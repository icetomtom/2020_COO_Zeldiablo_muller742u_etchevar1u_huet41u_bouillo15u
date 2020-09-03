package Partie;

import GUI.Button;
import Usine.UsineNiveau;
import moteurJeu.moteur.CClavier;
import moteurJeu.moteur.CSouris;
import moteurJeu.moteur.JeuAbstract;
import moteurJeu.moteur.MoteurGraphique;
import moteurJeu.sprite.Sprites;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represente le jeu dans tous les etats
 */
public class JeuPrincipale implements JeuAbstract {

    /**
     * Menu principal
     */
    AdaptateurJeuMenu menu;
    /**
     * Partie, le jeu en lui meme
     */
    Jeu partie;

    /**
     * Mode de jeu actuel : MENU, PARTIE, FIN
     */
    private String mode;

    /**
     * Liste de tous les niveaux disponibles dans le dossier 'niveaux/'
     */
    private List<String> chemins_niveaux;
    /**
     * Fin du Jeu
     */
    private boolean fini;

    /**
     * Modes de jeu disponible
     */
    public final static String MODE_MENU = "MENU";
    public final static String MODE_PARTIE = "PARTIE";
    public final static String MODE_FIN = "FIN";

    /**
     * Constructeur du Jeu
     */
    public JeuPrincipale() throws IOException {
        chemins_niveaux = this.getNomNiveaux();
        fini = chemins_niveaux.size() == 0;

        mode = MODE_MENU;
        menu = new AdaptateurJeuMenu();
        int y = 30;
        for(String niveau : chemins_niveaux) {
            menu.getMenu().getButtons().add(new Button(niveau, JeuPrincipale.MODE_PARTIE, 30, y, 540, 70));
            y += 90;
        }
        partie = new Jeu();
    }

    /**
     * Recupere les niveaux disponibles
     */
    public List<String> getNomNiveaux() {
        List<String> r = new ArrayList<>();

        File f = new File("niveaux/");
        File[] files = f.listFiles();
        if(files == null)
            return r;

        for(File file : files) {
            if (file.isFile())
                r.add(file.getName());
        }

        return r;
    }

    /**
     * Fait evoluer le jeu en raport avec son etat
     * @param clavier
     *            commande utilisateur
     * @param souris
     *            commande souris
     *
     * @return null
     */
    @Override
    public String evoluer(CClavier clavier, CSouris souris) {
        String mode_precedent = mode;
        switch (mode) {
            case MODE_MENU:
                mode = menu.evoluer(clavier, souris);
                break;
            case MODE_PARTIE:
                mode = partie.evoluer(clavier, souris);
                break;
            case MODE_FIN:
                fini = true;
                return null;
        }

        // A choisi un niveau dans le menu
        if(mode_precedent.equals(MODE_MENU) && mode.equals(MODE_PARTIE)) {
            try {
                System.out.println("Ouverture de : " + "niveaux/" + menu.menu.getNomNiveau());
                partie.initialiserAvecNiveau(UsineNiveau.getNiveau("niveaux/" + menu.menu.getNomNiveau()));
            } catch (IOException e) {
                fini = true;
                e.printStackTrace();
            }
            menu.menu.setNomNiveau(null);;
            menu.menu.setProchaineEtape(MODE_MENU);
            return null;
        }

        return null;
    }

    @Override
    public boolean etreFini() {
        return fini;
    }

    public String getMode() {
        return mode;
    }

    public static void main(String[] args) throws IOException {
        Sprites.chargerFeuille("entities", "images/16x16DungeonTileset.v3.png", 16, 16);

        JeuPrincipale j = new JeuPrincipale();
        DessinPrincipale dessin = new DessinPrincipale(j);

        MoteurGraphique m = new MoteurGraphique(j, dessin);
        m.lancerJeu(600, 600, 8);
    }
}
