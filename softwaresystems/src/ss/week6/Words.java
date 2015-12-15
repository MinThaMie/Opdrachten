package ss.week6;

import java.util.Scanner;
import java.util.ArrayList;

public class Words {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> words;
		boolean stop;
		do {
			System.out.println("Enter sentence end with <.> ");
			words = read(scanner);

			stop = write(words);
		} while (!stop);

	}

	private static ArrayList<String> read(Scanner in) {
		ArrayList<String> words = new ArrayList<String>();
		int i = 0;
		while (in.hasNext()) {
			words.add(in.next());
			if (words.get(i).contains(".")||words.get(i).contains("!"))
				break;
			i++;
		}
		return words;
	}

	private static boolean write(ArrayList<String> words) {
		boolean stop = false;
		if (words.get(0).equals("end")){
			stop = true;
		words.remove(0);}
		for (int i = 0; i < words.size(); i++) {
			System.out.println("Word " + (i+1) +": " + words.get(i));
		}
		return stop;

	}

}
