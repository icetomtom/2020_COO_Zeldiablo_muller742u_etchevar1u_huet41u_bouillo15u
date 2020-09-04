package Partie;

import GUI.Bouton;
import GUI.MenuPrincipal;
import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;

/**
 * Permet d'adapter un Menu a  un Jeu
 */
public class AdaptateurJeuMenu implements JeuAbstract {

    /**
     * Menu a adapter
     */
    MenuPrincipal menu;

    /**
     * Constructeur
     */
    public AdaptateurJeuMenu() {
        menu = new MenuPrincipal();
    }

    @Override
    public String evoluer(CClavier clavier, CSouris souris) {
        for(Bouton b : menu.getBoutons()) {
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
        return !menu.getProchaineEtape().equals(JeuPrincipal.MODE_MENU);
    }

    public MenuPrincipal getMenu() {
        return menu;
    }
}
