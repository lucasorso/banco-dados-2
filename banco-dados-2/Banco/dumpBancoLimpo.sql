#
# SQL Export
# Created by Querious (1055)
# Created: November 16, 2016 at 8:50:10 PM GMT-2
# Encoding: Unicode (UTF-8)
#


SET @PREVIOUS_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS;
SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS `pessoas`;
DROP TABLE IF EXISTS `pais`;
DROP TABLE IF EXISTS `movimento`;
DROP TABLE IF EXISTS `logradouro`;
DROP TABLE IF EXISTS `estado`;
DROP TABLE IF EXISTS `cidade`;
DROP TABLE IF EXISTS `bairro`;


CREATE TABLE `bairro` (
  `idBairro` int(11) NOT NULL AUTO_INCREMENT,
  `nomeBairro` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idBairro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `cidade` (
  `idCidade` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCidade` varchar(50) NOT NULL,
  PRIMARY KEY (`idCidade`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `estado` (
  `idEstado` int(11) NOT NULL AUTO_INCREMENT,
  `nomeEstado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `logradouro` (
  `idLogradouro` int(11) NOT NULL AUTO_INCREMENT,
  `nomeLogradouro` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idLogradouro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `movimento` (
  `idMovimento` int(11) NOT NULL AUTO_INCREMENT,
  `movimento` varchar(100) NOT NULL,
  `data` datetime NOT NULL,
  `primeiroBanco` varchar(100) NOT NULL,
  `segundoBanco` varchar(100) NOT NULL,
  `terceiroBanco` varchar(100) NOT NULL,
  PRIMARY KEY (`idMovimento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `pais` (
  `idPais` int(11) NOT NULL AUTO_INCREMENT,
  `nomePais` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idPais`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `pessoas` (
  `idPessoa` int(11) NOT NULL AUTO_INCREMENT,
  `nomePessoa` varchar(50) DEFAULT NULL,
  `logradouroIdLogradouro` int(11) NOT NULL,
  `bairroIdBairro` int(11) NOT NULL,
  `cidadeIdCidade` int(11) NOT NULL,
  `estadoIdEstado` int(11) NOT NULL,
  `paisIdPais` int(11) NOT NULL,
  PRIMARY KEY (`idPessoa`),
  KEY `fk_p_bairro_idx` (`bairroIdBairro`),
  KEY `fk_p_cidade_idx` (`cidadeIdCidade`),
  KEY `fk_p_logradouro_idx` (`logradouroIdLogradouro`),
  KEY `fk_p_pais_idx` (`paisIdPais`),
  KEY `fk_p_estado_idx` (`estadoIdEstado`) USING BTREE,
  CONSTRAINT `fk_p_bairro` FOREIGN KEY (`bairroIdBairro`) REFERENCES `bairro` (`idBairro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_p_cidade` FOREIGN KEY (`cidadeIdCidade`) REFERENCES `cidade` (`idCidade`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_p_estado` FOREIGN KEY (`estadoIdEstado`) REFERENCES `estado` (`idEstado`) ON UPDATE NO ACTION,
  CONSTRAINT `fk_p_logradouro` FOREIGN KEY (`logradouroIdLogradouro`) REFERENCES `logradouro` (`idLogradouro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_p_pais` FOREIGN KEY (`paisIdPais`) REFERENCES `pais` (`idPais`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




SET FOREIGN_KEY_CHECKS = @PREVIOUS_FOREIGN_KEY_CHECKS;


SET @PREVIOUS_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS;
SET FOREIGN_KEY_CHECKS = 0;


LOCK TABLES `bairro` WRITE;
ALTER TABLE `bairro` DISABLE KEYS;
ALTER TABLE `bairro` ENABLE KEYS;
UNLOCK TABLES;


LOCK TABLES `cidade` WRITE;
ALTER TABLE `cidade` DISABLE KEYS;
ALTER TABLE `cidade` ENABLE KEYS;
UNLOCK TABLES;


LOCK TABLES `estado` WRITE;
ALTER TABLE `estado` DISABLE KEYS;
ALTER TABLE `estado` ENABLE KEYS;
UNLOCK TABLES;


LOCK TABLES `logradouro` WRITE;
ALTER TABLE `logradouro` DISABLE KEYS;
ALTER TABLE `logradouro` ENABLE KEYS;
UNLOCK TABLES;


LOCK TABLES `movimento` WRITE;
ALTER TABLE `movimento` DISABLE KEYS;
ALTER TABLE `movimento` ENABLE KEYS;
UNLOCK TABLES;


LOCK TABLES `pais` WRITE;
ALTER TABLE `pais` DISABLE KEYS;
ALTER TABLE `pais` ENABLE KEYS;
UNLOCK TABLES;


LOCK TABLES `pessoas` WRITE;
ALTER TABLE `pessoas` DISABLE KEYS;
ALTER TABLE `pessoas` ENABLE KEYS;
UNLOCK TABLES;




SET FOREIGN_KEY_CHECKS = @PREVIOUS_FOREIGN_KEY_CHECKS;


