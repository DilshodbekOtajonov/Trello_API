package com.example.trelloApi.service.boardColumn;

import com.example.trelloApi.dto.boardColumn.BoardColumnCreateDto;
import com.example.trelloApi.dto.boardColumn.BoardColumnDto;
import com.example.trelloApi.dto.boardColumn.BoardColumnOrderChangeDto;

/**
 * @author "Otajonov Dilshodbek
 * @since 9/2/22 10:54 AM (Friday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */
public interface BoardColumnService {
    BoardColumnDto save(BoardColumnCreateDto dto);

    BoardColumnDto changeOrder(BoardColumnOrderChangeDto dto);

    void deleteColumn(Long id);
}
