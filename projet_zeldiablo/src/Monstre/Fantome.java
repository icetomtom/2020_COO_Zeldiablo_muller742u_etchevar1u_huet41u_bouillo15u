package Monstre;

import Elements.Entite;

public class Fantome extends Entite {
	
	
	public Fantome(int x, int y) {
		super("");
		this.vie = 2;	
	}
	
	public void seDeplacer(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
