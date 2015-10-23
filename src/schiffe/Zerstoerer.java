package schiffe;

/**
 * Created by Ich on 23.10.2015.
 */
public class Zerstoerer extends Schiff {

    public Zerstoerer(int x, int y, int direction) {
        super();
        size = 3;
        name = "Zerstörer";
        erstelleSchiff(x, y, direction);
    }
}
