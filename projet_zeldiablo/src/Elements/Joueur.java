package Elements;

import java.util.ArrayList;
import java.util.List;

import Partie.Jeu;
import moteurJeu.sprite.Sprite;

/**
 * 
 * classe representant un joueur
 */
public class Joueur extends Entite{
	
	private List<Objet> inventaire;

	
	/**
	 *  attribut correspondant a la derniere direction du joueur
	 */
	private int direction;
	
	/**
	 * contructeur vide de la classe joueur
	 */
	public Joueur() {
		this(0, 0);
	}
	
	/**
	 * Constructeur avec paramtre de la classe joueur
	 * @param x entier correspondant a l abscisse du joueur
	 * @param y entier correspondant a l ordonnee du joueur
	 */
	public Joueur(int x,int y) {
		super("entities_4_8");
		this.vie = 10;
		this.x=x;
		this.y=y;
		this.inventaire = new ArrayList<Objet>();
        this.inventaire.add(new Epee());
        barreDeVie.setVieMax(vie);

	}

	/**
	 * methode permettant d ajouter un objet
	 * @param ob
	 */
	public void ajouterObjet(Objet ob) {
		this.inventaire.add(ob);
	}
	
	/**
	 * methode qui sert a utiliser un objet
	 * @param ob
	 */
	public void utiliserObjet(int ob) {
		if(this.inventaire.size() > ob) {
			Objet obj = this.inventaire.get(ob);
			obj.etreUtilise(this);
			this.inventaire.remove(ob);
		}
	}
	
	/**
	 * methode qui affiche l inventaire
	 */
	public void afficherInventaire() {
		for(int i=0;i<this.inventaire.size();i++) {
			System.out.println(this.inventaire.get(i).getNomObjet());
		}
	}
	/**
	 * methode permettant de ramasser un objet
	 * @param o
	 */
	public void ramasser(Objet o) {
		if(o != null) {
			this.inventaire.add(o);
			System.out.println("Le joueur a ramasse \"" + o.getNomObjet() + "\" !");
			if(o instanceof Sprite) {
				((Sprite)o).setNomImage("entities_2_3");
			}
		}
	}
	
	
	/**
	 * Methode qui sert a deplacer le jouer 
	 * @param x entier correspondant a la nouvelle abscisse du joueur
	 * @param y entier correspondant a la nouvelle ordonnee du joueur
	 */
	public void seDeplacer(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	/**
	 * methode permettant de se souvenir de la derniere direction du joueur
	 * @param n
	 */
	public void setDirection(int n) {
		this.direction =n;
	}
	
	/**
	 * methode permettant de recuperer la direction
	 * @return un entier correspondant a la direction
	 */
	public int getDirection() {
		return this.direction;
	}
	
	/**
	 * attaque du joueur en focntion de sa direction
	 * @param e correspond a l'entite qu il attaque
	 */
	@Override
	public void attaquer(Entite e) {
		switch(this.getDirection()) {
		case Jeu.UP:
			if(e.getPosX()==this.getPosX()&&e.getPosY()==this.getPosY()-1) {
				e.subirDegats(this.degats);
			}
				break;
		case Jeu.LEFT:
			if(e.getPosX()==this.getPosX()-1 && e.getPosY()==this.getPosY()) {
				e.subirDegats(this.degats);
			}
			break;
		case Jeu.RIGHT:
			if(e.getPosX()==this.getPosX()+1&& e.getPosY()==this.getPosY()) {
				e.subirDegats(this.degats);		
			}
			break;
		case Jeu.DOWN:
			if(e.getPosX()==this.getPosX()&& e.getPosY()==this.getPosY()+1) {
				e.subirDegats(this.degats);
			}
			break;
		}
	}
	
	public List<Objet> getInventaire() {
		return this.inventaire;
	}
	

}
