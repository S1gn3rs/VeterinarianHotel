package hva.app.main;

import hva.HotelManager;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


/**
 * Command for advancing the season.
 */
class DoAdvanceSeason extends Command<HotelManager> {

    /**
     * Constructor for DoAdvanceSeason.
     *
     * @param receiver the hotel manager
     */
    DoAdvanceSeason(HotelManager receiver) {
        super(Label.ADVANCE_SEASON, receiver);
    }


    /**
     * Executes the command.
     */
    @Override
    protected final void execute() {
        _display.popup(_receiver.advanceSeason());
    }
}
