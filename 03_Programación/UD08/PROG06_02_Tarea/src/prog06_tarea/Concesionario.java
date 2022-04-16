package prog06_tarea;

import java.time.LocalDate;
import java.util.TreeSet;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase Concesionario en la que se gestiona un TreeSet donde se almacenan vehículos.
    Para ello contiene diferentes métodos que sirven para añadir, buscar, listar, actualizar km y eliminarlos
 */
public class Concesionario {

    /*Como el objetivo es mantener los vehículos ordenados por matrícula escojo el conjunto TreeSet
    que ordenará los vehiculos de esta manera a través del método implementado compareTo(Vehiculo v) en la clase Vehiculo,
    que utiliza el TreeSet para ordenar objetos.
     */
    TreeSet<Vehiculo> vehiculos = new TreeSet<Vehiculo>();

    //Constructor
    public Concesionario() {
    }

    //Método que recibe una matrícula de parámetro, busca el vehículo en el concesionario y devuelve una cadena con los datos del vehículo o null si no existe
    public String buscaVehiculo(String matricula) {
        String devolucion = null;
        for (Vehiculo v : this.vehiculos) {
            if (v.getMatricula().equals(matricula)) {
                devolucion = v.toStringBuscar();
                break;
            }
        }
        return devolucion;
    }

    //Método que recibe todos los datos de un vehículo y trata de insertarlo en el concesionario
    public int insertarVehiculo(String marca, String matricula, int numKilometros, LocalDate fechaMat,
            String descripcion, double precio, String nombrePropietario, String dniPropietario) {

        int devolucion = 0;

        //Como se pide evitar el uso de la clase Vehiculo en la clase principal, instancio los vehículos directamente en este método
        Vehiculo veh = new Vehiculo(marca, matricula, numKilometros, fechaMat, descripcion, precio, nombrePropietario, dniPropietario);

        //Bucle for que recorre el concesionario hasta el valor de posición
        for (Vehiculo v : this.vehiculos) {
            //Si hay algun vehículo a insertar que coincida con la matricula de uno ya insertado, decuelve -2 y cierra el bucle
            if (v.getMatricula().equals(matricula)) {
                devolucion = -2;
                break;
            }

        }
        if (devolucion != -2) {
            this.vehiculos.add(veh);
            //Collections.sort(this.vehiculos);
        }
        return devolucion;
    }

    //Método que lista por pantalla los datos de todos los vehículos del concesionario
    public void listaVehiculos() {
        boolean listaVacia = true;
        for (Vehiculo v : this.vehiculos) {
            System.out.println(v.toStringLista());
            listaVacia = false;
        }
        if (listaVacia) {
            System.out.println("Actualmente, el concesionario está vacio");
        }
    }

    /*Método que recibe por parámetro una matrícula y un número de kilómetros y se actualizan. 
    Devuelve true si se hizo con éxito y false en caso contrario.*/
    public boolean actualizaKms(String matricula, int numKm) {
        boolean devolucion = false;
        for (Vehiculo v : this.vehiculos) {
            if (v.getMatricula().equals(matricula)) {
                v.setNumKm(numKm);
                devolucion = true;
                break;
            }
        }
        return devolucion;
    }

    //Método para eliminar vehículo que, solicitando una matrícula, lo elimina si existe.
    public String eliminarVehiculo(String matricula) {
        String devolucion = "Vehiculo a eliminar no encontrado";
        for (Vehiculo v : this.vehiculos) {
            if (v.getMatricula().equals(matricula)) {
                vehiculos.remove(v);
                devolucion = "Vehiculo eliminado";
                break;
            }
        }
        return devolucion;
    }

}
