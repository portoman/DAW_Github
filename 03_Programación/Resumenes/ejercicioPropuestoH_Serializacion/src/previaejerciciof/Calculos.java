package previaejerciciof;

import java.util.ArrayList;

public class Calculos {

    static int maximaEdad(ArrayList<Persona> persona) {
        int max = persona.get(0).getEdad();
        for (Persona p : persona) {
            if (p.getEdad() > max) {
                max = p.getEdad();
            }
        }
        return max;
    }

    static int minimaEdad(ArrayList<Persona> persona) {
        int min = persona.get(0).getEdad();
        for (Persona p : persona) {
            if (p.getEdad() < min) {
                min = p.getEdad();
            }
        }
        return min;
    }

    static int cantidadPersonas(ArrayList<Persona> persona) {
        return persona.size();
    }

    static int mediaEdades(ArrayList<Persona> persona) {
        int suma = 0;
        for (Persona e : persona) {
            suma += e.getEdad();
        }
        int media = suma / persona.size();
        return media;
    }

}
