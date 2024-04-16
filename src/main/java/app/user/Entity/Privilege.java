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
@Table(name = "priveleges")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class Privilege extends Auditable {
    private String privilegeName;
}
