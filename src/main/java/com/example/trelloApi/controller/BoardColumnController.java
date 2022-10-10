package com.example.trelloApi.controller;

import com.example.trelloApi.dto.boardColumn.BoardColumnCreateDto;
import com.example.trelloApi.dto.boardColumn.BoardColumnDto;
import com.example.trelloApi.dto.boardColumn.BoardColumnOrderChangeDto;
import com.example.trelloApi.service.boardColumn.BoardColumnService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

/**
 * @author "Otajonov Dilshodbek
 * @since 9/2/22 10:52 AM (Friday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@RestController
@RequestMapping("/boardColumn")
@RequiredArgsConstructor
public class BoardColumnController {

    private final BoardColumnService boardColumnService;

    @PostMapping(value = "/create", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BoardColumnDto> createBoardColumn(@RequestBody BoardColumnCreateDto dto) {
        BoardColumnDto boardColumnDto = boardColumnService.save(dto);
        return new ResponseEntity<>(boardColumnDto, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/changeOrder", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BoardColumnDto> changeOrder(@RequestBody BoardColumnOrderChangeDto dto) {
        BoardColumnDto boardColumnDto = boardColumnService.changeOrder(dto);
        return new ResponseEntity<>(boardColumnDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteColumn/{id}")
    public ResponseEntity deleteColumn(@PathVariable Long id) {
        boardColumnService.deleteColumn(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
