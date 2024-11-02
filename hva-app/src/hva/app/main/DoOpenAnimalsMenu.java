package hva.app.main;

import hva.HotelManager;
import pt.tecnico.uilib.menus.Command;


/**
 * Command for opening the animals menu.
 */
class DoOpenAnimalsMenu extends Command<HotelManager> {

    /**
     * Constructor for DoOpenAnimalsMenu.
     *
     * @param receiver the hotel manager
     */
    DoOpenAnimalsMenu(HotelManager receiver) {
        super(Label.MENU_ANIMALS, receiver);
    }


    /**
     * Executes the command.
     */
    @Override
    protected final void execute() {
        (new hva.app.animal.Menu(_receiver.getHotel())).open();
    }
}
