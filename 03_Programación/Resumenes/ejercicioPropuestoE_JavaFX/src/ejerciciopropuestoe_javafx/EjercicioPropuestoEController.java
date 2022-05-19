/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciopropuestoe_javafx;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author portb
 */
public class EjercicioPropuestoEController implements Initializable {

    @FXML
    private Button insertar;
    @FXML
    private Button Salir;
    @FXML
    private TextField campo;
    @FXML
    private TextArea listado;
    @FXML
    private TextField resultado;
    @FXML
    private Button Max;
    @FXML
    private Button Min;
    @FXML
    private Button Longitud;
    @FXML
    private Button Media;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    String list = "";
    ArrayList<Integer>listadoArrayList=new ArrayList<Integer>();
    @FXML
    private void insertar(ActionEvent event) {
        try {
            int num = Integer.parseInt(campo.getText());
            listadoArrayList.add(num);
            list = list + num + "\n";
            listado.setText(String.valueOf(list));

        } catch (NumberFormatException e) {
            //Si los operandos no son enteros, aparece un mensaje de error
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Los operandos deben ser números enteros");
            alerta.showAndWait();
        }
    }

    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void Max(ActionEvent event) {
        int numeroMaximo=listadoArrayList.get(0);
        for (int numero:listadoArrayList)
        {
            if(numero>numeroMaximo){
                numeroMaximo=numero;
            }
        }
        resultado.setText(String.valueOf(numeroMaximo));
    }

    @FXML
    private void Min(ActionEvent event) {
        int numeroMinimo=listadoArrayList.get(0);
        for (int numero:listadoArrayList)
        {
            if(numero<numeroMinimo){
                numeroMinimo=numero;
            }
        }
        resultado.setText(String.valueOf(numeroMinimo));
    }

    @FXML
    private void Longitud(ActionEvent event) {
        resultado.setText(String.valueOf(listadoArrayList.size()));
    }

    @FXML
    private void Media(ActionEvent event) {
        int suma=0;
        for (int numero:listadoArrayList)
        {
            suma=suma+numero;
        }
        resultado.setText(String.valueOf(suma/listadoArrayList.size()));
        
    }

}
