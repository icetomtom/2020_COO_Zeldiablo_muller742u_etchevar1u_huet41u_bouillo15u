package Partie;

import GUI.Bouton;
import GUI.MenuPrincipale;
import moteurJeu.moteur.DessinAbstract;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Adpte un menu pour etre afficher
 */
public class DessinMenuAdaptateur implements DessinAbstract {

    /**
     * Menu qu'il faut afficher
     */
    private MenuPrincipale menu;

    /**
     * Constructeur
     * @param menu à afficher
     */
    public DessinMenuAdaptateur(MenuPrincipale menu) {
        this.menu = menu;
    }

    @Override
    public void dessiner(BufferedImage image) {
        Graphics g = image.getGraphics();

        g.setColor(Color.WHITE);
        g.drawRect(0, 0, image.getWidth(), image.getHeight());
        for(Bouton b : menu.getBoutons()) {
            g.setColor(Color.GRAY);
            g.fillRect(b.getX(), b.getY(), b.getLongeur(), b.getLargeur());
            g.setColor(Color.BLACK);
            g.setFont(g.getFont().deriveFont(Font.PLAIN, 50));

            FontMetrics metrics = g.getFontMetrics(g.getFont());
            int w = metrics.stringWidth(b.getLabel());
            g.drawString(b.getLabel(), b.getLongeur() / 2 + b.getX() - w / 2, b.getLargeur() / 2 + b.getY() + metrics.getHeight() / 2);
        }
    }
}
