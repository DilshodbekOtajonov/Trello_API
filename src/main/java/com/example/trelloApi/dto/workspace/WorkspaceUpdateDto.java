package com.example.trelloApi.dto.workspace;

import com.example.trelloApi.dto.base.GenericDto;
import com.example.trelloApi.enums.workspace.WorkspaceType;
import lombok.*;

import java.util.List;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/25/22 3:41 PM (Thursday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class WorkspaceUpdateDto extends GenericDto {
    private Long id;
    private String name;
    private WorkspaceType type;
    private String description;
}
