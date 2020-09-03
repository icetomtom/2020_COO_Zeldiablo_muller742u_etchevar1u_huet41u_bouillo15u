package GUI;

public class Button {

    private final String etape, label;
    private final int x, y, longeur, largeur;

    public Button(String label, String etape, int x, int y, int longeur, int largeur) {
        this.etape = etape;
        this.label = label;
        this.x = x;
        this.y = y;
        this.longeur = longeur;
        this.largeur = largeur;
    }

    public boolean collision(int x, int y) {
        return !(x < this.x || x > this.x + longeur || y < this.y || y > this.largeur + y);
    }

    public String getLabel() {
        return label;
    }

    public String getEtape() {
        return etape;
    }

    public int getLongeur() {
        return longeur;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
