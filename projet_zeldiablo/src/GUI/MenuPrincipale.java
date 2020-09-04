package GUI;

import Partie.JeuPrincipale;

import java.util.ArrayList;

public class MenuPrincipale {

    /**
     * Boutons disponibles
     */
    ArrayList<Bouton> boutons;

    /**
     * String du nom de la prochaine etape, null signifie qu'on reste sur le menu
     */
    String prochaine_etape = JeuPrincipale.MODE_MENU;

    String nom_niveau = null;

    /**
     * Constructeur du menu et ses boutons
     */
    public MenuPrincipale() {
        boutons = new ArrayList<>();
        boutons.add(new Bouton("Quitter", JeuPrincipale.MODE_FIN, 100, 450, 400, 100));
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

    public void setNomNiveau(String niveau) {
        this.nom_niveau = niveau;
    }

    public String getNomNiveau() {
        return this.nom_niveau;
    }

    public ArrayList<Bouton> getBoutons() {
        return boutons;
    }
}
