CREATE TABLE conductor (
  id BIGINT PRIMARY KEY NOT NULL,
  identificacion VARCHAR(11) NOT NULL,
  apellido VARCHAR(20) ,
  nombre VARCHAR(20) NOT NULL,
  telefono VARCHAR(10) NOT NULL,
  direccion VARCHAR(50)
);

CREATE TABLE vehiculo (
  id BIGINT PRIMARY KEY NOT NULL,
  modelo VARCHAR(4) NOT NULL,
  placa VARCHAR(7) NOT NULL,
  capacidad VARCHAR(7),
  conductor_id INT(6),
  FOREIGN KEY (conductor_id) REFERENCES conductor(id)
);

CREATE TABLE pedidos (
  id BIGINT PRIMARY KEY NOT NULL,
  tipo_pedido VARCHAR(20),
  direccion VARCHAR(50) NOT NULL,
  conductor_id INT(6) NOT NULL,
  FOREIGN KEY (conductor_id) REFERENCES conductor(id)
);