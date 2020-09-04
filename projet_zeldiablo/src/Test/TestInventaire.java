package Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import Elements.Labyrinthe;
import Elements.Niveau;
import Partie.Jeu;

public class TestInventaire {
	
	@Test
	public void test_ramasser() {
		//initialisation
		Labyrinthe l = new Labyrinthe();
		Jeu j = new Jeu();
		j.initialiserAvecNiveau(new Niveau(l,new ArrayList<>()));
		
		//verification
		j.getJoueur().ramasser(j.getLaby().getAmulette());
		
		assertEquals("L'inventaire du joueur doit avoir une taille de 1", 1, j.getJoueur().getInventaire().size() - 1);
	}
}
