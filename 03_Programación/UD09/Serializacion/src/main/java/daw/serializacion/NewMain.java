package daw.serializacion;

public class NewMain {

    public static void main(String[] args) {
        Contacto contacto = new Contacto("Alfonso", "Porto");
        Serializadora serializadora = new Serializadora();
        serializadora.escribirObjeto(contacto);

        Contacto contacto2 = (Contacto) serializadora.leerObjeto("objeto.dat");
        System.out.println(contacto2.getNombre());

        Banco b = new Banco();

        Contacto contacto1 = new Contacto("Alfonso", "Porto");
        Contacto contacto3 = new Contacto("Alfonso3", "Porto");
        Contacto contacto4 = new Contacto("Alfonso4", "Porto");
        Contacto contacto5 = new Contacto("Alfonso5", "Porto");

        b.cuentasTotales.add(contacto1);
        b.cuentasTotales.add(contacto3);
        b.cuentasTotales.add(contacto4);
        b.cuentasTotales.add(contacto5);
        
        
        serializadora.escribirObjeto(b);
        
        Banco banco = (Banco) serializadora.leerObjeto("objeto.dat");
        
       for (Contacto c : banco.cuentasTotales) {
            System.out.println(c.getNombre());
        }
        
    }

}
