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


//        Niveau n = UsineNiveau.getNiveau("niveaux/niveau3_2.obj");
//        Case c_porte = n.getLabyrinthe().getCase(5, 3);
//        Case c_vide = n.getLabyrinthe().getCase(6, 7);
//        for (Monstre m : n.getMonstres())
//            if (m.getPosY() == 5 && m.getPosX() == 13)
//                m.setPosX(1);

//        c_porte.setX(6);
//        c_porte.setY(7);
//        ((Porte) c_porte).changerEtat(true);
//
//        c_vide.setX(5);
//        c_vide.setY(3);
//
//        n.getLabyrinthe().setCase(c_porte);
//        n.getLabyrinthe().setCase(c_vide);

////
//
//
//        UsineNiveau.saveNiveau("niveaux/niveau3_2.obj", n);

        for(int i = 0; i < 4; i++) {
//
            HashMap<TYPE_MONSTRE, Integer> montres_lvl_1 = new HashMap<>();
            montres_lvl_1.put(TYPE_MONSTRE.MONSTRE_FANTOME, 4);
            montres_lvl_1.put(TYPE_MONSTRE.MONSTRE_TROLL, 4);
            montres_lvl_1.put(TYPE_MONSTRE.MONSTRE_IMMO, 1);
            Niveau n1 = UsineNiveau.getNiveau(montres_lvl_1, 15, 15);
            UsineNiveau.saveNiveau("niveaux/niveau1_"+i+".obj", n1);
        }

//        UsineNiveau.saveNiveau("niveaux/niveau_vide", new Niveau(new Labyrinthe(), new ArrayList<Monstre>()));

    }
}
