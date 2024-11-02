package hva.search.comparators;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;
import hva.trees.Tree;


/**
 * Compares two trees lexicographically by their IDs,
 * without distinction between uppercase and lowercase.
 */
public class IdTreeComparator implements Comparator<Tree>,
    Serializable {

    /** IdTreeComparator's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410241459L;


    /**
     * Compares two trees lexicographically by their IDs,
     * without distinction between uppercase and lowercase.
     *
     * @param t1 the first tree to be compared
     * @param t2 the second tree to be compared
     * @return a negative int, zero, or a positive int as the first
     * argument is less than, equal to, or greater than the second
     */
    @Override
    public int compare(Tree t1, Tree t2) {
        return t1.getIdTree().toLowerCase().compareTo
            (t2.getIdTree().toLowerCase());
    }
}
