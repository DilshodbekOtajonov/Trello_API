package com.example.trelloApi;

import com.example.trelloApi.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor
class TrelloApiApplicationTests {
    private final BoardRepository repository;

    @Test
    void contextLoads() {
    }
}
