import sum.kern.Bildschirm;

import java.awt.*;

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
        return !(type == team);
    }
}
