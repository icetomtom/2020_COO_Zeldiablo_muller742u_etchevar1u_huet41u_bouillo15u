package Partie;

import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;
import moteurJeu.moteur.MoteurGraphique;
import moteurJeu.sprite.Sprite;
import moteurJeu.sprite.Sprites;

import java.util.ArrayList;

public class JeuPrincipale implements JeuAbstract {

    AdaptateurJeuMenu menu;
    Jeu partie;

    private String mode;

    public final static String MODE_MENU = "MENU";
    public final static String MODE_PARTIE = "PARTIE";

    public JeuPrincipale() {
        mode = MODE_MENU;
        menu = new AdaptateurJeuMenu();
        partie = new Jeu();
    }

    @Override
    public String evoluer(CClavier clavier, CSouris souris) {
        switch (mode) {
            case MODE_MENU:
                mode = menu.evoluer(clavier, souris);
                break;
            case MODE_PARTIE:
                mode = partie.evoluer(clavier, souris);
                break;
        }
        return null;
    }

    @Override
    public boolean etreFini() {
        return false;
    }

    public static void main(String[] args) {
        Sprites.chargerFeuille("entities", "images/16x16DungeonTileset.v3.png", 16, 16);

        JeuPrincipale j = new JeuPrincipale();
        DessinPrincipale dessin = new DessinPrincipale(j);

        MoteurGraphique m = new MoteurGraphique(j, dessin);
        m.lancerJeu(600, 600, 8);
    }

    public String getMode() {
        return mode;
    }
}
