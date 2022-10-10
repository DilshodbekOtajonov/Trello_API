package com.example.trelloApi.repository.board;

import com.example.trelloApi.domains.board.Board;
import com.example.trelloApi.dto.board.BoardDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/31/22 3:59 PM (Wednesday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

//    @Query("select t.id,t.name,t.visibilityType,t.workspace.id from Board t where t.id=1l")
//    Optional<BoardDto> getBoardDto();
//    @Query("select t from Board t inner join t.boardColumns d where d.isDeleted=false")
//    Optional<Board> findById(Long id);
}
