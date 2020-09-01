package Elements;

public class CasePiege extends CaseAEffet {

	public CasePiege(int x, int y, int type) {
		super(x, y, type);
	}

	@Override
	public void activerEffet(Entite e) {
		System.out.println("L'entite a ete blesse");
	}

}
