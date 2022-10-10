package com.example.trelloApi.validators.board;

import com.example.trelloApi.domains.board.Board;
import com.example.trelloApi.domains.board.BoardColumn;
import com.example.trelloApi.dto.boardColumn.BoardColumnCreateDto;
import com.example.trelloApi.dto.boardColumn.BoardColumnOrderChangeDto;
import com.example.trelloApi.dto.boardColumn.BoardColumnUpdateDto;
import com.example.trelloApi.exceptions.GenericNotFoundException;
import com.example.trelloApi.exceptions.ValidationException;
import com.example.trelloApi.repository.board.BoardRepository;
import com.example.trelloApi.repository.boardColumn.BoardColumnRepository;
import com.example.trelloApi.validators.base.AbstractValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/25/22 2:35 PM (Thursday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */
@Component
@RequiredArgsConstructor
public class BoardColumnValidator extends AbstractValidator<BoardColumnCreateDto, BoardColumnUpdateDto, Long> {
    private final BoardValidator boardValidator;

    private final BoardRepository boardRepository;
    private final BoardColumnRepository boardColumnRepository;

    @Override
    public void validateKey(Long id) throws ValidationException {
        BoardColumn boardColumn = getBoardColumn(id);
        boardValidator.validateAccessiblity(boardColumn.getBoard());
    }

    protected BoardColumn getBoardColumn(Long id) {
        BoardColumn boardColumn = boardColumnRepository.findById(id).
                orElseThrow(() -> new GenericNotFoundException("Board column not found by id: %s".formatted(id)));
        if (boardColumn.getIsDeleted())
            throw new ValidationException("Board column not available with id: %s".formatted(id));
        return boardColumn;
    }

    @Override
    public void validOnCreate(BoardColumnCreateDto dto) throws ValidationException {
        String name = dto.getName();
        if (Objects.isNull(name) || name.isBlank()) {
            throw new ValidationException("Board column name can not be empty");
        }
        Board board = boardRepository.findById(dto.getBoardId())
                .orElseThrow(() -> new GenericNotFoundException("Board not found by id: %s".formatted(dto.getBoardId())));
        if (board.getIsDeleted())
            throw new ValidationException("Board not available");
        boardValidator.validateAccessiblity(board);

        int boardColumnsNumber = board.getBoardColumns().size();
        if (dto.getOrder() != (boardColumnsNumber + 1))
            throw new ValidationException("Order number don't matches sequence of board columns overall (%s) and order number: %s ".formatted(boardColumnsNumber, dto.getOrder()));
    }

    @Override
    public void validOnUpdate(BoardColumnUpdateDto dto) throws ValidationException {

    }

    public void validateOnChangeOrder(BoardColumnOrderChangeDto dto) {
        Long id = dto.getId();
        BoardColumn boardColumn = getBoardColumn(id);
        Board board = boardColumn.getBoard();
        boardValidator.validateAccessiblity(board);
        int boardColumnSize = board.getBoardColumns().size();
        if (dto.getOrder() < 1 || dto.getOrder() > boardColumnSize)
            throw new ValidationException("order number is not valid");

    }

    public void validateOnDelete(Long id) {
        BoardColumn boardColumn = getBoardColumn(id);
        boardValidator.validateAccessiblity(boardColumn.getBoard());
        boardValidator.checkMembership(boardColumn.getBoard());
    }


}
