package Monstre;

/**
 * 
 * classe representant un monstre immobile
 */
public class MonstreImmobile extends Monstre {
	
	/**
	 * Constructeur avec un string en parametre
	 */
	public MonstreImmobile() {
		super("entities_5_13");
	}
	
	@Override
	public void seDeplacer(int n) {
		return;
	}
}
