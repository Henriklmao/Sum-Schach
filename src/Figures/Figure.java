import sum.kern.Bildschirm;
import sum.kern.Buntstift;

import java.awt.*;

public abstract class Figure {

    Chess.Type team;
    Bildschirm bildschirm;
    Table table;
    Figure ID;
    Point pos;
    Buntstift stift = new Buntstift();

    public Figure(Chess.Type type, Bildschirm bildschirm, Table table) {

        this.team = type;
        this.bildschirm = bildschirm;
        this.table = table;
    }

    //void init(x, y) {
    //    pos = new Point(x, y);
    // }
    Figure getID() {return ID;}
    public void setId(Figure ID) {
        this.ID=ID;
    }

    Point getPos() {
        return pos;
    }

    /** @Method: getLegalMoves() Stores Moveset of Figure,   */
    abstract Point[] getLegalMoves();
    Chess.Type getTeam() {
        return team;
    }
    void mov(int x, int y) {
        pos = new Point (x, y);
    }
    void draw() {
        stift.bewegeBis(pos.x, pos.y);
        stift.zeichneKreis(20);
    }

}
