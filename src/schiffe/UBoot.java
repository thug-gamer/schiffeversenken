package schiffe;

import punkt.Punkt;

/**
 * Created by Ich on 23.10.2015.
 */
public class UBoot extends Schiff {

    public UBoot(int x, int y, int direction) {
        super();
        size = 2;
        name = "U-Boot";
        this.direction = direction;
        erstelleSchiff(x, y);
    }
}
