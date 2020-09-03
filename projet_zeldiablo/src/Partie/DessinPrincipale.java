package Partie;

import moteurJeu.moteur.DessinAbstract;

import java.awt.image.BufferedImage;

public class DessinPrincipale implements DessinAbstract {

    private final DessinAbstract dessinMenu;
    private final DessinAbstract dessinJeu;

    private final JeuPrincipale j;

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
        }
    }
}
