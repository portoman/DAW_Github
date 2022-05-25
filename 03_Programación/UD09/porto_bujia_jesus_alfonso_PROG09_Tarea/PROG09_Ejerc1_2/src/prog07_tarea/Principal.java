package prog07_tarea;


/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase principal donde se instancian un objeto banco, un objeto serializadora y se inicializa el JFrame
 */
public class Principal {

    public static void main(String args[]) {
        //Instanciación de la clase serializadora
        Serializadora serializadora = new Serializadora();
        //Instanciación del objeto banco, donde se carga el contenido del fichero datoscuentasbancarias.dat
        Banco banco = (Banco) serializadora.leerObjeto("datoscuentasbancarias.dat");

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //Inicialización del JFrame a través del constructor, con parámetro banco y serializadora
                new NewJFrame(banco, serializadora).setVisible(true);
            }
        });
    }
}
