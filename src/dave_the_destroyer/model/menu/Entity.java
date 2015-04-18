package dave_the_destroyer.model.menu;

/**
 * Created by parango on 4/18/15.
 */
public class Entity {

    int x, y , z;

    public Entity( int x, int y, int z){

        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
