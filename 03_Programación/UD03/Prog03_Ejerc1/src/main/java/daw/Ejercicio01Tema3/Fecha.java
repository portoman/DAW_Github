package daw.Ejercicio01Tema3;

public class Fecha {

    public enum enumMes {
        Enero, Febrero, Marzo, Abril, Mayo, Junio, Julio, Agosto, Septiembre, Octubre, Noviembre, Diciembre
    };

    int dia;
    enumMes mes;
    int anio;

    Fecha(enumMes mes) {
        this.dia = 0;
        this.mes = mes;
        this.anio = 0;
    }

    Fecha(int dia, enumMes mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    //Getters y Setters
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public enumMes getMes() {
        return mes;
    }

    public void setMes(enumMes mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    //Método que devuelve si es verano
    public boolean isSummer() {
        boolean junio = (this.mes == mes.Junio ? true : false);
        boolean julio = (this.mes == mes.Julio ? true : false);
        boolean agosto = (this.mes == mes.Agosto ? true : false);

        boolean verano=junio||julio||agosto;
        
        return verano;
    }

    //Método toString
    public String toString (){
        String cadena=dia+" de "+mes+" de "+anio;
        return cadena;
    }
}
