package com.example.trelloApi.dto.board;

import com.example.trelloApi.enums.board.BoardVisibilityType;
import lombok.*;

/**
 * @author "Otajonov Dilshodbek
 * @since 9/4/22 3:57 PM (Sunday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BoardChangeVisibilityDto {
    private Long id;
    private BoardVisibilityType visibility;
}
