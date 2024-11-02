package hva.search.comparators;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;
import hva.vaccines.Vaccine;


public class IdVaccineComparator implements Comparator<Vaccine>,
    Serializable {

    @Serial
    private static final long serialVersionUID = 202410241458L;


    @Override
    public int compare(Vaccine v1, Vaccine v2) {
        return v1.getIdVaccine().toLowerCase().compareTo
            (v2.getIdVaccine().toLowerCase());
    }
}
