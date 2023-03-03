import sum.kern.Bildschirm;
import sum.kern.Stift;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// 8x8
public class Table {

    int[] x;
    int[] y;
    double factorH = .075;
    double factorV = .1;
    Bildschirm bildschirm;
    Stift stift = new Stift();
    Square[][] Rows = new Square[0x8][0x8];
    Square[] table = new Square[0x8];


    Table(Bildschirm bildschirm) {
        this.bildschirm = bildschirm;
    }

    // Section Reference------------------------------------
    private void reference() {
        resetPos();
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                table[j] = new Square(bildschirm, factorH, factorV, j, i);
                Rows[i][j] = table[j];
            }

        }
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
