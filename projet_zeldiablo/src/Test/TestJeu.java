package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Elements.Jeu;

public class TestJeu {
	
	/**
	 * test quand le joueur se deplace dans le vide
	 */
	@Test
	public void methode_seDeplacer_vide() {
		//initialisation des valeurs
		Jeu j = new Jeu();
		
		//test de la methode
		int yOld = j.getJoueur().getPosY();
		j.deplacerJoueur(Jeu.DOWN);
		
		assertEquals("Le joueur doit s'etre deplace vers le bas", yOld + 1, j.getJoueur().getPosY());
	}
	
	/**
	 * test quand le joueur se deplace dans un mur
	 */
	@Test
	public void methode_seDeplacer_mur() {
		//initialisation des valeurs
		Jeu j = new Jeu();
		
		//test de la methode, on avance le personnage assez pour etre sur d'avoir rencontre un mur
		for(int i = 0; i < 20; i++) {
			j.deplacerJoueur(Jeu.LEFT);
		}
		
		assertEquals("Le joueur doit etre au bord du labyrinthe, donc a x = 1", 1, j.getJoueur().getPosX());
	}
}
