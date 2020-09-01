package Test;
import org.junit.Test;

import Joueur;

public class TestJoueur {
	public static boolean succes_test;
	@Test
	public static void testConstructeurVide() {
		Joueur j = new Joueur();
		if(j.getPosY() ==0 && j.getPosX()==0) {
			succes_test=true;
		}else {
			succes_test=false;
		}
	}
	
	@Test
	public static void testConstructeur() {
		int x=4;
		int y=4;
		Joueur j= new Joueur(x,y);
		if(j.getPosY() ==y && j.getPosX()==x) {
			succes_test= true;
		}else {
			succes_test= false;
		}
	}
	
	@Test
	public static void testSeDeplacer() {
		Joueur j = new Joueur();
		int x=j.getPosX()+1;
		int y=j.getPosY();
		
		j.seDeplacer(x, y);
		
		if(j.getPosX()==x &&j.getPosY()==y) {
			succes_test=true;
		}else {
			succes_test= false;
		}
	}
	
	public static void main(String[] args) {
		
		testConstructeurVide();
		if(!succes_test) {
			System.out.println("Probleme dans le constructeur vide");
		}
		testConstructeur();
		if(!succes_test) {
			System.out.println("Probleme dans le constructeur vide");
		}
		testSeDeplacer();
		
		if(!succes_test) {
			System.out.println("Probleme dans le constructeur vide");
		}
	}
}

