package daw.exameninternet_ejercicio5_arraymediaimpares;
public class NewMain {

    public static void main(String[] args) {
        
        int[] a1 = {3, 5, 2, 3, 7, 4, 5};
    
        System.out.println(mediaImparesDesdePrimerPar(a1));    
        
    }

    
     public static int mediaImparesDesdePrimerPar(int[] a1) {
         int sumatorioImpares=0;
         int contadorImpares=0;
        boolean par = false;
        
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] % 2 == 0) {
                par = true;
                }
            if(par==true && a1[i]%2!=0){
                    sumatorioImpares+=a1[i];
                    contadorImpares++;
            }

        }
        return sumatorioImpares/contadorImpares;
    }
    }
    
