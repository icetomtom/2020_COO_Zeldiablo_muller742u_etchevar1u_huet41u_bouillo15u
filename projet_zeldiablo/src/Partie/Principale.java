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
        Joueur joueur = new Joueur();
        Labyrinthe l = new Labyrinthe();

        Sprites.chargerFeuille("entities", "./projet_zeldiablo/images/test_sprites.png", 6, 3);

        DessinPartie dessin = new DessinPartie();
        for(Case c : l.getCases())
            dessin.addSprite(c);
        Jeu j = new Jeu();
        MoteurGraphique m = new MoteurGraphique(j, dessin);

        m.lancerJeu(600, 600, 60);

    }
}
