package Elements;

import java.util.ArrayList;
import java.util.List;

public class Niveau {

	public List<Labyrinthe> labyrinthes;

	private boolean fin;

	public Niveau(List<Labyrinthe> labyrinthes) {
		this.labyrinthes = labyrinthes;

	}

	public Niveau() {
		this.labyrinthes = new ArrayList<>();
	}

	public void ajouterLaby(Labyrinthe l) {
		labyrinthes.add(l);
	}
	
	
	 public Labyrinthe getCurentLaby() {
	        for (Labyrinthe l : labyrinthes) {
	            if (l.getCase(1, 1) != null) {
	                return l;
	            }
	        }
	        return null;
	    }

	public boolean isFinish() {
		return fin;
	}
}
