package app.user.Repo;

import app.user.Entity.User.Privilege;
import app.user.Helper.Enums.EPrivilege;
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
public interface PrivilegeRepo extends JpaRepository<Privilege, Long> {
    List<Privilege> findByPrivilegeNameIn(List<String> privilegeNames);

    @Query("SELECT p FROM Privilege p WHERE LOWER(p.privilegeName) = LOWER(?1)")
    Optional<Privilege> findByPrivilegeNameIgnoreCase(EPrivilege privilegeName);
}
