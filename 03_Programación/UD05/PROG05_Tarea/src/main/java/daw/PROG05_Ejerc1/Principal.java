package daw.PROG05_Ejerc1;

import static PROG05_Ejerc1_util.MetodosEstaticos.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws Exception {

        Vehiculo veh = null;

        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");

        boolean semaforo = true;

        //Bucle do-while: Si no se teclea un número, se repite la petición, activando el boolean semaforo
        while (semaforo) {

            System.out.println("Seleccione una opcion:\n1. Nuevo Vehiculo.\n"
                    + "2. Ver Matrícula.\n"
                    + "3. Ver Número de Kilómetros.\n"
                    + "4. Actualizar Kilómetros.\n"
                    + "5. Ver años de antigüedad.\n"
                    + "6. Mostrar propietario.\n"
                    + "7. Mostrar descripción.\n"
                    + "8. Mostrar Precio.\n"
                    + "9. Salir.");
            try {
                int opcion = teclado.nextInt();

                if (!numeroOpcion(opcion)) {
                    throw new Exception("La opción tiene que estar entre el 1 y el 9");
                }
                switch (opcion) {
                    case 1:

                        System.out.println("Introduce la marca");
                        String marca = teclado.next();

                        System.out.println("Introduce la matricula");
                        String matricula = teclado.next();

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

                        System.out.println("Introduce DNI del propietario");
                        int dniPropietario = teclado.nextInt();

                        //Comprobación que el DNI del propietario es válido
                        if (!dniValido(dniPropietario)) {
                            throw new Exception("DNI inválido: " + String.valueOf(dniPropietario));
                        }

                        veh = new Vehiculo(marca, matricula, numKilometros, fechaMat, descripcion, precio, nombrePropietario, dniPropietario);

                        System.out.println(veh.toString());
                        break;

                    case 2:
                        if (veh == null) {
                            System.out.println("Debes de crear un vehículo");
                        } else {
                            System.out.println("La matrícula es: " + veh.getMatricula());
                        }
                        break;

                    case 3:
                        if (veh == null) {
                            System.out.println("Debes de crear un vehículo");
                        } else {
                            System.out.println("El número de km es: " + veh.getNumKm());
                        }
                        break;

                    case 4:
                        if (veh == null) {
                            System.out.println("Debes de crear un vehículo");
                        } else {
                            System.out.println("Introduce km: ");
                            int kmActualizado = teclado.nextInt();
                            veh.setNumKm(kmActualizado);
                        }
                        break;
                    case 5:
                        if (veh == null) {
                            System.out.println("Debes de crear un vehículo");
                        } else {
                            System.out.println("Años de antigüedad: " + veh.get_Anios());
                        }
                        break;
                    case 6:
                        if (veh == null) {
                            System.out.println("Debes de crear un vehículo");
                        } else {
                            System.out.println("Nombre del propietario: " + veh.getNombrePropietario());
                        }
                        break;
                    case 7:
                        if (veh == null) {
                            System.out.println("Debes de crear un vehículo");
                        } else {
                            System.out.println("Descripcion: " + veh.getDescripcion());
                        }
                        break;

                    case 8:
                        if (veh == null) {
                            System.out.println("Debes de crear un vehículo");
                        } else {
                            System.out.println("Precio: " + veh.getPrecio());
                        }
                        break;
                    case 9:
                        semaforo = false;
                        break;

                }
            } catch (InputMismatchException e) {
                System.out.println("Eso no es un número");
                teclado.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                teclado.nextLine();
            }

        };

    }

}
