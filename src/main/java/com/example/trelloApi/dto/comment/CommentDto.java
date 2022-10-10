package com.example.trelloApi.dto.comment;

import com.example.trelloApi.domains.auth.AuthUser;
import com.example.trelloApi.domains.board.Card;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

/**
 * @author "Otajonov Dilshodbek
 * @since 9/3/22 5:01 PM (Saturday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {
    private Long id;
    private String creator;
    private String text;
    private String attachment;
    private Long cardId;
}
