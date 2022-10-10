package com.example.trelloApi.dto.boardColumn;

import lombok.*;

/**
 * @author "Otajonov Dilshodbek
 * @since 9/4/22 4:52 PM (Sunday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BoardColumnOrderChangeDto {
    private Long id;
    private Integer order;
}
