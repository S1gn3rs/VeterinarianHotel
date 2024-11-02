package hva.app.animal;

import hva.Hotel;
import hva.exceptions.UnknownSpeciesException;
import hva.exceptions.UnknownHabitatException;
import hva.exceptions.DuplicateAnimalException;
import hva.exceptions.DuplicateSpeciesNameCoreException;
import hva.app.exceptions.DuplicateAnimalKeyException;
import hva.app.exceptions.UnknownHabitatKeyException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoRegisterAnimal extends Command<Hotel> {

    DoRegisterAnimal(Hotel receiver) {
        super(Label.REGISTER_ANIMAL, receiver);
        addStringField("animalKey", Prompt.animalKey());
        addStringField("animalName", Prompt.animalName());
        addStringField("speciesKey", Prompt.speciesKey());
        addStringField("habitatKey",
            hva.app.habitat.Prompt.habitatKey());
    }


    @Override
    protected final void execute() throws CommandException {
        String animalKey = stringField("animalKey");
        String animalName = stringField("animalName");
        String speciesKey = stringField("speciesKey");
        String habitatKey = stringField("habitatKey");

        try {
            _receiver.registerAnimal(new String[] {"ANIMAL",
                animalKey, animalName, speciesKey, habitatKey});
        }
        catch (UnknownSpeciesException e1) {
            String speciesName = Form.requestString(
                Prompt.speciesName());

            try {
                _receiver.registerSpecies(new String[] {"ESPÉCIE",
                    speciesKey, speciesName});
                try {
                    _receiver.registerAnimal(new String[] {"ANIMAL",
                    animalKey, animalName, speciesKey, habitatKey});
                }
                catch (UnknownSpeciesException e) {
                    e.printStackTrace();
                } catch (UnknownHabitatException e) {
                    throw new UnknownHabitatKeyException(habitatKey);
                } catch (DuplicateAnimalException e) {
                    throw new DuplicateAnimalKeyException(animalKey);
                }
            }
            catch (DuplicateSpeciesNameCoreException e) {
                // never happens
                e.printStackTrace();
            }
        }
        catch (UnknownHabitatException e2) {
            throw new UnknownHabitatKeyException(habitatKey);
        } catch (DuplicateAnimalException e3) {
            throw new DuplicateAnimalKeyException(animalKey);
        }
    }
}

