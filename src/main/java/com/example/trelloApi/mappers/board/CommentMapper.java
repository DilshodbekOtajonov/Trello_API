package com.example.trelloApi.mappers.board;

import com.example.trelloApi.domains.Comment;
import com.example.trelloApi.dto.comment.CommentCreateDto;
import com.example.trelloApi.dto.comment.CommentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author "Otajonov Dilshodbek
 * @since 9/3/22 10:01 PM (Saturday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment fromCreateDto(CommentCreateDto dto);

    @Mapping(target = "creator", source = "creator.email")
    @Mapping(target = "cardId", source = "card.id")
    CommentDto fromComment(Comment comment);
}
