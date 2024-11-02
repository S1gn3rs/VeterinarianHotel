package hva.employees.satisfactions;

import hva.habitats.Habitat;
import java.io.Serial;
import hva.employees.Keeper;


public class KeeperWorkLoadSatisfaction  extends KeeperSatisfaction {

    @Serial
    private static final long serialVersionUID = 202410232001L;


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

