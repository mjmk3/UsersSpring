package app.user.Utility.Listener;

import app.user.Helper.Event.UserEvent;
import app.user.Helper.HelperUtils.ServiceUtils.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Component
@RequiredArgsConstructor
public class UserEventListener {
    private final EmailService emailService;

    @EventListener
    public void onUserEvent(UserEvent userEvent) {
        switch (userEvent.getEventType()) {
            case REGISTRATION -> emailService.sendNewAccountEmail(userEvent.getUser().getPhone(), userEvent.getUser().getEmail(), (String)userEvent.getData().get("key"));
            case RESET -> emailService.sendPasswordResetEmail(userEvent.getUser().getPhone(), userEvent.getUser().getEmail(), (String)userEvent.getData().get("key"));
            default -> {}
        }
    }
}
