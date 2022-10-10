package com.example.trelloApi.dto.boardColumn;

import com.example.trelloApi.dto.base.GenericDto;
import lombok.*;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/25/22 2:54 PM (Thursday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BoardColumnUpdateDto extends GenericDto {
    private Long id;
    private String name;
    private Integer order;
    private Long boardId;
}
