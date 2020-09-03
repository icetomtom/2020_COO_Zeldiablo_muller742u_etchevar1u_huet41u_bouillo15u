package Partie;

import GUI.Button;
import GUI.MenuPrincipale;
import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;

public class AdaptateurJeuMenu implements JeuAbstract {

    MenuPrincipale menu;

    public AdaptateurJeuMenu() {
        menu = new MenuPrincipale();
    }

    @Override
    public String evoluer(CClavier clavier, CSouris souris) {
        for(Button b : menu.getButtons()) {
            if(souris.isPressed() && b.collision(souris.getX(), souris.getY())) {
                menu.setProchaineEtape(b.getEtape());
            break;
            }
        }
        return menu.getProchaineEtape();
    }

    @Override
    public boolean etreFini() {
        return menu.getProchaineEtape() != null;
    }

    public MenuPrincipale getMenu() {
        return menu;
    }
}
