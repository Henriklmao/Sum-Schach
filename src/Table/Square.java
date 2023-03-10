import sum.kern.Bildschirm;

import java.awt.*;

public class Square {
    boolean isOccupied;
    Chess.Type team;
    Point pos;
    Bildschirm bildschirm;
    int width;
    int height;
    Figure occupant;

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

    void occupy(Figure object, Chess.Type team) { // TODO: Add Who and Team!
        occupant = object;
        isOccupied = true;
        this.team = team;
    }

    boolean isOccupied() {
        return isOccupied;
    }
    
    boolean isFriendly(Chess.Type type) {
        if (type == team) return true;
        return false;
    }
}
