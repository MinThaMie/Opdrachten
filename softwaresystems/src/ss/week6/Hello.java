package ss.week6;

import java.util.*;

public class Hello {

	private static Scanner scanner;
	private static boolean go;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);
		go = true;

		do {
			read(scanner);
		} while (go);

	}

	//-----------------------------Commands
	private static void read(Scanner scanner) {
		String name = "";
		System.out.println("Enter name"); // waarom komt dit er niet oneindig vaak uit?
		do {
			if (scanner.hasNext()) {
				name = scanner.next();
			}else if (!scanner.hasNext())
				go=false;
			
			//if (name.equals("end"))
			//	go = false;
		//	else
				System.out.println("Hello " + name);
		} while (go);

	}

}
