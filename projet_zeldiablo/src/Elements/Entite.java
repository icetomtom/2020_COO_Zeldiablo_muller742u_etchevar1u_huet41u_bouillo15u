package Elements;

import moteurJeu.sprite.Sprite;

public class Entite extends Sprite {
	
	protected int vie;
    /**
     * creation du sprite
     *
     * @param nom nom de l'imaeg
     */
    public Entite(String nom) {
        super(nom);
    }

    /**
     * methode qui permet de retourner l'abscisse du joueur
     * @return un entier
     */
    public int getPosX() {
        return this.x;
    }

    /**
     * methode qui permet de retourner l'ordonnee du joueur
     * @return un entier
     */
    public int getPosY() {
        return this.y;
    }

    /**
     * Methode qui permet de modifier l'abscisse du joueur
     * @param x entier correspondant � la nouvelle abscisse du joueur
     */
    public void setPosX(int x) {
        this.x=x;
    }

    /**
     * Methode qui permet de modifier l'ordonnee du joueur
     * @param y entier correspondant � la nouvelle ordonnee du joueur
     */
    public void setPosY(int y) {
        this.y=y;
    }
    
    public int getVie() {
		return this.getVie();
	}
}
