package Test;

import Elements.Joueur;
import moteurJeu.sprite.Sprite;
import moteurJeu.sprite.Sprites;
import org.junit.Assert;
import org.junit.Test;

import Partie.Jeu;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import static org.junit.Assert.*;

/**
 * classe de test affichage avec sprite
 * @author hugo-
 *
 */
public class TestAffichageAvecSprite {

    @Test
    public void test_SpriteConcerneEntites() {
        Joueur j = new Joueur();
        assertTrue("Joueur n'est pas un sprite !", j instanceof Sprite);

    }

    @Test
    public void test_ChargementImages() {
        File f = new File(".");
        Sprites.chargerFeuille("personnages", "images/test_sprites.png", 6, 3);

        int i=0,j=0;
        try {
            for(i = 0; i<6; i++) {
                for (j = 0; j < 3; j ++) {
                    Sprites.getImage("personnages_" + i + "_" + j);
                }
            }
        } catch (Error e) {
            Assert.fail("L'image en (" +i+ ", " +j+") n'a pas été chargée !" );
        }

        assertNull("Trop d'images ont été crées : en (6, 0)", Sprites.getImage("personnages_6_0"));
        assertNull("Trop d'images ont été crées : en (0, 3)", Sprites.getImage("personnages_0_3"));
    }

    @Test
    public void test_AffichageImg() {
        Sprites.chargerFeuille("personnages_2", "images/test_sprites.png", 6, 3);
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                g.drawImage(Sprites.getImage("personnages_2_0_0"), 0, 0, null);
            }
        };

    }

    /**
     * Lance les tests
     * @param args
     */
    public static void main(String[] args) {
        boolean succes = true;
        Result result = JUnitCore.runClasses(TestAffichageAvecSprite.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            succes = false;
        }
        if(succes)
            System.out.println("Tous les tests se sont bien passes !");
    }
}
