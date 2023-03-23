-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: van_humbeeck_menuv4
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commande` (
  `idCommande` int NOT NULL AUTO_INCREMENT,
  `numéroTable` varchar(45) DEFAULT NULL,
  `menu` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `prix` int DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `statut` tinyint DEFAULT NULL,
  PRIMARY KEY (`idCommande`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande`
--

LOCK TABLES `commande` WRITE;
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
INSERT INTO `commande` VALUES (10,'Table 3','Menu 1:\nboeuf au grill riz basmati à la japonaise vanille enrobé de chocolat\n25.0\nMenu 2:\ndinde de Noel farcie pommes de terre Nicolas en chemise au four café latte avec des gourmandises\n25.0\n',50,'2023-02-20 15:38:58',0),(11,'Table 3','Menu 1:\nboeuf au grill riz basmati à la japonaise vanille enrobé de chocolat\n25.0\nMenu 2:\ndinde de Noel farcie pommes de terre Nicolas en chemise au four café latte avec des gourmandises\n25.0\nMenu 3:\ndinde de Noel farcie pommes de terre Nicolas en chemise au four café latte avec des gourmandises eclair fondant chocolat\n30.0\n',80,'2023-02-20 15:41:35',0),(12,'Table 4','eclair',35,'2023-02-20 17:58:50',0),(13,'Table 4','Menu 1:\nsardine à l\'huile spaghetti aldente pomme sucrée\n20.0\nMenu 2:\nCochon au feu de bois riz basmati à la japonaise eclair fondant chocolat\n35.0\nMenu 3:\nCochon au feu de bois frites large faites maison eclair fondant chocolat\n35.0\n',90,'2023-02-20 17:58:50',0),(14,'Table 2','sardine à l\'huile riz basmati à la japonaise pomme sucrée',20,'2023-02-20 17:59:55',0),(15,'Table 18','sardine à l\'huile frites large faites maison café latte avec des gourmandises',20,'2023-02-22 14:05:37',0),(16,'Table 2','Menu 1:\nsole au feu de bois riz basmati à la japonaise vanille enrobé de chocolat\n25.0\nMenu 2:\ndinde de Noel farcie pommes de terre Nicolas en chemise au four eclair fondant chocolat\n25.0\nMenu 3:\nCochon au feu de bois riz basmati à la japonaise pomme sucrée\n35.0\n',85,'2023-02-22 14:06:59',0),(17,'Table 8','Menu 1:\nCochon au feu de bois pommes de terre Nicolas en chemise au four vanille enrobé de chocolat\n35.0\n',35,'2023-02-25 22:47:29',0),(18,'Table 8','Menu 1:\nsole au feu de bois riz basmati à la japonaise pomme sucrée\n25.0\nMenu 2:\nsardine à l\'huile frites large faites maison eclair fondant chocolat\n20.0\nMenu 3:\nCochon au feu de bois pommes de terre Nicolas en chemise au four vanille enrobé de chocolat\n35.0\n',80,'2023-02-27 14:34:15',0),(19,'Table 8','Menu 1:\nsole au feu de bois riz basmati à la japonaise pomme sucrée\n25.0\nMenu 2:\nsardine à l\'huile frites large faites maison eclair fondant chocolat\n20.0\nMenu 3:\nCochon au feu de bois pommes de terre Nicolas en chemise au four vanille enrobé de chocolat\n35.0\nMenu 4:\nsole au feu de bois pommes de terre Nicolas en chemise au four vanille enrobé de chocolat\n25.0\n',105,'2023-02-27 14:34:33',0),(20,'Table 12','Menu 1:\nsardine à l\'huile riz basmati à la japonaise café latte avec des gourmandises\n20.0\n',20,'2023-02-27 14:34:46',0),(21,'Table 19','Menu 1:\nboeuf au grill spaghetti aldente pomme sucrée\n25.0\n',25,'2023-03-07 22:11:50',0),(22,'Table 1','Menu 1:\nsole au feu de bois spaghetti aldente pomme pomme sucrée\n25.0\nMenu 2:\nboeuf au grill Nicolas en chemise au four vanille enrobé de chocolat\n25.0\n',50,'2023-03-08 20:10:50',0),(23,'Table 1','Menu 1:\nboeuf au grill spaghetti aldente latte avec des gourmandises\n25.0\n',25,'2023-03-09 10:23:13',0),(24,'Table 6','Menu 1:\ndinde de Noel farcie pommes de terre Nicolas en chemise au four glace vanille enrobé de chocolat\n25.0\n',25,'2023-03-09 16:31:21',0),(25,'Table 1','Menu 1:\nsole au feu de bois spaghetti aldente cafe latte avec des gourmandises\n25.0\n',25,'2023-03-09 16:31:30',0),(26,'Table 1','Menu 1:\nsole au feu de bois spaghetti aldente cafe latte avec des gourmandises\n25.0\nMenu 2:\nsteack au grill pommes de terre Nicolas en chemise au four glace vanille enrobé de chocolat\n25.0\n',50,'2023-03-09 16:31:36',0),(27,'Table 2','Menu 1:\nsteack au grill pommes de terre Nicolas en chemise au four glace vanille enrobé de chocolat\n25.0\nMenu 2:\ndinde de Noel farcie pommes de terre Nicolas en chemise au four eclair eclair fondant chocolat\n25.0\nMenu 3:\ndinde de Noel farcie pommes de terre Nicolas en chemise au four pomme pomme sucrée\n25.0\n',75,'2023-03-09 16:34:42',0),(28,'Table 3','Menu 1:\nsteack au grill riz basmati à la japonaise cafe latte avec des gourmandises\n25.0\nMenu 2:\nboeuf au grill pommes de terre Nicolas en chemise au four glace vanille enrobé de chocolat\n25.0\n',50,'2023-03-09 19:12:59',0),(29,'Table 1','Menu 1:\nboeuf au grill riz basmati à la japonaise pomme pomme sucrée\n25.0\n',25,'2023-03-10 21:39:54',0),(30,'Table 2','Menu 1:\nboeuf au grill riz basmati à la japonaise pomme pomme sucrée\n25.0\n',25,'2023-03-11 15:05:54',0),(31,'Table 1','Menu 1:\nsole au feu de bois 15.0\n spaghetti aldente cafe latte avec des gourmandises\n25.0\n',25,'2023-03-11 15:07:58',0),(32,'Table 7','Menu 1:\nsole au feu de bois 15.0\n frites large faites maison 20.0\n cafe latte avec des gourmandises 25.0\n\n25.0\n',25,'2023-03-11 15:08:53',0),(33,'Table 4','Menu 1:\nsole au feu de bois 15.0\n frites large faites maison 15.0\n cafe latte avec des gourmandises 15.0\n\n15.0\n',15,'2023-03-11 15:11:36',0),(34,'Table 4','Menu 1:\nsole au feu de bois 15.0\n frites large faites maison 15.0\n cafe latte avec des gourmandises 15.0\n\n15.0\n',15,'2023-03-11 15:13:37',0),(35,'Table 9','Menu 1:\nsole au feu de bois 15.0\n frites large faites maison 15.0\n cafe latte avec des gourmandises 15.0\n\n15.0\n',15,'2023-03-11 15:18:04',0),(36,'Table 1','Menu 1:\nsole au feu de bois 15.0\n frites large faites maison 15.0\n cafe latte avec des gourmandises 15.0\n\n15.0\n',15,'2023-03-11 15:19:02',0),(37,'Table 1','Menu 1:\nsole au feu de bois 15.0\n frites large faites maison 5.0\n cafe latte avec des gourmandises 5.0\n\n5.0\nMenu 2:\nsole au feu de bois 15.0\n frites large faites maison 5.0\n cafe latte avec des gourmandises 5.0\n\n5.0\nMenu 3:\nsole au feu de bois 15.0\n frites large faites maison 5.0\n cafe latte avec des gourmandises 5.0\n\n5.0\n',15,'2023-03-11 15:24:18',0),(38,'Table 8','Menu 1:\nsole au feu de bois 15.0\n frites large faites maison 5.0\n cafe latte avec des gourmandises 5.0\n\n25.0\nMenu 2:\nsole au feu de bois 15.0\n frites large faites maison 5.0\n cafe latte avec des gourmandises 5.0\n\n25.0\n',50,'2023-03-11 15:26:00',0),(39,'Table 1','Menu 1:\nsole au feu de bois 15.0\n frites large faites maison 5.0\n cafe latte avec des gourmandises 5.0\n\n25.0\n',25,'2023-03-14 15:16:27',0),(40,'Table 1','Menu 1:\nsteack au grill pommes de terre Nicolas en chemise au four 5.0\n eclair eclair fondant chocolat 5.0\n\n25.0\n',25,'2023-03-14 15:20:34',0),(41,'Table 2','Menu 1:\nboeuf au grill spaghetti aldente 5.0\n eclair eclair fondant chocolat 5.0\n\n25.0\n',25,'2023-03-14 15:21:12',0),(42,'Table 3','Menu 1:\nsteack au grill 15.0\n pommes de terre Nicolas en chemise au four 5.0\n pomme pomme sucrée 5.0\n\n25.0\n',25,'2023-03-14 15:22:37',0),(43,'Table 1','Menu 1:\nsole au feu de bois 15.0\n riz basmati à la japonaise 5.0\n cafe latte avec des gourmandises 5.0\n\n25.0\n',25,'2023-03-16 15:11:36',0);
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'van_humbeeck_menuv4'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-16 17:16:53
