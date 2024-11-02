package hva.exceptions;

import java.io.Serial;

public class VeterinarianNotAuthorizedCoreException extends Exception{

    /** VeterinarianNotAuthorizedCoreException's class serial
     * number. */
    @Serial
    private static final long serialVersionUID = 202410091908L;

    private String _key;

    public VeterinarianNotAuthorizedCoreException(String key) {
        _key = key;
    }


    public String getKey() {
        return _key;
    }
}
