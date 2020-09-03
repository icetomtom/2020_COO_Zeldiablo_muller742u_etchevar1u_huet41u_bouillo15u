package Partie;

import moteurJeu.moteur.DessinAbstract;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Classe qui se charge de l'affichage
 */
public class DessinPrincipale implements DessinAbstract {

    /**
     * Classe qui dessine le menu
     */
    private final DessinAbstract dessinMenu;
    /**
     * Classe qui dessin la partie
     */
    private final DessinAbstract dessinJeu;

    /**
     * Attribut qui reprente le Jeu dans tous ses etats
     */
    private final JeuPrincipale j;

    /**
     * Constructeur
     * @param j jeu
     */
    public DessinPrincipale(JeuPrincipale j) {
        dessinMenu = new DessinMenuAdaptateur(j.menu.menu);
        dessinJeu = new DessinPartie(j.partie.getSprites());
        this.j = j;
    }

    @Override
    public void dessiner(BufferedImage image) {
        switch (this.j.getMode()) {
            case JeuPrincipale.MODE_MENU:
                dessinMenu.dessiner(image);
                break;
            case JeuPrincipale.MODE_PARTIE:
                dessinJeu.dessiner(image);
                break;
            case JeuPrincipale.MODE_FIN:
                Graphics g = image.getGraphics();
                FontMetrics metrics = g.getFontMetrics(g.getFont());
                g.setColor(Color.BLACK);
                g.drawString("Merci d'avoir joué !", 300 - metrics.stringWidth("Merci d'avoir joué !") / 2, 300);
        }
    }
}
