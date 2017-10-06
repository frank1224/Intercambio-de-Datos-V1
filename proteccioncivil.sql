-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 06-10-2017 a las 22:41:02
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proteccioncivil`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asigna`
--

CREATE TABLE `asigna` (
  `codinterno` int(11) NOT NULL,
  `codparque` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Empleado`
--

CREATE TABLE `Empleado` (
  `codinterno` int(11) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `fechanaciemiento` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Empleado`
--

INSERT INTO `Empleado` (`codinterno`, `dni`, `nombre`, `apellido`, `fechanaciemiento`) VALUES
(1, 'ggg1', 'machina', 'maquina', '01-02-1990'),
(2, 'ggg2', 'machina2', 'maquina2', '04-09-1989');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Instalacion`
--

CREATE TABLE `Instalacion` (
  `codparque` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Instalacion`
--

INSERT INTO `Instalacion` (`codparque`, `nombre`, `telefono`, `direccion`) VALUES
(12, 'parque1', '9876867', 'cercana');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Notificacion`
--

CREATE TABLE `Notificacion` (
  `codnotificacion` int(11) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `urgencia` enum('baja','media','alta','') NOT NULL,
  `tipo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Notificacion`
--

INSERT INTO `Notificacion` (`codnotificacion`, `direccion`, `urgencia`, `tipo`) VALUES
(6, 'Parque1', 'alta', 'Pelea');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recibe`
--

CREATE TABLE `recibe` (
  `codigoparque` int(11) NOT NULL,
  `codnotificacion` int(11) NOT NULL,
  `fecha_hora` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asigna`
--
ALTER TABLE `asigna`
  ADD KEY `codigointerno_idx` (`codinterno`),
  ADD KEY `codparque_idx` (`codparque`);

--
-- Indices de la tabla `Empleado`
--
ALTER TABLE `Empleado`
  ADD PRIMARY KEY (`codinterno`);

--
-- Indices de la tabla `Instalacion`
--
ALTER TABLE `Instalacion`
  ADD PRIMARY KEY (`codparque`);

--
-- Indices de la tabla `Notificacion`
--
ALTER TABLE `Notificacion`
  ADD PRIMARY KEY (`codnotificacion`);

--
-- Indices de la tabla `recibe`
--
ALTER TABLE `recibe`
  ADD KEY `codigoparque_idx` (`codigoparque`),
  ADD KEY `codnotificacion_idx` (`codnotificacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Empleado`
--
ALTER TABLE `Empleado`
  MODIFY `codinterno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `Instalacion`
--
ALTER TABLE `Instalacion`
  MODIFY `codparque` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT de la tabla `Notificacion`
--
ALTER TABLE `Notificacion`
  MODIFY `codnotificacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asigna`
--
ALTER TABLE `asigna`
  ADD CONSTRAINT `codigointerno` FOREIGN KEY (`codinterno`) REFERENCES `Empleado` (`codinterno`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `codparque` FOREIGN KEY (`codparque`) REFERENCES `Instalacion` (`codparque`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `recibe`
--
ALTER TABLE `recibe`
  ADD CONSTRAINT `codigoparque` FOREIGN KEY (`codigoparque`) REFERENCES `Instalacion` (`codparque`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `codnotificacion` FOREIGN KEY (`codnotificacion`) REFERENCES `Notificacion` (`codnotificacion`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
