import sum.kern.Bildschirm;

import java.awt.*;

public class Pawn extends Figure {
    public Pawn(Chess.Type type, Bildschirm bildschirm, Table table) {
        super (type, bildschirm, table);
    }

    Point[] getLegalMoves() {
        Point[] moves;
        boolean movleft = true;
        boolean possible;
        int mov = 1;
        for (int i = 0; movleft; i++) {
            //
            if (team == Chess.Type.Black) mov=-1;
            Point trial = new Point(getPos().x,getPos().y+mov);
            table.testMov(getID(), trial);

            moves[i] = new Point();
            movleft = true;
        }
        return moves;
    }
}