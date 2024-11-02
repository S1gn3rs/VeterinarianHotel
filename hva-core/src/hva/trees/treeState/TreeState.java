package hva.trees.treeState;

import java.io.Serial;
import java.io.Serializable;
import hva.trees.Tree;


/**
 * The TreeState class represents a tree state with a seasonal age,
 * a biologic cycle, and a seasonal effort.
 */
public abstract class TreeState implements Serializable {

    /** TreeState's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410231727L;

    /** TreeState's seasonal age. */
    private int _seasonalAge;


    /**
     * Constructs a new TreeState.
     *
     * @param seasonalAge TreeState's seasonal age.
     */
    public TreeState(int seasonalAge) {
        _seasonalAge = seasonalAge;
    }


    /**
     * @return TreeState's seasonal age.
     */
    public int getSeasonalAge() {
        return _seasonalAge;
    }


    /**
     * @return TreeState's biologic cycle.
     */
    public abstract BiologicCycle biologicCycle();


    /**
     * @return TreeState's seasonal effort.
     */
    public abstract SeasonalEffort seasonalEffort();


    /**
     * @param tree Tree to change state.
     */
    public abstract void next(Tree tree);

}
