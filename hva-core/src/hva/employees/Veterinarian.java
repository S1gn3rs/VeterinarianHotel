package hva.employees;

import hva.animals.Species;
import hva.employees.satisfactions.KeeperSatisfaction;
import hva.employees.satisfactions.KeeperWorkLoadSatisfaction;
import hva.employees.satisfactions.VetCareLoadSatisfaction;
import hva.employees.satisfactions.VetSatisfaction;
import hva.exceptions.NoResponsibilityCoreException;
import hva.habitats.Habitat;
import java.util.Map;
import java.util.TreeMap;
import java.io.Serial;
import java.util.Collection;


/**
 * The Veterinarian class represents a employee
 * who is responsible for various species.
 */
public class Veterinarian extends Employee<Species> {

    /** Veterinarian's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410091853L;


    /**
     * Constructs a new Veterinarian.
     *
     * @param idEmployee Veterinarian's ID.
     * @param name Veterinarian's name.
     */
    public Veterinarian(String idEmployee, String name) {
        super(idEmployee, name);
    }


    @Override
    public double getSatisfaction(){
        VetSatisfaction satisfaction = new VetCareLoadSatisfaction();
        return satisfaction.getSatisfaction(this);
    }


    /**
     * Veterinarian's information in the format:
     * "VET|idEmployee|name|idSpecies1,idSpecies2,..."
     *
     * @return String with the Veterinarian's information.
     */
    @Override
    public String toString() {
        String str = "VET|" + getIdEmployee() + "|" + getName();
        Collection<Species> responsibilities = getResponsibilities();
        if (responsibilities.size() != 0) {
            str += "|";
            for (Species species : responsibilities) {
                str += species.getIdSpecies() + ",";
            }
            // remove last comma
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}
