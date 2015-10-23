package schiffe;

import java.util.List;

/**
 * Created by Ich on 23.10.2015.
 */
public abstract class Schiff {

    public int size = 0;
    public String name = "name";

	private List<Punkt> punkte;
    
    public boolean istGetroffen(int x, int y) {
    	//TODO implement
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
