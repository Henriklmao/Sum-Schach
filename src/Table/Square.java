import sum.kern.Bildschirm;

import java.awt.*;

public class Square {

    enum Type {
        BLACK,
        White
    }
    boolean isOccupied;
    Type team;
    Point pos;
    Bildschirm bildschirm;
    int width;
    int height;

    Square(Bildschirm bildschirm, double factorH, double factorV, int x, int y) {
        this.bildschirm = bildschirm;
        isOccupied = false;
        setPos(x, y);
        width = (int) (bildschirm.breite()*factorH);
        height = (int) (bildschirm.hoehe()*factorV);
    }
    void setPos(int x, int y) {
        x++;
        y++;
    pos = new Point (
            x*width + width/2 , y*height + height/2
        );
    }

    Point getPos() {
        return pos;
    }

    void Occupy() { // TODO: Add Who and Team!
        isOccupied = true;

    }

    boolean isOccupied() {
        return isOccupied;
    }
    boolean isFriendly(Type type) {
        if (type == team) return true;
        return false;
    }
}
