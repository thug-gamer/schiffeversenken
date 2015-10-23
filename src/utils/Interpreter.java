package utils;

import java.util.Scanner;

import schiffe.UBoot;
import level.Level;

public class Interpreter {
	
	public static void interpret(String input, Level level, Scanner scanner) {
		switch (input) {
		case "getmap":
			System.out.println(level);
			break;
		case "shoot":
			System.out.println("x eingeben:");
			int x = scanner.nextInt();
			System.out.println("y eingeben:");
			int y = scanner.nextInt();
			level.shoot(x, y);
			break;
		case "createuboot":
			System.out.println("x eingeben:");
			int xUboot = scanner.nextInt();
			System.out.println("y eingeben:");
			int yUboot = scanner.nextInt();
			System.out.println("richtung (0 = horizontal, 1 = vertikal):");
			int dirUboot = scanner.nextInt();
			level.addSchiff(new UBoot(xUboot, yUboot, dirUboot));
			break;
		
		default:
			System.out.println("Befehl '" + input + "' unbekannt");
			break;
		}
	}

}
