package com.example.trelloApi.dto.board;

import com.example.trelloApi.domains.workspace.Workspace;
import com.example.trelloApi.dto.base.BaseGenericDto;
import com.example.trelloApi.enums.board.BoardVisibilityType;
import lombok.*;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/25/22 2:56 PM (Thursday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BoardCreateDto implements BaseGenericDto {
    private String name;
    @Builder.Default
    private BoardVisibilityType visibilityType = BoardVisibilityType.PUBLIC;
    private Long workspaceId;
}
