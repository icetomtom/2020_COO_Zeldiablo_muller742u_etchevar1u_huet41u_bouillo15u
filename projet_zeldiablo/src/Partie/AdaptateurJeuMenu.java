package Partie;

import GUI.Button;
import GUI.MenuPrincipale;
import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;

/**
 * Permet d'adapter un Menu à un Jeu
 */
public class AdaptateurJeuMenu implements JeuAbstract {

    /**
     * Menu à adapter
     */
    MenuPrincipale menu;

    /**
     * Constructeur
     */
    public AdaptateurJeuMenu() {
        menu = new MenuPrincipale();
    }

    @Override
    public String evoluer(CClavier clavier, CSouris souris) {
        for(Button b : menu.getButtons()) {
            if(souris.isPressed() && b.collision(souris.getX(), souris.getY())) {
                menu.setNomNiveau(b.getLabel());
                menu.setProchaineEtape(b.getEtape());
                break;
            }
        }
        return menu.getProchaineEtape();
    }

    @Override
    public boolean etreFini() {
        return !menu.getProchaineEtape().equals(JeuPrincipale.MODE_MENU);
    }

    public MenuPrincipale getMenu() {
        return menu;
    }
}
