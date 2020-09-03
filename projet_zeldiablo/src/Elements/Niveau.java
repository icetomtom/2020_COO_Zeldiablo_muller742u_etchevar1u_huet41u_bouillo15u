package Elements;

import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;



public class Niveau implements Serializable {

	private static final long serialVersionUID = 1L;
	public Labyrinthe labyrinthe;
	public List<Entite> monstres;

	public Niveau(Labyrinthe labyrinthe, List<Entite> monstres) {
		this.labyrinthe = labyrinthe;
		this.monstres = monstres;
	}

	public Labyrinthe getLabyrinthe() {
		return labyrinthe;
	}

	public List<Entite> getMonstres() {
		return monstres;
	}
}
