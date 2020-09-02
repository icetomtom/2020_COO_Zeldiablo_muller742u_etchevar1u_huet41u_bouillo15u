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
	
	/**
	 * methode qui permet au monstre de se deplacer
	 * @param x correspondant a l'abscisse
	 * @param y correspondant a l'ordonnee
	 */
	public void seDeplacer(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
