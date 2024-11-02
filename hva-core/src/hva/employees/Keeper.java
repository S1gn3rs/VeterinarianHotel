package hva.employees;

import hva.habitats.Habitat;
import hva.employees.satisfactions.KeeperSatisfaction;
import hva.employees.satisfactions.KeeperWorkLoadSatisfaction;
import java.io.Serial;
import java.util.Collection;


/**
 * The Keeper class represents an employee
 * who is responsible for various habitats.
 */
public class Keeper extends Employee<Habitat> {

    /** Keeper's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410091852L;

    /**
     * Constructs a new Keeper.
     *
     * @param idEmployee Keeper's ID.
     * @param name Keeper's name.
     */
    public Keeper(String idEmployee, String name) {
        super(idEmployee, name);
    }


    /**
     * Calculates the satisfaction of the keeper.
     *
     * @return Keeper's satisfaction.
     */
    @Override
    public double getSatisfaction(){
        KeeperSatisfaction satisfaction = new
            KeeperWorkLoadSatisfaction();
        return satisfaction.getSatisfaction(this);
    }


    /**
     * Keeper's information in the format:
     * "TRT|idEmployee|name|idHabitat1,idHabitat2,..."
     *
     * @return String with the Keeper's information.
     */
    @Override
    public String toString() {
        String str = "TRT|" + getIdEmployee() + "|" + getName();

        Collection<Habitat> responsibilities = getResponsibilities();
        if (responsibilities.size() != 0) {
            str += "|";
            for (Habitat habitat : responsibilities) {
                str += habitat.getIdHabitat() + ",";
            }
            // remove last comma
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}
