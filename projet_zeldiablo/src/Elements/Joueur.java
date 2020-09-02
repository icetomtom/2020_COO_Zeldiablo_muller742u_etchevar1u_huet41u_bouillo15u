package Elements;

import moteurJeu.sprite.Sprite;

/**
 * 
 * classe representant un joueur
 */
public class Joueur extends Entite{
	
	/**
	 *  attribut correspondant � la derniere direction du joueur
	 */
	private int direction;
	/**
	 * contructeur vide de la classe joueur
	 */
	public Joueur() {
		this(0, 0);
	}
	
	/**
	 * Constructeur avec paramtre de la classe joueur
	 * @param x entier correspondant � l'abscisse du joueur
	 * @param y entier correspondant a l'ordonnee du joueur
	 */
	public Joueur(int x,int y) {
		super("entities_3_2");
		this.vie = 10;
		this.x=x;
		this.y=y;

	}
	
	/**
	 * Methode qui sert � deplacer le jouer 
	 * @param x entier correspondant � la nouvelle abscisse du joueur
	 * @param y entier correspondant a la nouvelle ordonnee du joueur
	 */
	public void seDeplacer(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	/**
	 * methode permettant de se souvenir de la derni�re direction du joueur
	 * @param n
	 */
	public void setDirection(int n) {
		this.direction =n;
	}
	
	/**
	 * methode permettant de recuperer la direction
	 * @return un entier correspondant � la direction
	 */
	public int getDirection() {
		return this.direction;
	}

}
