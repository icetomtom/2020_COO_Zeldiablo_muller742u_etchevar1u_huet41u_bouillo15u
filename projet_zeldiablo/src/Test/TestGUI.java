package Test;

import Partie.DessinMenu;
import Partie.AdaptateurJeuMenu;
import moteurJeu.moteur.MoteurGraphique;

public class TestGUI {
    public static void main(String[] args) {

        AdaptateurJeuMenu menuAdaptateur = new AdaptateurJeuMenu();
        DessinMenu dessin_menu = new DessinMenu(menuAdaptateur.getMenu());

        MoteurGraphique m = new MoteurGraphique(menuAdaptateur, dessin_menu);
        m.lancerJeu(600, 600, 8);
    }
}
