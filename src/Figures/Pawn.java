import sum.kern.Bildschirm;

import java.awt.*;
/**
 * Pawn class for Sum-Schach.
 * Pawn is a moveset extension for the general Figure superclass.
 * Funfact: in Chess, the pawn has the most complex moveset.
 */

public class Pawn extends Figure {
    boolean hasMoved = false;
    public Pawn(Chess.Type type, Bildschirm bildschirm, Table table) {
        super (type, bildschirm, table);
    }

    /** Pawn Moveset **/
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
        // First Move
        if (!hasMoved) {
            mov++;
            if (team == Chess.Type.Black) mov = -2;
            trial = new Point(getPos().x,getPos().y+mov);
            possible = table.testMov(this, trial);
            if (possible) moves[1] = trial;
        }

        // Test Killable

        // En Passante
        return moves;
    }

    // Custom move to set hasMoved to true;
    @Override
    void mov(int x, int y) {
        hasMoved = true;
        super.mov(x, y);
    }
}