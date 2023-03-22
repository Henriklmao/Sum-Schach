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
    // boolean enPassant = false; // Needed soon to store if en passant is possible

    Square(Bildschirm bildschirm, double factorH, double factorV, int x, int y) {
        this.bildschirm = bildschirm;
        isOccupied = false;
        width = (int) (bildschirm.breite()*factorH);
        height = (int) (bildschirm.hoehe()*factorV);
        setPos(x, y);

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

    void occupy(Figure figure, Chess.Type team) {
        occupant = figure;
        isOccupied = true;
        this.team = team;
    }
    boolean isOccupied() {
        return isOccupied;
    }
    
    boolean isFriendly(Chess.Type type) {
        return type == team;
    }
}
