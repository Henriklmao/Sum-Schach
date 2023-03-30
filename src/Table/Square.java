import sum.kern.Bildschirm;

import java.awt.*;

/**
 * <h1>Square class for Sum-Schach</h1>
 * <P>In Sum-Schach, the Square class is used to store a multitude of information about a</P>
 * square on the playfield.
 */
public class Square {
    boolean isOccupied;
    Chess.Type team;
    Point pos;
    Bildschirm bildschirm;
    int width;
    int height;
    Figure occupant;
    boolean enPassante;
    Figure enPassanteFigure = null;
    Square(Bildschirm bildschirm, double factorH, double factorV, int x, int y) {
        this.bildschirm = bildschirm;
        isOccupied = false;
        width = (int) (bildschirm.breite()*factorH);
        height = (int) (bildschirm.hoehe()*factorV);
        setPos(x, y);

    }
    /**
     * Sets Point Pos to center of square
     * @param x Type int
     * @param y Type int
     */
    private void setPos(int x, int y) {
        x++;
        y++;
        pos = new Point (
            x*width + width/2 , y*height + height/2
        );
    }

    /**
     * @return Point pos
     */
    Point getPos() {
        return pos;
    }
    /**
     * Occupies defined Square
     * @param figure Object of Figure
     * @param team  as Chess.Type
     */
    void occupy(Figure figure, Chess.Type team) {
        occupant = figure;
        isOccupied = true;
        this.team = team;
    }

    /**
     * Checks if Mouse selected this Square
     * @param mousePos Java.awt.Point
     * @return if mousePos is on square.
     */
    boolean checkMouse(Point mousePos){
        return mousePos.x > pos.x-width && mousePos.x < pos.x+width
                && mousePos.y > pos.y-height && mousePos.y < pos.y+height;
            }
    Figure getOccupant() {
        return occupant;
    }
    /**
     * Allows Square to be en passanted
     * @param mover Type Figure
     */
    void allowEnPassante(Figure mover) {
        enPassanteFigure = mover;
    }
    /**
     * @Method: Disables being able to get killed by en passante
     */
    void disableEnPassante() {
        enPassante = false;
        enPassanteFigure = null;
    }
    /**
     * @Method: Kills Figure which allowed enPassante
     */
    void enPassante() {
        enPassanteFigure.kill();
        disableEnPassante();
    }
    /**
     * Tests if an EnPassante is possible
     * @return boolean enPassante
     */
    boolean getEnPassante(){
        return enPassante;
    }
    /**
     * @return boolean isOccupied
     */
    boolean isOccupied() {
        return isOccupied;
    }
    /**
     * @param type as Chess.Type
     * @return true if occupant is not in same Team
     */
    boolean isEnemy(Chess.Type type) {
        if (type == null) return false;
        return !(type == team);
    }
}
