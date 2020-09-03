package Partie;

import moteurJeu.moteur.DessinAbstract;
import moteurJeu.sprite.Sprite;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DessinPartie implements DessinAbstract {

    private final List<Sprite> sprites;

    public static final int TAILLE_CASE = 60;

    public DessinPartie() {
        this.sprites = new ArrayList<>();
    }

    public DessinPartie(List<Sprite> sprites) {
        this.sprites = sprites;
    }

    public void addSprite(Sprite s) {
        sprites.add(s);
    }

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
