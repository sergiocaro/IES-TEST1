DROP DATABASE IF EXISTS institutosMatricula;
CREATE DATABASE institutosMatricula CHARACTER SET utf8mb4;
USE institutosMatricula;

CREATE TABLE IF NOT EXISTS TInstituto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) not null,
    direccion VARCHAR(255) not null,
    localidad VARCHAR(100) not null,
    telefono VARCHAR(15) not null);
    
CREATE TABLE IF NOT EXISTS TAlumno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) not null,
    fecha_nacimiento DATE,
    direccion VARCHAR(255),
    correo VARCHAR(255),
    telefono VARCHAR(15),
    instituto_id INT,
    constraint fk_alumno_instituto FOREIGN KEY (instituto_id) 
		REFERENCES TInstituto(id) On delete restrict On Update Cascade);

CREATE TABLE IF NOT EXISTS TModulo (
    codigo_modulo INT AUTO_INCREMENT PRIMARY KEY,
    nombre_modulo VARCHAR(255) NOT NULL,
    ciclo_formativo VARCHAR(255) NOT NULL);

CREATE TABLE IF NOT EXISTS TMatricula (
    alumno_id INT,
    modulo_codigo INT,
    PRIMARY KEY (alumno_id, modulo_codigo),
    FOREIGN KEY (alumno_id) REFERENCES TAlumno(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (modulo_codigo) REFERENCES TModulo(codigo_modulo) ON DELETE CASCADE ON UPDATE CASCADE);

INSERT INTO TInstituto (nombre, direccion, localidad, telefono) VALUES
('IES Vicente Medina', 'C/. Vaso Ibérico de los Guerreros, S/N', 'ARCHENA', '968670157'),
('IES Los Albares', 'C/ Vereda de Morcillo S/N', 'CIEZA', '968773077'),
('IES Valle del Segura', 'Av. Río Segura, nº 10', 'BLANCA', '968459348');

INSERT INTO TAlumno	(nombre, fecha_nacimiento, direccion, correo, telefono, instituto_id) VALUES
('Juan Pérez', '2000-01-15', 'Calle 123, Ciudad A', 'juan@example.com', '123456789', 1),
('Ana García', '1999-05-22', 'Avenida XYZ, Ciudad B', 'ana@example.com', '987654321', 2),
('Pedro López', '1998-11-10', 'Calle Principal, Ciudad A', 'pedro@example.com', '555555555', 1),
('María Rodríguez', '2001-03-05', 'Calle Secundaria, Ciudad C', 'maria@example.com', '777777777', 3),
('Carlos Sánchez', '1997-08-18', 'Avenida Central, Ciudad B', 'carlos@example.com', '999999999', 2);

INSERT INTO TModulo (nombre_modulo, ciclo_formativo) VALUES
('Acceso a Datos', 'Desarrollo de Aplicaciones Multiplataforma'),
('Seguridad y Alta Disponibilidad', 'Administración de Sistemas Informáticos en Red'),
('Programación', 'Desarrollo de Aplicaciones Multiplataforma'),
('Redes de Computadoras', 'Administración de Sistemas Informáticos en Red');

INSERT INTO TMatricula (alumno_id, modulo_codigo) VALUES
(1, 1),(1, 2),(2, 2),(3, 3),(4, 4);

use institutosMatricula;
Select * From TInstituto;

# INSERT INTO TInstituto (nombre, direccion, localidad, telefono) VALUES
# ('IES Diego Tortosa', 'C/ Aleatoria, 23', 'CIEZA', '968451234');
# Select * From TInstituto;