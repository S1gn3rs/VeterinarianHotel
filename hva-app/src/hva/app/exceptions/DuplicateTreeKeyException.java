package hva.app.exceptions;

import pt.tecnico.uilib.menus.CommandException;

import java.io.Serial;

public class DuplicateTreeKeyException extends CommandException {
    @Serial
    private static final long serialVersionUID = 202407081733L;

    public DuplicateTreeKeyException(String id) {
        super(Message.duplicateTreeKey(id));
    }
}
