package Partie;

import moteurJeu.moteur.DessinAbstract;
import moteurJeu.moteur.MoteurGraphique;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Principale {
    public static void main(String[] args) {
        Jeu j = new Jeu();
        DessinAbstract dessin = new DessinAbstract() {
            @Override
            public void dessiner(BufferedImage image) {
                Graphics2D g = (Graphics2D) image.getGraphics();

                g.setColor(Color.BLACK);
                g.drawString("Surprise", 300, 200);
                g.dispose();
            }
        };

        MoteurGraphique m = new MoteurGraphique(j, dessin);
        m.lancerJeu(600, 400, 60);

    }
}
