package schiffe;

/**
 * Created by Ich on 23.10.2015.
 */
public abstract class Schiff {

    public int size = 0;
    public String name = "name";
    public int posX;
    public int posY;

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}
