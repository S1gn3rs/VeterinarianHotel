package hva.employees.satisfactions;

import java.io.Serial;
import java.io.Serializable;
import hva.employees.Veterinarian;


public abstract class VetSatisfaction implements Serializable {

    @Serial
    private static final long serialVersionUID = 202410231957L;

    public abstract double getSatisfaction(Veterinarian vet);
}
