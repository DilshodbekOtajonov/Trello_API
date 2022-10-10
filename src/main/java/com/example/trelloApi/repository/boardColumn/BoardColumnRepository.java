package com.example.trelloApi.repository.boardColumn;

import com.example.trelloApi.domains.board.BoardColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author "Otajonov Dilshodbek
 * @since 9/2/22 11:15 AM (Friday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@Repository
public interface BoardColumnRepository extends JpaRepository<BoardColumn, Long> {
}
