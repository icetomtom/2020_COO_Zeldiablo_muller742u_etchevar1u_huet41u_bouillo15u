package Usine;

import Elements.Case;
import Elements.Entite;
import Elements.Labyrinthe;
import Elements.Niveau;
import Monstre.Monstre;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UsineNiveau {

    public static Niveau getNiveauNbMonstresAlea() {
        HashMap<TYPE_MONSTRE, Integer> nb = new HashMap<>();
        for(TYPE_MONSTRE t : TYPE_MONSTRE.values()) {
            nb.put(t, (int)(Math.random() * 3) + 1);
        }
        return getNiveau(nb);
    }

    public static Niveau getNiveau(HashMap<TYPE_MONSTRE, Integer> nb_monstres) {
        List<Monstre> entites = new ArrayList<>();
        Labyrinthe l = new Labyrinthe(10, 10, false);

        Monstre m = null;
        List<Case> cases = l.getNoeuds();
        Case c = null;
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
//            System.out.println(n.getLabyrinthe().getCase(2, 1).getType());
        } catch (ClassNotFoundException e) {

        }

        is.close();
        ois.close();

        return n;
    }

    public static void saveNiveau(String fichier, Niveau n) throws IOException {
//        System.out.println(n.getLabyrinthe().getCase(2, 1).getType());
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
