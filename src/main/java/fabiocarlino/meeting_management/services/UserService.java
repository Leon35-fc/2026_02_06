package fabiocarlino.meeting_management.services;

import fabiocarlino.meeting_management.entities.User;
import fabiocarlino.meeting_management.exceptions.NotFoundException;
import fabiocarlino.meeting_management.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User findById(UUID id) throws NotFoundException {
        return this.userRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public User save(User newUser) {
        return this.userRepo.save(newUser);
    }

}
