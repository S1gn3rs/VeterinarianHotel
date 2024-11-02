package hva.app.employee;

import hva.Hotel;
import hva.exceptions.NoResponsibilityCoreException;
import hva.exceptions.UnknownEmployeeException;
import hva.app.exceptions.NoResponsibilityException;
import hva.app.exceptions.UnknownEmployeeKeyException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoRemoveResponsibility extends Command<Hotel> {

    DoRemoveResponsibility(Hotel receiver) {
        super(Label.REMOVE_RESPONSABILITY, receiver);
        addStringField("employeeKey", Prompt.employeeKey());
        addStringField("responsibilityKey",
            Prompt.responsibilityKey());
    }


    @Override
    protected void execute() throws CommandException {
        String employeeKey = stringField("employeeKey");
        String responsibilityKey = stringField("responsibilityKey");
        try {
            _receiver.removeResponsibility(employeeKey,
                responsibilityKey);
        }
        catch (UnknownEmployeeException e) {
            throw new UnknownEmployeeKeyException(employeeKey);
        } catch (NoResponsibilityCoreException e) {
            throw new NoResponsibilityException(employeeKey,
                responsibilityKey);
        }
    }
}
