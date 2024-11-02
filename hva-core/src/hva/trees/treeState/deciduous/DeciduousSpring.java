package hva.trees.treeState.deciduous;

import hva.trees.Tree;
import java.io.Serial;
import hva.trees.Deciduous;
import hva.trees.treeState.BiologicCycle;
import hva.trees.treeState.SeasonalEffort;
import hva.trees.treeState.TreeState;


/**
 * The DeciduousSpring class represents a deciduous tree state
 * in spring.
 */
public class DeciduousSpring extends TreeState {

    /** DeciduousSpring's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410231808L;


    /**
     * Constructs a new DeciduousSpring.
     *
     * @param seasonalAge Deciduous spring's seasonal age.
     */
    public DeciduousSpring(int seasonalAge) {
        super(seasonalAge);
    }


    /**
     * @return Deciduous spring's biologic cycle.
     */
    @Override
    public BiologicCycle biologicCycle() {
        return BiologicCycle.GERARFOLHAS;
    }


    /**
     * @return Deciduous spring's seasonal effort.
     */
    @Override
    public SeasonalEffort seasonalEffort() {
        return SeasonalEffort.ONE;
    }


    /**
     * Changes the tree state to the next season.
     * DeciduousSpring -> DeciduousSummer
     *
     * @param tree Tree to change state.
     */
    @Override
    public void next(Tree tree) {
        tree.setTreeState(new DeciduousSummer(getSeasonalAge() + 1));
    }
}
