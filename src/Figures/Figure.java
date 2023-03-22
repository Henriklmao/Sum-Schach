import sum.kern.Bildschirm;
import sum.kern.Buntstift;

import java.awt.*;

public abstract class Figure {

    Chess.Type team;
    Bildschirm bildschirm;
    Table table;
    Point pos;
    Point trial;
    Buntstift stift = new Buntstift();
    public Figure(Chess.Type type, Bildschirm bildschirm, Table table) {

        this.team = type;
        this.bildschirm = bildschirm;
        this.table = table;
    }
    Figure getID() {return this;}

    Point getPos() {
        return pos;
    }

    /** @Method: getLegalMoves() stores MoveSet of Figure,   */
    abstract Point[] getLegalMoves();
    Chess.Type getTeam() {
        return team;
    }

    void mov(int x, int y) {
        table.mov(this, new Point (x, y));
        pos = table.getSquare(x, y);
    }
    boolean possible() {
        return table.testMov(this, trial);
    }
    void draw() {
        stift.bewegeBis(pos.x, pos.y);
        stift.zeichneKreis(20);
    }
}