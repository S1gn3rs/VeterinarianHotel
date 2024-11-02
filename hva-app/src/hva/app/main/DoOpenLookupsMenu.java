package hva.app.main;

import hva.HotelManager;
import pt.tecnico.uilib.menus.Command;


/**
 * Command for opening the lookups menu.
 */
class DoOpenLookupsMenu extends Command<HotelManager> {

    /**
     * Constructor for DoOpenLookupsMenu.
     *
     * @param receiver the hotel manager
     */
    DoOpenLookupsMenu(HotelManager receiver) {
        super(hva.app.main.Label.MENU_LOOKUPS, receiver);
    }


    /**
     * Executes the command.
     */
    @Override
    protected final void execute() {
        (new hva.app.search.Menu(_receiver.getHotel())).open();
    }
}
