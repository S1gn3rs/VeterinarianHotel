package hva.employees.satisfactions;

import java.io.Serial;
import java.io.Serializable;
import hva.employees.Keeper;


/**
 * Keepers have a satisfaction that can be calculated.
 */
public abstract class KeeperSatisfaction implements Serializable {

    /** KeeperSatisfaction's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410231956L;

    /**
     * Calculates the satisfaction of the given keeper.
     *
     * @param animal the keeper whose satisfaction is to be calculated
     * @return the satisfaction of the keeper
     */
    public abstract double getSatisfaction(Keeper keeper);
}
