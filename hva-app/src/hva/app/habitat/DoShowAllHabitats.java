package hva.app.habitat;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


/**
 * Command for showing all habitats.
 */
class DoShowAllHabitats extends Command<Hotel> {

    /**
     * Constructor for DoShowAllHabitats.
     *
     * @param receiver the hotel
     */
    DoShowAllHabitats(Hotel receiver) {
        super(Label.SHOW_ALL_HABITATS, receiver);
    }


    /**
     * Executes the command.
     */
    @Override
    protected void execute() {
        _display.popup(_receiver.showAllHabitats());
    }
}
