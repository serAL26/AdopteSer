-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.31-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema adopte_un_dev
--

CREATE DATABASE IF NOT EXISTS adopte_un_dev;
USE adopte_un_dev;

--
-- Definition of table `adresse`
--

DROP TABLE IF EXISTS `adresse`;
CREATE TABLE `adresse` (
  `id_adresse` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(255) NOT NULL,
  `rue` varchar(255) NOT NULL,
  `idVille` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_adresse`),
  KEY `FKBC5730AF4EBD7C7E` (`idVille`),
  CONSTRAINT `FKBC5730AF4EBD7C7E` FOREIGN KEY (`idVille`) REFERENCES `ville` (`id_ville`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adresse`
--

/*!40000 ALTER TABLE `adresse` DISABLE KEYS */;
INSERT INTO `adresse` (`id_adresse`,`numero`,`rue`,`idVille`) VALUES
  (1,'12','rue des developpeurs heureux',1),
  (2,'12','rue des developpeurs',1),
  (3,'12','rue des developpeurs bienheureux',1),
  (4,'12','rue des developpeurs contents',1),
  (5,'12','rue des developpeurs riches',1),
  (6,'12','rue des developpeurs passionnÃ©s',1),
  (7,'12','rue des developpeurs avares',1),
  (8,'12','rue des developpeurs tristes',1),
  (9,'12','rue des developpeurs creatifs',1),
  (10,'12','rue des developpeurs dÃ©pendants',1),
  (11,'12','rue des developpeurs indÃ©pendants',1),
  (12,'12','rue des developpeurs pauvres',1),
  (13,'12','rue des developpeurs exubÃ©rants',1),
  (14,'12','rue des developpeurs intelligents',1),
  (15,'12','rue des developpeurs dÃ©passÃ©s',1),
  (16,'12','rue des clients',1),
  (17,'12','rue des clients bienheureux',1),
  (18,'12','rue des clients malheureux',1),
  (19,'12','rue des clients riches',1),
  (20,'12','rue des clients pauvres',1),
  (21,'12','rue des clients fatiguants',1),
  (22,'12','rue des clients charismatiques',1),
  (23,'12','rue des clients jeunes',1),
  (24,'12','rue des clients oldschool',1),
  (25,'12','rue des clients interessants',1),
  (26,'12','rue des clients stressÃ©s',1),
  (27,'12','rue des clients stressants',1),
  (28,'12','rue des clients incomprehensibles',1),
  (29,'12','rue des clients perdus',1),
  (30,'12','rue des clients etrangers',1),
  (31,'12','rue des clients exuberants',1),
  (32,'12','rue des clients intelligents',1),
  (33,'12','rue des clients pragmatiques',1),
  (34,'12','rue des clients vertueux',1),
  (35,'12','rue des clients conciliants',1);
/*!40000 ALTER TABLE `adresse` ENABLE KEYS */;


--
-- Definition of table `association_cdc_fonctionnalite`
--

DROP TABLE IF EXISTS `association_cdc_fonctionnalite`;
CREATE TABLE `association_cdc_fonctionnalite` (
  `id_assoc_cdc_fonctionnalite` int(11) NOT NULL AUTO_INCREMENT,
  `idCdc` int(11) DEFAULT NULL,
  `idFonctionnalite` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_assoc_cdc_fonctionnalite`),
  KEY `FKCDEF0DEEAC4C4ECC` (`idFonctionnalite`),
  KEY `FKCDEF0DEEAD7FC49E` (`idCdc`),
  CONSTRAINT `FKCDEF0DEEAD7FC49E` FOREIGN KEY (`idCdc`) REFERENCES `cdc` (`id_cdc`),
  CONSTRAINT `FKCDEF0DEEAC4C4ECC` FOREIGN KEY (`idFonctionnalite`) REFERENCES `fonctionnalite` (`id_fonctionnalite`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `association_cdc_fonctionnalite`
--

/*!40000 ALTER TABLE `association_cdc_fonctionnalite` DISABLE KEYS */;
INSERT INTO `association_cdc_fonctionnalite` (`id_assoc_cdc_fonctionnalite`,`idCdc`,`idFonctionnalite`) VALUES
  (1,1,1),
  (2,2,2),
  (3,3,3),
  (4,4,4),
  (5,5,5),
  (6,6,6),
  (7,8,7),
  (8,9,8),
  (9,11,9);
/*!40000 ALTER TABLE `association_cdc_fonctionnalite` ENABLE KEYS */;


--
-- Definition of table `association_dev_techno`
--

DROP TABLE IF EXISTS `association_dev_techno`;
CREATE TABLE `association_dev_techno` (
  `id_association_dev_techno` int(11) NOT NULL AUTO_INCREMENT,
  `idDeveloppeur` int(11) NOT NULL,
  `idTechnologie` int(11) NOT NULL,
  PRIMARY KEY (`id_association_dev_techno`),
  KEY `FKFE52F8BFDBBDC0B8` (`idDeveloppeur`),
  KEY `FKFE52F8BFB89A002C` (`idTechnologie`),
  CONSTRAINT `FKFE52F8BFB89A002C` FOREIGN KEY (`idTechnologie`) REFERENCES `technologie` (`id_technologie`),
  CONSTRAINT `FKFE52F8BFDBBDC0B8` FOREIGN KEY (`idDeveloppeur`) REFERENCES `utilisateur` (`id_utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `association_dev_techno`
--

/*!40000 ALTER TABLE `association_dev_techno` DISABLE KEYS */;
INSERT INTO `association_dev_techno` (`id_association_dev_techno`,`idDeveloppeur`,`idTechnologie`) VALUES
  (1,1,6),
  (2,2,9),
  (3,3,10),
  (4,4,7),
  (5,5,7),
  (6,6,1),
  (7,6,8),
  (8,6,11),
  (9,7,8),
  (10,8,1),
  (11,8,2),
  (12,9,1),
  (13,9,11),
  (14,10,6),
  (16,12,8),
  (17,13,8),
  (18,13,1),
  (19,13,7),
  (22,8,8),
  (23,14,9),
  (24,15,9),
  (25,11,9);
/*!40000 ALTER TABLE `association_dev_techno` ENABLE KEYS */;


--
-- Definition of table `association_typeservice_techno`
--

DROP TABLE IF EXISTS `association_typeservice_techno`;
CREATE TABLE `association_typeservice_techno` (
  `id_association_typeservice_techno` int(11) NOT NULL AUTO_INCREMENT,
  `idTechnologie` int(11) DEFAULT NULL,
  `idTypeService` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_association_typeservice_techno`),
  KEY `FK456585D9B89A002C` (`idTechnologie`),
  KEY `FK456585D9D68566B0` (`idTypeService`),
  CONSTRAINT `FK456585D9D68566B0` FOREIGN KEY (`idTypeService`) REFERENCES `typeservice` (`id_type_service`),
  CONSTRAINT `FK456585D9B89A002C` FOREIGN KEY (`idTechnologie`) REFERENCES `technologie` (`id_technologie`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `association_typeservice_techno`
--

/*!40000 ALTER TABLE `association_typeservice_techno` DISABLE KEYS */;
INSERT INTO `association_typeservice_techno` (`id_association_typeservice_techno`,`idTechnologie`,`idTypeService`) VALUES
  (1,1,1),
  (2,1,5),
  (3,2,3),
  (4,2,10),
  (5,2,4),
  (6,3,1),
  (7,4,1),
  (8,5,1),
  (9,6,3),
  (10,6,4),
  (11,6,5),
  (12,7,3),
  (13,7,4),
  (14,7,5),
  (15,7,10),
  (16,8,3),
  (17,8,4),
  (18,8,5),
  (19,9,5),
  (20,10,5),
  (21,11,6),
  (22,11,7);
/*!40000 ALTER TABLE `association_typeservice_techno` ENABLE KEYS */;


--
-- Definition of table `cdc`
--

DROP TABLE IF EXISTS `cdc`;
CREATE TABLE `cdc` (
  `id_cdc` int(11) NOT NULL AUTO_INCREMENT,
  `Besoin` varchar(255) NOT NULL,
  `Contexte` varchar(255) NOT NULL,
  `EXISTANT` varchar(255) NOT NULL,
  `date_fin_estimee` datetime DEFAULT NULL,
  `lu` tinyint(1) NOT NULL,
  `tarif` double NOT NULL,
  `id_developpeur` int(11) DEFAULT NULL,
  `idProjet` int(11) DEFAULT NULL,
  `id_remarque` int(11) DEFAULT NULL,
  `idTypeCdc` int(11) NOT NULL,
  PRIMARY KEY (`id_cdc`),
  KEY `FK18022F8BC6C8A` (`idTypeCdc`),
  KEY `FK18022B0AE178F` (`id_developpeur`),
  KEY `FK18022C13E6B1` (`id_remarque`),
  KEY `FK1802275783EFE` (`idProjet`),
  CONSTRAINT `FK1802275783EFE` FOREIGN KEY (`idProjet`) REFERENCES `projet` (`id_projet`),
  CONSTRAINT `FK18022B0AE178F` FOREIGN KEY (`id_developpeur`) REFERENCES `utilisateur` (`id_utilisateur`),
  CONSTRAINT `FK18022C13E6B1` FOREIGN KEY (`id_remarque`) REFERENCES `cdc` (`id_cdc`),
  CONSTRAINT `FK18022F8BC6C8A` FOREIGN KEY (`idTypeCdc`) REFERENCES `typecdc` (`id_type_cdc`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cdc`
--

/*!40000 ALTER TABLE `cdc` DISABLE KEYS */;
INSERT INTO `cdc` (`id_cdc`,`Besoin`,`Contexte`,`EXISTANT`,`date_fin_estimee`,`lu`,`tarif`,`id_developpeur`,`idProjet`,`id_remarque`,`idTypeCdc`) VALUES
  (1,'Notre site internet veut répondre a cette problematique en centralisant, dÃ¢Â?Â?une part, une majoritÃ?Â© des dÃ?Â©veloppeurs freelances sur un mÃ?Âªme espace mais Ã?Â©galement en accompagnant le particulier au maximum.','Les solutions de mise en relation de professionnels de lÃ¢Â?Â?informatique avec des clients Ã?Â  la recherche de dÃ?Â©veloppeurs ne sont pas prÃ?Â©vues aux particuliers ou aux micro-entreprises.','La majoritÃ?Â© des sites proposent un systÃ?Â¨me dÃ¢Â?Â?abonnement en plus de se rÃ?Â©munÃ?Â©rer en rÃ?Â©cupÃ?Â©rant un pourcentage des transactions.','2015-02-04 00:00:00',1,1500,NULL,11,NULL,2),
  (2,'Notre site internet veut répondre a cette problematique en centralisant, dÃ¢Â?Â?une part, une majoritÃ?Â© des dÃ?Â©veloppeurs freelances sur un mÃ?Âªme espace mais Ã?Â©galement en accompagnant le particulier au maximum.','Les solutions de mise en relation de professionnels de lÃ¢Â?Â?informatique avec des clients Ã?Â  la recherche de dÃ?Â©veloppeurs ne sont pas prÃ?Â©vues aux particuliers ou aux micro-entreprises.','La majoritÃ?Â© des sites proposent un systÃ?Â¨me dÃ¢Â?Â?abonnement en plus de se rÃ?Â©munÃ?Â©rer en rÃ?Â©cupÃ?Â©rant un pourcentage des transactions.','2015-02-04 00:00:00',1,1500,NULL,12,NULL,2),
  (3,'Notre site internet veut répondre a cette problematique en centralisant, dÃ¢Â?Â?une part, une majoritÃ?Â© des dÃ?Â©veloppeurs freelances sur un mÃ?Âªme espace mais Ã?Â©galement en accompagnant le particulier au maximum.','Les solutions de mise en relation de professionnels de lÃ¢Â?Â?informatique avec des clients Ã?Â  la recherche de dÃ?Â©veloppeurs ne sont pas prÃ?Â©vues aux particuliers ou aux micro-entreprises.','La majoritÃ?Â© des sites proposent un systÃ?Â¨me dÃ¢Â?Â?abonnement en plus de se rÃ?Â©munÃ?Â©rer en rÃ?Â©cupÃ?Â©rant un pourcentage des transactions.','2015-02-04 00:00:00',1,1500,NULL,13,NULL,2),
  (4,'Notre site internet veut répondre a cette problematique en centralisant, dÃ¢Â?Â?une part, une majoritÃ?Â© des dÃ?Â©veloppeurs freelances sur un mÃ?Âªme espace mais Ã?Â©galement en accompagnant le particulier au maximum.','Les solutions de mise en relation de professionnels de lÃ¢Â?Â?informatique avec des clients Ã?Â  la recherche de dÃ?Â©veloppeurs ne sont pas prÃ?Â©vues aux particuliers ou aux micro-entreprises.','La majoritÃ?Â© des sites proposent un systÃ?Â¨me dÃ¢Â?Â?abonnement en plus de se rÃ?Â©munÃ?Â©rer en rÃ?Â©cupÃ?Â©rant un pourcentage des transactions.','2015-02-04 00:00:00',1,1500,NULL,14,NULL,2),
  (5,'Notre site internet veut rÃ?Â©pondre Ã?Â  cette problÃ?Â©matique en centralisant, dÃ¢Â?Â?une part, une majoritÃ?Â© des dÃ?Â©veloppeurs freelances sur un mÃ?Âªme espace mais Ã?Â©galement en accompagnant le particulier au maximum.','Les solutions de mise en relation de professionnels de lÃ¢Â?Â?informatique avec des clients Ã?Â  la recherche de dÃ?Â©veloppeurs ne sont pas prÃ?Â©vues aux particuliers ou aux micro-entreprises. ','La majoritÃ?Â© des sites proposent un systÃ?Â¨me dÃ¢Â?Â?abonnement en plus de se rÃ?Â©munÃ?Â©rer en rÃ?Â©cupÃ?Â©rant un pourcentage des transactions.','2015-02-04 00:00:00',1,1500,NULL,24,NULL,2),
  (6,'Notre site internet veut rÃ?Â©pondre Ã?Â  cette problÃ?Â©matique en centralisant, dÃ¢Â?Â?une part, une majoritÃ?Â© des dÃ?Â©veloppeurs freelances sur un mÃ?Âªme espace mais Ã?Â©galement en accompagnant le particulier au maximum.','Les solutions de mise en relation de professionnels de lÃ¢Â?Â?informatique avec des clients Ã?Â  la recherche de dÃ?Â©veloppeurs ne sont pas prÃ?Â©vues aux particuliers ou aux micro-entreprises. ','La majoritÃ?Â© des sites proposent un systÃ?Â¨me dÃ¢Â?Â?abonnement en plus de se rÃ?Â©munÃ?Â©rer en rÃ?Â©cupÃ?Â©rant un pourcentage des transactions.','2015-02-04 00:00:00',1,1500,NULL,25,NULL,2),
  (7,'dfgh','dfghj','fdghj',NULL,0,2000,6,24,10,1),
  (8,'Notre site internet veut rÃ?Â©pondre Ã?Â  cette problÃ?Â©matique en centralisant, dÃ¢Â?Â?une part, une majoritÃ?Â© des dÃ?Â©veloppeurs freelances sur un mÃ?Âªme espace mais Ã?Â©galement en accompagnant le particulier au maximum.','Les solutions de mise en relation de professionnels de lÃ¢Â?Â?informatique avec des clients Ã?Â  la recherche de dÃ?Â©veloppeurs ne sont pas prÃ?Â©vues aux particuliers ou aux micro-entreprises. ','La majoritÃ?Â© des sites proposent un systÃ?Â¨me dÃ¢Â?Â?abonnement en plus de se rÃ?Â©munÃ?Â©rer en rÃ?Â©cupÃ?Â©rant un pourcentage des transactions.','2015-02-04 00:00:00',1,1500,NULL,26,NULL,2),
  (9,'Notre site internet veut rÃ?Â©pondre Ã?Â  cette problÃ?Â©matique en centralisant, dÃ¢Â?Â?une part, une majoritÃ?Â© des dÃ?Â©veloppeurs freelances sur un mÃ?Âªme espace mais Ã?Â©galement en accompagnant le particulier au maximum.','Les solutions de mise en relation de professionnels de lÃ¢Â?Â?informatique avec des clients Ã?Â  la recherche de dÃ?Â©veloppeurs ne sont pas prÃ?Â©vues aux particuliers ou aux micro-entreprises. ','La majoritÃ?Â© des sites proposent un systÃ?Â¨me dÃ¢Â?Â?abonnement en plus de se rÃ?Â©munÃ?Â©rer en rÃ?Â©cupÃ?Â©rant un pourcentage des transactions.','2015-02-04 00:00:00',1,1500,NULL,27,NULL,2),
  (10,'kdeje','fe','fe',NULL,0,0,6,24,NULL,1),
  (11,'Notre site internet veut rÃ?Â©pondre Ã?Â  cette problÃ?Â©matique en centralisant, dÃ¢Â?Â?une part, une majoritÃ?Â© des dÃ?Â©veloppeurs freelances sur un mÃ?Âªme espace mais Ã?Â©galement en accompagnant le particulier au maximum.','Les solutions de mise en relation de professionnels de lÃ¢Â?Â?informatique avec des clients Ã?Â  la recherche de dÃ?Â©veloppeurs ne sont pas prÃ?Â©vues aux particuliers ou aux micro-entreprises. ','La majoritÃ?Â© des sites proposent un systÃ?Â¨me dÃ¢Â?Â?abonnement en plus de se rÃ?Â©munÃ?Â©rer en rÃ?Â©cupÃ?Â©rant un pourcentage des transactions.','2015-02-04 00:00:00',1,1500,NULL,28,NULL,2);
/*!40000 ALTER TABLE `cdc` ENABLE KEYS */;


--
-- Definition of table `departement`
--

DROP TABLE IF EXISTS `departement`;
CREATE TABLE `departement` (
  `id_departement` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `numero` varchar(255) NOT NULL,
  PRIMARY KEY (`id_departement`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departement`
--

/*!40000 ALTER TABLE `departement` DISABLE KEYS */;
INSERT INTO `departement` (`id_departement`,`nom`,`numero`) VALUES
  (1,'HAUT DE SEINE','92'),
  (2,'PARIS','75'),
  (3,'HAUT RHIN','68'),
  (4,'BOUCHES DU RHONES','13'),
  (5,'BAS RHIN','67');
/*!40000 ALTER TABLE `departement` ENABLE KEYS */;


--
-- Definition of table `dispo`
--

DROP TABLE IF EXISTS `dispo`;
CREATE TABLE `dispo` (
  `id_dispo` int(11) NOT NULL AUTO_INCREMENT,
  `debutDispo` datetime NOT NULL,
  `finDispo` datetime NOT NULL,
  `idDeveloppeur` int(11) DEFAULT NULL,
  `idTypeDispo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_dispo`),
  KEY `FK5B2A70DBB74C0E0` (`idTypeDispo`),
  KEY `FK5B2A70DDBBDC0B8` (`idDeveloppeur`),
  CONSTRAINT `FK5B2A70DDBBDC0B8` FOREIGN KEY (`idDeveloppeur`) REFERENCES `utilisateur` (`id_utilisateur`),
  CONSTRAINT `FK5B2A70DBB74C0E0` FOREIGN KEY (`idTypeDispo`) REFERENCES `typedispo` (`id_type_dispo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dispo`
--

/*!40000 ALTER TABLE `dispo` DISABLE KEYS */;
INSERT INTO `dispo` (`id_dispo`,`debutDispo`,`finDispo`,`idDeveloppeur`,`idTypeDispo`) VALUES
  (1,'0000-00-00 00:00:00','0000-00-00 00:00:00',1,3),
  (2,'0000-00-00 00:00:00','0000-00-00 00:00:00',2,2),
  (3,'0000-00-00 00:00:00','0000-00-00 00:00:00',3,4),
  (4,'0000-00-00 00:00:00','0000-00-00 00:00:00',4,4),
  (5,'0000-00-00 00:00:00','0000-00-00 00:00:00',5,4),
  (6,'0000-00-00 00:00:00','0000-00-00 00:00:00',6,4),
  (7,'0000-00-00 00:00:00','0000-00-00 00:00:00',7,4),
  (8,'0000-00-00 00:00:00','0000-00-00 00:00:00',8,4),
  (9,'0000-00-00 00:00:00','0000-00-00 00:00:00',9,4),
  (10,'0000-00-00 00:00:00','0000-00-00 00:00:00',10,1);
/*!40000 ALTER TABLE `dispo` ENABLE KEYS */;


--
-- Definition of table `etat_projet`
--

DROP TABLE IF EXISTS `etat_projet`;
CREATE TABLE `etat_projet` (
  `id_etat_projet` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  PRIMARY KEY (`id_etat_projet`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `etat_projet`
--

/*!40000 ALTER TABLE `etat_projet` DISABLE KEYS */;
INSERT INTO `etat_projet` (`id_etat_projet`,`libelle`) VALUES
  (1,'Demarre'),
  (2,'Termine'),
  (3,'Arrete'),
  (4,'En attente');
/*!40000 ALTER TABLE `etat_projet` ENABLE KEYS */;


--
-- Definition of table `fonctionnalite`
--

DROP TABLE IF EXISTS `fonctionnalite`;
CREATE TABLE `fonctionnalite` (
  `id_fonctionnalite` int(11) NOT NULL AUTO_INCREMENT,
  `commentaire` varchar(255) DEFAULT NULL,
  `id_type_fonctionnalite` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_fonctionnalite`),
  KEY `FK541BB7B3599A7FCC` (`id_type_fonctionnalite`),
  CONSTRAINT `FK541BB7B3599A7FCC` FOREIGN KEY (`id_type_fonctionnalite`) REFERENCES `typefonctionnalite` (`id_type_fonctionnalite`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fonctionnalite`
--

/*!40000 ALTER TABLE `fonctionnalite` DISABLE KEYS */;
INSERT INTO `fonctionnalite` (`id_fonctionnalite`,`commentaire`,`id_type_fonctionnalite`) VALUES
  (1,'recruter',3),
  (2,'recruter un dev en lui ajoutant en panier',3),
  (3,'recruter un dev en lui ajoutant en panier',3),
  (4,'recruter',3),
  (5,'xsdfgh',2),
  (6,'efes',2),
  (7,'recruter',3),
  (8,'il faut le gÃ©rer le panier',3),
  (9,'r\'t(',3);
/*!40000 ALTER TABLE `fonctionnalite` ENABLE KEYS */;


--
-- Definition of table `litige`
--

DROP TABLE IF EXISTS `litige`;
CREATE TABLE `litige` (
  `id_litige` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  `motif` varchar(255) NOT NULL,
  `idProjet` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_litige`),
  KEY `FKBE49591075783EFE` (`idProjet`),
  CONSTRAINT `FKBE49591075783EFE` FOREIGN KEY (`idProjet`) REFERENCES `projet` (`id_projet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `litige`
--

/*!40000 ALTER TABLE `litige` DISABLE KEYS */;
/*!40000 ALTER TABLE `litige` ENABLE KEYS */;


--
-- Definition of table `livrable`
--

DROP TABLE IF EXISTS `livrable`;
CREATE TABLE `livrable` (
  `id_livrable` int(11) NOT NULL AUTO_INCREMENT,
  `date_livraison` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `echeance` datetime NOT NULL,
  `fichier` varchar(255) DEFAULT NULL,
  `idDeveloppeur` int(11) DEFAULT NULL,
  `idProjet` int(11) DEFAULT NULL,
  `idTypeEvaluation` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_livrable`),
  KEY `FK553D21D3DBBDC0B8` (`idDeveloppeur`),
  KEY `FK553D21D341FF6772` (`idTypeEvaluation`),
  KEY `FK553D21D375783EFE` (`idProjet`),
  CONSTRAINT `FK553D21D375783EFE` FOREIGN KEY (`idProjet`) REFERENCES `projet` (`id_projet`),
  CONSTRAINT `FK553D21D341FF6772` FOREIGN KEY (`idTypeEvaluation`) REFERENCES `typeevaluation` (`id_type_evaluation`),
  CONSTRAINT `FK553D21D3DBBDC0B8` FOREIGN KEY (`idDeveloppeur`) REFERENCES `utilisateur` (`id_utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `livrable`
--

/*!40000 ALTER TABLE `livrable` DISABLE KEYS */;
INSERT INTO `livrable` (`id_livrable`,`date_livraison`,`description`,`echeance`,`fichier`,`idDeveloppeur`,`idProjet`,`idTypeEvaluation`) VALUES
  (1,'2016-03-09 01:10:00','premier livrable','2016-03-10 01:10:00','',6,4,2),
  (2,'0000-00-00 00:00:00',NULL,'0000-00-00 00:00:00','',6,5,1),
  (3,'0000-00-00 00:00:00',NULL,'0000-00-00 00:00:00','Paypal.pdf',6,5,3),
  (4,'0000-00-00 00:00:00',NULL,'0000-00-00 00:00:00','Paypal.pdf',6,6,3),
  (5,'0000-00-00 00:00:00',NULL,'2016-02-04 13:40:43','',6,7,3),
  (6,'0000-00-00 00:00:00',NULL,'0000-00-00 00:00:00','Paypal.pdf',6,8,3),
  (7,'0000-00-00 00:00:00',NULL,'0000-00-00 00:00:00','Paypal.pdf',6,9,3),
  (8,NULL,'Livrable test','2010-01-10 01:10:00',NULL,1,24,2),
  (9,NULL,'test livrable','2010-01-10 01:10:00',NULL,6,24,2),
  (10,NULL,'livrable','2010-01-10 01:10:00',NULL,1,24,2),
  (11,NULL,'sdfgh','2010-01-10 01:10:00',NULL,1,26,2),
  (12,NULL,'dsdzd','2010-01-10 01:10:00',NULL,6,26,2),
  (13,NULL,'deuxieme livrable','2016-06-10 01:10:00',NULL,6,4,2);
/*!40000 ALTER TABLE `livrable` ENABLE KEYS */;


--
-- Definition of table `message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id_message` int(11) NOT NULL AUTO_INCREMENT,
  `date_envoi` datetime NOT NULL,
  `lu` tinyint(1) NOT NULL,
  `MESSAGE` varchar(255) NOT NULL,
  `TITRE` varchar(255) NOT NULL,
  `idMessFille` int(11) DEFAULT NULL,
  `idMessMere` int(11) DEFAULT NULL,
  `idUtilisateur1` int(11) DEFAULT NULL,
  `idUtilisateur2` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_message`),
  KEY `FK38EB000793523382` (`idUtilisateur2`),
  KEY `FK38EB000793523381` (`idUtilisateur1`),
  KEY `FK38EB00075C431A6B` (`idMessFille`),
  KEY `FK38EB000734A82ABA` (`idMessMere`),
  CONSTRAINT `FK38EB000734A82ABA` FOREIGN KEY (`idMessMere`) REFERENCES `message` (`id_message`),
  CONSTRAINT `FK38EB00075C431A6B` FOREIGN KEY (`idMessFille`) REFERENCES `message` (`id_message`),
  CONSTRAINT `FK38EB000793523381` FOREIGN KEY (`idUtilisateur1`) REFERENCES `utilisateur` (`id_utilisateur`),
  CONSTRAINT `FK38EB000793523382` FOREIGN KEY (`idUtilisateur2`) REFERENCES `utilisateur` (`id_utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `message`
--

/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` (`id_message`,`date_envoi`,`lu`,`MESSAGE`,`TITRE`,`idMessFille`,`idMessMere`,`idUtilisateur1`,`idUtilisateur2`) VALUES
  (1,'2016-02-04 12:50:51',0,'dfghjkl','derghjk',NULL,NULL,17,3),
  (2,'2016-02-04 12:54:55',1,'Salut ca va toi ?','dfgh',3,NULL,17,6),
  (3,'2016-02-04 12:55:23',0,'Ben ouais carrÃ©ment. Ca a l\'air de marcher; ','dfgh',NULL,2,6,17),
  (4,'2016-02-04 13:15:14',1,'Vous avez l\'air vraiment bon. Quand pouvez vous commencer Ã  dÃ©velopper ?','DisponibilitÃ©s',5,NULL,17,6),
  (5,'2016-02-04 13:19:10',0,'tout de suite','DisponibilitÃ©s',NULL,4,6,17);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;


--
-- Definition of table `note`
--

DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `id_note` int(11) NOT NULL AUTO_INCREMENT,
  `Commentaire` varchar(255) DEFAULT NULL,
  `Date` datetime NOT NULL,
  `Note` double NOT NULL,
  `id_est_note` int(11) NOT NULL,
  `id_noteur` int(11) NOT NULL,
  `idProjet` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_note`),
  KEY `FK33AFF275783EFE` (`idProjet`),
  CONSTRAINT `FK33AFF275783EFE` FOREIGN KEY (`idProjet`) REFERENCES `projet` (`id_projet`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `note`
--

/*!40000 ALTER TABLE `note` DISABLE KEYS */;
INSERT INTO `note` (`id_note`,`Commentaire`,`Date`,`Note`,`id_est_note`,`id_noteur`,`idProjet`) VALUES
  (1,'tres bien travail','2016-02-03 00:00:00',5,1,17,5),
  (2,'peut mieux faire','2016-02-03 00:00:00',4,1,19,4),
  (3,'mauvaise assimilation du client avec les methodes agiles','2016-02-03 00:00:00',1,19,1,4),
  (4,'excelent client toujours disponible pour repondre aux questions','2016-02-03 00:00:00',5,17,1,5),
  (5,'Enfin un developpeur qui sait developper !il propose des idées innovantes et fonctionnelle avec une rapidité d\'execution du niveau d\'un ordinateur nouvelle generation.','2016-02-03 00:00:00',5,6,19,5),
  (6,'Deux jours ! deux jours pour me faire un site Ecommerce alors que des entreprises du numerique me proposait un an de developpement ! Il a utilisé des nouvelles technologies innovantes tel que le COBOL et le FORTRAN (ironique) qui lui ont fait gagné un tem','2016-02-03 00:00:00',5,6,20,6),
  (7,'Du bon travail mais il a du maitriser un outil technologique ce qui lui a fait perdre du temps et donc une etoile...','2016-02-03 00:00:00',4,6,21,7),
  (8,'je veux mon application qui tourne sous blackberry, donc je refuse tous conseils concernant le support d\'utilisation de mon application. le developpeur n\'est pas la pour conseiller un MOA mais pour appliquer les ordre qu\'on lui donne.','2016-02-03 00:00:00',2,6,21,8),
  (9,'une application developpé à temps ','2016-02-03 00:00:00',4,6,21,9),
  (10,'Enfin une personne qui aime travailler en agilité et qui s\'adapte à tout changement de planning','2016-02-03 00:00:00',5,6,22,10),
  (11,'une application developpé à temps et tres aimable','2016-02-03 00:00:00',5,8,23,11),
  (12,'une application developpé à temps ','2016-02-03 00:00:00',3,13,24,12),
  (13,'une application developpé à temps ','2016-02-03 00:00:00',4,2,25,13),
  (14,'une application developpé à temps ','2016-02-03 00:00:00',2,3,26,14),
  (15,'une application developpé à temps ','2016-02-03 00:00:00',1,4,27,15),
  (16,'une application developpé à temps ','2016-02-03 00:00:00',3,5,27,16),
  (17,'une application developpé à temps ','2016-02-03 00:00:00',1,7,27,17),
  (18,'une application developpé à temps ','2016-02-03 00:00:00',1,9,28,18),
  (19,'une application developpé à temps ','2016-02-03 00:00:00',1,10,29,19),
  (20,'une application developpé à temps ','2016-02-03 00:00:00',1,11,30,20),
  (21,'une application developpé à temps ','2016-02-03 00:00:00',3,12,31,21),
  (22,'une application developpé à temps ','2016-02-03 00:00:00',2,14,31,22),
  (23,'une application developpé à temps ','2016-02-03 00:00:00',3,15,31,23);
/*!40000 ALTER TABLE `note` ENABLE KEYS */;


--
-- Definition of table `operation`
--

DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation` (
  `id_operation` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `montant` double NOT NULL,
  `idLivrable` int(11) DEFAULT NULL,
  `idTypeOperation` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_operation`),
  KEY `FK631AD56728224A94` (`idTypeOperation`),
  KEY `FK631AD56719EC278C` (`idLivrable`),
  CONSTRAINT `FK631AD56719EC278C` FOREIGN KEY (`idLivrable`) REFERENCES `livrable` (`id_livrable`),
  CONSTRAINT `FK631AD56728224A94` FOREIGN KEY (`idTypeOperation`) REFERENCES `typeoperation` (`id_type_operation`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `operation`
--

/*!40000 ALTER TABLE `operation` DISABLE KEYS */;
INSERT INTO `operation` (`id_operation`,`date`,`montant`,`idLivrable`,`idTypeOperation`) VALUES
  (1,'0000-00-00 00:00:00',20,1,1),
  (2,'0000-00-00 00:00:00',10,2,2),
  (3,NULL,35,8,3),
  (4,NULL,55,9,3),
  (5,NULL,35,10,3),
  (6,NULL,35,11,3),
  (7,NULL,35,12,3);
/*!40000 ALTER TABLE `operation` ENABLE KEYS */;


--
-- Definition of table `projet`
--

DROP TABLE IF EXISTS `projet`;
CREATE TABLE `projet` (
  `id_projet` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `idClient` int(11) DEFAULT NULL,
  `idEtatProjet` int(11) DEFAULT NULL,
  `idTypeService` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_projet`),
  KEY `FKC5994CCC78619762` (`idEtatProjet`),
  KEY `FKC5994CCC486B8CFC` (`idClient`),
  KEY `FKC5994CCCD68566B0` (`idTypeService`),
  CONSTRAINT `FKC5994CCCD68566B0` FOREIGN KEY (`idTypeService`) REFERENCES `typeservice` (`id_type_service`),
  CONSTRAINT `FKC5994CCC486B8CFC` FOREIGN KEY (`idClient`) REFERENCES `utilisateur` (`id_utilisateur`),
  CONSTRAINT `FKC5994CCC78619762` FOREIGN KEY (`idEtatProjet`) REFERENCES `etat_projet` (`id_etat_projet`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `projet`
--

/*!40000 ALTER TABLE `projet` DISABLE KEYS */;
INSERT INTO `projet` (`id_projet`,`libelle`,`photo`,`idClient`,`idEtatProjet`,`idTypeService`) VALUES
  (1,'Site de vente des cadeaux de saint valentin','portfolio1.jpg',17,4,3),
  (2,'Site de gestion pour les ONG','portfolio2.jpg',17,4,8),
  (3,'Site de vente des bijoux','portfolio3.jpg',17,1,8),
  (4,'Site de vente des Vetements','portfolio4.jpg',17,2,5),
  (5,'SiteWebPerso','portfolio5.jpg',19,2,4),
  (6,'siteEcommerce','portfolio4.jpg',20,2,5),
  (7,'ApplicationMobile','portfolio5.jpg',21,2,8),
  (8,'ApplicationMobile','portfolio7.jpg',21,2,9),
  (9,'ApplicationMobile','portfolio8.jpg',21,2,6),
  (10,'ConversionModeleEnSite','portfolio6.jpg',22,1,3),
  (11,'siteEcommerce','portfolio7.jpg',23,2,3),
  (12,'siteEcommerce','portfolio7.jpg',24,2,3),
  (13,'siteEcommerce','portfolio2.jpg',25,2,3),
  (14,'siteEcommerce','portfolio4.jpg',26,2,3),
  (15,'siteEcommerce','portfolio8.jpg',26,2,3),
  (16,'siteEcommerce','portfolio8.jpg',26,2,3),
  (17,'siteEcommerce','portfolio8.jpg',27,2,3),
  (18,'siteEcommerce','portfolio8.jpg',27,2,3),
  (19,'siteEcommerce','portfolio8.jpg',27,2,3),
  (20,'siteEcommerce','portfolio8.jpg',28,2,3),
  (21,'siteEcommerce','portfolio8.jpg',29,2,3),
  (22,'siteEcommerce','portfolio8.jpg',30,2,3),
  (23,'siteEcommerce','portfolio8.jpg',31,2,3),
  (24,'Site de vente des chaussures taille 37','portfolio4.jpg',17,4,3),
  (25,'Site de vente des cadeaux pour tous','portfolio5.jpg',17,4,2),
  (26,'Site de Vente des chaussures pour bébé','portfolio3.jpg',17,4,4),
  (27,'Site de Vente CDiscount','portfolio4.jpg',17,4,3),
  (28,'defrgthy','avatarDeveloppeur8.jpg',17,4,2);
/*!40000 ALTER TABLE `projet` ENABLE KEYS */;


--
-- Definition of table `propostion`
--

DROP TABLE IF EXISTS `propostion`;
CREATE TABLE `propostion` (
  `id_proposition` int(11) NOT NULL AUTO_INCREMENT,
  `Lu` tinyint(1) NOT NULL,
  `date` datetime NOT NULL,
  `titre` varchar(255) NOT NULL,
  `idDeveloppeur` int(11) DEFAULT NULL,
  `idProjet` int(11) DEFAULT NULL,
  `idTypeProposition` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_proposition`),
  KEY `FKD9EC1C1BDBBDC0B8` (`idDeveloppeur`),
  KEY `FKD9EC1C1B5F4663F2` (`idTypeProposition`),
  KEY `FKD9EC1C1B75783EFE` (`idProjet`),
  CONSTRAINT `FKD9EC1C1B75783EFE` FOREIGN KEY (`idProjet`) REFERENCES `projet` (`id_projet`),
  CONSTRAINT `FKD9EC1C1B5F4663F2` FOREIGN KEY (`idTypeProposition`) REFERENCES `typeproposition` (`id_type_proposition`),
  CONSTRAINT `FKD9EC1C1BDBBDC0B8` FOREIGN KEY (`idDeveloppeur`) REFERENCES `utilisateur` (`id_utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `propostion`
--

/*!40000 ALTER TABLE `propostion` DISABLE KEYS */;
INSERT INTO `propostion` (`id_proposition`,`Lu`,`date`,`titre`,`idDeveloppeur`,`idProjet`,`idTypeProposition`) VALUES
  (1,1,'2015-02-12 00:00:00','siteEcomnerce',1,11,3),
  (2,1,'2015-02-12 00:00:00','siteEcomnerce',2,12,3),
  (3,1,'2015-02-12 00:00:00','siteEcomnerce',3,13,3),
  (4,1,'2015-02-12 00:00:00','siteEcomnerce',4,14,3),
  (8,1,'2015-02-12 00:00:00','siteEcomnerce',5,15,3),
  (9,1,'2015-02-12 00:00:00','DoYouKnow',6,1,3),
  (10,1,'2015-02-12 00:00:00','ShowMeYourFace',6,2,3),
  (11,1,'2015-02-12 00:00:00','HugNeeded',6,3,3),
  (12,1,'2015-02-12 00:00:00','BoutiqueDeVetement',6,4,3),
  (13,1,'2015-02-12 00:00:00','SiteWebPerso',6,5,3),
  (14,1,'2015-02-12 00:00:00','siteEcommerce',6,6,3),
  (15,1,'2015-02-12 00:00:00','ApplicationMobile',6,7,3),
  (16,1,'2015-02-12 00:00:00','ApplicationMobile',6,8,3),
  (17,1,'2015-02-12 00:00:00','ApplicationMobile',6,9,3),
  (18,1,'2015-02-12 00:00:00','ConversionModeleEnSite',6,10,3),
  (19,1,'2015-02-12 00:00:00','siteEcommerce',7,16,3),
  (20,1,'2015-02-12 00:00:00','siteEcommerce',8,17,3),
  (21,1,'2015-02-12 00:00:00','siteEcommerce',17,18,3),
  (22,1,'2015-02-12 00:00:00','siteEcommerce',10,19,3),
  (23,1,'2015-02-12 00:00:00','siteEcommerce',11,20,3),
  (24,1,'2015-02-12 00:00:00','siteEcommerce',12,21,3),
  (25,1,'2015-02-12 00:00:00','siteEcommerce',13,22,3),
  (26,1,'2015-02-12 00:00:00','siteEcommerce',14,23,3),
  (27,1,'2016-02-04 12:51:03','',1,24,1),
  (28,0,'2016-02-04 12:51:03','',3,24,1),
  (29,0,'2016-02-04 12:51:03','',2,24,1),
  (30,1,'2016-02-04 12:56:25','',6,24,2),
  (31,1,'2016-02-04 13:15:24','',7,26,1),
  (32,1,'2016-02-04 13:15:24','',6,26,2),
  (33,1,'2016-02-04 13:15:24','',11,26,1),
  (34,0,'2016-02-04 13:33:16','',6,28,1);
/*!40000 ALTER TABLE `propostion` ENABLE KEYS */;


--
-- Definition of table `technologie`
--

DROP TABLE IF EXISTS `technologie`;
CREATE TABLE `technologie` (
  `id_technologie` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  PRIMARY KEY (`id_technologie`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `technologie`
--

/*!40000 ALTER TABLE `technologie` DISABLE KEYS */;
INSERT INTO `technologie` (`id_technologie`,`libelle`) VALUES
  (1,'JAVA'),
  (2,'PHP'),
  (3,'C'),
  (4,'C#'),
  (5,'C++'),
  (6,'HTML'),
  (7,'CSS'),
  (8,'JAVASCRIPT'),
  (9,'FORTRAN'),
  (10,'COBOL'),
  (11,'SWIFT');
/*!40000 ALTER TABLE `technologie` ENABLE KEYS */;


--
-- Definition of table `typeappli`
--

DROP TABLE IF EXISTS `typeappli`;
CREATE TABLE `typeappli` (
  `id_type_appli` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  PRIMARY KEY (`id_type_appli`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `typeappli`
--

/*!40000 ALTER TABLE `typeappli` DISABLE KEYS */;
INSERT INTO `typeappli` (`id_type_appli`,`libelle`) VALUES
  (1,'SITE WEB'),
  (2,'LOGICIEL'),
  (3,'MOBILE');
/*!40000 ALTER TABLE `typeappli` ENABLE KEYS */;


--
-- Definition of table `typecdc`
--

DROP TABLE IF EXISTS `typecdc`;
CREATE TABLE `typecdc` (
  `id_type_cdc` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  PRIMARY KEY (`id_type_cdc`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `typecdc`
--

/*!40000 ALTER TABLE `typecdc` DISABLE KEYS */;
INSERT INTO `typecdc` (`id_type_cdc`,`libelle`) VALUES
  (1,'REMARQUE'),
  (2,'CAHIER DE CHARGE');
/*!40000 ALTER TABLE `typecdc` ENABLE KEYS */;


--
-- Definition of table `typedispo`
--

DROP TABLE IF EXISTS `typedispo`;
CREATE TABLE `typedispo` (
  `id_type_dispo` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  PRIMARY KEY (`id_type_dispo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `typedispo`
--

/*!40000 ALTER TABLE `typedispo` DISABLE KEYS */;
INSERT INTO `typedispo` (`id_type_dispo`,`libelle`) VALUES
  (1,'WEEKEND'),
  (2,'SOIR'),
  (3,'TOUTE LA JOURNEE'),
  (4,'INDISPONIBLE');
/*!40000 ALTER TABLE `typedispo` ENABLE KEYS */;


--
-- Definition of table `typeevaluation`
--

DROP TABLE IF EXISTS `typeevaluation`;
CREATE TABLE `typeevaluation` (
  `id_type_evaluation` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  PRIMARY KEY (`id_type_evaluation`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `typeevaluation`
--

/*!40000 ALTER TABLE `typeevaluation` DISABLE KEYS */;
INSERT INTO `typeevaluation` (`id_type_evaluation`,`libelle`) VALUES
  (1,'REFUSE'),
  (2,'EN ATTENTE'),
  (3,'VALIDE');
/*!40000 ALTER TABLE `typeevaluation` ENABLE KEYS */;


--
-- Definition of table `typefonctionnalite`
--

DROP TABLE IF EXISTS `typefonctionnalite`;
CREATE TABLE `typefonctionnalite` (
  `id_type_fonctionnalite` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  PRIMARY KEY (`id_type_fonctionnalite`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `typefonctionnalite`
--

/*!40000 ALTER TABLE `typefonctionnalite` DISABLE KEYS */;
INSERT INTO `typefonctionnalite` (`id_type_fonctionnalite`,`libelle`) VALUES
  (1,'AUTRE'),
  (2,'GESTION DES UTILISATEURS'),
  (3,'GESTION du panier');
/*!40000 ALTER TABLE `typefonctionnalite` ENABLE KEYS */;


--
-- Definition of table `typeoperation`
--

DROP TABLE IF EXISTS `typeoperation`;
CREATE TABLE `typeoperation` (
  `id_type_operation` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  PRIMARY KEY (`id_type_operation`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `typeoperation`
--

/*!40000 ALTER TABLE `typeoperation` DISABLE KEYS */;
INSERT INTO `typeoperation` (`id_type_operation`,`libelle`) VALUES
  (1,'DEBIT'),
  (2,'CREDIT'),
  (3,'EN ATTENTE'),
  (4,'TERMINE');
/*!40000 ALTER TABLE `typeoperation` ENABLE KEYS */;


--
-- Definition of table `typeproposition`
--

DROP TABLE IF EXISTS `typeproposition`;
CREATE TABLE `typeproposition` (
  `id_type_proposition` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  PRIMARY KEY (`id_type_proposition`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `typeproposition`
--

/*!40000 ALTER TABLE `typeproposition` DISABLE KEYS */;
INSERT INTO `typeproposition` (`id_type_proposition`,`libelle`) VALUES
  (1,'EN ATTENTE'),
  (2,'ACCEPTE PAR LE DEV'),
  (3,'VALIDE PAR LE CLIENT'),
  (4,'REFUSE');
/*!40000 ALTER TABLE `typeproposition` ENABLE KEYS */;


--
-- Definition of table `typeservice`
--

DROP TABLE IF EXISTS `typeservice`;
CREATE TABLE `typeservice` (
  `id_type_service` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  `idTypeAppli` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_type_service`),
  KEY `FKA19B1A1BBB267982` (`idTypeAppli`),
  CONSTRAINT `FKA19B1A1BBB267982` FOREIGN KEY (`idTypeAppli`) REFERENCES `typeappli` (`id_type_appli`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `typeservice`
--

/*!40000 ALTER TABLE `typeservice` DISABLE KEYS */;
INSERT INTO `typeservice` (`id_type_service`,`libelle`,`idTypeAppli`) VALUES
  (1,'CODEZ UN LOGICIEL',2),
  (2,'DEVELOPPEZ UNE APPLICATION MAC',2),
  (3,'CONVERTISSEZ UN MODELE EN UN SITE WEB',1),
  (4,'CREER UNE BOUTIQUE EN LIGNE',1),
  (5,'CODEZ UNE APPLICATION IPHONE',3),
  (6,'CODEZ UNE APPLICATION IPAD',3),
  (7,'CODEZ UNE APPLICATION ANDROID',3),
  (8,'CODEZ UNE APPLICATION BLACKBERRY',3),
  (9,'CODEZ UN SITE WEB MOBILE',3);
/*!40000 ALTER TABLE `typeservice` ENABLE KEYS */;


--
-- Definition of table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE `utilisateur` (
  `type_utilisateur` varchar(31) NOT NULL,
  `id_utilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `date_inscription` datetime NOT NULL,
  `Fixe` varchar(255) DEFAULT NULL,
  `Nom` varchar(255) NOT NULL,
  `Photo` varchar(255) DEFAULT NULL,
  `Portable` varchar(255) DEFAULT NULL,
  `Prenom` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `idAdresse` int(11) NOT NULL,
  PRIMARY KEY (`id_utilisateur`),
  KEY `FKDD163383D71D68B8` (`idAdresse`),
  CONSTRAINT `FKDD163383D71D68B8` FOREIGN KEY (`idAdresse`) REFERENCES `adresse` (`id_adresse`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `utilisateur`
--

/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` (`type_utilisateur`,`id_utilisateur`,`date_inscription`,`Fixe`,`Nom`,`Photo`,`Portable`,`Prenom`,`mail`,`mdp`,`idAdresse`) VALUES
  ('DEVELOPPEUR',1,'2015-02-12 00:00:00','148910675','AHMIM','resources/img/avatarDeveloppeur2.jpg','643677732','Ferhat','ferhat.ahmim@gmail.com','azerty',1),
  ('DEVELOPPEUR',2,'2015-02-12 00:00:00',NULL,'AIT TALEB','avatarDeveloppeur2.jpg','605017075','Lahcen','aittaleb.lahcen@yahoo.fr','azerty',2),
  ('DEVELOPPEUR',3,'2015-02-12 00:00:00',NULL,'ESSID','avatarDeveloppeur14.jpg','695264816','Amal','amal.jaziri@gmail.com','azerty',3),
  ('DEVELOPPEUR',4,'2015-02-12 00:00:00',NULL,'HICHRI','avatarDeveloppeur4.jpg','778020125','Sabrine','sabrine.hichri@gmail.com','azerty',4),
  ('DEVELOPPEUR',5,'2015-02-12 00:00:00',NULL,'MORIN','avatarDeveloppeur6.jpg','625830547','Sylvain','morin.slv@gmail.com','azerty',5),
  ('DEVELOPPEUR',6,'2015-02-12 00:00:00',NULL,'QUERE','avatarDeveloppeur5.jpg','633120842','Alexandre','alexquere1@gmail.com','azerty',6),
  ('DEVELOPPEUR',7,'2015-02-12 00:00:00',NULL,'WAILLE','avatarDeveloppeur14.jpg','646808184','Emilie','ewaille@hotmail.fr','azerty',9),
  ('DEVELOPPEUR',8,'2015-02-12 00:00:00',NULL,'ROIGNANT','avatarDeveloppeur.jpg','665335584','Pierre-Yves','py@roignant.fr','azerty',8),
  ('DEVELOPPEUR',9,'2015-02-12 00:00:00',NULL,'BINISTI','avatarDeveloppeur3.jpg','612134556','Mickael','mickael.binisti@iris.fr','afcepf',1),
  ('DEVELOPPEUR',10,'2015-02-12 00:00:00',NULL,'ZHANG','avatarDeveloppeur7.jpg','650499021','Gege','gege.zhang@gmx.com','azerty',14),
  ('DEVELOPPEUR',11,'2015-02-12 00:00:00',NULL,'SABOUNDJI','avatarDeveloppeur10.jpg','661506153','Mehdi','mehdi.saboundji','azerty',17),
  ('DEVELOPPEUR',12,'2015-02-12 00:00:00',NULL,'LE BARON','avatarDeveloppeur9.jpg','671972061','Jerome','lebaronjerome@free.fr','azerty',19),
  ('DEVELOPPEUR',13,'2015-02-12 00:00:00',NULL,'GUERIN','avatarDeveloppeur8.jpg','683269593','Emmanuel','emmanuel.guerin9@gmail.com','azerty',7),
  ('DEVELOPPEUR',14,'2015-02-12 00:00:00',NULL,'DANGUEUGER','avatarDeveloppeur11.jpg','637449875','Raphael','raphael.dangueuger@gmail.com','azerty',10),
  ('DEVELOPPEUR',15,'2015-02-12 00:00:00',NULL,'ESTACAILLE','avatarDeveloppeur12.jpg','603943699','Julien','julien.estacaille@gmail.com','azerty',12),
  ('CLIENT',16,'2015-02-12 00:00:00',NULL,'RAKOTOMALALA','portfolio4.jpg','611121314','Patrick','patrick.rakotomalala@madagascar.com','afcepf',2),
  ('CLIENT',17,'2015-02-12 00:00:00','123124565','ZRELLI','portfolio5.jpg',NULL,'Yasmine','yasmine_zr@hotmail.fr','azerty',15),
  ('CLIENT',18,'2015-02-12 00:00:00','123124565','PIERRE','portfolio6.jpg','612134556','Pierre','pierre@gmail.com','afcepf',3),
  ('CLIENT',19,'2015-02-12 00:00:00','123124565','PAUL','img.jpg','612134556','Paul','paul@gmail.com','afcepf',1),
  ('CLIENT',20,'2015-02-12 00:00:00','123124565','JACQUES','avatarDeveloppeur12.jpg','612134556','Jacques','jacques@gmail.com','afcepf',6),
  ('CLIENT',21,'2015-02-12 00:00:00','123124565','FRANCOIS','avatarDeveloppeur12.jpg','612134556','Francois','francois@gmail.com','afcepf',1),
  ('CLIENT',22,'2015-02-12 00:00:00','123124565','MATTHIEU','avatarDeveloppeur12.jpg','612134556','Matthieu','matthieu@gmail.com','afcepf',2),
  ('CLIENT',23,'2015-02-12 00:00:00','123124565','JOSEPH','avatarDeveloppeur12.jpg','612134556','Joseph','joseph@gmail.com','afcepf',3),
  ('CLIENT',24,'2015-02-12 00:00:00','123124565','THIERRY','avatarDeveloppeur12.jpg','612134556','Thierry','thierry@gmail.com','afcepf',1),
  ('CLIENT',25,'2015-02-12 00:00:00','123124565','KARIM','avatarDeveloppeur12.jpg','612134556','Karim','karim@gmail.com','afcepf',2),
  ('CLIENT',26,'2015-02-12 00:00:00','123124565','ALADDIN','avatarDeveloppeur12.jpg','612134556','Jasmine','jasmine@gmail.com','afcepf',1),
  ('CLIENT',27,'2015-02-12 00:00:00','123124565','POISSON','avatarDeveloppeur12.jpg','612134556','Ariel','ariel@gmail.com','afcepf',2),
  ('CLIENT',28,'2015-02-12 00:00:00','123124565','Margot','avatarDeveloppeur12.jpg','612134556','Robbie','margotrobbie@gmail.com','afcepf',1),
  ('CLIENT',29,'2015-02-12 00:00:00','123124565','LING','avatarDeveloppeur12.jpg','612134556','Ling','ling@gmail.com','afcepf',2),
  ('CLIENT',30,'2015-02-12 00:00:00','123124565','CELINE','avatarDeveloppeur12.jpg','612134556','celine','celine@gmail.com','afcepf',1),
  ('CLIENT',31,'2015-02-12 00:00:00','123124565','LAETICIA','avatarDeveloppeur12.jpg','612134556','Laeticia','laeticia@gmail.com','afcepf',3),
  ('CLIENT',32,'2015-02-12 00:00:00','123124565','MARIE','avatarDeveloppeur12.jpg','612134556','Marie','marie@gmail.com','afcepf',2),
  ('CLIENT',33,'2015-02-12 00:00:00','123124565','ELODIE','avatarDeveloppeur12.jpg','612134556','Elodie','elodie@gmail.com','afcepf',3),
  ('CLIENT',34,'2015-02-12 00:00:00','123124565','AURELIA','avatarDeveloppeur12.jpg','612134556','Aurelia','aurelia@gmail.com','afcepf',1),
  ('CLIENT',35,'2015-02-12 00:00:00','123124565','NATHALIE','avatarDeveloppeur12.jpg','612134556','Nathalie','nathalie@gmail.com','afcepf',2);
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;


--
-- Definition of table `ville`
--

DROP TABLE IF EXISTS `ville`;
CREATE TABLE `ville` (
  `id_ville` int(11) NOT NULL AUTO_INCREMENT,
  `cp` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `idDepartemen` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_ville`),
  KEY `FK6B03352C3EFD6C4` (`idDepartemen`),
  CONSTRAINT `FK6B03352C3EFD6C4` FOREIGN KEY (`idDepartemen`) REFERENCES `departement` (`id_departement`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ville`
--

/*!40000 ALTER TABLE `ville` DISABLE KEYS */;
INSERT INTO `ville` (`id_ville`,`cp`,`nom`,`idDepartemen`) VALUES
  (1,'92046','MALAKOFF',1),
  (2,'75000','PARIS',2),
  (3,'68000','COLMAR',3),
  (4,'13100','AIX EN PROVENCE',4),
  (5,'67000','STRASBOURG',5);
/*!40000 ALTER TABLE `ville` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
