package hva.app.animal;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;


/**
 * Command for showing all animals.
 */
class DoShowAllAnimals extends Command<Hotel> {

    /**
     * Constructor for DoShowAllAnimals.
     *
     * @param receiver the hotel
     */
    DoShowAllAnimals(Hotel receiver) {
        super(Label.SHOW_ALL_ANIMALS, receiver);
    }


    /**
     * Executes the command.
     */
    @Override
    protected final void execute() {
        _display.popup(_receiver.showAllAnimals());
    }
}
