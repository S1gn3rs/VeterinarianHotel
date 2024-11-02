package hva.app.exceptions;

import pt.tecnico.uilib.menus.CommandException;

import java.io.Serial;

public class UnknownVeterinarianKeyException extends CommandException {
    @Serial
    private static final long serialVersionUID = 202407081733L;

    public UnknownVeterinarianKeyException(String id) {
        super(Message.unknownVeterinarianKey(id));
    }
}
