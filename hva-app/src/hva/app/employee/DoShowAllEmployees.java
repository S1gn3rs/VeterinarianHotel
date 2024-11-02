package hva.app.employee;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


/**
 * Command for showing all employees.
 */
class DoShowAllEmployees extends Command<Hotel> {

    /**
     * Constructor for DoShowAllEmployees.
     *
     * @param receiver the hotel
     */
    DoShowAllEmployees(Hotel receiver) {
        super(Label.SHOW_ALL_EMPLOYEES, receiver);
    }


    /**
     * Executes the command.
     */
    @Override
    protected void execute() throws CommandException {
        _display.popup(_receiver.showAllEmployees());
    }
}
