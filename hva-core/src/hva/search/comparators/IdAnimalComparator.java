package hva.search.comparators;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;
import hva.animals.Animal;


/**
 * Compares two animals lexicographically by their IDs,
 * without distinction between uppercase and lowercase.
 */
public class IdAnimalComparator implements Comparator<Animal>,
    Serializable {

    /** IdAnimalComparator's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410241505L;


    /**
     * Compares two animals lexicographically by their IDs,
     * without distinction between uppercase and lowercase.
     *
     * @param a1 the first animal to be compared
     * @param a2 the second animal to be compared
     * @return a negative int, zero, or a positive int as the first
     * argument is less than, equal to, or greater than the second
     */
    @Override
    public int compare(Animal a1, Animal a2) {
        return a1.getIdAnimal().toLowerCase().compareTo
            (a2.getIdAnimal().toLowerCase());
    }
}
