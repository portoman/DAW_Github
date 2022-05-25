/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package previaejerciciof;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author portb
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField nombre;
    @FXML
    private TextField edad;
    @FXML
    private Button Añadir;
    @FXML
    private TextArea Area;

    @FXML
    private TextArea campoEstadisticas;
    @FXML
    private Button estadisticas;

    /**
     * Initializes the controller class.
     */
    ArrayList<Persona> personas = new ArrayList<Persona>();
    File f = new File("datos.dat");

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        personas = Datos.leer(f);
        for (Persona p : personas) {
            Area.appendText(p.getNombre() + " " + p.getEdad() + "\n");
        }

    }

    @FXML
    private void anhadir(ActionEvent event) {

        try {
            String n = nombre.getText();
            int e = Integer.valueOf(edad.getText());

            Area.appendText(n + " " + e + "\n");
            personas.add(new Persona(n, e));
        } catch (Exception e) {
            Area.setText("Debe ser un numero");
        }

        //Escribimos cada vez que añadimos
        Datos.escribir(personas, f);

    }

    @FXML
    private void estadistica(ActionEvent event) {

        campoEstadisticas.setText("Cantidad: " + Calculos.cantidadPersonas(personas) + "\n"
                + "Media: " + Calculos.mediaEdades(personas) + "\n"
                + "Máxima: " + Calculos.maximaEdad(personas) + "\n"
                + "Mínima: " + Calculos.minimaEdad(personas));
    }

}
