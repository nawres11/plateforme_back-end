-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 13, 2020 at 10:01 PM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uib`
--

-- --------------------------------------------------------

--
-- Table structure for table `flux`
--

DROP TABLE IF EXISTS `flux`;
CREATE TABLE IF NOT EXISTS `flux` (
  `id_flux` int(11) NOT NULL AUTO_INCREMENT,
  `adresse_destinataire` varchar(255) DEFAULT NULL,
  `adresse_source` varchar(255) DEFAULT NULL,
  `cadre` varchar(255) DEFAULT NULL,
  `date_ouverture` varchar(255) DEFAULT NULL,
  `duree` int(11) NOT NULL,
  `nature_echange` varchar(255) DEFAULT NULL,
  `port` int(11) NOT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `type_flux` varchar(255) DEFAULT NULL,
  `id_projet` int(11) NOT NULL,
  `id_serveur` bigint(20) NOT NULL,
  `projet_id_projet` int(11) DEFAULT NULL,
  `is_validated` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id_flux`),
  KEY `FKeowogln1prdcvs9odgm2tiofv` (`id_projet`),
  KEY `FKolna6wbj6fittmjga0mu59dyu` (`id_serveur`),
  KEY `FK3w8tcv6hqaf96o4gkts66s696` (`projet_id_projet`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flux`
--

INSERT INTO `flux` (`id_flux`, `adresse_destinataire`, `adresse_source`, `cadre`, `date_ouverture`, `duree`, `nature_echange`, `port`, `statut`, `type_flux`, `id_projet`, `id_serveur`, `projet_id_projet`, `is_validated`) VALUES
(1, '192.168.1.6', '192.168.1.5', NULL, '12/12/12', 5, NULL, 3030, 'UP', 'sortant', 1, 1, NULL, NULL),
(2, '192.168.1.6', '192.168.1.5', NULL, '12/12/12', 5, NULL, 3030, 'UP', 'sortant', 1, 1, NULL, NULL),
(3, '192.168.1.12', NULL, 'azertykl', '12/12/12', 0, NULL, 0, NULL, NULL, 3, 3, NULL, NULL),
(4, '172.1.1.158', '192.168.2.8', 'Cadre', '12/12/12', 0, NULL, 8585, NULL, NULL, 3, 4, NULL, NULL),
(5, '192.168.1.142', '192.168.1.15', 'MT103', '12/12/12', 0, NULL, 3099, NULL, NULL, 1, 1, NULL, NULL),
(6, '192.168.1.125', '192.168.1.15', 'Demande 15584', '12/04/2020', 0, 'nature', 3258, 'stat1', 'type1', 1, 1, NULL, NULL),
(7, '192.168.1.182', '192.168.1.15', 'DS18zD854', '12/12/12', 0, 'nature', 2968, 'stat2', 'type1', 1, 1, NULL, NULL),
(8, '172.1.1.158', '192.168.2.8', 'CD528K', '2020-09-30', 0, 'nature', 8585, 'stat2', 'type1', 2, 4, NULL, NULL),
(9, '172.1.1.158', '192.168.2.8', 'CD528Kphj', '2020-09-07', 0, 'nature', 8585, 'stat1', 'type2', 3, 4, NULL, NULL),
(10, '192.168.1.12', '192.168.1.15', 'Cadre852DLML', '2020-09-25', 0, 'Projet', 3030, 'stat1', 'type1', 3, 1, NULL, NULL),
(11, '172.1.1.158', '172.128.12.127', 'Cadre 0103', '2020-09-26', 0, 'Audit', 9013, 'stat1', 'type1', 3, 27, NULL, NULL),
(12, '172.1.1.12', '172.128.12.127', 'Nidhal Arouri', '1994-06-02', 0, 'Audit', 9013, 'stat1', 'type1', 3, 27, NULL, NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `flux`
--
ALTER TABLE `flux`
  ADD CONSTRAINT `FK3w8tcv6hqaf96o4gkts66s696` FOREIGN KEY (`projet_id_projet`) REFERENCES `projet` (`id_projet`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKeowogln1prdcvs9odgm2tiofv` FOREIGN KEY (`id_projet`) REFERENCES `projet` (`id_projet`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKolna6wbj6fittmjga0mu59dyu` FOREIGN KEY (`id_serveur`) REFERENCES `serveur` (`id_serveur`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
