import sum.kern.*;
public class Schach {
    Bildschirm bildschirm;
    Table table;
    public static void main(String[] args) {
        new Schach();
    }
    Schach() {
        bildschirm = new Bildschirm(); // TODO: Set to true when ready!
        table = new Table(bildschirm);

    }

    void Game() {
        table.draw();
    }
}