package Elements;

public abstract class Arme implements Objet {
	
	protected int degats;
	protected int resistance;
	
	public int getDegats(){
		return degats;
	}
	
	public int getResistance() {
		return resistance;
	}
	
	public abstract String getNomObjet();
}
