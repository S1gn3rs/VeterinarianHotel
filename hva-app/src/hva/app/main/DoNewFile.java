package hva.app.main;

import hva.HotelManager;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


/**
 * Command for creating a new file.
 */
class DoNewFile extends Command<HotelManager> {

    /**
     * Constructor for DoNewFile.
     *
     * @param receiver the hotel manager
     */
    DoNewFile(HotelManager receiver) {
        super(Label.NEW_FILE, receiver);
    }


    /**
     * Executes the command.
     */
    @Override
    protected final void execute() throws CommandException {
        if (_receiver.changed() &&
        Form.confirm(Prompt.saveBeforeExit())) {

            DoSaveFile cmd = new DoSaveFile(_receiver);
            cmd.execute();
        }
        _receiver.reset();
    }
}
