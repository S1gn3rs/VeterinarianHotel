package hva.vaccines;

import java.io.Serial;

/**
 * Enumerates the possible damages caused by a vaccine.
 */
public enum Damage {
    NORMAL(),
    CONFUSÃO(),
    ACIDENTE(),
    ERRO();

    /** Damage's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410241451L;
}
