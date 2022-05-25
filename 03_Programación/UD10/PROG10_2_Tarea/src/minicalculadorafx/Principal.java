package minicalculadorafx;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase principal donde se inicializa el JavaFX y se vincula la hoja de estilos: "style.css"
 */
public class Principal extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("MiniCalcVentana.fxml"));
        Scene scene = new Scene(root);
        //Vinculación de la hoja de estilos css
        String css = this.getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(css);
        primaryStage.setTitle("PROG10_Tarea");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
