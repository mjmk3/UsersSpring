package app.user.Repo;

import app.user.Entity.User.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Repository
public interface CredentialRepo extends JpaRepository<Credential, Long> {
    Optional<Credential> getCredentialById(Long userId);
}
