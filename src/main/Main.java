package main;

import java.util.Scanner;

import utils.Interpreter;
import level.Level;

public class Main {

	public static void main(String[] args) {
		Level level = new Level();

		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Befehl:");
			String input = scanner.next();
			Interpreter.interpret(input, level, scanner);
		}
	}

}
