package hva.vaccines;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import hva.animals.Animal;
import hva.animals.Species;
import hva.vaccines.Damage;
import hva.vaccines.Vaccination;
import java.io.Serial;
import java.io.Serializable;


/**
 * The Vaccine class represents a vaccine with a unique ID, a name,
 * a list of target species, and a list of vaccinations.
 */
public class Vaccine implements Serializable {

    /** Vaccine's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410091917L;

    /** Vaccine's identifier. */
    private final String _idVaccine;

    /** Vaccine's name. */
    private String _name;

    /** Vaccine's target species. */
    private Map<String,Species> _targetSpecies =
        new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    /** Vaccine's record of vaccinations. */
    private Set<Vaccination> _vaccinations =
        new HashSet<Vaccination>();


    /**
     * Constructs a new Vaccine.
     *
     * @param idVaccine Vaccine's ID.
     * @param name Vaccine's name.
     * @param species Vaccine's target species.
     */
    public Vaccine(String idVaccine, String name,
        TreeMap<String,Species> species) {

        _idVaccine = idVaccine;
        _name = name;
        _targetSpecies = species;
    }


    /**
     * @return Vaccine's ID.
     */
    public String getIdVaccine() { return _idVaccine;}


    /**
     * @return Vaccine's name.
     */
    public String getName() { return _name;}


    /**
     * Determines the damage caused by the vaccine to a given species.
     *
     * @param species the species to check
     * @return damage caused by the vaccine
     */
    public Damage calculateDamage(Species species) {
        int max = 0;
        int damage = 0;
        String speciesName = species.getName();
        if (_targetSpecies.get(species.getIdSpecies()) != null)
            return Damage.NORMAL;

        // Case of vaccine not apropriated for any species
        if (_targetSpecies.size() == 0)
            damage = speciesName.length();

        for (Species targetSpecies : _targetSpecies.values()) {
            String targetName = targetSpecies.getName();
            damage = namesSize(speciesName, targetName) -
                commonChars(speciesName, targetName);

            if (damage > max)
                max = damage;
        }
        if (damage == 0) return Damage.CONFUSÃO;
        if (damage >= 1 && damage < 5) return Damage.ACIDENTE;
        return Damage.ERRO;
    }


    /**
     * Calculates the maximum length of two strings.
     *
     * @param s1 the string
     * @param s2 the string
     * @return the maximum length of the two strings
     */
    public int namesSize(String s1, String s2) {
        return Math.max(s1.length(), s2.length());
    }


    /**
     * Calculates the number of common characters
     * between two strings.
     *
     * @param s1 the first string
     * @param s2 the second string
     * @return the number of common characters
     * between two strings
     */
    public int commonChars(String s1, String s2) {
        int count = 0;
        char[] str2Chars = s2.toCharArray();

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);

            for (int j = 0; j < str2Chars.length; j++) {
                if (c1 == str2Chars[j]) {
                    count++;
                    str2Chars[j] = 0; // Mark character as used
                    break;
                }
            }
        }
        return count;
    }


    /**
     * Adds a vaccination record to the vaccine.
     *
     * @param vaccination the vaccination record to add
     */
    public void addVaccination(Vaccination vaccination) {
        _vaccinations.add(vaccination);
    }


    /**
     * Vaccine's information in the format:
     * "VACINA|idVaccine|name|numberOfVaccinations|idSpecies1,..."
     *
     * @return String with the vaccine's information.
     */
    @Override
    public String toString() {
        String str = "VACINA|" + getIdVaccine() +
        "|" + getName() +
        "|" + _vaccinations.size();

        if (_targetSpecies.size() > 0) {
            str += "|";
            for (Species species : _targetSpecies.values()) {
                str += species.getIdSpecies() + ",";
            }
            // remove last comma
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}
