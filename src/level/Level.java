package level;

import java.util.ArrayList;
import java.util.List;

import constant.Constant;
import punkt.Punkt;
import schiffe.Schiff;

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
		map = new Feld[width][height];
		fillMap();
		schiffListe = new ArrayList<Schiff>();
	}
	
	private void fillMap() {
		for (int row = 0; row < width; row++) {
			for (int col = 0; col < height; col++) {
				map[row][col] = new Feld();
			}
		}
	}
	
	public void shoot(String col, int row) {
		col = col.toUpperCase();
		int colNum = (int)col.charAt(0);
		colNum -= 65;
		row -= 1;
		shoot(row, colNum);
	}
	
	public void shoot(int row, int col) {
		Feld feld = map[row][col];
		feld.setIstBeschossen(true);
		feld.setIstSchiff(false);
		for(Schiff schiff : schiffListe) {
			if(schiff.istGetroffen(row, col)) {
				feld.setIstSchiff(true);
			}
			if(schiff.istZerstoert()) {
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
		List<Punkt> punkte = schiff.getPunkte();

		int rowPoint = punkte.get(0).getRow() -1;
		int colPoint = punkte.get(0).getCol() -1;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < punkte.size() + 2; j++) {
				try {
					Feld feld;
					if (schiff.getDirection() == 0) {
						feld = map[rowPoint + i][colPoint + j];
					} else {
						feld = map[rowPoint + j][colPoint + i];
					}
					
					if (!feld.isIstSchiff()) {
						feld.setIstBeschossen(true);
					}
					else {
						feld.setIstZerstoert(true);
					}
				} catch (IndexOutOfBoundsException e) { }
			}
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
