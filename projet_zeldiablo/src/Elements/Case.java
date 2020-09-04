package Elements;

import moteurJeu.sprite.Sprite;

import java.io.Serializable;

/**
 * Classe représentant une case
 */
public class Case extends Sprite implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5972635160189174690L;

	/**
     * Position de la case
     */
    private int x, y;

    /**
     * Type de la case
     */
    private int type;
    
    /**
     * Si la case est traversable ou non 
     */
    private boolean traversable;

    /**
     * Type représentant un vide
     */
    public static final int TYPE_VIDE = 1;
    /**
     * Type représentant un mur
     */
    public static final int TYPE_MUR = 2;
    
    /**
     * Type representant une case piege
     */
    public static final int TYPE_PIEGE = 3;
    
    /**
     * Type representant une porte
     */
    public static final int TYPE_PORTE = 4;
    
    /**
     * Type representant une case qui ouvre une porte
     */
    public static final int TYPE_OUVERTURE = 5;
    
    /**
     * Type representant une case qui ferme une porte
     */
    public static final int TYPE_FERMETURE = 6;
    
    /**
     * Type representant l'entree
     */
    public static final int TYPE_ENTREE = 7;
    
    /**
     * Constructeur
     */
    public Case(int x, int y, int type) {
        super("entities_2_3");
        
        this.setType(type);

        this.x = x;
        this.y = y;
        
        if(type == TYPE_MUR || type == TYPE_PORTE) {
        	this.traversable = false;
        }else {
        	this.traversable = true;
        }
    }

    /**
     * Getter de l'attibut type
     * @return le type de la case
     */
    public int getType() {
        return type;
    }
    
    /**
     * Getter de l'attribut traversable
     * @return l'attribut traversable
     */
    public boolean estTraversable() { return this.traversable; }
    
    /**
     * Setter de l'attribut traversable
     * @param t la nouvelle valeur de traverable
     */
    public void setTraversable(boolean t) {
    	this.traversable = t;	
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getPosX() {
        return x;
    }

    @Override
    public int getPosY() {
        return y;
    }
    
    public void setType(int newType) {
		this.type = newType;
		
		switch (type){
        case TYPE_VIDE:
            break;
        case TYPE_MUR:
            setNomImage("entities_0_1");
            break;
        case TYPE_PIEGE:
            break;
        case TYPE_PORTE:
        	setNomImage("entities_4_6");
        	break;
        case TYPE_OUVERTURE:
        	setNomImage("entities_2_6");
        	break;
        case TYPE_FERMETURE:
        	setNomImage("entities_1_6");
        	break;
        case TYPE_ENTREE:
        	setNomImage("entities_0_6");
        	break;
        default:
            throw new IllegalArgumentException("Type inconnu : " + type);
    }
	}
}