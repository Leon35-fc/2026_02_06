package fabiocarlino.meeting_management.runners;

import fabiocarlino.meeting_management.entities.*;
import fabiocarlino.meeting_management.services.BookingService;
import fabiocarlino.meeting_management.services.BuildingService;
import fabiocarlino.meeting_management.services.EmplacementService;
import fabiocarlino.meeting_management.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {

    private final UserService userService;
    private final BookingService bookingService;
    private final BuildingService buildingService;
    private final EmplacementService emplacementService;

    public Runner(UserService userService, BookingService bookingService, BuildingService buildingService, EmplacementService emplacementService) {
        this.userService = userService;
        this.bookingService = bookingService;
        this.buildingService = buildingService;
        this.emplacementService = emplacementService;
    }

    @Override
    public void run(String... args) throws Exception {

        User utente1 = new User("Marcolino", "Marco Manno", "f35@hotmail.it");
        this.userService.save(utente1);
        Building edificio1 = new Building("Edificio 3", "Centro Direzionale", "Napoli");
        this.buildingService.save(edificio1);

//        Building edificio = buildingService.findById(UUID.fromString("c335ddd8-87d5-4422-ba2c-63ff13cac618"));
        Emplacement postazione1 = new Emplacement("ufficio 4° piano", EmplacementType.SALA_RIUNIONI, 12, edificio1);
        this.emplacementService.save(postazione1);

        Booking booking1 = new Booking(utente1, postazione1, LocalDate.parse("2026-02-16"));
        this.bookingService.save(booking1);
    }
}
