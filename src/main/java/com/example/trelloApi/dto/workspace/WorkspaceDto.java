package com.example.trelloApi.dto.workspace;

import com.example.trelloApi.domains.auth.AuthUser;
import com.example.trelloApi.domains.board.Board;
import com.example.trelloApi.dto.auth.UserDto;
import com.example.trelloApi.dto.board.BoardDto;
import com.example.trelloApi.enums.workspace.WorkspaceType;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/25/22 8:00 PM (Thursday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkspaceDto {
    private Long id;
    private String name;
    private Long createdBy;
    private WorkspaceType type;
    private String description;
    private Boolean isVisible;
    private Set<BoardDto> boards;
    private Set<UserDto> members;
}
