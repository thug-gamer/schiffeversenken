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
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				map[i][j] = new Feld();
			}
		}
	}
	
	public void shoot(String col, int row) {
		col = col.toUpperCase();
		int colNum = (int)col.charAt(0);
		colNum -= 65;
		row -= 1;
		shoot(colNum, row);
	}
	
	public void shoot(int x, int y) {
		Feld feld = map[x][y];
		feld.setIstBeschossen(true);
		feld.setIstSchiff(false);
		for(Schiff schiff : schiffListe) {
			if(schiff.istGetroffen(x, y)) {
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

		int x = punkte.get(0).getX() -1;
		int y = punkte.get(0).getY() -1;


		try {
			if (schiff.direction == 0) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < punkte.size() + 2; j++) {
						Feld feld = map[x + j][y + i];
						if (!feld.isIstSchiff()) {
							feld.setIstBeschossen(true);
						}
						else {
							feld.setIstZerstoert(true);
						}
					}
				}
			}
			else if (schiff.direction == 1) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < punkte.size() + 2; j++) {
						Feld feld = map[x + i][y + j];
						if (!feld.isIstSchiff()) {
							feld.setIstBeschossen(true);
						}
						else {
							feld.setIstZerstoert(true);
						}
					}
				}
			}
		} catch (IndexOutOfBoundsException e) { }
	}

	@Override
	public String toString() {
		String rowText = "   ";
		for (int i = 0; i < width; i++) {
			rowText += " " + String.valueOf(Character.toChars(i + 65)) + " ";
		}
		rowText += "\n";
		for (int i = 0; i < width; i++) {
			rowText += " " + (i + 1);
			if((i +1) < 10) {
				rowText += " ";
			}
			for (int j = 0; j < height; j++) {
				rowText += map[i][j].toString();
			}
			rowText += "\n";
		}
		return rowText;
	}
}
