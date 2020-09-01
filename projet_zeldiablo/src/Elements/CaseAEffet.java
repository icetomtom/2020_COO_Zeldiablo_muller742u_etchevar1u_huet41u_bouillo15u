package Elements;

public abstract class CaseAEffet extends Case {

	public CaseAEffet(int x, int y, int type) {
		super(x, y, type);
	}
	
	public abstract void activerEffet(Joueur j);
}
