package hva.trees;

import hva.seasons.Season;
import hva.trees.treeState.TreeState;
import java.io.Serial;
import java.io.Serializable;


/**
 * The Tree class represents a tree with a unique ID,
 * name, age base cleaning difficulty and biologic cycle.
 */
public abstract class Tree implements Serializable {

    /** Tree's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410091915L;

    /** Tree's identifier. */
    private final String _idTree;

    /** Tree's name. */
    private String _name;

    /** Tree's base cleaning difficulty. */
    private double _baseCleanDifficulty;

    /** Tree's state. */
    private TreeState _state;


    /**
     * Constructs a new Tree.
     *
     * @param idTree Tree's ID.
     * @param name Tree's name.
     * @param age Tree's age.
     * @param baseCleanDifficulty Tree's base cleaning difficulty.
     */
    public Tree(String idTree, String name,
        double baseCleanDifficulty) {

        _idTree = idTree;
        _name = name;
        _baseCleanDifficulty = baseCleanDifficulty;
    }


    /**
     * @param state Tree's state.
     */
    public void setTreeState(TreeState state) {
        _state = state;
    }


    /**
     * @return Tree's ID.
     */
    public String getIdTree() { return _idTree; }


    /**
     * @return Tree's name.
     */
    public String getName() { return _name; }


    /**
     * @return Tree's age in years.
     */
    public int age() {
        return _state.getSeasonalAge() / 4; // 1 year = 4 seasons
    }


    /**
     * @return Tree's base cleaning difficulty.
     */
    public double getBaseCleanDifficulty() {
        return _baseCleanDifficulty;
    }


    /**
     * @return Tree's biologic cycle.
     */
    public String getBiologicCycle() {
        return _state.biologicCycle().toString();
    }


    /**
     * Defines the seasonal effort required to clean the tree.
     *
     * @return int representing the seasonal effort required.
     */
    public int seasonalEffort() {
        return _state.seasonalEffort().getValue();
    }


    /**
     * Changes the tree's state to the next one.
     */
    public void nextState() {
        _state.next(this);
    }


    /**
     * Calculates the effort required to
     * clean the tree at a given season.
     *
     * @return Cleaning effort required to clean the tree.
     */
    public double cleaningEffort() {
        return getBaseCleanDifficulty()
            * seasonalEffort()
            * (Math.log(age() + 1));
    }


    /**
     * Tree's information in the format:
     * "ÁRVORE|idTree|name|age|baseCleanDifficulty|"
     *
     * @return String with the Tree's information.
     */
    @Override
    public String toString() {
        return "ÁRVORE|" + getIdTree() +
        "|" + getName() +
        "|" + age() +
        "|" + (int) getBaseCleanDifficulty() +
        "|" ;
    }
}
