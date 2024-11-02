package hva.search.comparators;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;
import hva.animals.Animal;


public class IdAnimalComparator implements Comparator<Animal>,
    Serializable {

    @Serial
    private static final long serialVersionUID = 202410241505L;

    @Override
    public int compare(Animal a1, Animal a2) {
        return a1.getIdAnimal().toLowerCase().compareTo
            (a2.getIdAnimal().toLowerCase());
    }
}
