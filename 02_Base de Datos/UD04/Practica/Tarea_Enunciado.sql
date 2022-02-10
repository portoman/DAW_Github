

DROP DATABASE IF EXISTS tarea04;
CREATE DATABASE tarea04 CHARSET utf8mb4;
USE tarea04;

/*
create user 'c##dpto';
grant connect, resource,DBA on tarea04 to 'c##dpto';
 CONNECT c##dpto/dpto;*/

CREATE TABLE CENTRO(
codcentro decimal(2) not null,
direccion varchar(30) not null,
localidad varchar(20) not null);

insert into centro values (01,'Rambla Nova','Tarragona');
insert into centro values (02,'Alcala','Madrid');
insert into centro values (03,'Sierpes','Sevilla');

alter table centro add constraint pk_codcentro primary key (codcentro);

CREATE TABLE DPTO(
coddpto decimal(2) not null,
denominacion varchar(20) not null,
codcentro decimal(2) not null,
coddptodepende decimal(2),
codemplejefe decimal(3) not null,
tipo char(1) not null ,
presupuesto decimal(8,2) not null);


insert into dpto values (01,'DIRECCIÓN',01,NULL,01,'P',100000);
insert into dpto values (02,'ADMINISTRACION',01,01,03,'F',50000);
insert into dpto values (03,'RECURSOS HUMANOS',01,01,05,'P',30000);
insert into dpto values (05,'CENTRAL COMERCIAL',01,01,07,'P',100000);
insert into dpto values (06,'COMERCIAL CENTRO',02,05,02,'F',5000);
insert into dpto values (07,'COMERCIAL SUR',03,05,04,'F',40000);

create table empleado(
 codemple decimal(3) not null,
 ape1 varchar(20) not null,
 ape2 varchar(20) not null,
 nombre varchar(15) not null,
 direccion varchar(25) not null,
 localidad varchar(25) not null,
 telef varchar(9),
 coddpto decimal(2) not null,
 codcate decimal(2) not null,
 fechaingreso date not null,
 salario decimal(6,2) not null,
 comision decimal(6,2)
 );

insert into empleado values (01,'LOPEZ','GARCIA','ANA','C/ ANAS','MADRID',666666666,01,01,'2000/02/01',3000,NULL);
insert into empleado values (02,'FERNANDEZ','MORON','JUAN','C/FUENTE','TARRAGONA',7777777,01,02,'2002/02/01',2000,NULL);
insert into empleado values (03,'CORTES','LOPEZ','ANGEL','C/CIFUENTES','BARACALDO',888888,02,01,'2003/03/01',2000,NULL);
insert into empleado values (04,'SANCHEZ','LUZ','FABIOLA','C/CARDON','SEVILLA',99999999,03,02,'2001/05/21',2500,NULL);
insert into empleado values (05,'RAJOY','AZNAR','PAZ','C/MAR','JAEN',88888888,03,01,'2000/02/23',2000,130);
insert into empleado values (06,'ZAPATERO','GALLARDON','ANGUSTIAS','C/SUR','MADRID', 78787878,05,03,'2000/02/01',2000,NULL);
insert into empleado values (07,'FLOR','LUZ','BLANCA','C/TECLA','SEVILLA',7777777,06, 01,'2000/02/01',3000,130);
insert into empleado values (08,'ROS','SANTON','ALFONSO','C/ LUZ','MADRID',888888,07,03,'2003/02/01',2000,NULL);
insert into empleado values (09,'LOPEZ','ITURRIALDE','GANDI','C/OASIS','TARRAGONA',777777,05,01,'1998/02/01',1500,210);
insert into empleado values (10,'JAZMIN','EXPOSITO','MARIA','C/MANDRAGORA','MADRID', 888888,05,03,'2001/03/01',1000,200);

alter table dpto add constraint pk_coddpto primary key (coddpto);
alter table dpto add constraint fk_codcentro foreign key(codcentro) references centro(codcentro);
alter table dpto add constraint fk_coddptodepende foreign key(coddptodepende) references dpto(coddpto);
alter table dpto add constraint chk_tipo check(tipo in('P','F'));
alter table empleado add constraint pk_codemple primary key(codemple);

alter table dpto add constraint fk_codemplejefe foreign key (codemplejefe)  references empleado(codemple);

alter table empleado add constraint fk_coddpto foreign key(coddpto) references dpto(coddpto);

create table categoria(
codcate decimal(2) not null,
denom varchar(20) not null,
julio decimal(6,2) not null,
diciembre decimal(6,2) not null
);

insert into categoria values (1,'ALTOS DIRECTIVOS',6000,5000);
insert into categoria values (2,'DIRECTIVOS',3000,2000);
insert into categoria values (3,'ADMINISTRATIVOS',2000,1500);

alter table categoria add constraint pk_codcate primary key(codcate);
alter table empleado add constraint fk_codcate foreign key(codcate) references categoria(codcate)