package daw.poo_3_discoduro;

public class Aula {

    private int id;
    private final int MAX_ALUMNOS = 20;
    private String materia;
    private Profesor profesor;
    private Estudiante[] estudiantes;

    public Aula() {

        this.profesor = new Profesor();

        this.estudiantes = new Estudiante[MAX_ALUMNOS];

        creaAlumnos();

        this.materia = Constantes.MATERIAS[Metodos.generaNumeroRandom(0, 2)];
    }

    private void creaAlumnos() {

        for (int i = 0; i < MAX_ALUMNOS; i++) {
            estudiantes[i] = new Estudiante();
        }
    }

    private boolean asistenciaAlumnos() {
        int contador = 0;
        boolean asistencia = false;
        for (int i = 0; i < estudiantes.length; i++) {

            if (estudiantes[i].presente) {
                contador++;
            }
        }
        return (contador > (int) MAX_ALUMNOS / 2);
    }

    ;
    
    public boolean darClase() {
        if (!profesor.presencia()) {
            System.out.println("El profesor no está, no se puede dar clase");
            return false;
        } else if (!profesor.getMateria().equals(this.materia)) {
            System.out.println("La materia del profesor y del aula no es la misma, no se puede dar clase");
            return false;
        } else if (!asistenciaAlumnos()) {
            System.out.println("La asistencia no es suficiente, no se puede dar clase");
            return false;
        }
        System.out.println("Se puede dar clase!!!!");
        return true;
    }

    public void notas() {

        int chicosAprobados = 0;
        int chicasAprobadas = 0;

        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i].getCalificacion() >= 5) {
                if (estudiantes[i].getSexo() == 'V') {
                    chicosAprobados++;
                } else {
                    chicasAprobadas++;
                }
            }
            System.out.println(estudiantes[i].toString());
        }

        System.out.println("Hay " + chicosAprobados + " chicos aprobados y " + chicasAprobadas + " chicas aprobadas");
    }
;
}
