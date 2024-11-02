package hva.app.main;

import hva.HotelManager;
import pt.tecnico.uilib.menus.Command;


/**
 * Command for opening the vaccines menu.
 */
class DoOpenVaccinesMenu extends Command<HotelManager> {

    /**
     * Constructor for DoOpenVaccinesMenu.
     *
     * @param receiver the hotel manager
     */
    DoOpenVaccinesMenu(HotelManager receiver) {
        super(hva.app.main.Label.MENU_VACCINES, receiver);
    }


    /**
     * Executes the command.
     */
    @Override
    protected final void execute() {
        (new hva.app.vaccine.Menu(_receiver.getHotel())).open();
    }
}
