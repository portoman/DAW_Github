/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package proposto03i;

import java.sql.Connection;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class NewFXMain extends Application {
    //Establecemos la conexión en la clase principal y la declaramos static para llamarla desde cualquier lado
    public static Connection con = Datos.getConnection();
    
    @Override
    public void start(Stage primaryStage)  {
        try {
            Parent root= FXMLLoader.load(getClass().getResource("./FXML.fxml"));
            Scene scene = new Scene(root, 465, 400);
            primaryStage.setTitle("Persoas");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println("Problema: " + ex.getMessage());
            System.exit(0);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
