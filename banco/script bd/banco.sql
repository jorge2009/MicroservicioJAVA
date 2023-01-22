-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 22-01-2023 a las 19:17:02
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `banco`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `contraseña` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `persona_id_persona` int NOT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `FKcmgtin2h9wj7hvgp6jf60v54t` (`persona_id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `contraseña`, `estado`, `persona_id_persona`) VALUES
(1, '5555', 'True', 1),
(2, '1234', 'True', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
CREATE TABLE IF NOT EXISTS `cuenta` (
  `id_cuenta` int NOT NULL AUTO_INCREMENT,
  `estado` int DEFAULT NULL,
  `numero_cuenta` int DEFAULT NULL,
  `saldo_inicial` double NOT NULL,
  `tipo_cuenta` varchar(255) DEFAULT NULL,
  `cliente_id_cliente` int NOT NULL,
  PRIMARY KEY (`id_cuenta`),
  KEY `FK4ejpfsimj7rgv5nr994wmstui` (`cliente_id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `cuenta`
--

INSERT INTO `cuenta` (`id_cuenta`, `estado`, `numero_cuenta`, `saldo_inicial`, `tipo_cuenta`, `cliente_id_cliente`) VALUES
(1, 1, 57876, 0, NULL, 1),
(3, 1, 35367, 25.25, 'ahorro', 1),
(4, 1, 57644, 52.67, 'ahorros', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento`
--

DROP TABLE IF EXISTS `movimiento`;
CREATE TABLE IF NOT EXISTS `movimiento` (
  `id_movimiento` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `saldo` double NOT NULL,
  `tipo_movimiento` varchar(255) DEFAULT NULL,
  `valor` double NOT NULL,
  `cuenta_id_cuenta` int NOT NULL,
  PRIMARY KEY (`id_movimiento`),
  KEY `FKd8vdh1gws7jn8sjx62m9fdfvk` (`cuenta_id_cuenta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `movimiento`
--

INSERT INTO `movimiento` (`id_movimiento`, `fecha`, `saldo`, `tipo_movimiento`, `valor`, `cuenta_id_cuenta`) VALUES
(1, '2023-01-22', 40, 'deposito', 40, 1),
(2, '2023-01-22', 40, 'deposito', 40, 1),
(3, '2023-01-22', 0, 'debito', 40, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

DROP TABLE IF EXISTS `persona`;
CREATE TABLE IF NOT EXISTS `persona` (
  `id_persona` int NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `identificacion` int DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  PRIMARY KEY (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id_persona`, `direccion`, `edad`, `genero`, `identificacion`, `nombre`, `telefono`) VALUES
(1, 'La central sn y Principal', 23, 'Femenino', 1715555647, 'Maria Estrada', 2144443647),
(2, 'Amazonas y NNUU', 35, 'Femenino', 1747483647, 'Marianela Montalvo', 987654456),
(4, '13 junio y Equinoccial', 27, 'Masculino', 1723444434, 'Juan Osorio', 987654365),
(5, 'el bosque', 35, 'Masculino', 1711756787, 'miguel ramirez', 546543576),
(6, 'Las casas', 32, 'Masculino', 1714354334, 'Luis Rodriguez', 914748363);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `FKcmgtin2h9wj7hvgp6jf60v54t` FOREIGN KEY (`persona_id_persona`) REFERENCES `persona` (`id_persona`);

--
-- Filtros para la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD CONSTRAINT `FK4ejpfsimj7rgv5nr994wmstui` FOREIGN KEY (`cliente_id_cliente`) REFERENCES `cliente` (`id_cliente`);

--
-- Filtros para la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD CONSTRAINT `FKd8vdh1gws7jn8sjx62m9fdfvk` FOREIGN KEY (`cuenta_id_cuenta`) REFERENCES `cuenta` (`id_cuenta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
