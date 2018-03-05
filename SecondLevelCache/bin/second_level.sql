/*
SQLyog Ultimate v9.02 
MySQL - 5.0.24-community-nt : Database - second_level
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`second_level` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `second_level`;

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `ID` bigint(20) NOT NULL,
  `PRODUCT_ID` bigint(20) default NULL,
  `PRODUCT_NAME` varchar(255) default NULL,
  `PRICE` double default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product` */

insert  into `product`(`ID`,`PRODUCT_ID`,`PRODUCT_NAME`,`PRICE`) values (1,101,'Samsung Galaxy S8',54000),(2,102,'iPhone X',90000),(3,103,'Google Pixel X',45000),(4,104,'Google Pixel XL',65000),(5,105,'Xaomi Mi MIX 2',32000),(6,106,'Motorola Z2 Force',35000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
