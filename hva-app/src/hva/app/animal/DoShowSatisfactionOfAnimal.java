package hva.app.animal;

import hva.Hotel;
import hva.exceptions.UnknownAnimalException;
import hva.app.exceptions.UnknownAnimalKeyException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowSatisfactionOfAnimal extends Command<Hotel> {

    DoShowSatisfactionOfAnimal(Hotel receiver) {
        super(Label.SHOW_SATISFACTION_OF_ANIMAL, receiver);
        addStringField("animalKey", Prompt.animalKey());
    }


    @Override
    protected final void execute() throws CommandException {
        String animalKey = stringField("animalKey");
        try {
            long satisfaction = Math.round(
                _receiver.showSatisfactionOfAnimal(animalKey));

            _display.popup(satisfaction);

        }
        catch (UnknownAnimalException e) {
            throw new UnknownAnimalKeyException(animalKey);
        }
    }

}
