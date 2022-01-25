
/*Realiza los ejercicios en la Hoja de trabajo de SQLDeveloper o desde SQLPlus 
conectando con tu usuario, creado en la primera tarea, y comprueba que las 
sentencias son correctas antes de incluirlas en el script. 
Una vez hayas hecho todas para probar el script, desde SQLPlus, 
ejecuta start nombrescript.sql o @nombrescript.sql  eliminando previamente todas 
las tablas creadas para poder crearlas de nuevo.
*/
DROP DATABASE IF EXISTS tienda;
CREATE DATABASE tienda CHARSET utf8mb4;
USE tienda;

CREATE TABLE familia(
    Codfamilia DECIMAL(3) PRIMARY KEY,
     Denofamilia VARCHAR(50) UNIQUE NOT NULL
    ) ENGINE=InnoDB;

CREATE TABLE producto(
    Codproducto DECIMAL(5) PRIMARY KEY,
     Denoproducto VARCHAR(20) NOT NULL,
     Descripcion VARCHAR(100),
     PrecioBase DECIMAL(8,2) NOT NULL CHECK (PrecioBase > 0), 
     PorcReposicion DECIMAL(3) CHECK (PorcReposicion  > 0), 
     UnidadesMinimas DECIMAL(4) NOT NULL CHECK (UnidadesMinimas > 0), 
     Codfamilia DECIMAL(3) NOT NULL,
     CONSTRAINT fk_prod_fam FOREIGN KEY (Codfamilia) REFERENCES familia(Codfamilia)
     ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE tienda(
    Codtienda DECIMAL(3) PRIMARY KEY,
    Denotienda VARCHAR(20) NOT NULL,
    telefono VARCHAR(11),
    CodigoPostal VARCHAR(5) NOT NULL,
    Provincia VARCHAR(5) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE stock(
    Codtienda DECIMAL(3),
    Codproducto DECIMAL(5),
    Unidades DECIMAL(6) NOT NULL CHECK(Unidades>=0),
    PRIMARY KEY(Codtienda,Codproducto),
    FOREIGN KEY (Codtienda) REFERENCES tienda(Codtienda)
    ON DELETE CASCADE,
     FOREIGN KEY (Codproducto) REFERENCES producto(Codproducto)
     ON DELETE CASCADE
) ENGINE=InnoDB;