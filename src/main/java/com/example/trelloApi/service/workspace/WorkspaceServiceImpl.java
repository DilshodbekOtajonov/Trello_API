package com.example.trelloApi.service.workspace;

import com.example.trelloApi.configs.security.UserDetails;
import com.example.trelloApi.domains.auth.AuthUser;
import com.example.trelloApi.domains.workspace.Workspace;
import com.example.trelloApi.dto.workspace.WorkspaceMemberDto;
import com.example.trelloApi.dto.workspace.WorkspaceChangeVisibilityDto;
import com.example.trelloApi.dto.workspace.WorkspaceCreateDto;
import com.example.trelloApi.dto.workspace.WorkspaceDto;
import com.example.trelloApi.exceptions.GenericNotFoundException;
import com.example.trelloApi.mappers.workspace.WorkspaceMapper;
import com.example.trelloApi.repository.auth.UserRepository;
import com.example.trelloApi.repository.workspace.WorkspaceRepository;
import com.example.trelloApi.validators.workspace.WorkspaceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/25/22 3:52 PM (Thursday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@Service
@Transactional
@RequiredArgsConstructor
public class WorkspaceServiceImpl implements WorkspaceService {
    private final WorkspaceValidator workspaceValidator;
    private final WorkspaceMapper workspaceMapper;
    private final WorkspaceRepository workspaceRepository;
    private final UserRepository userRepository;

    @Override
    public WorkspaceDto get(Long id) throws IllegalAccessException {
        UserDetails userDetails = getUserDetails();
        Workspace workspace = workspaceRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException("workspace not found by id: %s".formatted(id)));
        boolean isNotCreator = !workspace.getCreatedBy().getId().equals(userDetails.getId());
        boolean isNotMember = !workspace.getMembers().contains(userDetails.authUser());
        if (isNotCreator && isNotMember) {
            throw new IllegalAccessException("You do not have permission to get workspace with id %s".formatted(id));
        }
        return workspaceMapper.fromWorkspace(workspace);
    }

    private UserDetails getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetails) authentication.getPrincipal();
    }

    @Override
    public WorkspaceDto save(WorkspaceCreateDto workspaceCreateDto) {
        workspaceValidator.validOnCreate(workspaceCreateDto);
        AuthUser authUser = userRepository.findById(workspaceCreateDto.getUserId()).get();
        Workspace workspace = workspaceMapper.fromWorkspaceCreateDto(workspaceCreateDto);
        workspace.setCreatedBy(authUser);
        return workspaceMapper.fromWorkspace(workspaceRepository.save(workspace));

    }

    @Override
    public void addMember(WorkspaceMemberDto dto) {
        workspaceValidator.validOnAddMember(dto);
        String userEmail = dto.getMemberEmail();
        Workspace workspace = workspaceRepository.findById(dto.getId()).get();
        AuthUser authUser = userRepository.findByEmail(userEmail).get();
        workspace.getMembers().add(authUser);
        workspaceRepository.save(workspace);
    }

    @Override
    public void removeMember(WorkspaceMemberDto dto) {
        workspaceValidator.validateOnRemoveMember(dto);
        Workspace workspace = workspaceRepository.findById(dto.getId())
                .orElseThrow(() -> new GenericNotFoundException("workspace not found by id: %s".formatted(dto.getId())));
        AuthUser authUser = userRepository.findByEmail(dto.getMemberEmail())
                .orElseThrow(() -> new GenericNotFoundException("User not found by email: " + dto.getMemberEmail()));
        workspace.getMembers().remove(authUser);
        workspaceRepository.save(workspace);
    }

    @Override
    public void changeVisibility(WorkspaceChangeVisibilityDto dto) {
        workspaceValidator.validateOnChangeVisibility(dto);
        Workspace workspace = workspaceRepository.findById(dto.getId())
                .orElseThrow(() -> new GenericNotFoundException("workspace not found by id: %s".formatted(dto.getId())));
        workspace.setIsVisible(dto.getVisibility());
        workspaceRepository.save(workspace);
    }

    @Override
    public List<WorkspaceDto> getAll() {
        UserDetails userDetails = getUserDetails();
        List<Workspace> workspaces = workspaceRepository.findAllByUser(userDetails.authUser());
        List<WorkspaceDto> result = new ArrayList<>();
        for (Workspace workspace : workspaces) {
            WorkspaceDto workspaceDto = workspaceMapper.fromWorkspace(workspace);
            result.add(workspaceDto);
        }
        return result;
    }
}
