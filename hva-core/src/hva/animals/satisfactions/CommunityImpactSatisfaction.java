package hva.animals.satisfactions;

import java.io.Serial;
import hva.animals.Animal;
import hva.habitats.Habitat;


public class CommunityImpactSatisfaction extends AnimalSatisfaction {

    @Serial
    private static final long serialVersionUID = 202410232000L;


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
