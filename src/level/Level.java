package level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import punkt.Punkt;
import schiffe.Kreuzer;
import schiffe.Schiff;
import schiffe.Schlachtschiff;
import schiffe.UBoot;
import schiffe.Zerstoerer;
import constant.Constant;

public class Level {
	
	private Feld[][] map;
	
	private List<Schiff> schiffListe;
	
	private int width;
	private int height;

	public Level() {
		init(Constant.DEFAULT_GROESSE, Constant.DEFAULT_GROESSE);
	}
	
	public Level(int width, int height) {
		init(width, height);
	}

	private void init(int width, int height) {
		this.width = width;
		this.height = height;
		map = new Feld[height][width];
		fillMap();
		schiffListe = new ArrayList<Schiff>();
	}
	
	private void fillMap() {
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				map[row][col] = new Feld();
			}
		}
	}
	
	public void setAlleSchiffe() {
		List<Schiff> list = Arrays.asList(
				new Schlachtschiff(0, 0, 0),
				new Zerstoerer(0, 0, 0),
				new Zerstoerer(0, 0, 0),
				new Kreuzer(0, 0, 0),
				new Kreuzer(0, 0, 0),
				new Kreuzer(0, 0, 0),
				new UBoot(0, 0, 0),
				new UBoot(0, 0, 0),
				new UBoot(0, 0, 0),
				new UBoot(0, 0, 0));
		for(Schiff schiff : list) {
			setShiffAtRandomPosition(schiff);
		}
	}
	
	public void setShiffAtRandomPosition(Schiff schiff) {
		Random rand = new Random();
		int direction = rand.nextInt(2);
		int maxWidth = this.width;
		int maxHeight = this.height;
		if(direction == 0) {
			maxWidth -= (schiff.getPunkte().size() - 1);
		} else {
			maxHeight -= (schiff.getPunkte().size() - 1);
		}
		int col = rand.nextInt(maxWidth);
		int row = rand.nextInt(maxHeight);
		
		String typ = schiff.getName();
		switch (typ) {
		case "Kreuzer":
			schiff = new Kreuzer(row, col, direction);
			break;
		case "Schlachtschiff":
			schiff = new Schlachtschiff(row, col, direction);
			break;
		case "U-Boot":
			schiff = new UBoot(row, col, direction);
			break;
		case "Zerst�rer":
			schiff = new Zerstoerer(row, col, direction);
			break;

		default:
			schiff = null;
			break;
		}
		boolean kolidiert = false;
		for (Schiff s : schiffListe) {
			if(s.kolidiertMitSchiff(schiff)) {
				kolidiert = true;
			}
		}
		if(!kolidiert) {
			addSchiff(schiff);
		} else {
			setShiffAtRandomPosition(schiff);
		}
	}
	
	public void shoot(String col, int row) throws IndexOutOfBoundsException {
		col = col.toUpperCase();
		int colNum = (int)col.charAt(0);
		colNum -= 65;
		row -= 1;
		shoot(row, colNum);
	}
	
	public void shoot(int row, int col) throws IndexOutOfBoundsException {
		Feld feld;
		feld = map[row][col];
		feld.setIstBeschossen(true);
		feld.setIstSchiff(false);
		for(Schiff schiff : schiffListe) {
			if (schiff.istGetroffen(row, col)) {
				feld.setIstSchiff(true);
			}
			if (schiff.isIstZerstoert()) {
				markiereZerstoertesSchiff(schiff);
			}
		}
	}
	
	public Feld[][] getMap() {
		return this.map;
	}

	public void addSchiff(Schiff schiff) {
		schiffListe.add(schiff);
	}

	public void markiereZerstoertesSchiff(Schiff schiff) {
		for (Punkt p : schiff.getBereich()) {
			try {
				Feld feld;
				feld = map[p.getRow()][p.getCol()];

				if (!feld.isIstSchiff()) {
					feld.setIstBeschossen(true);
				}
				else {
					feld.setIstZerstoert(true);
				}
			} catch (IndexOutOfBoundsException e) { }
		}
	}

	@Override
	public String toString() {
		String result = "   ";
		for (int col = 0; col < width; col++) {
			result += " " + String.valueOf(Character.toChars(col + 65)) + " ";
		}
		result += "\n";
		for (int row = 0; row < width; row++) {
			result += " " + (row + 1);
			if((row +1) < 10) {
				result += " ";
			}
			for (int col = 0; col < height; col++) {
				result += map[row][col].toString();
			}
			result += "\n";
		}
		return result;
	}
}
