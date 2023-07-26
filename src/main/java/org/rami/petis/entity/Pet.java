package org.rami.petis.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.rami.petis.base.AbstractEntity;
import org.rami.petis.base.PetType;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "ps_pet")
public class Pet extends AbstractEntity {
    @Id
    @SequenceGenerator(
            name = "seq_pet_id",
            sequenceName = "seq_pet_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_pet_id"
    )
    @Column(name = "pet_id",updatable = false)
    private Long id;
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private PetType petType;
    @Size(max = 100)
    private String name;
    @Size(max = 500)
    private String details;
    @NotEmpty
    @Size(min = 10, max = 100)
    private String rfid;
    @ManyToOne
    @JoinColumn(
            name = "owner_id",
            referencedColumnName = "user_id",
            nullable = false)
    private User owner;

    public Pet() {
        super();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id) && petType == pet.petType && Objects.equals(name, pet.name) && Objects.equals(rfid, pet.rfid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, petType, name, rfid);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
