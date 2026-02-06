package fabiocarlino.meeting_management.services;

import fabiocarlino.meeting_management.entities.Building;
import fabiocarlino.meeting_management.exceptions.NotFoundException;
import fabiocarlino.meeting_management.repositories.BuildingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BuildingService {

    private final BuildingRepo buildingRepo;

    @Autowired
    public BuildingService(BuildingRepo buildingRepo) {
        this.buildingRepo = buildingRepo;
    }

    public Building findById(UUID id) throws NotFoundException {
        return this.buildingRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Building save(Building newBuilding) {
        return this.buildingRepo.save(newBuilding);
    }

}
