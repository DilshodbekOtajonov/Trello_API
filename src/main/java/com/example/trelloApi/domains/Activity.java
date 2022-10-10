package com.example.trelloApi.domains;

import com.example.trelloApi.domains.auth.AuthUser;
import com.example.trelloApi.domains.board.Board;
import lombok.*;

import javax.persistence.*;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/25/22 12:13 PM (Thursday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private AuthUser user;
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;
    private String description;
}
