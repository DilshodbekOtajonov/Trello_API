package com.example.trelloApi.dto.comment;

import lombok.*;

/**
 * @author "Otajonov Dilshodbek
 * @since 9/3/22 9:42 PM (Saturday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentCreateDto {
    private String creatorEmail;
    private String text;
    private String attachment;
    private Long cardId;
}
