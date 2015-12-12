/**
 * 
 */
package ss.week2.hotel;

/**
 * @author Jasper Gerth
 *
 */
public class Password {
	// -----------------------------Instance Variables
	public static final String INITIAL = "BANAAN";
	private String pass = INITIAL;

	// -----------------------------Constructor
	public Password() {
	}

	// -----------------------------Queries
	/*@pure*/public static boolean acceptable(String suggestion) {
		return (suggestion.length() >= 6 && !suggestion.contains(" "));
	}

	public boolean setWord(String oldpass, String newpass) {
		boolean result = false;
		if (testWord(oldpass) && acceptable(newpass)) {
			pass = newpass;
			result = true;
		}
		return result;
	}

	/*@pure*/public boolean testWord(String test) {
		return (test.equals(pass));
	}

	// -----------------------------Commands
}
