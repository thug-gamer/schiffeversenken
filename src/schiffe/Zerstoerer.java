package schiffe;

/**
 * Created by Ich on 23.10.2015.
 */
public class Zerstoerer extends Schiff {

    public Zerstoerer(int x, int y, int direction) {
        super();
        size = 4;
        name = "Zerst�rer";
        this.direction = direction;
        erstelleSchiff(x, y);
    }
}
