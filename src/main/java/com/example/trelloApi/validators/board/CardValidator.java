package com.example.trelloApi.validators.board;

import com.example.trelloApi.domains.auth.AuthUser;
import com.example.trelloApi.domains.board.Board;
import com.example.trelloApi.domains.board.BoardColumn;
import com.example.trelloApi.domains.board.Card;
import com.example.trelloApi.domains.workspace.Workspace;
import com.example.trelloApi.dto.card.CardAddMemberDto;
import com.example.trelloApi.dto.card.CardChangeColumnDto;
import com.example.trelloApi.dto.card.CardCreateDto;
import com.example.trelloApi.dto.card.CardUpdateDto;
import com.example.trelloApi.dto.comment.CommentCreateDto;
import com.example.trelloApi.exceptions.GenericNotFoundException;
import com.example.trelloApi.exceptions.ValidationException;
import com.example.trelloApi.repository.auth.UserRepository;
import com.example.trelloApi.repository.card.CardRepository;
import com.example.trelloApi.validators.base.AbstractValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/25/22 2:36 PM (Thursday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@Component
@RequiredArgsConstructor
public class CardValidator extends AbstractValidator<CardCreateDto, CardUpdateDto, Long> {
    private final BoardColumnValidator boardColumnValidator;
    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    @Override
    public void validateKey(Long id) throws ValidationException {
        Card card = getCard(id);
        boardColumnValidator.validateKey(card.getBoardColumn().getId());
    }

    private Card getCard(Long id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException("Card not found by id: %s".formatted(id)));
        if (card.getIsDeleted())
            throw new ValidationException("Card is not available with id: %s".formatted(id));
        return card;
    }

    @Override
    public void validOnCreate(CardCreateDto dto) throws ValidationException {
        boardColumnValidator.validateKey(dto.getBoardColumnId());
        String name = dto.getName();
        if (Objects.isNull(name) || name.isBlank())
            throw new ValidationException("Name can not be empty");

    }

    @Override
    public void validOnUpdate(CardUpdateDto dto) throws ValidationException {

    }

    public void validateOnAddMember(CardAddMemberDto dto) {
        validateKey(dto.getId());
        AuthUser user = userRepository.findByEmail(dto.getMemberEmail())
                .orElseThrow(() -> new GenericNotFoundException("user not found by email: " + dto.getMemberEmail()));
        Workspace workspaceByCard = cardRepository.findWorkspaceByCard(dto.getId());
        if (!workspaceByCard.getMembers().contains(user))
            throw new ValidationException("You can't add member outside your workspace");
    }

    public void validateOnAddComment(CommentCreateDto dto) {
        validateKey(dto.getCardId());
        String text = dto.getText();
        if (Objects.isNull(text) || text.isBlank())
            throw new ValidationException(
                    "Comment text can not be empty"
            );
    }


    public void validateOnChangeColumn(CardChangeColumnDto dto) {
        validateKey(dto.getId());
        Card card = getCard(dto.getId());
        Board board = card.getBoardColumn().getBoard();
        Long boardColumnId = dto.getBoardColumnId();
        BoardColumn boardColumn = boardColumnValidator.getBoardColumn(boardColumnId);
        boolean isColumnFromSameBoard = board.getBoardColumns().contains(boardColumn);
        if (!isColumnFromSameBoard) {
            throw new ValidationException(
                    "Board not contains column with id: " + boardColumnId
            );
        }
    }

    public void validateOnDelete(Long id) {
        Card card = getCard(id);
        boardColumnValidator.validateOnDelete(card.getBoardColumn().getId());
    }
}
