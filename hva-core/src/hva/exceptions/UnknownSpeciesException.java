package hva.exceptions;

import java.io.Serial;

public class UnknownSpeciesException extends Exception {

    /** UnknownSpeciesException's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410091904L;

    private String _key;

    public UnknownSpeciesException(String key) {
        _key = key;
    }

    public String getKey() {
        return _key;
    }
}
