package Elements;

public class Epee extends Arme {

	/**
	 * contructeur
	 */
	public Epee (){
		this.degats = 6;
	}
	/**
	 * getter retournant le nom de l objet
	 */
	public String getNomObjet() {
		return "Epee";
	}
	
	
	/**
	 * methode retournant si l objet peut etre utiliser
	 */
	@Override
	public boolean etreUtilise(Joueur j) {
		return false;
	}
}
