import sum.kern.Bildschirm;
import sum.kern.Buntstift;

import java.awt.*;

public abstract class Figure {

    enum Type {
        BLACK,
        WHITE
    }

    Type team;
    Bildschirm bildschirm;
    Table table;
    int ID;
    Point pos;
    Buntstift stift = new Buntstift();

    public Figure(Type type, Bildschirm bildschirm, Table table, int ID) {

        this.team = type;
        this.bildschirm = bildschirm;
        this.table = table;
        this.ID = ID;
    }

    //void init(x, y) {
    //    pos = new Point(x, y);
    // }
    int getID() {return ID;}

    Point getPos() {
        return pos;
    }
    Type getTeam() {
        return team;
    }
    void mov(int x,int y) {
        pos = new Point (x, y);
    }
    void draw() {
        stift.bewegeBis(pos.x, pos.y);
        stift.zeichneKreis(20);
    }

}
