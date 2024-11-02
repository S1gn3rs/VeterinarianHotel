package hva.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import hva.HotelManager;
import hva.app.exceptions.FileOpenFailedException;
import hva.exceptions.UnavailableFileException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


/**
 * Command for opening a file.
 */
class DoOpenFile extends Command<HotelManager> {

    /**
     * Constructor for DoOpenFile.
     *
     * @param receiver the hotel manager
     */
    DoOpenFile(HotelManager receiver) {
        super(Label.OPEN_FILE, receiver);
    }


    /**
     * Executes the command.
     */
    @Override
    protected final void execute() throws CommandException {
        try {
            if (_receiver.changed() &&
                Form.confirm(Prompt.saveBeforeExit())) {

                DoSaveFile cmd = new DoSaveFile(_receiver);
                cmd.execute();
            }
            _receiver.load(Form.requestString(Prompt.openFile()));
        }
        catch (UnavailableFileException e) {
            throw new FileOpenFailedException(e);
        }
        catch (ClassNotFoundException e) {
            throw new FileOpenFailedException(e);
        }
        catch (FileNotFoundException e) {
            _display.popup(Message.fileNotFound());
            throw new FileOpenFailedException(e);
        }
        catch (IOException e) {
            throw new FileOpenFailedException(e);
        }
    }
}
