package main;

import java.util.Scanner;

import schiffe.Schiff;
import schiffe.Zerstoerer;
import utils.Interpreter;
import level.Level;

public class Main {

	public static void main(String[] args) {
		Level level = new Level();

		Schiff zerstoerer = new Zerstoerer(3, 4, 0);
		level.addSchiff(zerstoerer);

		level.shoot(5, 4);
		level.shoot(2, 4);
		level.shoot(4, 4);
		level.shoot(3, 4);

		System.out.println(level);

		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Befehl:");
			String input = scanner.next();
			Interpreter.interpret(input, level, scanner);
		}
	}

}
