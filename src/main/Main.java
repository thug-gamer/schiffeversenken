package main;

<<<<<<< HEAD
import java.util.Scanner;

import utils.Interpreter;
=======
>>>>>>> branch 'master' of https://github.com/thug-gamer/schiffeversenken.git
import level.Level;
import schiffe.Schiff;
import schiffe.Zerstoerer;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Level level = new Level();

		Schiff zerstoerer = new Zerstoerer(3, 4, 0);
		level.addSchiff(zerstoerer);

		level.shoot(5, 4);
		level.shoot(2, 4);

		System.out.println(level);

		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Befehl:");
			String input = scanner.next();
			Interpreter.interpret(input, level, scanner);
		}
	}

}
