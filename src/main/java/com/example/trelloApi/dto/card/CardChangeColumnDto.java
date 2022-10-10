package com.example.trelloApi.dto.card;

import lombok.*;

/**
 * @author "Otajonov Dilshodbek
 * @since 9/5/22 10:47 AM (Monday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardChangeColumnDto {
    private Long id;
    private Long boardColumnId;
}
