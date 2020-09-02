package Partie;

import Elements.Case;
import Elements.Joueur;
import Elements.Labyrinthe;
import moteurJeu.moteur.DessinAbstract;
import moteurJeu.moteur.MoteurGraphique;
import moteurJeu.sprite.Sprites;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Principale {
    /**
     * Fonction appelée pour lancer le jeu
     */
    public static void main(String[] args) {
        Jeu j = new Jeu();

        Sprites.chargerFeuille("entities", "images/16x16DungeonTileset.v3.png", 16, 16);

        DessinPartie dessin = new DessinPartie();
        for(Case c : j.getLaby().getCases())
            dessin.addSprite(c);
        dessin.addSprite(j.getJoueur());

        MoteurGraphique m = new MoteurGraphique(j, dessin);

        m.lancerJeu(600, 600, 8);
    }
}
