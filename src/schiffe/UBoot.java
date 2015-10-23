package schiffe;

import punkt.Punkt;

/**
 * Created by Ich on 23.10.2015.
 */
public class UBoot extends Schiff {

    public UBoot(int x, int y, int direction) {
        super();
        size = 1;
        name = "U-Boot";
        erstelleSchiff(x, y, direction);
    }
}
