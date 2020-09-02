package Elements;

/**
 * classe representant une case avec un effet
 *
 */
public abstract class CaseAEffet extends Case {
	
	/**
	 * constructeur d'une case a effet
	 * 
	 * @param x abscisse de la case
	 * @param y ordonnee de la case
	 * @param type type de la case
	 */
	public CaseAEffet(int x, int y) {
		super(x, y, Case.TYPE_EFFET);
	}
	
	/**
	 * methode abstraite permettant de declencher l'effet de la case
	 * 
	 * @param e l'entite ayant marche sur la case
	 */
	public abstract void activerEffet(Entite e);
}
