package Elements;

public class Boucliers extends Arme {
	
	/**
	 * getter retournant le nom de l objet
	 */
	public String getNomObjet() {
		return "Bouclier";
	}

	/**
	 * methode retournant si l objet peut etre utiliser
	 */
	@Override
	public boolean etreUtilise(Joueur j) {
		// TODO Auto-generated method stub
		return false;
	}
}
