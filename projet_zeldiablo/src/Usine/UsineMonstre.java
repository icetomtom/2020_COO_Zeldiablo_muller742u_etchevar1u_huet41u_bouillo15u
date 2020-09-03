package Usine;

import Monstre.Monstre;
import Monstre.Fantome;
import Monstre.MonstreImmobile;
import Monstre.Troll;

 

public class UsineMonstre {
	
    public static Monstre getMonstre(TYPE_MONSTRE type) {
        switch (type) {
            case MONSTRE_IMMO:
                return new MonstreImmobile();
            case MONSTRE_TROLL:
                return new Troll();
            case MONSTRE_FANTOME:
                return new Fantome();
            default:
                throw new IllegalArgumentException("Type de Monstre '" + type + "' inconnu");
        }
    }
}
