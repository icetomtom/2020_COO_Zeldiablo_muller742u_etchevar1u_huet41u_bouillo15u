package Elements;

/**
 * classe representant une porte
 */
public class Porte extends Case {
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
	 * permet d'ouvrir la porte
	 */
	public void ouvrirPorte() {
		if(!this.estTraversable()) {
			this.setTraversable(true);
		}
		
		//a faire : chgmt de sprite
	}
}
