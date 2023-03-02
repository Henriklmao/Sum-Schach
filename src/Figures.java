import sum.kern.Bildschirm;

import java.awt.*;
import java.util.ArrayList;

public class Figures {
    enum Type {
        BLACK,
        WHITE
    }
    ArrayList<Pawn> Pawns;
    ArrayList<Bishop> Bishops;
    ArrayList<Rook> Rooks;
    ArrayList<Knight> Knight;
    ArrayList<King> Kings;
    ArrayList<Queen> Queens;
    ArrayList[] all;
    Bildschirm bildschirm;
    Table table;

    Figures(Table table, Bildschirm bildschirm) {
        this.table = table;
        this.bildschirm = bildschirm;

        // Init Arrays
        var Pawns = new ArrayList<Pawn>();
        var Bishops = new ArrayList<Bishop>();
        var Rooks = new ArrayList<Rook>();
        var Queens = new ArrayList<Queen>();
        var Kings = new ArrayList<King>();

        all = new ArrayList[]{Pawns, Bishops, Rooks, Queens, Kings};

        for (int i = 0; i < 16; i++) {
            Pawn pawn;
            if (i <= 2) {
                pawn = new Pawn(Pawn.Type.BLACK, bildschirm, table, i);
            } else {
                pawn = new Pawn(Pawn.Type.WHITE, bildschirm, table, i);
            }
            Pawns.add(pawn);
        } // Spawn Pawns
        /*for (int i = 0; i < 2; i++) {
            King king;
            if (i == 1) {
                king = new King(King.Type.BLACK, bildschirm, table, i);
            } else {
                king = new Pawn(King.Type.WHITE, bildschirm, table, i);
            }
            Kings.add(King);
        }*/
    }
    void Kill(int type, int n) {
        all[type].remove(n);
    }

}
