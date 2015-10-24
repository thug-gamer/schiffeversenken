package schiffe;

/**
 * Created by Ich on 23.10.2015.
 */
public class Kreuzer extends Schiff {

    public Kreuzer(int x, int y, int direction) {
        super();
        size = 3;
        name = "Kreuzer";
        this.direction = direction;
        erstelleSchiff(x, y);
    }
}
