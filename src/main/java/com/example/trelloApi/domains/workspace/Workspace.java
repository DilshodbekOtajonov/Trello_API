package com.example.trelloApi.domains.workspace;

import com.example.trelloApi.domains.auth.AuthUser;
import com.example.trelloApi.domains.board.Board;
import com.example.trelloApi.enums.workspace.WorkspaceType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/25/22 8:49 AM (Thursday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, referencedColumnName = "id", name = "created_by")
    private AuthUser createdBy;

    @Enumerated(EnumType.STRING)
    private WorkspaceType type;

    private String description;

    @Builder.Default
    private Boolean isVisible = true;

    @Builder.Default
    @OneToMany(mappedBy = "workspace", fetch = FetchType.LAZY)
    private Set<Board> boards = new HashSet<>();

    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(joinColumns = @JoinColumn(name = "workspace_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<AuthUser> members = new HashSet<>();

    @Builder.Default
    @Column(columnDefinition = "bool default false")
    private Boolean isDeleted = false;
}
