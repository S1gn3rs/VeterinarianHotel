package hva.app.vaccine;

import hva.Hotel;
import hva.exceptions.DuplicateVaccineException;
import hva.exceptions.UnknownSpeciesException;
import hva.app.exceptions.DuplicateVaccineKeyException;
import hva.app.exceptions.UnknownSpeciesKeyException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoRegisterVaccine extends Command<Hotel> {

    DoRegisterVaccine(Hotel receiver) {
        super(Label.REGISTER_VACCINE, receiver);
	    addStringField("vaccineKey", Prompt.vaccineKey());
        addStringField("vaccineName", Prompt.vaccineName());
        addStringField("listOfSpeciesKeys",
            Prompt.listOfSpeciesKeys());
    }


    @Override
    protected final void execute() throws CommandException {
        String vaccineKey = stringField("vaccineKey");
        String vaccineName = stringField("vaccineName");
        String listOfSpeciesKeys = stringField("listOfSpeciesKeys");
        try {
            _receiver.registerVaccine(new String[] {"VACINA",
                vaccineKey, vaccineName, listOfSpeciesKeys});
        }
        catch (DuplicateVaccineException e) {
            throw new DuplicateVaccineKeyException(vaccineKey);
        } catch (UnknownSpeciesException e) {
            throw new UnknownSpeciesKeyException(e.getKey());
        }
    }

}
