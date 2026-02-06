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

//        User utente1 = new User("Marcolino", "Marco Manno", "f35@hotmail.it");
//        this.userService.save(utente1);
//        Building edificio1 = new Building("Edificio 3", "Centro Direzionale", "Napoli");
//        this.buildingService.save(edificio1);
//
//        Emplacement postazione1 = new Emplacement("ufficio 4° piano", EmplacementType.SALA_RIUNIONI, 12, edificio1);
//        this.emplacementService.save(postazione1);
//
//        Booking booking1 = new Booking(utente1, postazione1, LocalDate.parse("2026-02-16"));
//        this.bookingService.save(booking1);

//         Creazione utenti
        User utente1 = new User("johnDoe", "John Doe", "john.doe@example.com");
        User utente2 = new User("janeDoe", "Jane Doe", "jane.doe@example.com");
        User utente3 = new User("admin", "Admin User", "admin@example.com");

        this.userService.save(utente1);
        this.userService.save(utente2);
        this.userService.save(utente3);

//         Creazione edifici
        Building edificio1 = new Building("Edificio principale", "Via Roma 1", "Roma");
        Building edificio2 = new Building("Edificio secondario", "Via Milano 2", "Milano");
        Building edificio3 = new Building("Edificio terziario", "Via Napoli 3", "Napoli");

        this.buildingService.save(edificio1);
        this.buildingService.save(edificio2);
        this.buildingService.save(edificio3);

//         Creazione postazioni
        Emplacement postazione1 = new Emplacement("Sala riunioni principale", EmplacementType.SALA_RIUNIONI, 10, edificio1);
        Emplacement postazione2 = new Emplacement("Open space ufficio", EmplacementType.OPENSPACE, 20, edificio2);
        Emplacement postazione3 = new Emplacement("Ufficio privato", EmplacementType.PRIVATE, 2, edificio3);

        this.emplacementService.save(postazione1);
        this.emplacementService.save(postazione2);
        this.emplacementService.save(postazione3);

//         Creazione prenotazioni
        Booking prenotazione1 = new Booking(utente1, postazione1, LocalDate.parse("2024-03-16"));
        Booking prenotazione2 = new Booking(utente2, postazione2, LocalDate.parse("2024-03-17"));
        Booking prenotazione3 = new Booking(utente3, postazione3, LocalDate.parse("2024-03-18"));

        this.bookingService.save(postazione1);
        this.bookingService.save(postazione2);
        this.bookingService.save(postazione3);

    }
}
