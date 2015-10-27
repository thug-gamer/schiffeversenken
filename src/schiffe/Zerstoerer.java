package schiffe;

/**
 * Created by Ich on 23.10.2015.
 */
public class Zerstoerer extends Schiff {

    public Zerstoerer(int row, int col, int direction) {
        super();
        size = 4;
        name = SchiffName.ZERSTOERER;
        this.direction = direction;
        erstelleSchiff(row, col);
    }
}
