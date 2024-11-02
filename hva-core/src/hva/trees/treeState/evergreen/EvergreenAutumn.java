package hva.trees.treeState.evergreen;

import java.io.Serial;
import hva.trees.Evergreen;
import hva.trees.Tree;
import hva.trees.treeState.BiologicCycle;
import hva.trees.treeState.SeasonalEffort;
import hva.trees.treeState.TreeState;

/**
 * The EvergreenAutumn class represents an evergreen tree state
 * in autumn.
 */
public class EvergreenAutumn extends TreeState {

    /** EvergreenAutumn's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410231739L;


    /**
     * Constructs a new EvergreenAutumn.
     *
     * @param seasonalAge EvergreenAutumn's seasonal age.
     */
    public EvergreenAutumn(int seasonalAge) {
        super(seasonalAge);
    }


    /**
     * @return Evergreen autumn's biologic cycle.
     */
    @Override
    public BiologicCycle biologicCycle() {
        return BiologicCycle.COMFOLHAS;
    }


    /**
     * @return Evergreen autumn's seasonal effort.
     */
    @Override
    public SeasonalEffort seasonalEffort() {
        return SeasonalEffort.ONE;
    }


    /**
     * Changes the tree state to the next season.
     * EvergreenAutumn -> EvergreenWinter
     *
     * @param tree Tree to change state.
     */
    @Override
    public void next(Tree tree) {
        tree.setTreeState(new EvergreenWinter(getSeasonalAge() + 1));
    }
}
