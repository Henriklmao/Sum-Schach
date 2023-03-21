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
    ArrayList<Knight> Knights;
    ArrayList<King> Kings;
    ArrayList<Queen> Queens;
    Bildschirm bildschirm;
    Table table;

    Figures(Table table, Bildschirm bildschirm) {
        this.table = table;
        this.bildschirm = bildschirm;

        // Init Arrays
        Pawns = new ArrayList<>();
        Bishops = new ArrayList<>();
        Rooks = new ArrayList<>();
        Knights = new ArrayList<>();
        Kings = new ArrayList<>();
        Queens = new ArrayList<>();

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
        // Knights
        for (int i = 0; i < 4; i++) {
            Knight knight;
            if (i < 2) {
                knight = new Knight(Chess.Type.Black, bildschirm, table);
            } else {
                knight = new Knight(Chess.Type.White, bildschirm, table);
            }
            Knights.add(knight);
        }

        // Queens and Kings
        Queen queen;
        King king;
        queen = new Queen(Chess.Type.Black, bildschirm, table);
        king = new King(Chess.Type.Black, bildschirm, table);
        Queens.add(queen);
        Kings.add(king);
        queen = new Queen(Chess.Type.White, bildschirm, table);
        king = new King(Chess.Type.White, bildschirm, table);
        Queens.add(queen);
        Kings.add(king);
    }

    void draw() {

        for (Pawn pawn : Pawns) {
            pawn.draw();
        }
        /*
        for (Bishop bishop : Bishops) {
            bishop.draw();
        }
        for (Rook rook : Rooks) {
            rook.draw();
        }
        for (Knight knight : Knights) {
            knight.draw();
        }
        for (Queen queen : Queens) {
            queen.draw();
        }
        for (King king : Kings) {
            king.draw();
        }
         */

    }

    void init() {
        int i = 0;
        for (Pawn pawn : Pawns) {
            if (i == 8) i = 0;
            if (pawn.getTeam() == Chess.Type.Black) pawn.mov(2, i);
            else pawn.mov(6, i);
            i++;
        }
    }

    void kill() {

    }

}
