package hva.habitats;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public enum Influence implements Serializable {
    POS(20),
    NEG(-20),
    NEU(0);

    @Serial
    private static final long serialVersionUID = 202410160921L;

    private final int _value;

    Influence(int value) {
        _value = value;
    }

    public int getValue() {
        return _value;
    }
}
