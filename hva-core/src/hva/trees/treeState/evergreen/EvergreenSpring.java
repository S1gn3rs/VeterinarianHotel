package hva.trees.treeState.evergreen;

import hva.trees.Tree;
import java.io.Serial;
import hva.trees.Evergreen;
import hva.trees.treeState.BiologicCycle;
import hva.trees.treeState.SeasonalEffort;
import hva.trees.treeState.TreeState;


/**
 * The EvergreenSpring class represents an evergreen tree state
 * in spring.
 */
public class EvergreenSpring extends TreeState {

    /** EvergreenSpring's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410231740L;


    /**
     * Constructs a new EvergreenSpring.
     *
     * @param seasonalAge EvergreenSpring's seasonal age.
     */
    public EvergreenSpring(int seasonalAge) {
        super(seasonalAge);
    }


    /**
     * @return Evergreen spring's biologic cycle.
     */
    @Override
    public BiologicCycle biologicCycle() {
        return BiologicCycle.GERARFOLHAS;
    }


    /**
     * @return Evergreen spring's seasonal effort.
     */
    @Override
    public SeasonalEffort seasonalEffort() {
        return SeasonalEffort.ONE;
    }

    /**
     * Changes the tree state to the next season.
     * EvergreenSpring -> EvergreenSummer
     *
     * @param tree Tree to change state.
     */
    @Override
    public void next(Tree tree) {
        tree.setTreeState(new EvergreenSummer(getSeasonalAge() + 1));
    }
}
