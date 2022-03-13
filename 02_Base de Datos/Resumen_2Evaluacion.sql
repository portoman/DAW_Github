
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
    FOREIGN KEY (Codtienda) REFERENCES tienda(Codtienda) ON DELETE CASCADE,
	FOREIGN KEY (Codproducto) REFERENCES producto(Codproducto) ON DELETE CASCADE
) ENGINE=InnoDB;


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


#UD4
use tarea04;

#1. Obtener los nombres y salarios de los empleados con más de 1000 euros de salario por orden alfabético.

SELECT nombre, salario FROM empleado  WHERE salario>1000 ORDER BY nombre;

#2. Obtener el nombre de los empleados cuya comisión es superior al 20% de su salario.

SELECT nombre FROM empleado WHERE comision>(salario*0.2);

#3. Obtener el código de empleado, código de departamento, nombre y sueldo total en pesetas de aquellos empleados cuyo sueldo total 
# (salario más comisión) supera los 1800 euros. Presentarlos ordenados por código de departamento y dentro de éstos por orden alfabético.

SELECT codemple "Código de empleado", coddpto "Código de departamento", nombre, (salario+ifnull( comision, 0 ))*166.386 "Salario total en pesetas" 
    from empleado where (salario+ifnull( comision, 0 )) > 1800 ORDER BY 2,3;

#4. Obtener por orden alfabético los nombres de empleados cuyo salario igualen o superen en más de un 5% al salario de la empleada ‘MARIA JAZMIN’.

SELECT nombre FROM empleado WHERE salario >=(SELECT salario*1.05 FROM empleado WHERE nombre='Maria' AND ape1='Jazmin') ORDER BY 1;

#5. Obtener una listado ordenado por años en la empresa con los nombres, y apellidos de los empleados y los años de antigüedad en la empresa

SELECT nombre, CONCAT(ape1,' ',ape2) 'Apellidos',  CEIL(DATEDIFF(CURRENT_DATE(),fechaingreso)/365) 'Años de antiguedad' from empleado ORDER BY 3;

#Comentario: Redondeo los años por abajo, con CEIL.

#6. Obtener el nombre de los empleados que trabajan en un departamento con presupuesto superior a 50.000 euros. Hay que usar predicado cuantificado

SELECT nombre FROM empleado WHERE coddpto =SOME(SELECT coddpto FROM dpto WHERE presupuesto>50000);

#7. Obtener los nombres y apellidos de empleados que más cobran en la empresa. Considerar el salario más la comisión.

SELECT nombre, CONCAT(ape1, ' ',ape2) 'Apellidos', (salario+ifnull( comision, 0 )) 'Salario total' FROM empleado 
    WHERE (salario+ifnull( comision, 0 )) >= ALL(SELECT (salario+ifnull( comision, 0 )) FROM empleado);
    

#8. Obtener en orden alfabético los nombres de empleado cuyo salario es inferior al mínimo de los empleados del departamento 1.

SELECT nombre FROM empleado WHERE salario <(SELECT MIN(salario) FROM empleado WHERE coddpto=1) ORDER BY nombre; 

#9. Obtener los nombres de empleados que trabajan en el departamento del cuál es jefe el empleado con código 1.

SELECT nombre FROM empleado WHERE coddpto IN (SELECT coddpto FROM dpto WHERE codemplejefe=1);

SELECT e.nombre FROM empleado e JOIN dpto d ON e.coddpto=d.coddpto WHERE codemplejefe=1;

#10. Obtener los nombres de los empleados cuyo primer apellido empiece por las letras p, q, r, s.

SELECT nombre, ape1 FROM empleado WHERE ape1 LIKE 'p%' OR ape1 LIKE 'q%' OR ape1 LIKE 'r%' OR ape1 LIKE 's%';

#11.Obtener los empleados cuyo nombre de pila contenga el nombre JUAN.

SELECT nombre FROM empleado WHERE nombre LIKE'%JUAN%';

#12. Obtener los nombres de los empleados que viven en ciudades en las que hay algún centro de trabajo

SELECT e.nombre FROM empleado e  JOIN centro c ON e.localidad=c.localidad;


#13. Obtener el nombre del jefe de departamento que tiene mayor salario de entre los jefes de departamento.

#Comentario: realizo la consulta interpretando que el salario es= salario+comision

SELECT e.nombre FROM empleado e JOIN dpto d ON e.codemple=d.codemplejefe
	WHERE e.salario+ifnull( e.comision, 0 )>=ALL(SELECT e.salario+ifnull( e.comision, 0 ) 'Salario total' 
		FROM empleado e JOIN dpto d ON e.codemple=d.codemplejefe);


#14. Obtener en orden alfabético los salarios y nombres de los empleados cuyo salario sea superior al 60% del máximo salario de la empresa.

#Comentario: realizo también la consulta interpretando que el salario es= salario+comision

 SELECT nombre, (salario+ifnull( comision, 0 )) 'Salario total' FROM empleado 
	WHERE (salario+ifnull( comision, 0 ))>= 0.6*(SELECT (salario+ifnull( comision, 0 )) 'Salario total' 
			FROM empleado WHERE (salario+ifnull( comision, 0 )) >= ALL(SELECT (salario+ifnull( comision, 0 )) FROM empleado)) ORDER BY 1;

#15.Obtener en cuántas ciudades distintas viven los empleados

SELECT COUNT(DISTINCT (localidad)) FROM empleado; 

#16.El nombre y apellidos del empleado que más salario cobra

SELECT nombre, CONCAT(ape1, ' ',ape2) 'Apellidos', salario FROM empleado
	WHERE salario >=ALL(SELECT salario FROM empleado);

#17.Obtener las localidades y número de empleados de aquellas en las que viven más de 3 empleados

SELECT localidad,COUNT(*) FROM empleado GROUP BY localidad HAVING COUNT(*)>3;

#18.Obtener para cada departamento cuántos empleados trabajan, la suma de sus salarios y la suma de sus comisiones 
#para aquellos departamento en los que hay algún empleado cuyo salario es superior a 1700 euros.

SELECT e.coddpto, COUNT(e.coddpto)'Número de empleados', SUM(e.salario) 'Suma salario', SUM(ifnull( e.comision, 0 )) 'Suma comisiones' 
	FROM empleado e JOIN dpto d ON e.coddpto=d.coddpto 
		GROUP BY e.coddpto HAVING e.coddpto 
			IN(SELECT e.coddpto FROM empleado e WHERE e.salario >1700);

#19.Obtener el departamento que más empleados tiene

SELECT e.coddpto, d.denominacion, COUNT(e.coddpto) 'Número de empleados'
	FROM empleado e JOIN dpto d ON e.coddpto=d.coddpto
		GROUP BY e.coddpto HAVING COUNT(e.coddpto)>=ALL(SELECT COUNT(e.coddpto)
					FROM empleado e GROUP BY e.coddpto );

#20. Obtener los nombres de todos los centros y los departamentos que se ubican en cada uno, así como aquellos centros que no tienen departamentos. 

SELECT  c.direccion, c.localidad, d.denominacion FROM centro c LEFT JOIN dpto d ON c.codcentro=d.codcentro;

#21. Obtener el nombre del departamento de más alto nivel, es decir, aquel que no depende de ningún otro.

SELECT denominacion FROM dpto WHERE coddptodepende IS NULL;

#22.Obtener todos los departamentos existentes en la empresa y los empleados (si los tiene) que pertenecen a él.

SELECT d.coddpto,d.denominacion, e.nombre, CONCAT(e.ape1, ' ',e.ape2) 'Apellidos'
	FROM dpto d LEFT JOIN empleado e ON d.coddpto=e.coddpto;
        
#Comentario: Con el LEFT JOIN muestra todos los departamentos, también los que no tienen empleados

#23.Obtener un listado en el que aparezcan todos los departamentos existentes y el departamento del cual depende,si depende de alguno.
#### RECURSIVA ####
SELECT * FROM dpto;

SELECT d.coddpto,d.denominacion, de.coddpto 'Código del departamento que depende', de.denominacion 'Departamento del que depende'  
	FROM dpto d LEFT JOIN dpto de ON d.coddptodepende=de.coddpto;

#24.Obtener un listado ordenado alfabéticamente donde aparezcan los nombres de los empleados y a continuación el literal "tiene comisión" si la tiene,y "no tiene comisión" si no la tiene.
   
SELECT nombre,CASE 
WHEN comision>0 THEN 'tiene comisión' 
ElSE 'no tiene comisión' 
END comision FROM empleado ORDER BY 1;

#25. Obtener un listado de las localidades en las que hay centros y no vive ningún empleado ordenado alfabéticamente.

SELECT localidad FROM centro WHERE localidad NOT IN(SELECT localidad FROM empleado) ORDER BY localidad;

#26.Obtener un listado de las localidades en las que hay centros y además vive al menos un empleado ordenado alfabéticamente.

SELECT c.localidad, COUNT(e.localidad) 'Número de empleados' FROM empleado e JOIN centro c 
		ON e.localidad=c.localidad GROUP BY e.localidad HAVING COUNT(e.localidad)>1 ORDER BY c.localidad;

#27. Esta cuestión puntúa por 2. Se desea dar una gratificación por navidades en función de la antigüedad en la empresa siguiendo estas pautas:
	#- Si lleva entre 1 y 5 años, se le dará 100 euros
	#- Si lleva entre 6 y 10 años, se le dará 50 euros por año
	#- Si lleva entre 11 y 20 años, se le dará 70 euros por año
	#- Si lleva más de 21 años, se le dará 100 euros por año

SELECT nombre,CASE 
	WHEN CEIL(DATEDIFF(CURRENT_DATE(),fechaingreso)/365) BETWEEN 1 AND 5 THEN 100 
    WHEN CEIL(DATEDIFF(CURRENT_DATE(),fechaingreso)/365) BETWEEN 6 AND 10 THEN CEIL(DATEDIFF(CURRENT_DATE(),fechaingreso)/365)*50 
    WHEN CEIL(DATEDIFF(CURRENT_DATE(),fechaingreso)/365) BETWEEN 11 AND 20 THEN CEIL(DATEDIFF(CURRENT_DATE(),fechaingreso)/365)*70
    WHEN CEIL(DATEDIFF(CURRENT_DATE(),fechaingreso)/365)>=21 THEN CEIL(DATEDIFF(CURRENT_DATE(),fechaingreso)/365)*100
	END gratificación, CEIL(DATEDIFF(CURRENT_DATE(),fechaingreso)/365) 'Años  en la empresa' FROM empleado;

#28. Obtener un listado de los empleados,ordenado alfabéticamente,indicando cuánto le corresponde de gratificación.

SELECT nombre,CASE 
	WHEN CEIL(DATEDIFF(CURRENT_DATE(),fechaingreso)/365) BETWEEN 1 AND 5 THEN 100 
    WHEN CEIL(DATEDIFF(CURRENT_DATE(),fechaingreso)/365) BETWEEN 6 AND 10 THEN CEIL(DATEDIFF(CURRENT_DATE(),fechaingreso)/365)*50 
    WHEN CEIL(DATEDIFF(CURRENT_DATE(),fechaingreso)/365) BETWEEN 11 AND 20 THEN CEIL(DATEDIFF(CURRENT_DATE(),fechaingreso)/365)*70
    WHEN CEIL(DATEDIFF(CURRENT_DATE(),fechaingreso)/365)>=21 THEN CEIL(DATEDIFF(CURRENT_DATE(),fechaingreso)/365)*100
	END gratificación, CEIL(DATEDIFF(CURRENT_DATE(),fechaingreso)/365) 'Años  en la empresa' FROM empleado ORDER BY nombre;

#29.Obtener a los nombres, apellidos de los empleados que no son jefes de departamento.

SELECT nombre, CONCAT(ape1, ' ',ape2) 'Apellidos' FROM empleado WHERE codemple NOT IN (SELECT codemplejefe FROM dpto); 


#UD05

#2. Inserta varios registros más en la tabla PROFESORADO utilizando sentencias SQL. 
#En la entrega de la tarea debes copiar las sentencias que has utilizado. Los datos deben ser los siguientes:

INSERT INTO profesorado VALUES (2, 'MARIA LUISA', 'FABRE BERDUN', '51083099F',
'TECNOLOGIA','1975/03/31',4);
INSERT INTO profesorado(Codigo,Nombre, Apellidos, Especialidad, Fecha_Nac, Antiguedad )
VALUES (3, 'JAVIER', 'JIMENEZ HERNANDO', 'LENGUA', '1969/05/04',10);
INSERT INTO profesorado VALUES (4, 'ESTEFANIA', 'FERNANDEZ MARTINEZ',
'19964324W', 'INGLES','1973/06/22',5);
INSERT INTO profesorado(Codigo,Nombre, Apellidos) VALUES (5, 'JOSE M.', 'ANERO
PAYAN');

#4.  Modifica el registro del profesor cuyo Codigo es 3  usando sentencias SQL, y cambia su especialidad a Informática  y su DNI a 9876543C. 
# En la entrega de la tarea debes copiar la sentencia que has utilizado.

UPDATE profesorado SET Especialidad='INFORMATICA', DNI='9876543C' WHERE Codigo=3;

#5.Modifica las antigüedades de todos los profesores y profesoras decrementándolas en 2 en todos los registros en los que la antigüedad superior a 2. 
#Debes hacerlo usando un sola sentencia SQL que debes copiar para la entrega de la tarea.

UPDATE profesorado SET Antiguedad=Antiguedad-2 WHERE Antiguedad > 2;

#7.Elimina, de la tabla ALUMNADO, aquellos registros asociados al curso con código 2 cuyo sexo sea H. Debes hacerlo usando un sola sentencia SQL que debes copiar para la entrega de la tarea..

DELETE FROM alumnado WHERE Cod_Curso=2 AND Sexo='H';

#8.Inserta los registros de la tabla ALUMNADO_NUEVO en la tabla ALUMNADO asociándole el código de curso 1, es decir, cod_curso con el valor 1. Debes hacerlo usando un sola sentencia SQL que debes copiar para la entrega de la tarea.

INSERT INTO alumnado(Nombre, Apellidos, Sexo, Fecha_Nac, Cod_curso) SELECT Nombre,
Apellidos, Sexo, Fecha_Nac, 1 FROM alumnado_nuevo;

#9.En la tabla CURSOS, actualiza el campo Max_Alumn del registro del curso con código 1, asignándole el valor correspondiente al número total de alumnos y alumnas que hay en la tabla ALUMNADO y que tienen asignado ese mismo curso.

UPDATE cursos SET Max_Alumn=(SELECT COUNT(*) FROM alumnado WHERE
Cod_Curso=1) WHERE Codigo=1;

#10.Elimina de la tabla ALUMNADO todos los registros asociados a los cursos que imparte el profesor cuyo codigo es 3

DELETE FROM alumnado WHERE Cod_Curso IN(SELECT Codigo FROM cursos WHERE Cod_Profe=3);

#BD Cines

-- CREATE DATABASE bd_cine DEFAULT character SET utf8 COLLATE utf8_general_ci;
CREATE DATABASE IF NOT EXISTS bd_cine;
USE bd_cine;


/* Películas */

CREATE TABLE peliculas (
  id INT NOT NULL auto_increment,
  titulo VARCHAR(80),
  titulo_original VARCHAR(80),
  produccion SMALLINT,
  duracion SMALLINT,
  calificacion SMALLINT,
  bn BOOLEAN DEFAULT FALSE,
  tiene_sinopsis BOOLEAN NOT NULL DEFAULT FALSE,
  --
  CONSTRAINT pk_pelicula PRIMARY KEY (id),
  CONSTRAINT uq_titulo UNIQUE KEY titulo (titulo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/* Actores y actrices */

CREATE TABLE actores (
  id INT NOT NULL auto_increment,
  actor VARCHAR(24) NOT NULL,
  --
  CONSTRAINT pk_actor PRIMARY KEY (actor),
  CONSTRAINT uq_id UNIQUE KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE peliculas_actores (
  pelicula_id INT NOT NULL,
  actor_id INT NOT NULL,
  /*papel VARCHAR(50),*/
  --
  CONSTRAINT pk_peliactor PRIMARY KEY (pelicula_id,actor_id),
  CONSTRAINT fk_peliactor1 FOREIGN KEY (pelicula_id) REFERENCES peliculas(id),
  CONSTRAINT fk_peliactor2 FOREIGN KEY (actor_id) REFERENCES actores(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE VIEW actores_peliculas AS
  SELECT pelicula_id id, actor_id, actor
  FROM actores a INNER JOIN peliculas_actores pa ON a.id = pa.actor_id;


/* Distribuidoras */

CREATE TABLE distribuidoras (
  id INT NOT NULL auto_increment,
  distribuidora VARCHAR(32) NOT NULL,
  --
  CONSTRAINT pk_distribuidora PRIMARY KEY (distribuidora),
  CONSTRAINT uq_id UNIQUE KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE peliculas_distribuidoras (
  pelicula_id INT NOT NULL,
  distribuidora_id INT NOT NULL,
  --
  CONSTRAINT pk_pelidistribuidora PRIMARY KEY (distribuidora_id,pelicula_id),
  CONSTRAINT fk_pelidistribuidora1 FOREIGN KEY (pelicula_id) REFERENCES peliculas(id),
  CONSTRAINT fk_pelidistribuidora2 FOREIGN KEY (distribuidora_id) REFERENCES distribuidoras(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE VIEW distribuidoras_peliculas AS
  SELECT pelicula_id id, distribuidora_id, distribuidora
  FROM distribuidoras d INNER JOIN peliculas_distribuidoras pd ON d.id = pd.distribuidora_id;

/* Directores */

CREATE TABLE directores (
  id INT NOT NULL auto_increment,
  director VARCHAR(24) NOT NULL,
  --
  CONSTRAINT pk_director PRIMARY KEY (director),
  CONSTRAINT uq_id UNIQUE KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE peliculas_directores (
  pelicula_id INT NOT NULL,
  director_id INT NOT NULL,
  --
  CONSTRAINT pk_pelidirector PRIMARY KEY (director_id,pelicula_id),
  CONSTRAINT fk_pelidirector1 FOREIGN KEY (pelicula_id) REFERENCES peliculas(id),
  CONSTRAINT fk_pelidirector2 FOREIGN KEY (director_id) REFERENCES directores(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE VIEW directores_peliculas AS
  SELECT pelicula_id id, director_id, director
  FROM directores d INNER JOIN peliculas_directores pd ON d.id = pd.director_id;

/* Estudios */

CREATE TABLE estudios (
  id INT NOT NULL auto_increment,
  estudio VARCHAR(32) NOT NULL,
  --
  CONSTRAINT pk_estudio PRIMARY KEY (estudio),
  CONSTRAINT uq_id UNIQUE KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE peliculas_estudios (
  pelicula_id INT NOT NULL,
  estudio_id INT NOT NULL,
  --
  CONSTRAINT pk_peliestudio PRIMARY KEY (estudio_id,pelicula_id),
  CONSTRAINT fk_peliestudio1 FOREIGN KEY (pelicula_id) REFERENCES peliculas(id),
  CONSTRAINT fk_peliestudio2 FOREIGN KEY (estudio_id) REFERENCES estudios(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE VIEW estudios_peliculas AS
  SELECT pelicula_id id, estudio_id, estudio
  FROM estudios e INNER JOIN peliculas_estudios pe ON e.id = pe.estudio_id;

/* Fotógrafos */

CREATE TABLE fotografos (
  id INT NOT NULL auto_increment,
  fotografo VARCHAR(24) NOT NULL,
  --
  CONSTRAINT pk_fotografo PRIMARY KEY (fotografo),
  CONSTRAINT uq_id UNIQUE KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE peliculas_fotografos (
  pelicula_id INT NOT NULL,
  fotografo_id INT NOT NULL,
  --
  CONSTRAINT pk_pelifotografo PRIMARY KEY (fotografo_id,pelicula_id),
  CONSTRAINT fk_pelifotografo1 FOREIGN KEY (pelicula_id) REFERENCES peliculas(id),
  CONSTRAINT fk_pelifotografo2 FOREIGN KEY (fotografo_id) REFERENCES fotografos(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE VIEW fotografos_peliculas AS
  SELECT pelicula_id id, fotografo_id, fotografo
  FROM fotografos f INNER JOIN peliculas_fotografos pf ON f.id = pf.fotografo_id;


/* Géneros */

CREATE TABLE generos (
  id INT NOT NULL auto_increment,
  genero VARCHAR(16) NOT NULL,
  --
  CONSTRAINT pk_genero PRIMARY KEY (genero),
  CONSTRAINT uq_id UNIQUE KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE peliculas_generos (
  pelicula_id INT NOT NULL,
  genero_id INT NOT NULL,
  --
  CONSTRAINT pk_peligenero PRIMARY KEY (genero_id,pelicula_id),
  CONSTRAINT fk_peligenero1 FOREIGN KEY (pelicula_id) REFERENCES peliculas(id),
  CONSTRAINT fk_peligenero2 FOREIGN KEY (genero_id) REFERENCES generos(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE VIEW generos_peliculas AS
  SELECT pelicula_id id, genero_id, genero
  FROM generos g INNER JOIN peliculas_generos pg ON g.id = pg.genero_id;


/* Guionistas */

CREATE TABLE guionistas (
  id INT NOT NULL auto_increment,
  guionista VARCHAR(24) NOT NULL,
  --
  CONSTRAINT pk_guionista PRIMARY KEY (guionista),
  CONSTRAINT uq_id UNIQUE KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE peliculas_guionistas (
  pelicula_id INT NOT NULL,
  guionista_id INT NOT NULL,
  --
  CONSTRAINT pk_peliguionista PRIMARY KEY (guionista_id,pelicula_id),
  CONSTRAINT fk_peliguionista1 FOREIGN KEY (pelicula_id) REFERENCES peliculas(id),
  CONSTRAINT fk_peliguionista2 FOREIGN KEY (guionista_id) REFERENCES guionistas(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE VIEW guionistas_peliculas AS
  SELECT pelicula_id id, guionista_id, guionista
  FROM guionistas g INNER JOIN peliculas_guionistas pg ON g.id = pg.guionista_id;


/* Montadores */

CREATE TABLE montadores (
  id INT NOT NULL auto_increment,
  montador VARCHAR(24) NOT NULL,
  --
  CONSTRAINT pk_montador PRIMARY KEY (montador),
  CONSTRAINT uq_id UNIQUE KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE peliculas_montadores (
  pelicula_id INT NOT NULL,
  montador_id INT NOT NULL,
  CONSTRAINT pk_pelimontador PRIMARY KEY (montador_id,pelicula_id),
  CONSTRAINT fk_pelimontador1 FOREIGN KEY (pelicula_id) REFERENCES peliculas(id),
  CONSTRAINT fk_pelimontador2 FOREIGN KEY (montador_id) REFERENCES montadores(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE VIEW montadores_peliculas AS
  SELECT pelicula_id id, montador_id, montador
  FROM montadores m INNER JOIN peliculas_montadores pm ON m.id = pm.montador_id;

/* Músicos */

CREATE TABLE musicos (
  id INT NOT NULL auto_increment,
  musico VARCHAR(24) NOT NULL,
  --
  CONSTRAINT pk_musico PRIMARY KEY (musico),
  CONSTRAINT uq_id UNIQUE KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE peliculas_musicos (
  pelicula_id INT NOT NULL,
  musico_id INT NOT NULL,
  --
  CONSTRAINT pk_pelimusico PRIMARY KEY (musico_id,pelicula_id),
  CONSTRAINT fk_pelimusico1 FOREIGN KEY (pelicula_id) REFERENCES peliculas(id),
  CONSTRAINT fk_pelimusico2 FOREIGN KEY (musico_id) REFERENCES musicos(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE VIEW musicos_peliculas AS
  SELECT pelicula_id id, musico_id, musico
  FROM musicos m INNER JOIN peliculas_musicos pm ON m.id = pm.musico_id;


/* Nacionalidades */

CREATE TABLE nacionalidades (
  id INT NOT NULL auto_increment,
  nacionalidad VARCHAR(16) NOT NULL,
  --
  CONSTRAINT pk_nacionalidad PRIMARY KEY (nacionalidad),
  CONSTRAINT uq_id UNIQUE KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE peliculas_nacionalidades (
  pelicula_id INT NOT NULL,
  nacionalidad_id INT NOT NULL,
  --
  CONSTRAINT pk_pelinacionalidad PRIMARY KEY (nacionalidad_id,pelicula_id),
  CONSTRAINT fk_pelinacionalidad1 FOREIGN KEY (pelicula_id) REFERENCES peliculas(id),
  CONSTRAINT fk_pelinacionalidad2 FOREIGN KEY (nacionalidad_id) REFERENCES nacionalidades(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE VIEW nacionalidades_peliculas AS
  SELECT pelicula_id id, nacionalidad_id, nacionalidad
  FROM nacionalidades n INNER JOIN peliculas_nacionalidades pn ON n.id = pn.nacionalidad_id;


/* Productores */

CREATE TABLE productores (
  id INT NOT NULL auto_increment,
  productor VARCHAR(24) NOT NULL,
  --
  CONSTRAINT pk_productor PRIMARY KEY (productor),
  CONSTRAINT uq_id UNIQUE KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE peliculas_productores (
  pelicula_id INT NOT NULL,
  productor_id INT NOT NULL,
  --
  CONSTRAINT pk_peliproductor PRIMARY KEY (productor_id,pelicula_id),
  CONSTRAINT fk_peliproductor1 FOREIGN KEY (pelicula_id) REFERENCES peliculas(id),
  CONSTRAINT fk_peliproductor2 FOREIGN KEY (productor_id) REFERENCES productores(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE VIEW productores_peliculas AS
  SELECT pelicula_id id, productor_id, productor
  FROM productores p INNER JOIN peliculas_productores pp ON p.id = pp.productor_id;


/* Carátulas */

CREATE TABLE peliculas_caratulas (
  pelicula_id INT NOT NULL,
  caratula LONGBLOB,
  --
  CONSTRAINT pk_pelicaratula PRIMARY KEY (pelicula_id),
  CONSTRAINT fk_pelicaratula1 FOREIGN KEY (pelicula_id) REFERENCES peliculas(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/* Sinopsis */

CREATE TABLE peliculas_sinopsis (
  pelicula_id INT NOT NULL,
  sinopsis LONGTEXT,
  --
  CONSTRAINT pk_pelisinopsis PRIMARY KEY (pelicula_id),
  CONSTRAINT fk_pelisinopsis1 FOREIGN KEY (pelicula_id) REFERENCES peliculas(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




use bd_cine;

#1.Directores y actores con más películas

(SELECT d.director, COUNT(p.pelicula_id), 'Director' AS 'TIPO' FROM directores d JOIN peliculas_directores p ON d.id=p.director_id GROUP BY d.director) 
UNION
(SELECT a.actor, COUNT(p.pelicula_id), 'Actor' AS 'TIPO' FROM actores a JOIN peliculas_actores p ON a.id=p.actor_id GROUP BY a.actor) ORDER BY 2 DESC;

#2.Películas que han sido producidas por Kathleen Kennedy. Incluir el director y ordenar por año de producción.

SELECT pe.titulo, pe.produccion, pr.productor, p.pelicula_id, di.director  FROM productores pr 
	JOIN peliculas_productores p ON pr.id=p.productor_id 
		JOIN peliculas pe ON pe.id=p.pelicula_id 
			JOIN peliculas_directores pd ON pe.id=pd.pelicula_id 
				JOIN directores di ON pd.director_id=di.id 
					WHERE pr.productor='Kathleen Kennedy';
                    
#3. Películas realizadas por cualquiera de los actores que trabajaron en "Forrest Gump"
       
SELECT pe.titulo,a.actor FROM actores a
	JOIN peliculas_actores p ON a.id=p.actor_id
		JOIN peliculas pe ON pe.id=p.pelicula_id WHERE a.actor IN(SELECT a.actor FROM actores a
			JOIN peliculas_actores p ON a.id=p.actor_id
				JOIN peliculas pe ON pe.id=p.pelicula_id WHERE pe.titulo="Forrest Gump") ORDER BY 1;
        
#4. Películas dirigidas por Billy Wilder donde hayan actuado Marilyn Monroe o Jack Lemmon

SELECT d.director, p.titulo, p.produccion, a.actor FROM directores d 
	JOIN peliculas_directores pd ON d.id=pd.director_id
		JOIN peliculas p ON p.id=pd.pelicula_id
			JOIN peliculas_actores pa ON p.id=pa.pelicula_id
				JOIN actores a ON a.id=pa.actor_id WHERE d.director="Billy Wilder" 
					AND (a.actor="Marilyn Monroe" OR a.actor="Jack Lemmon") ORDER BY 2;
 
 #5.Géneros de película preferidos del director John Ford
 
 SELECT d.director, g.genero, COUNT(p.titulo) 'cuenta' FROM directores d 
	JOIN peliculas_directores pd ON d.id=pd.director_id
		JOIN peliculas p ON p.id=pd.pelicula_id
			JOIN peliculas_generos pg ON p.id=pg.pelicula_id
				JOIN generos g ON g.id=pg.genero_id WHERE d.director="John Ford" GROUP BY g.genero ORDER BY 3 DESC;
 
 
 #6.Películas de animación o dibujos animados ordenadas de más a menos reciente
 
 SELECT p.titulo,p.produccion,g.genero FROM peliculas p 
	JOIN peliculas_generos pg ON p.id=pg.pelicula_id
		JOIN generos g ON g.id=pg.genero_id WHERE g.genero="Dibujos animados" OR g.genero="Animación" ORDER BY 2 DESC;
        
     
#7.Películas dónde actúan "Cary Grant" y "Ingrid Bergman"

SELECT pe.titulo,a.actor FROM actores a
	JOIN peliculas_actores p ON a.id=p.actor_id
		JOIN peliculas pe ON pe.id=p.pelicula_id WHERE actor="Cary Grant" AND pe.titulo IN(
			SELECT pe.titulo FROM actores a
				JOIN peliculas_actores p ON a.id=p.actor_id
					JOIN peliculas pe ON pe.id=p.pelicula_id WHERE actor="Ingrid Bergman");
        
#8.Películas y actores del año 1982

SELECT pe.titulo,a.actor,pe.produccion FROM actores a
	JOIN peliculas_actores p ON a.id=p.actor_id
		JOIN peliculas pe ON pe.id=p.pelicula_id WHERE pe.produccion=1982;
  
#9.Películas y actores de la década de los 90 con al menos 2 directores

SELECT p.titulo, d.director, a.actor FROM directores d 
	JOIN peliculas_directores pd ON d.id=pd.director_id
		JOIN peliculas p ON p.id=pd.pelicula_id
			JOIN peliculas_actores pa ON p.id=pa.pelicula_id
				JOIN actores a ON a.id=pa.actor_id WHERE p.titulo IN(
					SELECT p.titulo FROM directores d 
						JOIN peliculas_directores pd ON d.id=pd.director_id
							JOIN peliculas p ON p.id=pd.pelicula_id
								JOIN peliculas_actores pa ON p.id=pa.pelicula_id
									JOIN actores a ON a.id=pa.actor_id WHERE produccion LIKE '199%' GROUP BY (p.titulo) 
										HAVING COUNT(distinct(d.director))>1);
                                        
SELECT titulo, 
  GROUP_CONCAT(director SEPARATOR ', ') directores,
  (SELECT GROUP_CONCAT(actor SEPARATOR ', ') 
   FROM actores_peliculas
   WHERE p.id = id) actores
FROM peliculas p INNER JOIN directores_peliculas USING (id)
WHERE produccion BETWEEN 1990 AND 1999  
GROUP BY titulo
HAVING COUNT(*) >= 2
ORDER BY titulo;
                                        
#10.Películas del director que tenga más películas

SELECT p.titulo,d.director FROM directores d 
	JOIN peliculas_directores pd ON d.id=pd.director_id
		JOIN peliculas p ON p.id=pd.pelicula_id WHERE d.director IN
        (SELECT d.director FROM directores d 
			JOIN peliculas_directores pd ON d.id=pd.director_id
				JOIN peliculas p ON p.id=pd.pelicula_id GROUP BY d.director HAVING COUNT(p.titulo) >=ALL
				(SELECT COUNT(p.titulo) FROM directores d 
					JOIN peliculas_directores pd ON d.id=pd.director_id
						JOIN peliculas p ON p.id=pd.pelicula_id GROUP BY d.director)) ORDER BY p.titulo;
                        
#11.Actores que también han sido directores y productores

SELECT DISTINCT actor FROM actores_peliculas ap
	 JOIN directores_peliculas dp ON ap.actor=dp.director
     JOIN productores_peliculas pp ON ap.actor=pp.productor ORDER BY actor;

#12.Número de películas en cada década
SELECT FLOOR(produccion/10)*10 decada, COUNT(*) cuenta FROM peliculas GROUP BY 1 ORDER BY 1;

#13. Los tres actores más representativos de los 50 y 60

(SELECT 1950 decada, ap.actor, COUNT(ap.actor) cuenta
	FROM peliculas p JOIN actores_peliculas ap ON p.id=ap.id
		WHERE p.produccion BETWEEN 1950 AND 1959
			GROUP BY ap.actor ORDER BY COUNT(*) DESC LIMIT 3)
	UNION
(SELECT 1960 decada, ap.actor, COUNT(ap.actor) cuenta
	FROM peliculas p JOIN actores_peliculas ap ON p.id=ap.id
		WHERE p.produccion BETWEEN 1960 AND 1969
			GROUP BY ap.actor ORDER BY COUNT(*) DESC LIMIT 3);
    
#14.Número de películas por actor encolumnado por década

SELECT ap.actor, COUNT(p.titulo), FLOOR(produccion/10)*10 decada FROM peliculas p
	JOIN actores_peliculas ap ON p.id=ap.id GROUP BY 1,3; 
    
#15.Director y género de las películas interpretadas por Ron Perlman

SELECT ap.actor, gp.genero, dp.director FROM peliculas p
	JOIN actores_peliculas ap ON p.id=ap.id
		JOIN generos_peliculas gp ON p.id=gp.id
			JOIN directores_peliculas dp ON p.id=dp.id WHERE ap.actor="Ron Perlman";

#16.Director, nacionalidad y músico de las películas que empiezan por "K"

SELECT p.titulo, dp.director, np.nacionalidad, mp.musico FROM peliculas p
	JOIN directores_peliculas dp ON p.id=dp.id
		JOIN nacionalidades_peliculas np ON p.id=np.id
			JOIN musicos_peliculas mp ON p.id=mp.id WHERE p.titulo LIKE "K%";

#17.Películas de Katherine Hepburn cuando actuó junto a Cary Grant o Spencer Tracy

SELECT ap.actor, p.titulo  FROM peliculas p
	JOIN actores_peliculas ap ON p.id=ap.id WHERE ap.actor='Katharine Hepburn' AND p.titulo IN(   
    SELECT p.titulo  FROM peliculas p
	JOIN actores_peliculas ap ON p.id=ap.id WHERE ap.actor='Cary Grant' OR ap.actor="Spencer Tracy");

#18.Actores de las películas donde actuó Marilyn Monroe ordenado por año de producción

SELECT ap.actor, p.titulo,p.produccion  FROM peliculas p
	JOIN actores_peliculas ap ON p.id=ap.id WHERE p.titulo IN(
	SELECT p.titulo  FROM peliculas p
		JOIN actores_peliculas ap ON p.id=ap.id WHERE ap.actor="Marilyn Monroe") ORDER BY p.produccion DESC;
    
#19.Películas donde actuaron Ava Gardner o Clark Gable y fueron dirigidas por John Ford o John Huston
    
SELECT ap.actor, gp.genero, dp.director FROM peliculas p
	JOIN actores_peliculas ap ON p.id=ap.id
		JOIN generos_peliculas gp ON p.id=gp.id
			JOIN directores_peliculas dp ON p.id=dp.id WHERE (ap.actor="Ava Gardner" OR ap.actor="Clark Gable")
				AND (dp.director="John Ford" OR dp.director="John Huston");
     
#20.Número de películas que empiezan por cada letra del abecedario. Las películas que no empiezan por una letra agruparlas en el grupo asterisco.

SELECT SUBSTRING(p.titulo, 1, 1), COUNT(p.titulo) FROM peliculas p GROUP BY 1;

SELECT titulo,
CASE 
	WHEN SUBSTRING(titulo, 1, 1)="[A-Z]{1}" THEN SUBSTRING(titulo, 1, 1)
    END FROM peliculas;
    
#21.Añadir el número de directores y de actores a la consulta anterior

SELECT SUBSTRING(p.titulo, 1, 1),COUNT(DISTINCT(p.titulo)), COUNT(DISTINCT(dp.director)), COUNT(DISTINCT(ap.actor)) FROM peliculas p 
	JOIN actores_peliculas ap ON p.id=ap.id 
		JOIN directores_peliculas dp ON p.id=dp.id GROUP BY 1;
        
