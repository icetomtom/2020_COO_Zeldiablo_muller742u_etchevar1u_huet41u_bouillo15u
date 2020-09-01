package Elements;

/**
 * classe representant une case piege
 *
 */
public class CasePiege extends CaseAEffet {
	/**
	 * attribut permettant de savoir si le piege a deja ete declenche une fois
	 */
	private boolean active;
	
	/**
	 * constructeur d'une case piege
	 * 
	 * @param x abscisse de la case
	 * @param y ordonne de la case
	 * @param type type de la case
	 */
	public CasePiege(int x, int y, int type) {
		super(x, y, type);
		this.active = false;
	}

	/**
	 * methode permettant de blesser l'entite ayant marche sur la case
	 * 
	 * @param e entite ayant marche sur la case
	 */
	@Override
	public void activerEffet(Entite e) {
		e.vie -= 1;
		
		if(!this.active) {
			this.active = true;
		}
	}
	
	public boolean estActive() { return this.active; }
}