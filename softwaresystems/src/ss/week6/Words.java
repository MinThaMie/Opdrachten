package ss.week6;

import java.util.Scanner;

public class Words {

	private static String[] words;
	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		System.out.println("input text");
		words = read();

		write(words);
	}

	private static String[] read() {
		String[] result = null;
		;
		int i = 0;
		boolean go = true;
		do {
			if (in.hasNext()) {
				words[i] = in.next();
				i++;
			} else
				go = false;
		} while (go);

		return result;
	}

	public static void write(String[] words){
		for (String word : words){
			System.out.println(word);
		}
	}

}
