package com.example.trelloApi.mappers.board;

import com.example.trelloApi.domains.board.BoardColumn;
import com.example.trelloApi.dto.boardColumn.BoardColumnCreateDto;
import com.example.trelloApi.dto.boardColumn.BoardColumnDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author "Otajonov Dilshodbek
 * @since 9/2/22 11:16 AM (Friday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@Mapper(componentModel = "spring",
        uses = {CardMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BoardColumnMapper {
    BoardColumn fromCreateDto(BoardColumnCreateDto dto);

    @Mapping(target = "boardId", source = "board.id")
    BoardColumnDto fromBoardColumn(BoardColumn boardColumn);
}
