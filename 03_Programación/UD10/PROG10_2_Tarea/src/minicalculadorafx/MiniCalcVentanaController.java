package minicalculadorafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase controladora que implementa la interfaz Initializable y contiene todo el código asociado a la ventana, 
es decir, toda la lógica de negocio. Contiene 4 manejadores de eventos para realizar las operaciones requeridas:
sumar, restar, multiplicar y dividir. Se incluyen mejoras: no se permiten divisores igual a 0, se añaden botones de incrementar
y disminuir valor para cada uno de los operandos, inicialización a cero individual e inicialización general.
 */
public class MiniCalcVentanaController implements Initializable {

    @FXML
    private TextField tfNumero1;
    @FXML
    private TextField tfNumero2;
    @FXML
    private TextField tfNumero3;
    @FXML
    private TextField tfNumero4;
    @FXML
    private TextField tfResultado;
    @FXML
    private Button sumar;
    @FXML
    private Button restar;
    @FXML
    private Button multiplicar;
    @FXML
    private Button dividir;
    @FXML
    private Button N1add;
    @FXML
    private Button N1remove;
    @FXML
    private Button N2remove;
    @FXML
    private Button N2add;
    @FXML
    private Button N3remove;
    @FXML
    private Button N3add;
    @FXML
    private Button N4add;
    @FXML
    private Button N4remove;
    @FXML
    private Button N1C;
    @FXML
    private Button N2C;
    @FXML
    private Button N3C;
    @FXML
    private Button N4C;
    @FXML
    private Button AllC;

    //Manejador del botón sumar
    @FXML
    private void buttonSumarHandler(ActionEvent event) {
        //Variables para almacenar los operandos a sumar.
        int num1, num2, num3, num4, resul;
        try {
            num1 = Integer.parseInt(tfNumero1.getText());
            num2 = Integer.parseInt(tfNumero2.getText());
            num3 = Integer.parseInt(tfNumero3.getText());
            num4 = Integer.parseInt(tfNumero4.getText());
            //Ya hemos recogido el valor de los operandos de los campos de texto de la interfaz. Realizamos la suma.
            resul = num1 + num2 + num3 + num4;

            tfResultado.setText(String.valueOf(resul));
        } catch (NumberFormatException e) {
            //Si los operandos no son enteros, aparece un mensaje de error
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Los operandos deben ser números enteros");
            alerta.showAndWait();
        }
    }

    //Manejador del botón restar
    @FXML
    private void buttonRestarHandler(ActionEvent event) {
        //Variables para almacenar los operandos a restar.
        int num1, num2, num3, num4, resul;
        try {
            num1 = Integer.parseInt(tfNumero1.getText());
            num2 = Integer.parseInt(tfNumero2.getText());
            num3 = Integer.parseInt(tfNumero3.getText());
            num4 = Integer.parseInt(tfNumero4.getText());
            //Ya hemos recogido el valor de los operandos de los campos de texto de la interfaz. Realizamos la resta.
            resul = num1 - num2 - num3 - num4;

            tfResultado.setText(String.valueOf(resul));
        } catch (NumberFormatException e) {
            //Si los operandos no son enteros, aparece un mensaje de error
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Los operandos deben ser números enteros");
            alerta.showAndWait();
        }
        ;

    }

    //Manejador del botón multiplicar
    @FXML
    private void buttonMultiplicarHandler(ActionEvent event) {
        //Variables para almacenar los operandos a multiplicar.
        int num1, num2, num3, num4, resul;
        try {
            num1 = Integer.parseInt(tfNumero1.getText());
            num2 = Integer.parseInt(tfNumero2.getText());
            num3 = Integer.parseInt(tfNumero3.getText());
            num4 = Integer.parseInt(tfNumero4.getText());
            //Ya hemos recogido el valor de los operandos de los campos de texto de la interfaz. Realizamos la multiplicación.
            resul = num1 * num2 * num3 * num4;

            tfResultado.setText(String.valueOf(resul));
        } catch (NumberFormatException e) {
            //Si los operandos no son enteros, aparece un mensaje de error
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Los operandos deben ser números enteros");
            alerta.showAndWait();
        }
        ;

    }

    //Manejador del botón dividir
    @FXML
    private void buttonDividirHandler(ActionEvent event) {

        //Variables para almacenar los operandos a dividir.
        int num1, num2, num3, num4;
        double resul;
        try {
            num1 = Integer.parseInt(tfNumero1.getText());
            num2 = Integer.parseInt(tfNumero2.getText());
            num3 = Integer.parseInt(tfNumero3.getText());
            num4 = Integer.parseInt(tfNumero4.getText());
            /*Ya hemos recogido el valor de los operandos de los campos de texto de la interfaz.
            Añadimos una mejora que consiste en comprobar que ningún divisor sea 0. Si lo es saldrá un mensaje de error
             */
            if (num2 == 0 || num3 == 0 || num4 == 0) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("Error");
                alerta.setContentText("Los divisores no deben ser 0");
                alerta.showAndWait();
            } else {
                //Si ninguno de los divisores es 0, se realiza la división
                resul = (double) num1 / num2 / num3 / num4;
                tfResultado.setText(String.valueOf(resul));
            }

        } catch (NumberFormatException e) {
            //Si los operandos no son enteros, aparece un mensaje de error
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Los operandos deben ser números enteros");
            alerta.showAndWait();
        }
        ;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    //Manejador para salir de la aplicación
    @FXML
    private void buttonSalirHandler(ActionEvent event) {
        System.exit(0);
    }

    //Manejador para incrementar valor al operando número 1
    @FXML
    private void N1add(ActionEvent event) {
        int num1 = Integer.parseInt(tfNumero1.getText());
        num1++;
        tfNumero1.setText(String.valueOf(num1));
    }

    //Manejador para reducir valor al operando número 1
    @FXML
    private void N1remove(ActionEvent event) {
        int num1 = Integer.parseInt(tfNumero1.getText());
        num1--;
        tfNumero1.setText(String.valueOf(num1));
    }

    //Manejador para incrementar valor al operando número 2
    @FXML
    private void N2add(ActionEvent event) {
        int num2 = Integer.parseInt(tfNumero2.getText());
        num2++;
        tfNumero2.setText(String.valueOf(num2));
    }

    //Manejador para reducir valor al operando número 2
    @FXML
    private void N2remove(ActionEvent event) {
        int num2 = Integer.parseInt(tfNumero2.getText());
        num2--;
        tfNumero2.setText(String.valueOf(num2));
    }

    //Manejador para incrementar valor al operando número 3
    @FXML
    private void N3add(ActionEvent event) {
        int num3 = Integer.parseInt(tfNumero3.getText());
        num3++;
        tfNumero3.setText(String.valueOf(num3));
    }

    //Manejador para reducir valor al operando número 3
    @FXML
    private void N3remove(ActionEvent event) {
        int num3 = Integer.parseInt(tfNumero3.getText());
        num3--;
        tfNumero3.setText(String.valueOf(num3));
    }

    //Manejador para incrementar valor al operando número 4
    @FXML
    private void N4add(ActionEvent event) {
        int num4 = Integer.parseInt(tfNumero4.getText());
        num4++;
        tfNumero4.setText(String.valueOf(num4));
    }

    //Manejador para reducir valor al operando número 4
    @FXML
    private void N4remove(ActionEvent event) {
        int num4 = Integer.parseInt(tfNumero4.getText());
        num4--;
        tfNumero4.setText(String.valueOf(num4));
    }

    //Manejador para poner a cero el operando número 1
    @FXML
    private void N1C(ActionEvent event) {
        tfNumero1.setText("0");
    }

    //Manejador para poner a cero el operando número 2
    @FXML
    private void N2C(ActionEvent event) {
        tfNumero2.setText("0");
    }

    //Manejador para poner a cero el operando número 3
    @FXML
    private void N3C(ActionEvent event) {
        tfNumero3.setText("0");
    }

    //Manejador para poner a cero el operando número 4
    @FXML
    private void N4C(ActionEvent event) {
        tfNumero4.setText("0");
    }

    //Manejador para poner a cero todos los operandos y en blanco el campo resultado
    @FXML
    private void AllC(ActionEvent event) {
        tfNumero1.setText("0");
        tfNumero2.setText("0");
        tfNumero3.setText("0");
        tfNumero4.setText("0");
        tfResultado.setText("");

    }
}
