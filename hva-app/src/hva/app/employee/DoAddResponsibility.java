package hva.app.employee;

import hva.Hotel;
import hva.app.exceptions.NoResponsibilityException;
import hva.app.exceptions.UnknownEmployeeKeyException;
import hva.exceptions.NoResponsibilityCoreException;
import hva.exceptions.UnknownEmployeeException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoAddResponsibility extends Command<Hotel> {

    DoAddResponsibility(Hotel receiver) {
        super(Label.ADD_RESPONSABILITY, receiver);
        addStringField("employeeKey", Prompt.employeeKey());
        addStringField("responsibilityKey",
            Prompt.responsibilityKey());
    }


    @Override
    protected void execute() throws CommandException {
        String employeeKey = stringField("employeeKey");
        String responsibilityKey = stringField("responsibilityKey");
        try {
            _receiver.addResponsibility(employeeKey,
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
