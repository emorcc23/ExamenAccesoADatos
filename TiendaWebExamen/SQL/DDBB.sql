CREATE DATABASE tienda;
USE tienda;

CREATE TABLE productos (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
descripcion VARCHAR(100),
precio DOUBLE);

INSERT INTO productos (descripcion,precio) VALUES ("descripcion1","4.15");
INSERT INTO productos (descripcion,precio) VALUES ("descripcion2","15.2");
INSERT INTO productos (descripcion,precio) VALUES ("descripcion3","1.10");
INSERT INTO productos (descripcion,precio) VALUES ("descripcion4","3.20");
INSERT INTO productos (descripcion,precio) VALUES ("descripcion5","6.32");
INSERT INTO productos (descripcion,precio) VALUES ("descripcion6","2.36");
INSERT INTO productos (descripcion,precio) VALUES ("descripcion7","7.25");
INSERT INTO productos (descripcion,precio) VALUES ("descripcion8","4.15");

SELECT * FROM productos;