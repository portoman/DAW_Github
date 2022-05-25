package com.prog11.princ;

import static com.prog11.bbdd.ConnectionDB.openConnection;
import static com.prog11.bbdd.PropietariosDAO.*;
import static com.prog11.bbdd.VehiculosDAO.*;
import java.sql.Connection;
import java.sql.SQLException;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase principal para probar cada uno de los métodos implementados en las clases de acceso a la BBDD,
siguiendo el orden definido en el enunciado y finalizando con consultas añadidas para dar funcionalidad adicional.
 */
public class PROG11_tarea {

    public static void main(String[] args) {
        try {
            /*El método openConnection abre la conexión y devuelve una instancia de Connection en la clase ConnectionDB
            cuyo valor asignamos a "con"*/
            Connection con = openConnection();

            //Insertar varios propietarios
            System.out.println(insertarPropietario(con, 1, "Pedro", "89784187L"));
            System.out.println(insertarPropietario(con, 2, "Emilio", "48484877P"));
            System.out.println(insertarPropietario(con, 3, "Lourdes", "78451577M"));
            System.out.println(insertarPropietario(con, 4, "Ramón", "47878596A"));
            System.out.println(insertarPropietario(con, 5, "Mariola", "43558798T"));

            //Insertar varios vehículos
            System.out.println(insertarVehiculo(con, "7783POI", "Opel", 4444, 15559, "20%", 3));
            System.out.println(insertarVehiculo(con, "1854JHW", "Fiat", 87851, 4999, "30%", 1));
            System.out.println(insertarVehiculo(con, "8797ERE", "Opel", 8975, 13559, "15%", 4));
            System.out.println(insertarVehiculo(con, "8478PLO", "Nissan", 35488, 12000, "15%", 2));
            System.out.println(insertarVehiculo(con, "7898POL", "Honda", 50045, 8149, "15%", 3));

            //Listar todos los vehículos
            System.out.println("Listar todos los vehículos:");
            System.out.println(recuperarTodosVehiculos(con));

            //Actualizar propietario de un vehículo
            System.out.println(actualizarPropietarioVehículo(con, "1854JHW", 4));

            //Listar todos los vehículos
            System.out.println("Listar los vehículos después de actualizar propietario");
            System.out.println(recuperarTodosVehiculos(con));

            //Eliminar un vehículo que exista
            System.out.println(borrarVehiculo(con, "8478PLO"));

            //Eliminar un vehículo que no exista
            System.out.println(borrarVehiculo(con, "7789POI"));

            //Listar todos los vehículos
            System.out.println("Listar los vehículos después de borrar el 8478PLO:");
            System.out.println(recuperarTodosVehiculos(con));

            //Listar los vehículos de una marca
            System.out.println("Listar los vehículos de la marca Opel:");
            System.out.println(recuperarVehiculosMarca(con, "Opel"));

            //Listar todos los vehículos de un propietario
            System.out.println("Listar todos los vehículos del propietario con DNI: 47878596A");
            System.out.println(recuperarVehiculosPropietario(con, "47878596A"));

            //Eliminar un propietario con vehículos
            System.out.println(borrarPropietario(con, "47878596A"));

            //Eliminar un propietario sin vehículos
            System.out.println(borrarPropietario(con, "43558798T"));

            //Listar todos los propietarios
            System.out.println("Listar todos los propietarios");
            System.out.println(listarPropietarios(con));

            //Listar propietarios sin vehículos
            System.out.println("Listar propietarios sin vehículos");
            System.out.println(listarPropietariosSinVehiculo(con));

            //Listar vehículos con precio igual o inferior al que le pasemos
            System.out.println("Listar vehículos con precio igual o inferior a 10000");
            System.out.println(recuperarVehiculosPrecioInferior(con, 10000));

        } catch (SQLException ex) {
            System.out.println("No fue posible la conexión");
            System.out.println(ex.getMessage());
        }

    }
}
