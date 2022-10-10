package com.example.trelloApi.domains.board;

import com.example.trelloApi.domains.Comment;
import com.example.trelloApi.domains.auth.AuthUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    private String description;
    private LocalDateTime dueDate;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "card_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "auth_user_id", nullable = false))
    private final Set<AuthUser> members = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private final List<Comment> comments = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "column_id", referencedColumnName = "id", nullable = false)
    private BoardColumn boardColumn;

    @Builder.Default
    @Column(columnDefinition = "bool default false")
    private Boolean isDeleted = false;


}
