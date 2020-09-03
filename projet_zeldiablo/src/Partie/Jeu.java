package Partie;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Elements.Case;
import Elements.CaseAEffet;
import Elements.Entite;
import Elements.Joueur;
import Elements.Labyrinthe;
import Usine.TYPE_MONSTRE;
import Usine.UsineMonstre;
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
	
	private boolean fini;
	
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
		this.laby = new Labyrinthe(10, 11);
		this.joueur = new Joueur(this.laby.getEntreeX(), this.laby.getEntreeY());
		this.entites = new ArrayList<Entite>();
		this.entites.add(joueur);
		this.entites.add(UsineMonstre.getMonstre(TYPE_MONSTRE.MONSTRE_IMMO));
		this.entites.add(UsineMonstre.getMonstre(TYPE_MONSTRE.TROLL));
		this.entites.add(UsineMonstre.getMonstre(TYPE_MONSTRE.FANTOME));
		this.fini = false;
	}

	/**
	 * classe permettant de deplacer le joueur dans le labyrinthe
	 *
	 * @param direction la direction prise par le joueur (direction cardinale representee par un entier)
	 */
	public void deplacerEntite(Entite e,int direction) {
		int xNewPos = e.getPosX();
		int yNewPos = e.getPosY();
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
			if(e.getClass().isInstance(joueur)) {
				this.joueur.seDeplacer(xNewPos, yNewPos);
				this.joueur.setDirection(direction);
				
				if(xNewPos == this.laby.getAmulette().getPosX() && yNewPos == this.laby.getAmulette().getPosY()) {
					joueur.ramasser(this.laby.getAmulette());
				}
				
				if(xNewPos == this.laby.getEntreeX() && yNewPos == this.laby.getEntreeY() 
						&& this.laby.getAmulette().etreUtilise(this.joueur)) {
					this.fini = true;
				}
			}else {
				e.seDeplacer(direction);
			}
			
			
			if(c instanceof CaseAEffet) {
				((CaseAEffet)c).activerEffet(e);
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
		if(clavier.isPressed(KeyEvent.VK_UP)) {
			this.deplacerEntite(joueur,UP);
		}

		if(clavier.isPressed(KeyEvent.VK_DOWN)) {
			this.deplacerEntite(joueur,DOWN);
		}

		if(clavier.isPressed(KeyEvent.VK_LEFT)) {
			this.deplacerEntite(joueur,LEFT);
		}

		if(clavier.isPressed(KeyEvent.VK_RIGHT)) {
			this.deplacerEntite(joueur,RIGHT);
		}if(clavier.isPressed(KeyEvent.VK_SPACE)) {
			this.combat();
		}
//		this.actionMonstre();

		if(this.fini) {
			System.out.println("tu as fini gg");
		}
		
		return null;
	}

	@Override
	public boolean etreFini() {
		return fini;
	}
	
	/**
	 * methode qui permet d'ajouter des entites au jeu
	 * @param e
	 */
	public void ajouter(Entite e) {
		this.entites.add(e);
	}
	
	/**
	 * methode qui permet de faire combattre le joueur si un monstre est en face de lui et dans sa direction
	 */
	public void combat() {
		Joueur j = (Joueur) entites.get(0);
		for(int i =1;i<entites.size();i++) {
			j.attaquer(entites.get(i));
		}		
	}
	
	/**
	 * methode qui permet a toute la liste de monstre d'attaquer si possible le joueur ou alors de se deplacer
	 */
	public void actionMonstre() {
		Joueur j = (Joueur)entites.get(0);
		for(int i =1;i<entites.size();i++) {
			if(entites.get(i).getPosX()==j.getPosX()&& entites.get(i).getPosY()==j.getPosY()+1) {
				entites.get(i).attaquer(entites.get(0));
			}else if(entites.get(i).getPosX()==j.getPosX()&& entites.get(i).getPosY()==j.getPosY()-1) {
				entites.get(i).attaquer(entites.get(0));
			}else if(entites.get(i).getPosX()==j.getPosX()-1&& entites.get(i).getPosY()==j.getPosY()) {
				entites.get(i).attaquer(entites.get(0));
			}else if(entites.get(i).getPosX()==j.getPosX()+1&& entites.get(i).getPosY()==j.getPosY()) {
				entites.get(i).attaquer(entites.get(0));
			}else {
				this.deplacerEntite(entites.get(i), entites.get(i).deplacementAleatoire());
			}
		}
	}
	
	/**
	 * methode qui permet d'avoir une entite de la liste en fonction de son index
	 * @param index entier correspondant a la place de lentite dans la liste
	 * @return une entite 
	 */
	public Entite getEntite(int index) {
		return this.entites.get(index);
	}
	
	/**
	 * methode qui permet de supprimer de la liste des entites les monstre ou joueur si ils sont morts
	 */
	public void morts() {
		if(entites.get(0).etreMort()) {
			this.fini=true;
		}
		for(int i=1;i<entites.size();i++) {
			if(entites.get(i).etreMort()) {
				entites.remove(i);
			}
		}
	}
	
}
