package hva.seasons;

import java.io.Serial;
import java.io.Serializable;

public enum SeasonIndex implements Serializable{
    SPRING_INDEX(0),
    SUMMER_INDEX(1),
    AUTUMN_INDEX(2),
    WINTER_INDEX(3);

    @Serial
    private static final long serialVersionUID = 202410241453L;

    private final int _index;


    SeasonIndex(int index) {
        _index = index;
    }


    public int getValue() {
        return _index;
    }
}
