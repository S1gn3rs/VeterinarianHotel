package hva.trees.treeState.deciduous;

import java.io.Serial;
import hva.trees.Deciduous;
import hva.trees.Tree;
import hva.trees.treeState.BiologicCycle;
import hva.trees.treeState.SeasonalEffort;
import hva.trees.treeState.TreeState;


/**
 * The DeciduousWinter class represents a deciduous tree state
 * in winter.
 */
public class DeciduousWinter extends TreeState {

    /** DeciduousWinter's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410231738L;


    /**
     * Constructs a new DeciduousWinter.
     *
     * @param seasonalAge Deciduous winter's seasonal age.
     */
    public DeciduousWinter(int seasonalAge) {
        super(seasonalAge);
    }


    /**
     * @return Deciduous winter's biologic cycle.
     */
    @Override
    public BiologicCycle biologicCycle() {
        return BiologicCycle.SEMFOLHAS;
    }


    /**
     * @return Deciduous winter's seasonal effort.
     */
    @Override
    public SeasonalEffort seasonalEffort() {
        return SeasonalEffort.ZERO;
    }


    /**
     * Changes the tree state to the next season.
     * DeciduousWinter -> DeciduousSpring
     *
     * @param tree Tree to change state.
     */
    @Override
    public void next(Tree tree) {
        tree.setTreeState(new DeciduousSpring(getSeasonalAge() + 1));
    }
}
