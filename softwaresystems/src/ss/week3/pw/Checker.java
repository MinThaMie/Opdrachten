package ss.week3.pw;

public interface Checker {
	/**
	 * Returns true if <code>suggestion</code> is an acceptable password.
	 */
	public boolean acceptable(String suggestion);
	
	public String generatePassword();
}
