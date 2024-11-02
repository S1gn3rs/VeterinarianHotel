package hva.search.comparators;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;
import hva.vaccines.Vaccine;


/**
 * Compares two vaccines lexicographically by their IDs,
 * without distinction between uppercase and lowercase.
 */
public class IdVaccineComparator implements Comparator<Vaccine>,
    Serializable {

    /** IdVaccineComparator's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410241458L;


    /**
     * Compares two vaccines lexicographically by their IDs,
     * without distinction between uppercase and lowercase.
     *
     * @param v1 the first vaccine to be compared
     * @param v2 the second vaccine to be compared
     * @return a negative int, zero, or a positive int as the first
     * argument is less than, equal to, or greater than the second
     */
    @Override
    public int compare(Vaccine v1, Vaccine v2) {
        return v1.getIdVaccine().toLowerCase().compareTo
            (v2.getIdVaccine().toLowerCase());
    }
}
