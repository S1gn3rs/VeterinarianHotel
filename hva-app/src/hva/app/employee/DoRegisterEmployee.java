package hva.app.employee;

import hva.Hotel;
import hva.exceptions.DuplicateEmployeeException;
import hva.app.exceptions.DuplicateEmployeeKeyException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;


class DoRegisterEmployee extends Command<Hotel> {

    DoRegisterEmployee(Hotel receiver) {
        super(Label.REGISTER_EMPLOYEE, receiver);
        addStringField("employeeKey", Prompt.employeeKey());
        addStringField("employeeName", Prompt.employeeName());
        addOptionField("employeeType", Prompt.employeeType(),
            new String[] {"VET", "TRT"});
    }


    @Override
    protected void execute() throws CommandException {
        String employeeKey = stringField("employeeKey");
        String employeeName = stringField("employeeName");
        String employeeType = optionField("employeeType");

        try {
            _receiver.registerEmployee(new String[] {employeeType,
                employeeKey, employeeName});
        }
        catch (DuplicateEmployeeException e) {
            throw new DuplicateEmployeeKeyException(employeeKey);
        }
    }
}
