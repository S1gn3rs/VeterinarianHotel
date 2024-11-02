package hva.employees.satisfactions;

import java.io.Serial;
import java.io.Serializable;
import hva.employees.Veterinarian;


/**
 * Veterinarians have a satisfaction that can be calculated.
 */
public abstract class VetSatisfaction implements Serializable {

    /** VetSatisfaction's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410231957L;

    /**
     * Calculates the satisfaction of the given veterinarian.
     *
     * @param vet the vet whose satisfaction is to be calculated
     * @return the satisfaction of the veterinarian
     */
    public abstract double getSatisfaction(Veterinarian vet);
}
