USE `CIRCO`;

SET @nombreAnimalSinArtista="";

SELECT anhos,peso
INTO @anhos,@peso
FROM ANIMALES
WHERE nombre="Caiman";

SELECT @anhos;
SELECT @peso;

SELECT anhos
FROM ANIMALES
WHERE nombre="Caiman";

SELECT nombre INTO @nombreAnimalSinArtista FROM animales WHERE nombre NOT IN(SELECT nombre_animal FROM animales_artistas);
SELECT @nombreAnimalSinArtista;

INSERT INTO animales_artistas VALUES(@nombreAnimalSinArtista,'11111111A');


DELIMITER $$

CREATE PROCEDURE animales_getList()
BEGIN
    SELECT nombre
    FROM ANIMALES
    ORDER BY nombre;

END$$

DELIMITER ;

CALL animales_getList();


#Ejercicio 1
#Crea un procedimiento de nombre artistas_getList() que devuelva el nombre y apellidos de los artistas separados por coma con el formato: apellidos,nombre ordenados de forma descendente.

DELIMITER $$

CREATE PROCEDURE artistas_getList()
BEGIN
    SELECT CONCAT(apellidos,', ',nombre) 'Nombres'
    FROM artistas
    ORDER BY apellidos DESC;

END$$

DELIMITER ;

CALL artistas_getList();

#Ejercicio 2
#Crea un procedimiento de nombre artistas_getListAnimales() que devuelva los nombres de los artistas junto con su nif así como el nombre y peso de los animales que están atendidos por los artistas, 
#ordenados por nif del artista y nombre del animal.
DELIMITER $$

CREATE PROCEDURE artistas_getListAnimales()
BEGIN
SELECT ar.nombre, ar.nif, an.nombre, an.peso
FROM artistas ar JOIN animales_artistas an_ar
ON an_ar.nif_artista=ar.nif JOIN animales an
ON  an_ar.nombre_animal=an.nombre ORDER BY 2,3;
END$$

DELIMITER ;

CALL artistas_getListAnimales();

#Ejercicio 3
#Crea un procedimiento de nombre atracciones_getListConAntiguedad5() que devuelva los datos de las atracciones que hayan comenzado hace 5 años con respecto a la fecha actual. 
#Tendrás que hacer uso de alguna de las funciones Date Time. Intenta averiguar cual.
#Fijarse que este procedimiento es un buen candidato para emplear un parámetro en donde indiquemos el número de años. Lo veremos después cuando expliquemos el paso de datos por parámetros.
DELIMITER $$

CREATE PROCEDURE atracciones_getListConAntiguedad5()
BEGIN
SELECT * FROM atracciones WHERE (DATEDIFF(CURRENT_DATE(),fecha_inicio)/365)>5;
END$$

DELIMITER ;
CALL atracciones_getListConAntiguedad5();

#Ejercicio 4
#Crea un procedimiento de nombre animales_Leo_getPista() que muestre los datos de la pista donde trabaja el animal de nombre 'Leo'. 
#Hacerlo empleando una variable local que guarde el nombre de la pista. Después consultar los datos de la pista empleando dicha variable local.
#Fijarse que este procedimiento es un buen candidato para emplear un parámetro en donde indiquemos el nombre del animal. Lo veremos después cuando expliquemos el paso de datos por parámetros.

DROP PROCEDURE IF EXISTS animales_Leo_getPista;
DELIMITER $$

CREATE PROCEDURE animales_Leo_getPista()
BEGIN
DECLARE v_nombre_pista VARCHAR(50) DEFAULT '';
	SELECT nombre_pista
	INTO v_nombre_pista
	FROM animales 
	WHERE nombre='Leo';
    
    SELECT * FROM pistas WHERE nombre=v_nombre_pista;
    
END$$;
DELIMITER ;

CALL animales_Leo_getPista();


#Ejercicio 1: Crea un procedimiento de nombre artistas_getAnimalesPorNif que devuelva los animales que cuida un artista. Llevará como parámetro el nif de artista.

DELIMITER $$
CREATE PROCEDURE artistas_getAnimalesPorNif (IN p_nif_artista char(9))
BEGIN
     SELECT nombre_animal
     FROM animales_artistas
     WHERE nif_artista=p_nif_artista;
END $$
DELIMITER ;

CALL artistas_getAnimalesPorNif('22222222B');


#Ejercicio 3: Crea un procedimiento de nombre atracciones_getListConAntiguedad que devuelva los datos de las atracciones que hayan comenzado hace un número de años con respecto a la fecha actual. 
#Tendrás que hacer uso de alguna de las funciones Date Time. Intenta averiguar cual.

DELIMITER $$
CREATE PROCEDURE atracciones_getListConAntiguedad (IN p_num_años INTEGER)
BEGIN
    SELECT * FROM atracciones WHERE (DATEDIFF(CURRENT_DATE(),fecha_inicio)/365)>p_num_años;
END $$
DELIMITER ;

CALL atracciones_getListConAntiguedad(1);


#Ejercicio 4: Crea un procedimiento de nombre artistas_getListMasAnimalesCuida que devuelva los datos del/os artista/s que cuidan a más animales de los indicados (parámetro que se le envía).
#Pista: Como la consulta puede devolver más de un artista no podremos hacer uso de INTO....

DELIMITER $$
CREATE PROCEDURE artistas_getListMasAnimalesCuida (IN p_num_animales INTEGER)
BEGIN
    SELECT COUNT(*),nif_artista FROM animales_artistas GROUP BY nif_artista HAVING COUNT(*)> p_num_animales;
END $$
DELIMITER ;

CALL artistas_getListMasAnimalesCuida(3);

#Ejercicio 5: Crea un procedimiento de nombre atracciones_getListPorFecha que devuelva los datos de las atracciones que han comenzado a partir de la fecha indicada.
#Pista: Recordar que las fechas son tratadas como cadenas...y tener en cuenta el formato.
#Añade una nueva atracción con la fecha de inicio actual.
#Llama al procedimiento empleando la fecha actual menos 3 días (haz uso de la función DATE_SUB y curdate)

DELIMITER $$
CREATE PROCEDURE atracciones_getListPorFecha (IN p_fecha DATE)
BEGIN
    SELECT * FROM atracciones WHERE DATE_SUB(CURDATE(), INTERVAL 3 DAY)>p_fecha;
END $$
DELIMITER ;

CALL atracciones_getListPorFecha(3);


#Ejercicio 6
#Crea un procedimiento de nombre artistas_getNumAnimalesCuida al que se le pase el nif de un artista y que devuelva en forma de parámetro de salida a cuantos animales cuida.

#Ejercicio 7
#Crea un procedimiento de nombre pistas_addAforo al que se le envíe como parámetros el nombre de la pista y una cantidad que representa el incremento del aforo.
#El procedimiento debe devolver en el mismo parámetro el nuevo aforo de la pista.


