package Partie;

import Elements.Entite;
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
     * Liste de tous les sprites qui ne sont pas des entities
     */
    private final List<Sprite> sprites;

    /**
     * Liste de toutes les entites de la partie
     */
    private final List<Entite> entities;

    /**
     * Taille en px de chaque case du labyrinthe
     */
    public static final int TAILLE_CASE = 40;

    /**
     * Constructeur
     */
    public DessinPartie() {
        this.sprites = new ArrayList<>();
        this.entities = new ArrayList<>();
    }

    /**
     * Constructeur
     * @param sprites a afficher
     * @param entities a afficher
     */
    public DessinPartie(List<Sprite> sprites, List<Entite> entities) {
        if(entities == null)
            this.entities = new ArrayList<>();
        else
            this.entities = entities;
        if(sprites == null)
            this.sprites = new ArrayList<>();
        else
            this.sprites = sprites;
    }

    /**
     * Ajoute un sprite a afficher
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
        for(Entite e: entities) {
            e.dessiner(g);
            System.out.println(e.getBarreDeVie());
            e.getBarreDeVie().dessiner(g);

        }

        g.dispose();
    }

}
