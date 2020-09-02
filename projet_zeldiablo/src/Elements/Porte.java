package Elements;

/**
 * classe representant une porte
 */
public class Porte extends Case {
	/**
	 * attribut qui permet de savoir si la porte est ouverte ou fermee
	 */
	private boolean ouverte;
	
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
		if(!this.ouverte) {
			this.ouverte = true;
		}
		
		//a faire : chgmt de sprite
	}
	
	/**
	 * getter de l'attribut ouverte
	 * 
	 * @return l'attribut ouverte
	 */
	public boolean estOuverte() { return this.ouverte; }
}
