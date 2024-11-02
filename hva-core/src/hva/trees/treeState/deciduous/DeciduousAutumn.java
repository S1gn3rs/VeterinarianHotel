package hva.trees.treeState.deciduous;

import hva.trees.Tree;
import java.io.Serial;
import hva.trees.Deciduous;
import hva.trees.treeState.BiologicCycle;
import hva.trees.treeState.SeasonalEffort;
import hva.trees.treeState.TreeState;


/**
 * The DeciduousAutumn class represents a deciduous tree state
 * in autumn.
 */
public class DeciduousAutumn extends TreeState {

    /** DeciduousAutumn's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410231809L;


    /**
     * Constructs a new DeciduousAutumn.
     *
     * @param seasonalAge Deciduous autumn's seasonal age.
     */
    public DeciduousAutumn(int seasonalAge) {
        super(seasonalAge);
    }


    /**
     * @return Deciduous autumn's biologic cycle.
     */
    @Override
    public BiologicCycle biologicCycle() {
        return BiologicCycle.LARGARFOLHAS;
    }


    /**
     * @return Deciduous autumn's seasonal effort.
     */
    @Override
    public SeasonalEffort seasonalEffort() {
        return SeasonalEffort.FIVE;
    }


    /**
     * Changes the tree state to the next season.
     * DeciduousAutumn -> DeciduousWinter
     *
     * @param tree Tree to change state.
     */
    @Override
    public void next(Tree tree) {
        tree.setTreeState(new DeciduousWinter(getSeasonalAge() + 1));
    }
}
