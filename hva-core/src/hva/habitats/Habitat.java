package hva.habitats;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import hva.employees.Keeper;
import hva.search.comparators.IdAnimalComparator;
import hva.search.comparators.IdTreeComparator;
import hva.exceptions.UnknownTreeException;
import hva.animals.*;
import hva.trees.*;
import java.util.Set;
import java.io.Serial;
import java.io.Serializable;


/**
 * Habitats have ID, name, area, animals, trees and keepers
 * responsible for their maintenance. Habitats may also
 * influence specific species of animals.
 */
public class Habitat implements Serializable {

    /** Habitat'S class serial number. */
    @Serial
    private static final long serialVersionUID = 202410091918L;

    /** Habitat's identifier. */
    private final String _idHabitat;

    /** Habitat's name. */
    private String _name;

    /** Habitat's area. */
    private double _area;

    /** Trees inside the habitat. */
    private Map<String, Tree> _trees =
        new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    /** Keepers responsible for the habitat. */
    private Set<Keeper> _keepers = new HashSet<>();

    /** Animals inside the habitat. */
    private Map<String, Animal> _animals =
        new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    /** Habitat's influence over specific species. */
    private Map<String, Influence> _speciesInfluence =
        new HashMap<>();


    /**
     * Constructs a new habitat.
     *
     * @param idHabitat Habitat's ID.
     * @param name Habitat's name.
     * @param area Habitat's area.
     */
    public Habitat(String idHabitat, String name, int area) {
        _idHabitat = idHabitat;
        _name = name;
        _area = area;
    }


    /**
     * @return Habitat's ID.
     */
    public String getIdHabitat() {
        return _idHabitat;
    }


    /**
     * @return Habitat's name.
     */
    public String getName() {
        return _name;
    }


    /**
     * @return Habitat's area.
     */
    public double getArea() {
        return _area;
    }


    /**
     * Changes the habitat's area.
     *
     * @param area New area of the habitat.
     */
    public void changeArea(int area) {
        _area = area;
    }


    /**
     * Changes habitat's influence over a specific species.
     *
     * @param species Species to change the influence.
     * @param influence New influence over the species.
     */
    public void changeSpeciesInfluence(Species species,
        String influence) {

        _speciesInfluence.put(species.getIdSpecies(),
            Influence.valueOf(influence));
    }


    /**
     * Adds a tree to the habitat.
     *
     * @param tree Tree to be added to the habitat.
     */
    public void addTree(Tree tree) {
        _trees.put(tree.getIdTree(), tree);
    }


    /**
     * Adds an animal to the habitat.
     *
     * @param animal Animal to be added to the habitat.
     */
    public void addAnimal(Animal animal) {
        _animals.put(animal.getIdAnimal(), animal);
    }


    /**
     * Removes an animal from the habitat.
     *
     * @param animal Animal to be removed from the habitat.
     */
    public void removeAnimal(Animal animal) {
        _animals.remove(animal.getIdAnimal());
    }


    /**
     * Adds a keeper to the habitat.
     *
     * @param keeper Keeper to be added to the habitat.
     */
    public void addKeeper(Keeper keeper) {
        _keepers.add(keeper);
    }


    /**
     * Removes a keeper from the habitat.
     *
     * @param keeper Keeper to be removed from the habitat.
     */
    public void removeKeeper(Keeper keeper) {
        _keepers.remove(keeper);
    }


    /**
     * The total number of animals in the habitat.
     *
     * @return the total number of animals.
     */
    public int numberOfAnimals() {
        return _animals.size();
    }


    /**
    * Total number of animals of a specific species in the habitat.
    *
    * @param species the species to count animals for.
    * @return the total number of animals of the specified species.
    */
    public int numberAnimalsOfSpecies(Species species) {
        int count = 0;
        for (Animal animal : _animals.values()) {
            if (animal.getSpecies().equals(species)) { count++; }
        }
        return count;
    }


    /**
     * @return the total number of trees in the habitat.
     */
    public int numberOfTrees() {
        return _trees.size();
    }


    /**
     * @return the total number of keepers in the habitat.
     */
    public int numberOfKeepers() {
        return _keepers.size();
    }


    /**
     * Calculates the total work required in the habitat.
     *
     * @return the total work required in the habitat.
     */
    public double workInHabitat() {
        double work = 0;
        for (Tree tree : _trees.values()) {
            work += tree.cleaningEffort();
        }
        return work + getArea() + 3 * numberOfAnimals();
    }


    /**
     * Finds a tree in the habitat by its ID.
     *
     * @param idTree the ID of the tree to find.
     * @return the tree with the specified ID.
     * @throws UnknownTreeException if the tree is not found.
     */
    public Tree findTreeInHabitat(String idTree)
        throws UnknownTreeException {

        Tree tree = _trees.get(idTree);
        if (tree == null) {
            throw new UnknownTreeException();
        }
        return tree;
    }


    /**
    * Rates the adequation of an animal to the habitat based on
    * species influence.
    *
    * @param animal the animal to evaluate.
    * @return the adequation score: 20, -20, or 0.
    */
    public int rateAdequation(Animal animal) {
        Influence influence = _speciesInfluence.get(
            animal.getSpecies().getIdSpecies());

        if (influence == null) {
            return 0;
        }
        return influence.getValue();
    }


    /**
     * Provides a list of animals in the habitat ordered
     * lexicographically by their IDs, without distinction between
     * uppercase and lowercase.
     *
     * @return a list of animals in the habitat.
     */
    public List<Animal> showAnimalsInHabitat() {
        return _animals.values().stream()
            .sorted(new IdAnimalComparator())
            .collect(Collectors.toList());
    }


    /**
    * Provides a list of all trees in the habitat ordered
    * lexicographically by their IDs, without distinction between
    * uppercase and lowercase.
    *
    * @return a list of trees in the habitat.
    */
    public List<Tree> showAllTreesInHabitat() {
        return _trees.values().stream()
            .sorted(new IdTreeComparator())
            .collect(Collectors.toList());
    }


    /**
    * Habitat's information in the format:
     * "HABITAT|idHabitat|name|area|numberOfTrees allTreesOfHabitat"
    *
    * @return String with the habitat information.
    */
    @Override
    public String toString() {
        String str = "HABITAT|" + getIdHabitat() +
        "|" + getName() +
        "|" + (int) getArea() +
        "|" + numberOfTrees() + "\n";

        Collection<Tree> trees = showAllTreesInHabitat();
        for (Tree tree : trees) {
            str += tree.toString() + "\n";
        }
        return str.substring(0, str.length() - 1);
    }
}
