package com.example.trelloApi.mappers.workspace;

import com.example.trelloApi.domains.workspace.Workspace;
import com.example.trelloApi.dto.workspace.WorkspaceMemberDto;
import com.example.trelloApi.dto.workspace.WorkspaceCreateDto;
import com.example.trelloApi.dto.workspace.WorkspaceDto;
import com.example.trelloApi.dto.workspace.WorkspaceUpdateDto;
import com.example.trelloApi.mappers.auth.UserMapper;
import com.example.trelloApi.mappers.board.BoardMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/25/22 8:04 PM (Thursday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@Mapper(componentModel = "spring", uses = {BoardMapper.class, UserMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface WorkspaceMapper {
    Workspace fromWorkspaceCreateDto(WorkspaceCreateDto workspaceCreateDto);


    @Mapping(target = "createdBy", source = "createdBy.id")
    WorkspaceDto fromWorkspace(Workspace workspace);

    WorkspaceUpdateDto fromAddMemberToUpdate(WorkspaceMemberDto dto);
}
