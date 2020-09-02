package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Elements.Case;
import Elements.CasePiege;
import Partie.Jeu;

/** 
 * test la classe Case
 */
public class TestCase {
	/**
	 * test le constructeur avec les valeurs par defauts
	 */
	@Test
	public void test_ConstructeurDefaut() {
		Case c = new Case(0, 1, Case.TYPE_VIDE);
		
		assertEquals("la valeur par defaut n est pas bonne", 0, c.getPosX());
		assertEquals("la valeur par defaut n est pas bonne", 1, c.getPosY());
		assertEquals("la valeur n'est pas bonne", Case.TYPE_VIDE, c.getType());
		
	}

	/**
	 * test des cases pieges
	 */
	@Test
	public void test_CasePiege() {
		//initialisation
		CasePiege c = new CasePiege(1, 1);
		Jeu j = new Jeu();
		j.getLaby().setCase(c);
		
		//verification
		for(int i = 0; i < 4; i++) {
			j.deplacerJoueur(Jeu.LEFT);
		}
		
		for(int i = 0; i < 4; i++) {
			j.deplacerJoueur(Jeu.UP);
		}
		
		assertEquals("Le joueur doit avoir perdu un pdv", 9, j.getJoueur().getVie());
	}
}
