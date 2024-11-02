package hva.search.selectors;

import hva.employees.Veterinarian;
import hva.vaccines.Vaccination;
import java.util.function.Predicate;

public class VaccinationByVetSelector implements
    Predicate<Vaccination> {

    Veterinarian _vet;

    public VaccinationByVetSelector(Veterinarian vet) {
        _vet = vet;
    }

    @Override
    public boolean test(Vaccination vaccination) {
        return vaccination.getVet().equals(_vet);
    }
}
