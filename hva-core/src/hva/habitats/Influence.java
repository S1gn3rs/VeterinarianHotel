package hva.habitats;

import java.io.Serial;
import java.io.Serializable;


/**
 * Enumerates the possible influences of a habitat.
 */
public enum Influence implements Serializable {
    POS(20),
    NEG(-20),
    NEU(0);

    /** Influence's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410160921L;

    /** Influence's value. */
    private final int _value;


    /**
     * Creates a new influence.
     *
     * @param value The influence's value.
     */
    private Influence(int value) {
        _value = value;
    }


    /**
     * @return The influence's value.
     */
    public int getValue() {
        return _value;
    }
}
