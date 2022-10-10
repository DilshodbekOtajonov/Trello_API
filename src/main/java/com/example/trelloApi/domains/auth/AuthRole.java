package com.example.trelloApi.domains.auth;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 10:15 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class AuthRole implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "role_permission",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id")
    )
    private Set<AuthPermission> permissions;

    @Override
    public String getAuthority() {
        return "ROLE_" + this.code;
    }
}
