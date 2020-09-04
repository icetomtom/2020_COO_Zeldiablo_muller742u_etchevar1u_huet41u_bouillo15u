package Test;

import Elements.Niveau;
import Monstre.Fantome;
import Monstre.Monstre;
import Monstre.MonstreImmobile;
import Monstre.Troll;
import Usine.TYPE_MONSTRE;
import Usine.UsineNiveau;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class TestUsineNiveau {
    @Test
    public void test_monstres_alea() {
        // Comme valeurs sont aléatoires, on teste plusieurs fois
        for (int i = 0; i<10; i++) {
            Niveau n = UsineNiveau.getNiveauNbMonstresAlea();
            assertFalse("Le nombre de monstres ne peut pas être 0", n.getMonstres().isEmpty());
            assertNotNull("il doit y avoir un labyrinthe non null", n.getLabyrinthe());
        }
    }

    @Test
    public void test_monstres_definis() {
        HashMap<TYPE_MONSTRE, Integer> nb_monstres = new HashMap<>();
        nb_monstres.put(TYPE_MONSTRE.MONSTRE_IMMO, 2);
        nb_monstres.put(TYPE_MONSTRE.MONSTRE_FANTOME, 1);
        nb_monstres.put(TYPE_MONSTRE.MONSTRE_TROLL, 5);

        Niveau n = UsineNiveau.getNiveau(nb_monstres);
        assertEquals("Le nombre de monstres n'est pas le bon", 8, n.getMonstres().size());

        ArrayList<Monstre> fantomes = new ArrayList(n.getMonstres());
        fantomes.removeIf(monstre -> !(monstre instanceof Fantome));
        assertEquals("Le nombre de fantomes n'est pas le bon", 1, fantomes.size());

        ArrayList<Monstre> trolls = new ArrayList(n.getMonstres());
        trolls.removeIf(monstre -> !(monstre instanceof Troll));
        assertEquals("Le nombre de trolls n'est pas le bon", 5, trolls.size());

        ArrayList<Monstre> immo = new ArrayList(n.getMonstres());
        immo.removeIf(monstre -> !(monstre instanceof MonstreImmobile));
        assertEquals("Le nombre de monstres immobiles n'est pas le bon", 2, immo.size());
    }

    @Test public void test_chargement() throws IOException {
        Niveau n = UsineNiveau.getNiveauNbMonstresAlea();
        UsineNiveau.saveNiveau("niveaux/niveau_tmp.obj", n);

        Niveau save = UsineNiveau.getNiveau("niveaux/niveau_tmp.obj");

        assertEquals("Le nombre de monstres de la sauvegarde n'est pas bon", n.getMonstres().size(), save.getMonstres().size());
        Monstre m1, m2;
        for(int i = 0; i < save.getMonstres().size(); i++) {
            m1 = n.getMonstres().get(i);
            m2 = save.getMonstres().get(i);
            assertEquals("Le type de monstre n'est pas le bon", m1.getClass(), m2.getClass());
            assertEquals("la position n'est pas la bonne : ", m1.getPosX()+" "+m1.getPosY(), m2.getPosX()+" "+m2.getPosY());
        }

        (new File("niveaux/niveau_tmp.obj")).delete();
    }
}
