package hva.app.search;

import hva.Hotel;
import hva.app.employee.Prompt;
import hva.app.exceptions.UnknownVeterinarianKeyException;
import hva.exceptions.UnknownVeterinarianException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowMedicalActsByVeterinarian extends Command<Hotel> {

    DoShowMedicalActsByVeterinarian(Hotel receiver) {
        super(Label.MEDICAL_ACTS_BY_VET, receiver);
        addStringField("veterinarianKey", Prompt.employeeKey());
    }


    @Override
    protected void execute() throws CommandException {
        String veterinarianKey = stringField("veterinarianKey");
        try {
            _display.popup(
                _receiver.showMedicalActsByVeterinarian(
                veterinarianKey));
        }
        catch (UnknownVeterinarianException e) {
            throw new UnknownVeterinarianKeyException(
                veterinarianKey);
        }
    }
}
