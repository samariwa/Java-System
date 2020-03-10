# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: localhost (MySQL 5.7.16)
# Database: Kwanza Tukule
# Generation Time: 2020-03-10 13:29:09 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table category
# ------------------------------------------------------------

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `Category_Name` varchar(100) NOT NULL DEFAULT '',
  `Created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table orders
# ------------------------------------------------------------

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Customer_id` bigint(20) unsigned NOT NULL,
  `Category_id` bigint(20) unsigned NOT NULL,
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
  KEY `order_category_id_foreign` (`Category_id`),
  CONSTRAINT `order_category_id_foreign` FOREIGN KEY (`Category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE,
  CONSTRAINT `order_customer_id_foreign` FOREIGN KEY (`Customer_id`) REFERENCES `customers` (`id`) ON DELETE CASCADE,
  CONSTRAINT `order_stock_id_foreign` FOREIGN KEY (`Stock_id`) REFERENCES `stock` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
