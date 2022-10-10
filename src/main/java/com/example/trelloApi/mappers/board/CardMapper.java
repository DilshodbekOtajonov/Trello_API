package com.example.trelloApi.mappers.board;

import com.example.trelloApi.domains.board.Card;
import com.example.trelloApi.dto.card.CardCreateDto;
import com.example.trelloApi.dto.card.CardDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author "Otajonov Dilshodbek
 * @since 9/2/22 6:36 PM (Friday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@Mapper(componentModel = "spring", uses = {CommentMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CardMapper {
    @Mapping(target = "boardColumnId", source = "boardColumn.id")
    CardDto fromCard(Card card);


    Card fromCreateDto(CardCreateDto dto);
}
