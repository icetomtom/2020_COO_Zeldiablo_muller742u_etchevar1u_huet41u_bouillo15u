package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import Elements.Joueur;
import Monstre.Monstre;
import Monstre.MonstreImmobile;

public class TestMonstreImmobile {
	
	/**
	 * Test du constructeur vide du monstre immobile
	 */
	@Test
	public void testConstructeur(){
		Monstre m  = new MonstreImmobile(0,0);
		
		assertEquals("Le monstre n'est pas a la bonne abscisse",0,m.getPosMonstX());
		assertEquals("Le monstre n'est pas a la bonne ordonnee",0,m.getPosMonstY());
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
