package Partie;

import Elements.*;
import Monstre.Fantome;
import Monstre.Monstre;
import Monstre.Troll;
import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;
import moteurJeu.sprite.Sprite;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

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
	private ArrayList<Sprite> sprites;

	/**
	 * attribut qui represente le labyrinthe
	 */
	private Labyrinthe laby;
	private long start=0;
	private int i =0;



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
		this.sprites = new ArrayList<>();
		this.entites = new ArrayList<>();
		this.fini = true;
	}

	public Jeu(Niveau n) {
		this();
		initialiserAvecNiveau(n);
	}

	/**
	 * Cree toutes les entities et sprites, remet les variable du jeu a 0
	 * @param n
	 */
	public void initialiserAvecNiveau(Niveau n) {
		if(n == null)
			throw new IllegalArgumentException("Impossible d'initialiser un jeu avec un niveau null");

		this.entites.clear();
		this.sprites.clear();

		this.laby = n.getLabyrinthe();
		this.joueur = new Joueur(this.laby.getEntreeX(), this.laby.getEntreeY());

		entites.addAll(n.getMonstres());

		this.entites.add(joueur);

		sprites.addAll(this.laby.getCases());
		sprites.add(laby.getAmulette());
		sprites.addAll(this.entites);
		this.fini = false;
	}

	/**
	 * classe permettant de deplacer le joueur dans le labyrinthe
	 *
	 * @param direction la direction prise par le joueur (direction cardinale representee par un entier)
	 */
	public void deplacerEntite(Entite e,int direction) {
		if (fini)
			return;
		if(e == null)
			return;

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
		
		if (c==null) { return; }
		
		//le joueur ne peut avancer que si la case est traversable
		if(c.estTraversable() ) {
			if(e.getClass().isInstance(joueur)) {
				this.joueur.seDeplacer(xNewPos, yNewPos);
				this.joueur.setDirection(direction);
 
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
	    	
	    	e.getBarreDeVie().updatePos(e.getPosX(), e.getPosY());
	    	
	    	System.out.println(e.getBarreDeVie().getPosX() + " " + e.getBarreDeVie().getPosY());
		}else if(e instanceof Fantome){
			if(e.getPosX()<laby.getLongeur() && e.getPosX()>0) {
				if (e.getPosY()<laby.getLargeur() && e.getPosY()>0) {
					e.seDeplacer(direction);
				}
			}
		}
	}

	/**
	 * getter de l attribut joueur
	 *
	 * @return l attribut joueur
	 */
	public Joueur getJoueur() { return this.joueur; }

	/**
	 * getter de l attribut laby
	 *
	 * @return l attribut laby
	 */
	public Labyrinthe getLaby() { return this.laby; }


	@Override
	public String evoluer(CClavier clavier, CSouris souris) {
		if (fini)
			return JeuPrincipal.MODE_FIN;

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
		}if(clavier.getTyped(KeyEvent.VK_E)) {
			if(this.joueur.getPosX() == this.laby.getAmulette().getPosX()
					&& this.joueur.getPosY() == this.laby.getAmulette().getPosY()) {
				this.joueur.ramasser(this.laby.getAmulette());
			}
		}
		;
		long tempsEntre = System.currentTimeMillis() - start;

		if((tempsEntre/1000)>=1){
			this.actionMonstre();
			start = System.currentTimeMillis();
		}



		morts();

		if(this.fini)
			return JeuPrincipal.MODE_MENU;

		return JeuPrincipal.MODE_PARTIE;
	}

	@Override
	public boolean etreFini() {
		return fini;
	}
	
	/**
	 * methode qui permet d ajouter des entites au jeu
	 * @param e
	 */
	public void ajouter(Entite e) {
		this.entites.add(e);
	}
	
	/**
	 * methode qui permet de faire combattre le joueur si un monstre est en face de lui et dans sa direction
	 */
	public void combat() {
		if (fini)
			return;

		for(int i =0;i<entites.size();i++) {
			joueur.attaquer(entites.get(i));
		}		
	}
	
	/**
	 * methode qui permet a toute la liste de monstre d attaquer si possible le joueur ou alors de se deplacer
	 */
	public void actionMonstre() {
		if (fini)
			return;

		Joueur j = joueur;
		for(int i =0;i<entites.size();i++) {
			if(!(entites.get(i) instanceof Monstre))
				continue;
			if(entites.get(i).getPosX()==j.getPosX()&& entites.get(i).getPosY()==j.getPosY()+1) {
				entites.get(i).attaquer(joueur);
			}else if(entites.get(i).getPosX()==j.getPosX()&& entites.get(i).getPosY()==j.getPosY()-1) {
				entites.get(i).attaquer(joueur);
			}else if(entites.get(i).getPosX()==j.getPosX()-1&& entites.get(i).getPosY()==j.getPosY()) {
				entites.get(i).attaquer(joueur);
			}else if(entites.get(i).getPosX()==j.getPosX()+1&& entites.get(i).getPosY()==j.getPosY()) {
				entites.get(i).attaquer(joueur);
			}else {
				this.deplacerEntite(entites.get(i), entites.get(i).deplacementAleatoire());
			}
			if(entites.get(i) instanceof Troll) {
				((Troll) entites.get(i)).regeneration();
			}
		}
	}
	
	/**
	 * methode qui permet d avoir une entite de la liste en fonction de son index
	 * @param index entier correspondant a la place de lentite dans la liste
	 * @return une entite 
	 */
	public Entite getEntite(int index) {
		return this.entites.get(index);
	}
	
	public void enleverSprite(Sprite s) {
		sprites.remove(s);
	}
	
	/**
	 * methode qui permet de supprimer de la liste des entites les monstre ou joueur si ils sont morts
	 */
	public void morts() {
		if (fini)
			return;

		if(joueur.etreMort()) {
			this.fini=true;
		}else {
			for(int i=entites.size()-1;i>=0;i--) {
				if(entites.get(i).etreMort()) {
					enleverSprite(entites.get(i));
					entites.remove(entites.get(i));
					
				}
				
			}
		}
		
		
	}

	public List<Sprite> getSprites() {
		return sprites;
	}
}
