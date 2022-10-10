package com.example.trelloApi.domains;

import com.example.trelloApi.domains.auth.AuthUser;
import com.example.trelloApi.domains.board.Card;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/25/22 8:51 AM (Thursday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = AuthUser.class)
    @JoinColumn(nullable = false, referencedColumnName = "id", name = "created_by")
    private AuthUser creator;
    @Column(nullable = false)
    private String text;
    private String attachment;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false, name = "card_id", referencedColumnName = "id")
    private Card card;
}
