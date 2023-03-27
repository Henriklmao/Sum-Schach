import sum.kern.Bildschirm;
import sum.kern.Stift;

import java.awt.Point;

// 8x8
public class Table {

    double factorH = .075;
    double factorV = .1;
    Bildschirm bildschirm;
    Stift stift = new Stift();
    Square[][] squares = new Square[0x8][0x8];

    /**
     * White spawns at the bottom, black at the Top.
     **/
    Table(Bildschirm bildschirm) {
        this.bildschirm = bildschirm;
    }

    /**
     * @Method: Initialises Square[][] Array and positions.
     */
    private void reference() {
        resetPos();
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                squares[y][x] = new Square(bildschirm, factorH, factorV, x, y);
            }
        }
    }
    /**
     * Acquires position of center of Square
     * @param x Type int
     * @param y Type int
     * @return Java.awt.Point of center of Square
     */
    Point getSquare(int x, int y){
        return squares[y][x].getPos();
    }
    /**
     * @Method: Draws the Grid field
     */
    void draw() {
        resetPos();
        for (int i = 0; i < 8; i++) {
            stift.dreheBis(0);
            for (int o = 0; o < 8; o++) nextSquare(true);
            resetH();
            stift.dreheUm(-90);
            nextSquare(false);
        }
        reference();
    }
    /**
     * Moves a Figure to a Point
     * @param mover Object of Figure to move
     * @param sqr Java.awt.Point
     */
    void mov(Figure mover, Point sqr) {
        Square square = squares[sqr.y][sqr.x];
        if(square.getEnPassante()) square.enPassante();;
        square.occupy(mover, mover.getTeam()); // Occupies Square
    }
    /**
     * Allows enPassante
     * @param mover Object of figure which moved 2 squares
     * @param sqr Java.awt.Point
     */
    void allowEnPassante(Figure mover, Point sqr) {
        squares[sqr.y][sqr.x].allowEnPassante(mover);
    }
    /**
     * Disables being able to get killed by en passante
     * @param sqr Java.awt.Point
     */
    void disableEnPassante(Point sqr) {
        squares[sqr.y][sqr.x].disableEnPassante();
    }
    /**
     * @param mover Object of Figure
     * @param trial Java.awt.Point
     * @return if move is possible
     */
    boolean testMov(Figure mover, Point trial) {
        if (squares[trial.y][trial.x].isOccupied()) {
            return squares[trial.y][trial.x].isEnemy(mover.getTeam());
        } else return true;
    }
    /**
     * Only for Pawn forward move. Does not allow killing enemy.
     * @param mover
     * @param trial
     * @return flipped boolean of Square.isOccupied()
     */
    boolean testMovPawn(Figure mover, Point trial) {
        return !squares[trial.y][trial.x].isOccupied();
    }
    /**
     * Special move test for Pawn class.
     * @param mover Type Figure
     * @param trial Java.awt.Point
     * @return if pawn can either en passante or kill someone on the square
     */
    boolean testDiagonalPawn(Figure mover, Point trial) {
        if(squares[trial.y][trial.x].isOccupied()) {
            return squares[trial.y][trial.x].isEnemy(mover.getTeam());
        }
        return squares[trial.y][trial.x].getEnPassante();
    }
    /**
     * @Method: resets Stift position to initial position
     */
    private void resetPos() {
        stift.bewegeBis(bildschirm.breite()*factorH,bildschirm.hoehe()*factorV);
    }
    /**
     * @Method: Resets horizontal Position of Stift
     */
    private void resetH() {
        stift.bewegeBis(bildschirm.breite()*factorH, stift.vPosition());
    }
    /**
     * Draws a new Square and moves Stift by length or height of Square
     * @param draw Type boolean defines if the Square is visually displayed
     */
    private void nextSquare(boolean draw) {
        if (draw) stift.zeichneRechteck(bildschirm.breite()*factorH,bildschirm.hoehe()*factorV);
        if (stift.winkel()==0) stift.bewegeUm(bildschirm.breite()*factorH);
        else stift.bewegeUm(bildschirm.hoehe()*factorV);
    }
}
