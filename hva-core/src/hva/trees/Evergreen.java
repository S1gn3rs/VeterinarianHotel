package hva.trees;

import java.io.Serial;
import hva.seasons.*;
import hva.trees.treeState.TreeState;
import hva.trees.treeState.evergreen.EvergreenAutumn;
import hva.trees.treeState.evergreen.EvergreenSpring;
import hva.trees.treeState.evergreen.EvergreenSummer;
import hva.trees.treeState.evergreen.EvergreenWinter;


/**
 * The Evergreen class represents a type of tree with
 * specific seasonal effort depending on the season.
 */
public class Evergreen extends Tree {

    /** Evergreen's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410091914L;


    /**
     * Constructs a new Evergreen tree.
     *
     * @param idTree Tree's ID.
     * @param name Tree's name.
     * @param age Tree's age.
     * @param baseCleanDifficulty Tree's base cleaning difficulty.
     */
    public Evergreen(String idTree, String name, int age,
        double baseCleanDifficulty, Season season) {

        super(idTree, name, baseCleanDifficulty);
        int seasonalAge = age * 4; // 1 year = 4 seasons
        switch (season.getIndex()) {
            case SPRING_INDEX ->
                setTreeState(new EvergreenSpring(seasonalAge));
            case SUMMER_INDEX ->
                setTreeState(new EvergreenSummer(seasonalAge));
            case AUTUMN_INDEX ->
                setTreeState(new EvergreenAutumn(seasonalAge));
            case WINTER_INDEX ->
                setTreeState(new EvergreenWinter(seasonalAge));
        };
    }


    /**
     * Evergreen tree information in the format:
     * "ÁRVORE|idTree|name|age|baseCleanDiffic.|PERENE|biologicCycle"
     *
     * @return String with the Evergreen tree's information.
     */
    @Override
    public String toString() {
        return super.toString() + "PERENE|" +
        getBiologicCycle();
    }
}
