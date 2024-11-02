package hva.exceptions;

import java.io.Serial;

/**
 * Exception thrown when a veterinarian is not authorized.
 */
public class VeterinarianNotAuthorizedCoreException extends Exception{

    /** VeterinarianNotAuthorizedCoreException's class serial
     * number. */
    @Serial
    private static final long serialVersionUID = 202410091908L;

    /** The key of the unauthorized veterinarian. */
    private String _key;


    /**
     * Constructs a new VeterinarianNotAuthorizedCoreException
     * with the given key.
     * @param key The key of the unauthorized veterinarian.
     */
    public VeterinarianNotAuthorizedCoreException(String key) {
        _key = key;
    }


    /**
     * @return The key of the unauthorized veterinarian.
     */
    public String getKey() {
        return _key;
    }
}
