package Elements;

import moteurJeu.sprite.Sprite;

/**
 * classe representant une amulette
 *
 */
public class Amulette extends Sprite implements Objet {

	/**
	 * abscisse et ordonnee de l'amulette
	 */
	private int x, y;
	
	/**
	 * constructeur par defaut d'une amulette
	 * 
	 * @param nom sprite de l'amulette
	 */
	public Amulette(String nom) {
		super(nom);
	}
	
	/**
	 * constructeur d'une amulette
	 * 
	 * @param nom sprite de l'amulette
	 * @param x abscisse de l'amulette
	 * @param y ordonnee de l'amulette
	 */
	public Amulette(String nom, int x, int y) {
		super(nom);
		this.x = x;
		this.y = y;
	}	
	
	@Override
	public String getNomObjet() {
		return "Amulette";
	}

	@Override
	public boolean etreUtilise(Joueur j) {
		return j.getInventaire().contains(this);
	}

	@Override
	public int getPosX() {
		return this.x;
	}

	@Override
	public int getPosY() {
		return this.y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
