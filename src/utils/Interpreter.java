package utils;

import java.util.Scanner;

import error.SchiffeVersenkenException;
import schiffe.UBoot;
import level.Level;

public class Interpreter {
	
	public static void interpret(String input, Level level, Scanner scanner) {
		if (InputCommand.GETMAP.getCommand().equals(input)) {
			System.out.println(level);
		} else if (input.matches("^[A-za-z][0-9]{1,2}$")) {
				String col = input.substring(0, input.length());
				int row = Integer.valueOf(input.substring(1));
				try {
					level.shoot(col, row);
					System.out.println(level);
				} catch (IndexOutOfBoundsException e) {
					System.err.println("Angegebene Position au�erhalb des Spielfelds");
				} catch (SchiffeVersenkenException e) {
					System.err.println(e.getMessage());
				}
		} else if (InputCommand.CREATEUBOOT.getCommand().equals(input)) {
			System.out.println("Reihe eingeben:");
			int rowUboot = scanner.nextInt();
			System.out.println("Spalte eingeben:");
			int colUboot = scanner.nextInt();
			System.out.println("richtung (0 = horizontal, 1 = vertikal):");
			int dirUboot = scanner.nextInt();
			level.addSchiff(new UBoot(rowUboot, colUboot, dirUboot));
		} else {
			System.err.println("Befehl '" + input + "' unbekannt");
		}
	}

}
