-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.13-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for capstone
CREATE DATABASE IF NOT EXISTS `capstone` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `capstone`;

-- Dumping structure for table capstone.buyorders
CREATE TABLE IF NOT EXISTS `buyorders` (
  `order_bid` int(11) NOT NULL,
  `instrument_id` varchar(50) NOT NULL,
  `client_id` varchar(50) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`order_bid`),
  KEY `client_id` (`client_id`),
  KEY `instrument_id` (`instrument_id`),
  CONSTRAINT `client_id` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`),
  CONSTRAINT `instrument_id` FOREIGN KEY (`instrument_id`) REFERENCES `instrument` (`instrument_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table capstone.buyorders: ~0 rows (approximately)
/*!40000 ALTER TABLE `buyorders` DISABLE KEYS */;
/*!40000 ALTER TABLE `buyorders` ENABLE KEYS */;

-- Dumping structure for table capstone.client
CREATE TABLE IF NOT EXISTS `client` (
  `client_id` varchar(50) NOT NULL,
  `client_name` varchar(50) NOT NULL,
  `cust_id` varchar(50) NOT NULL,
  `transaction_limit` double NOT NULL,
  `amount` double NOT NULL,
  PRIMARY KEY (`client_id`),
  KEY `cust_id` (`cust_id`),
  CONSTRAINT `cust_id` FOREIGN KEY (`cust_id`) REFERENCES `custodian` (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table capstone.client: ~0 rows (approximately)
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`client_id`, `client_name`, `cust_id`, `transaction_limit`, `amount`) VALUES
	('DBS001', 'MACQUARIE BANK LIMITED', 'CS001', 14000000, 0),
	('DBS002', 'LLOYDS BANK CORPORATE MARKETS PLC', 'CS001', 14000000, 0),
	('DBS003', 'KEYBANK NATIONAL ASSOCIATION', 'CS001', 18000000, 0),
	('DBS004', 'JP MORGAN SECURITIES LLC', 'CS001', 5000000, 0),
	('DBS005', 'JEFFERIES FINANCIAL SERVICES, INC.', 'CS002', 21000006, 0),
	('DBS006', 'JB DRAX HONORE UK LTD', 'CS002', 21000006, 0),
	('DBS007', 'J ARON & COMPANY SINGAPORE PTE', 'CS002', 18000006, 0),
	('DBS008', 'J ARON & COMPANY LLC', 'CS002', 7500003, 0),
	('DBS009', 'INTESA SANPAOLO SPA', 'CS002', 21000012, 0),
	('DBS010', 'ING CAPITAL MARKETS LLC', 'CS002', 21000012, 0),
	('DBS011', 'ICBC STANDARD BANK PLC', 'CS002', 18000012, 0),
	('DBS012', 'HSBC BANK USA NA', 'CS002', 5000004, 0),
	('DBS013', 'HSBC BANK PLC', 'CS003', 17500015, 0),
	('DBS014', 'GOLDMAN SACHS PARIS INC ET CIE', 'CS003', 28000024, 0),
	('DBS015', 'GOLDMAN SACHS MEXICO CASA DE BOLSA SA DE CV', 'CS003', 12000012, 0),
	('DBS016', 'GAIN GTX LLC', 'CS003', 12500015, 0),
	('DBS017', 'FIFTH THIRD BANK NATIONAL ASSOCIATION', 'CS003', 7000008, 0),
	('DBS018', 'ED&F MAN DERIVATIVE PRODUCTS INC', 'CS003', 28000032, 0),
	('DBS019', 'DEUTSCHE BANK AG', 'CS003', 12000016, 0),
	('DBS020', 'DARBY SWAP TRADING LLC', 'CS003', 7500012, 0),
	('DBS021', 'DANSKE BANK AS', 'CS003', 21000030, 0),
	('DBS022', 'CREDIT SUISSE SECURITIES EUROPE LIMITED', 'CS003', 35000050, 0),
	('DBS023', 'COOPERATIEVE RABOBANK UA', 'CS003', 12000020, 0),
	('DBS024', 'COMMONWEALTH BANK OF AUSTRALIA', 'CS004', 7500015, 0),
	('DBS025', 'CITIGROUP ENERGY INC', 'CS004', 21000036, 0),
	('DBS026', 'CITIBANK N A', 'CS004', 14000024, 0),
	('DBS027', 'CITADEL SECURITIES SWAP DEALER LLC', 'CS004', 36000072, 0),
	('DBS028', 'CARGILL INCORPORATED', 'CS005', 10000024, 0),
	('DBS029', 'CAPITAL ONE NATIONAL ASSOCIATION', 'CS005', 10500021, 0),
	('DBS030', 'CANTOR FITZGERALD SECURITIES', 'CS005', 21000042, 0),
	('DBS031', 'CANADIAN IMPERIAL BANK OF COMMERCE', 'CS005', 12000028, 0),
	('DBS032', 'BP ENERGY COMPANY', 'CS006', 7500021, 0),
	('DBS033', 'BOFA SECURITIES JAPAN CO LTD', 'CS006', 1500000, 0);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;

-- Dumping structure for table capstone.custodian
CREATE TABLE IF NOT EXISTS `custodian` (
  `cust_id` varchar(100) NOT NULL,
  `cust_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table capstone.custodian: ~0 rows (approximately)
/*!40000 ALTER TABLE `custodian` DISABLE KEYS */;
INSERT INTO `custodian` (`cust_id`, `cust_name`, `password`) VALUES
	('CS001', 'BNP Paribas Securities ServicesFrance', 'A123'),
	('CS002', 'The Bank of New York Mellon CorporationU.S.', 'B123'),
	('CS003', 'EuroculearBelgium', 'C123'),
	('CS004', 'HSBC Securities ServicesUnited Kingdom', 'D123'),
	('CS005', 'Credit SuissesSwitzerland', 'E123'),
	('CS006', 'Northen Trust CorporationU.S.', 'F123');
/*!40000 ALTER TABLE `custodian` ENABLE KEYS */;

-- Dumping structure for table capstone.history
CREATE TABLE IF NOT EXISTS `history` (
  `id` int(11) NOT NULL,
  `order_bid` int(11) NOT NULL,
  `order_sid` int(11) NOT NULL,
  `status` enum('Success','Failure') NOT NULL,
  KEY `order_bid` (`order_bid`),
  KEY `order_sid` (`order_sid`),
  CONSTRAINT `order_bid` FOREIGN KEY (`order_bid`) REFERENCES `buyorders` (`order_bid`),
  CONSTRAINT `order_sid` FOREIGN KEY (`order_sid`) REFERENCES `sellorders` (`order_sid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table capstone.history: ~0 rows (approximately)
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
/*!40000 ALTER TABLE `history` ENABLE KEYS */;

-- Dumping structure for table capstone.instrument
CREATE TABLE IF NOT EXISTS `instrument` (
  `instrument_id` varchar(50) NOT NULL,
  `instrument_name` varchar(50) NOT NULL,
  `face_value` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `min_quantity` int(11) NOT NULL,
  PRIMARY KEY (`instrument_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table capstone.instrument: ~0 rows (approximately)
/*!40000 ALTER TABLE `instrument` DISABLE KEYS */;
INSERT INTO `instrument` (`instrument_id`, `instrument_name`, `face_value`, `price`, `expiry_date`, `min_quantity`) VALUES
	('1001', 'US treasury Bills', 100, NULL, NULL, 25),
	('1002', 'RBI-2026-6.5%', 1000, NULL, NULL, 25),
	('1003', 'RBI-2045-8%', 1000, NULL, NULL, 25),
	('1004', 'USDINR', NULL, NULL, NULL, 25),
	('1005', 'EUR USD-FUT', NULL, NULL, '2021-08-28', 25);
/*!40000 ALTER TABLE `instrument` ENABLE KEYS */;

-- Dumping structure for table capstone.sellorders
CREATE TABLE IF NOT EXISTS `sellorders` (
  `order_sid` int(11) NOT NULL,
  `instrument_id` varchar(50) NOT NULL,
  `client_id` varchar(50) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`order_sid`),
  KEY `instrumnt_id` (`instrument_id`),
  KEY `clint_id` (`client_id`),
  CONSTRAINT `clint_id` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`),
  CONSTRAINT `instrumnt_id` FOREIGN KEY (`instrument_id`) REFERENCES `instrument` (`instrument_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table capstone.sellorders: ~0 rows (approximately)
/*!40000 ALTER TABLE `sellorders` DISABLE KEYS */;
/*!40000 ALTER TABLE `sellorders` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
