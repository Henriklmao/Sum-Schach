import sum.kern.Bildschirm;

public class Chess {
    enum Type {
        Black,
        White
    }
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
        figures.init();
        figures.draw();
        bildschirm.zeichneDich();
    }
}