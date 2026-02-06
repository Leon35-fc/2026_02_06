package fabiocarlino.meeting_management.repositories;

import fabiocarlino.meeting_management.entities.Emplacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmplacementRepo extends JpaRepository<Emplacement, UUID> {

}
