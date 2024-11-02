package hva.exceptions;

import java.io.Serial;

/**
 * Exception thrown when an error occurs while
 * processing an import file.
 */
public class ImportFileException extends Exception {

    /** ImportFileException's class serial number. */
    @Serial
    private static final long serialVersionUID = 202407081733L;


    /** Error message. */
    private static final String ERROR_MESSAGE =
        "Erro a processar ficheiro de import: ";


    /**
     * Constructs a new ImportFileException.
     *
     * @param filename File name.
     */
    public ImportFileException(String filename) {
        super(ERROR_MESSAGE + filename);
    }


    /**
     * Constructs a new ImportFileException.
     *
     * @param filename File name.
     * @param cause Cause of the exception.
     */
    public ImportFileException(String filename, Exception cause) {
        super(ERROR_MESSAGE + filename, cause);
    }

}
