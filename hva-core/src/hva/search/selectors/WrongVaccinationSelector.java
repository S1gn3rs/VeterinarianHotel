package hva.search.selectors;

import hva.vaccines.Vaccination;
import java.util.function.Predicate;

public class WrongVaccinationSelector implements
    Predicate<Vaccination> {

    @Override
    public boolean test(Vaccination vaccination) {
        return vaccination.gaveDamage();
    }
}
