package Elements;

public class CasePiege extends CaseAEffet {
	private boolean active;

	public CasePiege(int x, int y, int type) {
		super(x, y, type);
		this.active = false;
	}

	@Override
	public void activerEffet(Entite e) {
		e.vie -= 1;
		
		if(!this.active) {
			this.active = true;
		}
	}
	
	public boolean estActive() { return this.active; }
}
