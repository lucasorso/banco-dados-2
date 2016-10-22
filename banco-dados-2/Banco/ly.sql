/*
SQLyog Community Edition- MySQL GUI v5.31
Host - 5.0.41-community-nt : Database - ly
*********************************************************************
Server version : 5.0.41-community-nt
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `ly`;

USE `ly`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `bairro` */

DROP TABLE IF EXISTS `bairro`;

CREATE TABLE `bairro` (
  `idBairro` int(11) NOT NULL auto_increment,
  `nomeBairro` varchar(50) default NULL,
  PRIMARY KEY  (`idBairro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `bairro` */

insert  into `bairro`(`idBairro`,`nomeBairro`) values (1,'Santa Augusta'),(2,'Universitário'),(3,'Pinheirinho'),(4,'Japonês'),(5,'Esplanada'),(6,'Saco dos Limões'),(7,'Centro'),(8,'China Town');

/*Table structure for table `cidade` */

DROP TABLE IF EXISTS `cidade`;

CREATE TABLE `cidade` (
  `Cidade` int(11) NOT NULL auto_increment,
  `idCidade` varchar(50) default NULL,
  PRIMARY KEY  (`Cidade`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cidade` */

insert  into `cidade`(`Cidade`,`idCidade`) values (1,'Cricíuma'),(2,'Turvo'),(3,'Sombrio'),(4,'Florianópolis'),(5,'Balneário Camburiú'),(6,'Nova York'),(7,'Boston'),(8,'Kyoto'),(9,'Sydney'),(10,'Passo de Torres'),(11,'Torres'),(12,'Maringá');

/*Table structure for table `estado` */

DROP TABLE IF EXISTS `estado`;

CREATE TABLE `estado` (
  `idEstado` int(11) NOT NULL auto_increment,
  `nomeEstado` varchar(50) default NULL,
  PRIMARY KEY  (`idEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `estado` */

insert  into `estado`(`idEstado`,`nomeEstado`) values (1,'Santa Catarina'),(2,'New York'),(3,'Rio Grande do Sul'),(4,'Paraná'),(5,'California'),(6,'Rio de Janeiro'),(7,'São Paulo');

/*Table structure for table `logradouro` */

DROP TABLE IF EXISTS `logradouro`;

CREATE TABLE `logradouro` (
  `idLogradouro` int(11) NOT NULL auto_increment,
  `nomeLogradouro` varchar(50) default NULL,
  PRIMARY KEY  (`idLogradouro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `logradouro` */

insert  into `logradouro`(`idLogradouro`,`nomeLogradouro`) values (1,'São Martinho'),(2,'Avenida Municipal'),(3,'Jorge Lacerda'),(4,'São Judas de Alcântara'),(5,'5th Avenue'),(6,'Parker Street'),(7,'Avenida Santa Augusta');

/*Table structure for table `pais` */

DROP TABLE IF EXISTS `pais`;

CREATE TABLE `pais` (
  `idPais` int(11) NOT NULL auto_increment,
  `nomePais` varchar(50) default NULL,
  PRIMARY KEY  (`idPais`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pais` */

insert  into `pais`(`idPais`,`nomePais`) values (1,'Brasil'),(2,'EUA'),(3,'China'),(4,'México'),(5,'Japão'),(6,'França'),(7,'Alemanha');

/*Table structure for table `pessoas` */

DROP TABLE IF EXISTS `pessoas`;

CREATE TABLE `pessoas` (
  `idPessoa` int(11) NOT NULL auto_increment,
  `nomePessoa` varchar(50) default NULL,
  `logradouroIdLogradouro` int(11) default NULL,
  `bairroIdBairro` int(11) default NULL,
  `cidadeIdCidade` int(11) default NULL,
  `estadoIdEstado` int(11) default NULL,
  `paisIdPais` int(11) default NULL,
  PRIMARY KEY  (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pessoas` */

insert  into `pessoas`(`idPessoa`,`nomePessoa`,`logradouroIdLogradouro`,`bairroIdBairro`,`cidadeIdCidade`,`estadoIdEstado`,`paisIdPais`) values (1,'Lucas',1,2,4,5,3),(2,'Yuri ',0,0,3,0,6);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
