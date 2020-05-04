-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 09, 2020 at 11:10 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tukule_kwanza`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` bigint(11) UNSIGNED NOT NULL,
  `Category_Name` varchar(100) NOT NULL DEFAULT '',
  `Created_at` timestamp NULL DEFAULT current_timestamp(),
  `Updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `Category_Name`, `Created_at`, `Updated_at`) VALUES
(1, 'Maize Flour', '2020-03-16 21:33:52', '2020-03-16 21:36:36'),
(2, 'Cooking Oil', '2020-03-16 21:34:16', NULL),
(3, 'Soap', '2020-03-16 21:34:23', NULL),
(4, 'Cereals', '2020-03-16 21:34:33', NULL),
(5, 'Baking Powder', '2020-03-16 21:34:36', '2020-03-16 21:34:59'),
(6, 'Sugar', '2020-03-16 21:35:09', NULL),
(7, 'Rice', '2020-03-16 21:35:16', NULL),
(8, 'Serviettes', '2020-03-16 21:36:22', NULL),
(9, 'Baking Flour', '2020-03-16 21:36:48', NULL),
(10, 'All Purpose Flour', '2020-03-16 21:36:57', NULL),
(11, 'Salt', '2020-03-16 21:36:59', '2020-03-16 21:38:11'),
(12, '', '2020-03-16 21:39:44', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `id` bigint(11) UNSIGNED NOT NULL,
  `Name` varchar(255) NOT NULL DEFAULT '',
  `Number` varchar(13) NOT NULL DEFAULT '',
  `Deliverer` varchar(255) NOT NULL DEFAULT '',
  `Location` varchar(255) NOT NULL DEFAULT '',
  `Status` varchar(255) NOT NULL DEFAULT 'clean',
  `Created_at` timestamp NULL DEFAULT current_timestamp(),
  `Updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `Name`, `Number`, `Deliverer`, `Location`, `Status`, `Created_at`, `Updated_at`) VALUES
(2, 'Jane', '0712843012', 'John', 'South B', 'no delivery', NULL, '2020-04-05 09:14:44'),
(4, 'Mary', '0723592122', 'Roy', 'South C', 'fined', '2020-03-13 17:20:28', '2020-04-06 14:35:38'),
(5, 'Mary', '072376121', 'dcsx', 'Here', 'clean', '2020-03-13 19:04:30', NULL),
(6, 'Sam', '0713932911', 'Me', 'Nairobi', 'clean', '2020-03-13 20:00:17', NULL),
(7, 'Sam2', '0316981281', 'Vid', 'Nai', 'clean', '2020-03-13 20:04:06', NULL),
(8, 'Jsujdb', '0316981281', 'Vid', 'Nai', 'clean', '2020-03-13 20:04:34', '2020-03-25 17:23:40'),
(10, 'guwca', '2268942', 'csbdj', 'gljebcsd', 'clean', '2020-03-13 20:10:34', NULL),
(12, 'Mariwa', '0732981', 'sbjk ', 'bsdcnjds', 'clean', '2020-03-13 20:25:57', NULL),
(13, 'Mariwa1', '66894892', 'urfd', 'Sabaki', 'clean', '2020-03-16 13:06:15', '2020-03-16 13:06:15'),
(14, 'Mariwa2', '8962398', 'Brian', 'Nfbijev', 'clean', '2020-03-16 13:45:42', '2020-03-26 18:18:31'),
(16, 'Mariwa', '394290', 'George', 'grhknad', 'clean', '2020-03-16 13:38:41', '2020-03-16 13:38:41'),
(17, 'Mariwa', '394290', 'scdjn,m', 'Westlands', 'clean', '2020-03-16 13:38:24', '2020-03-17 13:01:59'),
(21, 'Mariwa', '394290', 'scdjn,m cds', 'grhknad', 'no delivery', '2020-03-16 12:44:15', '2020-04-05 09:11:39'),
(23, 'Sam', '1231231', 'Me', 'Mombasa', 'clean', '2020-03-17 13:02:20', NULL),
(25, 'New', '309273', 'John', 'Here', 'no delivery', '2020-03-17 13:19:39', '2020-04-09 04:35:50'),
(26, 'New', '309273', 'John', 'Here', 'clean', '2020-03-17 13:20:01', '2020-03-26 18:18:40');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) UNSIGNED NOT NULL,
  `Customer_id` bigint(20) UNSIGNED NOT NULL,
  `Category_id` bigint(20) UNSIGNED NOT NULL,
  `Stock_id` bigint(20) UNSIGNED NOT NULL,
  `Quantity` int(20) NOT NULL,
  `Debt` double NOT NULL,
  `MPesa` double NOT NULL DEFAULT 0,
  `Cash` double NOT NULL DEFAULT 0,
  `Balance` double NOT NULL,
  `Banked` double DEFAULT 0,
  `Slip_Number` varchar(255) DEFAULT 'N/A',
  `Banked_By` varchar(255) DEFAULT 'N/A',
  `Created_at` timestamp NULL DEFAULT current_timestamp(),
  `Updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `Customer_id`, `Category_id`, `Stock_id`, `Quantity`, `Debt`, `MPesa`, `Cash`, `Balance`, `Banked`, `Slip_Number`, `Banked_By`, `Created_at`, `Updated_at`) VALUES
(25, 4, 2, 4, 23, -69000, 186782, 0, -110, 0, 'N/A', 'N/A', '2020-03-22 20:34:28', '2020-04-09 04:52:00'),
(26, 4, 2, 4, 12, -36000, 0, 0, -110, 0, 'N/A', 'N/A', '2020-03-22 20:42:57', '2020-04-09 04:52:00'),
(29, 4, 2, 4, 12, -105000, 0, 0, -110, 0, 'N/A', 'N/A', '2020-03-22 21:09:43', '2020-04-09 04:52:00'),
(30, 4, 2, 4, 12, -105000, 0, 141000, -110, 0, 'N/A', 'N/A', '2020-03-22 21:10:00', '2020-04-09 04:52:00'),
(34, 2, 9, 2, 12, -31200, 0, 45550, -31200, 0, 'N/A', 'N/A', '2020-03-23 11:40:25', '2020-03-23 23:25:58'),
(35, 2, 9, 2, 12, -45600, 0, 0, -44, 0, 'N/A', 'N/A', '2020-03-23 11:42:35', '2020-04-09 04:52:00'),
(37, 2, 9, 2, 2, -33600, 0, 0, -33600, 0, 'N/A', 'N/A', '2020-03-23 18:10:12', NULL),
(38, 2, 2, 4, 2, -81600, 0, 87600, -81600, 0, 'N/A', 'N/A', '2020-03-24 02:20:39', '2020-03-24 02:31:05'),
(48, 21, 2, 4, 2, -6000, 0, 0, -6000, 0, 'N/A', 'N/A', '2020-03-24 14:22:59', '2020-03-25 16:47:53'),
(50, 2, 2, 4, 2, -87600, 0, 93600, -93600, 0, 'N/A', 'N/A', '2020-03-24 15:52:36', '2020-03-24 16:00:05'),
(51, 2, 2, 4, 2, -99600, 105000, 600, 111700, 105000, 'NZ-200', 'Job', '2020-03-24 16:00:28', '2020-03-24 17:02:10'),
(52, 2, 2, 4, 1, -3000, 0, 0, -3000, 0, 'N/A', 'N/A', '2020-03-24 17:02:10', NULL),
(53, 2, 2, 4, 1, -6000, 0, 9000, 0, 0, 'N/A', 'N/A', '2020-03-24 17:03:04', '2020-03-24 17:09:26'),
(54, 2, 2, 4, 1, -3000, 0, 0, -3000, 0, 'N/A', 'N/A', '2020-03-24 17:09:31', NULL),
(55, 2, 2, 4, 2, -9000, 0, 0, -9000, 0, 'N/A', 'N/A', '2020-03-24 17:14:05', NULL),
(57, 2, 2, 4, 2, -5000, 0, 0, -5000, 0, 'N/A', 'N/A', '2020-03-24 17:18:17', NULL),
(58, 2, 2, 4, 2, -11000, 2, 11000, 11102, 0, 'N/A', 'N/A', '2020-03-24 17:22:01', '2020-03-24 17:02:10'),
(60, 2, 2, 4, 2, -998, 0, 0, -998, 0, 'N/A', 'N/A', '2020-03-24 17:23:30', NULL),
(61, 2, 2, 4, 2, -6998, 0, 6998, 0, 0, 'N/A', 'N/A', '2020-03-24 17:23:37', '2020-03-24 17:26:24'),
(62, 2, 2, 4, 2, -12998, 0, 0, -12998, 0, 'N/A', 'N/A', '2020-03-24 17:24:09', NULL),
(63, 2, 9, 2, 2, -15398, 0, 15300, -107.8, 0, 'N/A', 'N/A', '2020-03-24 17:24:09', '2020-04-09 04:52:00'),
(64, 2, 2, 4, 1, -15998, 0, 15998, 0, 0, 'N/A', 'N/A', '2020-03-24 18:14:09', '2020-03-24 18:30:34'),
(65, 2, 2, 4, 2, -6000, 0, 0, -6000, 0, 'N/A', 'N/A', '2020-03-24 23:21:27', NULL),
(66, 4, 9, 10, 1, -220, 0, 0, -242, 0, 'N/A', 'N/A', '2020-03-25 21:43:05', '2020-04-09 04:52:00'),
(67, 4, 9, 2, 2, -2620, 2620, 0, 0, 0, 'N/A', 'N/A', '2020-03-25 21:43:05', '2020-03-26 22:12:08'),
(70, 2, 2, 4, 2, -12000, 0, 0, -11979, 0, 'N/A', 'N/A', '2020-03-30 17:30:15', '2020-03-30 18:49:00'),
(71, 2, 2, 4, 2, -18000, 0, 18000, 0, 0, 'N/A', 'N/A', '2020-03-30 17:31:08', '2020-03-30 17:31:41'),
(72, 4, 2, 4, 3, -9220, 0, 0, -9226.8, 0, 'N/A', 'N/A', '2020-03-30 17:37:18', '2020-03-30 18:49:00'),
(73, 2, 2, 4, 1, -3000, 0, 1000, -3069, 0, 'N/A', 'N/A', '2020-03-30 17:41:11', '2020-03-30 18:49:00'),
(74, 2, 2, 4, 1, -6069, 6000, 120, 6063, 0, 'N/A', 'N/A', '2020-03-30 21:24:53', '2020-03-30 21:27:14'),
(75, 2, 9, 10, 2, -240, 0, 0, -528, 0, 'N/A', 'N/A', '2020-04-04 10:43:35', '2020-04-04 10:47:00'),
(76, 21, 9, 12, 2, -6000, 0, 0, -8400, 0, 'N/A', 'N/A', '2020-04-05 09:11:39', NULL),
(77, 21, 9, 2, 3, -8400, 0, 0, -12000, 0, 'N/A', 'N/A', '2020-04-05 09:11:40', NULL),
(78, 2, 2, 4, 1, -528, 0, 0, -3528, 0, 'N/A', 'N/A', '2020-04-05 09:14:44', NULL),
(79, 4, 2, 4, 1, -9226.8, 0, 0, -12226.8, 0, 'N/A', 'N/A', '2020-04-06 10:38:30', NULL),
(80, 4, 9, 2, 1, -12226.8, 0, 0, -13426.8, 0, 'N/A', 'N/A', '2020-04-06 10:58:23', NULL),
(81, 4, 9, 10, 1, -13426.8, 0, 0, -13546.8, 0, 'N/A', 'N/A', '2020-04-06 10:58:26', NULL),
(82, 4, 9, 12, 2, -13546.8, 1594.8, 14352, 1594.7999999999993, 0, 'N/A', 'N/A', '2020-04-06 10:58:29', '2020-04-06 11:01:51'),
(83, 4, 2, 4, 1, 1594.7999999999993, 1405, 0, -0.22000000000080036, 0, 'N/A', 'N/A', '2020-04-06 11:23:52', '2020-04-09 04:52:00'),
(85, 25, 11, 13, 1, 0, 0, 0, -55, 0, 'N/A', 'N/A', '2020-04-07 14:21:48', '2020-04-09 04:52:00'),
(86, 2, 2, 4, 1, -3528, 0, 0, -6528, 0, 'N/A', 'N/A', '2020-04-07 14:34:55', NULL),
(87, 25, 11, 13, 2, -50, 0, 0, -150, 0, 'N/A', 'N/A', '2020-04-09 04:35:49', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `id` bigint(11) UNSIGNED NOT NULL,
  `Category_id` bigint(20) UNSIGNED DEFAULT NULL,
  `Name` varchar(255) NOT NULL DEFAULT '',
  `Price` double NOT NULL,
  `Quantity` int(255) NOT NULL,
  `Created_at` timestamp NULL DEFAULT current_timestamp(),
  `Updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`id`, `Category_id`, `Name`, `Price`, `Quantity`, `Created_at`, `Updated_at`) VALUES
(2, 9, 'Ndovu Wheat Flour Bundles', 1200, 57, '2020-03-13 21:09:53', '2020-04-06 10:58:24'),
(3, 3, '5 Lit Rising Sun Multipurpose Soap', 400, 23, '2020-03-13 21:29:38', '2020-03-16 21:50:54'),
(4, 2, 'Ufuta Cooking oil 20 lit', 3000, 20, '2020-03-13 22:46:27', '2020-04-07 14:34:55'),
(10, 9, 'Ajab Wheat Flour Packets', 120, 39, '2020-03-17 12:39:29', '2020-04-06 10:58:27'),
(12, 9, 'Cosmo Wheat Flour Bundles', 1200, 19, '2020-03-17 12:48:39', '2020-04-06 10:58:30'),
(13, 11, '1 Kilogram Kensalt', 50, 16, '2020-03-23 17:59:27', '2020-04-09 04:35:50');

-- --------------------------------------------------------

--
-- Table structure for table `summary`
--

CREATE TABLE `summary` (
  `id` int(11) UNSIGNED NOT NULL,
  `Sales` double NOT NULL,
  `Revenue` double NOT NULL,
  `M-Pesa` double NOT NULL,
  `Cash` double NOT NULL,
  `Debt_M-Pesa` double NOT NULL,
  `Debt_Cash` double NOT NULL,
  `Banked` double NOT NULL,
  `Expenses` double NOT NULL,
  `Cash_In_Hand` double NOT NULL,
  `Created_at` timestamp NULL DEFAULT current_timestamp(),
  `Updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `firstname` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `lastname` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `number` varchar(13) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `nationalID` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `staffID` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `yob` int(4) NOT NULL,
  `gender` varchar(6) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `role` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `username` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`firstname`, `lastname`, `number`, `email`, `nationalID`, `staffID`, `yob`, `gender`, `role`, `username`, `password`) VALUES
('Khadija', 'Mohamed', '0717668335', 'khadija.mohamed.churchill@kwanzatukule.com', '22367588', '001', 1979, 'Female', 'CEO', 'Khadija', 'eC0aqsw6bHjQE4jIUxojxdxMtvZwxxG9BLRrRE/PANs='),
('Samuel', 'Mariwa', '0713932911', 'samuelmariwa@gmail.com', '36897187', '000', 1999, 'Male', 'Software', 'Mariwa', 'weuDCDqiRTvGP4KGbMjo8KjX0bs9zsYxelefbslXD8k='),
('Samuel', 'Mariwa', '0739367400', 'samuel.mariwa@gmail.com', '36897188', '004', 1999, 'Male', 'admin', 'Sam', 'B7GTODouAb4fCeEZ3HrrhQUuUZhji4Mecx3idBMO+fA='),
('Sheldon', 'Wakwaya', '0724723286', 'sheldon.wakwaya@gmail.com', '23625691', '002', 1983, 'Male', 'General operation manager', 'Wakwaya', 'qeATbdtpdDlyW+0/ZBv+4x7ZsWEwPhvuBLZlrKZ+J58=');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `order_customer_id_foreign` (`Customer_id`),
  ADD KEY `order_stock_id_foreign` (`Stock_id`),
  ADD KEY `order_category_id_foreign` (`Category_id`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`id`),
  ADD KEY `stock_category_id_foreign` (`Category_id`);

--
-- Indexes for table `summary`
--
ALTER TABLE `summary`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `username_2` (`username`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `nationalID` (`nationalID`),
  ADD UNIQUE KEY `staffID` (`staffID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `id` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=88;

--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `id` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `summary`
--
ALTER TABLE `summary`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `order_category_id_foreign` FOREIGN KEY (`Category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `order_customer_id_foreign` FOREIGN KEY (`Customer_id`) REFERENCES `customers` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `order_stock_id_foreign` FOREIGN KEY (`Stock_id`) REFERENCES `stock` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `stock_category_id_foreign` FOREIGN KEY (`Category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE;

DELIMITER $$
--
-- Events
--
CREATE DEFINER=`tukule`@`%` EVENT `reset0` ON SCHEDULE EVERY 1 DAY STARTS '2020-03-30 00:00:00' ON COMPLETION NOT PRESERVE ENABLE DO UPDATE orders SET Balance = Balance + (0.1 * Balance) where DATE(`Created_at`) < CURRENT_DATE() and Balance > -500 and Balance < 0$$

CREATE DEFINER=`tukule`@`%` EVENT `reset1` ON SCHEDULE EVERY 1 DAY STARTS '2020-03-30 00:00:00' ON COMPLETION NOT PRESERVE ENABLE DO UPDATE orders SET Balance = Balance - 100 where DATE(`Created_at`) < CURRENT_DATE() and Balance < -500$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
