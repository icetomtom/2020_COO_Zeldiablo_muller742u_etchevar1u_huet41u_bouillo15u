package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Elements.Case;
import Elements.CasePiege;
import Elements.CaseSecrete;
import Elements.Porte;
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
			j.deplacerEntite(j.getJoueur(),Jeu.LEFT);
		}
		
		for(int i = 0; i < 4; i++) {
			j.deplacerEntite(j.getJoueur(),Jeu.UP);
		}
		
		assertEquals("Le joueur doit avoir perdu un pdv", 9, j.getJoueur().getVie());
	}
	
	/**
	 * test d'une porte fermee
	 */
	@Test
	public void test_Porte_fermee() {
		//initialisation
		Porte p = new Porte(1, 1);
		CaseSecrete cs = new CaseSecrete(8, 8, p, Case.TYPE_OUVERTURE);
		Jeu j = new Jeu();
		j.getLaby().setCase(cs);
		j.getLaby().setCase(p);
		
		//verif
		for(int i = 0; i < 20; i++) {
			j.deplacerEntite(j.getJoueur(),Jeu.LEFT);
		}
		
		for(int i = 0; i < 20; i++) {
			j.deplacerEntite(j.getJoueur(),Jeu.UP);
		}
		
		//le joueur doit etre bloque par la porte fermee
		assertEquals("L'ordonnee du joueur doit etre 2", 2, j.getJoueur().getPosY());
	}
	
	/**
	 * test d'une porte ouverte
	 */
	@Test
	public void test_Porte_ouverte() {
		//initialisation
		Porte p = new Porte(1, 1);
		CaseSecrete cs = new CaseSecrete(3, 4, p, Case.TYPE_OUVERTURE);
		Jeu j = new Jeu();
		j.getLaby().setCase(cs);
		j.getLaby().setCase(p);
		
		//verif
		for(int i = 0; i < 20; i++) {
			j.deplacerEntite(j.getJoueur(),Jeu.LEFT);
		}
		
		for(int i = 0; i < 20; i++) {
			j.deplacerEntite(j.getJoueur(),Jeu.UP);
		}
		
		//le joueur doit pouvoir traverser la porte
		assertEquals("L'ordonnee du joueur doit etre 1", 1, j.getJoueur().getPosY());
	}
	
	/**
	 * test de l'ouverture d'une porte
	 */
	@Test
	public void test_ouvrir_porte() {
		//initialisation
		Porte p = new Porte(1, 1);
		CaseSecrete cs = new CaseSecrete(3, 4, p, Case.TYPE_OUVERTURE);
		Jeu j = new Jeu();
		j.getLaby().setCase(cs);
		j.getLaby().setCase(p);
		
		//verif
		j.deplacerEntite(j.getJoueur(),Jeu.LEFT);
		
		assertEquals("La porte doit etre ouverte", true, p.estTraversable());
	}
	
	/**
	 * test de la fermeture d'une porte
	 */
	@Test
	public void test_fermer_porte() {
		//initialisation
		Porte p = new Porte(1, 1);
		CaseSecrete cs = new CaseSecrete(3, 4, p, Case.TYPE_OUVERTURE);
		CaseSecrete cs1 = new CaseSecrete(2, 4, p, Case.TYPE_FERMETURE);
		Jeu j = new Jeu();
		j.getLaby().setCase(cs);
		j.getLaby().setCase(cs1);
		j.getLaby().setCase(p);
		
		//verif
		j.deplacerEntite(j.getJoueur(),Jeu.LEFT); //la porte s'ouvre
		j.deplacerEntite(j.getJoueur(),Jeu.LEFT); //puis se ferme
		
		assertEquals("La porte doit etre fermee", false, p.estTraversable());
	}
}
