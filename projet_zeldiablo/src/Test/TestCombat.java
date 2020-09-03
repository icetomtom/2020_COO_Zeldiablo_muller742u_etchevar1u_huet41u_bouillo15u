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
	
	/**
	 * test qui permet de savoir si le joueur attaque bien le monstre en face de lui
	 */
	@Test
	public void testCombatJoueur() {
		Jeu j= new Jeu();
		
		Entite troll = new Troll();
		
		j.deplacerEntite(j.getEntite(0),Jeu.UP);
		j.ajouter(troll);
		j.getEntite(1).setPosX(4);
		j.getEntite(1).setPosY(2);
		
		
		j.combat();
	
		assertEquals("Le joueur n'a pas attaque",2,j.getEntite(1).getVie());
	}
	
	/**
	 * test pour savoir si le joueur attaque bien d'une case et dans une bonne direction
	 */
	@Test
	public void testCombatPlusieursMonstre() {
		Jeu j= new Jeu();
		
		Entite troll = new Troll();
		
		
		j.deplacerEntite(j.getJoueur(),Jeu.UP);
		j.ajouter(troll);
		j.getEntite(1).setPosX(4);
		j.getEntite(1).setPosY(2);
		
		j.ajouter(new Troll());
		j.getEntite(2).setPosX(4);
		j.getEntite(2).setPosY(6);
		j.combat();
		
		assertEquals("Le joueur n'a pas attaque",2,j.getEntite(1).getVie());
		assertEquals("la direction n'est pas bonne",5,j.getEntite(2).getVie());
		
		j.deplacerEntite(j.getJoueur(),Jeu.DOWN);
		j.deplacerEntite(j.getEntite(0),Jeu.DOWN);
		j.combat();
		assertEquals("Le joueur n'a pas attaque",4,j.getEntite(2).getVie());
	}
	
	/**
	 * test qui permet de savoir si les monstres attaquent tous s'il le peuvent et dans toutes les directions
	 */
	@Test
	public void testCombatMonstre() {
		Jeu j = new Jeu();
		
		j.getEntite(1).setPosX(4);
		j.getEntite(1).setPosY(5);
		
		
		j.getEntite(2).setPosX(3);
		j.getEntite(2).setPosY(4);
		
		
		
		j.getEntite(3).setPosX(4);
		j.getEntite(3).setPosY(3);
		
		
		j.ajouter(new Troll());
		j.getEntite(4).setPosX(5);
		j.getEntite(4).setPosY(4);
		
		j.ajouter(new Troll());
		j.getEntite(5).setPosX(6);
		j.getEntite(5).setPosY(6);
		
		
		
		j.actionMonstre();
		
		assertEquals("Le joueur ne s'est pas fait attaque",6,j.getJoueur().getVie());
		
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
