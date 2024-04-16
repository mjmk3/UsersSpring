package app.user.Entity.User;

import app.user.Entity.Auditable;
import app.user.Helper.Enums.EPrivilege;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Entity
@Table(name = "priveleges")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
public class Privilege extends Auditable {

    @Enumerated(EnumType.STRING)
    private EPrivilege privilegeName;

    @JsonIgnore
    @ManyToMany(mappedBy = "privileges", fetch = FetchType.LAZY)
    private Collection<Role> roles = new ArrayList<>();

    public Privilege(String privilegeName) {
        this.privilegeName = EPrivilege.valueOf(privilegeName); // Assuming EPrivilege is an enum
    }
}
