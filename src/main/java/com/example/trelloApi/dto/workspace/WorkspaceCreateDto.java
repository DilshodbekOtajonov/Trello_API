package com.example.trelloApi.dto.workspace;

import com.example.trelloApi.domains.auth.AuthUser;
import com.example.trelloApi.dto.base.BaseGenericDto;
import com.example.trelloApi.enums.workspace.WorkspaceType;
import lombok.*;
/**
 * @author "Otajonov Dilshodbek
 * @since 8/25/22 3:39 PM (Thursday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class WorkspaceCreateDto implements BaseGenericDto {
    private String name;
    private Long userId;
    private WorkspaceType type;
    private String description;
}
