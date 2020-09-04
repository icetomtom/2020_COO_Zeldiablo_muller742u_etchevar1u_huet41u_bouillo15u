package GUI;

import Partie.JeuPrincipal;

import java.util.ArrayList;

public class MenuPrincipal {

    /**
     * Boutons disponibles
     */
    ArrayList<Bouton> boutons;

    /**
     * String du nom de la prochaine etape, null signifie qu on reste sur le menu
     */
    String prochaine_etape = JeuPrincipal.MODE_MENU;

    String nom_niveau = null;

    /**
     * Constructeur du menu et ses boutons
     */
    public MenuPrincipal() {
        boutons = new ArrayList<>();
        boutons.add(new Bouton("Quitter", JeuPrincipal.MODE_FIN, 100, 450, 400, 100));
    }

    /**
     * Obtenir la prochaine etape
     * @return la prochaine etape
     */
    public String getProchaineEtape() {
        return prochaine_etape;
    }

    /**
     * Obtenir la prochaine etape
     * @param etape la prochaine etape
     */
    public void setProchaineEtape(String etape) {
        prochaine_etape = etape;
    }

    /**
     * setter du nom niveau
     * @param niveau
     */
    public void setNomNiveau(String niveau) {
        this.nom_niveau = niveau;
    }

    /**
     * getter du nom niveau
     * @return
     */
    public String getNomNiveau() {
        return this.nom_niveau;
    }

    public ArrayList<Bouton> getBoutons() {
        return boutons;
    }
}
