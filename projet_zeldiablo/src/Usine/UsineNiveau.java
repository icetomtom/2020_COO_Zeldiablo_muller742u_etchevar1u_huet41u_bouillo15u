package Usine;

import Elements.*;
import Monstre.Monstre;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UsineNiveau {

    public static Niveau getNiveauNbMonstresAlea() {
        return getNiveauNbMonstresAlea(10, 10);
    }

    public static Niveau getNiveau(HashMap<TYPE_MONSTRE, Integer> nb_monstres) {
        return getNiveau(nb_monstres, 10, 10);
    }

    public static Niveau getNiveauNbMonstresAlea(int longeur_laby, int largeur_laby) {
        HashMap<TYPE_MONSTRE, Integer> nb = new HashMap<>();
        for(TYPE_MONSTRE t : TYPE_MONSTRE.values()) {
            nb.put(t, (int)(Math.random() * 3) + 1);
        }
        return getNiveau(nb, longeur_laby, largeur_laby);
    }

    public static Niveau getNiveau(HashMap<TYPE_MONSTRE, Integer> nb_monstres, int longeur_laby, int largeur_laby) {

        List<Monstre> entites = new ArrayList<>();
        Labyrinthe l = new Labyrinthe(longeur_laby, largeur_laby, false);

        List<Case> noeuds = l.getNoeuds();
        Case c = noeuds.get((int)(Math.random()*noeuds.size()));
        noeuds.remove(c);
        CasePiege cp = new CasePiege(c.getPosX(), c.getPosY());

        c = noeuds.get((int)(Math.random()*noeuds.size()));
        Porte p = new Porte(c.getPosX(), c.getPosY());
        noeuds.remove(c);

        c = noeuds.get((int)(Math.random()*noeuds.size()));
        CaseSecrete o = new CaseSecrete(c.getPosX(), c.getPosY(), p, Case.TYPE_OUVERTURE);
        noeuds.remove(c);

        c = noeuds.get((int)(Math.random()*noeuds.size()));
        CaseSecrete f = new CaseSecrete(c.getPosX(), c.getPosY(), p, Case.TYPE_FERMETURE);
        noeuds.remove(c);

        l.setCase(cp);
        l.setCase(p);
        l.setCase(o);
        l.setCase(f);
        
        Monstre m = null;
        List<Case> cases = l.getNoeuds();
        c = null;
        int nb = cases.size();

        for(TYPE_MONSTRE type : nb_monstres.keySet()) {
            for (int i=0; i<nb_monstres.get(type); i++) {
                m = UsineMonstre.getMonstre(type);
                c = cases.get((int)(Math.random() * nb));
                m.setPosX(c.getPosX());
                m.setPosY(c.getPosY());
                nb--;
                cases.remove(c);
                entites.add(m);
            }
        }

        return new Niveau(l, entites);
    }

    public static Niveau getNiveau(String fichier) throws IOException {

        if(fichier == null) {
            throw new IllegalArgumentException("Le nom du fichier ne peut pas etre null");
        }

        FileInputStream is = new FileInputStream(new File(fichier));
        ObjectInputStream ois = new ObjectInputStream(is);

        Niveau n=null;
        try {
            n = (Niveau) ois.readObject();
        } catch (ClassNotFoundException e) {

        }

        is.close();
        ois.close();

        return n;
    }

    public static void saveNiveau(String fichier, Niveau n) throws IOException {
        if(n == null)
            return;

        File f = new File(fichier);
        f.createNewFile();
        FileOutputStream os = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos.writeObject(n);

        os.close();
        oos.close();
    }

}
