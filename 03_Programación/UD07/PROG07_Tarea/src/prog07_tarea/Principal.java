package prog07_tarea;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase principal donde se instancia un objeto banco y se inicializa el JFrame
 */
public class Principal {

    //Instanciación del objeto banco
    static private Banco banco = new Banco();

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //Inicialización del JFrame a través del constructor y con parámetro banco
                new NewJFrame(banco).setVisible(true);
            }
        });
    }

}
