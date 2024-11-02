package hva.trees;

import java.io.Serial;
import hva.seasons.*;
import hva.trees.treeState.TreeState;
import hva.trees.treeState.deciduous.DeciduousAutumn;
import hva.trees.treeState.deciduous.DeciduousSpring;
import hva.trees.treeState.deciduous.DeciduousSummer;
import hva.trees.treeState.deciduous.DeciduousWinter;


/**
 * The Deciduous class represents a type of tree with
 * specific seasonal effort depending on the season.
 */
public class Deciduous extends Tree {

    /** Deciduous's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410091913L;


    /**
     * Constructs a new Deciduous tree.
     *
     * @param idTree Tree's ID.
     * @param name Tree's name.
     * @param age Tree's age.
     * @param baseCleanDifficulty Tree's base cleaning difficulty.
     */
    public Deciduous(String idTree, String name, int age,
        double baseCleanDifficulty, Season season) {

        super(idTree, name, baseCleanDifficulty);
        int seasonalAge = age * 4; // 1 year = 4 seasons
        switch (season.getIndex()) {
            case SPRING_INDEX ->
                setTreeState(new DeciduousSpring(seasonalAge));
            case SUMMER_INDEX ->
                setTreeState(new DeciduousSummer(seasonalAge));
            case AUTUMN_INDEX ->
                setTreeState(new DeciduousAutumn(seasonalAge));
            case WINTER_INDEX ->
                setTreeState(new DeciduousWinter(seasonalAge));
        };
    }


    /**
     * Deciduous tree information in the format:
     * "ÁRVORE|idTree|name|age|baseCleanDiffic.|CADUCA|biologicCycle"
     *
     * @return String with the Deciduous tree's information.
     */
    @Override
    public String toString() {
        return super.toString() + "CADUCA|" +
        getBiologicCycle();
    }
}
