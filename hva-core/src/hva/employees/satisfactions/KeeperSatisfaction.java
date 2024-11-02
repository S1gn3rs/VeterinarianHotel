package hva.employees.satisfactions;

import java.io.Serial;
import java.io.Serializable;
import hva.employees.Keeper;


public abstract class KeeperSatisfaction implements Serializable {

    @Serial
    private static final long serialVersionUID = 202410231956L;

    public abstract double getSatisfaction(Keeper keeper);
}
