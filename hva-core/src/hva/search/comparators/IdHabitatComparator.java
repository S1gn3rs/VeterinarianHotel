package hva.search.comparators;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;
import hva.habitats.Habitat;


public class IdHabitatComparator implements Comparator<Habitat>,
    Serializable {

    @Serial
    private static final long serialVersionUID = 202410241500L;


    @Override
    public int compare(Habitat h1, Habitat h2) {
        return h1.getIdHabitat().toLowerCase().compareTo
            (h2.getIdHabitat().toLowerCase());
    }
}
