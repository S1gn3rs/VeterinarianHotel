package hva.trees.treeState;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * Enumerates the possible seasonal efforts.
 */
public enum SeasonalEffort implements Serializable {
    ZERO(0),
    ONE(1),
    TWO(2),
    FIVE(5);

    /** SeasonalEffort's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410231756L;


    /** Value to SeasonalEffort instance. */
    private final int _value;


    /**
     * Constructs a new SeasonalEffort.
     *
     * @param value SeasonalEffort's value.
     */
    SeasonalEffort(int value) {
        _value = value;
    }


    /**
     * @return SeasonalEffort's value.
     */
    public int getValue() {
        return _value;
    }
}
