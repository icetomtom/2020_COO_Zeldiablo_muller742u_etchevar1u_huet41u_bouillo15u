package GUI;

import Partie.JeuPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuPrincipale {

    /**
     * Boutons disponibles
     */
    ArrayList<Button> buttons;

    /**
     * String du nom de la prochaine etape, null signifie qu'on reste sur le menu
     */
    String prochaine_etape = JeuPrincipale.MODE_MENU;

    /**
     * Constructeur du menu et ses boutons
     */
    public MenuPrincipale() {
        buttons = new ArrayList<>();
        buttons.add(new Button("Jouer", JeuPrincipale.MODE_PARTIE, 10, 10, 580, 200));
//        buttons.add(new Button("Niveau 1"));
    }

    /**
     * Obtenir la prochaine étape
     * @return la prochaine etape
     */
    public String getProchaineEtape() {
        return prochaine_etape;
    }

    /**
     * Obtenir la prochaine étape
     * @param etape la prochaine etape
     */
    public void setProchaineEtape(String etape) {
        prochaine_etape = etape;
    }

    public ArrayList<Button> getButtons() {
        return buttons;
    }
}
