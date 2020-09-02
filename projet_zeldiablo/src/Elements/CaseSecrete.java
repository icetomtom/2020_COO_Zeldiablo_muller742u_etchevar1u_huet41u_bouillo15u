package Elements;

/**
 * classe representant une case qui ouvre un passage secret
 *
 */
public class CaseSecrete extends CaseAEffet {
	
	/**
	 * attribut qui permet d'attribuer une porte
	 */
	private Porte porteLiee;
	
	/**
	 * constructeur d'une case secrete
	 * 
	 * @param x abscisse de la case
	 * @param y ordonnee de la case
	 */
	public CaseSecrete(int x, int y, Porte p) {
		super(x, y, Case.TYPE_SECRET);
		this.porteLiee = p;
	}

	@Override
	public void activerEffet(Entite e) {
		this.porteLiee.ouvrirPorte();
	}
}
