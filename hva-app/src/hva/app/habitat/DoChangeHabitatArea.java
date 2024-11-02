package hva.app.habitat;

import hva.Hotel;
import hva.exceptions.UnknownHabitatException;
import hva.app.exceptions.UnknownHabitatKeyException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoChangeHabitatArea extends Command<Hotel> {

    DoChangeHabitatArea(Hotel receiver) {
        super(Label.CHANGE_HABITAT_AREA, receiver);
        addStringField("habitatKey", Prompt.habitatKey());
        addIntegerField("habitatArea", Prompt.habitatArea());
    }


    @Override
    protected void execute() throws CommandException {
        String habitatKey = stringField("habitatKey");
        int habitatArea = integerField("habitatArea");
        try {
            _receiver.changeHabitatArea(habitatKey, habitatArea);
        } catch (UnknownHabitatException e) {
            throw new UnknownHabitatKeyException(habitatKey);
        }
    }

}
