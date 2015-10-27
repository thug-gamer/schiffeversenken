package schiffe;

/**
 * Created by Ich on 23.10.2015.
 */
public class Schlachtschiff extends Schiff {

    public Schlachtschiff(int row, int col, int direction) {
        super();
        size = 5;
        name = SchiffName.SCHLACHTSCHIFF;
        this.direction = direction;
        erstelleSchiff(row, col);
    }
}
