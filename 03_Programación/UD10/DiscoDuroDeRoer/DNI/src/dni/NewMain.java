/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dni;

/**
 *
 * @author portb
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       
        DNI dni1=new DNI();
        
        dni1.establecer(47353500);
        
        System.out.println(dni1.obtenerDNI());
        
    }
    
}
