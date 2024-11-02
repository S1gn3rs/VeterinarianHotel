package hva.app.exceptions;

import pt.tecnico.uilib.menus.CommandException;

import java.io.Serial;

public class FileOpenFailedException extends CommandException {
    @Serial
    private static final long serialVersionUID = 202407081733L;

    public FileOpenFailedException(Exception e) {
        super(Message.problemOpeningFile(e), e);
    }
}
