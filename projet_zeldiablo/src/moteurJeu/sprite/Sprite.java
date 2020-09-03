package moteurJeu.sprite;

import Partie.DessinPartie;

import java.awt.Graphics;
import java.io.Serializable;

/**
 * un sprite correspond � une image positionn�e � un endroit de la scene
 * 
 * @author vthomas
 *
 */
public abstract class Sprite implements Serializable {

	/**
	 * le nom de l'image stock�e dans Images
	 */
	String nomImage;

	/**
	 * creation du sprite
	 * 
	 * @param nom
	 *            nom de l'imaeg
	 */
	public Sprite(String nom) {
		this.nomImage = nom;
	}

	/**
	 * Permet de changer l'image du sprite
	 * @param nomImage
	 */
	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}

	/**
	 * permet de dessiner le sprite avec un graphics
	 * 
	 * @param g
	 *            graphics pour dessiner
	 */
	public void dessiner(Graphics g) {
//		System.out.println("Dessine : "+getPosX()+ " " +getPosY() + " " + this.nomImage);
		Sprites.dessiner(g, this.nomImage, getPosX() * DessinPartie.TAILLE_CASE, getPosY() * DessinPartie.TAILLE_CASE);
	}

	/**
	 * Permet d'obtenir la position X du sprite dans le labyrinthe
	 */
	public abstract int getPosX();


	/**
	 * Permet d'obtenir la position Y du sprite dans le labyrinthe
	 */
	public abstract int getPosY();

}
