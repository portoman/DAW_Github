/*EJERCICIO 2*/
/*Añadir a la tabla STOCK*/
    /*Una columna de tipo fecha llamada FechaUltimaEntrada que por defecto tome el valor de la fecha actual*/
    ALTER TABLE stock ADD (FechaUltimaEntrada DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP);

    /*Una columna llamada Beneficio que contendrá el tipo de porcentaje de beneficio que esa tienda aplica en ese producto. 
    Se debe controlar que el valor que almacene sea 1,2, 3, 4 o 5.*/
    ALTER TABLE stock ADD (Beneficio INT CHECK(Beneficio BETWEEN 1 AND 5));
    
/*En la tabla PRODUCTO*/

/*Eliminar de la tabla producto la columna Descripción.*/

ALTER TABLE producto DROP Descripcion;

/*Añadir una columna llamada perecedero que únicamente acepte los valores: S o N.*/

 ALTER TABLE producto ADD (perecedero CHAR CHECK(perecedero='S' OR perecedero='N'));

/*Modificar el tamaño de la columna Denoproducto a 50.*/

ALTER TABLE producto MODIFY Denoproducto VARCHAR(50);

/*En la tabla FAMILIA*/

/*Añadir una columna llamada IVA, que represente el porcentaje de IVA y únicamente pueda contener los valores 21,10,ó 4.*/

ALTER TABLE familia ADD (IVA INT CHECK(IVA=21 OR IVA=10 OR IVA=4));

/*En la tabla tienda

/*La empresa desea restringir el número de tiendas con las que trabaja, de forma que no pueda haber más de una tienda en una misma zona 
(la zona se identifica por el código postal). Definir mediante DDL las restricciones necesarias para que se cumpla en el campo correspondiente..*/

ALTER TABLE tienda ADD  CONSTRAINT cp_uk UNIQUE (CodigoPostal);

/*B) Renombra la tabla STOCK por PRODXTIENDAS.*/

ALTER TABLE stock RENAME TO PRODXTIENDAS;

/*C) Elimina la tabla FAMILIA y su contenido si lo tuviera.*/

ALTER TABLE producto DROP CONSTRAINT fk_prod_fam;
DROP TABLE familia;

/*D) Crea un usuario llamado C##INVITADO siguiendo los pasos de la unidad 1 y dale todos los privilegios sobre la tabla PRODUCTO.*/

CREATE USER 'C##INVITADO';
GRANT ALL ON tienda.producto TO 'C##INVITADO';

/*E) Retira los permisos de modificar la estructura de la tabla y borrar contenido de la tabla PRODUCTO al usuario anterior.*/

REVOKE UPDATE,DELETE ON tienda.producto FROM 'C##INVITADO';