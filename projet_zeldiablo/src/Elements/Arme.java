package Elements;

public abstract class Arme implements Objet {
	
	protected int degats;
	
	
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
}
