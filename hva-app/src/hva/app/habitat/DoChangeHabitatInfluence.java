package hva.app.habitat;

import hva.Hotel;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.app.exceptions.UnknownSpeciesKeyException;
import hva.exceptions.UnknownHabitatException;
import hva.exceptions.UnknownSpeciesException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoChangeHabitatInfluence extends Command<Hotel> {

    DoChangeHabitatInfluence(Hotel receiver) {
        super(Label.CHANGE_HABITAT_INFLUENCE, receiver);
        addStringField("habitatKey", Prompt.habitatKey());
        addStringField("speciesKey",
            hva.app.animal.Prompt.speciesKey());
        addOptionField("habitatInfluence", Prompt.habitatInfluence(),
            new String[] {"POS", "NEG", "NEU"});
    }


    @Override
    protected void execute() throws CommandException {
        String habitatKey = stringField("habitatKey");
        String speciesKey = stringField("speciesKey");
        String habitatInfluence = optionField("habitatInfluence");
        try{
            _receiver.changeHabitatInfluence(habitatKey, speciesKey,
                habitatInfluence);
        }
        catch (UnknownHabitatException e) {
            throw new UnknownHabitatKeyException(habitatKey);
        } catch (UnknownSpeciesException e) {
            throw new UnknownSpeciesKeyException(speciesKey);
        }
    }

}
