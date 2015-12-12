package ss.week3.pw;

public class TimedPassword extends Password {
	//-----------------------------Instance Variables
	private int validTime;
	private long startTime;

	//-----------------------------Constructor
	public TimedPassword() {
		validTime = 5 * 1000;
		startTime = System.currentTimeMillis();
	}

	public TimedPassword(int expirationTime) {
		validTime = expirationTime;
		startTime = System.currentTimeMillis();
	}

	//-----------------------------Queries

	public boolean isExpired() {
		return !((System.currentTimeMillis() - startTime) <= validTime);
	}

	//-----------------------------Commands
	public boolean setWord(String oldPass, String newPass){
		boolean result;
		result=super.setWord(oldPass,newPass);
		if (result)
		startTime = System.currentTimeMillis();
		return result;		
	}
}

//dan kan je geen nieuw wachtwoord instellen
