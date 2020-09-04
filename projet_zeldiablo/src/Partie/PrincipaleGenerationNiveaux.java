package Partie;

import Elements.Case;
import Elements.Labyrinthe;
import Elements.Niveau;
import Elements.Porte;
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

        // Décommenter pour generer de nouveaux niveaux ! Ecrases les anciens !

//        for(int i = 0; i < 4; i++) {
////
//            HashMap<TYPE_MONSTRE, Integer> montres_lvl_1 = new HashMap<>();
//            montres_lvl_1.put(TYPE_MONSTRE.MONSTRE_FANTOME, 5);
//            montres_lvl_1.put(TYPE_MONSTRE.MONSTRE_TROLL, 7);
//            montres_lvl_1.put(TYPE_MONSTRE.MONSTRE_IMMO, 4);
//            Niveau n1 = UsineNiveau.getNiveau(montres_lvl_1, 15, 15);
//            UsineNiveau.saveNiveau("niveaux/niveau3_"+i+".obj", n1);
//        }

//        UsineNiveau.saveNiveau("niveaux/niveau_vide", new Niveau(new Labyrinthe(), new ArrayList<Monstre>()));

    }
}
