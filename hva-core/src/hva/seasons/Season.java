package hva.seasons;

import java.io.Serial;
import java.io.Serializable;
import hva.Hotel;


/**
 * Seasons can change state.
 */
public abstract class Season implements Serializable {

    /** Season's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410232235L;

    /** Index of the season. */
    private SeasonIndex _index;

    /**
     * Creates a new season with a given index.
     *
     * @param index The index of the season.
     */
    public Season(SeasonIndex index) {
        _index = index;
    }


    /**
     * @return The index of the season.
     */
    public SeasonIndex getIndex() { return _index; }


    /**
     * Gets the int value of the season index.
     *
     * @return The int value of the season index.
     */
    public int getIndexValue() { return _index.getValue(); }


    /**
     * Changes the season of the hotel to the next one.
     *
     * @param hotel Hotel to change the season.
     * @return int value of the next season (that will be the
     * current season).
     */
    public abstract int next(Hotel hotel);
}
