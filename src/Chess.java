import sum.kern.*;

import java.util.ArrayList;
import java.util.List;

public class Chess {
    Bildschirm bildschirm = new Bildschirm(true);
    Table table;
    Figures figures;

    public static void main(String[] args) {
        new Chess();
    }
    Chess() {

        table = new Table(bildschirm);
        figures = new Figures(table, bildschirm);
        Game();
    }
    void CheckScreen() {
       // if (bildschirm.hoehe() == )
    }

    void Game() {
        table.draw();
        while (true) {
            bildschirm.zeichneDich();
        }
    }
}