import sum.kern.Bildschirm;

import java.awt.*;
/**
 * Queen class for Sum-Schach.
 * Queen is a moveset extension for the general Figure superclass.
 */

/** Chess pieces by Cburnett - Own work, CC BY-SA 3.0, <a href="https://commons.wikimedia.org/wiki/Category:SVG_chess_pieces">wikimedia.org</a>**/

public class Queen extends Figure {
    public Queen(Chess.Type type, Bildschirm bildschirm, Table table) {
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
