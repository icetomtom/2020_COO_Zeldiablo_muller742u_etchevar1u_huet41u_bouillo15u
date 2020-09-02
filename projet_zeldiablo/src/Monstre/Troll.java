package Monstre;

import Elements.Entite;

/**
 * 
 * classe representant un monstre de type troll
 */
public class Troll extends Entite {
	
	/**
	 * attribut booleen prive qui annonce si le troll se fait attaquer 
	 */
	private boolean est_attaque;
	
	/**
	 * Constructeur avec un string en parametre
	 * @param nom correspondant au nom du monstre
	 */
	public Troll(String nom) {
		super(nom);
		this.vie = 4;
	}

}
