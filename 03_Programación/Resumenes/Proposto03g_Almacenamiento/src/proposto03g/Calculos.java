package proposto03g;

import java.util.ArrayList;

public class Calculos {

    static int cantos(ArrayList<Persoa> lista) {
        return lista.size();
    }

    static int max(ArrayList<Persoa> lista) {
        int max = 0;
        if (cantos(lista) > 0) {
            max = lista.get(0).getIdade();
            for (int i = 1; i < cantos(lista); i++) {
                if (lista.get(i).getIdade() > max) {
                    max = lista.get(i).getIdade();
                }
            }
        }
        return max;
    }

    static int min(ArrayList<Persoa> lista) {
        int min = 0;
        if (cantos(lista) > 0) {
            min = lista.get(0).getIdade();
            for (int i = 1; i < cantos(lista); i++) {
                if (lista.get(i).getIdade() < min) {
                    min = lista.get(i).getIdade();
                }
            }
        }
        return min;
    }

    static float media(ArrayList<Persoa> lista) {
        float media = 0;
        int suma = 0;
        if (cantos(lista) > 0) {
            for (Persoa p : lista) {
                suma += p.getIdade();
            }
            media = (float)suma / cantos(lista);
        }
        return media;
    }

}
