package prog06_tarea;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import static prog06_tarea_util.Validar.*;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase principal donde, desde su método main, permite gestionar un concesionario, con el siguiente menu:

    1.Nuevo Vehículo: Solicita al usuario por teclado los datos de un nuevo vehículo y, si son correctos, se almacenan en el concesionario.
                    Dentro de esta opción se valida que ciertos datos cumplan determinados formatos, usando expresiones regulares entre otras.
    2.Listar Vehículos: Muestra por pantalla un listado de los vehículos del concesionario: marca, matrícula, precio, kilómetros y descripción por cada vehículo.
    3.Buscar Vehículo: Solicita al usuario una matrícula por teclado y se busca en el concesionario un vehículo cuya matrícula coincida con la introducida.
    4.Modificar kms Vehículo: Solicita al usuario por teclado una matrícula y un número de kilómetros  para actualizarlos
    5.Eliminar vehículo: Solicita al usuario una matrícula y si existe, se elimina el vehículo correspondiente.
    6.Salir: Se sale del menu.
 */
public class Principal {

    public static void main(String[] args) {

        //Instanciación de concesionario
        Concesionario concesionario = new Concesionario();

        Scanner teclado = new Scanner(System.in);

        teclado.useDelimiter("\n");//Código para que Scanner admita espacios

        int opcion = 0;//Inicialización del atributo opcion

        //Bucle while: Si opcion es distinto de 6 se repetirá la petición
        while (opcion != 6) {
            System.out.println("""
                           1. Nuevo Vehículo.
                           2. Listar Vehículos.
                           3. Buscar Vehículo.
                           4. Modificar kms Vehículo.
                           5. Eliminar vehículo   
                           6. Salir.""");

            try {
                opcion = teclado.nextInt();
                //Validación de que la opción elegida está entre 1 y 6
                if (!numeroOpcion(opcion)) {
                    throw new Exception("La opción tiene que estar entre el 1 y el 6");
                }
                switch (opcion) {
                    case 1:
                        System.out.println("Introduce la marca");
                        String marca = teclado.next();

                        System.out.println("Introduce la matricula");
                        String matricula = teclado.next();

                        //Comprobación que el formato de la matricula es correcto
                        if (!validacionMatricula(matricula)) {
                            throw new Exception("El formato de la matrícula no es correcto");
                        }
                        System.out.println("Introduce número de kilómetros");
                        int numKilometros = teclado.nextInt();

                        //Comprobación que el número de km es mayor que cero
                        if (!valorPositivo(numKilometros)) {
                            throw new Exception("El número de kilómetros debe ser mayor que cero");
                        }
                        System.out.println("Fecha de matriculación: Introduce día");
                        int diaMat = teclado.nextInt();

                        System.out.println("Fecha de matriculación: Introduce mes");
                        int mesMat = teclado.nextInt();

                        System.out.println("Fecha de matriculación: Introduce año");
                        int anhoMat = teclado.nextInt();

                        LocalDate fechaMat = LocalDate.of(anhoMat, mesMat, diaMat);

                        //Comprobación que la fecha de matriculación es anterior a la actual
                        if (!fechaAnterior(fechaMat)) {
                            throw new Exception("La fecha debe ser anterior a la actual");
                        }

                        System.out.println("Introduce descripción");
                        String descripcion = teclado.next();

                        System.out.println("Introduce precio");
                        double precio = teclado.nextDouble();

                        System.out.println("Introduce nombre del propietario");
                        String nombrePropietario = teclado.next();

                        //Comprobación que el nombre es correcto: 1 nombre y 2 apellidos
                        if (!validacionNombre(nombrePropietario)) {
                            throw new Exception("El nombre debe tener nombre y 2 apellidos y no exceder de 40 caracteres");
                        }
                        System.out.println("Introduce DNI o NIE del propietario");
                        String dniNiePropietario = teclado.next();

                        //Comprobación DNI/NIE del propietario es válido
                        if (validacionDNI(dniNiePropietario)) {
                            System.out.println("DNI en formato correcto");
                        }else if(validacionNIE(dniNiePropietario)){
                            System.out.println("NIE en formato correcto");
                        }else{
                            throw new Exception("El formato del DNI/ NIE es incorrecto");
                        }
                        //Llamada al método insertarVehiculo donde le paso todos los atributos pedidos
                        int x = concesionario.insertarVehiculo(marca, matricula, numKilometros, fechaMat, descripcion, precio, nombrePropietario, dniNiePropietario);

                        //Estructura donde, dependiendo de la devolución del método, sale un mensaje u otro
                        if (x == 0) {
                            System.out.println("Vehículo insertado con éxito");
                        } else if (x == -1) {
                            System.out.println("El concesionario está lleno");
                        } else if (x == -2) {
                            System.out.println("Ya existe un vehículo con esta matrícula");
                        }
                        ;
                        break;
                    case 2://Listar Vehículos
                        concesionario.listaVehiculos();
                        break;
                    case 3://Buscar Vehículo
                        System.out.println("Introduce matrícula a buscar");
                        String matriculaABuscar = teclado.next();
                        String resultadoBuscar = concesionario.buscaVehiculo(matriculaABuscar);
                        if (resultadoBuscar == null) {
                            System.out.println("No existe vehículo con la matrícula introducida");
                        } else {
                            System.out.println(resultadoBuscar);
                        }
                        break;
                    case 4://Modificar kms Vehículo
                        System.out.println("Introduce matrícula de vehículo a modificar:");
                        String matriculaActualizarKm = teclado.next();
                        System.out.println("Introduce km a actualizar: ");
                        int kmAActualizar = teclado.nextInt();

                        if (!valorPositivo(kmAActualizar)) {
                            throw new Exception("El número de kilómetros debe ser mayor que cero");
                        }
                        boolean case4 = concesionario.actualizaKms(matriculaActualizarKm, kmAActualizar);

                        //Estructura donde, dependiendo del boolean devuelto, sale un mensaje u otro
                        if (case4) {
                            System.out.println("Km actualizados con éxito");
                        } else {
                            System.out.println("El vehículo no existe, por lo que no se ha podido actualizar los kms");
                        }
                        break;

                    case 5://Eliminar vehículo
                        System.out.println("Introduce matrícula de vehículo a eliminar:");
                        String matriculaAEliminar = teclado.next();
                        System.out.println(concesionario.eliminarVehiculo(matriculaAEliminar));

                    case 6://Salir
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Eso no es un número");
                teclado.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                teclado.nextLine();
            }
        }
    }
}
