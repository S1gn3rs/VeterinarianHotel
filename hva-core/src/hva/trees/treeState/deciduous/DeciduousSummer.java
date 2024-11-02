package hva.trees.treeState.deciduous;

import java.io.Serial;

import hva.trees.Deciduous;
import hva.trees.Tree;
import hva.trees.treeState.BiologicCycle;
import hva.trees.treeState.SeasonalEffort;
import hva.trees.treeState.TreeState;

/**
 * The DeciduousSummer class represents a deciduous tree state
 * in summer.
 */
public class DeciduousSummer extends TreeState {

    /** DeciduousSummer's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410231820L;


    /**
     * Constructs a new DeciduousSummer.
     *
     * @param seasonalAge Deciduous summer's seasonal age.
     */
    public DeciduousSummer(int seasonalAge) {
        super(seasonalAge);
    }


    /**
     * @return Deciduous summer's biologic cycle.
     */
    @Override
    public BiologicCycle biologicCycle() {
        return BiologicCycle.COMFOLHAS;
    }


    /**
     * @return Deciduous summer's seasonal effort.
     */
    @Override
    public SeasonalEffort seasonalEffort() {
        return SeasonalEffort.TWO;
    }

    /**
     * Changes the tree state to the next season.
     * DeciduousSummer -> DeciduousAutumn
     *
     * @param tree Tree to change state.
     */
    @Override
    public void next(Tree tree) {
        tree.setTreeState(new DeciduousAutumn(getSeasonalAge() + 1));
    }
}

