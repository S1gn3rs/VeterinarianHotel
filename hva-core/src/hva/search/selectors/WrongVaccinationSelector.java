package hva.search.selectors;

import hva.vaccines.Vaccination;
import java.util.function.Predicate;


/**
 * Selects vaccinations that gave damage to the animal.
 */
public class WrongVaccinationSelector implements
    Predicate<Vaccination> {

    /**
     * Tests whether the given vaccination gave damage to the animal.
     *
     * @param vaccination the vaccination to test
     * @return true if the vaccination gave damage
     * to the animal, false otherwise
     */
    @Override
    public boolean test(Vaccination vaccination) {
        return vaccination.gaveDamage();
    }
}
