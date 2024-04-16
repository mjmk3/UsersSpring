package app.user.Microservice.Impl;

import app.user.Microservice.Service.UserService;
import app.user.Repo.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Service
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PrivilegeRepo privilegeRepo;
    private final CredentialRepo credentialRepo;
    private final ConfirmationRepo confirmationRepo;
    private BCryptPasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher publisher;
}
