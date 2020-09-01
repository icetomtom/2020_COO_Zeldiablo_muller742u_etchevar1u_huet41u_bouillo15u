package Elements;

/**
 * 
 * classe permettant de gerer le jeu
 *
 */
public class Jeu {
	/**
	 * attribut qui represente le joueur
	 */
	private Joueur joueur;
	
	/**
	 * attribut qui represente le labyrinthe
	 */
	private Labyrinthe laby;
	
	/**
	 * constructeur par defaut
	 */
	public Jeu() {
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
		
		/**
		 * 0 : Up
		 * 1 : Down
		 * 2 : Left
		 * 3 : Right
		 */
		switch(direction) {
			case 0:
				yNewPos--;
				break;
				
			case 1:
				yNewPos++;
				break;
				
			case 2:
				xNewPos--;
				break;
				
			case 3:
				xNewPos++;
				break;
				
			default:
				break;
		} 
		
		//on recupere le type de la case sur laquelle on veut avancer
		int type = this.laby.getCase(xNewPos, yNewPos).getType();
		
		//le joueur ne poeut avancer que si la case est vide
		if(type == Case.TYPE_VIDE) {
			this.joueur.seDeplacer(xNewPos, yNewPos);
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
