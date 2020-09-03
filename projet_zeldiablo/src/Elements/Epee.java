package Elements;

public class Epee extends Arme {

	public Epee (){
		this.degats = 6;
	}

	public String getNomObjet() {
		return "Epee";
	}

	@Override
	public boolean etreUtilise(Joueur j) {
		return false;
	}
}
