/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciopropuestoe_javafx;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Crear archivo JavaFX Main Class
 * 
 * Añadir librería: JavaFX. Esta librería se creará con todo lo que tenga este
 * archivo: C:\Program Files\Java\javafx-sdk-19\lib 
 * 
 * Añadir en propiedades, run:
 * --module-path "C:\Program Files\Java\javafx-sdk-19\lib" --add-modules javafx.controls,javafx.fxml 
 * 
 * En compiling: Desactivar "Compile on Save"
 *
 * Por si acaso no está: En Opciones de Netbeans, Java, JavaFX, hay que poner la ruta de donde está el SceneBuilder: C:/Users/portb/AppData\Local\SceneBuilder
 * 
 * Después creamos fichero FXML y generamos también el controlador.
 * 
 * Ya podemos hacer la interfaz: En controls en la izquierda está todo.
 *  A medida que se van incluyendo componentes, se le va dando nombre y en code en la derecha: id y acciones.  Acordase de guardar
 *  Con el boton derecho en el archivo fxml, se le da a MakeController para ir exportando el código al controller.
 */
public class NewFXMain extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ejercicioPropuestoE.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("ejercicioPropuestoE");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
