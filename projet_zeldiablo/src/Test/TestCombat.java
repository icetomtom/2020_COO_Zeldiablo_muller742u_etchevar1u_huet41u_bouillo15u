package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import Elements.Entite;
import Elements.Joueur;
import Monstre.Troll;
import Partie.Jeu;

public class TestCombat {
	
	@Test
	public void testCombatJoueur() {
		Jeu j= new Jeu();
		
		Entite troll = new Troll("leo");
		
		
		j.deplacerJoueur(Jeu.UP);
		j.ajouter(troll);
		j.getEntite(1).setPosX(5);
		j.getEntite(1).setPosY(3);
		
		j.combat();
		
		assertEquals("Le joueur n'a pas attaque",3,j.getEntite(1).getVie());
	}
	
	@Test
	public void testCombatMonstre() {
		Jeu j = new Jeu();
		Entite troll= new Troll("leo");
		j.ajouter(troll);
		j.getEntite(1).setPosX(5);
		j.getEntite(1).setPosY(6);
		
		j.attaqueMonstre();
		
		assertEquals("Le joueur ne s'est pas fait attaque",9,j.getJoueur().getVie());
		
	}
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
