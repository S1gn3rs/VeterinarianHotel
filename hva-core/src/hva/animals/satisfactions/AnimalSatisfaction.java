package hva.animals.satisfactions;

import java.io.Serial;
import java.io.Serializable;
import hva.animals.Animal;

/**
 * Animals have a satisfaction that can be calculated.
 */
public abstract class AnimalSatisfaction  implements Serializable{

    /** AnimalSatisfaction's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410231955L;


    /**
     * Calculates the satisfaction of the given animal.
     *
     * @param animal the animal whose satisfaction is to be calculated
     * @return the satisfaction of the animal
     */
    public abstract double getSatisfaction(Animal animal);
}
