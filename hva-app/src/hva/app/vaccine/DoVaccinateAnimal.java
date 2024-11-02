package hva.app.vaccine;

import hva.Hotel;
import hva.app.exceptions.UnknownAnimalKeyException;
import hva.app.exceptions.UnknownVaccineKeyException;
import hva.app.exceptions.UnknownVeterinarianKeyException;
import hva.app.exceptions.VeterinarianNotAuthorizedException;
import hva.exceptions.UnknownAnimalException;
import hva.exceptions.UnknownVaccineException;
import hva.exceptions.UnknownVeterinarianException;
import hva.exceptions.VeterinarianNotAuthorizedCoreException;
import hva.exceptions.WrongVaccineException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoVaccinateAnimal extends Command<Hotel> {

    DoVaccinateAnimal(Hotel receiver) {
        super(Label.VACCINATE_ANIMAL, receiver);
        addStringField("vaccineKey", Prompt.vaccineKey());
        addStringField("veterinarianKey", Prompt.veterinarianKey());
        addStringField("animalKey",
            hva.app.animal.Prompt.animalKey());
    }


    @Override
    protected final void execute() throws CommandException {
        String vaccineKey = stringField("vaccineKey");
        String veterinarianKey = stringField("veterinarianKey");
        String animalKey = stringField("animalKey");

        try {
            _receiver.vaccinateAnimal(vaccineKey, veterinarianKey,
                animalKey);
        }
        catch (UnknownVaccineException e) {
            throw new UnknownVaccineKeyException(vaccineKey);
        }
        catch (UnknownVeterinarianException e) {
            throw new UnknownVeterinarianKeyException(
                veterinarianKey);
        }
        catch (VeterinarianNotAuthorizedCoreException e) {
            throw new VeterinarianNotAuthorizedException(
                veterinarianKey, e.getKey());
        }
        catch (UnknownAnimalException e) {
            throw new UnknownAnimalKeyException(animalKey);
        }
        catch (WrongVaccineException e) {
            _display.popup(Message.wrongVaccine(vaccineKey,
                animalKey));
        }
    }
}
