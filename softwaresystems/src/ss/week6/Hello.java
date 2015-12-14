package ss.week6;

import java.util.*;

public class Hello {
	private static String name;
	private static Scanner scanner;

	public static void main(String[] args) {
		
		name=" ";
		scanner = new Scanner(System.in);
		
		while(name!=null){
		read(scanner);
		write();
		}
	}

	//-----------------------------Commands
	private static void read(Scanner scanner) {
		do {
			System.out.println("Enter name"); // waarom komt dit er niet oneindig vaak uit?
			if (scanner.hasNext()) {
				name = scanner.next();
			}
		} while (name == null);
		
	}

	private static void write() {
		System.out.println("Hello " + name);
	}
}
