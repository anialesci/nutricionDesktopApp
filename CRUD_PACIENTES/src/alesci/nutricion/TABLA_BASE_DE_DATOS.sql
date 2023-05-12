
CREATE TABLE IF NOT EXISTS `pacientes` (
`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  `edad` int(10) NOT NULL,
  `telefono` varchar(200) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `peso` int(10),
  `tallaCentrimentos` int(10),
  `condicionBase` varchar(200),
  `medicamentos` varchar(200),
  `cribaje` int(10),
 `evaluacion` float(10),
 `evaluacionGlobal` float(10)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;