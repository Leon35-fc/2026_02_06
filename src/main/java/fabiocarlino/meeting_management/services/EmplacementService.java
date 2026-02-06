package fabiocarlino.meeting_management.services;

import fabiocarlino.meeting_management.entities.Emplacement;
import fabiocarlino.meeting_management.exceptions.NotFoundException;
import fabiocarlino.meeting_management.repositories.EmplacementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmplacementService {

    private final EmplacementRepo emplacementRepo;

    @Autowired
    public EmplacementService(EmplacementRepo emplacementRepo) {
        this.emplacementRepo = emplacementRepo;
    }

    public Emplacement findById(UUID id) throws NotFoundException {
        return this.emplacementRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Emplacement save(Emplacement newEmplacement) {
        return this.emplacementRepo.save(newEmplacement);
    }
}
