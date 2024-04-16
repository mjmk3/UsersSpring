package app.user.Helper.HelperUtils;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

public class EmailUtils {
    public static String getEmailMessage(String name, String host, String token) {
        return "Hello " + name + ",\n\n Your account has been created, Pleas click the link below to confirm your account.\n\n"
                + getVerificationUrl(host, token) + ",\n\n The Technical Support Team";
    }

    public static String getResetPasswordMessage(String name, String host, String token) {
        return "Hello " + name + ",\n\n Reset password has been sent, Pleas click the link below to reset your password.\n\n"
                + getResetPasswordUrl(host, token) + ",\n\n The Technical Support Team";
    }

    private static String getVerificationUrl(String host, String token) {
        return host + "/verify/account?token" + token;
    }

    private static String getResetPasswordUrl(String host, String token) {
        return host + "/reset/password?token" + token;
    }
}
