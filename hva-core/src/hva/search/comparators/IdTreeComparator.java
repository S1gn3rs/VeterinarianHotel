package hva.search.comparators;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;
import hva.trees.Tree;


public class IdTreeComparator implements Comparator<Tree>,
    Serializable {

    @Serial
    private static final long serialVersionUID = 202410241459L;


    @Override
    public int compare(Tree t1, Tree t2) {
        return t1.getIdTree().toLowerCase().compareTo
            (t2.getIdTree().toLowerCase());
    }
}
