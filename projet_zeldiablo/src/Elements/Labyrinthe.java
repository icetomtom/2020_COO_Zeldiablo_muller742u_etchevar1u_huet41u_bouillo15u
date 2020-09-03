package Elements;

import moteurJeu.sprite.Sprite;

import java.io.Console;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un labyrinthe
 */
public class Labyrinthe implements Serializable {

    /**
     * Dimensions du labyrinthe
     */
    private int longeur, largeur;

    /**
     * Point d'appartion du joueur
     */
    private int entree_x, entree_y;

    /**
     * Cases du labyrinthe
     */
    private ArrayList<Case> cases;

    /**
     * Constructeur par défaut
     */
    public Labyrinthe() {
        this.longeur = 10;
        this.largeur = 10;
        this.entree_x = (this.longeur-1) / 2;
        this.entree_y = (this.largeur-1) / 2;
        this.cases = new ArrayList<Case>(this.longeur * this.largeur);

        chargerNiveauParDefaut();
    }

    /**
     * Charge les cases du labyrinthe à partir d'un niveau par défaut
     */
    private void chargerNiveauParDefaut() {
        cases.clear();

        Case c = null;
        for(int j=0; j<largeur; j++) {
            for(int i=0; i<longeur; i++) {
                if(i == 0 || j == 0 || i == longeur-1 || j == largeur-1)
                    c = new Case(i, j, Case.TYPE_MUR);
                else
                    c = new Case(i, j, Case.TYPE_VIDE);
                cases.add(c);
            }
        }
    }

    /**
     * Per d'obtenir une case à une position
     * @param x abscisse de la case
     * @param y ordonnée de la case
     * @return case
     */
    public Case getCase(int x, int y) {
        int i = x + y * longeur;
        if(i < this.longeur * this.longeur && i >= 0)
            return cases.get(i);
        return null;
    }

    /**
     * Remplace une Case par une autre, se base sur les coordonnees de la cases
     * @param c la case qui remplace l'ancienne
     */
    public void setCase(Case c) {
        int i = c.getPosX() + c.getPosY() * longeur;
        if(i < this.longeur * this.longeur && i >= 0)
            cases.set(i, c);
    }

    /**
     * Getter de l'attibut longeur
     * @return longeur
     */
    public int getLongeur() {
        return longeur;
    }

    /**
     * Getter de l'attibut largeur
     * @return largeur
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Getter de l'attibut entree_x
     * @return position x de l'entrée pour le joueur
     */
    public int getEntreeX() {
        return entree_x;
    }

    /**
     * Getter de l'attibut entree_y
     * @return position y de l'entrée pour le joueur
     */
    public int getEntreeY() {
        return entree_y;
    }

    public ArrayList<Case> getCases() {
        return cases;
    }
}