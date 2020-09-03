package Partie;

import Elements.Labyrinthe;
import Elements.Niveau;
import Monstre.Monstre;
import Usine.TYPE_MONSTRE;
import Usine.UsineNiveau;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Principale pour creer et sauvegarder les niveaux
 */
public class PrincipaleGenerationNiveaux {

    /**
     * Methode pour creer et sauvegarder des niveaux
     */
    public static void main(String[] args) throws IOException {

//        HashMap<TYPE_MONSTRE, Integer> montres_lvl_1 = new HashMap<>();
//        montres_lvl_1.put(TYPE_MONSTRE.MONSTRE_IMMO, 3);
//        Niveau n1 = UsineNiveau.getNiveau(montres_lvl_1);
//        UsineNiveau.saveNiveau("niveaux/niveau1.obj", n1);

        HashMap<TYPE_MONSTRE, Integer> montres_lvl_2 = new HashMap<>();
        montres_lvl_2.put(TYPE_MONSTRE.MONSTRE_IMMO, 2);
        montres_lvl_2.put(TYPE_MONSTRE.MONSTRE_FANTOME, 1);
        Niveau n2 = UsineNiveau.getNiveau(montres_lvl_2);
        UsineNiveau.saveNiveau("niveaux/niveau2.obj", n2);

        UsineNiveau.saveNiveau("niveaux/niveau_vide", new Niveau(new Labyrinthe(), new ArrayList<Monstre>()));

    }
}
