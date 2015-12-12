package ss.week3.pw;

public class BasicChecker implements Checker {

	//-----------------------------Instance Variables
	public static final String INITPASS = "BANAAN";
	//-----------------------------Constructor
	public BasicChecker(){}

	//-----------------------------Queries
	@Override
	public boolean acceptable(String suggestion) {
		return (suggestion.length() >= 6 && !suggestion.contains(" "));
	}

	public String generatePassword() {
		return INITPASS;
	}
	//-----------------------------Commands
}
