package Partie;

import Elements.Case;
import Elements.CasePiege;
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

        Sprites.chargerFeuille("entities", "images/16x16DungeonTileset.v3.png", 16, 16);


        CasePiege cp = new CasePiege(1, 1);
        Porte p = new Porte(5, 6);
        CaseSecrete o = new CaseSecrete(8, 8, p, Case.TYPE_OUVERTURE);
        CaseSecrete f = new CaseSecrete(8, 7, p, Case.TYPE_FERMETURE);

        j.getLaby().setCase(cp);
        j.getLaby().setCase(p);
        j.getLaby().setCase(o);
        j.getLaby().setCase(f);

        
        DessinPartie dessin = new DessinPartie();

        for(Case c : j.getLaby().getCases()) {
            dessin.addSprite(c);
        }
        
        dessin.addSprite(j.getLaby().getAmulette());
        dessin.addSprite(j.getJoueur());

        MoteurGraphique m = new MoteurGraphique(j, dessin);

        // Menu
        m.lancerJeu(600, 600, 8);
    }
}
