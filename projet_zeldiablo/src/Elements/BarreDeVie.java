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
	private int x;
	private int y;
	private int vie_initiale;

	/**
	 * constructeur par defaut
	 * 
	 * @param nom nom du sprite a charger
	 */
	public BarreDeVie(String nom, int x, int y, int vie_max) { super(nom); this.x = x; this.y = y; this.vie_initiale = vie_max;}

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

	public void setVieMax(int vie) {
		vie_initiale = vie;
	}

	public void setVie(int vie) {
		float r = (float)vie / vie_initiale;
		if(r < 0.33)
			setNomImage("entities_2_15");
		else if(r < 0.66)
			setNomImage("entities_1_15");
		else
			setNomImage("entities_0_15");

	}

}
