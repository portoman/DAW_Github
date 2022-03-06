package daw.prog10_1_tarea;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase principal donde se crean un array surtidores y recadación total con los valores que quereamos
y se incicializa el JFrame
 */
public class ClasePrincipal {

    //Declaración e inicialización del array surtidores y recadacionTotal con los valores a cero
    static double[] surtidores = {0, 0, 0, 0, 0, 0, 0, 0};
    static double recadacionTotal = 0;

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //Inicialización del JFrame a través del constructor y con surtidores y recadacionTotal
                new NewJFrame(surtidores, recadacionTotal).setVisible(true);
            }
        });
    }

}
