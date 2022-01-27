drop database if exists juegos_online;
create database if not exists juegos_online charset utf8;
use juegos_online;
/*TABLA USUARIOS*/
CREATE TABLE USUARIOS (
         login         VARCHAR(15) PRIMARY KEY NOT NULL,  
         password      VARCHAR(9) NOT NULL, 
         nombre        VARCHAR(25) NOT NULL,
         apellidos     VARCHAR(30) NOT NULL,
         direccion     VARCHAR(30) NOT NULL,
         cp            VARCHAR(5) NOT NULL, 
         localidad     VARCHAR(25) NOT NULL,
         provincia     VARCHAR(25) NOT NULL,
         pais          VARCHAR(15) NOT NULL, 
         f_nac      DATE,
         f_ing      DATE,
         correo     VARCHAR(25) NOT NULL,
         credito    INTEGER,
         sexo       VARCHAR(1));
/*TABLA JUEGOS*/
         CREATE TABLE JUEGOS(
       codigo VARCHAR(15) PRIMARY KEY NOT NULL,  
         nombre        VARCHAR(15) NOT NULL,
         descripcion   VARCHAR(200) NOT NULL);
/*TABLA PARTIDAS*/
         CREATE TABLE PARTIDAS(
         codigo        VARCHAR(15) PRIMARY KEY NOT NULL,  
         nombre        VARCHAR(25) NOT NULL,
         estado        VARCHAR(1) NOT NULL,
         cod_juego     VARCHAR(15) NOT NULL,
         fecha_inicio  DATE, 
         hora_inicio   TIMESTAMP,
         cod_creador   VARCHAR(15),
         CONSTRAINT CA_cod_juego foreign key(cod_juego) references JUEGOS(codigo),
         CONSTRAINT CA_cod_creador foreign key (cod_creador) REFERENCES USUARIOS(login));
/*TABLA UNEN*/
		CREATE TABLE UNEN(
        codigo_partida VARCHAR(15) NOT NULL,  
        codigo_usuario VARCHAR(15) NOT NULL,
        CONSTRAINT CA_codigo_partida foreign key (codigo_partida) REFERENCES PARTIDAS(codigo),
		CONSTRAINT CA_codigo_usuario foreign key (codigo_usuario) REFERENCES USUARIOS(login),
        CONSTRAINT PK_UNEN primary key (codigo_partida, codigo_usuario));

        /*ALTER SESSION SET NLS_DATE_FORMAT='MM/DD/YYYY';*/
INSERT INTO USUARIOS VALUES('anamat56','JD9U6?','ANA M.','MATA VARGAS','GARCILASO DE LA VEGA','8924','SANTA COLOMA DE GRAMANET','BARCELONA','ESPAÑA','1974/08/25','2007/10/10','anamat56@hotmail.com',213,'M');
INSERT INTO USUARIOS VALUES('alecam89','5;5@PK','ALEJANDRO EMILIO','CAMINO LAZARO','PEDRO AGUADO BLEYE','34004','PALENCIA','PALENCIA','ESPAÑA','1976/03/05','2010/10/15','alecam89@hotmail.com',169,'H');
INSERT INTO USUARIOS VALUES('verbad64','MP49HF','VERONICA','BADIOLA PICAZO','BARRANCO GUINIGUADA','35015','PALMAS GRAN CANARIA,LAS','PALMAS (LAS)','ESPAÑA','1984/04/28','2010/10/23','verbad64@hotmail.com',437,'M');
INSERT INTO USUARIOS VALUES('conmar76','O1<N9U','CONSUELO','MARTINEZ RODRIGUEZ','ROSA','4002','ALMERÍA','ALMERÍA','ESPAÑA','1978/09/18','2007/10/25','conmar76@yahoo.com',393,'M');
INSERT INTO USUARIOS VALUES('encpay57','FYC3L5','ENCARNACIÓN','PAYO MORALES','MULLER,AVINGUDA','43007','TARRAGONA','TARRAGONA','ESPAÑA','1993/04/05','1993/06/10','encpay57@yahoo.com',318,'M');
INSERT INTO USUARIOS VALUES('mandia79','00JRIH','MANUELA','DIAZ COLAS','214 (GENOVA)','7015','PALMA DE MALLORCA','BALEARES','ESPAÑA','1979/7/14','2008/07/16','mandia79@hotmail.com',255,'M');
INSERT INTO USUARIOS VALUES('alibar52','IER8S','ALICIA MARIA','BARRANCO CALLIZO','HECTOR VILLALOBOS','29014','MÁLAGA','MÁLAGA','ESPAÑA','1993/08/21','2010/09/19','alibar52@hotmail.com',486,'M');
INSERT INTO USUARIOS VALUES('adofid63',';82=MH','ADOLFO','FIDALGO DIEZ','FORCALL','12006','CASTELLÓN DE LA PLANA','CASTELLÓN','ESPAÑA','1981/08/11','2008/03/02','adofid63@gmail.com',154,'H');
INSERT INTO USUARIOS VALUES('jesdie98','X565ZS','JESUS','DIEZ GIL','TABAIBAL','35213','TELDE','PALMAS (LAS)','ESPAÑA','1981/10/23','2009/09/13','jesdie98@gmail.com',152,'H');
INSERT INTO USUARIOS VALUES('pedsan70','T?5=J@','PEDRO','SANCHEZ GUIL','PINTOR ZULOAGA','3013','ALACANT/ALICANTE','ALICANTE','ESPAÑA','1983/12/01','2008/06/15','pedsan70@yahoo.com',21,'H');
INSERT INTO USUARIOS VALUES('diahue96','LSQZMC','DIANA','HUERTA VALIOS','JOAQUIN SALAS','39011','SANTANDER','CANTABRIA','ESPAÑA','1984/04/25','2009/07/31','diahue96@yahoo.com',395,'M');
INSERT INTO USUARIOS VALUES('robrod74','<LQMLP','ROBERTO','RODRIGUEZ PARMO','CASTILLO HIDALGO','51002','CEUTA','CEUTA','ESPAÑA','1978/06/28','2009/03/16','robrod74@gmail.com',486,'H');
INSERT INTO USUARIOS VALUES('milgar78','SF=UZ8','MILAGROSA','GARCIA ELVIRA','PEDRALBA','28037','MADRID','MADRID','ESPAÑA','1983/12/19','2008/05/15','milgar78@gmail.com',330,'M');
INSERT INTO USUARIOS VALUES('frabar93','19JZ7@','FRANCISCA','BARRANCO RODRIGUEZ','BALSAS, LAS','26006','LOGROÑO','RIOJA (LA)','ESPAÑA','1986/09/21','2008/02/16','frabar93@gmail.com',75,'M');
INSERT INTO USUARIOS VALUES('migarc93','AAFLTW','MIGUEL ANGEL','ARCOS ALONSO','ISAAC ALBENIZ','4008','ALMERÍA','ALMERÍA','ESPAÑA','1991/03/01','2010/06/16','migarc93@hotmail.com',23,'H');

/*TABLA JUEGOS*/

INSERT INTO JUEGOS VALUES('1','Parchís','El parchís es un juego de mesa derivado del pachisi y similar al ludo y al parcheesi');
INSERT INTO JUEGOS VALUES('2','Oca','El juego de la oca es un juego de mesa para dos o más jugadores');
INSERT INTO JUEGOS VALUES('3','Ajedrez','El ajedrez es un juego entre dos personas, cada una de las cuales dispone de 16 piezas móviles que se colocan sobre un tablero dividido en 64 escaques');
INSERT INTO JUEGOS VALUES('4','Damas','Las damas es un juego de mesa para dos contrincantes');
INSERT INTO JUEGOS VALUES('5','Poker','El póquer es un juego de cartas de los llamados de "apuestas"');
INSERT INTO JUEGOS VALUES('6','Chinchón','El chinchón es un juego de naipes de 2 a 8 jugadores');
INSERT INTO JUEGOS VALUES('7','Mus','El mus es un juego de naipes, originario de Navarra, que en la actualidad se encuentra muy extendido por toda España');
INSERT INTO JUEGOS VALUES('8','Canasta','La canasta o rummy-canasta es un juego de naipes, variante del rummy');
INSERT INTO JUEGOS VALUES('9','Dominó','El dominó es un juego de mesa en el que se emplean unas fichas rectangulares');
INSERT INTO JUEGOS VALUES('10','Pocha','La pocha es un juego de cartas que se juega con la baraja española');
INSERT INTO JUEGOS VALUES('11','Backgammon','Cada jugador tiene quince fichas que va moviendo entre veinticuatro triángulos (puntos) según el resultado de sus dos dados');
INSERT INTO JUEGOS VALUES('12','Billar','El billar es un deporte de precisión que se practica impulsando con un taco un número variable de bolas');

/*TABLA PARTIDAS*/

INSERT INTO PARTIDAS (codigo, nombre, estado, cod_juego,cod_creador)
VALUES('1','Billar_migarc93_18/7','1','12','migarc93'),
('2','Chinchón_mandia79_2/10','1','6','mandia79'),
('3','Canasta_alibar52_26/2','0','8','alibar52'),
('4','Damas_verbad64_16/3','1','4','verbad64'),
('5','Chinchón_alibar52_9/9','1','6','alibar52'),
('6','Oca_pedsan70_21/12','0','2','pedsan70'),
('7','Canasta_encpay57_18/2','0','8','encpay57'),
('8','Pocha_adofid63_26/10','1','10','adofid63'),
('9','Damas_diahue96_25/6','1','4','diahue96'),
('10','Parchís_encpay57_31/7','1','1','encpay57');


/*TABLA UNEN*/

INSERT INTO UNEN VALUES('4','anamat56');
INSERT INTO UNEN VALUES('3','alecam89');
INSERT INTO UNEN VALUES('6','alecam89');
INSERT INTO UNEN VALUES('2','conmar76');
INSERT INTO UNEN VALUES('2','encpay57');
INSERT INTO UNEN VALUES('2','mandia79');
INSERT INTO UNEN VALUES('4','alibar52');
INSERT INTO UNEN VALUES('3','adofid63');
INSERT INTO UNEN VALUES('5','jesdie98');
INSERT INTO UNEN VALUES('8','pedsan70');
INSERT INTO UNEN VALUES('6','diahue96');
INSERT INTO UNEN VALUES('4','robrod74');
INSERT INTO UNEN VALUES('5','milgar78');
INSERT INTO UNEN VALUES('4','frabar93');
INSERT INTO UNEN VALUES('5','encpay57');

/*1 . Nombre y apellidos de los usuarios con crédito entre 200 y 400 ordenado por crédito descendente.*/

SELECT nombre, apellidos FROM usuarios WHERE credito BETWEEN 200 AND 400;

/*2. ¿Cuántos usuarios son mujeres?*/

SELECT COUNT(*) FROM usuarios WHERE sexo='M';

/*3. Nombre y apellidos de los usuarios que tiene correo en Hotmail ordenado por apellido y nombre.*/

SELECT nombre, apellidos FROM usuarios WHERE correo LIKE  '%hotmail.%' ORDER BY apellidos, nombre;

/*4. Suma del crédito de los usuarios de la provincia de Barcelona*/

SELECT SUM(credito) FROM usuarios WHERE provincia='Barcelona';

/*5. Nombre, apellidos y fecha de nacimiento del usuario de mas edad.*/

SELECT nombre, apellidos, f_nac FROM usuarios ORDER BY f_nac LIMIT 1;

/*6. Listado con la suma del crédito de los usuarios de cada una de las provincias ordenado por provincia.*/

SELECT SUM(credito), provincia FROM usuarios GROUP BY provincia;

/*7. Provincias en las que la suma del crédito de los usuarios es menos de 200.*/

SELECT SUM(credito), provincia FROM usuarios GROUP BY provincia HAVING SUM(credito)<200;

/*8. ¿Cuál es la provincia en la que la suma de crédito de los usuarios es la mayor de todas?*/

SELECT SUM(credito), provincia FROM usuarios GROUP BY provincia ORDER BY SUM(credito) DESC LIMIT 1;

select * from usuarios;