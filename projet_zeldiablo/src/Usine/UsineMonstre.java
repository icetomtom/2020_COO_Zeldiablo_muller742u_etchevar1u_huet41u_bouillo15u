package Usine;

import Elements.Entite;
import Monstre.MonstreImmobile;

enum TYPE_MONSTRE {
    MONSTRE_IMMO,
}

public class UsineMonstre {

    public static Entite getMonstre(TYPE_MONSTRE type) {
        switch (type) {
            case MONSTRE_IMMO:
                return new MonstreImmobile();
//            case MONSTRE_IMMO:
//                return new MonstreImmobile();
//            break;
            default:
                throw new IllegalArgumentException("Type de Monstre '" + type + "' inconnu");
        }
    }
}
