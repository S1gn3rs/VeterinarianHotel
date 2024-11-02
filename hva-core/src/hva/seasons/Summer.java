package hva.seasons;

import hva.Hotel;
import hva.trees.Deciduous;
import hva.trees.Evergreen;
import hva.seasons.SeasonIndex;
import java.io.Serial;


/**
 * Summer is a season that can change state to Autumn. Affects the
 * biological cycle and seasonal effort for both deciduous and
 * evergreen trees.
 */
public class Summer extends Season{

    /** Summer's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410091911L;


    public Summer() {
        super(SeasonIndex.SUMMER_INDEX);
    }


    /**
     * Changes the season of the hotel from Spring to Summer.
     *
     * @param hotel Hotel to change the season.
    * @return int value of the next season (Summer).
     */
    @Override
    public int next(Hotel hotel) {
        Season newSeason = new Autumn();
        hotel.setSeason(newSeason);
        return newSeason.getIndexValue();
    }
}
