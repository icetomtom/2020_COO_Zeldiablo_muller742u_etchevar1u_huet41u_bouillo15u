package GUI;

public class Bouton {

    private final String etape;
    private String label;
    private final int x, y, longeur, largeur;

    public Bouton(String label, String etape, int x, int y, int longeur, int largeur) {
        this.etape = etape;
        this.label = label;
        this.x = x;
        this.y = y;
        this.longeur = longeur;
        this.largeur = largeur;
    }

    public boolean collision(int x, int y) {
        boolean r = !(x < this.x || x > this.x + longeur || y < this.y || y > this.largeur + this.y);
        return r;
    }

    public void setLabel(String label) {
        this.label = label;
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
