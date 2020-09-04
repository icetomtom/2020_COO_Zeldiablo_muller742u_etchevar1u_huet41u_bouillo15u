package Elements;

import moteurJeu.sprite.Sprite;

public class Entite extends Sprite {

	/**
	 * Position de l entite dans un labyrinthe
	 */
	protected int x, y;

	/**
	 * point de vie de l entite
	 */
	protected int vie;
	
	/**
	 * si l entite est vivante ou non
	 */
	protected boolean vivant;
	
	/**
	 * Degats de l entite
	 */
	protected int degats;

	/**
	 * Labyrinthe ou se situe l entite
	 */
	protected Labyrinthe labyrinthe;

	/**
	 * Nombre maximum de points de vie d'une entite 
	 */
	protected int maxPV;

	/**
	 * creation du sprite
	 *
	 * @param nom nom de l'image
	 */
	public Entite(String nom) {
		super(nom);
		this.degats=1;
		this.vivant=true;
		this.vie= 3;
		this.maxPV=3;
	}


	/**
	 * methode qui permet de retourner l abscisse du joueur
	 * @return un entier
	 */
	public int getPosX() {
		return this.x;
	}

	/**
	 * methode qui permet de retourner l ordonnee du joueur
	 * @return un entier
	 */
	public int getPosY() {
		return this.y;
	}

	/**
	 * Methode qui permet de modifier l abscisse du joueur
	 * @param x entier correspondant a la nouvelle abscisse du joueur
	 */
	public void setPosX(int x) {
		this.x = x;
	}

	/**
	 * Methode qui permet de modifier l ordonnee du joueur
	 * @param y entier correspondant a la nouvelle ordonnee du joueur
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
	 * Methode permettant de subir des degats
	 *
	 * @param d degats subis
	 */
	public void subirDegats(int d) {
		vie = vie - d;
		if (vie<=0) {
			vie =0;
			this.vivant=false;
		}
		

	}
	
	  /**
     * Methode permettant de savoir si le personnage
     * est en vie
     *
     * @return booleen si le personnage est mort
     */
    public boolean etreMort() {
        return !this.vivant;
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
    
    /**
     * methode qui permet de deplacer une entite dans une direction donnee
     * @param n correspond a une direction
     */
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
    
    /**
     * deplacement aleatoire d un monstre
     */
    public int deplacementAleatoire() {
    	return (int)(Math.random()*4);
    }
}
