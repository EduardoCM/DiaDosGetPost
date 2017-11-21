create database HSBC;

use HSBC;

create table Cliente 
(
  id_cliente int primary key auto_increment,
  nombre VARCHAR(200),
  apellido_paterno VARCHAR(200),
  apellido_materno VARCHAR(200),
  email VARCHAR(200),  
  telefono VARCHAR(200)
);

INSERT INTO Cliente (nombre, apellido_paterno, apellido_materno, email, telefono) VALUES ("Eduardo", "Castillo", "Mendoza", "ecm3198@gmail.com", "5554740931");