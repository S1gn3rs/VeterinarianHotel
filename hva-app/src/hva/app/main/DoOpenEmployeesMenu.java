package hva.app.main;

import hva.HotelManager;
import pt.tecnico.uilib.menus.Command;


/**
 * Command for opening the employees menu.
 */
class DoOpenEmployeesMenu extends Command<HotelManager> {

    /**
     * Constructor for DoOpenEmployeesMenu.
     *
     * @param receiver the hotel manager
     */
    DoOpenEmployeesMenu(HotelManager receiver) {
        super(Label.MENU_EMPLOYEES, receiver);
    }


    /**
     * Executes the command.
     */
    @Override
    protected final void execute() {
        (new hva.app.employee.Menu(_receiver.getHotel())).open();
    }

}
