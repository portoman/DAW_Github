/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarefa10;

/**
 *
 * @author portb
 */
public class Hospital {
    Paciente[] pacientes=new Paciente[50];
    int primeraPosicionLibre=0;
    
    
    public void inserirPaciente(Paciente p){
        
        pacientes[primeraPosicionLibre++]=p;
     }
    
    public String listadoDePacientes(){
        String resultado="";
        
        for(int i=0;i<primeraPosicionLibre;i++){
            resultado+=pacientes[i].toString()+"\n";
            
        }
        return resultado;
    }
}
