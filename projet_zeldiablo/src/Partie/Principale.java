package Partie;

import Elements.Joueur;
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
        Joueur joueur = new Joueur();

        Sprites.chargerFeuille("entities", "./projet_zeldiablo/images/test_sprites.png", 6, 3);

        DessinAbstract dessin = new DessinAbstract() {
            @Override
            public void dessiner(BufferedImage image) {
                Graphics2D g = (Graphics2D) image.getGraphics();

                joueur.dessiner(g);
                g.dispose();
            }
        };

        MoteurGraphique m = new MoteurGraphique(j, dessin);
        m.lancerJeu(600, 400, 60);

    }
}
