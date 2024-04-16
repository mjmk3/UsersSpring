package app.user.Repo;

import app.user.Entity.User.Role;
import app.user.Helper.Enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    List<Role> findByRoleNameIn(List<String> roleNames);

    @Query("SELECT r FROM Role r WHERE LOWER(r.roleName) = LOWER(?1)")
    Optional<Role> findByRoleNameIgnoreCase(ERole roleName);
}
