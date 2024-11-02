package hva.trees.treeState.evergreen;

import java.io.Serial;
import hva.trees.Evergreen;
import hva.trees.Tree;
import hva.trees.treeState.BiologicCycle;
import hva.trees.treeState.SeasonalEffort;
import hva.trees.treeState.TreeState;


/**
 * The EvergreenSummer class represents an evergreen tree state
 * in summer.
 */
public class EvergreenSummer extends TreeState {

    /** EvergreenSummer's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410231741L;


    /**
     * Constructs a new EvergreenSummer.
     *
     * @param seasonalAge EvergreenSummer's seasonal age.
     */
    public EvergreenSummer(int seasonalAge) {
        super(seasonalAge);
    }


    /**
     * @return Evergreen summer's biologic cycle.
     */
    @Override
    public BiologicCycle biologicCycle() {
        return BiologicCycle.COMFOLHAS;
    }


    /**
     * @return Evergreen summer's seasonal effort.
     */
    @Override
    public SeasonalEffort seasonalEffort() {
        return SeasonalEffort.ONE;
    }


    /**
     * Changes the tree state to the next season.
     * EvergreenSummer -> EvergreenAutumn
     *
     * @param tree Tree to change state.
     */
    @Override
    public void next(Tree tree) {
        tree.setTreeState(new EvergreenAutumn(getSeasonalAge() + 1));
    }
}
