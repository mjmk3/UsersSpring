package app.user.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class User extends Auditable{

    @Column(unique = true, updatable = false, nullable = false)
    private String userId;

    @Column(unique = true, nullable = false)
    private String phone;

    @Column(unique = true)
    private String email;
    private String password;
    private Integer loginAttempt;
    private LocalDateTime lastLoginTime;
    private String userImage;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean enabled;
    private boolean mfa;

    @JsonIgnore
    private String qrCodeSecret;

    @Column(columnDefinition = "TEXT")
    private String qrCodeImage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Role role;
}
