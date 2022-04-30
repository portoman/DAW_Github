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

#EJERCICIOS PROCEDIMIENTOS

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

DROP PROCEDURE IF EXISTS atracciones_getListConAntiguedad5;
DELIMITER $$

#Version profe
CREATE PROCEDURE atracciones_getListConAntiguedad5()
COMMENT 'Devuelve todos los datos de las atracciones que comenzaran hace 5 años con respecto a la fecha actual'
BEGIN
    SELECT *
    FROM ATRACCIONES
    WHERE fecha_inicio BETWEEN DATE_SUB(curdate(), INTERVAL 5 YEAR) AND  curdate()
    ORDER BY nombre;

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


#EJERCICIOS PROCEDIMIENTOS CON PARÁMETROS

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

CALL artistas_getListMasAnimalesCuida(1);

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

CALL atracciones_getListPorFecha('2022-04-01');


#Ejercicio 6
#Crea un procedimiento de nombre artistas_getNumAnimalesCuida al que se le pase el nif de un artista y que devuelva en forma de parámetro de salida a cuantos animales cuida.

DROP PROCEDURE IF EXISTS artistas_getNumAnimalesCuida;
DELIMITER $$
CREATE PROCEDURE artistas_getNumAnimalesCuida (IN p_nif_artista char(9),OUT p_num_animales INTEGER)
BEGIN
    SELECT COUNT(*) INTO p_num_animales FROM animales_artistas GROUP BY nif_artista HAVING nif_artista=p_nif_artista;
END $$
DELIMITER ;

CALL artistas_getNumAnimalesCuida('22222222B',@num);

SELECT @num;

#Ejercicio 7
#Crea un procedimiento de nombre pistas_addAforo al que se le envíe como parámetros el nombre de la pista y una cantidad que representa el incremento del aforo.
#El procedimiento debe devolver en el mismo parámetro el nuevo aforo de la pista.

DROP PROCEDURE IF EXISTS pistas_addAforo;
DELIMITER $$
CREATE PROCEDURE pistas_addAforo (IN p_nombre_pista VARCHAR(50),INOUT p_incremento_aforo SMALLINT)
BEGIN
    SELECT aforo+p_incremento_aforo INTO p_incremento_aforo FROM pistas WHERE nombre=p_nombre_pista;
END $$
DELIMITER ;

SET @dato=50;
CALL pistas_addAforo('LATERAL1',@dato);

SELECT @dato;

###########FUNCIONES##############

DELIMITER //
CREATE FUNCTION ejemploFuncion() RETURNS VARCHAR(20) DETERMINISTIC
BEGIN
    RETURN 'Ejemplo';
END
//

SELECT ejemploFuncion();

SELECT @@log_bin;

#1 Crea una función de nombre utilidades_getMesEnLetra a la que se le pase un número y devuelva el nombre del mes. En caso de que el número no se corresponda con ningún mes, debe devolver null.
DROP FUNCTION IF EXISTS utilidades_getMesEnLetra;
DELIMITER //
CREATE FUNCTION utilidades_getMesEnLetra(p_mes VARCHAR(50)) RETURNS VARCHAR(10) DETERMINISTIC
BEGIN
    DECLARE v_mesEnLetra VARCHAR(10) DEFAULT NULL;
    CASE p_mes 
		WHEN 1 THEN SET v_mesEnLetra="ENERO";
        WHEN 2 THEN SET v_mesEnLetra="FEBRERO";
        WHEN 3 THEN SET v_mesEnLetra="MARZO";
        WHEN 4 THEN SET v_mesEnLetra="ABRIL";
        WHEN 5 THEN SET v_mesEnLetra="MAYO";
        WHEN 6 THEN SET v_mesEnLetra="JUNIO";
        WHEN 7 THEN SET v_mesEnLetra="JULIO";
        WHEN 8 THEN SET v_mesEnLetra="AGOSTO";
        WHEN 9 THEN SET v_mesEnLetra="SEPTIEMBRE";
        WHEN 10 THEN SET v_mesEnLetra="OCTUBRE";
        WHEN 11 THEN SET v_mesEnLetra="NOVIEMBRE";
        WHEN 12 THEN SET v_mesEnLetra="DICIEMBRE";
	END CASE;
    RETURN v_mesEnLetra;
END//
DELIMITER ;

# Llama a la función directamente y guarda el resultado en una variable de sesión.
SET @mes=utilidades_getMesEnLetra(55);
SELECT @mes;

# Llama a la función para que muestre los meses en letra en los que se celebró la atracción 'El gran felino'.
SELECT utilidades_getMesEnLetra(MONTH(fecha)) FROM atraccion_dia WHERE nombre_atraccion="El gran felino";

# Llama a la función para que muestre las atracciones que se celebraron en ABRIL (busca por la cadena ABRIL) (recuerda hacer uso de COLLATE).

SHOW CREATE TABLE atraccion_dia;

SELECT nombre_atraccion FROM atraccion_dia WHERE utilidades_getMesEnLetra(MONTH(fecha))="ABRIL" COLLATE "utf8mb4_spanish2_ci";

# 2. Modifica un ejercicio anterior en el que creamos el procedimiento de nombre 'atracciones_getNumPorMes' y crea una función de nombre utilidades_getMesEnNumero a 
#la que se le pase el nombre de un mes y devuelva el número que se corresponde con ese nombre. Si el mes no existe debe devolver -1. 
#Modifica el procedimiento para que haga uso de la función.

#Creación de la función. Como la anterior, pero al revés

DROP FUNCTION IF EXISTS utilidades_getMesEnNumero;
DELIMITER //
	CREATE FUNCTION utilidades_getMesEnNumero (p_mes VARCHAR(20)) RETURNS INTEGER DETERMINISTIC
    BEGIN
		DECLARE v_mesEnNumero INT DEFAULT -1;
    CASE p_mes 
		WHEN "ENERO" THEN SET v_mesEnLetra=1;
        WHEN "FEBRERO" THEN SET v_mesEnLetra=2;
        WHEN "MARZO" THEN SET v_mesEnLetra=3;
        WHEN "ABRIL" THEN SET v_mesEnLetra=4;
        WHEN "MAYO" THEN SET v_mesEnLetra=5;
        WHEN "JUNIO" THEN SET v_mesEnLetra=6;
        WHEN "JULIO" THEN SET v_mesEnLetra=7;
        WHEN "AGOSTO" THEN SET v_mesEnLetra=8;
        WHEN "SEPTIEMBRE" THEN SET v_mesEnLetra=9;
        WHEN "OCTUBRE" THEN SET v_mesEnLetra=10;
        WHEN "NOVIEMBRE" THEN SET v_mesEnLetra=11;
        WHEN "DICIEMBRE" THEN SET v_mesEnLetra=12;
	END CASE;
    RETURN v_mesEnNumero;   
    END //
DELIMITER ;

##Metemos la funcion en el procedimiento

DROP PROCEDURE IF EXISTS atracciones_getNumPorMes;
DELIMITER //
	CREATE PROCEDURE atracciones_getNumPorMesConFuncion(p_mes VARCHAR(10), p_ano INT, OUT p_numAtracciones in)
    DECLARE v_mesEnNumero INT DEFAULT 0;
    DECLARE v_dia INT DEFAULT 1;
    DECLARE v_numAtracionPorDia INT;
    SET p_numAtracciones=0;
    SET v_mesEnNumero=utilidades_getMesEnNumero(p_mes);
    IF(v_mesEnNumero=-1) THEN
		SET p_numAtracciones=-1;
        LEAVE label_prod;
	END IF;
    
    IF(p_ano IS NULL) THEN
		SET p_ano=YEAR(curdate());
	END IF;
    
    bucle_dia: WHILE (v_dia<=31) DO
    IF(DATE(CONCAT(p_ano,'-',v_mesEnNumero,'-',v_dia)) IS NULL) THEN
    LEAVE bucle_dia;
    END IF;
    
    SELECT COUNT(*)
    INTO v_numAtracionPorDia
    FROM atraccion_dia
    WHERE fecha=CONCAT(p_ano,'-',v_mesEnNumero,'-',v_dia);
    SET v_dia=v_dia+1;
    SET p_numAtracciones=p_numAtracciones+v_numAtracionPorDia;
    
    
    END WHILE bucle_dia;

DELIMITER ;

#Crea una función de nombre animales_getEstadoPorAnhos que devuelva la cadena:
#Si tipo = León
	#anhos < 2: 'JOVEN'
	#anhos >=2 y <=5: 'MADURO'
	#anhos > 5: 'VIEJO'
#Cualquier otro tipo:
	#anhos < 1: 'JOVEN'
	#anhos >=1 y <=3: 'MADURO'
	#anhos > 3: 'VIEJO'
#Llama a la función para mostrar el estado por años de cada uno de los animales del CIRCO.

DROP FUNCTION IF EXISTS animales_getEstadoPorAnhos;
DELIMITER //
	CREATE FUNCTION animales_getEstadoPorAnhos(p_tipo VARCHAR(20), p_anos INT) RETURNS VARCHAR(8) DETERMINISTIC
    BEGIN
		DECLARE v_cadena VARCHAR(20);
		IF (p_tipo="León") THEN 
			IF (p_anos<2) THEN SET v_cadena="JOVEN";
            ELSEIF(p_anos>=2 and p_anos <=5) THEN SET v_cadena="MADURO";
            ELSEIF(p_anos>5) THEN SET v_cadena="VIEJO";
            END IF;
        ELSE
			IF (p_anos<1) THEN SET v_cadena="JOVEN";
            ELSEIF(p_anos>=1 and p_anos <=3) THEN SET v_cadena="MADURO";
            ELSEIF(p_anos>3) THEN SET v_cadena="VIEJO";
            END IF;
		END IF;
    RETURN v_cadena;   
    END //
DELIMITER ;

SET @estado=animales_getEstadoPorAnhos("León",2);
SELECT @estado;

SELECT *,animales_getEstadoPorAnhos(tipo, anhos)
FROM animales;


############## CONTROL DE FLUJO ################

# Ejemplo Teoría 1

# Crear un procedimiento de nombre artistas_getPorNif que recupere los datos de un artista enviando un nif. 
# En caso de que el artista no exista, devolverá la cadena 'NO ENCONTRADO' sin utilizar un parámetro de salida. 
# La cadena que va a devolver tendrá el formato: artista>nif:nombre:apellidos-jefe>nif:nombre:apellidos. 
# En caso de que no tenga jefe, el formato será: artista>nif:nombre:apellidos-jefe>SIN JEFE


DROP PROCEDURE IF EXISTS artistas_getPorNif;
DELIMITER $$
CREATE PROCEDURE artistas_getPorNif(IN p_nif char(9))		
BEGIN
    DECLARE v_nifArt,v_nifJefe char(9);		-- No ponemos default, por lo tanto el valor por defecto es NULL
    DECLARE v_nombreArt,v_nombreJefe varchar(45);
    DECLARE v_apellArt,v_apellJefe varchar(100);
    
    DECLARE v_cadenaArtista varchar(400);
    DECLARE v_cadenaJefe varchar(400);
    
    # Consulta reflexiva
    SELECT A.nif,A.nombre,A.apellidos,J.nif,J.nombre,J.apellidos
    INTO v_nifArt,v_nombreArt,v_apellArt,v_nifJefe,v_nombreJefe,v_apellJefe
    FROM ARTISTAS A LEFT OUTER JOIN ARTISTAS J 
				ON (A.nif_jefe = J.nif)
    WHERE A.nif=p_nif;
    
    #Si no hay artista con ese nif
    IF (v_nifArt IS NULL) THEN		
        SELECT 'NO ENCONTRADO';
	#Si no tiene jefe
    ELSEIF (v_nifJefe IS NULL) THEN
		SELECT CONCAT('artista>',v_nifArt,':',v_nombreArt,':',v_apellArt,'>  SIN JEFE');
	#Resto de casos
   	ELSE
		SELECT CONCAT('artista>',v_nifArt,':',v_nombreArt,':',v_apellArt,'-jefe>',v_nifJefe,':',v_nombreJefe,':',v_apellJefe);
    END IF;
END$$

CALL artistas_getPorNif('11111111A');	-- Artista con jefe
CALL artistas_getPorNif('22222222B');	-- Artista sin jefe
CALL artistas_getPorNif('22222222X');  -- No existe Artista

# Ejemplo Teoría 2

# Crea un procedimiento de nombre utilidades_getDia al que se le pase como parámetro un número entre 1 y 7 y devuelva, en forma de parámetro de salida, Lunes, Martes, Miércoles,....
# En caso de que el número esté fuera de rango debe devolver la cadena null.

USE CIRCO;
DROP PROCEDURE IF EXISTS utilidades_getDia;
DELIMITER $$
CREATE PROCEDURE utilidades_getDia(p_numDia tinyint, OUT p_nombreDia varchar(9))		
BEGIN
		CASE p_numDia
			WHEN 1 THEN 
				SET p_nombreDia = 'LUNES';
			WHEN 2 THEN 
				SET p_nombreDia = 'MARTES';
			WHEN 3 THEN 
				SET p_nombreDia = 'MIERCOLES';
			WHEN 4 THEN 
				SET p_nombreDia = 'JUEVES';
			WHEN 5 THEN 
				SET p_nombreDia = 'VIERNES';
			WHEN 6 THEN 
				SET p_nombreDia = 'SABADO';
			WHEN 7 THEN 
				SET p_nombreDia = 'DOMINGO';
            ELSE
				SET p_nombreDia = null;
        END CASE;
END$$
DELIMITER ;

CALL utilidades_getDia(3,@nombreDia);    -- Devuelve MIERCOLES
SELECT @nombreDia;

CALL utilidades_getDia(20,@nombreDia);   -- Devuelve NULL
SELECT @nombreDia;

#### EJERCICIOS IF/ELSE #######


#1 Crea un procedimiento de nombre pistas_getListAnimales que devuelva los animales (nombre, peso y anhos) que trabajen en la pista indicada. 
#En caso de que no haya animales deberá devolver SIN ANIMALES y en el caso de que no exista la pista, ESA PISTA NO EXISTE.

DROP PROCEDURE IF EXISTS pistas_getListAnimales;
DELIMITER $$
CREATE PROCEDURE pistas_getListAnimales (IN p_pista VARCHAR(50))
BEGIN
	IF ((SELECT nombre FROM pistas WHERE  nombre=p_pista) IS NULL) THEN SELECT "ESA PISTA NO EXISTE"; 
	ELSEIF((SELECT count(*) FROM animales WHERE nombre_pista=p_pista)=0) THEN  SELECT "SIN ANIMALES";
    ELSE SELECT nombre, peso, anhos FROM animales WHERE nombre_pista=p_pista;
    END IF;
END $$
DELIMITER ;

SELECT nombre FROM pistas WHERE  nombre="La grande";
CALL pistas_getListAnimales("LATERAL2");

#2.Crea un procedimiento de nombre atracciones_getNumeroPorFecha que devuelva el número de atracciones que se celebraron en la fecha indicada. En caso de que no hubiera atracciones ese día debe devolver el número -1.
#Haz dos variantes de este ejercicio. Una en la que la información se devuelva en un SELECT y otra en la que se emplee un parámetro de salida.
#Nota: Como comenté antes, el devolver -1 sería el 'valor' que un programador chequearía en la aplicación cliente y en base a ese valor mostraría un mensaje al usuario.

#Variante donde la info se devuelve en un select

DROP PROCEDURE IF EXISTS atracciones_getNumeroPorFecha;
DELIMITER $$
CREATE PROCEDURE atracciones_getNumeroPorFecha (IN p_fecha DATE)
BEGIN
	IF ((SELECT fecha FROM atraccion_dia WHERE  fecha=p_fecha) IS NULL) THEN SELECT -1; 
	ELSE 
		SELECT COUNT(fecha) FROM atraccion_dia WHERE fecha=p_fecha;
    END IF;
END $$
DELIMITER ;

CALL atracciones_getNumeroPorFecha("2005-04-01");

#Variante donde se emplea un parámetro de salida

DROP PROCEDURE IF EXISTS atracciones_getNumeroPorFecha2;
DELIMITER $$
CREATE PROCEDURE atracciones_getNumeroPorFecha2(IN p_fecha DATE, OUT p_numAtracciones INTEGER)
BEGIN
	IF ((SELECT fecha FROM atraccion_dia WHERE  fecha=p_fecha) IS NULL) THEN SELECT -1 INTO p_numAtracciones; 
	ELSE 
		SELECT COUNT(*) INTO p_numAtracciones FROM atraccion_dia WHERE fecha=p_fecha;
    END IF;
END $$
DELIMITER ;

CALL atracciones_getNumeroPorFecha2("2001-04-01",@numAtracciones);

SELECT @numAtracciones;


#3. Crea un procedimiento de nombre animales_updateCuidador al que se le pase el nombre de un animal y si dicho animal no está cuidado por un artista (table ANIMALES_ARTISTAS) 
# deben ser asignados al cuidador que cuide a menos animales. El procedimiento debe devolver con un parámetro de salida el nif del cuidador al que se le ha asignado al animal 
# y en forma de registro (con un SELECT) a cuantos animales está cuidando, contando el actual, tiene asignados el cuidador. 
# En caso de que el animal no exista, el nif tendrá de valor y el select mandará -1. En caso de que ya tenga cuidador, se devolverá el nif del cuidador actual y 0 en el SELECT.
# Como un mismo animal puede ser cuidado por varios artistas, recuerda emplear LIMIT para coger el primero...
# Añade un animal que no tenga asignado un artista.

DROP PROCEDURE IF EXISTS animales_updateCuidador;
DELIMITER $$
CREATE PROCEDURE animales_updateCuidador(IN p_nombreAnimal VARCHAR(50), OUT p_NIFCuidador CHAR(9))
BEGIN
	# Si el animal no existe
	IF((SELECT nombre FROM animales WHERE nombre=p_nombreAnimal) IS NULL) 
    THEN 
		SET p_NIFCuidador=0;
        SELECT -1;
	# Si el animal no está cuidado por ningún artista
    ELSEIF ((SELECT nif_artista FROM animales_artistas WHERE nombre_animal=p_nombreAnimal LIMIT 1) IS NULL) 
    THEN 
        #Busco el cuidador que tiene menos animales y se lo asigno al parametro p_NIFCuidador 
        SELECT nif_artista INTO p_NIFCuidador FROM animales_artistas GROUP BY nif_artista
	HAVING COUNT(*) =(SELECT COUNT(nif_artista) FROM animales_artistas GROUP BY nif_artista ORDER BY 1 LIMIT 1);
        
        #Insertamos el animal y el cuidador que tiene menos animales
        INSERT INTO `circo`.`animales_artistas` (`nombre_animal`, `nif_artista`) VALUES (p_nombreAnimal, p_NIFCuidador);

		# SELECT que devuelve cuantos animales está cuidando, contando el actual, tiene asignados el cuidador
		SELECT COUNT(*) FROM animales_artistas WHERE nif_artista=p_NIFCuidador;
        
	# Si el animal existe y tiene cuidador, devolvemos el cuidador. Limitamos con LIMIT 1 por si tiene más de uno
	ELSEIF ((SELECT nif_artista FROM animales_artistas WHERE nombre_animal=p_nombreAnimal LIMIT 1) IS NOT NULL and (SELECT nombre FROM animales WHERE nombre=p_nombreAnimal LIMIT 1) IS NOT NULL) 
	THEN
		SELECT nif_artista INTO p_NIFCuidador FROM animales_artistas WHERE nombre_animal=p_nombreAnimal LIMIT 1;
        SELECT 0;
    END IF;
END $$
DELIMITER ;

# Si el animal no existe
CALL animales_updateCuidador('Leon',@NIF_CUIDADOR);
SELECT @NIF_CUIDADOR;
# Si el animal existe y tiene cuidador
CALL animales_updateCuidador('Leo',@NIF_CUIDADOR);
SELECT @NIF_CUIDADOR;

# Si el animal no está cuidado por ningún artista. Primero creo el animal Princesa 3
CALL animales_updateCuidador('Princesa3',@NIF_CUIDADOR);
SELECT @NIF_CUIDADOR;



######### INSTRUCCIONES REPETITIVAS ##########

# Ejemplo teoria 1 #### REPEAT

# Crear un procedimiento de nombre utilidades_getSumEntreNumeros que sume los números entre un rango 
# indicado por dos parámetros de entrada (incluidos ambos) y devuelva la suma en un parámetro de salida.
# En el caso de que el primer parámetro tenga un valor superior al segundo, se debe devolver -1 y mostrar la cadena EL PRIMER NUMERO TIENE QUE SER INFERIOR AL SEGUNDO.

DROP PROCEDURE IF EXISTS utilidades_getSumEntreNumeros;
DELIMITER $$
CREATE PROCEDURE utilidades_getSumEntreNumeros(p_primerNumero int,p_segundoNumero int, out p_suma int)
BEGIN
	#Iniciamos a cero el parametro de salida, ya que inicialmente es null
	SET p_suma=0;
	IF(p_primerNumero>p_segundoNumero) THEN
		SET p_suma=-1;
		SELECT "EL PRIMER NUMERO TIENE QUE SER INFERIOR AL SEGUNDO";
	ELSE
			#Similar a un while
			REPEAT
				SET p_suma = p_suma + p_primerNumero;
				SET p_primerNumero = p_primerNumero + 1;
			UNTIL p_primerNumero > p_segundoNumero
			END REPEAT;
	END IF;
END $$
DELIMITER ;

CALL utilidades_getSumEntreNumeros(3,50,@suma);
SELECT @suma;

CALL utilidades_getSumEntreNumeros(60,1,@suma);		-- Mostrará el mensaje de error
SELECT @suma;


# Ejemplo teoria 2 #### REPEAT

# Crear un procedimiento de nombre utilidades_getSumEntreNumerosPares que sume los números pares entre un rango indicado por dos parámetros 
# de entrada (incluidos ambos) y devuelva la suma en un parámetro de salida. En caso de que la suma sea superior a 120000 debe devolver 120000 y salir del bucle.
# Deberás considerar el caso de que se envíen los números un cualquier orden.
# Para obtener el resto de dividir por 2 y saber si es par puedes hacer uso del operador % o MOD.

DROP PROCEDURE IF EXISTS utilidades_getSumEntreNumerosPares;
DELIMITER $$
CREATE PROCEDURE utilidades_getSumEntreNumerosPares(IN p_primerNumero int,IN p_segundoNumero int, out p_suma int)
BEGIN

#Iniciamos a cero el parametro de salida, ya que inicialmente es null
SET p_suma=0;

#Si el primer número es menor que el segundo
IF(p_primerNumero<p_segundoNumero) THEN
	#Similar a un while
		label_repeat: REPEAT
				#Si es par se suma
				IF(p_primerNumero % 2 = 0) THEN
					SET p_suma = p_suma + p_primerNumero;
				END IF;
                #Se va incrementando el valor del menor número siempre
            SET p_primerNumero = p_primerNumero + 1;
				#Si la suma es mayor que 1200, será 12000 y se sale del bucle
				IF (p_suma>120000) THEN
					SET p_suma = 120000;
					LEAVE label_repeat;
				END IF;
			#El bucle gira hasta que el primer número sea mayor que el segundo
		UNTIL p_primerNumero > p_segundoNumero
		END REPEAT;
#Si el segundo número es menor que el primero, lo mismo que arriba pero tomando al número menor al segundo
ELSE
		label_repeat: REPEAT
				IF(p_segundoNumero % 2 = 0) THEN
					SET p_suma = p_suma + p_segundoNumero;
				END IF;
            SET p_segundoNumero = p_segundoNumero + 1;
				IF (p_suma>120000) THEN
					SET p_suma = 120000;
					LEAVE label_repeat;
				END IF;
		UNTIL p_segundoNumero > p_primerNumero
		END REPEAT;
	
END IF;
END $$
DELIMITER ;

CALL utilidades_getSumEntreNumerosPares(8,13000,@suma);  -- Se pasa. Da 120.000
SELECT @suma;

CALL utilidades_getSumEntreNumerosPares(8,12,@suma);  -- Da 8+10+12=30
SELECT @suma;

CALL utilidades_getSumEntreNumerosPares(12,8,@suma); 
SELECT @suma;

# Ejemplo teoria 3 ######## WHILE 

# Crea un procedimiento de nombre atracciones_getNumPorMes al que se le pase dos datos: un mes en letra (ENERO, FEBRERO,....) y un año en número. 
# Tendrá que calcular la suma de todas las atracciones celebradas en el mes y año indicado y devolver el dato en un parámetro de salida. En el caso de que el año indicado sea null, tomar el año actual.
# Crea un bucle que recorra todos los días del mes del año indicado y vaya sumando las atracciones.
# Si el mes no existe debe devolver -1 en el parámetro de salida.
# Para 'construír' la fecha emplear la función CONCAT. Debéis de tener en cuenta que hay meses en los que no hay 31 días. En vez de establecer condiciones por meses, 
# emplear la función DATE (ya vista antes) para comprobar si la fecha es válida.

USE CIRCO;
DROP PROCEDURE IF EXISTS atracciones_getNumPorMes;
DELIMITER $$
CREATE PROCEDURE atracciones_getNumPorMes(p_mes varchar(10),p_ano smallint, OUT p_numAtracciones int)		
label_proc: BEGIN
    DECLARE v_mesEnNumero tinyint default 0;
    DECLARE v_dia tinyint default 1;	-- Día del mes. Usado para hacer el bucle hasta el día 31
    DECLARE v_numAtraccPorDia int;

	#Iniciamos a cero el parametro de salida, ya que inicialmente es null
    SET p_numAtracciones = 0;		
    
    CASE p_mes
        WHEN 'ENERO' THEN SET v_mesEnNumero = 1;
        WHEN 'FEBRERO' THEN	SET v_mesEnNumero = 2;
        WHEN 'MARZO' THEN SET v_mesEnNumero = 3;
        WHEN 'ABRIL' THEN SET v_mesEnNumero = 4;
        WHEN 'MAYO' THEN SET v_mesEnNumero = 5;
        WHEN 'JUNIO' THEN SET v_mesEnNumero = 6;
        WHEN 'JULIO' THEN SET v_mesEnNumero = 7;
        WHEN 'AGOSTO' THEN SET v_mesEnNumero = 8;
        WHEN 'SEPTIEMBRE' THEN SET v_mesEnNumero = 9;
        WHEN 'OCTUBRE' THEN SET v_mesEnNumero = 10;
        WHEN 'NOVIEMBRE' THEN SET v_mesEnNumero = 11;
        WHEN 'DICIEMBRE' THEN SET v_mesEnNumero = 12;
        ELSE 
			# Si el mes no existe debe devolver -1 en el parámetro de salida y sale del procedimiento.
            SET p_numAtracciones = -1;
            LEAVE label_proc;       
    END CASE;
    
    # Si el año es null se toma el actual.
    IF (p_ano IS NULL) THEN
        SET p_ano = YEAR(curdate());
    END IF;
    
    bucle_dia: WHILE (v_dia <= 31) DO
		#Los dias se van incrementando desde 1. En el momento que la fecha no sea válida, se sale del while
        IF (DATE(CONCAT(p_ano,'-',v_mesEnNumero,'-',v_dia)) IS NULL) THEN 
            LEAVE bucle_dia;
        END IF;
        
        #Consulta que cuenta las atracciones que hay en un día y las mete en la variable v_numAtraccPorDia
        SELECT COUNT(*)
        INTO v_numAtraccPorDia
        FROM ATRACCION_DIA
        WHERE fecha = CONCAT(p_ano,'-',v_mesEnNumero,'-',v_dia);
        
        #Sumatorio que va incrementando el día
        SET v_dia = v_dia+1;
        #Sumatorio que va incrementando el parámetro de salida
        SET p_numAtracciones = p_numAtracciones + v_numAtraccPorDia;
    END WHILE bucle_dia;

END $$
DELIMITER ;

CALL atracciones_getNumPorMes('ABRIL',2000,@numAtracciones);   -- Devuelve 2.  Podéis añadir nuevas entradas a la tabla para comprobar el funcionamiento.
SELECT @numAtracciones;

CALL atracciones_getNumPorMes('NO EXISTE',2000,@numAtracciones);   -- Devuelve -1. 
SELECT @numAtracciones;

CALL atracciones_getNumPorMes('ABRIL',NULL,@numAtracciones);   -- Buscar en el año actual
SELECT @numAtracciones;
            

# Ejemplo teoria 3 ######## LOOP 

# Crea un procedimiento de nombre utilidades_cambiarFormato al que se le pase un dato en forma de cadena y devuelva en el mismo parámetro 
# la cadena enviada cambiando las letras por números y separados por un guion.
# Para pasar de letra a número emplea la función ORD.
# Para recorrer la cadena carácter a carácter puedes hacer uso de las funciones LEFT y RIGHT o de la función SUBSTRING (más fácil) además de la función CHAR_LENGTH.

USE CIRCO;
DROP PROCEDURE IF EXISTS utilidades_cambiarFormato;
DELIMITER $$
CREATE PROCEDURE utilidades_cambiarFormato(INOUT p_cadena varchar(1000))		
BEGIN
    DECLARE v_indice smallint default 1;   -- Empleado para recorrer la cadena caracter a caracter
    DECLARE v_caracter char(1);            -- Guarda el caracter de la cadena
    
    # Variable local que será la cadena a devolver. Debemos poner un default para poder concatenar
    DECLARE v_cadena varchar(1000) default '';        
    
    bucle_loop: LOOP
		# Coge caracter a caracter
        SET v_caracter = SUBSTRING(p_cadena,v_indice,1);
        # Concatena y convierte a número cada caracter
        SET v_cadena = CONCAT(v_cadena,ORD(v_caracter),'-');	

        SET v_indice = v_indice+1;
        # Cuando el v_indice sea mayor que la longitud de la cadena, sale del bucle
        IF (v_indice > CHAR_LENGTH(p_cadena)) THEN   
            LEAVE bucle_loop;
        END IF;
    END LOOP bucle_loop;
    
    # Al finalizar el bucle, le damos el valor de v_cadena al parámetro de salida
    SET p_cadena = v_cadena;

END $$
DELIMITER ;

SET @dato = 'ANGEL';
CALL utilidades_cambiarFormato(@dato);
SELECT @dato;


# Ejercicios propuestos instrucciones repetitivas

#Ejercicio 1

# Crea un procedimiento de nombre pistas_getSumAforo que devuelva en forma de parámetro de salida la suma de los aforos de las pistas enviadas como parámetro. 
# El formato de la lista de pistas es una única cadena: 'pista1,pista2,pista3,....'
# Deberás, empleando la función SUBSTRING y LOCATE, descomponer el dato en cada una de las pistas y buscar el aforo de cada una de ellas, devolviendo la suma de los aforos de todas.
# En caso de que alguna pista no exista, deberás de mostrar la cadena 'La pista ZZZZZZ no existe' por cada pista que no exista.
# Debemos de controlar que al menos siempre se envíe una pista. En caso contrario debe de enviarse -1 en el parámetro de salida (emplea la función CHAR_LENGTH).

DROP PROCEDURE IF EXISTS pistas_getSumAforo;
DELIMITER $$
CREATE PROCEDURE pistas_getSumAforo(IN p_pistas varchar(100),OUT p_sumaAforo int)
# Se añade una etiqueta para poder salir del procedimiento, según que condiciones  
label_getSumAforo: BEGIN
    DECLARE v_index,v_pos smallint default 1;
    DECLARE v_aforo smallint;   
    DECLARE v_nombrePista varchar(50);	

	#Inicializamos el parámetro de salida
    SET p_sumaAforo = 0;		
    
    # Si la longitud es cero, se devuelve -1 y se sale del bucle
    IF (CHAR_LENGTH(p_pistas)=0) THEN
        SET p_sumaAforo = -1;
        LEAVE label_getSumAforo;
    END IF;
    
    WHILE (v_pos != 0) DO 
    # La función LOCATE devuelve 0 si no encuentra la ',' en p_pistas, desde v_index
        SELECT LOCATE(',',p_pistas,v_index)
        INTO v_pos;
        
        # Si encuentra una coma, la posición es distinta de 0
        IF (v_pos != 0) THEN
			# Consulta que selecciona una palabra desde primera ',' a la siguiente 
            SELECT SUBSTRING(p_pistas,v_index,v_pos-v_index)
            INTO v_nombrePista;
            
            set v_index = v_pos+1;
        ELSE    -- Bucle final que hara cuando no encuentre ',' que será la última pista
            SELECT SUBSTRING(p_pistas,v_index)
            INTO v_nombrePista;
        END IF;
        
        SET v_aforo = null; #Si la pista no existe el valor de la variable seguirá valiendo NULL

        SELECT aforo
        INTO v_aforo
        FROM PISTAS
        WHERE nombre = v_nombrePista;
        
        #Si el aforo es null, es que la pista no existe
        IF (v_aforo IS NULL) THEN 	
            SELECT CONCAT('La pista ',v_nombrePista,' no existe');
        ELSE
        # Si el aforo es distinto de null, se va incluyendo en un sumatorio
            SET p_sumaAforo = p_sumaAforo + v_aforo;
        END IF;
    END WHILE;
END $$
DELIMITER ;

# Ejemplo de uso:
CALL pistas_getSumAforo('LATERAL1,LATERAL2,NO EXISTE',@aforo);  -- Una de las pistas no existe
SELECT @aforo;

CALL pistas_getSumAforo('SUPER',@aforo);   -- Devuelve el aforo de SUPER
SELECT @aforo;

CALL pistas_getSumAforo('',@aforo);   -- Devuelve -1
SELECT @aforo;


# Ejercicio 2
# Crea un procedimiento de nombre atracciones_getGananciasSupuestas en el que se le pase como datos el nombre de una atracción y 2 números. 
# Deberá de mostrar los días en los que se celebró la atracción junto con su número de espectadores y ganancia así como las ganancias que tendríamos si la entrada costara diferentes precios. 
# Los precios deben variar desde el primer número enviado hasta el segundo, con una diferencia de 5 euros entre ellos. 
# Es decir, si envío los datos 'pista1',20,30 deberá mostrar que ganancia tenemos con un precio de entrada de 20,25 y 30 
# (se debe mostrar cada precio en una nueva consulta, es decir, una consulta mostrará 'atraccion1', 100, 3000 (estos serían los datos actuales), 
# 20x100 (con un precio de 20 euros por entrada), la siguiente consulta debe mostrar lo mismo pero con 25x100 y la tercera consulta debe mostrar lo mismo pero 30x100).
# Debes controlar que los números enviados sean múltiplo de 5 y que el segundo es mayor que el primero. Si no se cumplen las condiciones, debe mostrar un texto aclarando el error.
# En caso de que la atracción no exista o que la atracción existe pero no ha tenido representaciones, también debe informar del error.

USE CIRCO;
DROP PROCEDURE IF EXISTS atracciones_getGananciasSupuestas;
DELIMITER $$
CREATE PROCEDURE atracciones_getGananciasSupuestas (p_nombreAtraccion varchar(50),p_precioInferior tinyint, p_precioSuperior tinyint)		
label_getGananciasSupuestas: BEGIN
    DECLARE v_precio tinyint default 0;
    DECLARE v_atraccionExiste tinyint;	-- Para comprobar si la atraccion existe

    SELECT COUNT(*)		-- Comprobamos si la atraccion existe
    INTO v_atraccionExiste
    FROM ATRACCIONES
    WHERE nombre = p_nombreAtraccion;
    IF (v_atraccionExiste=0) THEN
        SELECT 'La atracción no existe';
        LEAVE label_getGananciasSupuestas; 
    END IF;

    SELECT COUNT(*)		-- Comprobamos si tiene alguna atraccion
    INTO v_atraccionExiste
    FROM ATRACCION_DIA
    WHERE nombre_atraccion = p_nombreAtraccion;
    IF (v_atraccionExiste=0) THEN
        SELECT 'La atracción no ha celebrado ninguna actuación';
        LEAVE label_getGananciasSupuestas; 
    END IF;

    IF (p_precioInferior > p_precioSuperior) THEN
        SELECT 'El precio inferior no puede ser superior al segundo número';
        LEAVE label_getGananciasSupuestas;
    END IF;
    IF ((p_precioInferior % 5)!=0 OR (p_precioSuperior%5)!=0) THEN
        SELECT 'Los dos números deben ser múltiplos de 5';
        LEAVE label_getGananciasSupuestas;
    END IF;
    
    SET v_precio = p_precioInferior;
    REPEAT
        SELECT nombre_atraccion, num_espectadores, ganancias, num_espectadores*v_precio as gananciaSimulada
        FROM ATRACCION_DIA
        WHERE nombre_atraccion = p_nombreAtraccion;
        
        SET v_precio = v_precio + 5;    
    UNTIL v_precio > p_precioSuperior
    END REPEAT;
END $$
DELIMITER ;

CALL atracciones_getGananciasSupuestas('El orangután',12,20);  -- Muestra mensaje de error ya que los precios no son múltiplos de 5
CALL atracciones_getGananciasSupuestas('El orangután',10,20);  -- Muestra mensaje de error ya que esa atracción no se ha celebrado nunca.
CALL atracciones_getGananciasSupuestas('El gran felino',10,20);  -- Muestra tres pestañas cada una con todas las celebraciones y ganancias simuladas


# Ejercicio 3
# Crea un procedimiento de nombre utilidades_getNumImpares al que se le pasen tres números y devuelva en forma de parámetro de salida cuanto números 
# hay entre los dos primeros números que son divisibles por el tercero. Se deben incluir los dos primeros números a la hora de contar.

DROP PROCEDURE IF EXISTS utilidades_getNumImpares;
DELIMITER $$
CREATE PROCEDURE utilidades_getNumImpares (p_numero1 int, p_numero2 int,p_multiplo int, OUT p_numMultiplos int)		
    COMMENT 'Muestra cuanto números múltiplos por el tercer número hay entre los dos primeros (incluidos los dos números enviados)'
BEGIN
    DECLARE v_temporal int default 0;
    
    IF (p_numero1 > p_numero2) THEN		-- Intercambiamos los números si el segundo es inferior al primero
        SET v_temporal = p_numero2;
        SET p_numero2 = p_numero1;
        SET p_numero1 = v_temporal;
    END IF;
    
    SET p_numMultiplos = 0;
    
    etiqueta_bucle: LOOP	-- Probamos con LOOP. Valdría WHILE o REPEAT
		# Si es multipo del multiplo, se incrementa el número de mútiplos
        IF (p_numero1%p_multiplo=0) THEN 
            SET p_numMultiplos = p_numMultiplos + 1;
        END IF;
        SET p_numero1 = p_numero1 + 1;
        # Cuando el primer número es mayor que el segundo, se sale del bucle
        IF (p_numero1 > p_numero2) THEN
            LEAVE etiqueta_bucle;
        END IF;
    END LOOP;
END $$
DELIMITER ;

CALL utilidades_getNumImpares(5,1,3,@numMultiplos);-- Busca múltiplos de 3
SELECT @numMultiplos;

CALL utilidades_getNumImpares(25,2,2,@numMultiplos);   -- Busca múltiplos de 2
SELECT @numMultiplos;


############ TRIGGERS ###############



