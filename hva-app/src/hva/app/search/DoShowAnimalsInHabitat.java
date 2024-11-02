package hva.app.search;

import hva.Hotel;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.app.habitat.Prompt;
import hva.exceptions.UnknownHabitatException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowAnimalsInHabitat extends Command<Hotel> {

    DoShowAnimalsInHabitat(Hotel receiver) {
        super(Label.ANIMALS_IN_HABITAT, receiver);
        addStringField("habitatKey", Prompt.habitatKey());
    }


    @Override
    protected void execute() throws CommandException {
        String habitatKey = stringField("habitatKey");
        try {
            _display.popup(
                _receiver.showAnimalsInHabitat(habitatKey));
        } catch (UnknownHabitatException e) {
            throw new UnknownHabitatKeyException(habitatKey);
        }
    }
}
