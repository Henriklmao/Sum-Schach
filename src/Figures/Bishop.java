import sum.kern.Bildschirm;

import java.awt.*;
/**
 * Pawn class for Sum-Schach.
 * Pawn is a moveset extension for the general Figure superclass.
 * Funfact: in Chess, the pawn has the most complex moveset.
 */

public class Bishop extends Figure {
    public Bishop(Chess.Type type, Bildschirm bildschirm, Table table) {
        super (type, bildschirm, table);
    }

    /**  Moveset **/
    @Override
    Point[] getLegalMoves() {

        // Standard moves incl. first move
        Point[] moves = new Point[0];

        boolean movsleft = true;
        int mov = 1;
        boolean possible;
        if (team == Chess.Type.Black) mov = -1;
        Point trial = new Point(getPos().x,getPos().y+mov);
        possible = table.testMov(this, trial);
        if (possible) moves[0] = trial;

        return moves;
    }

}
