CREATE DATABASE juegosOnLine;
use juegosOnLine;

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
         f_ing      DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
         correo     VARCHAR(25) NOT NULL,
         credito    DECIMAL,
         sexo       VARCHAR(1));
         
CREATE TABLE JUEGOS(
         codigo        VARCHAR(15) PRIMARY KEY NOT NULL,  
         nombre        VARCHAR(15) NOT NULL,
         descripcion   VARCHAR(200) NOT NULL);
         
CREATE TABLE PARTIDAS(
         codigo        VARCHAR(15) PRIMARY KEY NOT NULL,  
         nombre        VARCHAR(25) NOT NULL,
         estado        VARCHAR(1) NOT NULL,
         cod_juego     VARCHAR(15) NOT NULL,
        CONSTRAINT CA_cod_juego FOREIGN KEY (cod_juego) REFERENCES JUEGOS(codigo),
         fecha_inicio  DATE, 
         hora_inicio   TIMESTAMP,
         cod_creador   VARCHAR(15), 
		CONSTRAINT CA_cod_creador FOREIGN KEY (cod_creador) REFERENCES USUARIOS(login));
        
        
        CREATE TABLE UNEN(
        codigo_partida VARCHAR(15) NOT NULL,
		CONSTRAINT CA_codigo_partida FOREIGN KEY (codigo_partida) REFERENCES PARTIDAS(codigo),  
        codigo_usuario VARCHAR(15) NOT NULL,
		CONSTRAINT CA_codigo_usuario FOREIGN KEY (codigo_usuario)REFERENCES USUARIOS(login),
        CONSTRAINT PK_UNEN primary key (codigo_partida, codigo_usuario));