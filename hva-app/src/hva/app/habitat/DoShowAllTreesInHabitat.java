package hva.app.habitat;

import hva.Hotel;
import hva.exceptions.UnknownHabitatException;
import hva.app.exceptions.UnknownHabitatKeyException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowAllTreesInHabitat extends Command<Hotel> {

    DoShowAllTreesInHabitat(Hotel receiver) {
        super(Label.SHOW_TREES_IN_HABITAT, receiver);
        //FIXME add command fields if needed
        addStringField("habitatKey", Prompt.habitatKey());
    }


    @Override
    protected void execute() throws CommandException {
        String habitatKey = stringField("habitatKey");
        try{
            _display.popup(_receiver.showAllTreesInHabitat(
                habitatKey));
        } catch (UnknownHabitatException e) {
            throw new UnknownHabitatKeyException(habitatKey);
        }
    }
}
