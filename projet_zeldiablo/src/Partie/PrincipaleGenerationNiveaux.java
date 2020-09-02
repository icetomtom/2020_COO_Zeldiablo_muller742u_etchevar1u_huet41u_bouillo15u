package Partie;

import Elements.Niveau;
import Usine.UsineNiveau;

import java.io.IOException;

public class PrincipaleGenerationNiveaux {

    public static void main(String[] args) throws IOException {

        Niveau n1 = UsineNiveau.getNiveauNbMonstresAlea();
        UsineNiveau.saveNiveau("niveaux/niveau1.obj", n1);

        Niveau n2 = UsineNiveau.getNiveauNbMonstresAlea();
        UsineNiveau.saveNiveau("niveaux/niveau2.obj", n2);

        Niveau n3 = UsineNiveau.getNiveau("niveaux/niveau1.obj");
        Niveau n4 = UsineNiveau.getNiveau("niveaux/niveau2.obj");

        System.out.println(n3.getMonstres().size());
    }

}
