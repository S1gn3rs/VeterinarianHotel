package hva.employees.satisfactions;

import hva.habitats.Habitat;
import java.io.Serial;
import hva.employees.Keeper;


/**
 * The KeeperWorkLoadSatisfaction class calculates the
 * satisfaction of a keeper based on its workload.
 */
public class KeeperWorkLoadSatisfaction  extends KeeperSatisfaction {

    /** KeeperWorkLoadSatisfaction's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410232001L;


    /**
     * Calculates the satisfaction of the given keeper
     * based on its workload.
     *
     * @param keeper the keeper whose satisfaction is to be calculated
     * @return the satisfaction of the keeper
     */
    @Override
    public double getSatisfaction(Keeper keeper) {
        double totalWork = 0;
        double work;

        for (Habitat habitat : keeper.getResponsibilities()) {
            work = habitat.workInHabitat();
            work /= habitat.numberOfKeepers();
            totalWork += work;
        }
        return 300 - totalWork;
    }
}

