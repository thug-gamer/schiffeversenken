package level;

import java.util.ArrayList;
import java.util.List;

import constant.Constant;
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
	
	public void shoot(int x, int y) {
		boolean istShiffAufPosition = false;
		for(Schiff schiff : schiffListe) {
			if(schiff.istGetroffen(x, y)) {
				istShiffAufPosition = true;
			}
		}
		Feld feld = map[x][y];
		feld.setIstBeschossen(true);
		feld.setIstSchiff(istShiffAufPosition);
	}
	
	public Feld[][] getMap() {
		return this.map;
	}

	public void addSchiff(Schiff schiff) {
		schiffListe.add(schiff);
	}

	@Override
	public String toString() {
		String rowText = "";
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				rowText += map[i][j].toString();
			}
			rowText += "\n";
		}
		return rowText;
	}
}
