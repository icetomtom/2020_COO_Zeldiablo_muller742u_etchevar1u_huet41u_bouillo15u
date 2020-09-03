package Elements;

/**
 * classe representant une porte
 */
public class Porte extends Case {
	/**
	 * 
	 */
	private static final long serialVersionUID = 450910692541530219L;

	/**
	 * constructeur d'une porte
	 * 
	 * @param x abscisse de la case
	 * @param y ordonnee de la case
	 */
	public Porte(int x, int y) {
		super(x, y, Case.TYPE_PORTE);
	}
	
	/**
	 * permet d'ouvrir ou de fermer une porte
	 * 
	 * @param b true = ouvrir, false = fermer
	 */
	public void changerEtat(boolean b) {
		if(b != this.estTraversable()) {
			this.setTraversable(b);
			
			if(b) {
				super.setNomImage("entities_4_7");
			}else {
				setNomImage("entities_4_6");
			}
		}
	}
}
