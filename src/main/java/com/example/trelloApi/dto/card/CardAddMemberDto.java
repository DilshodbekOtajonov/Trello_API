package com.example.trelloApi.dto.card;

import lombok.*;

/**
 * @author "Otajonov Dilshodbek
 * @since 9/3/22 7:12 PM (Saturday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardAddMemberDto {
    private Long id;
    private String memberEmail;
}
