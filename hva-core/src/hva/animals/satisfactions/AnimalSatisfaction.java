package hva.animals.satisfactions;

import java.io.Serial;
import java.io.Serializable;
import java.nio.file.SecureDirectoryStream;
import hva.animals.Animal;


public abstract class AnimalSatisfaction  implements Serializable{

    @Serial
    private static final long serialVersionUID = 202410231955L;

    public abstract double getSatisfaction(Animal animal);
}
