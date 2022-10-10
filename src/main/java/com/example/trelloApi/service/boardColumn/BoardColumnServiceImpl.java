package com.example.trelloApi.service.boardColumn;

import com.example.trelloApi.domains.board.Board;
import com.example.trelloApi.domains.board.BoardColumn;
import com.example.trelloApi.dto.boardColumn.BoardColumnCreateDto;
import com.example.trelloApi.dto.boardColumn.BoardColumnDto;
import com.example.trelloApi.dto.boardColumn.BoardColumnOrderChangeDto;
import com.example.trelloApi.exceptions.GenericNotFoundException;
import com.example.trelloApi.mappers.board.BoardColumnMapper;
import com.example.trelloApi.repository.board.BoardRepository;
import com.example.trelloApi.repository.boardColumn.BoardColumnRepository;
import com.example.trelloApi.validators.board.BoardColumnValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author "Otajonov Dilshodbek
 * @since 9/2/22 10:55 AM (Friday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */
@Service
@Transactional
@RequiredArgsConstructor
public class BoardColumnServiceImpl implements BoardColumnService {
    private final BoardColumnRepository boardColumnRepository;
    private final BoardColumnValidator boardColumnValidator;
    private final BoardRepository boardRepository;
    private final BoardColumnMapper boardColumnMapper;

    @Override
    public BoardColumnDto save(BoardColumnCreateDto dto) {
        boardColumnValidator.validOnCreate(dto);
        BoardColumn boardColumn = boardColumnMapper.fromCreateDto(dto);
        Board board = boardRepository.findById(dto.getBoardId())
                .orElseThrow(() -> new GenericNotFoundException("board not found by id: %s".formatted(dto.getBoardId())));
        boardColumn.setBoard(board);
        return boardColumnMapper.fromBoardColumn(boardColumnRepository.save(boardColumn));
    }

    @Override
    public BoardColumnDto changeOrder(BoardColumnOrderChangeDto dto) {
        boardColumnValidator.validateOnChangeOrder(dto);
        BoardColumn boardColumn = boardColumnRepository.findById(dto.getId())
                .orElseThrow(() -> new GenericNotFoundException(
                        "Board column not found by id: " + dto.getId()
                ));
        boardColumn.getBoard().getBoardColumns().stream()
                .filter(bc -> bc.getOrder() >= dto.getOrder())
                .forEach(nbc -> nbc.setOrder(nbc.getOrder() + 1));
        boardColumn.setOrder(dto.getOrder());
        return boardColumnMapper.fromBoardColumn(boardColumnRepository.save(boardColumn));
    }


    @Override
    public void deleteColumn(Long id) {
        boardColumnValidator.validateOnDelete(id);
        BoardColumn boardColumn = boardColumnRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException(
                        "Board column not found by id: " + id
                ));
        Set<BoardColumn> boardColumns = boardColumn.getBoard()
                .getBoardColumns();
        boardColumns.stream()
                .filter(bc -> bc.getOrder() > boardColumn.getOrder())
                .forEach(nbc -> nbc.setOrder(nbc.getOrder() - 1));
        boardColumns.remove(boardColumn);
        boardColumn.setIsDeleted(true);
        boardColumnRepository.save(boardColumn);
    }
}
