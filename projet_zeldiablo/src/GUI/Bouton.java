package GUI;

/**
 * classe representant un bouton
 *
 */
public class Bouton {

    private final String etape;
    private String label;
    private final int x, y, longeur, largeur;

    /**
     * Constructeur 
     * @param label
     * @param etape
     * @param x
     * @param y
     * @param longeur
     * @param largeur
     */
    public Bouton(String label, String etape, int x, int y, int longeur, int largeur) {
        this.etape = etape;
        this.label = label;
        this.x = x;
        this.y = y;
        this.longeur = longeur;
        this.largeur = largeur;
    }

    /** 
     * methode de collision
     * @param x
     * @param y
     * @return
     */
    public boolean collision(int x, int y) {
        boolean r = !(x < this.x || x > this.x + longeur || y < this.y || y > this.largeur + this.y);
        return r;
    }

    /**
     * setter de label
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * getter de label
     */
    public String getLabel() {
        return label;
    }

    /**
     * getter etape
     */
    public String getEtape() {
        return etape;
    }

    /**
     * getter longueur
     */
    public int getLongeur() {
        return longeur;
    }

    /**
     * getter largeur
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * getter x
     */
    public int getX() {
        return x;
    }

    /**
     * getter y
     */
    
    public int getY() {
        return y;
    }
}
