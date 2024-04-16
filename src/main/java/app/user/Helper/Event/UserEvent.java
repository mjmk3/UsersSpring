package app.user.Helper.Event;

import app.user.Entity.User.User;
import app.user.Helper.Enums.EventType;
import lombok.*;

import java.util.Map;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Getter
@Setter
@AllArgsConstructor
public class UserEvent {
    private User user;
    private EventType eventType;
    private Map<?, ?> data;
}
