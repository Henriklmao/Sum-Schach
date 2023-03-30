import sum.kern.Bildschirm;
import sum.kern.Buntstift;
import sum.kern.Maus;

import java.awt.*;
import java.util.ArrayList;

public class Chess {
    enum Type {
        Black,
        White
    }

    Bildschirm bildschirm = new Bildschirm(true);
    Maus mouse = new Maus();
    Table table;
    Figures figures;
    Point selected;
    Figure subject;
    Buntstift stift = new Buntstift();
    ArrayList<Point> legalMoves;

    public static void main(String[] args) {
        new Chess();
    }

    Chess() {
        table = new Table(bildschirm);
        figures = new Figures(table, bildschirm);
        Game();
    }

    /**
     * @Method: Main method which includes the game loop.
     */
    void Game() {
        while (true) { // TODO: 30/03/2023 replace true. Used as placeholder
            if (selected == null) checkMouse();
            if(selected != null) {
                subject = table.getOccupant(selected.x, selected.y);
                drawLegalMoves();
                checkMov();
            }

            table.draw();
            figures.init();
            figures.draw();
            bildschirm.zeichneDich();
        }
    }

    /**
     * @Method: Sets selected square to mouse pressed
     */
    void checkMouse() {
        if (mouse.istGedrueckt()) {
            selected = table.getMouseSquare(mouse);
        }
    }

    /**
     * @Method: Visually draws legal move possibilities
     */
    void drawLegalMoves(){
        legalMoves = subject.getLegalMoves();
        for (Point legalMove : legalMoves) {
            stift.bewegeBis(legalMove.x, legalMove.y);
            stift.zeichneKreis(10);
            stift.setzeFuellMuster(1);
            if (table.isEnemy(legalMove.x, legalMove.y, subject))
                stift.setzeFarbe(Color.RED);
            else stift.setzeFarbe(Color.BLACK);
        }
    }

    /**
     * @Method: Secondary game loop to check where to move the
     */
    void checkMov(){
        checkMouse();
        for (Point legalMove : legalMoves) {
            if (selected == null) return;
            if (legalMove == selected) mov(legalMove, subject);
        }
    }
    void mov(Point pos, Figure object) {
        figures.mov
    }
}
