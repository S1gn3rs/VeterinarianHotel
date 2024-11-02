package hva.app.main;

import hva.HotelManager;
import hva.exceptions.MissingFileAssociationException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import java.io.IOException;
import java.io.FileNotFoundException;


/**
 * Command for saving a file.
 */
class DoSaveFile extends Command<HotelManager> {

    /**
     * Constructor for DoSaveFile.
     *
     * @param receiver the hotel manager
     */
    DoSaveFile(HotelManager receiver) {
        super(Label.SAVE_FILE, receiver, r -> r.getHotel() != null);
    }


    /**
     * Executes the command.
     */
    @Override
    protected final void execute() {
        try {
            _receiver.save();
        } catch (MissingFileAssociationException eSave) {
            try {
                _receiver.saveAs(Form.requestString(
                    Prompt.newSaveAs()));

            }
            catch (MissingFileAssociationException eSaveAs) {
                eSaveAs.printStackTrace();
            }
            catch (FileNotFoundException aSaveAs) {
                aSaveAs.printStackTrace();
            }
            catch (IOException eSaveAs) {
                eSaveAs.printStackTrace();
            }
        }
        catch (FileNotFoundException aSave) {
            aSave.printStackTrace();
        }
        catch (IOException eSave) {
            eSave.printStackTrace();
        }
    }
}
