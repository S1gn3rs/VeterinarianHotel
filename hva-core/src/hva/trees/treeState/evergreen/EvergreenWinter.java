package hva.trees.treeState.evergreen;

import hva.trees.Tree;
import java.io.Serial;
import hva.trees.Evergreen;
import hva.trees.treeState.BiologicCycle;
import hva.trees.treeState.SeasonalEffort;
import hva.trees.treeState.TreeState;


/**
 * The EvergreenWinter class represents an evergreen tree state
 * in winter.
 */
public class EvergreenWinter extends TreeState {

    /** EvergreenWinter's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410231742L;


    /**
     * Constructs a new EvergreenWinter.
     *
     * @param seasonalAge EvergreenWinter's seasonal age.
     */
    public EvergreenWinter(int seasonalAge) {
        super(seasonalAge);
    }


    /**
     * @return Evergreen winter's biologic cycle.
     */
    @Override
    public BiologicCycle biologicCycle() {
        return BiologicCycle.LARGARFOLHAS;
    }


    /**
     * @return Evergreen winter's seasonal effort.
     */
    @Override
    public SeasonalEffort seasonalEffort() {
        return SeasonalEffort.TWO;
    }


    /**
     * Changes the tree state to the next season.
     * EvergreenWinter -> EvergreenSpring
     *
     * @param tree Tree to change state.
     */
    @Override
    public void next(Tree tree) {
        tree.setTreeState(new EvergreenSpring(getSeasonalAge() + 1));
    }
}
