CREATE TABLE `eventos` (
                           `id_evento` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
                           `nombre` varchar(50) NOT NULL,
                           `fecha_ini` TIMESTAMP,
                           `fecha_fin` TIMESTAMP,
                           `categoria_id` INTEGER,
                           `valor` DOUBLE,
                           `estado` BOOLEAN,
                           PRIMARY KEY(`id_evento`)
);


CREATE UNIQUE INDEX `events_index_0`
    ON `eventos` (`id_evento`);
CREATE INDEX `events_index_1`
    ON `eventos` (`categoria_id`);
CREATE TABLE `categorias` (
                             `id_categoria` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
                             `nombre_categoria` varchar(50),
                             `estado` BOOLEAN,
                             PRIMARY KEY(`id_categoria`)
);


CREATE UNIQUE INDEX `categoria_index_0`
    ON `categorias` (`id_categoria`);
CREATE INDEX `categoria_index_1`
    ON `categorias` (`id_categoria`);
CREATE TABLE `inscripciones` (
                                 `id_inscrito` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
                                 `evento_id` INTEGER,
                                 `nombre` varchar(50),
                                 `email` varchar(50),
                                 `telefono` varchar(20),
                                 `comentario` VARCHAR(255),
                                 PRIMARY KEY(`id_inscrito`)
);



ALTER TABLE `eventos`
    ADD FOREIGN KEY(`categoria_id`) REFERENCES `categorias`(`id_categoria`)
        ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `inscripciones`
    ADD FOREIGN KEY(`evento_id`) REFERENCES `eventos`(`id_evento`)
        ON UPDATE NO ACTION ON DELETE NO ACTION;


INSERT INTO categorias VALUES (1, 'Ciclismo', true);
INSERT INTO categorias VALUES (2, 'Atletismo', true);
INSERT INTO categorias VALUES (3, 'Automovilismo', true);

INSERT INTO eventos VALUES (1, 'Juegos Olimpicos', '2024-08-16 00:00:00', '2024-09-16 00:00:00', '2', '185', true);
INSERT INTO eventos VALUES (2, 'Vuelta a España', '2024-11-02 13:00:00', '2024-11-16 11:30:00', '1', '0', true);
INSERT INTO eventos VALUES (3, 'Gran Prix barcelona', '2025-01-02 15:00:00', '2025-01-12 16:00:00', '3', '305', true);
INSERT INTO eventos VALUES (4, 'Tour Colombia', '2025-11-02 13:00:00', '2025-11-16 11:30:00', '1', '0', true);

ALTER TABLE eventos ALTER COLUMN id_evento RESTART WITH 5;
ALTER TABLE categorias ALTER COLUMN id_categoria RESTART WITH 4;

