package Elements;

public abstract class Arme implements Objet {
	
	protected int degats;
	protected int resistance;
	
	
	public String getType() {
		return "Arme";
	}

	@Override
	public boolean etreUtilise(Joueur j) {
		return false;
	}
	
	public int getDegats(){
		return degats;
	}
	
	public int getResistance() {
		return resistance;
	}
}
