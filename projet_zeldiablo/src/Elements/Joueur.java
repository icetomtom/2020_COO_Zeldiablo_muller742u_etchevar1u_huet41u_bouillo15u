package Elements;

public class Joueur {
	private int[][] coordonnes;
	
	
	public Joueur() {
		this.coordonnes= new int[1][1];
		
	}
	
	public Joueur(int x,int y) {
		this.coordonnes[0][0]=x;
		this.coordonnes[0][1]=y;
	}
	
	public void seDeplacer(int x,int y) {
		this.coordonnes[0][0]=x;
		this.coordonnes[0][1]=y;
	}
	
	public int getPosX() {
		return this.coordonnes[0][0];
	}
	
	public int getPosY() {
		return this.coordonnes[0][1];
	}
}
