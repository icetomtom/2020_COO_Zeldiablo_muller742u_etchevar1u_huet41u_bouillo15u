package Elements;

import moteurJeu.sprite.Sprite;

/**
 * Classe représentant une case
 */
public class Case extends Sprite {

    /**
     * Position de la case
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
        super("entities_0_1");
        switch (type){
            case TYPE_VIDE:
                break;
            case TYPE_MUR:
                setNomImage("entities_0_2");
                break;
            case TYPE_EFFET:
                setNomImage("entities_0_3");
                break;
            default:
                throw new IllegalArgumentException("Type inconnu : " + type);
        }

        this.x = x;
        this.y = y;
        this.type = type;
    }

    /**
     * Getter de l'attibut type
     * @return le type de la case
     */
    public int getType() {
        return type;
    }

    @Override
    public int getPosX() {
        return x;
    }

    @Override
    public int getPosY() {
        return y;
    }
}