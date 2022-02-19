package tarefa10;

/**
 * Esta clase llamará a JFrame
 */
public class Principal {
    
    static Hospital hospital1=new Hospital();
    static Hospital hospital2=new Hospital();
    static Hospital hospital3=new Hospital();

    public static void main(String args[]) {
        
        new NewJFrame(hospital1).setVisible(true);
    }
}
