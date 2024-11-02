package hva.app.main;

import hva.HotelManager;
import pt.tecnico.uilib.menus.Command;


/**
 * Command for opening the habitats menu.
 */
class DoOpenHabitatsMenu extends Command<HotelManager> {

    /**
     * Constructor for DoOpenHabitatsMenu.
     *
     * @param receiver the hotel manager
     */
    DoOpenHabitatsMenu(HotelManager receiver) {
        super(hva.app.main.Label.MENU_HABITATS, receiver);
    }


    /**
     * Executes the command.
     */
    @Override
    protected final void execute() {
        (new hva.app.habitat.Menu(_receiver.getHotel())).open();
    }
}
