package Elements;

import moteurJeu.sprite.Sprite;

public class Entite extends Sprite {

	/**
	 * Position de l'entite dans un labyrinthe
	 */
	protected int x, y;

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
     * methode d attaque 
     * @param e Entite
     */
    public void attaquer(Entite e) {
    	e.subirDegats(degats);
    }
    
    public void seDeplacer(int n) {
    	switch(n) {
    	case 0:
    		this.y--;
    		break;
    	case 1:
    		this.y++;
    		break;
    	case 2:
    		this.x--;
    		break;
    	case 3:
    		this.x++;
    		break;
    	}
    }
}
