package hva.vaccines;

import hva.animals.Animal;
import hva.employees.Veterinarian;
import java.io.Serial;
import java.io.Serializable;


/**
 * The Vaccination class represents a vaccination record with
 * information about the vaccine, the animal, the veterinarian,
 * and any damage caused.
 */
public class Vaccination implements Serializable {

    /** Vaccination's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410091916L;

    /** Vaccine applied. */
    private Vaccine _vaccine;

    /** Animal vaccinated. */
    private Animal _animal;

    /** Veterinarian who applied the vaccine. */
    private Veterinarian _vet;

    /** Damage caused by the vaccine. */
    private Damage _damage;


    /**
     * Constructs a new Vaccination.
     *
     * @param vaccine Vaccine applied.
     * @param animal Animal vaccinated.
     * @param vet Veterinarian who applied the vaccine.
     * @param damage Damage caused by the vaccine.
     */
    public Vaccination(Vaccine vaccine, Animal animal,
    Veterinarian vet, Damage damage) {

        _vaccine = vaccine;
        _animal = animal;
        _vet = vet;
        _damage = damage;
    }


    /**
     * @return Vaccine used in the vaccination.
     */
    public Vaccine getVaccine() { return _vaccine;}


    /**
     * @return Animal vaccinated.
     */
    public Animal getAnimal() { return _animal;}


    /**
     * @return Veterinarian who applied the vaccine.
     */
    public Veterinarian getVet() { return _vet;}


    /**
     * @return Damage caused by the vaccine.
     */
    public Damage getDamage() { return _damage;}


    /**
     * @return true if the vaccine caused damage, false otherwise.
     */
    public boolean gaveDamage() {
        return _damage != Damage.NORMAL;
    }


    /**
     * Vaccination's information in the format:
     * "REGISTO_VACINA|idVaccine|idVet|idSpecies"
     *
     * @return String with the vaccination information.
     */
    @Override
    public String toString() {
        return "REGISTO-VACINA|" + getVaccine().getIdVaccine() +
        "|" + getVet().getIdEmployee() +
        "|" + getAnimal().getSpecies().getIdSpecies();
    }
}
