-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 20, 2020 at 06:16 PM
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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id_user` bigint(20) NOT NULL,
  `date_of_birth` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `UK_c0r9atamxvbhjjvy5j8da1kam` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `admin_roles`
--

DROP TABLE IF EXISTS `admin_roles`;
CREATE TABLE IF NOT EXISTS `admin_roles` (
  `admin_id_user` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  KEY `FK1tckqbr9482dxy81bwk6qevln` (`roles_id`),
  KEY `FK3xacqx8sa6sjtyfif1fwuqa3d` (`admin_id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flux`
--

INSERT INTO `flux` (`id_flux`, `adresse_destinataire`, `adresse_source`, `cadre`, `date_ouverture`, `duree`, `nature_echange`, `port`, `statut`, `type_flux`, `id_projet`, `id_serveur`, `projet_id_projet`, `is_validated`) VALUES
(1, '192.168.1.6', '192.168.1.5', NULL, '12/12/12', 5, NULL, 3030, 'UP', 'sortant', 1, 1, NULL, b'1'),
(2, '192.168.1.6', '192.168.1.5', NULL, '12/12/12', 5, NULL, 3030, 'UP', 'sortant', 1, 1, NULL, b'1'),
(3, '192.168.1.12', NULL, 'azertykl', '12/12/12', 0, NULL, 0, NULL, NULL, 3, 3, NULL, b'1'),
(5, '192.168.1.142', '192.168.1.15', 'MT103', '12/12/12', 0, NULL, 3099, NULL, NULL, 1, 1, NULL, b'0'),
(6, '192.168.1.125', '192.168.1.15', 'Demande 15584', '12/04/2020', 0, 'nature', 3258, 'stat1', 'type1', 1, 1, NULL, b'0'),
(7, '192.168.1.182', '192.168.1.15', 'DS18zD854', '12/12/12', 0, 'nature', 2968, 'stat2', 'type1', 1, 1, NULL, b'1'),
(10, '192.168.1.12', '192.168.1.15', 'Cadre852DLML', '2020-09-25', 0, 'Projet', 3030, 'stat1', 'type1', 3, 1, NULL, b'0'),
(13, '192.168.1.12', '192.168.99.128', 'CD528K56', '2020-09-18', 0, 'Projet', 9000, 'stat1', 'type1', 3, 2, NULL, b'1'),
(14, '172.1.1.158', '192.168.99.128', 'Cadre35', '2020-09-30', 0, 'Audit', 9000, 'stat1', 'type1', 1, 2, NULL, b'0'),
(15, '192.168.1.127', '192.168.0.222', 'PRETEST', '2019-01-02', 0, 'Audit', 8085, 'stat1', 'type1', 1, 1, NULL, b'0'),
(16, '172.1.1.100', '172.128.12.15', 'CD528KD', '2019-01-01', 0, 'Audit', 9874, 'stat1', 'type1', 1, 3, NULL, b'1');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(4),
(4);

-- --------------------------------------------------------

--
-- Table structure for table `projet`
--

DROP TABLE IF EXISTS `projet`;
CREATE TABLE IF NOT EXISTS `projet` (
  `id_projet` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_creation` varchar(255) NOT NULL,
  `intitule_projet` varchar(255) NOT NULL,
  `type_projet` varchar(255) NOT NULL,
  `id_serveur` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_projet`),
  KEY `FKl0lvjjvqvlhwecmk84bpyt07r` (`id_serveur`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `projet`
--

INSERT INTO `projet` (`id_projet`, `date_creation`, `intitule_projet`, `type_projet`, `id_serveur`) VALUES
(1, '2020-07-29', 'BF250', 'Finance', 1),
(2, '2012-12-12', 'UIK', 'UI', 2),
(3, '2019-05-01', 'RecHandler', 'Internal', 3);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `role_name`) VALUES
(1, 'USER'),
(2, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `serveur`
--

DROP TABLE IF EXISTS `serveur`;
CREATE TABLE IF NOT EXISTS `serveur` (
  `id_serveur` bigint(20) NOT NULL AUTO_INCREMENT,
  `intitule` varchar(255) NOT NULL,
  `port` int(11) NOT NULL,
  `statut` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id_serveur`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `serveur`
--

INSERT INTO `serveur` (`id_serveur`, `intitule`, `port`, `statut`, `type`, `url`) VALUES
(1, 'Staging 2', 8085, 'ouvert', 'source', '192.168.0.222'),
(2, 'Staging', 9000, 'ouvert', 'source', '192.168.99.128'),
(3, 'Staging 3', 9874, 'fermé', 'source', '172.128.12.15');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` bigint(20) NOT NULL,
  `date_of_birth` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `date_of_birth`, `email`, `first_name`, `gender`, `last_name`, `password`) VALUES
(1, NULL, 'user@gmail.com', NULL, NULL, NULL, '$2a$10$ufnyNGSZR7LO/kf1BjRbfu0Nw.4YKbLSCg.V82EKrbiufitYeXISO'),
(2, NULL, 'adminuib@gmail.com', NULL, NULL, NULL, '$2a$10$pKGSQSG0AJLNAf.zhhJ0SO3V7rV2R2TXQPFeiBLITI1OBBzVB5Y2.'),
(3, NULL, 'admuib@gmail.com', NULL, NULL, NULL, '$2a$10$eb/InZEWoqjrUj6l0ptoKuLpH4ojLWOWENl8N576W1u4gExVUXOYi');

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id_user` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  KEY `FKj9553ass9uctjrmh0gkqsmv0d` (`roles_id`),
  KEY `FKcwoy89k2wleeoyebc7rfxqu08` (`user_id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_id_user`, `roles_id`) VALUES
(1, 1),
(3, 1),
(3, 2),
(2, 1),
(2, 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin_roles`
--
ALTER TABLE `admin_roles`
  ADD CONSTRAINT `FK1tckqbr9482dxy81bwk6qevln` FOREIGN KEY (`roles_id`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `FK3xacqx8sa6sjtyfif1fwuqa3d` FOREIGN KEY (`admin_id_user`) REFERENCES `admin` (`id_user`);

--
-- Constraints for table `flux`
--
ALTER TABLE `flux`
  ADD CONSTRAINT `FKolna6wbj6fittmjga0mu59dyu` FOREIGN KEY (`id_serveur`) REFERENCES `serveur` (`id_serveur`);

--
-- Constraints for table `projet`
--
ALTER TABLE `projet`
  ADD CONSTRAINT `FKl0lvjjvqvlhwecmk84bpyt07r` FOREIGN KEY (`id_serveur`) REFERENCES `serveur` (`id_serveur`);

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKcwoy89k2wleeoyebc7rfxqu08` FOREIGN KEY (`user_id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `FKj9553ass9uctjrmh0gkqsmv0d` FOREIGN KEY (`roles_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
