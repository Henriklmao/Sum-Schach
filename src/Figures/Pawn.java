import sum.kern.Bildschirm;
import sum.multimedia.Bild; //<-- To render pictures

import java.awt.*;
import java.util.ArrayList;

/**
 *   <h1>Pawn class for Sum-Schach</h1>
 *   Pawn is a moveset extension for the general Figure superclass.
 *   Funfact: in Chess, the pawn has the most complex moveset.
 *   <P>
 *   Chess pieces by Cburnett - Own work, CC BY-SA 3.0, <a href="https://commons.wikimedia.org/wiki/Category:SVG_chess_pieces">wikimedia.org</a>
 *   </P>**/
public class Pawn extends Figure {
    boolean hasMoved = false;
    boolean allowEnPassante = false;
    Point enPassantePos;
    Pawn(Chess.Type type, Bildschirm bildschirm, Table table) {
        super (type, bildschirm, table);
        isPawn = true;
    }

    /** Pawn Moveset **/
    @Override
    ArrayList<Point> getLegalMoves() {
        moves.clear();
        // Standard moves incl. first move
        int mov = 1;
        if (team == Chess.Type.Black) mov = -1;
        addMovesPawn(0, mov);

        // Test Killable and en Passant
        trial = new Point(getPos().x-1,getPos().y+mov);
        addMovesKill(-1,1);
        trial = new Point(getPos().x+1,getPos().y+mov);
        if (possible()) moves.add(trial);
            // First Move
        if (!hasMoved) {
            mov++;
            if (team == Chess.Type.Black) mov = -2;
            trial = new Point(getPos().x, getPos().y + mov);
            if (possible()) moves.add(trial);
        }
            return moves;
        }
    /**
     * Overridden mov Method, to allow en passante check two square movement at start.
     * @param x Type int
     * @param y Type int
     */
    @Override
    void mov(int x, int y) {

        if (pos == null) {
            super.mov(x, y);
            return;
        }
        allowEnPassante = false;
        if (enPassantePos != null) {
            table.disableEnPassante(enPassantePos);
        }
        if (y == pos.y + 2 || y == pos.y - 2) {
            enPassantePos = new Point(new Point(x, y));
            table.allowEnPassante(this, new Point(x, y));
        } else {
            enPassantePos = null;
        }
        hasMoved = true;
        super.mov(x, y);
    }
    /**
     * Special move method to allow Pawn to only move forward and not kill.
     * @param MovX Type int
     * @param MovY Type int
     */
    void addMovesPawn(int MovX, int MovY) {
        trial = new Point(getPos().x+MovX,getPos().y+MovY);
        if (isNull()) return;
        if (table.testMovPawn(this, trial)) moves.add(trial);
    }

    /**
     * Special move method to only allow Pawn to kill or en passante diagonally.
     * @param MovX Type int
     * @param MovY Type int
     */
    void addMovesKill(int MovX, int MovY) {
        trial = new Point(getPos().x+MovX,getPos().y+MovY);
        if (isNull()) return;
        if (table.testMovPawn(this, trial)) moves.add(trial);
        if (table.testDiagonalPawn(this, trial)) {
            moves.add(trial);
        }
    }
}