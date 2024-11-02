package hva.animals;

import java.util.Set;
import java.util.HashSet;
import hva.employees.Veterinarian;
import java.io.Serial;
import java.io.Serializable;


/**
 * Species have an ID, a name, animals from that species, and the
 * responsible veterinarians for their treatment.
 */
public class Species implements Serializable {

    /** Species' class serial number. */
    @Serial
    private static final long serialVersionUID = 202410091850L;

    /** Species' identifier.*/
    private final String _idSpecies;

    /** Species' name.*/
    private String _name;

    /** All animals from this species.*/
    private Set<Animal> _animals = new HashSet<>();

    /** All responsible veterinarians for this species. */
    private Set<Veterinarian> _responsibleVets = new HashSet<>();


    /** Constructs a new species.
     *
     * @param idSpecies Species' ID.
     * @param name Species' name.
     */
    public Species(String idSpecies, String name) {
        _idSpecies = idSpecies;
        _name = name;
    }


    /**
     * @return Species' ID.
     */
    public String getIdSpecies() { return _idSpecies; }


    /**
     * @return Species' name.
     */
    public String getName() { return _name; }


    /**
     * Adds a new animal to the species.
     *
     * @param animal Animal to be added.
     */
    public void addAnimal(Animal animal) {
        _animals.add(animal);
    }


    /**
     * @return Number of animals from this species.
     */
    public int totalAnimals() {
        return _animals.size();
    }


    /**
     * @return Number of responsible veterinarians for this species.
     */
    public int totalResponsibleVets(){
        return _responsibleVets.size();
    }


    /**
     * Adds a new responsible veterinarian for this species.
     *
     * @param vet Veterinarian to be added.
     */
    public void addResponsibleVet(Veterinarian vet){
        _responsibleVets.add(vet);
    }


    /**
     * Removes a responsible veterinarian for this species.
     *
     * @param vet Veterinarian to be removed.
     */
    public void removeResponsibleVet(Veterinarian vet){
        _responsibleVets.remove(vet);
    }
}
