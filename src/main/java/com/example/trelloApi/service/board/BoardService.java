package com.example.trelloApi.service.board;

import com.example.trelloApi.dto.board.BoardChangeVisibilityDto;
import com.example.trelloApi.dto.board.BoardCreateDto;
import com.example.trelloApi.dto.board.BoardDto;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/31/22 3:29 PM (Wednesday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */
public interface BoardService {
    BoardDto save(BoardCreateDto dto);

    BoardDto get(Long id);

    void changeVisibility(BoardChangeVisibilityDto dto);

    void deleteBoard(Long id);
}
