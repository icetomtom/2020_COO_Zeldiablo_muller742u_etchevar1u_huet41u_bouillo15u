package Monstre;

import Elements.Entite;

/**
 * classe representant un monstre de type fantome
 */
public class Fantome extends Entite {
	
	/**
	 * Constructeur avec un string en parametre
	 * @param nom correspondant au nom du monstre
	 */
	public Fantome(String nom) {
		super(nom);
		this.vie = 2;	
	}
	

}
