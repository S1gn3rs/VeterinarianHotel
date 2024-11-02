package hva.seasons;

import hva.Hotel;
import java.io.Serial;


/**
 * Winter is a season that can change state to Spring.
 */
public class Winter extends Season {

    /** Winter's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410091912L;


    /**
     * Creates a new Winter season.
     */
    public Winter() {
        super(SeasonIndex.WINTER_INDEX);
    }


    /**
     * Changes the season of the hotel from Spring to Summer.
     *
     * @param hotel Hotel to change the season.
    * @return int value of the next season (Summer).
     */
    @Override
    public int next(Hotel hotel) {
        Season newSeason = new Spring();
        hotel.setSeason(newSeason);
        return newSeason.getIndexValue();
    }
}
