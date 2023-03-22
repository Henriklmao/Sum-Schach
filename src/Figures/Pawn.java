import sum.kern.Bildschirm;
import sum.multimedia.Bild; //<-- To render pictures

import java.awt.*;
/**
 * Pawn class for Sum-Schach.
 * Pawn is a moveset extension for the general Figure superclass.
 * Funfact: in Chess, the pawn has the most complex moveset.
 */
/** Chess pieces by Cburnett - Own work, CC BY-SA 3.0, <a href="https://commons.wikimedia.org/wiki/Category:SVG_chess_pieces">wikimedia.org</a>**/

public class Pawn extends Figure {
    int hasMoved = 0;
    public Pawn(Chess.Type type, Bildschirm bildschirm, Table table) {
        super (type, bildschirm, table);
    }

    /** Pawn Moveset **/
    @Override
    Point[] getLegalMoves() {

        // Standard moves incl. first move
        Point[] moves = new Point[0];
        int mov = 1;

        if (team == Chess.Type.Black) mov = -1;
        trial = new Point(getPos().x,getPos().y+mov);
        if (possible()) moves[moves.length] = trial;

        // Test Killable and en Passante
        trial = new Point(getPos().x-1,getPos().y+mov);
        if (possible()) moves[moves.length] = trial;
        trial = new Point(getPos().x+1,getPos().y+mov); //
        if (possible()) moves[moves.length] = trial;
            // First Move
        if (hasMoved > 2) {
            mov++;
            if (team == Chess.Type.Black) mov = -2;
            trial = new Point(getPos().x,getPos().y+mov);
            if (possible()) moves[moves.length] = trial;
        }

        return moves;
    }

    // Custom move to set hasMoved to true;
    @Override
    void mov(int x, int y) {
        hasMoved++;
        super.mov(x, y);
    }
}