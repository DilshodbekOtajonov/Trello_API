package com.example.trelloApi.service.card;

import com.example.trelloApi.dto.card.CardAddMemberDto;
import com.example.trelloApi.dto.card.CardChangeColumnDto;
import com.example.trelloApi.dto.card.CardCreateDto;
import com.example.trelloApi.dto.card.CardDto;
import com.example.trelloApi.dto.comment.CommentCreateDto;

/**
 * @author "Otajonov Dilshodbek
 * @since 9/3/22 10:12 AM (Saturday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */
public interface CardService {
    CardDto save(CardCreateDto dto);

    CardDto addMember(CardAddMemberDto dto);

    CardDto addComment(CommentCreateDto dto);

    CardDto changeColumn(CardChangeColumnDto dto);

    void deleteCard(Long id);
}
