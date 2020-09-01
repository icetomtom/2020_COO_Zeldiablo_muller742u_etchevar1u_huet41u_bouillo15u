package Test;

import Elements.Case;
import Elements.Labyrinthe;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Teste la classe labyrinthe
 */
public class TestLabyrinthe {

    /**
     * Teste le constructeur et les valeurs par défaut du constructeur
     */
    @Test
    public void test_ConstructeurDefaut() {
        Labyrinthe laby = new Labyrinthe();

        assertEquals("La longeur par défaut n'est pas bonne", 10, laby.getLongeur());
        assertEquals("La largeur par défaut n'est pas bonne", 10, laby.getLargeur());

        assertEquals("La position en X d'entree du joueur par défaut n'est pas bonne", 5, laby.getEntreeX());
        assertEquals("La position en Y d'entree du joueur par défaut n'est pas bonne", 5, laby.getEntreeY());

        Case c = null;
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                c = laby.getCase(i, j);
                if(i == 0 || j == 0 || i == 9 || j == 9)
                    assertEquals("Par défaut, les cases au bord du labyrinthe doivent être des murs",Case.TYPE_MUR, c.getType());
                else
                    assertEquals("Par défaut, les cases au milieu du labyrinthe doivent être vides", Case.TYPE_VIDE, c.getType());
            }
        }
    }

    /**
     * Lance les tests
     * @param args
     */
    public static void main(String[] args) {
        boolean succes = true;
        Result result = JUnitCore.runClasses(TestLabyrinthe.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            succes = false;
        }
        if(succes)
            System.out.println("Tous les tests se sont bien passes !");
    }
}