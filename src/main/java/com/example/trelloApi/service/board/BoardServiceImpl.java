package com.example.trelloApi.service.board;

import com.example.trelloApi.domains.board.Board;
import com.example.trelloApi.domains.workspace.Workspace;
import com.example.trelloApi.dto.board.BoardChangeVisibilityDto;
import com.example.trelloApi.dto.board.BoardCreateDto;
import com.example.trelloApi.dto.board.BoardDto;
import com.example.trelloApi.exceptions.GenericNotFoundException;
import com.example.trelloApi.mappers.board.BoardMapper;
import com.example.trelloApi.repository.board.BoardRepository;
import com.example.trelloApi.repository.workspace.WorkspaceRepository;
import com.example.trelloApi.validators.board.BoardValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author "Otajonov Dilshodbek
 * @since 8/31/22 3:29 PM (Wednesday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardValidator boardValidator;
    private final BoardRepository boardRepository;
    private final WorkspaceRepository workspaceRepository;
    private final BoardMapper boardMapper;

    @Override
    public BoardDto save(BoardCreateDto dto) {
        boardValidator.validOnCreate(dto);
        Board board = boardMapper.fromCreateDto(dto);
        Workspace workspace = workspaceRepository.findById(dto.getWorkspaceId())
                .orElseThrow(() -> new GenericNotFoundException("Workspace not found"));
        board.setWorkspace(workspace);
        Board savedBoard = boardRepository.save(board);
        return boardMapper.fromBoard(savedBoard);
    }

    @Override
    public BoardDto get(Long id) {
        boardValidator.validateKey(id);
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException("Board not found by id : %s".formatted(id)));
        return boardMapper.fromBoard(board);
    }

    @Override
    public void changeVisibility(BoardChangeVisibilityDto dto) {
        boardValidator.validateOnChangeVisibility(dto);
        Board board = boardRepository.findById(dto.getId())
                .orElseThrow(() -> new GenericNotFoundException("Board not found by id : %s".formatted(dto.getId())));

        board.setVisibilityType(dto.getVisibility());
        boardRepository.save(board);
    }

    @Override
    public void deleteBoard(Long id) {
        boardValidator.validateOnDelete(id);
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException(
                        "Board not found by id : %s".formatted(id))
                );

        board.setIsDeleted(true);
        boardRepository.save(board);
    }
}
