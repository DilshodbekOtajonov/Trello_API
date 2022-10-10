package com.example.trelloApi.dto.card;

import com.example.trelloApi.dto.auth.UserDto;
import com.example.trelloApi.dto.comment.CommentDto;
import lombok.*;

import java.util.List;
import java.util.Set;

/**
 * @author "Otajonov Dilshodbek
 * @since 9/2/22 3:33 PM (Friday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardDto {
    private Long id;
    private String name;
    private Set<UserDto> members;
    //    private final List<Comment> comments = new ArrayList<>();
    private Long boardColumnId;
    private List<CommentDto> comments;
}
