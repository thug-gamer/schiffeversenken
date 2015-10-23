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

	private List<Punkt> punkte;

    public Schiff() {
        punkte = new ArrayList<Punkt>();
    }

    protected void erstelleSchiff(int x, int y, int direction) {
        for (int i = 0; i < size; i++) {
            Punkt punkt = null;
            if (direction == 0) {
                punkt = new Punkt(x+i, y);
            }
            else if (direction == 1) {
                punkt = new Punkt(x, y+i);
            }
            punkte.add(punkt);
        }
    }
    
    public boolean istGetroffen(int x, int y) {
    	for (int i=0; i < punkte.size(); i++) {
            if (punkte.get(i).getX() == x && punkte.get(i).getY() == y) {
                System.out.println("Schiff wurde getroffen");
                punkte.remove(0);
                return true;
            }
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
}
