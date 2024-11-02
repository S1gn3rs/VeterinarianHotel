package hva.employees.satisfactions;

import java.io.Serial;
import hva.animals.Species;
import hva.employees.Veterinarian;


/**
 * The VetCareLoadSatisfaction class calculates the
 * satisfaction of a veterinarian based on its workload.
 */
public class VetCareLoadSatisfaction extends VetSatisfaction {

    /** VetCareLoadSatisfaction's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410232003L;


    /**
     * Calculates the satisfaction of the given veterinarian
     * based on its workload.
     *
     * @param vet the vet whose satisfaction is to be calculated
     * @return the satisfaction of the veterinarian
     */
    @Override
    public double getSatisfaction(Veterinarian vet) {
        double totalWork = 0;
        double work;

        for (Species species : vet.getResponsibilities()) {
            work = species.totalAnimals();
            work /= species.totalResponsibleVets();
            totalWork += work;
        }
        return 20 - totalWork;
    }
}
