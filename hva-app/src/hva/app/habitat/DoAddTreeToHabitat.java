package hva.app.habitat;

import hva.Hotel;
import hva.app.exceptions.DuplicateTreeKeyException;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.exceptions.DuplicateTreeException;
import hva.exceptions.UnknownHabitatException;
import hva.exceptions.UnknownTreeException;
import hva.exceptions.UnrecognizedEntryException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoAddTreeToHabitat extends Command<Hotel> {

    DoAddTreeToHabitat(Hotel receiver) {
        super(Label.ADD_TREE_TO_HABITAT, receiver);
        addStringField("habitatKey", Prompt.habitatKey());
        addStringField("treeKey", Prompt.treeKey());
        addStringField("treeName", Prompt.treeName());
        addStringField("treeAge", Prompt.treeAge());
        addStringField("treeDifficulty", Prompt.treeDifficulty());
        addOptionField("treeType", Prompt.treeType(), new
            String[] {"PERENE", "CADUCA"});
    }


    @Override
    protected void execute() throws CommandException {

        String habitatKey = stringField("habitatKey");
        String treeKey = stringField("treeKey");
        String treeName = stringField("treeName");
        String treeAge = stringField("treeAge");
        String treeDifficulty = stringField("treeDifficulty");
        String treeType = optionField("treeType");
        try{
            String[] fields = new String[] {"ÁRVORE", treeKey,
            treeName, treeAge, treeDifficulty, treeType, habitatKey};
            _display.popup(_receiver.addTreeToHabitat(fields));
        }
        catch (DuplicateTreeException e) {
            throw new DuplicateTreeKeyException(treeKey);
        } catch (UnknownHabitatException e) {
            throw new UnknownHabitatKeyException(habitatKey);
        } catch (UnknownTreeException | UnrecognizedEntryException e){
            // This exception is not expected to be thrown
            e.printStackTrace();
        }
    }
}
