package daw.poo_3_discoduro;

public class Persona {

    int edad;
    String nombre;
    char sexo;

    private final String[] NOMBRES_CHICOS = {"Alfonso", "Juan", "Pablo", "Brais", "Manuel", "Carlos"};
    private final String[] NOMBRES_CHICAS = {"Marta", "Natalia", "Aida", "Sara", "Helena", "Luisa"};
    private final int NUM_CHICO=0;
    private final int NUM_CHICA=1;
    
    public Persona() {
        int determinar_sexo = Metodos.generaNumeroRandom(0, 1);

        if (determinar_sexo == NUM_CHICO) {
            this.sexo = 'V';
            this.nombre = NOMBRES_CHICOS[Metodos.generaNumeroRandom(0, 5)];
        } else {
            this.sexo = 'M';
            this.nombre = NOMBRES_CHICAS[Metodos.generaNumeroRandom(0, 5)];
        }

    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Persona{" + "edad=" + edad + ", nombre=" + nombre + ", sexo=" + sexo + '}';
    }

    
    
}
