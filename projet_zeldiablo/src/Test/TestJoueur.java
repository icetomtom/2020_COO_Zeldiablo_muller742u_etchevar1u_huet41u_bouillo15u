package Test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import Elements.Joueur;

/**
 * 
 * @author Huet Guillaume
 * classe de test de la classe joueur
 */
public class TestJoueur {
	
	/**
	 * Methode qui permet de tester le contructeur vide d'un joueur
	 */
	@Test
	public void testConstructeurVide() {
		Joueur j = new Joueur();
		assertEquals("Le joueur n'est pas à la bonne abscisse",0,j.getPosX());
		assertEquals("Le joueur n'est pas à la bonne ordonnee",0,j.getPosY());
		
	}
	
	/**
	 * Methode qui permet de tester le constructeur avec parametres d'un joueur
	 */
	@Test
	public void testConstructeur() {
		int x=4;
		int y=4;
		Joueur j= new Joueur(x,y);
		assertEquals("Le joueur n'est pas à la bonne abscisse",x,j.getPosX());
		assertEquals("Le joueur n'est pas à la bonne ordonnee",y,j.getPosY());
	}
	
	/**
	 * Methode qui teste si le joueur se deplace correctement
	 */
	@Test
	public  void testSeDeplacer() {
		Joueur j = new Joueur();
		int x=j.getPosX()+1;
		int y=j.getPosY();
		
		j.seDeplacer(x, y);
		
		assertEquals("Le joueur ne s'est pas deplace à la bonne abscisse",x,j.getPosX());
		assertEquals("Le joueur ne s'est pas deplace à la bonne ordonnee",y,j.getPosY());
	}
	
	/**
	 * Lance les tests 
	 * @param args
	 */
	public static void main(String[] args) {
		boolean succes = true;
		Result result = JUnitCore.runClasses(Joueur.class);
		for(Failure failure: result.getFailures()) {
			System.out.println(failure.toString());
			succes=false;
		}
		if(succes) {
			System.out.println("les tests se sont bien passes");
		}
	}
}

