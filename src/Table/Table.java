import sum.kern.Bildschirm;
import sum.kern.Stift;

import java.awt.*;
import java.util.ArrayList;

// 8x8
public class Table {

    int x[];
    int y[];
    double factorH = .075;
    double factorV = .1;
    Bildschirm bildschirm;
    Stift stift = new Stift();
    ArrayList[] Rows;


    Table(Bildschirm bildschirm) {
        this.bildschirm = bildschirm;
    }

    // Section Reference------------------------------------
    private void reference() {
        resetPos();
        for (int i = 0; i < 8; i++) {
            ArrayList<Square> table = new ArrayList<Square>();
            for (int j = 0; j < 8; j++) {
                Square square = new Square(bildschirm, factorH, factorV, j, i);
                table.add(square);
            }
            Rows[i] = table;
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
