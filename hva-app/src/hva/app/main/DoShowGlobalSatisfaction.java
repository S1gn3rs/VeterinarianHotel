package hva.app.main;

import hva.HotelManager;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Command for showing the global satisfaction.
 */
class DoShowGlobalSatisfaction extends Command<HotelManager> {

    /**
     * Constructor for DoShowGlobalSatisfaction.
     *
     * @param receiver the hotel manager
     */
    DoShowGlobalSatisfaction(HotelManager receiver) {
        super(hva.app.main.Label.SHOW_GLOBAL_SATISFACTION, receiver);
    }


    /**
     * Executes the command.
     */
    @Override
    protected final void execute() throws CommandException {
        _display.popup(Math.round(
            _receiver.showGlobalSatisfaction()));
    }
}
