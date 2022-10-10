package com.example.trelloApi.domains.auth;

import com.example.trelloApi.domains.workspace.Workspace;
import com.example.trelloApi.enums.auth.UserStatus;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 10:03 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<AuthRole> roles = new HashSet<>();

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.ACTIVE;

    @Builder.Default
    private Boolean isActive = true;

    @OneToMany(mappedBy ="createdBy",fetch = FetchType.LAZY)
    private Set<Workspace> workspaces = new HashSet<>();

}
