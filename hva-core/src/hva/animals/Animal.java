package hva.animals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;
import hva.animals.satisfactions.AnimalSatisfaction;
import hva.animals.satisfactions.CommunityImpactSatisfaction;
import hva.habitats.*;
import hva.vaccines.Vaccination;
import java.io.Serial;
import java.io.Serializable;


/**
 * Animals have an ID, a name, a species, an habitat and a register of
 * all vaccinations. Animals can receive vaccinations and show their
 * health history. They can also be transfered to a different habitat.
 */
public class Animal implements Serializable {

    /** Animal's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410091849L;

    /** Animal's identifier. */
    private final String _idAnimal;

    /** Animal's name. */
    private String _name;

    /** Animal's species. */
    private Species _species;

    /** Animal's habitat. */
    private Habitat _habitat;

    /** Registry of all vaccinations received. */
    private List<Vaccination> _vaccinations =
        new ArrayList<>();


    /**
     * Constructs a new animal.
     *
     * @param idAnimal Animal's ID.
     * @param name Animal's name.
     * @param species Animal's species.
     * @param habitat Animal's habitat.
     */
    public Animal(String idAnimal, String name, Species species,
        Habitat habitat) {

        _idAnimal = idAnimal;
        _name = name;
        _species = species;
        _habitat = habitat;
    }


    /**
     * @return Animal's ID.
     */
    public String getIdAnimal() { return _idAnimal; }


    /**
     * @return Animal's name.
     */
    public String getName() { return _name; }


    /**
     * @return Animal's species.
     */
    public Species getSpecies() { return _species; }


    /**
     * @return Animal's habitat.
     */
    public Habitat getHabitat() { return _habitat; }


    /**
     * Vaccinates the animal. Adds the vaccination to the animal
     * health history.
     *
     * @param vaccination Vaccination to be applied.
     */
    public void vaccinateAnimal(Vaccination vaccination) {
        _vaccinations.add(vaccination);
    }


    public List<Vaccination> showMedicalActsOnAnimal() {
        return _vaccinations.stream()
            .collect(Collectors.toList());
    }


    /**
     * Shows the animal's health history.
     *
     * @return String with the animal's health history.
     */
    public String showHealthHistory() {
        String health = ""; // health history in string format
        for (Vaccination vaccination : _vaccinations)
            health += vaccination.getDamage().name() + ",";

        if (health.length() > 0) // remove last comma
            return health.substring(0, health.length() - 1);

        return "VOID";
    }


    public void transferToHabitat(Habitat habitat) {
        _habitat = habitat;
    }


    public double getSatisfaction(){
        AnimalSatisfaction satisfaction = new
            CommunityImpactSatisfaction();
        return satisfaction.getSatisfaction(this);
    }


    /**
     * Animal's information in the format:
     * "ANIMAL|idAnimal|name|idSpecies|healthHistory|idHabitat"
     *
     * @return String with the animal's information.
     */
    @Override
    public String toString() {
        return "ANIMAL|" + getIdAnimal() +
               "|" + getName() +
               "|" + getSpecies().getIdSpecies() +
               "|" + showHealthHistory() +
               "|" + getHabitat().getIdHabitat();
    }
}
