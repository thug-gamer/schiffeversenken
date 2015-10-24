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

    public Schiff() {
        punkte = new ArrayList<Punkt>();
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

    public boolean istZerstoert() {
        if (size == 0) {
            System.out.println("Schiff wurde zerstört");
            return true;
        }
        return false;
    }
        
    public List<Punkt> getPunkte() {
    	return punkte;
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
