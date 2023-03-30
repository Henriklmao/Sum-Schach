import sum.kern.Bildschirm;

import java.awt.*;
import java.util.ArrayList;

/**
 * <h1>Bishop class for Sum-Schach</h1>
 * Bishop is a moveset extension for the general Figure superclass.
 * <P>
 * Chess pieces by Cburnett - Own work, CC BY-SA 3.0, <a href="https://commons.wikimedia.org/wiki/Category:SVG_chess_pieces">wikimedia.org</a>
 * </P>**/
public class Bishop extends Figure {
    public Bishop(Chess.Type type, Bildschirm bildschirm, Table table) {
        super (type, bildschirm, table);
    }

    /**
     * Moveset for Bishop
     * @return ArrayList of possible moves
     */
    @Override
    ArrayList<Point> getLegalMoves() {

        addMoves(-1,0);
        addMoves(0,1);
        addMoves(0,-1);
        addMoves(1,0);

        return moves;
    }

}
