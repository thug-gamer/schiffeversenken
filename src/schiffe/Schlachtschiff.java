package schiffe;

/**
 * Created by Ich on 23.10.2015.
 */
public class Schlachtschiff extends Schiff {

    public Schlachtschiff(int x, int y, int direction) {
        super();
        size = 4;
        name = "Schlachtschiff";
        erstelleSchiff(x, y, direction);
    }
}
