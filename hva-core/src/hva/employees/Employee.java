package hva.employees;

import java.io.Serializable;
import java.io.Serial;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import hva.exceptions.NoResponsibilityCoreException;
import hva.habitats.Habitat;


/**
 * Employees have a unique ID and a name.
 */
public abstract class Employee<Responsibility>
    implements Serializable {

    /** Employee's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410091851L;

    /** Employee's identifier. */
    private final String _idEmployee;

    /** Employee's name.  */
    private String _name;

    private Map<String, Responsibility> _responsibilities =
        new TreeMap<>(String.CASE_INSENSITIVE_ORDER);


    /**
     * Constructs a new Employee.
     *
     * @param idEmployee Employee's ID.
     * @param name Employee's name.
     */
    public Employee(String idEmployee, String name) {
        _idEmployee = idEmployee;
        _name = name;
    }


    /**
     * @return Employee's ID.
     */
    public String getIdEmployee() { return _idEmployee; }


    /**
     * @return Employee's name.
     */
    public String getName() { return _name; }


    public abstract double getSatisfaction();


    public Collection<Responsibility> getResponsibilities() {
        return _responsibilities.values();
    }


    public Responsibility findResponsibility(String idResponsibility)
        throws NoResponsibilityCoreException {

        Responsibility responsibility = _responsibilities.get(
            idResponsibility);

        if (responsibility == null)
            throw new NoResponsibilityCoreException();
        return responsibility;
    }


    public void assignResponsibility(Responsibility responsibility,
        String key) {

        if (_responsibilities.get(key) == null)
            _responsibilities.put(key, responsibility);
    }


    public void unassignResponsibility(Responsibility responsibility,
        String key) throws NoResponsibilityCoreException {

        if (_responsibilities.get(key) == null)
            throw new NoResponsibilityCoreException();
        _responsibilities.remove(key);
    }
}
