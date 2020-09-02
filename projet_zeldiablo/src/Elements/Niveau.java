package Elements;

import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;



public class Niveau implements Serializable {

	private static final long serialVersionUID = 1L;
	public Labyrinthe labyrinthes;
	public List<Entite> monstres;
	private boolean fin;

	public Niveau(Labyrinthe labyrinthes) {
		this.labyrinthes = labyrinthes;

	}
	
	public void sauvegarder(String nomSave) throws FileNotFoundException, Exception {
		String ext ="";
		if(nomSave.length()>4) {
			String nom_ext =nomSave.substring(nomSave.length()-4, nomSave.length());
			System.out.println(nom_ext);
			if(!nom_ext.equals(".niv")) {
				ext=".niv";
			}
		}
		
		ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(new File(nomSave)));
		stream.writeObject(this);
		
	}
	
	public boolean isFinish() {
		return fin;
	}
}
