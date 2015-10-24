package schiffe;

import punkt.Punkt;

/**
 * Created by Ich on 23.10.2015.
 */
public class UBoot extends Schiff {

    public UBoot(int row, int col, int direction) {
        super();
        size = 1;
        name = "U-Boot";
        this.direction = direction;
        erstelleSchiff(row, col);
    }
}
