package com.example.trelloApi.controller;

import com.example.trelloApi.dto.workspace.WorkspaceMemberDto;
import com.example.trelloApi.dto.workspace.WorkspaceChangeVisibilityDto;
import com.example.trelloApi.dto.workspace.WorkspaceCreateDto;
import com.example.trelloApi.dto.workspace.WorkspaceDto;
import com.example.trelloApi.service.workspace.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/25/22 3:17 PM (Thursday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/workspace")
@PreAuthorize("isAuthenticated()")
public class WorkspaceController {
    private final WorkspaceService workspaceService;

    @PostMapping(value = "/create", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<WorkspaceDto> createWorkspace(@Valid @RequestBody WorkspaceCreateDto workspaceCreateDto) {
        WorkspaceDto workspaceDto = workspaceService.save(workspaceCreateDto);
        return new ResponseEntity<>(workspaceDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WorkspaceDto>> getAll() {
        List<WorkspaceDto> workspaceDtos = workspaceService.getAll();
        return new ResponseEntity<>(workspaceDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<WorkspaceDto> getWorkspace(@PathVariable Long id) throws IllegalAccessException {
        WorkspaceDto workspaceDto = workspaceService.get(id);
        return new ResponseEntity<>(workspaceDto, HttpStatus.OK);
    }

    @PatchMapping(value = "/addMember")
    public ResponseEntity<Void> addMember(@Valid @RequestBody WorkspaceMemberDto dto) {
        workspaceService.addMember(dto);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/removeMember")
    public ResponseEntity removeMember(@Valid @RequestBody WorkspaceMemberDto dto) {
        workspaceService.removeMember(dto);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/changeVisibility")
    public ResponseEntity changeVisibility(@Valid @RequestBody WorkspaceChangeVisibilityDto dto) {
        workspaceService.changeVisibility(dto);
        return ResponseEntity.noContent().build();
    }
}
