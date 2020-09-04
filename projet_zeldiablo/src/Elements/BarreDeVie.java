package Elements;

import moteurJeu.sprite.Sprite;

/**
 * classe representant une barre de vie
 *
 */
public class BarreDeVie extends Sprite {
	/**
	 * coordonnees de la barre de vie
	 */
	private int x, y;

	/**
	 * constructeur par defaut
	 * 
	 * @param nom nom du sprite a charger
	 */
	public BarreDeVie(String nom) { super(nom); }

	@Override
	public int getPosX() { return this.x; }

	@Override
	public int getPosY() { return this.y; }
	
	/**
	 * permet a la barre de vie de suivre l'entite
	 * @param x abscisse
	 * @param y ordonnee
	 */
	public void updatePos(int x, int y) {
		this.x = x; this.y = y;
	}

}
