package base;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Abstract entity
 */
@MappedSuperclass
public class AbstractEntity implements Serializable {
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name ="modified_at")
    private LocalDate modifiedAt;

    public AbstractEntity() {
        createdAt = LocalDate.now();
        modifiedAt= LocalDate.now();
    }


    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDate modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
