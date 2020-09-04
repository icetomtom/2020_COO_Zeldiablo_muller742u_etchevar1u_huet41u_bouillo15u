package Elements;

public abstract class Arme implements Objet {
	
	protected int degats;
	protected int resistance;
	
	/**
	 * getter de l attribut degats
	 * @return le nombre de degats
	 */
	public int getDegats(){
		return degats;
	}
	/**
	 * getter de l attribut resistance
	 * @return la resistance 
	 */
	public int getResistance() {
		return resistance;
	}
	/**
	 * methode abstraite permettant de donner le nom d un objet 
	 */
	public abstract String getNomObjet();
}
