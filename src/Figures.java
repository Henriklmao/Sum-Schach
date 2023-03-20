import sum.kern.Bildschirm;

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

        // Pawns
        for (int i = 0; i < 16; i++) {
            Pawn pawn;
            if (i < 8) {
                pawn = new Pawn(Chess.Type.Black, bildschirm, table);
            } else {
                pawn = new Pawn(Chess.Type.White, bildschirm, table);
            }
            Pawns.add(pawn);
        }

        // Bishops
        for (int i = 0; i < 4; i++) {
            Bishop bishop;
            if (i < 2) {
                bishop = new Bishop(Chess.Type.Black, bildschirm, table);
            } else {
                bishop = new Bishop(Chess.Type.White, bildschirm, table);
            }
            Bishops.add(bishop);
        }

        // Rooks
        for (int i = 0; i < 4; i++) {
            Rook rook;
            if (i < 2) {
                rook = new Rook(Chess.Type.Black, bildschirm, table);
            } else {
                rook = new Rook(Chess.Type.White, bildschirm, table);
            }
            Rooks.add(rook);
        }

        // Queens and Kings
        Queen queen;
        King king;
        queen = new Queen(Chess.Type.Black, bildschirm, table);
        king = new King(Chess.Type.Black, bildschirm, table);
        Queens.add(queen);
        Kings.add(king);

        queen = new Queen(Chess.Type.Black, bildschirm, table);
        king = new King(Chess.Type.Black, bildschirm, table);
        Queens.add(queen);
        Kings.add(king);
    }

    void draw() {
        for (Pawn pawn : Pawns) {
            pawn.draw();
        }
        for (Bishop bishop : Bishops) {
            bishop.draw();
        }

    }

    void init() {

    }
    void Kill(int type, int n) {
        all[type].remove(n);
    }

}
