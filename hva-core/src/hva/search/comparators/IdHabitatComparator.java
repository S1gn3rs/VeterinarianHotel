package hva.search.comparators;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;
import hva.habitats.Habitat;


/**
 * Compares two habitats lexicographically by their IDs,
 * without distinction between uppercase and lowercase.
 */
public class IdHabitatComparator implements Comparator<Habitat>,
    Serializable {

    /** IdHabitatComparator's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410241500L;


    /**
     * Compares two habitats lexicographically by their IDs,
     * without distinction between uppercase and lowercase.
     *
     * @param h1 the first habitat to be compared
     * @param h2 the second habitat to be compared
     * @return a negative int, zero, or a positive int as the first
     * argument is less than, equal to, or greater than the second
     */
    @Override
    public int compare(Habitat h1, Habitat h2) {
        return h1.getIdHabitat().toLowerCase().compareTo
            (h2.getIdHabitat().toLowerCase());
    }
}
