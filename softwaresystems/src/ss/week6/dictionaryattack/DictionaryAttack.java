package ss.week6.dictionaryattack;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.*;

public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;
	private final String PATH = "D:\\SS Home\\BB\\ss\\week6\\test\\";

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
			e.printStackTrace();
		}

		while (go) {
			String line = null;
			try {
				line = reader.readLine();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			if (line == null) {
				go = false;
			} else {
				String[] splitLine = line.split(": ");
				passwordMap.put(splitLine[0], splitLine[1]);
			}
		}

	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting hash
	 * (or sometimes called digest) should be hex-encoded in a String.
	 * 
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
		byte[] inputdata = password.getBytes();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e.getMessage());
		}
		md.update(inputdata);
		byte[] digest = md.digest();
		return Hex.encodeHexString(digest);
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
		String hashedPass = getPasswordHash(password);
		return hashedPass.equals(passwordMap.get(user));
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

		BufferedReader reader = null;
		hashDictionary = new HashMap<String, String>();
		boolean go = true;

		try {
			reader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (go) {
			String commonPass = null;
			try {
				commonPass = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (commonPass == null) {
				go = false;
			} else {
				String hashedPass = getPasswordHash(commonPass);
				hashDictionary.put(hashedPass, commonPass);
			}
		}
	}

	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {

		try {
			readPasswords(PATH + "LeakedPasswords.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		addToHashDictionary(PATH + "CommonPasswords.txt");

		for (Map.Entry<String, String> entry : passwordMap.entrySet()) {
			if (hashDictionary.containsKey(entry.getValue())) {
				System.out.println(entry.getKey() + ": " + hashDictionary.get(entry.getValue()));
			}
		}
	}

	public static void main(String[] args) {
		DictionaryAttack da = new DictionaryAttack();
		// To implement
		da.doDictionaryAttack();
	}

}
