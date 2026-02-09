package fabiocarlino.meeting_management.repositories;

import fabiocarlino.meeting_management.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
    List<User> findByEmail(String email);

    boolean existsByEmail(String email);

}
