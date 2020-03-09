# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: localhost (MySQL 5.7.16)
# Database: Kwanza Tukule
# Generation Time: 2020-03-09 12:08:50 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table customers
# ------------------------------------------------------------

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL DEFAULT '',
  `Number` varchar(13) NOT NULL DEFAULT '',
  `Deliverer` varchar(255) NOT NULL DEFAULT '',
  `Location` varchar(255) NOT NULL DEFAULT '',
  `Status` text NOT NULL,
  `Created_at` timestamp NULL DEFAULT NULL,
  `Updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table orders
# ------------------------------------------------------------

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Customer_id` bigint(20) unsigned NOT NULL,
  `Stock_id` bigint(20) unsigned NOT NULL,
  `C/F/Debt` double NOT NULL,
  `MPesa` double NOT NULL,
  `Cash` double NOT NULL,
  `Balance` double NOT NULL,
  `Banked` double DEFAULT NULL,
  `Slip_Number` varchar(255) DEFAULT NULL,
  `Banked_By` varchar(255) DEFAULT NULL,
  `Created_at` timestamp NULL DEFAULT NULL,
  `Updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_customer_id_foreign` (`Customer_id`),
  KEY `order_stock_id_foreign` (`Stock_id`),
  CONSTRAINT `order_customer_id_foreign` FOREIGN KEY (`Customer_id`) REFERENCES `customers` (`id`) ON DELETE CASCADE,
  CONSTRAINT `order_stock_id_foreign` FOREIGN KEY (`Stock_id`) REFERENCES `stock` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table stock
# ------------------------------------------------------------

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL DEFAULT '',
  `Price` double NOT NULL,
  `Quantity` int(255) NOT NULL,
  `Created_at` timestamp NULL DEFAULT NULL,
  `Updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table summary
# ------------------------------------------------------------

DROP TABLE IF EXISTS `summary`;

CREATE TABLE `summary` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Sales` double NOT NULL,
  `Revenue` double NOT NULL,
  `M-Pesa` double NOT NULL,
  `Cash` double NOT NULL,
  `Debt_M-Pesa` double NOT NULL,
  `Debt_Cash` double NOT NULL,
  `Banked` double NOT NULL,
  `Expenses` double NOT NULL,
  `Cash_In_Hand` double NOT NULL,
  `Created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `firstname` varchar(40) NOT NULL DEFAULT '',
  `lastname` varchar(40) NOT NULL DEFAULT '',
  `number` varchar(13) NOT NULL DEFAULT '',
  `email` varchar(255) NOT NULL DEFAULT '',
  `nationalID` varchar(10) NOT NULL DEFAULT '',
  `staffID` varchar(20) NOT NULL DEFAULT '',
  `yob` int(4) NOT NULL,
  `gender` varchar(6) NOT NULL DEFAULT '',
  `role` varchar(100) NOT NULL DEFAULT '',
  `username` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(20) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`firstname`, `lastname`, `number`, `email`, `nationalID`, `staffID`, `yob`, `gender`, `role`, `username`, `password`)
VALUES
	('Samuel','Mariwa','0713932911','samuelmariwa@gmail.com','36897187','000',1999,'Male','Software','Mariwa','Kenya.2030'),
	('Khadija','Mohamed','0717668355','khadija.mohamed.churchill@kwanzatukule.com','22367588','001',1979,'Female','CEO','KHADIJA','Thamestana'),
	('Sheldon','Wakwaya','0724723286','sheldon.wakwaya@gmail.com','23625691','002',1983,'Male','General operation manager','wakwaya','jaber2005');

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
