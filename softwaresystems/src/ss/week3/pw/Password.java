/**
 * 
 */
package ss.week3.pw;

/**
 * @author Jasper Gerth
 *
 */
public class Password {
	// -----------------------------Instance Variables
	public static final String INITIAL = "BANAAN";
	private String pass;
	private Checker checker;
	private String factoryPassword;

	// -----------------------------Constructor
	public Password(Checker check) {
		this.checker=check;
		factoryPassword=check.generatePassword();	
		pass=factoryPassword;
	}
	
	public Password(){
		this(new BasicChecker());
	}

	// -----------------------------Queries
	/*@pure*/public boolean acceptable(String suggestion) {
		return checker.acceptable(suggestion);
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
	/*@ pure */public Checker getChecker(){
		return this.checker;
	}
	/*@ pure*/ public String getFactoryPassword(){
		return this.factoryPassword;
	}

	// -----------------------------Commands
}

