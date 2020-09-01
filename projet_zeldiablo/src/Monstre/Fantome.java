package Monstre;

public class Fantome extends Monstre {
	
	
	public Fantome(int x, int y) {
		super(x, y);
		this.vie = 2;	
	}
	
	public void seDeplacer(int x, int y) {
		this.setPosMonstX(x);
		this.setPosMonstY(y);
	}

}
