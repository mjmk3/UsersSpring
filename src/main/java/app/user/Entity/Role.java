package app.user.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

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
public class Role extends Auditable{
    private String roleName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_privileges",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id")
    )
    private Privilege privilege;
}
