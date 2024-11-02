package hva.seasons;

import java.io.Serial;
import java.io.Serializable;
import hva.Hotel;
import hva.trees.Deciduous;
import hva.trees.Evergreen;


/**
 * Seasons can change state. Affects the biological cycle and
 * seasonal effort for both deciduous and evergreen trees.
 */
public abstract class Season implements Serializable {

    /** Season's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410232235L;

    private SeasonIndex _index;


    public Season(SeasonIndex index) {
        _index = index;
    }


    public SeasonIndex getIndex() { return _index; }


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
