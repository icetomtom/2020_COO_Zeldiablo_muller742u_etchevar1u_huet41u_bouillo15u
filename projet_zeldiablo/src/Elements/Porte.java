package Elements;

/**
 * classe representant une porte
 */
public class Porte extends CaseAEffet {
	/**
	 * attribut qui permet de savoir si la porte est ouverte ou fermee
	 */
	private boolean ouverte;
	
	/**
	 * constructeur d'une porte
	 * 
	 * @param x abscisse de la case
	 * @param y ordonnee de la case
	 * @param type type de la case
	 */
	public Porte(int x, int y) {
		super(x, y);
		this.ouverte = false;
	}
	
	@Override
	public void activerEffet(Entite e) {
		this.ouverte = true;
	}
	
	public boolean estOuverte() { return this.ouverte; }
}
