package hva.employees.satisfactions;

import java.io.Serial;
import hva.animals.Species;
import hva.employees.Veterinarian;


public class VetCareLoadSatisfaction extends VetSatisfaction {

    @Serial
    private static final long serialVersionUID = 202410232003L;


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
