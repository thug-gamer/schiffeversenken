package schiffe;


/**
 * Created by Ich on 23.10.2015.
 */
public class UBoot extends Schiff {

    public UBoot(int row, int col, int direction) {
        super();
        size = 2;
        name = SchiffName.UBOOT;
        this.direction = direction;
        erstelleSchiff(row, col);
    }
}
