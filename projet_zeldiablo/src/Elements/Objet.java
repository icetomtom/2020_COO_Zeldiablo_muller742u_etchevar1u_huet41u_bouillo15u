package Elements;

public interface Objet {
	
	/**
	 * methode abstraite donnant le nom de l objet
	 */
	public abstract String getNomObjet();
	
	/**
	 * methode abstraite donnant si l objet peut etre utiliser 
	 * @param j
	 */
	public abstract boolean etreUtilise(Joueur j);
}
