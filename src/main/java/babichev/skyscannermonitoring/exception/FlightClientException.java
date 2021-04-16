package babichev.skyscannermonitoring.exception;

import babichev.skyscannermonitoring.exception.to.ValidationErrorTo;
import java.util.*;

public class FlightClientException extends RuntimeException {

    private List<ValidationErrorTo> listTos;

    public FlightClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public FlightClientException(String message) {
        super(message);
    }

    public FlightClientException(String message, List<ValidationErrorTo> listTos) {
        super(message);
        this.listTos = listTos;
    }
}
