package Elements;

/**
 * Classe représentant une case
 */
public class Case {

    /**
     * Coordonnées de la case
     */
    private int x, y;

    /**
     * Type de la case
     */
    private int type;

    /**
     * Type représentant un vide
     */
    public static final int TYPE_VIDE = 1;
    /**
     * Type représentant un mur
     */
    public static final int TYPE_MUR = 2;
    
    /**
     * Type representante un case a effet
     */
    public static final int TYPE_EFFET = 3;

    /**
     * Types disponibles
     */
    private static final int[] types_dispo = {TYPE_VIDE, TYPE_MUR, TYPE_EFFET};

    /**
     * Constructeur
     */
    public Case(int x, int y, int type) {
        boolean trouve = false;
        for(int t : types_dispo) {
            if (t == type) {
                trouve = true;
                break;
            }
        }
        if(!trouve)
            throw new IllegalArgumentException("Type inconnu : " + type);

        this.x = x;
        this.y = y;
        this.type = type;
    }

    /**
     * Getter de l'attibut x
     * @return position x
     */
    public int getX() {
        return x;
    }

    /**
     * Getter de l'attibut y
     * @return position y
     */
    public int getY() {
        return y;
    }

    /**
     * Getter de l'attibut type
     * @return le type de la case
     */
    public int getType() {
        return type;
    }
}