package schiffe;

import punkt.Punkt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ich on 23.10.2015.
 */
public abstract class Schiff {

    public int size = 0;
    public String name = "name";
    public int direction = 0;

	private List<Punkt> punkte;
    private List<Punkt> bereich;
    private boolean istZerstoert = false;

    public Schiff() {
        punkte = new ArrayList<Punkt>();
        bereich = new ArrayList<Punkt>();
    }

    protected void erstelleSchiff(int row, int col) {
        for (int i = 0; i < size; i++) {
            Punkt punkt = null;
            if (direction == 1) {
                punkt = new Punkt(row+i, col);
            }
            else if (direction == 0) {
                punkt = new Punkt(row, col+i);
            }
            punkte.add(punkt);
        }
        erstelleBereich(row, col);
    }

    private void erstelleBereich(int row, int col) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < punkte.size()+2; j++) {
                try {
                    Punkt punkt;
                    if (direction == 0) {
                        punkt = new Punkt((row-1) + i, (col-1) + j);
                    } else {
                        punkt = new Punkt((row-1) + j, (col-1) + i);
                    }
                    bereich.add(punkt);
                } catch (IndexOutOfBoundsException e) { }
            }
        }
    }

    public boolean istGetroffen(int row, int col) {
    	for (int i=0; i < punkte.size(); i++) {
            if (punkte.get(i).getRow() == row && punkte.get(i).getCol() == col) {
                System.out.println("Schiff wurde getroffen");
                size -= 1;
                return true;
            }
        }
    	return false;
    }

    public boolean isIstZerstoert() {
        if (size == 0 && istZerstoert == false) {
            istZerstoert = true;
            System.out.println("Schiff wurde zerst�rt");
            return true;
        }
        return false;
    }
    
    public boolean kolidiertMitSchiff(Schiff schiff) {
        for(Punkt b : bereich) {
            for (Punkt c: schiff.getPunkte()){
                if (b.getRow() == c.getRow() && b.getCol() == c.getCol()) {
                    return true;
                }
            }
        }
    	return false;
    }
        
    public List<Punkt> getPunkte() {
    	return punkte;
    }

    public List<Punkt> getBereich() {
        return bereich;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public int getDirection() {
        return direction;
    }
}
