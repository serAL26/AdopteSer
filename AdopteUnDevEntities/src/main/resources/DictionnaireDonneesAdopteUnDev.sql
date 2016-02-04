-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.31-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;

--
-- Create schema adopte_un_dev
--

CREATE DATABASE IF NOT EXISTS adopte_un_dev;
USE adopte_un_dev;

--
-- Definition of table `adresse`
--

--
-- Dumping data for table `adresse`
--

/*!40000 ALTER TABLE `adresse` DISABLE KEYS */;
INSERT INTO `adresse` (`id_adresse`, `NUMERO`, `RUE`, `idVille`) VALUES
  (1, '12', 'rue des developpeurs heureux', 1),
  (2, '12', 'rue des developpeurs', 1),
  (3, '12', 'rue des developpeurs bienheureux', 1),
  (4, '12', 'rue des developpeurs contents', 1),
  (5, '12', 'rue des developpeurs riches', 1),
  (6, '12', 'rue des developpeurs passionnÃ©s', 1),
  (7, '12', 'rue des developpeurs avares', 1),
  (8, '12', 'rue des developpeurs tristes', 1),
  (9, '12', 'rue des developpeurs creatifs', 1),
  (10, '12', 'rue des developpeurs dÃ©pendants', 1),
  (11, '12', 'rue des developpeurs indÃ©pendants', 1),
  (12, '12', 'rue des developpeurs pauvres', 1),
  (13, '12', 'rue des developpeurs exubÃ©rants', 1),
  (14, '12', 'rue des developpeurs intelligents', 1),
  (15, '12', 'rue des developpeurs dÃ©passÃ©s', 1),
  (16, '12', 'rue des clients', 1),
  (17, '12', 'rue des clients bienheureux', 1),
  (18, '12', 'rue des clients malheureux', 1),
  (19, '12', 'rue des clients riches', 1),
  (20, '12', 'rue des clients pauvres', 1),
  (21, '12', 'rue des clients fatiguants', 1),
  (22, '12', 'rue des clients charismatiques', 1),
  (23, '12', 'rue des clients jeunes', 1),
  (24, '12', 'rue des clients oldschool', 1),
  (25, '12', 'rue des clients interessants', 1),
  (26, '12', 'rue des clients stressÃ©s', 1),
  (27, '12', 'rue des clients stressants', 1),
  (28, '12', 'rue des clients incomprehensibles', 1),
  (29, '12', 'rue des clients perdus', 1),
  (30, '12', 'rue des clients etrangers', 1),
  (31, '12', 'rue des clients exuberants', 1),
  (32, '12', 'rue des clients intelligents', 1),
  (33, '12', 'rue des clients pragmatiques', 1),
  (34, '12', 'rue des clients vertueux', 1),
  (35, '12', 'rue des clients conciliants', 1);
/*!40000 ALTER TABLE `adresse` ENABLE KEYS */;

--
-- Definition of table `association_cdc_fonctionnalite`
--

--
-- Dumping data for table `association_cdc_fonctionnalite`
--


--
-- Definition of table `association_dev_techno`
--

--
-- Dumping data for table `association_dev_techno`
--

/*!40000 ALTER TABLE `association_dev_techno` DISABLE KEYS */;
INSERT INTO `association_dev_techno` (`id_association_dev_techno`, `idDeveloppeur`, `idTechnologie`) VALUES
  (1, 1, 6),
  (2, 2, 9),
  (3, 3, 10),
  (4, 4, 7),
  (5, 5, 7),
  (6, 6, 1),
  (7, 6, 8),
  (8, 6, 11),
  (9, 7, 8),
  (10, 8, 1),
  (11, 8, 2),
  (12, 9, 1),
  (13, 9, 11),
  (14, 10, 6),
  (15, 11, 8),
  (16, 12, 8),
  (17, 13, 8),
  (18, 13, 1),
  (19, 13, 7),
  (20, 14, 8),
  (21, 15, 8),
  (22, 8, 8);
/*!40000 ALTER TABLE `association_dev_techno` ENABLE KEYS */;

--
-- Definition of table `association_typeservice_techno`
--


--
-- Dumping data for table `association_typeservice_techno`
--

/*!40000 ALTER TABLE `association_typeservice_techno` DISABLE KEYS */;
INSERT INTO association_typeservice_techno (id_association_typeservice_techno, idTechnologie, idTypeService) VALUES
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

--
-- Dumping data for table `cdc`
--
--
-- Definition of table `departement`
--

--
-- Dumping data for table `departement`
--

/*!40000 ALTER TABLE `departement` DISABLE KEYS */;
INSERT INTO `departement` (`id_departement`, `NOM`, `NUMERO`) VALUES
  (1, 'HAUT DE SEINE', '92'),
  (2, 'PARIS', '75'),
  (3, 'HAUT RHIN', '68'),
  (4, 'BOUCHES DU RHONES', '13'),
  (5, 'BAS RHIN', '67');
/*!40000 ALTER TABLE `departement` ENABLE KEYS */;

--
-- Definition of table `dispo`
--
--
-- Dumping data for table `dispo`
--

/*!40000 ALTER TABLE `dispo` DISABLE KEYS */;
INSERT INTO dispo (id_dispo, DEBUTDISPO, FINDISPO, idDeveloppeur, idTypeDispo) VALUES
  (1,2015-02-12,2015-04-12,1,3),
  (2,2015-03-12,2015-05-12,2,2),
  (3,2015-03-12,2015-12-12,3,4),
  (4,2015-03-12,2015-12-12,4,4),
  (5,2015-03-12,2015-12-12,5,4),
  (6,2015-03-12,2015-12-12,6,4),
  (7,2015-03-12,2015-12-12,7,4),
  (8,2015-03-12,2015-12-12,8,4),
  (9,2015-03-12,2015-12-12,9,4),
  (10,2015-01-12,2015-09-12,10,1);
/*!40000 ALTER TABLE `dispo` ENABLE KEYS */;

--
-- Definition of table `etat_projet`
--

--
-- Dumping data for table `etat_projet`
--

/*!40000 ALTER TABLE `etat_projet` DISABLE KEYS */;
INSERT INTO `etat_projet` (`id_etat_projet`, `LIBELLE`) VALUES
  (1, 'Demarre'),
  (2, 'Termine'),
  (3, 'Arrete'),
  (4, 'En attente');
/*!40000 ALTER TABLE `etat_projet` ENABLE KEYS */;

--
-- Definition of table `fonctionnalite`
--

--
-- Dumping data for table `fonctionnalite`
--

--
-- Definition of table `litige`
--

-- Dumping data for table `litige`
--

/*!40000 ALTER TABLE `litige` DISABLE KEYS */;
/*!40000 ALTER TABLE `litige` ENABLE KEYS */;

--
-- Definition of table `livrable`
--

--
-- Dumping data for table `livrable`
--

/*!40000 ALTER TABLE `livrable` DISABLE KEYS */;
INSERT INTO livrable (id_livrable, date_livraison, ECHEANCE, FICHIER, idProjet, idTypeEvaluation) VALUES
  (1,2015-02-09,2015-02-12,'Paypal.pdf',4,3),
  (2,2015-02-09,2015-02-12,'',5,1),
  (3,2015-02-09,2015-02-12,'Paypal.pdf',5,3),
  (4,2015-02-09,2015-02-12,'Paypal.pdf',6,3),
  (5,2015-02-09,2015-02-12,'Paypal.pdf',7,3),
  (6,2015-02-09,2015-02-12,'Paypal.pdf',8,3),
  (7,2015-02-09,2015-02-12,'Paypal.pdf',9,3);
/*!40000 ALTER TABLE `livrable` ENABLE KEYS */;

--
-- Definition of table `message`
--


--
-- Dumping data for table `message`
--

--
-- Definition of table `note`
--

--
-- Dumping data for table `note`
--

/*!40000 ALTER TABLE `note` DISABLE KEYS */;
INSERT INTO note (id_note, COMMENTAIRE, DATE, NOTE, id_est_note, id_noteur, idProjet) VALUES
  (1,'tres bien travail','2016-02-03 00:00:00',5,1,17,5),
  (2,'peut mieux faire','2016-02-03 00:00:00',4,1,19,4),
  (3,'mauvaise assimilation du client avec les methodes agiles','2016-02-03 00:00:00',1,19,1,4),
  (4,'excelent client toujours disponible pour repondre aux questions','2016-02-03 00:00:00',5,17,1,5),
  (5,'Enfin un developpeur qui sait developper !il propose des idées innovantes et fonctionnelle avec une rapidité d\'execution du niveau d\'un ordinateur nouvelle generation.','2016-02-03 00:00:00',5,6,19,5),
  (6,'Deux jours ! deux jours pour me faire un site Ecommerce alors que des entreprises du numerique me proposait un an de developpement ! Il a utilisé des nouvelles technologies innovantes tel que le COBOL et le FORTRAN (ironique) qui lui ont fait gagné un tem','2016-02-03 00:00:00',5,6,20,6),
  (7,'Du bon travail mais il a du maitriser un outil technologique ce qui lui a fait perdre du temps et donc une etoile...','2016-02-03 00:00:00',4,6,21,7),
  (8,'je veux mon application qui tourne sous blackberry, donc je refuse tous conseils concernant le support d\'utilisation de mon application. le developpeur n\'est pas la pour conseiller un MOA mais pour appliquer les ordre qu\'on lui donne.','2016-02-03 00:00:00',2,6,21,8),
  (9,'une application developpé à temps ','2016-02-03 00:00:00',4,6,21,9),
  (10,'Enfin une personne qui aime travailler en agilité et qui s\'adapte à tout changement de planning','2016-02-03 00:00:00',5,6,22,10);
/*!40000 ALTER TABLE `note` ENABLE KEYS */;

--
-- Definition of table `operation`
--

--
-- Dumping data for table `operation`
--

/*!40000 ALTER TABLE `operation` DISABLE KEYS */;
INSERT INTO operation (id_operation, DATE, MONTANT, idLivrable, idTypeOperation) VALUES
  (1,2015-02-12,20.0,1,1),
  (2,2015-02-12,10.0,2,2);
/*!40000 ALTER TABLE `operation` ENABLE KEYS */;

--
-- Definition of table `projet`
--
/*!40000 ALTER TABLE `projet` DISABLE KEYS */;
INSERT INTO projet (id_projet, LIBELLE, idClient, idEtatProjet, photo, idTypeService) VALUES
  (1,'DoYouKnow',17,4,'portfolio1.jpg',3),
  (2,'ShowMeYourFace',17,4,'portfolio2.jpg',8),
  (3,'HugNeeded',17,1,'portfolio3.jpg',8),
  (4,'BoutiqueDeVetement',17,1,'portfolio4.jpg',5),
  (5,'SiteWebPerso',19,2,'portfolio5.jpg',4),
  (6,'siteEcommerce',20,2,'portfolio4.jpg',5),
  (7,'ApplicationMobile',21,2,'portfolio5.jpg',8),
  (8,'ApplicationMobile',21,2,'portfolio7.jpg',9),
  (9,'ApplicationMobile',21,2,'portfolio8.jpg',6),
  (10,'ConversionModeleEnSite',22,1,'portfolio6.jpg',3);
/*!40000 ALTER TABLE `projet` ENABLE KEYS */;
--
-- Definition of table `propostion`
--
--
-- Dumping data for table `propostion`
--

--
-- Definition of table `technologie`
--
--
-- Dumping data for table `technologie`
--

/*!40000 ALTER TABLE `technologie` DISABLE KEYS */;
INSERT INTO `technologie` (`id_technologie`, `libelle`) VALUES
  (1, 'JAVA'),
  (2, 'PHP'),
  (3, 'C'),
  (4, 'C#'),
  (5, 'C++'),
  (6, 'HTML'),
  (7, 'CSS'),
  (8, 'JAVASCRIPT'),
  (9, 'FORTRAN'),
  (10, 'COBOL'),
  (11, 'SWIFT');
/*!40000 ALTER TABLE `technologie` ENABLE KEYS */;

--
-- Definition of table `typeappli`
--

--
-- Dumping data for table `typeappli`
--

/*!40000 ALTER TABLE `typeappli` DISABLE KEYS */;
INSERT INTO `typeappli` (`id_type_appli`, `LIBELLE`) VALUES
  (1, 'SITE WEB'),
  (2, 'LOGICIEL'),
  (3, 'MOBILE');
/*!40000 ALTER TABLE `typeappli` ENABLE KEYS */;

--
-- Definition of table `typecdc`
--
--
-- Dumping data for table `typecdc`
--

/*!40000 ALTER TABLE `typecdc` DISABLE KEYS */;
INSERT INTO `typecdc` (`id_type_cdc`, `LIBELLE`) VALUES
  (1, 'REMARQUE'),
  (2, 'CAHIER DE CHARGE');
/*!40000 ALTER TABLE `typecdc` ENABLE KEYS */;

--
-- Definition of table `typedispo`
--

--
-- Dumping data for table `typedispo`
--

/*!40000 ALTER TABLE `typedispo` DISABLE KEYS */;
INSERT INTO `typedispo` (`id_type_dispo`, `LIBELLE`) VALUES
  (1, 'WEEKEND'),
  (2, 'SOIR'),
  (3, 'TOUTE LA JOURNEE'),
  (4, 'INDISPONIBLE');
/*!40000 ALTER TABLE `typedispo` ENABLE KEYS */;

--
-- Definition of table `typeevaluation`
--

--
-- Dumping data for table `typeevaluation`
--

/*!40000 ALTER TABLE `typeevaluation` DISABLE KEYS */;
INSERT INTO `typeevaluation` (`id_type_evaluation`, `LIBELLE`) VALUES
  (1, 'REFUSE'),
  (2, 'EN ATTENTE'),
  (3, 'VALIDE');
/*!40000 ALTER TABLE `typeevaluation` ENABLE KEYS */;

--
-- Definition of table `typefonctionnalite`
--
--
-- Dumping data for table `typefonctionnalite`
--

/*!40000 ALTER TABLE `typefonctionnalite` DISABLE KEYS */;
INSERT INTO `typefonctionnalite` (`id_type_fonctionnalite`, `LIBELLE`) VALUES
  (1, 'AUTRE'),
  (2, 'GESTION DES UTILISATEURS'),
  (3, 'GESTION du panier');
/*!40000 ALTER TABLE `typefonctionnalite` ENABLE KEYS */;

--
-- Definition of table `typeoperation`
--
--
-- Dumping data for table `typeoperation`
--

/*!40000 ALTER TABLE `typeoperation` DISABLE KEYS */;
INSERT INTO `typeoperation` (`id_type_operation`, `LIBELLE`) VALUES
  (1, 'DEBIT'),
  (2, 'CREDIT');
/*!40000 ALTER TABLE `typeoperation` ENABLE KEYS */;

--
-- Definition of table `typeproposition`
--

--
-- Dumping data for table `typeproposition`
--

/*!40000 ALTER TABLE `typeproposition` DISABLE KEYS */;
INSERT INTO `typeproposition` (`id_type_proposition`, `LIBELLE`) VALUES
  (1, 'EN ATTENTE'),
  (2, 'ACCEPTÃ© PAR LE DEV'),
  (3, 'VALIDÃ© PAR LE CLIENT'),
  (4, 'REFUSÃ©');
/*!40000 ALTER TABLE `typeproposition` ENABLE KEYS */;

--
-- Definition of table `typeservice`
--

--
-- Definition of table `utilisateur`
--

--
-- Dumping data for table `utilisateur`
--

/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` (`id_utilisateur`, `type_utilisateur`, `date_inscription`, `FIXE`, `NOM`, `PHOTO`, `PORTABLE`, `PRENOM`, `MAIL`, `MDP`, `idAdresse`)
VALUES
  (1, 'DEVELOPPEUR', '2015-02-12 00:00:00', '148910675', 'AHMIM', 'resources/img/avatarDeveloppeur2.jpg', '643677732',
      'Ferhat', 'ferhat.ahmim@gmail.com', 'azerty', 1),
  (2, 'DEVELOPPEUR', '2015-02-12 00:00:00', NULL, 'AIT TALEB', 'resources/img/avatarDeveloppeur3.jpg', '605017075', 'Lahcen', 'aittaleb.lahcen@yahoo.fr', 'azerty', 2),
  (3, 'DEVELOPPEUR', '2015-02-12 00:00:00', NULL, 'ESSID', 'resources/img/avatarDeveloppeur4.jpg', '695264816', 'Amal', 'amal.jaziri@gmail.com', 'azerty', 3),
  (4, 'DEVELOPPEUR', '2015-02-12 00:00:00', NULL, 'HICHRI', 'resources/img/avatarDeveloppeur7.jpg', '778020125', 'Sabrine', 'sabrine.hichri@gmail.com', 'azerty', 4),
  (5, 'DEVELOPPEUR', '2015-02-12 00:00:00', NULL, 'MORIN', 'resources/img/avatarDeveloppeur6.jpg', '625830547', 'Sylvain', 'morin.slv@gmail.com', 'azerty', 5),
  (6, 'DEVELOPPEUR', '2015-02-12 00:00:00', NULL, 'QUERE', 'resources/img/avatarDeveloppeur5.jpg', '633120842', 'Alexandre', 'alexquere1@gmail.com', 'azerty', 6),
  (7, 'DEVELOPPEUR', '2015-02-12 00:00:00', NULL, 'WAILLE', 'resources/img/avatarDeveloppeur.jpg', '646808184', 'Emilie', 'ewaille@hotmail.fr', 'azerty', 9),
  (8, 'DEVELOPPEUR', '2015-02-12 00:00:00', NULL, 'ROIGNANT', 'resources/img/avatarDeveloppeur.jpg', '665335584', 'Pierre-Yves', 'py@roignant.fr', 'azerty', 8),
  (9, 'DEVELOPPEUR', '2015-02-12 00:00:00', NULL, 'ZRELLI', 'resources/img/avatarDeveloppeur.jpg', NULL, 'Yasmine', 'yasmine_zr@hotmail.fr', 'azerty', 15),
  (10, 'DEVELOPPEUR', '2015-02-12 00:00:00', NULL, 'ZHANG', 'resources/img/avatarDeveloppeur.jpg', '650499021', 'Gege', 'gege.zhang@gmx.com', 'azerty', 14),
  (11, 'DEVELOPPEUR', '2015-02-12 00:00:00', NULL, 'SABOUNDJI', 'resources/img/avatarDeveloppeur.jpg', '661506153', 'Mehdi', 'mehdi.saboundji', 'azerty', 17),
  (12, 'DEVELOPPEUR', '2015-02-12 00:00:00', NULL, 'LE BARON', 'resources/img/avatarDeveloppeur.jpg', '671972061', 'JerÃ´me', 'lebaronjerome@free.fr', 'azerty', 19),
  (13, 'DEVELOPPEUR', '2015-02-12 00:00:00', NULL, 'GUERIN', 'resources/img/avatarDeveloppeur8.jpg', '683269593', 'Emmanuel', 'emmanuel.guerin9@gmail.com', 'azerty', 7),
  (14, 'DEVELOPPEUR', '2015-02-12 00:00:00', NULL, 'DANGUEUGER', 'resources/img/avatarDeveloppeur.jpg', '637449875', 'Raphael', 'raphael.dangueuger@gmail.com', 'azerty', 10),
  (15, 'DEVELOPPEUR', '2015-02-12 00:00:00', NULL, 'ESTACAILLE', 'resources/img/avatarDeveloppeur.jpg', '603943699', 'Julien', 'julien.estacaille@gmail.com', 'azerty', 12),
  (16, 'CLIENT', '2015-02-12 00:00:00', NULL, 'RAKOTOMALALA', '/resources/img/portfolio4.jpg', '611121314', 'Patrick', 'patrick.rakotomalala@madagascar.com', 'afcepf', 2),
  (17, 'CLIENT', '2015-02-12 00:00:00', '123124565', 'BINISTI', '/resources/img/portfolio5.jpg', '612134556', 'Mickael', 'mickael.binisti@iris.fr', 'afcepf', 1),
  (18, 'CLIENT', '2015-02-12 00:00:00', '123124565', 'PIERRE', '/resources/img/portfolio6.jpg', '612134556', 'Pierre', 'pierre@gmail.com', 'afcepf', 3),
  (19, 'CLIENT', '2015-02-12 00:00:00', '123124565', 'PAUL', '/resources/img/img.jpg', '612134556', 'Paul', 'paul@gmail.com', 'afcepf', 1),
  (20, 'CLIENT', '2015-02-12 00:00:00', '123124565', 'JACQUES', '/resources/img/img.jpg', '612134556', 'Jacques', 'jacques@gmail.com', 'afcepf', 6),
  (21, 'CLIENT', '2015-02-12 00:00:00', '123124565', 'FRANCOIS', '/resources/img/img.jpg', '612134556', 'Francois', 'francois@gmail.com', 'afcepf', 1),
  (22, 'CLIENT', '2015-02-12 00:00:00', '123124565', 'MATTHIEU', '/resources/img/img.jpg', '612134556', 'Matthieu', 'matthieu@gmail.com', 'afcepf', 2),
  (23, 'CLIENT', '2015-02-12 00:00:00', '123124565', 'JOSEPH', '/resources/img/img.jpg', '612134556', 'Joseph', 'joseph@gmail.com', 'afcepf', 3),
  (24, 'CLIENT', '2015-02-12 00:00:00', '123124565', 'THIERRY', '/resources/img/img.jpg', '612134556', 'Thierry', 'thierry@gmail.com', 'afcepf', 1),
  (25, 'CLIENT', '2015-02-12 00:00:00', '123124565', 'KARIM', '/resources/img/img.jpg', '612134556', 'Karim', 'karim@gmail.com', 'afcepf', 2),
  (26, 'CLIENT', '2015-02-12 00:00:00', '123124565', 'ALADDIN', '/resources/img/img.jpg', '612134556', 'Jasmine', 'jasmine@gmail.com', 'afcepf', 1),
  (27, 'CLIENT', '2015-02-12 00:00:00', '123124565', 'POISSON', '/resources/img/img.jpg', '612134556', 'Ariel', 'ariel@gmail.com', 'afcepf', 2),
  (28, 'CLIENT', '2015-02-12 00:00:00', '123124565', 'Margot', '/resources/img/img.jpg', '612134556', 'Robbie', 'margotrobbie@gmail.com', 'afcepf', 1),
  (29, 'CLIENT', '2015-02-12 00:00:00', '123124565', 'LING', '/resources/img/img.jpg', '612134556', 'Ling', 'ling@gmail.com', 'afcepf', 2),
  (30, 'CLIENT', '2015-02-12 00:00:00', '123124565', 'CELINE', '/resources/img/img.jpg', '612134556', 'celine', 'celine@gmail.com', 'afcepf', 1),
  (31, 'CLIENT', '2015-02-12 00:00:00', '123124565', 'LAETICIA', '/resources/img/img.jpg', '612134556', 'Laeticia', 'laeticia@gmail.com', 'afcepf', 3),
  (32, 'CLIENT', '2015-02-12 00:00:00', '123124565', 'MARIE', '/resources/img/img.jpg', '612134556', 'Marie',
       'marie@gmail.com', 'afcepf', 2),
  (33, 'CLIENT', '2015-02-12 00:00:00', '123124565', 'ELODIE', '/resources/img/img.jpg', '612134556', 'Elodie',
       'elodie@gmail.com', 'afcepf', 3),
  (34, 'CLIENT', '2015-02-12 00:00:00', '123124565', 'AURELIA', '/resources/img/img.jpg', '612134556', 'Aurelia',
       'aurelia@gmail.com', 'afcepf', 1),
  (35, 'CLIENT', '2015-02-12 00:00:00', '123124565', 'NATHALIE', '/resources/img/img.jpg', '612134556', 'Nathalie',
       'nathalie@gmail.com', 'afcepf', 2);
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;

--
-- Definition of table `ville`
--
--
-- Dumping data for table `ville`
--

/*!40000 ALTER TABLE `ville` DISABLE KEYS */;
INSERT INTO `ville` (`id_ville`, `CP`, `NOM`, `idDepartemen`) VALUES
  (1, '92046', 'MALAKOFF', 1),
  (2, '75000', 'PARIS', 2),
  (3, '68000', 'COLMAR', 3),
  (4, '13100', 'AIX EN PROVENCE', 4),
  (5, '67000', 'STRASBOURG', 5);
/*!40000 ALTER TABLE `ville` ENABLE KEYS */;


/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
