package prog06_tarea;

import java.time.LocalDate;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase Concesionario en la que se gestiona un array donde se almacenan hasta 50 Vehiculos.
    Para ello contiene diferentes métodos que sirven para añadir, buscar, listar, actualizar km y eliminarlos
 */
public class Concesionario {

    //Atributos
    Vehiculo[] vehiculos = new Vehiculo[50];//Array vehículo con un máximo de 50 posiciones
    int posicion = 0;//Atributo para indicar la posición en el array

    //Constructor
    public Concesionario() {
    }

    //Método que recibe una matrícula de parámetro, busca el vehículo en el concesionario y devuelve una cadena con los datos del vehículo o null si no existe
    public String buscaVehiculo(String matricula) {
        String devolucion = null;
        for (int i = 0; i < posicion; i++) {
            if (this.vehiculos[i] != null && this.vehiculos[i].getMatricula().equals(matricula)) {
                devolucion = this.vehiculos[i].toStringBuscar();
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
        for (int i = 0; i < posicion; i++) {
            //Si hay algun vehículo a insertar que coincida con la matricula de uno ya insertado, decuelve -2 y cierra el bucle
            if (this.vehiculos[i] != null && this.vehiculos[i].getMatricula().equals(matricula)) {
                devolucion = -2;
                break;
            }
        }
        //Si el concesionario está lleno devuelve -1
        if (posicion == vehiculos.length) {
            devolucion = -1;
        } else if (devolucion != -2) {
            //Si no está lleno y no exite un vehículo con su matrícula, inserta el vehículo en la posición que indica el atributo y devuelve 0 
            this.vehiculos[posicion] = veh;
            devolucion = 0;
            posicion++;
        }
        return devolucion;
    }

    //Método que lista por pantalla los datos de todos los vehículos del concesionario
    public void listaVehiculos() {
        boolean listaVacia = true;
        for (int i = 0; i < posicion; i++) {
            System.out.println(vehiculos[i].toStringLista());
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
        for (int i = 0; i < posicion; i++) {
            if (this.vehiculos[i] != null && this.vehiculos[i].getMatricula().equals(matricula)) {
                this.vehiculos[i].setNumKm(numKm);
                devolucion = true;
                break;
            }
        }
        return devolucion;
    }

    //MEJORA: Método para eliminar vehículo que, solicitando una matrícula, lo elimina.
    public String eliminarVehiculo(String matricula) {
        String devolucion = "Vehiculo a eliminar no encontrado";
        for (int i = 0; i < posicion; i++) {
            if (this.vehiculos[i] != null && this.vehiculos[i].getMatricula().equals(matricula)) {
                this.vehiculos[i] = null;
                devolucion = "Vehiculo eliminado";
                break;
            }
        }
        return devolucion;
    }

}
