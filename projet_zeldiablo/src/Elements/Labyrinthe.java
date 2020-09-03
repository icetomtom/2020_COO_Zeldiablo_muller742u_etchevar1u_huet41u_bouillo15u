package Elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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
     * amulette du labyrinthe
     */
    private Amulette amulette;

    /**
     * Cases du labyrinthe
     */
    private ArrayList<Case> cases;

    /**
     * Constructeur par défaut
     */
    public Labyrinthe() {
        this(0, 0);
    }

    public Labyrinthe(int longeur, int largeur) {
        this.longeur = longeur;
        this.largeur = largeur;
        this.entree_x = (this.longeur-1) / 2;
        this.entree_y = (this.largeur-1) / 2;
        this.cases = new ArrayList<Case>(this.longeur * this.largeur);

        chargerCasesRecursivement();
        this.getCase(entree_x, entree_y).setType(Case.TYPE_ENTREE);
        this.amulette = new Amulette("entities_6_8", this.getNoeuds().get(1).getPosX(), this.getNoeuds().get(1).getPosY());
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

    /**
     * Getter des cases du labyrinthe
     * @return les cases
     */
    public ArrayList<Case> getCases() {
        return cases;
    }

    /**
     * Retourne les noeuds du chemin qui definnissent le labyrinthe
     * @return liste de noeuds
     */
    public List<Case> getNoeuds() {
        ArrayList<Case> noeuds = new ArrayList<>();
        int nb_x = longeur-2 + longeur%2;
        int nb_y = largeur-2 + largeur%2;
        for(int i=1; i < nb_x; i+=2) {
            for(int j=1; j < nb_y; j+=2) {
                noeuds.add(getCase(i, j));
            }
        }
        return noeuds;
    }

    /**
     * Charge les cases du labyrinthe à partir d'un niveau par défaut
     */
    private void chargerCasesParDefaut() {
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
     * Genere les cases d'un Labyrinthe
     */
    public void chargerCasesRecursivement() {
        int w = (longeur+1) / 2 - 1;
        int h = (largeur+1) / 2 - 1;;

//        System.out.println(w + " " + h);

        // Cases pour la geneation du chemin
        CaseGeneration[][] cases = new CaseGeneration[w][];
        for (int i=0; i<w; i++)
            cases[i] = new CaseGeneration[h];

        // Chaque case a des murs tout autour
        for(int j=0; j<h; j++) {
            for(int i=0; i<w; i++) {
//                System.out.println(i + " " + j);
                cases[i][j] = new CaseGeneration(i, j);
            }
        }

        // Chemin depuis le debut jusqu'a la position courrante
        Stack<CaseGeneration> openlist = new Stack<>();
        // Toutes les cases visites
        ArrayList<CaseGeneration> visited = new ArrayList<>();
        // On commence le chemin en (0, 0)
        openlist.add(cases[0][0]);

        CaseGeneration curr = null;
        int dir;
        boolean[] possibles = new boolean[4];

        // Tant qu'on a pas fini
        while (!openlist.isEmpty()) {
            // On part de la derniere case dans le chemin
            curr = openlist.lastElement();
            // On la marque comme visitee
            visited.add(curr);

            // On cherche quel mur il est possible d'ouvrir de sorte à ne pas aller sur une case deja
            // visitee et a ne pas sortir des limites
            possibles[0] = (curr.y > 0 && !visited.contains(cases[curr.x][curr.y-1])); // NORD
            possibles[1] = (curr.x < w-1 && !visited.contains(cases[curr.x+1][curr.y])); // EST
            possibles[2] = (curr.y < h-1 && !visited.contains(cases[curr.x][curr.y+1])); // SUD
            possibles[3] = (curr.x > 0 && !visited.contains(cases[curr.x-1][curr.y])); // OUEST

            // Parmi les directions possible on en choisi une
            dir = curr.murAlea(possibles);
            // Si on est coince on retourne sur nos pas pour trouve une case ou on peut encore ouvrir
            if(dir == CaseGeneration.AUCUN_MUR) {
                openlist.pop();
                continue;
            }

            CaseGeneration next = null;
            switch (dir) {
                case 0:
                    next = (cases[curr.x][curr.y-1]);
                    break;
                case 1:
                    next = (cases[curr.x+1][curr.y]);
                    break;
                case 2:
                    next = (cases[curr.x][curr.y+1]);
                    break;
                case 3:
                    next = (cases[curr.x-1][curr.y]);
                    break;
            }

            // Ajoute la prochainecase au chemin
            if (next != null) CaseGeneration.open(curr, next);
            openlist.add(next);
        }

        // Transform le labyrinthe genere avec des cases pour les murs
        this.cases.clear();
        Case c = null;
        for(int j=0; j<largeur-largeur%2; j++) {
            for(int i=0; i<longeur-largeur%2; i++) {
                // Cherche le type de la case
                int type = Case.TYPE_MUR;
                // L'entree est forcement vide
                if(entree_x == i && entree_y == j)
                    type = Case.TYPE_VIDE;
                // Bords du labyrinthe
                if(i == 0 || j == 0 || i == longeur -1 || j == largeur -1 )
                    type = Case.TYPE_MUR;
                    // Un noeud du chemin est forcement vide
                else if (i % 2 == 1 && j % 2 == 1 )
                    type = Case.TYPE_VIDE;
                    // Si on est entre deux noeud on cherche si ces deux noeud sont connectes
                else if (i % 2 == 1 && !cases[(i / 2)][(j - 1) / 2].getMur(2))
                    type = Case.TYPE_VIDE;
                    // Si on est entre deux noeud on cherche si ces deux noeud sont connectes
                else if (j % 2 == 1 && !cases[(i - 1) / 2][j / 2].getMur(1))
                    type = Case.TYPE_VIDE;
                this.cases.add(new Case(i, j, type));
            }
        }
    }

	public Amulette getAmulette() {
		return this.amulette;
	}

}

class CaseGeneration {
    /**
     * Position de la case
     */
    public final int x;
    public final int y;

    /**
     * 4 murs autour de la case, false => pas de mur
     */
    private final boolean[] murs;

    static final int AUCUN_MUR = -1;

    public CaseGeneration(int x, int y) {
        this.x = x;
        this.y = y;
        this.murs = new boolean[4];
        for(int i = 0; i < 4; i++)
            murs[i] = true;
    }

    /**
     * Ouvre les murs entre une case et une autre
     * @param c1
     * @param c2
     */
    public static void open(CaseGeneration c1, CaseGeneration c2) {
        if(c1.x  == c2.x-1 && c1.y == c2.y) { // OUEST
            c2.murs[3] = false;
            c1.murs[1] = false;
        } else if(c1.x  == c2.x+1 && c1.y == c2.y) { // EST
            c2.murs[1] = false;
            c1.murs[3] = false;
        } else if(c1.x  == c2.x && c1.y == c2.y - 1) { // NORD
            c2.murs[0] = false;
            c1.murs[2] = false;
        } else if(c1.x  == c2.x && c1.y == c2.y + 1) { // SUD
            c2.murs[2] = false;
            c1.murs[0] = false;
        }
    }

    /**
     * Trouve un cote alea ou il n'y a pas de mur
     * @param possibles murs qui ne sont pas possible d'etre ouvert
     * @return index du cote, AUCUN_MUR s'il y a pas de côte dispo
     */
    public int murAlea(boolean[] possibles) {
        ArrayList<Integer> murs_dispos = new ArrayList<>(4);
        for (int i=0; i<4; i++)
            if (possibles[i])
                murs_dispos.add(i);

        if(murs_dispos.size() == 0)
            return AUCUN_MUR;

        int i = (int)(Math.random() * murs_dispos.size());
        return murs_dispos.get(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaseGeneration that = (CaseGeneration) o;
        return x == that.x &&
                y == that.y &&
                Arrays.equals(murs, that.murs);
    }

    public boolean getMur(int i) {
        if(i < 0 || i >= 4)
            return false;
        return murs[i];
    }
}
