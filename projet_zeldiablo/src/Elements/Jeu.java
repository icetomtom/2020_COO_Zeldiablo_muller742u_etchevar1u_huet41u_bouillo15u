package Elements;

import java.util.ArrayList;

/**
 * 
 * classe permettant de gerer le jeu
 *
 */
public class Jeu {
	/**
	 * attribut qui represente le joueur
	 */
	private ArrayList<Entite> entites;
	
	/**
	 * attribut qui represente le labyrinthe
	 */
	private Labyrinthe laby;
	
	/**
	 * constantes de direction
	 */
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	
	/**
	 * constructeur par defaut
	 */
	public Jeu() {
		this.entites = new ArrayList<Entite>();
		this.laby = new Labyrinthe();
		this.joueur = new Joueur(this.laby.getEntreeX(), this.laby.getEntreeY());
	}
	
	/**
	 * classe permettant de deplacer le joueur dans le labyrinthe
	 * 
	 * @param direction la direction prise par le joueur (direction cardinale representee par un entier)
	 */
	public void deplacerJoueur(int direction) {
		int xNewPos = this.joueur.getPosX();
		int yNewPos = this.joueur.getPosY();
		
		switch(direction) {
			case UP:
				yNewPos--;
				break;
				
			case DOWN:
				yNewPos++;
				break;
				
			case LEFT:
				xNewPos--;
				break;
				
			case RIGHT:
				xNewPos++;
				break;
				
			default:
				break;
		} 
		
		//on recupere la case sur laquelle on veut avancer
		Case c = this.laby.getCase(xNewPos, yNewPos);
		
		//le joueur ne poeut avancer que si la case est vide
		if(c.getType() != Case.TYPE_MUR) {
			this.joueur.seDeplacer(xNewPos, yNewPos);
		}else if(c.getType() == Case.TYPE_EFFET) {
			((CaseAEffet)c).activerEffet(this.joueur);
		}
	}
	
	/**
	 * getter de l'attribut joueur
	 * 
	 * @return l'attribut joueur
	 */
	public Joueur getJoueur() { return this.joueur; }
	
	/**
	 * getter de l'attribut laby
	 * 
	 * @return l'attribut laby
	 */
	public Labyrinthe getLaby() { return this.laby; }
}
