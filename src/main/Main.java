package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import level.Level;
import utils.Interpreter;

public class Main {
	
	private static boolean doRun = true;


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
		while(doRun) {
			String input = scanner.nextLine();
			Interpreter.interpret(input, level, scanner);
		}
		try {
			List<String> gameOverStringList = Files.readAllLines(Paths.get("resource/gameover.schiff"));
			gameOverStringList.stream().forEach(s -> {
				System.out.println(s);
			});
		} catch (IOException e1) {
			System.err.println("Datei gameover.schiff nicht gefunden");
		}
	}

	private static void writeHelpText(Level level) {
		System.out.println(level);
		System.out.println("Schieﬂen Beispiel: B5");
		
	}
	public static void setDoRun(boolean doRun) {
		Main.doRun = doRun;
	}

}
