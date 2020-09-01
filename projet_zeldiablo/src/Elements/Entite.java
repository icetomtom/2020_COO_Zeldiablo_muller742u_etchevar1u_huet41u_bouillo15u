package Elements;

import com.sun.jdi.Type;

import moteurJeu.sprite.Sprite;

public class Entite extends Sprite {

	/**
	 * point de vie de l entite
	 */
	protected int vie;

	/**
	 * Degats de l'entit�
	 */
	protected int degats;

	/**
	 * Labyrinthe o� se situe l'entit�
	 */
	protected Labyrinthe labyrinthe;

	/**
	 * Type de l'entit�
	 */
	protected Type entiteType;

	/**
	 * Nombre maximum de points de vie d'une entit�
	 */
	private int maxPV;

	/**
	 * creation du sprite
	 *
	 * @param nom nom de l'imaeg
	 */
	public Entite(String nom) {
		super(nom);
	}


	/**
	 * methode qui permet de retourner l'abscisse du joueur
	 * @return un entier
	 */
	public int getPosX() {
		return this.x;
	}

	/**
	 * methode qui permet de retourner l'ordonnee du joueur
	 * @return un entier
	 */
	public int getPosY() {
		return this.y;
	}

	/**
	 * Methode qui permet de modifier l'abscisse du joueur
	 * @param x entier correspondant � la nouvelle abscisse du joueur
	 */
	public void setPosX(int x) {
		this.x = x;
	}

	/**
	 * Methode qui permet de modifier l'ordonnee du joueur
	 * @param y entier correspondant � la nouvelle ordonnee du joueur
	 */
	public void setPosY(int y) {
		this.y = y;
	}

	public int getVie() {
		return this.vie;
	}

	/**
	 * Setter pour degats
	 *
	 * @param degats degats
	 */
	public void setDegats(int degats) {
		this.degats = degats;
	}

	/**
	 * M�thode permettant de subir des d�gats
	 *
	 * @param d degats subis
	 */
	public void subirDegats(int d) {
		vie = vie - d <= 0 ? 0 : vie - d;

	}
	
	  /**
     * M�thode permettant de savoir si le personnage
     * est d�c�d�
     *
     * @return bool�en si le personnage est mort
     */
    public boolean etreMort() {
        return this.vie == 0;
    }
    
    /**
     * Setter pour labyrinthe
     *
     * @param l labyrinthe
     */
    public void setLabyrinthe(Labyrinthe l) {
        this.labyrinthe = l;
    }
    
    /**
     * Getter pour le type de l'entit�
     *
     * @return
     */
    public Type getType() {
        return entiteType;
    }
}
