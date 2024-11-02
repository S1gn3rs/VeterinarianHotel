package hva.seasons;

import hva.Hotel;
import hva.trees.Deciduous;
import hva.trees.Evergreen;
import hva.seasons.SeasonIndex;
import java.io.Serial;


/**
 * Spring is a season that can change state to Summer. Affects the
 * biological cycle and seasonal effort for both deciduous and
 * evergreen trees.
 */
public class Spring extends Season {

    /** Spring's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410091910L;


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
