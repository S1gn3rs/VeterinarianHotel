package hva.search.comparators;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;
import hva.employees.Employee;


public class IdEmployeeComparator implements Comparator<Employee>,
    Serializable {

    @Serial
    private static final long serialVersionUID = 202410241456L;


    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getIdEmployee().toLowerCase().compareTo
            (e2.getIdEmployee().toLowerCase());
    }
}
