package fabiocarlino.meeting_management.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Emplacement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private EmplacementType emplacementTypeType;

    @Column
    private int maxSeat;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EmplacementType getEmplacementTypeType() {
        return emplacementTypeType;
    }

    public void setEmplacementTypeType(EmplacementType emplacementTypeType) {
        this.emplacementTypeType = emplacementTypeType;
    }

    public int getMaxSeat() {
        return maxSeat;
    }

    public void setMaxSeat(int maxSeat) {
        this.maxSeat = maxSeat;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Emplacement{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", emplacementTypeType=" + emplacementTypeType +
                ", maxSeat=" + maxSeat +
                ", building=" + building +
                '}';
    }
}
