package hva.search.comparators;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;
import hva.employees.Employee;


/**
 * Compares two employees lexicographically by their IDs,
 * without distinction between uppercase and lowercase.
 */
public class IdEmployeeComparator implements Comparator<Employee>,
    Serializable {

    /** IdEmployeeComparator's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410241456L;


    /**
     * Compares two employees lexicographically by their IDs,
     * without distinction between uppercase and lowercase.
     *
     * @param e1 the first employee to be compared
     * @param e2 the second employee to be compared
     * @return a negative int, zero, or a positive int as the first
     * argument is less than, equal to, or greater than the second
     */
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getIdEmployee().toLowerCase().compareTo
            (e2.getIdEmployee().toLowerCase());
    }
}
