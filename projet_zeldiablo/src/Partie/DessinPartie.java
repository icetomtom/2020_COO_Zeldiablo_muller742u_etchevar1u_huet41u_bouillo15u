package Partie;

import Elements.Joueur;
import moteurJeu.moteur.DessinAbstract;
import moteurJeu.sprite.Sprite;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Dessine une partie
 */
public class DessinPartie implements DessinAbstract {

    /**
     * Liste de tous les elements à afficher
     */
    private final List<Sprite> sprites;

    /**
     * Taille en px de chaque case du labyrinthe
     */
    public static final int TAILLE_CASE = 60;

    /**
     * Constructeur
     */
    public DessinPartie() {
        this.sprites = new ArrayList<>();
    }

    /**
     * Constructeur
     * @param sprites a afficher
     */
    public DessinPartie(List<Sprite> sprites) {
        if(sprites == null)
            this.sprites = new ArrayList<>();
        else
            this.sprites = sprites;
    }

    /**
     * Ajoute un sprite à afficher
     * @param s le sprite
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * Enleve un sprite a afficher
     * @param s le sprite
     */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }

    @Override
    public void dessiner(BufferedImage image) {
        Graphics2D g = (Graphics2D) image.getGraphics();

        for(Sprite s: sprites) {
            s.dessiner(g);
        }

        g.dispose();
    }

}
