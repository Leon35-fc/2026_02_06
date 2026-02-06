package fabiocarlino.meeting_management.repositories;

import fabiocarlino.meeting_management.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface BuildingRepo extends JpaRepository<Building, UUID> {
}
