package hva.search.selectors;

import hva.employees.Veterinarian;
import hva.vaccines.Vaccination;
import java.util.function.Predicate;


/**
 * Selects vaccinations by veterinarian.
 */
public class VaccinationByVetSelector implements
    Predicate<Vaccination> {

    /** Veterinarian to select vaccinations by. */
    private Veterinarian _vet;

    /**
     * Creates a new VaccinationByVetSelector.
     *
     * @param vet the veterinarian to select vaccinations by
     */
    public VaccinationByVetSelector(Veterinarian vet) {
        _vet = vet;
    }


    /**
     * Tests whether the given vaccination was administered
     * by the veterinarian specified in this selector.
     *
     * @param vaccination the vaccination to test
     * @return true if the vaccination was administered
     * by the veterinarian, false otherwise
     */
    @Override
    public boolean test(Vaccination vaccination) {
        return vaccination.getVet().equals(_vet);
    }
}
