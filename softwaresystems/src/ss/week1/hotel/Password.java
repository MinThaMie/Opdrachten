/**
 * 
 */
package ss.week1.hotel;

/**
 * @author Jasper Gerth
 *
 */
public class Password {
	// -----------------------------Instance Variables
	public static final java.lang.String INITIAL = "BANAAN";
	private java.lang.String pass = INITIAL;

	// -----------------------------Constructor
	public Password() {
	}

	// -----------------------------Queries
	public boolean acceptable(java.lang.String suggestion) {
		return (suggestion.length() >= 6 && !suggestion.contains(" "));
	}

	public boolean setWord(java.lang.String oldpass, java.lang.String newpass) {
		boolean result = false;
		if (testWord(oldpass) && acceptable(newpass)) {
			pass = newpass;
			result = true;
		}
		return result;
	}

	public boolean testWord(java.lang.String test) {
		return (test.equals(pass));
	}

	// -----------------------------Commands
}
