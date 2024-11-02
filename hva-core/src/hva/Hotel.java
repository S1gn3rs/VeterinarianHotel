package hva;

import java.io.Serial;
import java.io.Serializable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;
import hva.animals.*;
import hva.animals.satisfactions.*;
import hva.employees.*;
import hva.employees.satisfactions.*;
import hva.exceptions.*;
import hva.habitats.*;
import hva.vaccines.*;
import hva.seasons.*;
import hva.search.comparators.*;
import hva.search.selectors.*;
import hva.trees.*;


/**
 * Hotels manage species, animals, employees,
 * vaccines, habitats, and trees.
 */
public class Hotel implements Serializable {

    /** Hotel serial number. */
    @Serial
    private static final long serialVersionUID = 202407081733L;

    /** Hotel has been changed. */
    private boolean _changed = false;

    /** Current season. */
    private Season _currentSeason = new Spring();

    /** Species. */
    private Map<String, Species> _species =
        new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    /** Animals. */
    private Map<String, Animal> _animals =
        new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    /** Employees. */
    private Map<String, Employee> _employees =
        new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    /** Vaccines. */
    private Map<String, Vaccine> _vaccines =
        new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    /** Habitats. */
    private Map<String, Habitat> _habitats =
        new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    /** Trees. */
    private Map<String, Tree> _trees =
        new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    /** Vaccinations. */
    private List<Vaccination> _vaccinations =
        new ArrayList<>();


    /**
     * Marks the hotel as changed.
     */
    public void changed() {
        setChanged(true);
    }


    /**
     * Checks if the hotel has been changed.
     *
     * @return true if the hotel has been changed, false otherwise.
     */
    public boolean hasChanged() {
        return _changed;
    }


    /**
     * Sets the changed status of the hotel.
     *
     * @param changed the new changed status.
     */
    public void setChanged(boolean changed) {
        _changed = changed;
    }


    /**
     * Sets the current season of the hotel.
     *
     * @param season the new season.
     */
    public void setSeason(Season season) {
        _currentSeason = season;
    }


    /**
     * @return the current season.
     */
    public Season getSeason() {
        return _currentSeason;
    }


    /**
     * Advances the season of the hotel. And updates all states
     * related to the season.
     *
     * @return the index of the new season.
     */
    public int advanceSeason() {
        int seasonIndex = getSeason().next(this);
        for (Tree tree : _trees.values()) {
            tree.nextState();
        }
        changed();
        return seasonIndex;
    }


    /**
     * Adds a species to the hotel.
     *
     * @param species the species to add.
     * @throws DuplicateSpeciesNameCoreException if a species with
     * the same name already exists.
     */
    public void addSpecies(Species species)
        throws DuplicateSpeciesNameCoreException {

        if (doesSpeciesNameExist(species.getName())) {
            throw new DuplicateSpeciesNameCoreException();
        }
        _species.put(species.getIdSpecies(), species);
    }


    /**
     * Adds a habitat to the hotel.
     *
     * @param habitat the habitat to add.
     * @throws DuplicateHabitatException if an habitat with
     * the same ID already exists.
     */
    public void addHabitat(Habitat habitat)
        throws DuplicateHabitatException {

        String idHabitat = habitat.getIdHabitat();
        if (_habitats.get(idHabitat) != null) {
            throw new DuplicateHabitatException();
        }
        _habitats.put(idHabitat, habitat);
    }


    /**
     * Adds an animal to the hotel.
     *
     * @param animal the animal to add.
     * @throws DuplicateAnimalException if an animal with
     * the same ID already exists.
     */
    public void addAnimal(Animal animal)
        throws DuplicateAnimalException {

        String idAnimal = animal.getIdAnimal();
        if (_animals.get(idAnimal) != null) {
            throw new DuplicateAnimalException();
        }
        _animals.put(idAnimal, animal);
    }


    /**
     * Adds a tree to the hotel.
     *
     * @param tree the tree to add.
     * @throws DuplicateTreeException if a tree with
     * the same ID already exists.
     */
    public void addTree(Tree tree)
        throws DuplicateTreeException {

        String idTree = tree.getIdTree();
        if (_trees.get(idTree) != null) {
            throw new DuplicateTreeException();
        }
        _trees.put(idTree, tree);
    }


    /**
     * Adds an employee to the hotel.
     *
     * @param employee the employee to add.
     * @throws DuplicateEmployeeException if an employee with
     * the same ID already exists.
     */
    public void addEmployee(Employee employee)
        throws DuplicateEmployeeException {

        String idEmployee = employee.getIdEmployee();
        if (_employees.get(idEmployee) != null) {
            throw new DuplicateEmployeeException();
        }
        _employees.put(idEmployee, employee);
    }


    /**
     * Adds a vaccine to the hotel.
     *
     * @param vaccine the vaccine to add.
     * @throws DuplicateVaccineException if a vaccine with
     * the same ID already exists.
     */
    public void addVaccine(Vaccine vaccine)
        throws DuplicateVaccineException {

        String idVaccine = vaccine.getIdVaccine();
        if (_vaccines.get(idVaccine) != null) {
            throw new DuplicateVaccineException();
        }
        _vaccines.put(idVaccine, vaccine);
    }


    /**
     * Checks if a species name already exists.
     *
     * @param name the species name to check.
     * @return true if the species name exists, false otherwise.
     */
    public boolean doesSpeciesNameExist(String name) {
        String lowerCaseName = name.toLowerCase();
        for (Species species : _species.values()) {
            if (species.getName().toLowerCase().equals(lowerCaseName))
                return true;
        }
        return false;
    }


    /**
     * Transfers an animal to a habitat. The animal is removed from
     * its current habitat and added to the new habitat.
     *
     * @param idAnimal
     * @param idHabitat
     * @throws UnknownAnimalException
     * @throws UnknownHabitatException
     */
    public void transferToHabitat(String idAnimal, String idHabitat)
        throws UnknownAnimalException, UnknownHabitatException {

        Animal animal = findAnimal(idAnimal);
        Habitat newHabitat = findHabitat(idHabitat);
        Habitat oldHabitat = animal.getHabitat();
        animal.transferToHabitat(newHabitat);
        oldHabitat.removeAnimal(animal);
        newHabitat.addAnimal(animal);
        changed();
    }


    /**
     * Shows the satisfaction of an animal.
     *
     * @param idAnimal the ID of the animal.
     * @return the satisfaction of the animal.
     * @throws UnknownAnimalException
     */
    public double showSatisfactionOfAnimal(String idAnimal)
        throws UnknownAnimalException {

        Animal animal = findAnimal(idAnimal);
        return animal.getSatisfaction();
    }


    /**
     * Shows the satisfaction of an employee.
     *
     * @param idEmployee the ID of the employee.
     * @return the satisfaction of the employee.
     * @throws UnknownEmployeeException
     */
    public double showSatisfactionOfEmployee(String idEmployee)
        throws UnknownEmployeeException {

        Employee employee = findEmployee(idEmployee);
        return employee.getSatisfaction();
    }


    /**
     * Shows the global satisfaction of the hotel.
     *
     * @return the global satisfaction of the hotel.
     */
    public double showGlobalSatisfaction() {
        double globalSatisfaction = 0;
        for (Animal animal : _animals.values()) {
            globalSatisfaction += animal.getSatisfaction();
        }
        for (Employee employee : _employees.values()) {
            globalSatisfaction += employee.getSatisfaction();
        }
        return globalSatisfaction;
    }


    /**
     * Changes habitat area.
     *
     * @param idHabitat the ID of the habitat.
     * @param area the new area of the habitat.
     * @throws UnknownHabitatException
     */
    public void changeHabitatArea(String idHabitat, int area)
        throws UnknownHabitatException {

        Habitat habitat = findHabitat(idHabitat);
        habitat.changeArea(area);
        changed();
    }


    /**
     * Vaccinates an animal. The veterinarian must be authorized.
     *
     * @param idVaccine the ID of the vaccine.
     * @param idVet the ID of the veterinarian.
     * @param idAnimal the ID of the animal.
     * @throws UnknownVaccineException if the vaccine is not found.
     * @throws UnknownVeterinarianException if the veterinarian
     * is not found.
     * @throws UnknownAnimalException if the animal is not found.
     * @throws VeterinarianNotAuthorizedCoreException if the
     * veterinarian is not authorized.
     * @throws WrongVaccineException if the vaccine is wrong.
     */
    public void vaccinateAnimal(String idVaccine, String idVet,
        String idAnimal) throws UnknownVaccineException,
        UnknownVeterinarianException, UnknownAnimalException,
        VeterinarianNotAuthorizedCoreException,
        WrongVaccineException {

        Vaccine vaccine = findVaccine(idVaccine);
        Veterinarian vet = findVeterinarian(idVet);
        Animal animal = findAnimal(idAnimal);
        String idSpecies = animal.getSpecies().getIdSpecies();
        Species species;
        Vaccination vaccination;
        try {
            species = vet.findResponsibility(idSpecies);
        }
        catch (NoResponsibilityCoreException e) {
            throw new VeterinarianNotAuthorizedCoreException(
                idSpecies);
        }
        vaccination = new Vaccination(vaccine, animal,
            vet, vaccine.calculateDamage(species));

        animal.vaccinateAnimal(vaccination);
        vaccine.addVaccination(vaccination);
        _vaccinations.add(vaccination);
        changed();

        if (vaccination.gaveDamage()) throw new
            WrongVaccineException();
    }


    /**
     * Provides a list of animals in the hotel ordered
     * lexicographically by their IDs, without distinction between
     * uppercase and lowercase.
     *
     * @return a list of animals in the hotel.
     */
    public List<Animal> showAllAnimals() {
        return _animals.values().stream()
            .sorted(new IdAnimalComparator())
            .collect(Collectors.toList());
    }


    /**
     * Provides a list of animals in a habitat ordered
     * lexicographically by their IDs, without distinction between
     * uppercase and lowercase.
     *
     * @param idHabitat the ID of the habitat.
     * @return a list of animals in the habitat.
     * @throws UnknownHabitatException if the habitat is not found.
     */
    public List<Animal> showAnimalsInHabitat(String idHabitat)
        throws UnknownHabitatException {

        Habitat habitat = findHabitat(idHabitat);
        return habitat.showAnimalsInHabitat();
    }


    /**
     * Provides a list of habitats in the hotel ordered
     * lexicographically by their IDs, without distinction between
     * uppercase and lowercase.
     *
     * @return a list of habitats in the hotel.
     */
    public List<Habitat> showAllHabitats() {
        return _habitats.values().stream()
            .sorted(new IdHabitatComparator())
            .collect(Collectors.toList());
    }


    /**
     * Provides a list of trees in the habitat ordered
     * lexicographically by their IDs, without distinction between
     * uppercase and lowercase.
     *
     * @param idHabitat the ID of the habitat.
     * @return a list of trees in the habitat.
     * @throws UnknownHabitatException if the habitat is not found.
     */
    public List<Tree> showAllTreesInHabitat(String idHabitat)
        throws UnknownHabitatException {

        Habitat habitat = findHabitat(idHabitat);
        return habitat.showAllTreesInHabitat();
    }


    /**
     * Provides a list of employees in the hotel ordered
     * lexicographically by their IDs, without distinction between
     * uppercase and lowercase.
     *
     * @return a list of employess in the hotel.
     */
    public List<Employee> showAllEmployees() {
        return _employees.values().stream()
            .sorted(new IdEmployeeComparator())
            .collect(Collectors.toList());
    }


    /**
     * Provides a list of vaccines in the hotel ordered
     * lexicographically by their IDs, without distinction between
     * uppercase and lowercase.
     *
     * @return a list of vaccines in the hotel.
     */
    public List<Vaccine> showAllVaccines() {
        return _vaccines.values().stream()
            .sorted(new IdVaccineComparator())
            .collect(Collectors.toList());
    }


    /**
     * Provides a list of vaccinations administrated in the hotel
     * ordered by administration data.
     *
     * @return a list of vaccinations administrated in the hotel.
     */
    public List<Vaccination> showVaccinations() {
        return _vaccinations.stream()
            .collect(Collectors.toList());
    }


    /**
     * Provides a list of vaccinations given by a veterinarian,
     * ordered by administration data.
     *
     * @param idVet the ID of the veterinarian.
     * @return a list of vaccinations given by a veterinarian.
     * @throws UnknownVeterinarianException if the veterinarian
     */
    public List<Vaccination> showMedicalActsByVeterinarian(
        String idVet) throws UnknownVeterinarianException {

        Veterinarian vet = findVeterinarian(idVet);
        return _vaccinations.stream()
            .filter(new VaccinationByVetSelector(vet))
            .collect(Collectors.toList());
    }


    /**
     * Provides a list of vaccinations administrated to an animal,
     * ordered by administration data.
     *
     * @param idAnimal the ID of the animal.
     * @return a list of vaccinations administrated to an animal.
     * @throws UnknownAnimalException if the animal is not found.
     */
    public List<Vaccination> showMedicalActsOnAnimal(
        String idAnimal) throws UnknownAnimalException {

        Animal animal = findAnimal(idAnimal);
        return animal.showMedicalActsOnAnimal();
    }


    /**
     * Provides a list of wrong vaccinations administrated in the
     * hotel, ordered by administration data.
     * @return a list of wrong vaccinations administrated in
     * the hotel.
     */
    public List<Vaccination> showWrongVaccinations() {
        return _vaccinations.stream()
            .filter(new WrongVaccinationSelector())
            .collect(Collectors.toList());
    }


    /**
     * Read text input file and create domain entities.
     *
     * @param filename name of the text input file
     * @throws ImportFileException
     */
    void importFile(String filename) throws ImportFileException {
	    try (BufferedReader rd = new BufferedReader(
            new BufferedReader(new FileReader(filename)))) {

            String line;
            while((line = rd.readLine()) != null) {
                String[] fields = line.split("\\|");

                try { registerEntry(fields); }
                catch ( UnknownSpeciesException |
                        UnknownTreeException |
                        UnknownHabitatException |
                        DuplicateAnimalException |
                        DuplicateEmployeeException |
                        DuplicateHabitatException |
                        DuplicateTreeException |
                        DuplicateVaccineException |
                        DuplicateSpeciesNameCoreException |
                        UnrecognizedEntryException  e) {
                    throw new ImportFileException(filename, e);
                }
            }
        }
        catch (IOException e) {
            throw new ImportFileException(filename, e);
        }
    }


    /**
     * Registers an entry based on the provided fields.
     *
     * @param fields the fields of the entry.
     * @throws UnknownSpeciesException if the species is not found.
     * @throws UnknownHabitatException if the habitat is not found.
     * @throws UnknownTreeException if the tree is not found.
     * @throws DuplicateAnimalException if an animal with
     * the same ID already exists.
     * @throws DuplicateEmployeeException if an employee with
     * the same ID already exists.
     * @throws DuplicateHabitatException if a habitat with
     * the same ID already exists.
     * @throws DuplicateTreeException if a tree with the
     * same ID already exists.
     * @throws DuplicateVaccineException if a vaccine with
     * the same ID already exists.
     * @throws DuplicateSpeciesNameCoreException if a species with
     * the same name already exists.
     * @throws UnrecognizedEntryException if the entry type
     * is unrecognized.
     */
    private void registerEntry(String... fields)
        throws UnknownSpeciesException, UnknownHabitatException,
        UnknownTreeException, DuplicateAnimalException,
        DuplicateEmployeeException, DuplicateHabitatException,
        DuplicateTreeException, DuplicateVaccineException,
        DuplicateSpeciesNameCoreException, UnrecognizedEntryException{

        switch (fields[0]) {
            case "ESPÉCIE" -> registerSpecies(fields);
            case "ANIMAL" -> registerAnimal(fields);
            case "HABITAT" -> registerHabitatWithTrees(fields);
            case "ÁRVORE" -> registerTree(fields);
            case "TRATADOR", "VETERINÁRIO" ->
                registerEmployeeWithResponsibilities(fields);
            case "VACINA" -> registerVaccine(fields);
            default ->
                throw new UnrecognizedEntryException(fields[0]);
        }
    }


    /**
     * Registers a species based on the provided fields.
     *
     * @param fields the fields of the species.
     * @throws DuplicateSpeciesNameCoreException if a species with
     * the same name already exists.
     */
    public void registerSpecies(String... fields)
        throws DuplicateSpeciesNameCoreException {

        Species species = new Species(fields[1], fields[2]);
        addSpecies(species);
        changed();
    }


    /**
     * Registers an habitat based on the provided fields and adds
     * trees to it.
     *
     * @param fields the fields of the habitat.
     * @throws UnknownTreeException if a tree is not
     * found in the hotel.
     * @throws DuplicateTreeException if a tree with
     * the same ID already exists in a habitat.
     * @throws DuplicateHabitatException if a habitat with
     * the same ID already exists.
     */
    public void registerHabitatWithTrees(String... fields)
        throws UnknownTreeException, DuplicateTreeException,
        DuplicateHabitatException {

        Habitat habitat = new Habitat(fields[1], fields[2],
            Integer.parseInt(fields[3]));

        if (fields.length > 4) {
            addTreesToHabitat(habitat, fields[4]);
        }
        addHabitat(habitat);
        changed();
    }


    /**
     * Registers a habitat based on the provided fields.
     *
     * @param fields the fields of the habitat.
     * @throws DuplicateHabitatException if a habitat with
     * the same ID already exists.
     */
    public void registerHabitat(String... fields)
        throws DuplicateHabitatException{

        try {
            registerHabitatWithTrees(fields);
        }
        catch (UnknownTreeException | DuplicateTreeException e) {
            // never happens
            e.printStackTrace();
        }
    }


    /**
     * Adds trees to a habitat based on the provided tree IDs.
     *
     * @param habitat the habitat to add trees to.
     * @param treesField the field containing tree IDs.
     * @throws UnknownTreeException if a tree is not found
     * in the hotel.
     * @throws DuplicateTreeException if a tree with
     * the same ID already exists in a habitat.
     */
    public void addTreesToHabitat(Habitat habitat, String treesField)
        throws UnknownTreeException, DuplicateTreeException {

        String[] idsTrees = treesField.split(",");
        for (String idTree : idsTrees) {
            try {
                findTreeInHabitats(idTree);
                throw new DuplicateTreeException();
            }
            catch (UnknownTreeException e) {
                Tree tree = findTree(idTree);
                habitat.addTree(tree);
            }
        }
    }


    /**
     * Changes the influence of a species in a habitat.
     *
     * @param habitatKey the ID of the habitat.
     * @param speciesKey the ID of the species.
     * @param habitatInfluence the new influence of the species.
     * @throws UnknownHabitatException if the habitat is not found.
     * @throws UnknownSpeciesException if the species is not found.
     */
    public void changeHabitatInfluence(String habitatKey,
        String speciesKey, String habitatInfluence)
        throws UnknownHabitatException, UnknownSpeciesException {

        Habitat habitat = findHabitat(habitatKey);
        Species species = findSpecies(speciesKey);
        habitat.changeSpeciesInfluence(species, habitatInfluence);
        changed();
    }


    /**
     * Adds a tree to a habitat based on the provided fields.
     *
     * @param fields the fields of the tree.
     * @return the tree added to the habitat.
     * @throws DuplicateTreeException if a tree with
     * the same ID already exists.
     * @throws UnknownHabitatException if the habitat is not found.
     * @throws UnrecognizedEntryException if the tree type
     * is unrecognized.
     * @throws UnknownTreeException if the tree is not found.
     */
    public Tree addTreeToHabitat(String... fields)
        throws DuplicateTreeException, UnknownHabitatException,
        UnrecognizedEntryException, UnknownTreeException {

        registerTree(fields);
        return findTree(fields[1]);
    }


    /**
     * Registers an animal based on the provided fields.
     *
     * @param fields the fields of the animal.
     * @throws UnknownSpeciesException if the species is not found.
     * @throws UnknownHabitatException if the habitat is not found.
     * @throws DuplicateAnimalException if an animal with
     * the same ID already exists.
     */
    public void registerAnimal(String... fields)
        throws UnknownSpeciesException, UnknownHabitatException,
        DuplicateAnimalException {

        Habitat habitat = findHabitat(fields[4]);
        Species species = findSpecies(fields[3]);
        Animal animal = new Animal (fields[1], fields[2], species,
            habitat);

        addAnimal(animal);
        habitat.addAnimal(animal);
        species.addAnimal(animal);
        changed();
    }


    /**
     * Registers a tree based on the provided fields.
     *
     * @param fields the fields of the tree.
     * @throws DuplicateTreeException if a tree with
     * the same ID already exists.
     * @throws UnknownHabitatException if the habitat is not found.
     * @throws UnrecognizedEntryException if the tree type
     * is unrecognized.
     */
    public void registerTree(String... fields)
        throws DuplicateTreeException, UnknownHabitatException,
        UnrecognizedEntryException {

        Tree tree = createTree(fields);
        try {
            findTree(fields[1]);
            // If the tree is found, it is a duplicate
            throw new DuplicateTreeException();
        }
        catch (UnknownTreeException e) {
            if (fields.length > 6) {
                Habitat habitat = findHabitat(fields[6]);
                habitat.addTree(tree);
            }
            addTree(tree);
            changed();
        }
    }


    /**
     * Creates a tree based on the provided fields.
     *
     * @param fields the fields of the tree.
     * @return the created Tree object.
     * @throws UnrecognizedEntryException if the tree type
     * is unrecognized.
     */
    public Tree createTree(String... fields)
        throws UnrecognizedEntryException {

        int age = Integer.parseInt(fields[3]);
        double baseCleanDifficulty = Double.parseDouble(fields[4]);
        Tree tree;
        switch (fields[5]) {
            case "PERENE":
                tree = new Evergreen(fields[1], fields[2], age,
                    baseCleanDifficulty, getSeason());

                break;
            case "CADUCA":
                tree = new Deciduous(fields[1], fields[2], age,
                    baseCleanDifficulty, getSeason());

                break;
            default:
                throw new UnrecognizedEntryException(fields[5]);
        }
        return tree;
    }


    /**
     * Registers an employee based on the provided fields.
     *
     * @param fields the fields of the employee.
     * @throws UnknownSpeciesException if the species is not found.
     * @throws UnknownHabitatException if the habitat is not found.
     * @throws DuplicateEmployeeException if an employee with
     * the same ID already exists.
     * @throws UnrecognizedEntryException if the employee type
     * is unrecognized.
     */
    public void registerEmployeeWithResponsibilities(String... fields)
        throws UnknownSpeciesException, UnknownHabitatException,
        DuplicateEmployeeException, UnrecognizedEntryException {

        String[] idsResponsibilities = (fields.length > 3) ?
            fields[3].split(",") : new String[0];

        Employee employee;
        switch (fields[0]) {
            case "VETERINÁRIO", "VET":
                employee = new Veterinarian(fields[1], fields[2]);
                importResponsibilities(idsResponsibilities,
                    (Veterinarian) employee);

                break;
            case "TRATADOR", "TRT":
                employee = new Keeper(fields[1], fields[2]);
                importResponsibilities(idsResponsibilities,
                    (Keeper) employee);

                break;
            default:
                throw new UnrecognizedEntryException(fields[0]);
        }
        addEmployee(employee);
        changed();
    }


    /**
     * Registers an employee based on the provided fields.
     *
     * @param fields the fields of the employee.
     * @throws DuplicateEmployeeException if an employee with
     * the same ID already exists.
     */
    public void registerEmployee(String... fields)
        throws DuplicateEmployeeException {

        try {
            registerEmployeeWithResponsibilities(fields);
        }
        catch (UnknownSpeciesException | UnknownHabitatException |
            UnrecognizedEntryException e) {
            // never happens
            e.printStackTrace();
        }
    }


    /**
     * Assigns responsibilities to a veterinarian
     * based on the provided species IDs.
     *
     * @param idsResponsibilities The species IDs to assign
     * @param vet The veterinarian to whom the
     * responsibilities are assigned.
     * @throws UnknownSpeciesException If a species ID does
     * not correspond to a known species.
     */
    public void importResponsibilities(String[] idsResponsibilities,
        Veterinarian vet) throws UnknownSpeciesException {

        for (String idResponsibility : idsResponsibilities) {
            Species species = findSpecies(idResponsibility);
            vet.assignResponsibility(species, idResponsibility);
            species.addResponsibleVet(vet);
        }
    }


    /**
     * Assigns responsibilities to a keeper
     * based on the provided habitat IDs.
     *
     * @param idsResponsibilities The habitat IDs to assign
     * @param keeper The keeper to whom the
     * responsibilities are assigned.
     * @throws UnknownHabitatException If a habitat ID does
     * not correspond to a known habitat.
     */
    public void importResponsibilities(String[] idsResponsibilities,
        Keeper keeper) throws UnknownHabitatException {

        for (String idResponsibility : idsResponsibilities) {
            Habitat habitat = findHabitat(idResponsibility);
            keeper.assignResponsibility(habitat, idResponsibility);
            habitat.addKeeper(keeper);
        }
    }


    /**
     * Assigns a responsibility to an employee.
     *
     * @param idEmployee The ID of the employee.
     * @param idResponsibility The ID of the responsibility.
     * @throws UnknownEmployeeException If the employee is not found.
     * @throws NoResponsibilityCoreException If the responsibility.
     */
    public void addResponsibility(String idEmployee,
        String idResponsibility) throws UnknownEmployeeException,
        NoResponsibilityCoreException {

        try {
            Employee employee = findEmployee(idEmployee);

            if (employee instanceof Veterinarian) {
                Species species = findSpecies(idResponsibility);
                ((Veterinarian) employee).assignResponsibility
                    (species, idResponsibility);
                species.addResponsibleVet((Veterinarian) employee);
            }
            if (employee instanceof Keeper) {
                Habitat habitat = findHabitat(idResponsibility);
                ((Keeper) employee).assignResponsibility(habitat,
                    idResponsibility);
                habitat.addKeeper((Keeper) employee);
            }
        }
        catch (UnknownEmployeeException e) {
            throw new UnknownEmployeeException();
        } catch (UnknownSpeciesException | UnknownHabitatException e){
            throw new NoResponsibilityCoreException();
        }
        changed();
    }


    /**
     * Removes a responsibility from an employee.
     *
     * @param idEmployee The ID of the employee.
     * @param idResponsibility The ID of the responsibility.
     * @throws UnknownEmployeeException If the employee is not found.
     * @throws NoResponsibilityCoreException If the responsibility.
     */
    public void removeResponsibility(String idEmployee,
        String idResponsibility) throws UnknownEmployeeException,
        NoResponsibilityCoreException {

        try {
            Employee employee = findEmployee(idEmployee);

            if (employee instanceof Veterinarian) {
                Species species = findSpecies(idResponsibility);
                ((Veterinarian) employee).unassignResponsibility
                    (species, idResponsibility);
                species.removeResponsibleVet((Veterinarian) employee);
            }
            if (employee instanceof Keeper) {
                Habitat habitat = findHabitat(idResponsibility);
                ((Keeper) employee).unassignResponsibility(habitat,
                    idResponsibility);
                habitat.removeKeeper((Keeper) employee);
            }
        } catch (UnknownEmployeeException e) {
            throw new UnknownEmployeeException();
        } catch (UnknownSpeciesException | UnknownHabitatException e){
            throw new NoResponsibilityCoreException();
        }
        changed();
    }


    /**
     * Registers a vaccine based on the provided fields.
     *
     * @param fields the fields of the vaccine.
     * @throws DuplicateVaccineException if a vaccine with
     * the same ID already exists.
     * @throws UnknownSpeciesException if the species is not found.
     */
    public void registerVaccine(String... fields)
        throws DuplicateVaccineException, UnknownSpeciesException {

        TreeMap<String,Species> targetSpecies =
            new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        if (fields.length > 3) {
            String[] idsSpecies = fields[3].split(",");
            for (String idSpecies: idsSpecies) {
                idSpecies = idSpecies.trim(); // Ignore whitespaces
                Species species = findSpecies(idSpecies);
                targetSpecies.put(species.getIdSpecies(), species);
            }
        }
        Vaccine vaccine = new Vaccine(fields[1], fields[2],
            targetSpecies);

        addVaccine(vaccine);
        changed();
    }


    /**
     * Finds a species by its ID.
     *
     * @param idSpecies the ID of the species.
     * @return the species.
     * @throws UnknownSpeciesException if the species is not found.
     */
    public Species findSpecies(String idSpecies)
        throws UnknownSpeciesException {

        Species species = _species.get(idSpecies);
        if (species == null) {
            throw new UnknownSpeciesException(idSpecies);
        }
        return species;
    }


    /**
     * Finds an animal by its ID.
     *
     * @param idAnimal the ID of the animal.
     * @return the animal.
     * @throws UnknownAnimalException if the animal is not found.
     */
    public Animal findAnimal(String idAnimal)
        throws UnknownAnimalException {

        Animal animal = _animals.get(idAnimal);
        if (animal == null) {
            throw new UnknownAnimalException();
        }
        return animal;
    }


    /**
     * Finds a habitat by its ID.
     *
     * @param idHabitat the ID of the habitat.
     * @return the habitat.
     * @throws UnknownHabitatException if the habitat is not found.
     */
    public Habitat findHabitat(String idHabitat)
        throws UnknownHabitatException {

        Habitat habitat = _habitats.get(idHabitat);
        if (habitat == null) {
            throw new UnknownHabitatException();
        }
        return habitat;
    }


    /**
     * Finds an employee by its ID.
     *
     * @param idEmployee the ID of the employee.
     * @return the employee.
     * @throws UnknownEmployeeException if the employee is not found.
     */
    public Employee findEmployee(String idEmployee)
        throws UnknownEmployeeException {

        Employee employee = _employees.get(idEmployee);
        if (employee == null) {
            throw new UnknownEmployeeException();
        }
        return employee;
    }


    /**
     * Finds a veterinarian by its ID.
     *
     * @param idVet the ID of the veterinarian.
     * @return the veterinarian.
     * @throws UnknownVeterinarianException if the veterinarian
     * is not found.
     */
    public Veterinarian findVeterinarian(String idVet)
        throws UnknownVeterinarianException {

        Employee employee;
        try {
            employee = findEmployee(idVet);
        }
        catch (UnknownEmployeeException e) {
            throw new UnknownVeterinarianException();
        }

        if (!(employee instanceof Veterinarian vet)) {
            throw new UnknownVeterinarianException();
        }
        return vet;
    }


    /**
     * Finds a vaccine by its ID.
     *
     * @param idVaccine the ID of the vaccine.
     * @return the vaccine.
     * @throws UnknownVaccineException if the vaccine is not found.
     */
    public Vaccine findVaccine(String idVaccine)
        throws UnknownVaccineException {

        Vaccine vaccine = _vaccines.get(idVaccine);
        if (vaccine == null) {
            throw new UnknownVaccineException();
        }
        return vaccine;
    }


    /**
     * Finds a tree in the hotel (habitat and more) by its ID.
     *
     * @param idTree The ID of the tree to be found.
     * @return The tree corresponding to the given ID.
     * @throws UnknownTreeException If the tree cannot be
     * found in the hotel.
     */
    public Tree findTree(String idTree)
        throws UnknownTreeException {
        Tree tree = _trees.get(idTree);
        if (tree == null) {
            throw new UnknownTreeException();
        }
        return tree;
    }


    /**
     * Finds a tree in all habitats by its ID.
     *
     * @param idTree The ID of the tree to be found.
     * @return The tree corresponding to the given ID.
     * @throws UnknownTreeException If the tree cannot be
     * found in any of the habitats.
     */
    public Tree findTreeInHabitats(String idTree)
        throws UnknownTreeException {

        for (Habitat habitat : _habitats.values()) {
            try { return habitat.findTreeInHabitat(idTree); }
            catch (UnknownTreeException e) {
                // Continue searching in the next habitat
            }
        }
        throw new UnknownTreeException();
    }
}
