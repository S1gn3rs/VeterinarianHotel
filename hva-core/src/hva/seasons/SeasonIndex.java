package hva.seasons;

import java.io.Serial;
import java.io.Serializable;


/**
 * Enum representing the index of a season.
 */
public enum SeasonIndex implements Serializable {
    SPRING_INDEX(0),
    SUMMER_INDEX(1),
    AUTUMN_INDEX(2),
    WINTER_INDEX(3);

    /** SeasonIndex's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410241453L;

    /** Index value. */
    private final int _index;


    /**
     * Creates a new SeasonIndex.
     *
     * @param index The SeasonIndex value.
     */
    private SeasonIndex(int index) {
        _index = index;
    }


    /**
     * @return The SeasonIndex value.
     */
    public int getValue() {
        return _index;
    }
}
