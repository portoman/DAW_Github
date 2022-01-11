package daw.PROG05_Ejerc1;

import java.time.LocalDate;

public class Vehiculo {

    //Atributos
    private String marca;
    private String matricula;
    private int numKm;
    private LocalDate fechaMatriculacion;
    private String descripcion;
    private double precio;
    private String nombrePropietario;
    private int dniPropietario;

    //Constructores
    public Vehiculo(String marca, String matricula, int numKm, LocalDate fechaMatriculacion, String descripcion, double precio, String nombrePropietario, int dniPropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.numKm = numKm;
        this.fechaMatriculacion = fechaMatriculacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombrePropietario = nombrePropietario;
        this.dniPropietario = dniPropietario;
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
        return matricula;
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

    public int getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(int dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

    //Método get_Anios(): Retorna un entero con el número de años del vehículo.
    public int get_Anios() {
        return LocalDate.now().getYear() - this.getFechaMatriculacion().getYear();
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", matricula=" + matricula + ", numKm=" + numKm + ", fechaMatriculacion=" + fechaMatriculacion + ", descripcion=" + descripcion + ", precio=" + precio + ", nombrePropietario=" + nombrePropietario + ", dniPropietario=" + dniPropietario + '}';
    }

    
}
