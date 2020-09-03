package Elements;

/**
 * classe qui represente soit une case d'ouverture soit de fermeture
 *
 */
public class CaseSecrete extends CaseAEffet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1437108661682900514L;
	
	/**
	 * porte liee a	la case secrete
	 */
	private Porte porteLiee;
	
	/**
	 * effet de la case | true = ouverture, false = fermeture
	 */
	private boolean effet;
	
	/**
	 * constructeur d'une case secrete
	 * 
	 * @param x abscisse
	 * @param y ordonnee
	 * @param p porte liee
	 * @param b true = ouverture, false = fermeture
	 */
	public CaseSecrete(int x, int y, Porte p, int type) {
		super(x, y, type);
		this.porteLiee = p;
		
		if(type == Case.TYPE_FERMETURE) {
			this.effet = false;
		}else if(type == Case.TYPE_OUVERTURE) {
			this.effet = true;
		}else {
			throw new Error("Aie");
		}
	}

	@Override
	public void activerEffet(Entite e) {
		this.porteLiee.changerEtat(this.effet);
	}
}
