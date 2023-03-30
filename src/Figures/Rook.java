import sum.kern.Bildschirm;

import java.awt.*;
import java.util.ArrayList;

/**
 * <h1>Rook class for Sum-Schach</h1>
 * Rook is a moveset extension for the general Figure superclass.
 * <P>Chess pieces by Cburnett - Own work, CC BY-SA 3.0, <a href="https://commons.wikimedia.org/wiki/Category:SVG_chess_pieces">wikimedia.org</a>
 * </P>**/
public class Rook extends Figure {
    public Rook(Chess.Type type, Bildschirm bildschirm, Table table) {
        super (type, bildschirm, table);
    }

    /**
     * Moveset for Rook
     * @return ArrayList of possible moves
     */
    @Override
    ArrayList<Point> getLegalMoves() {

        for (int i = 0; i < 4; i++) {
            boolean Unobstructed = true;
            do {
                if (i == 0)
                for (int j = 0; j <7; j++) {
                    addMoves(pos.x, j);
                    if(pos.x, j)
                }
            } while (Unobstructed);
        }
        return moves;
    }
}

