package hva.app.animal;

import hva.Hotel;
import hva.exceptions.UnknownAnimalException;
import hva.exceptions.UnknownHabitatException;
import hva.app.exceptions.UnknownAnimalKeyException;
import hva.app.exceptions.UnknownHabitatKeyException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoTransferToHabitat extends Command<Hotel> {

    DoTransferToHabitat(Hotel hotel) {
        super(Label.TRANSFER_ANIMAL_TO_HABITAT, hotel);
        addStringField("animalKey", Prompt.animalKey());
        addStringField("habitatKey",
            hva.app.habitat.Prompt.habitatKey());
    }


    @Override
    protected final void execute() throws CommandException {
        String animalKey = stringField("animalKey");
        String habitatKey = stringField("habitatKey");
        try {
            _receiver.transferToHabitat(animalKey, habitatKey);
        }
        catch (UnknownAnimalException e) {
            throw new UnknownAnimalKeyException(animalKey);
        } catch (UnknownHabitatException e) {
            throw new UnknownHabitatKeyException(habitatKey);
        }
    }

}
