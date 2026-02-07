package fabiocarlino.meeting_management.exceptions;

public class EmailAlreadyExistException extends RuntimeException {
    public EmailAlreadyExistException(String email) {
        super("L'e-mail " + email + " è già in uso.");
    }
}
