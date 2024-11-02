package hva.trees.treeState;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * Enumerates the possible biologic cycles.
 */
public enum BiologicCycle implements Serializable {
    SEMFOLHAS,
    GERARFOLHAS,
    COMFOLHAS,
    LARGARFOLHAS;

    /** BiologicCycle's class serial number. */
    @Serial
    private static final long serialVersionUID = 202410231746L;
}
