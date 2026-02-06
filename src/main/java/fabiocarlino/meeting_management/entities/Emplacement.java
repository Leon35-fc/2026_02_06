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
    private EmplacementType emplacementType;

    @Column
    private int maxSeat;

    @ManyToOne
    @JoinColumn(name = "id_building")
    private Building building;

    public Emplacement(String description, EmplacementType emplacementType, int maxSeat, Building building) {
        this.description = description;
        this.emplacementType = emplacementType;
        this.maxSeat = maxSeat;
        this.building = building;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EmplacementType getEmplacementType() {
        return emplacementType;
    }

    public void setEmplacementType(EmplacementType emplacementType) {
        this.emplacementType = emplacementType;
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
                ", emplacementTypeType=" + emplacementType +
                ", maxSeat=" + maxSeat +
                ", building=" + building +
                '}';
    }
}
