package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4728342917872313964L;
	//-----------------------------Instance Variables
	int size1;
	int size2;

	//-----------------------------Constructor
	public ArgumentLengthsDifferException(int size1, int size2) {
		super();
		this.size1 = size1;
		this.size2 = size2;

	}

	public ArgumentLengthsDifferException(String msg) {
		super(msg);
	}

	//-----------------------------Queries
	public String getMessage() {
		return ("error: length of command line arguments " + "differs (" + size1 + ", " + size2 + ")");
		//-----------------------------Commands
	}
}