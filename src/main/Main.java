package main;

import java.util.Scanner;

import schiffe.Schiff;
import schiffe.Schlachtschiff;
import schiffe.Zerstoerer;
import utils.Interpreter;
import level.Level;

public class Main {

	public static void main(String[] args) {
		Level level = new Level();

		Schiff zerstoerer = new Zerstoerer(0, 0, 1);
		level.addSchiff(zerstoerer);
		System.out.println(level);
		level.shoot(1, 0);
		level.shoot(2, 0);
		level.shoot(3, 0);
		level.shoot(4, 0);
		level.shoot(0, 0);
		System.out.println(level);

		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Befehl:");
			String input = scanner.next();
			Interpreter.interpret(input, level, scanner);
		}
	}

}
