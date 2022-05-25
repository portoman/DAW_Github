package com.prog11.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase que se encarga de realizar la conexión contra la base de datos y el cierre de la misma. 
Para ello implementa los métodos openConnection() y closeConnection(). También crea el objeto Connection iniciándolo a null.
 */
public class ConnectionDB {

    //En lugar de crear el objeto en la clase principal, lo creo en esta clase ConnectionBD iniciándolo a null
    public static Connection con = null;

    //Método para abrir la conexión con la base de datos mysql
    public static Connection openConnection() {
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/concesionario?user=root&password=admin"
            );
            System.out.println("La conexión no tuvo ningún problema");
        } catch (SQLException ex) {
            System.out.println("No fue posible la conexión");
            System.out.println(ex.getMessage());
        }
        return con;
    }

    ;
   //Método para cerrar la conexión con la base de datos mysql
    public static Connection closeConnection() throws SQLException {
        con.close();
        return con;
    }
;
}
