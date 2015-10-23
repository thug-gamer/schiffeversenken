package main;

import level.Level;
import schiffe.Schiff;
import schiffe.Zerstoerer;

import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Level level = new Level();
		System.out.println(level);

		Schiff zerstoerer = new Zerstoerer(3, 4, 0);
		level.addSchiff(zerstoerer);

		level.shoot(5, 4);
		level.shoot(2, 4);

		System.out.println(level);

		Scanner scanner = new Scanner(System.in);
		System.out.println("enter x");
		int x = scanner.nextInt();
		
		System.out.println("enter y");
		int y = scanner.nextInt();
		
		System.out.println("x: " + x  + ", y: " + y);
	}

}
