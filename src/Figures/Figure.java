import sum.kern.Bildschirm;
import sum.kern.Buntstift;

import java.awt.*;
import java.util.ArrayList;

public abstract class Figure {

    Chess.Type team;
    Bildschirm bildschirm;
    Table table;
    Point pos;
    Point trial;
    Buntstift stift = new Buntstift();
    boolean isPawn = false;
    ArrayList<Point> moves = new ArrayList<>();
    boolean isDead = false;
    public Figure(Chess.Type type, Bildschirm bildschirm, Table table) {

        this.team = type;
        this.bildschirm = bildschirm;
        this.table = table;
    }

    Point getPos() {
        return pos;
    }

    /** @Method: getLegalMoves() stores MoveSet of Figure,   */
    abstract ArrayList<Point> getLegalMoves();
    Chess.Type getTeam() {
        return team;
    }

    /**
     * Moves a piece
     * @param x
     * @param y
     */
    void mov(int x, int y) {
        table.mov(this, new Point(x, y));
        pos = table.getSquare(x, y);
    }
    void addMoves(int MovX, int MovY) {
        trial = new Point(getPos().x+MovX,getPos().y+MovY);
        if (possible()) moves.add(trial);
    }
    /**
     * Checks if a certain move is possible.
     * @return Boolean if move is possible
     */
    boolean possible() {
        if (isNull()) return false;
        return table.testMov(this, trial);
    }
    /**
     * @Method: Avoids NullPointerException when requesting not existing field
     */
    protected boolean isNull() {
        if (trial.x < 0 || trial.y < 0) return true;
        return trial.x > 7 || trial.y > 7;
    }
    boolean isPawn() {
        return isPawn;
    }

    /**
     * @Method: Draws the figure
     */
    void draw() { // TODO: 23/03/2023 Properly draw image
        stift.bewegeBis(pos.x, pos.y);
        stift.zeichneKreis(20);
    }
    void kill() {
        isDead = true;
    }
    boolean isDead() {
        return isDead;
    }
}