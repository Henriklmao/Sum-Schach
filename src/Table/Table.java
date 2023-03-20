import sum.kern.Bildschirm;
import sum.kern.Stift;

import java.awt.*;

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

    // Section Reference------------------------------------
    private void reference() {
        resetPos();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new Square(bildschirm, factorH, factorV, j, i);
            }

        }
    }

    Point getSquare(int x, int y){
        return squares[y][x].getPos();
    }

    // Section Draw-----------------------------------------
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
    void mov(Figure mover, Point sqr) {
        squares[sqr.y][sqr.x].occupy(mover, mover.getTeam());
    }
    boolean testMov(Figure mover, Point trial) {
        if (squares[trial.y][trial.x].isOccupied()) {
            return squares[trial.y][trial.x].isFriendly(mover.getTeam());
        }
        return false;
    }
    private void resetPos() {
        stift.bewegeBis(bildschirm.breite()*factorH,bildschirm.hoehe()*factorV);
    }
    private void resetH() {
        stift.bewegeBis(bildschirm.breite()*factorH, stift.vPosition());
    }
    private void nextSquare(boolean draw) {
        if (draw) stift.zeichneRechteck(bildschirm.breite()*factorH,bildschirm.hoehe()*factorV);
        if (stift.winkel()==0) stift.bewegeUm(bildschirm.breite()*factorH);
        else stift.bewegeUm(bildschirm.hoehe()*factorV);
    }
}
