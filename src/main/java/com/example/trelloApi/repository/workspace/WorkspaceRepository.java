package com.example.trelloApi.repository.workspace;

import com.example.trelloApi.domains.auth.AuthUser;
import com.example.trelloApi.domains.workspace.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/26/22 8:20 AM (Friday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
    @Query(value = "select t from Workspace t where (t.createdBy =:user or :user member of t.members) and t.isDeleted=false")
    List<Workspace> findAllByUser(AuthUser user);
}
