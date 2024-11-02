package hva.app.vaccine;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


/**
 * Command for showing all vaccines.
 */
class DoShowAllVaccines extends Command<Hotel> {

    /**
     * Constructor for DoShowAllVaccines.
     *
     * @param receiver the hotel
     */
    DoShowAllVaccines(Hotel receiver) {
        super(Label.SHOW_ALL_VACCINES, receiver);
    }


    /**
     * Executes the command.
     */
    @Override
    protected final void execute() {
        _display.popup(_receiver.showAllVaccines());
    }
}
