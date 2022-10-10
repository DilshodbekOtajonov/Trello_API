package com.example.trelloApi.dto.board;

import com.example.trelloApi.domains.board.BoardColumn;
import com.example.trelloApi.domains.workspace.Workspace;
import com.example.trelloApi.dto.boardColumn.BoardColumnDto;
import com.example.trelloApi.enums.board.BoardVisibilityType;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/31/22 3:31 PM (Wednesday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {
    private Long id;
    private String name;
    private BoardVisibilityType visibilityType;
    private Long workspaceId;
    private Set<BoardColumnDto> boardColumns;
}
