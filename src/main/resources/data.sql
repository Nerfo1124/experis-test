DROP TABLE producto IF EXISTS;
DROP TABLE carrito IF EXISTS;

CREATE TABLE producto (
    id BIGINT IDENTITY NOT NULL,
    nombre VARCHAR(255),
    marca VARCHAR(255),
    precio BIGINT,
    cantidad INTEGER,
    estado VARCHAR(255),
    porc_descuento INTEGER
);

CREATE TABLE carrito (
    id BIGINT IDENTITY NOT NULL,
    id_cliente BIGINT,
    id_producto BIGINT,
    cantidad INTEGER
);