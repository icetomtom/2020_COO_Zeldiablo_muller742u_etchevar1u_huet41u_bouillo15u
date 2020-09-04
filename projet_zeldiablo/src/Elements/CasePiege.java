package Elements;

/**
 * classe representant une case piege
 *
 */
public class CasePiege extends CaseAEffet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2896770426808755699L;
	
	/**
	 * attribut permettant de savoir si le piege a deja ete declenche une fois
	 */
	private boolean active;
	
	/**
	 * constructeur d'une case piege
	 * 
	 * @param x abscisse de la case
	 * @param y ordonnee de la case
	 */
	public CasePiege(int x, int y) {
		super(x, y, Case.TYPE_PIEGE);
		this.active = false;
	}

	/**
	 * methode permettant de blesser l'entite ayant marche sur la case
	 * 
	 * @param e entite ayant marche sur la case
	 */
	@Override
	public void activerEffet(Entite e) {
		e.subirDegats(1);
		
		if(!this.active) {
			this.active = true;
			this.setNomImage("entities_3_6");
		}
	}
	
	public boolean estActive() { return this.active; }
}