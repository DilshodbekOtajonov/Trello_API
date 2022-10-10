package com.example.trelloApi.service.workspace;

import com.example.trelloApi.dto.workspace.WorkspaceMemberDto;
import com.example.trelloApi.dto.workspace.WorkspaceChangeVisibilityDto;
import com.example.trelloApi.dto.workspace.WorkspaceCreateDto;
import com.example.trelloApi.dto.workspace.WorkspaceDto;

import java.util.List;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/25/22 3:52 PM (Thursday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */


public interface WorkspaceService {
    WorkspaceDto save(WorkspaceCreateDto workspaceCreateDto);

    WorkspaceDto get(Long id) throws IllegalAccessException;

    void addMember(WorkspaceMemberDto dto);

    List<WorkspaceDto> getAll();

    void changeVisibility(WorkspaceChangeVisibilityDto dto);

    void removeMember(WorkspaceMemberDto dto);
}
