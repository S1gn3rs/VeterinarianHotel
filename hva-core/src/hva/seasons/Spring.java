package hva.seasons;

import hva.Hotel;
import java.io.Serial;


/**
 * Spring is a season that can change state to Summer.
 */
public class Spring extends Season {

    /** Spring's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410091910L;


    /**
     * Creates a new Spring season.
     */
    public Spring() {
        super(SeasonIndex.SPRING_INDEX);
    }


    /**
     * Changes the season of the hotel from Spring to Summer.
     *
     * @param hotel Hotel to change the season.
    * @return int value of the next season (Summer).
     */
    @Override
    public int next(Hotel hotel) {
        Season newSeason = new Summer();
        hotel.setSeason(newSeason);
        return newSeason.getIndexValue();
    }
}
