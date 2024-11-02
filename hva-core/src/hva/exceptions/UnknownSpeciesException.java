package hva.exceptions;

import java.io.Serial;

/**
 * Exception thrown when a species is unknown.
 */
public class UnknownSpeciesException extends Exception {

    /** UnknownSpeciesException's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410091904L;

    /** The key of the unknown species. */
    private String _key;


    /**
     * Constructs a new UnknownSpeciesException with the given key.
     * @param key The key of the unknown species.
     */
    public UnknownSpeciesException(String key) {
        _key = key;
    }


    /**
     * @return The key of the unknown species.
     */
    public String getKey() {
        return _key;
    }
}
