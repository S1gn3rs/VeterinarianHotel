package hva.app.habitat;

import hva.Hotel;
import hva.exceptions.DuplicateHabitatException;
import hva.app.exceptions.DuplicateHabitatKeyException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoRegisterHabitat extends Command<Hotel> {

    DoRegisterHabitat(Hotel receiver) {
        super(Label.REGISTER_HABITAT, receiver);
        addStringField("habitatKey", Prompt.habitatKey());
        addStringField("habitatName", Prompt.habitatName());
        addStringField("area", Prompt.habitatArea());
    }


    @Override
    protected void execute() throws CommandException {
        String habitatKey = stringField("habitatKey");
        String habitatName = stringField("habitatName");
        String area = stringField("area");
        try {
            _receiver.registerHabitat(new String[] {"HABITAT",
                habitatKey, habitatName, area});
        }
        catch (DuplicateHabitatException e) {
            throw new DuplicateHabitatKeyException(habitatKey);
        }
    }
}
