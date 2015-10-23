package level;

import java.util.List;

import constant.Constant;
import schiffe.Schiff;

public class Level {
	
	private Feld[][] map;
	
	private List<Schiff> schiffListe;
	
	private int width;
	private int height;
	
	public Level() {
		this.width = Constant.DEFAULT_GROESSE;
		this.height = Constant.DEFAULT_GROESSE;
		map = new Feld[width][height];
		fillMap();
	}
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		map = new Feld[width][height];
		fillMap();
	}
	
	private void fillMap() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				map[i][j] = new Feld();
			}
		}
	}
	
	public void shoot(int x, int y) {
		for(Schiff schiff : schiffListe) {
			//TODO
		}
	}
	
	public Feld[][] getMap() {
		return this.map;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
