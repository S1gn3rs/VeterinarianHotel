package hva.exceptions;

import java.io.Serial;

/**
 * Exception thrown when an entry is unrecognized.
 */
public class UnrecognizedEntryException extends Exception {

    /** UnrecognizedEntryException's class serial number. */
	@Serial
	private static final long serialVersionUID = 202407081733L;

	/** Unrecognized entry specification. */
	private final String _entrySpecification;


	/**
	 * Constructs a new UnrecognizedEntryException.
	 *
	 * @param entrySpecification Unrecognized entry specification.
	 */
	public UnrecognizedEntryException(String entrySpecification) {
		_entrySpecification = entrySpecification;
	}


	/**
	 * Constructs a new UnrecognizedEntryException.
	 *
	 * @param entrySpecification Unrecognized entry specification.
	 * @param cause Cause of the exception.
	 */
	public UnrecognizedEntryException(String entrySpecification,
		Exception cause) {

		super(cause);
		_entrySpecification = entrySpecification;
	}


	/**
	 * @return Unrecognized entry specification.
	 */
	public String getEntrySpecification() {
		return _entrySpecification;
	}
}
