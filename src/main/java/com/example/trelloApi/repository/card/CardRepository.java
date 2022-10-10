package com.example.trelloApi.repository.card;

import com.example.trelloApi.domains.board.Card;
import com.example.trelloApi.domains.workspace.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author "Otajonov Dilshodbek
 * @since 9/3/22 10:13 AM (Saturday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("select w from Card c join c.boardColumn t join t.board b join b.workspace w where c.id=:cardId")
    Workspace findWorkspaceByCard(Long cardId);
}
