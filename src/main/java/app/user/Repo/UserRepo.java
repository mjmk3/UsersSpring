package app.user.Repo;

import app.user.Entity.User.User;
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
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByPhoneIgnoreCase(String phone);
    Optional<User> findByEmailIgnoreCase(String email);
    Optional<User> findByUserId(String userId);
}
