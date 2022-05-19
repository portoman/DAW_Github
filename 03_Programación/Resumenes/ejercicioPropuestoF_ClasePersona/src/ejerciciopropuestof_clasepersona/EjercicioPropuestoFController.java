package ejerciciopropuestof_clasepersona;

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
public class EjercicioPropuestoFController implements Initializable {

    @FXML
    private Button insertar;
    @FXML
    private TextField nombre;
    @FXML
    private TextField edad;
    @FXML
    private Button Max;
    @FXML
    private Button Min;
    @FXML
    private Button Media;
    @FXML
    private Button Longitud;
    @FXML
    private TextArea listado;
    @FXML
    private TextField resultado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    String lista = "";
    ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

    @FXML
    private void insertar(ActionEvent event) {
        String n = nombre.getText();
        int e = Integer.parseInt(edad.getText());

        lista = lista + "nombre: " + n + ", edad:" + e + "\n";
        Persona persona = new Persona(n, e);
        listado.setText(lista);
        listaPersonas.add(persona);
    }

    @FXML
    private void Max(ActionEvent event) {
        int mayorEdad = listaPersonas.get(0).edad;

        for (Persona persona : listaPersonas) {
              if(persona.edad>mayorEdad)
                  mayorEdad=persona.edad;
        }
        resultado.setText(String.valueOf(mayorEdad));
    }

    @FXML
    private void Min(ActionEvent event) {
        int menorEdad = listaPersonas.get(0).edad;

        for (Persona persona : listaPersonas) {
              if(persona.edad<menorEdad)
                  menorEdad=persona.edad;
        }
        resultado.setText(String.valueOf(menorEdad));
    }

    @FXML
    private void Media(ActionEvent event) {
         int suma=0;
        for (Persona persona:listaPersonas)
        {
            suma=suma+persona.edad;
        }
        resultado.setText(String.valueOf(suma/listaPersonas.size()));
        
    }

    @FXML
    private void longitud(ActionEvent event) {
        resultado.setText(String.valueOf(listaPersonas.size()));
    }

}
