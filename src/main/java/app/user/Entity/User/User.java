package app.user.Entity.User;

import app.user.Entity.Auditable;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;
import static jakarta.persistence.FetchType.*;

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
@JsonInclude(NON_DEFAULT)
public class User extends Auditable {

    @Column(unique = true, updatable = false, nullable = false)
    private String uuid;

    @Column(unique = true, nullable = false)
    private String phone;

    @Column(unique = true)
    private String email;
    private Integer loginAttempt;
    private LocalDateTime lastLoginTime;
    private String userImage;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean enabled;
    private boolean mfa;

    @JsonIgnore
    private String qrCodeSecret;

    @Column(columnDefinition = "text")
    private String qrCodeImage;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    private Credential credential;

    @OneToOne(mappedBy = "user")
    private Confirmation confirmation;
}
