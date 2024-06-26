package app.user.Entity;

import app.user.Helper.Exception.EntityIDException;
import app.user.Model.RequestContext;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.*;

/**
 * @author MJ Makki
 * @version 1.0
 * @license SkyLimits, LLC (<a href="https://www.skylimits.tech">SkyLimits, LLC</a>)
 * @email m.makki@skylimits.tech
 * @since long time ago
 */

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public abstract class Auditable {
    @NotNull
    private Long createdBy;

    @NotNull
    private Long updatedBy;

    @NotNull
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @NotNull
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @PrePersist
    public void beforePersist() {
        var userId = RequestContext.getUserId();
        if (userId == null) {
            throw new EntityIDException("Can't persist entity without user ID in request context for this thread");
        }
        setCreatedAt(now());
        setCreatedBy(userId);
        setUpdatedAt(now());
        setUpdatedBy(userId);
    }

    @PreUpdate
    public void beforeUpdate() {
        var userId = RequestContext.getUserId();
        if (userId == null) {
            throw new EntityIDException("Can't update entity without user ID in request context for this thread");
        }
        setUpdatedAt(now());
        setUpdatedBy(userId);
    }
}
