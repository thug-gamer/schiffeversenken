package main;

import java.util.Scanner;

import level.Level;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Level level = new Level();
		System.out.println(level);

		Scanner scanner = new Scanner(System.in);
		System.out.println("enter x");
		int x = scanner.nextInt();
		
		System.out.println("enter y");
		int y = scanner.nextInt();
		
		System.out.println("x: " + x  + ", y: " + y);
	}

}
