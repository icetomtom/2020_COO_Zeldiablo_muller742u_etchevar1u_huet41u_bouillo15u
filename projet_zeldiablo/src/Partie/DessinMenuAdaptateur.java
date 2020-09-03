package Partie;

import GUI.Button;
import GUI.MenuPrincipale;
import moteurJeu.moteur.DessinAbstract;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DessinMenuAdaptateur implements DessinAbstract {

    private MenuPrincipale menu;

    public DessinMenuAdaptateur(MenuPrincipale menu) {
        this.menu = menu;
    }

    @Override
    public void dessiner(BufferedImage image) {
        Graphics g = image.getGraphics();

        g.setColor(Color.WHITE);
        g.drawRect(0, 0, image.getWidth(), image.getHeight());
        for(Button b : menu.getButtons()) {
            g.setColor(Color.GRAY);
            g.fillRect(b.getX(), b.getY(), b.getLongeur(), b.getLargeur());
            g.setColor(Color.BLACK);
            g.drawString(b.getLabel(), b.getX(), b.getY());
        }
    }
}
