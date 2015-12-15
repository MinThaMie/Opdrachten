package ss.week6;

public class TooFewArgumentsException extends WrongArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 160286419303419282L;
	//-----------------------------Instance Variables

	//-----------------------------Constructor
public  TooFewArgumentsException(){
	super();
}

public  TooFewArgumentsException(String msg){
	super(msg);
}

public String getMessage(){
	return "error: must pass two command line arguments";
}

	//-----------------------------Queries

	//-----------------------------Commands
}
