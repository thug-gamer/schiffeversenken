package main;

import java.util.Scanner;

import level.Level;
import utils.Interpreter;

public class Main {

	public static void main(String[] args) {
		Level level = new Level();
		level.setAlleSchiffe();
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
//				level.shoot(i, j);
//			}
//		}
//		Schiff zerstoerer = new Zerstoerer(0, 0, 1);
//		level.addSchiff(zerstoerer);
//		System.out.println(level);
//		level.shoot(1, 0);
//		level.shoot(2, 0);
//		level.shoot(3, 0);
//		level.shoot(4, 0);
//		level.shoot(0, 0);
//		System.out.println(level);

		Scanner scanner = new Scanner(System.in);
		writeHelpText(level);
		while(true) {
			String input = scanner.next();
			Interpreter.interpret(input, level, scanner);
		}
	}

	private static void writeHelpText(Level level) {
		System.out.println(level);
		System.out.println("Schießen Beispiel: B5");
		System.out.println("Spielfeld anzeigen: getmap");
		
	}

}
