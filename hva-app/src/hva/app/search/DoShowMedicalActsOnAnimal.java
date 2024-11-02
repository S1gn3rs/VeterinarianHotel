package hva.app.search;

import java.util.Collection;

import hva.Hotel;
import hva.app.animal.Prompt;
import hva.app.exceptions.UnknownAnimalKeyException;
import hva.app.exceptions.UnknownVeterinarianKeyException;
import hva.exceptions.UnknownAnimalException;
import hva.exceptions.UnknownVeterinarianException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowMedicalActsOnAnimal extends Command<Hotel> {

    DoShowMedicalActsOnAnimal(Hotel receiver) {
        super(Label.MEDICAL_ACTS_ON_ANIMAL, receiver);
        addStringField("animalKey", Prompt.animalKey());
    }


    @Override
    protected void execute() throws CommandException {
        String animalKey = stringField("animalKey");
        try {
            _display.popup(
                _receiver.showMedicalActsOnAnimal(animalKey));
        }
        catch (UnknownAnimalException e) {
            throw new UnknownAnimalKeyException(animalKey);
        }
    }
}
