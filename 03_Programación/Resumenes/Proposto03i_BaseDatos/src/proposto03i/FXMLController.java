/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proposto03i;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class FXMLController implements Initializable {

    @FXML
    private Button botonEngadir;
    @FXML
    private Button botonEstatisticas;
    @FXML
    private TextField nome;
    @FXML
    private TextField idade;
    @FXML
    private Label erro;
    @FXML
    private TextArea lista;
    @FXML
    private TextArea estatisticas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            //Al iniciar, se leen los datos de la base de datos
            ResultSet persoas = Datos.ler(NewFXMain.con);
            while (persoas.next()) {
                lista.appendText(persoas.getString(1) + " (" + persoas.getInt(2) + ")" + "\n");
            }
        } catch (SQLException ex) {
            erro.setText("Non foi posible ler datos. " + ex.getMessage());
        }
    }

    @FXML
    private void engadirPersoa(ActionEvent event) {
        try {
            if (!nome.getText().isEmpty() && !nome.getText().isEmpty()) {
                Persoa novaPersoa = new Persoa(nome.getText(), Integer.parseInt(idade.getText()));
                //Se añade en el textArea
                lista.appendText(novaPersoa.toString() + "\n");
                //Se inserta en la base de datos
                Datos.escribir(novaPersoa, NewFXMain.con);
                //Se vacian los textField
                nome.setText("");
                idade.setText("");
                erro.setText("");
            } else {
                erro.setText("Hai que introducir os dous datos");
            }
        } catch (NumberFormatException ex) {
            erro.setText("A idade debe ser un número enteiro");
        }
    }

    @FXML
    private void verEstatisticas(ActionEvent event) {
        Calculos calculos = Datos.estatistica(NewFXMain.con);
        estatisticas.clear();
        estatisticas.appendText("Cantos: " + calculos.cantos + "\n");
        estatisticas.appendText("Mínimo: " + calculos.min + "\n");
        estatisticas.appendText("Máximo: " + calculos.max + "\n");
        estatisticas.appendText("Media: " + calculos.media + "\n");        
    }

}
