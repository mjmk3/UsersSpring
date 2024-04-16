package app.user.Entity.User;

import app.user.Entity.Auditable;
import app.user.Helper.Enums.ERole;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static jakarta.persistence.FetchType.*;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class Role extends Auditable {

    @Enumerated(EnumType.STRING)
    private ERole roleName;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles", fetch = LAZY)
    private Collection<User> users = new ArrayList<>();

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "role_privileges",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges = new ArrayList<>();

    public Role(String roleName) {
        this.roleName = ERole.valueOf(roleName); // Assuming ERole is an enum
    }
}
