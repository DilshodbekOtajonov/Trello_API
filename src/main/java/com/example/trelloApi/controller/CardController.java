package com.example.trelloApi.controller;

import com.example.trelloApi.dto.boardColumn.BoardColumnCreateDto;
import com.example.trelloApi.dto.boardColumn.BoardColumnDto;
import com.example.trelloApi.dto.card.CardAddMemberDto;
import com.example.trelloApi.dto.card.CardChangeColumnDto;
import com.example.trelloApi.dto.card.CardCreateDto;
import com.example.trelloApi.dto.card.CardDto;
import com.example.trelloApi.dto.comment.CommentCreateDto;
import com.example.trelloApi.dto.comment.CommentDto;
import com.example.trelloApi.service.card.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/25/22 3:17 PM (Thursday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
@PreAuthorize("isAuthenticated()")
public class CardController {
    private final CardService cardService;

    @PostMapping(value = "/create", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CardDto> createBoardColumn(@RequestBody CardCreateDto dto) {
        CardDto cardDto = cardService.save(dto);
        return new ResponseEntity<>(cardDto, HttpStatus.CREATED);
    }

    @PostMapping(value = "/addMember")
    public ResponseEntity<CardDto> addMember(@RequestBody CardAddMemberDto dto) {
        CardDto cardDto = cardService.addMember(dto);
        return new ResponseEntity<>(cardDto, HttpStatus.OK);
    }

    @PostMapping(value = "/comment/create")
    public ResponseEntity<CardDto> addComment(@RequestBody CommentCreateDto dto) {
        CardDto cardDto = cardService.addComment(dto);
        return new ResponseEntity<>(cardDto, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/changeColumn")
    public ResponseEntity<CardDto> changeColumn(@RequestBody CardChangeColumnDto dto) {
        CardDto cardDto = cardService.changeColumn(dto);
        return new ResponseEntity<>(cardDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
