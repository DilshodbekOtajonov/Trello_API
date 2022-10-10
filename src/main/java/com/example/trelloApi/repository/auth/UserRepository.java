package com.example.trelloApi.repository.auth;

import com.example.trelloApi.domains.auth.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 10:28 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */

@Repository
public interface UserRepository extends JpaRepository<AuthUser, Long> {

    Optional<AuthUser> findByEmail(String email);
}
