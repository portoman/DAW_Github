package prog06_tarea;

import java.time.LocalDate;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase Vehiculo cuya finalidad es crear objetos vehículo.
    Tiene atributos para la siguiente información: marca, matrícula, número de kilómetros, fecha de matriculación, descripción, precio, nombre del propietario y dni del propietario.
    Sus atributos están encapsulados, tiene dos constructores y un método llamado get_Anios() para calcular el número de años.
    De acuerdo a la tarea 8 se implementa la interfaz Comparable que incluye el método compareTo(Vehiculo v), para comparar las matrículas.
 */
public class Vehiculo implements Comparable<Vehiculo> {

    //Atributos 
    private String marca;
    private String matricula;
    private int numKm;
    private LocalDate fechaMatriculacion;
    private String descripcion;
    private double precio;
    private String nombrePropietario;
    private String dniNiePropietario;

    //Constructores
    public Vehiculo(String marca, String matricula, int numKm, LocalDate fechaMatriculacion, String descripcion, double precio, String nombrePropietario, String dniNiePropietario) {
        this.matricula = matricula;
        this.marca = marca;
        this.numKm = numKm;
        this.fechaMatriculacion = fechaMatriculacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombrePropietario = nombrePropietario;
        this.dniNiePropietario = dniNiePropietario;
    }

    public Vehiculo() {
    }

    //Getter y setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getNumKm() {
        return numKm;
    }

    public void setNumKm(int numKm) {
        this.numKm = numKm;
    }

    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getDniNiePropietario() {
        return dniNiePropietario;
    }

    public void setDniNiePropietario(String dniNiePropietario) {
        this.dniNiePropietario = dniNiePropietario;
    }

    //Método get_Anios(): Retorna un entero con el número de años del vehículo.
    public int get_Anios() {
        return LocalDate.now().getYear() - this.getFechaMatriculacion().getYear();
    }

    /*Método para devolver los requerimientos del enunciado cuando se lista un vehículo: marca, matrícula, precio, kilómetros y descripción por cada vehículo. 
    Modifico el orden de los atributos a mostrar, para que matrícula esté primero, y así se aprecie mejor como los vehículos están ordenados
     */
    public String toStringLista() {
        return "Vehiculo{" + "matricula= " + matricula + ", marca= " + marca + ", precio= " + precio + ", km= " + numKm + " y descripción= " + descripcion + '}';
    }

    //Método para devolver los requerimientos del enunciado cuando se busca un vehículo: marca, matrícula y precio
    public String toStringBuscar() {
        return "Vehiculo{" + "marca= " + marca + ", matricula= " + matricula + " y precio= " + precio + '}';
    }

    /*Método que compara vehículos por matrícula, devolviendo cero si son iguales. 
    Será utilizado por TreeSet para ordenar los vehículos almacenados por matrícula.
     */
    @Override
    public int compareTo(Vehiculo v) {
        return this.matricula.compareTo(v.getMatricula());
    }

}
