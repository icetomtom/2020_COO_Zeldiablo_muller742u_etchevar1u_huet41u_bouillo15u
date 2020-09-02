package Partie;

import Elements.Case;
import Elements.CaseSecrete;
import Elements.Porte;
import moteurJeu.moteur.MoteurGraphique;
import moteurJeu.sprite.Sprites;

public class Principale {
    /**
     * Fonction appelée pour lancer le jeu
     */
    public static void main(String[] args) {
        Jeu j = new Jeu();
        Porte p = new Porte(1, 1);
        CaseSecrete cs = new CaseSecrete(8, 8, p);
        j.getLaby().setCase(cs);
        j.getLaby().setCase(p);;

        Sprites.chargerFeuille("entities", "images/16x16DungeonTileset.v3.png", 16, 16);

        DessinPartie dessin = new DessinPartie();
        for(Case c : j.getLaby().getCases())
            dessin.addSprite(c);
        dessin.addSprite(j.getJoueur());

        MoteurGraphique m = new MoteurGraphique(j, dessin);

        m.lancerJeu(600, 600, 8);
    }
}
