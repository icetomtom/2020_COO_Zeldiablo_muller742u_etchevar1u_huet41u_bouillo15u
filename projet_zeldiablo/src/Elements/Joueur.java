package Elements;

public class Joueur {
	private int PosX;
	private int PosY;
	
	
	public Joueur() {
		this.PosX=0;
		this.PosY=0;
		
	}
	
	public Joueur(int x,int y) {
		this.PosX=x;
		this.PosY=y;

	}
	
	public void seDeplacer(int x,int y) {
		this.PosX=x;
		this.PosY=y;
	}
	
	public int getPosX() {
		return this.PosX;
	}
	
	public int getPosY() {
		return this.PosY;
	}
}
