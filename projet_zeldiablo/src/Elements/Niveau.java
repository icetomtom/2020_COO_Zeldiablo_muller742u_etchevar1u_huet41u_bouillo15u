package Elements;

import java.io.Serializable;
import java.util.List;

import Monstre.Monstre;


public class Niveau implements Serializable {

	private static final long serialVersionUID = 1L;
	public Labyrinthe labyrinthe;
	public List<Monstre> monstres;

	public Niveau(Labyrinthe labyrinthe, List<Monstre> monstres) {
		this.labyrinthe = labyrinthe;
		this.monstres = monstres;
		List<Case> c1 = labyrinthe.getNoeuds();
		for(int i =0;i<monstres.size();i++) {
			int nb = (int)(Math.random()*(c1.size()));
			monstres.get(i).setPosX(c1.get(nb).getPosX());
			monstres.get(i).setPosY(c1.get(nb).getPosY());
			c1.remove(nb);
		}
		
	}

	public Labyrinthe getLabyrinthe() {
		return labyrinthe;
	}

	public List<Monstre> getMonstres() {
		return monstres;
	}
}
