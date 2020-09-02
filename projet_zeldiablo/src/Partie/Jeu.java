package Partie;

import java.util.ArrayList;

import Elements.Case;
import Elements.CaseAEffet;
import Elements.Entite;
import Elements.Joueur;
import Elements.Labyrinthe;
import Elements.Porte;
import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;

/**
 *
 * classe permettant de gerer le jeu
 *
 */
public class Jeu implements JeuAbstract {
	/**
	 * attribut qui represente le joueur
	 */
	private Joueur joueur;
	
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
		this.laby = new Labyrinthe();
		this.joueur = new Joueur(this.laby.getEntreeX(), this.laby.getEntreeY());
		this.entites = new ArrayList<Entite>();
		this.entites.add(joueur);
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

		//le joueur ne peut avancer que si la case est traversable
		if(c.estTraversable()) {
			this.joueur.seDeplacer(xNewPos, yNewPos);
			this.joueur.setDirection(direction);
			
			if(c.getType() == Case.TYPE_EFFET) {
				((CaseAEffet)c).activerEffet(this.joueur);
			}
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


	@Override
	public String evoluer(CClavier clavier, CSouris souris) {
		return null;
	}

	@Override
	public boolean etreFini() {
		return false;
	}
	
	/**
	 * methode qui permet d'ajouter des entites au jeu
	 * @param e
	 */
	public void ajouter(Entite e) {
		this.entites.add(e);
	}
	
	public void combat() {
		Joueur j = (Joueur) entites.get(0);
		for(int i =1;i<entites.size();i++) {
			switch(j.getDirection()) {
			case UP:
				if(entites.get(i).getPosX()==j.getPosX()&& entites.get(i).getPosY()==j.getPosY()-1) {
					entites.get(i).subirDegats(1);					}
					break;
			case LEFT:
				if(entites.get(i).getPosX()==j.getPosX()-1 && entites.get(i).getPosY()==j.getPosY()) {
					entites.get(i).subirDegats(1);
				}
				break;
			case RIGHT:
				if(entites.get(i).getPosX()==j.getPosX()+1&& entites.get(i).getPosY()==j.getPosY()) {
					entites.get(i).subirDegats(1);				
				}
				break;
			case DOWN:
				if(entites.get(i).getPosX()==j.getPosX()&& entites.get(i).getPosY()==j.getPosY()+1) {
					entites.get(i).subirDegats(1);
				}
				break;
		}
		}
			
						
	}
	
	public void attaqueMonstre() {
		Joueur j = (Joueur)entites.get(0);
		for(int i =1;i<entites.size();i++) {
			if(entites.get(i).getPosX()==j.getPosX()&& entites.get(i).getPosY()==j.getPosY()+1) {
				j.subirDegats(1);
			}else if(entites.get(i).getPosX()==j.getPosX()&& entites.get(i).getPosY()==j.getPosY()+1) {
				j.subirDegats(1);
			}else if(entites.get(i).getPosX()==j.getPosX()&& entites.get(i).getPosY()==j.getPosY()+1) {
				j.subirDegats(1);
			}else if(entites.get(i).getPosX()==j.getPosX()&& entites.get(i).getPosY()==j.getPosY()+1) {
				j.subirDegats(1);
			}
		}
	}
	
}
