import sum.kern.Bildschirm;

import java.awt.*;
import java.util.ArrayList;

/**
 * <h1>Knight class for Sum-Schach</h1>
 * Knight is a moveset extension for the general Figure superclass.
 * <p>
 * Chess pieces by Cburnett - Own work, CC BY-SA 3.0, <a href="https://commons.wikimedia.org/wiki/Category:SVG_chess_pieces">wikimedia.org</a>
 * </p>**/
public class Knight extends Figure {
    public Knight(Chess.Type type, Bildschirm bildschirm, Table table) {
        super (type, bildschirm, table);
    }

    /**
     * Moveset for Knight
     * @return ArrayList of possible moves
     */
    @Override
    ArrayList getLegalMoves() {

        addMoves(-1,0);
        addMoves(0,1);
        addMoves(0,-1);
        addMoves(1,0);

        return moves;
    }

}

