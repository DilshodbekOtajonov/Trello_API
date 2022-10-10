package com.example.trelloApi.dto.auth;

import com.example.trelloApi.domains.auth.AuthRole;
import com.example.trelloApi.dto.base.GenericDto;
import com.example.trelloApi.enums.auth.UserStatus;
import lombok.*;

import java.util.Set;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 12:16 PM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDto extends GenericDto {
    private String email;
    private Set<AuthRole> roles;
    private UserStatus status;
    private Boolean isActive;

    @Builder(builderMethodName = "childBuilder")
    public UserDto(Long id, String email, Set<AuthRole> roles, UserStatus status, Boolean isActive) {
        super(id);
        this.email = email;
        this.roles = roles;
        this.status = status;
        this.isActive = isActive;
    }
}
