import sum.kern.Bildschirm;
import sum.kern.Stift;

import java.awt.*;

// 8x8
public class Table {

    double factorH = .075;
    double factorV = .1;
    Bildschirm bildschirm;
    Stift stift = new Stift();
    Square[][] Rows = new Square[0x8][0x8];


    Table(Bildschirm bildschirm) {
        this.bildschirm = bildschirm;
    }

    // Section Reference------------------------------------
    private void reference() {
        resetPos();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Rows[i][j] = new Square(bildschirm, factorH, factorV, j, i);
            }

        }
    }

    Point getField(int x, int y){
        return Rows[y][x].getPos();
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
