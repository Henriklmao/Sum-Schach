import sum.kern.Bildschirm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Figures {
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
            if (i < 8)
                pawn = new Pawn(Chess.Type.Black, bildschirm, table);
            else
                pawn = new Pawn(Chess.Type.White, bildschirm, table);
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
        testDead();

        for (Pawn pawn : Pawns) {
            pawn.draw();
        }
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
    }

    /** Initialiser **/
    void init() {
        initPawn();
        initRook();
        initBishop();
        initKnight();
        initKing();
        initQueen();
    }
    void initPawn() {
        // initialise pawns
        int i = 0;
        for (Pawn pawn : Pawns) {
            if (i == 8) i = 0; // For lateral displacement
            if (pawn.getTeam() == Chess.Type.Black) pawn.mov(i, 1);
            else pawn.mov(i, 6);
            i++;
        }
    }
    void initRook() {
        Rooks.get(0).mov(0, 0);
        Rooks.get(1).mov(7, 0);
        Rooks.get(2).mov(0, 7);
        Rooks.get(3).mov(7, 7);
    }
    void initBishop() {
        Bishops.get(0).mov(2, 0);
        Bishops.get(1).mov(5, 0);
        Bishops.get(2).mov(2, 7);
        Bishops.get(3).mov(5, 7);
    }
    void initKnight() {
        Knights.get(0).mov(1, 0);
        Knights.get(1).mov(6, 0);
        Knights.get(2).mov(1, 7);
        Knights.get(3).mov(6, 7);
    }
    void initKing() {
        Kings.get(0).mov(4, 0);
        Kings.get(1).mov(4, 7);
    }
    void initQueen() {
        Queens.get(0).mov(3, 0);
        Queens.get(1).mov(3, 7);
    }

    void kill(Figure figure) {
        figure.kill();
    }
    void testDead() {
        Pawns.removeIf(Figure::isDead);
        Bishops.removeIf(Figure::isDead);
        Rooks.removeIf(Figure::isDead);
        Queens.removeIf(Figure::isDead);
        Kings.removeIf(Figure::isDead);
        Knights.removeIf(Figure::isDead);
    }
    void mov(int x, int y, Figure subject) {
        subject.mov(x, y);
    }

}
