package tarefa10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tarefa10 {

    public static void main(String[] args) {
        
        Hospital hospital=new Hospital();
        JFrame ventana = new JFrame("Hospital");

        //Para cuando se cierre la ventana se cierre el programa
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Darle tamaño
        ventana.setSize(600, 400);

        JTextField campo1 = new JTextField(40);
        JTextField campo2 = new JTextField(40);
        JTextField campo3 = new JTextField(40);
        JButton boton1 = new JButton("Novo paciente");
         JTextArea area1=new JTextArea(20,40);
        
        boton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Paciente paciente=new Paciente(campo1.getText(),campo2.getText(),LocalDate.parse(campo3.getText()));
                hospital.inserirPaciente(paciente);
                area1.setText(hospital.listadoDePacientes());
            }
        }
        );
        
        
        
       

        //Objeto que sirve para acumular elementos
        JPanel panel = new JPanel();

        panel.add(campo1);
        panel.add(campo2);
        panel.add(campo3);
        panel.add(boton1);
        panel.add(area1);

        ventana.setContentPane(panel);
        ventana.setVisible(true);
    }

}
