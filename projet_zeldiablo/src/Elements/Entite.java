package Elements;

import com.sun.jdi.Type;

import moteurJeu.sprite.Sprite;

public class Entite extends Sprite {

	/**
	 * point de vie de l entite
	 */
	protected int vie;

	/**
	 * Degats de l'entité
	 */
	protected int degats;

	/**
	 * Labyrinthe où se situe l'entité
	 */
	protected Labyrinthe labyrinthe;

	/**
	 * Type de l'entité
	 */
	protected Type entiteType;

	/**
	 * Nombre maximum de points de vie d'une entité
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
	 * @param x entier correspondant ï¿½ la nouvelle abscisse du joueur
	 */
	public void setPosX(int x) {
		this.x = x;
	}

	/**
	 * Methode qui permet de modifier l'ordonnee du joueur
	 * @param y entier correspondant ï¿½ la nouvelle ordonnee du joueur
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
	 * Méthode permettant de subir des dégats
	 *
	 * @param d degats subis
	 */
	public void subirDegats(int d) {
		vie = vie - d <= 0 ? 0 : vie - d;

	}
	
	  /**
     * Méthode permettant de savoir si le personnage
     * est décédé
     *
     * @return booléen si le personnage est mort
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
     * Getter pour le type de l'entité
     *
     * @return
     */
    public Type getType() {
        return entiteType;
    }
}
