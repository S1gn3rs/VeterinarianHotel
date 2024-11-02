package hva.animals.satisfactions;

import java.io.Serial;
import hva.animals.Animal;
import hva.habitats.Habitat;


/**
 * The CommunityImpactSatisfaction class calculates the
 * satisfaction of an animal based on the community factors
 * within its habitat, like number of animals of the same species.
 */
public class CommunityImpactSatisfaction extends AnimalSatisfaction {

    /** CommunityImpactSatisfaction's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410232000L;


    /**
     * Calculates the satisfaction of the given animal
     * based on community factors within its habitat.
     *
     * @param animal the animal whose satisfaction is to be calculated
     * @return the satisfaction of the animal
     */
    @Override
    public double getSatisfaction(Animal animal) {
        double satisfaction;
        Habitat habitat = animal.getHabitat();
        int equalAnimals = habitat.numberAnimalsOfSpecies(
            animal.getSpecies()) - 1;
        int totalAnimals = habitat.numberOfAnimals();

        satisfaction = 20;
        satisfaction += 3 * equalAnimals;
        // 2 * different animals
        satisfaction -= 2 * (totalAnimals - equalAnimals - 1);
        satisfaction += habitat.getArea() /
            habitat.numberOfAnimals();
        satisfaction += habitat.rateAdequation(animal);

        return satisfaction;
    }
}
