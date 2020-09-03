package Test;

import Partie.DessinMenuAdaptateur;
import Partie.AdaptateurJeuMenu;
import moteurJeu.moteur.MoteurGraphique;

public class TestGUI {
    public static void main(String[] args) {

        AdaptateurJeuMenu menuAdaptateur = new AdaptateurJeuMenu();
        DessinMenuAdaptateur dessin_menu = new DessinMenuAdaptateur(menuAdaptateur.getMenu());

        MoteurGraphique m = new MoteurGraphique(menuAdaptateur, dessin_menu);
        m.lancerJeu(600, 600, 8);
    }
}
