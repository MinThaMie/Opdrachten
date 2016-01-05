package ss.week6.dictionaryattack;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled withthe content of the file. The key for the map should be the
	 * username, and the password hash should be the content.
	 * 
	 * @param filename
	 */
	public void readPasswords(String filename) throws IOException {
		BufferedReader reader = null;
		passwordMap = new HashMap<String, String>();
		boolean go = true;
		try {
			reader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Scanner lineScanner = null;
		while (go) {
			String line = null;
			try {
				line = reader.readLine();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			if (line == null) {
				break;
			}
			lineScanner = new Scanner(line);

			String name = lineScanner.next();
			String hash = lineScanner.next();

			if (hash == null) {
				System.out.println("hash is null");
			}
			if (name == null) {
				System.out.println("name is null");
			}
			passwordMap.put(name, hash);
		}

		for (Map.Entry<String, String> entry : passwordMap.entrySet()) {
			System.out.println(passwordMap.get(entry.getKey()));
		}
		lineScanner.close();
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting hash
	 * (or sometimes called digest) should be hex-encoded in a String.
	 * 
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
		// To implement
		return null;
	}

	/**
	 * Checks the password for the user the password list. If the user does not
	 * exist, returns false.
	 * 
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
		// To implement
		return false;
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to the
	 * original password.
	 * 
	 * @param filename
	 *            filename of the dictionary.
	 */
	public void addToHashDictionary(String filename) {
		// To implement        
	}

	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		// To implement
	}

	public static void main(String[] args) {
		DictionaryAttack da = new DictionaryAttack();
		// To implement
		da.doDictionaryAttack();
	}

}
