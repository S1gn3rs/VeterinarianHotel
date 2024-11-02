package hva.exceptions;

import java.io.Serial;

/**
 * Exception thrown when a file is unavailable.
 */
public class UnavailableFileException extends Exception {

    /** UnavailableFileException's class serial number. */
	@Serial
	private static final long serialVersionUID = 202407081733L;

	/** The requested filename. */
	String _filename;


	/**
	 * Constructs a new UnavailableFileException.
	 *
	 * @param filename The requested filename.
	 */
	public UnavailableFileException(String filename) {
	  super("Erro a processar ficheiro " + filename);
	  _filename = filename;
	}


	/**
	 * @return The requested filename.
	 */
	public String getFilename() {
		return _filename;
	}

}
