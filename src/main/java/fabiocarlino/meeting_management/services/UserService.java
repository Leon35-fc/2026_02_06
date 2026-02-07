package fabiocarlino.meeting_management.services;

import fabiocarlino.meeting_management.entities.User;
import fabiocarlino.meeting_management.exceptions.NotFoundException;
import fabiocarlino.meeting_management.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<User> findByEmail(String email) {
        return this.userRepo.findByEmail(email);
    }

    public void save(User newUser) {
        String newEmail = newUser.getEmail();
        if (newEmail.length() < 4 || !newEmail.matches(".*@.*\\..*")) {
            System.out.println("\'" + newEmail + "\'" + " non è un'e-mail valida.");
        } else if (!this.userRepo.findByEmail(newEmail).isEmpty()) {
            System.out.println("L\'indirizzo e-mail \'" + newEmail + "\' é già in uso.");
        } else {
            userRepo.save(newUser);
            System.out.println("Nuovo utente salvato. Id: " + newUser.getId());
        }
    }


}
