package Elements;
/**
 * 
 * classe representant un joueur
 */
public class Joueur extends Entite{
	/**
	 * attribut prive d'un entier correspondant a l'abscisse du joueur
	 */
	private int PosX;
	/**
	 * attribut prive d'un entier correspondant a l'ordonnee du joueur
	 */
	private int PosY;
	
	/**
	 * contructeur vide de la classe joueur
	 */
	public Joueur() {
		this.PosX=0;
		this.PosY=0;
		
	}
	
	/**
	 * Constructeur avec paramtre de la classe joueur
	 * @param x entier correspondant à l'abscisse du joueur
	 * @param y entier correspondant a l'ordonnee du joueur
	 */
	public Joueur(int x,int y) {
		this.PosX=x;
		this.PosY=y;

	}
	
	/**
	 * Methode qui sert à deplacer le jouer 
	 * @param x entier correspondant à la nouvelle abscisse du joueur
	 * @param y entier correspondant a la nouvelle ordonnee du joueur
	 */
	public void seDeplacer(int x,int y) {
		this.PosX=x;
		this.PosY=y;
	}
	
	/**
	 * methode qui permet de retourner l'abscisse du joueur
	 * @return un entier 
	 */
	public int getPosX() {
		return this.PosX;
	}
	
	/**
	 * methode qui permet de retourner l'ordonnee du joueur
	 * @return un entier 
	 */
	public int getPosY() {
		return this.PosY;
	}
	
	/**
	 * Methode qui permet de modifier l'abscisse du joueur
	 * @param x entier correspondant à la nouvelle abscisse du joueur
	 */
	public void setPosX(int x) {
		this.PosX=x;
	}
	
	/**
	 * Methode qui permet de modifier l'ordonnee du joueur
	 * @param y entier correspondant à la nouvelle ordonnee du joueur
	 */
	public void setPosy(int y) {
		this.PosY=y;
	}
}
