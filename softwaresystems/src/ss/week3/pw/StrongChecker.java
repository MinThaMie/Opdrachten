package ss.week3.pw;

public class StrongChecker extends BasicChecker implements Checker {

	//-----------------------------Instance Variables
	public static final String INITPASS = "BANAAN6";

	//-----------------------------Constructor
	public StrongChecker() {
		super();
	}

	//-----------------------------Queries
	@Override
	public boolean acceptable(String suggestion) {

		return super.acceptable(suggestion) && Character.isLetter(suggestion.charAt(0))
				&& Character.isDigit(suggestion.charAt(suggestion.length() - 1));
	}

	public String generatePassword() {
		return INITPASS;
	}
	//-----------------------------Commands
}
