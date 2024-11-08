package hva.seasons;

import hva.Hotel;
import java.io.Serial;


/**
 * Autumn is a season that can change state to Winter.
 */
public class Autumn extends Season {

    /** Autumn's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410091909L;


    /**
     * Creates a new Autumn season.
     */
    public Autumn() {
        super(SeasonIndex.AUTUMN_INDEX);
    }


    /**
     * Changes the season of the hotel from Autumn to Winter.
     *
     * @param hotel Hotel to change the season.
     * @return int value of the next season (Winter).
     */
    @Override
    public int next(Hotel hotel) {
        Season newSeason = new Winter();
        hotel.setSeason(newSeason);
        return newSeason.getIndexValue();
    }

}
