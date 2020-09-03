package Elements;

import moteurJeu.sprite.Sprite;

public class Amulette extends Sprite implements Objet {
	
	public Amulette(String nom) {
		super(nom);
	}
	
	public Amulette(String nom, int x, int y) {
		super(nom);
	}

	private int x, y;
	
	
	
	@Override
	public String getNomObjet() {
		return "Amulette";
	}

	@Override
	public boolean etreUtilise(Joueur j) {
		return j.getInventaire().contains(this);
	}

	@Override
	public int getPosX() {
		return this.x;
	}

	@Override
	public int getPosY() {
		return this.y;
	}

}
