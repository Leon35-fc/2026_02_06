package fabiocarlino.meeting_management.services;

import fabiocarlino.meeting_management.entities.Booking;
import fabiocarlino.meeting_management.exceptions.NotFoundException;
import fabiocarlino.meeting_management.repositories.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingService {

    private final BookingRepo bookingRepo;

    @Autowired
    public BookingService(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public Booking findById(UUID id) throws NotFoundException {
        return this.bookingRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Booking save(Booking newBooking) {
        if (bookingRepo.existsByUtenteIdAndData(newBooking.getUser().getId(), newBooking.getDate())) {
            throw new RuntimeException("L'utente ha già una prenotazione per questa data");
        }
        return this.bookingRepo.save(newBooking);
    }

}
