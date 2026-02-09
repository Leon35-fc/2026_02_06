package fabiocarlino.meeting_management.repositories;

import fabiocarlino.meeting_management.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface BookingRepo extends JpaRepository<Booking, UUID> {
    boolean existsByUtenteIdAndData(UUID utenteId, LocalDate data);
}

