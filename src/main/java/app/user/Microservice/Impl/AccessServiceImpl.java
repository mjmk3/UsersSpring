package app.user.Microservice.Impl;

import app.user.Microservice.Service.AccessService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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
public class AccessServiceImpl implements AccessService {
}
