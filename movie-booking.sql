CREATE DATABASE  IF NOT EXISTS `movie-booking` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `movie-booking`;
-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: movie-booking
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `auditoriums`
--

DROP TABLE IF EXISTS `auditoriums`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auditoriums` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `cinema_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhse6clpv2uh59eu9to3ip5hyc` (`cinema_id`),
  CONSTRAINT `FKhse6clpv2uh59eu9to3ip5hyc` FOREIGN KEY (`cinema_id`) REFERENCES `cinemas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditoriums`
--

LOCK TABLES `auditoriums` WRITE;
/*!40000 ALTER TABLE `auditoriums` DISABLE KEYS */;
INSERT INTO `auditoriums` VALUES (2,'Salle 1 - Brussels',1),(3,'Salle 2 - Brussels',1),(4,'Salle 3 - Brussels',1),(5,'Salle 1 - Antwerpen',2),(6,'Salle 2 - Antwerpen',2),(7,'Salle 3 - Antwerpen',2);
/*!40000 ALTER TABLE `auditoriums` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cinemas`
--

DROP TABLE IF EXISTS `cinemas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cinemas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinemas`
--

LOCK TABLES `cinemas` WRITE;
/*!40000 ALTER TABLE `cinemas` DISABLE KEYS */;
INSERT INTO `cinemas` VALUES (1,'Bd du Centenaire 20, 1020 Bruxelles, Belgium','Kinepolis Brussels','+32 2 474 26 00'),(2,'Groenendaallaan 394, 2030 Antwerpen, Belgium','Kinepolis Antwerpen','+32 3 544 36 00');
/*!40000 ALTER TABLE `cinemas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genres`
--

DROP TABLE IF EXISTS `genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genres` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genres`
--

LOCK TABLES `genres` WRITE;
/*!40000 ALTER TABLE `genres` DISABLE KEYS */;
INSERT INTO `genres` VALUES (1,'Action'),(2,'Espionnage'),(3,'Animation'),(4,'Aventure'),(5,'Documentaire'),(6,'Drame'),(7,'Epouvante'),(8,'Fantastique'),(9,'Guerre'),(10,'Horreur'),(11,'Programme'),(12,'Science Fiction'),(13,'Thriller'),(15,'Western');
/*!40000 ALTER TABLE `genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_genres`
--

DROP TABLE IF EXISTS `movie_genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_genres` (
  `movie_id` bigint NOT NULL,
  `genre_id` bigint NOT NULL,
  KEY `FKnfpjuak0xiqpca3gjkwrixiig` (`genre_id`),
  KEY `FK4ak9svw913jblkfgru84h2phd` (`movie_id`),
  CONSTRAINT `FK4ak9svw913jblkfgru84h2phd` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`),
  CONSTRAINT `FKnfpjuak0xiqpca3gjkwrixiig` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_genres`
--

LOCK TABLES `movie_genres` WRITE;
/*!40000 ALTER TABLE `movie_genres` DISABLE KEYS */;
INSERT INTO `movie_genres` VALUES (6,6),(7,1),(7,4),(7,8),(8,10),(8,7),(9,6),(9,13),(10,6),(11,6),(12,8),(12,12),(12,6),(13,1),(13,12),(13,10);
/*!40000 ALTER TABLE `movie_genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` text,
  `imdb_rating` varchar(255) DEFAULT NULL,
  `poster` text,
  `release_date` varchar(255) DEFAULT NULL,
  `runtime` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (6,'A young woman\'s plans to propose to her girlfriend while at her family\'s annual holiday party are upended when she discovers her partner hasn\'t yet come out to her conservative parents.','6','https://image.tmdb.org/t/p/w220_and_h330_face/vzec9kkOSE93tygyfOktedkeOQ.jpg','2021-08-13','2h00','Happiest Season'),(7,'Mary Lennox is born in India to wealthy British parents who never wanted her. When her parents suddenly die, she is sent back to England to live with her uncle. She meets her sickly cousin, and the two children find a wondrous secret garden lost in the grounds of Misselthwaite Manor.\n\n','7','https://image.tmdb.org/t/p/w220_and_h330_face/5MSDwUcqnGodFTvtlLiLKK0XKS.jpg','2021-08-06','1h45','The Secret Garden'),(8,'When Edna—the elderly and widowed matriarch of the family—goes missing, her daughter and granddaughter travel to their remote family home to find her. Soon after her return, they start to discover a sinister presence haunting the house and taking control of Edna.','3','https://image.tmdb.org/t/p/w220_and_h330_face/3wZ0gxLqsPleneFSTZILmM3BE8Q.jpg','2021-08-19','1h45','Relic'),(9,'A young woman haunted by a tragedy in her past takes revenge on the predatory men unlucky enough to cross her path.','7','https://image.tmdb.org/t/p/w220_and_h330_face/cjzU4g6SlScnP4MdkleyI25KGlR.jpg','2021-08-07','2h00','Promising Young Woman'),(10,'In a last-ditch effort to save his career, sports agent JB Bernstein (Jon Hamm) dreams up a wild game plan to find Major League Baseball’s next great pitcher from a pool of cricket players in India. He soon discovers two young men who can throw a fastball but know nothing about the game of baseball. Or America. It’s an incredible and touching journey that will change them all — especially JB, who learns valuable lessons about teamwork, commitment and family.','6.8','https://image.tmdb.org/t/p/w220_and_h330_face/nO5Hq7fJhxmhuycELyVX6FamOjl.jpg','2021-08-12','1h50','Million Dollar Arm'),(11,'Carrie, Charlotte, and Miranda are all married now, but they\'re still up for a little fun in the sun. When Samantha gets the chance to visit one of the most extravagant vacation destinations on the planet and offers to bring them all along, they surmise that a women-only retreat may be the perfect excuse to eschew their responsibilities and remember what life was like before they decided to settle down.','6','https://image.tmdb.org/t/p/w220_and_h330_face/VF29fCNyGyZIACutBINKaNfDvB.jpg','2021-08-05','2h00','Sex and the City 2'),(12,'David Aames has it all: wealth, good looks and gorgeous women on his arm. But just as he begins falling for the warmhearted Sofia, his face is horribly disfigured in a car accident. That\'s just the beginning of his troubles as the lines between illusion and reality, between life and death, are blurred.','6.8','https://image.tmdb.org/t/p/w220_and_h330_face/cAh2pCiNPftsY3aSqJuIOde7uWr.jpg','2021-08-07','1h35','Vanilla Sky'),(13,'A deep sea submersible pilot revisits his past fears in the Mariana Trench, and accidentally unleashes the seventy foot ancestor of the Great White Shark believed to be extinct.','6.1','https://image.tmdb.org/t/p/w220_and_h330_face/xqECHNvzbDL5I3iiOVUkVPJMSbc.jpg','2021-08-11','1h45','The Meg');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation_seats`
--

DROP TABLE IF EXISTS `reservation_seats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation_seats` (
  `reservation_id` bigint NOT NULL,
  `seat_id` bigint NOT NULL,
  KEY `FKo4tbgy4jg06hfaugqx2gxx9we` (`seat_id`),
  KEY `FK755roqq37bto59vxaxis9x3nt` (`reservation_id`),
  CONSTRAINT `FK755roqq37bto59vxaxis9x3nt` FOREIGN KEY (`reservation_id`) REFERENCES `reservations` (`id`),
  CONSTRAINT `FKo4tbgy4jg06hfaugqx2gxx9we` FOREIGN KEY (`seat_id`) REFERENCES `seats` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation_seats`
--

LOCK TABLES `reservation_seats` WRITE;
/*!40000 ALTER TABLE `reservation_seats` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation_seats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservations` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `reservation_date` datetime(6) DEFAULT NULL,
  `screening_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gmeajr9v2vgkqhisyh56w3xlk` (`email`),
  KEY `FKps2fsuvl9g54tk7qitklej8rh` (`screening_id`),
  CONSTRAINT `FKps2fsuvl9g54tk7qitklej8rh` FOREIGN KEY (`screening_id`) REFERENCES `screenings` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `screenings`
--

DROP TABLE IF EXISTS `screenings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `screenings` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `screening_date` datetime(6) DEFAULT NULL,
  `auditorium_id` bigint DEFAULT NULL,
  `movie_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhgqtxur0889rjbwtpihaifjfe` (`auditorium_id`),
  KEY `FKrnko8743nv2o7jd7ix2wtcyf` (`movie_id`),
  CONSTRAINT `FKhgqtxur0889rjbwtpihaifjfe` FOREIGN KEY (`auditorium_id`) REFERENCES `auditoriums` (`id`),
  CONSTRAINT `FKrnko8743nv2o7jd7ix2wtcyf` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `screenings`
--

LOCK TABLES `screenings` WRITE;
/*!40000 ALTER TABLE `screenings` DISABLE KEYS */;
INSERT INTO `screenings` VALUES (16,'2021-08-14 12:30:00.000000',5,8),(17,'2021-08-15 12:30:00.000000',5,8),(18,'2021-08-16 12:30:00.000000',5,8),(19,'2021-08-17 12:30:00.000000',5,8),(20,'2021-08-18 12:30:00.000000',5,8),(21,'2021-08-14 08:00:00.000000',2,6),(22,'2021-08-15 08:00:00.000000',2,6),(23,'2021-08-16 08:00:00.000000',2,6),(24,'2021-08-17 08:00:00.000000',2,6),(25,'2021-08-18 08:00:00.000000',2,6),(26,'2021-08-19 08:00:00.000000',2,6),(27,'2021-08-20 08:00:00.000000',2,6),(28,'2021-08-21 08:00:00.000000',2,6),(29,'2021-08-22 08:00:00.000000',2,6),(30,'2021-08-23 08:00:00.000000',2,6),(31,'2021-08-13 07:30:00.000000',7,7),(32,'2021-08-14 07:30:00.000000',7,7),(33,'2021-08-15 07:30:00.000000',7,7),(34,'2021-08-16 07:30:00.000000',7,7),(35,'2021-08-17 07:30:00.000000',7,7),(36,'2021-08-18 07:30:00.000000',7,7),(37,'2021-08-19 07:30:00.000000',7,7),(38,'2021-08-20 07:30:00.000000',7,7),(39,'2021-08-21 07:30:00.000000',7,7),(40,'2021-08-22 07:30:00.000000',7,7),(41,'2021-08-14 17:30:00.000000',5,11),(42,'2021-08-15 17:30:00.000000',5,11),(43,'2021-08-16 17:30:00.000000',5,11),(44,'2021-08-17 17:30:00.000000',5,11),(45,'2021-08-18 17:30:00.000000',5,11),(46,'2021-08-19 17:30:00.000000',5,11),(47,'2021-08-20 17:30:00.000000',5,11),(48,'2021-08-21 17:30:00.000000',5,11),(49,'2021-08-22 17:30:00.000000',5,11),(50,'2021-08-23 17:30:00.000000',5,11),(51,'2021-08-14 14:00:00.000000',3,12),(52,'2021-08-15 14:00:00.000000',3,12),(53,'2021-08-16 14:00:00.000000',3,12),(54,'2021-08-17 14:00:00.000000',3,12),(55,'2021-08-18 14:00:00.000000',3,12),(56,'2021-08-19 14:00:00.000000',3,12),(57,'2021-08-20 14:00:00.000000',3,12),(58,'2021-08-21 14:00:00.000000',3,12),(59,'2021-08-22 14:00:00.000000',3,12),(60,'2021-08-23 14:00:00.000000',3,12),(61,'2021-08-14 13:00:00.000000',6,13),(62,'2021-08-15 13:00:00.000000',6,13),(63,'2021-08-16 13:00:00.000000',6,13),(64,'2021-08-17 13:00:00.000000',6,13),(65,'2021-08-18 13:00:00.000000',6,13),(66,'2021-08-19 13:00:00.000000',6,13),(67,'2021-08-20 13:00:00.000000',6,13),(68,'2021-08-21 13:00:00.000000',6,13),(69,'2021-08-22 13:00:00.000000',6,13),(70,'2021-08-23 13:00:00.000000',6,13);
/*!40000 ALTER TABLE `screenings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat_reserved`
--

DROP TABLE IF EXISTS `seat_reserved`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat_reserved` (
  `id` bigint NOT NULL,
  `seat_id` bigint NOT NULL,
  `reservation_id` bigint NOT NULL,
  PRIMARY KEY (`seat_id`,`reservation_id`,`id`),
  UNIQUE KEY `UK_1f5fygqs8wawibwiapluc0uie` (`seat_id`),
  UNIQUE KEY `UK_sw72oa8ixrrbym35dko3r6jxd` (`reservation_id`),
  CONSTRAINT `FK4kxsp2ub9m5y9kgv6jve7wu8d` FOREIGN KEY (`seat_id`) REFERENCES `seats` (`id`),
  CONSTRAINT `FK8fefjq6x34naulj480e9s2rq` FOREIGN KEY (`reservation_id`) REFERENCES `reservations` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_reserved`
--

LOCK TABLES `seat_reserved` WRITE;
/*!40000 ALTER TABLE `seat_reserved` DISABLE KEYS */;
/*!40000 ALTER TABLE `seat_reserved` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seats`
--

DROP TABLE IF EXISTS `seats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seats` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `row` int NOT NULL,
  `row_number` int NOT NULL,
  `auditorium_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK63avm7j8pbf018wn6oacgebp7` (`auditorium_id`),
  CONSTRAINT `FK63avm7j8pbf018wn6oacgebp7` FOREIGN KEY (`auditorium_id`) REFERENCES `auditoriums` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=221 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seats`
--

LOCK TABLES `seats` WRITE;
/*!40000 ALTER TABLE `seats` DISABLE KEYS */;
INSERT INTO `seats` VALUES (26,0,0,2),(27,0,1,2),(28,0,2,2),(29,0,3,2),(30,0,4,2),(31,0,5,2),(32,0,6,2),(33,1,0,2),(34,1,1,2),(35,1,2,2),(36,1,3,2),(37,1,4,2),(38,1,5,2),(39,1,6,2),(40,2,0,2),(41,2,1,2),(42,2,2,2),(43,2,3,2),(44,2,4,2),(45,2,5,2),(46,2,6,2),(47,3,0,2),(48,3,1,2),(49,3,2,2),(50,3,3,2),(51,3,4,2),(52,3,5,2),(53,3,6,2),(54,4,0,2),(55,4,1,2),(56,4,2,2),(57,4,3,2),(58,4,4,2),(59,4,5,2),(60,4,6,2),(61,5,0,2),(62,5,1,2),(63,5,2,2),(64,5,3,2),(65,5,4,2),(66,5,5,2),(67,5,6,2),(68,6,0,2),(69,6,1,2),(70,6,2,2),(71,6,3,2),(72,6,4,2),(73,6,5,2),(74,6,6,2),(75,7,0,2),(76,7,1,2),(77,7,2,2),(78,7,3,2),(79,7,4,2),(80,7,5,2),(81,7,6,2),(82,0,0,3),(83,0,1,3),(84,0,2,3),(85,0,3,3),(86,0,4,3),(87,1,0,3),(88,1,1,3),(89,1,2,3),(90,1,3,3),(91,1,4,3),(92,2,0,3),(93,2,1,3),(94,2,2,3),(95,2,3,3),(96,2,4,3),(97,3,0,3),(98,3,1,3),(99,3,2,3),(100,3,3,3),(101,3,4,3),(102,4,0,3),(103,4,1,3),(104,4,2,3),(105,4,3,3),(106,4,4,3),(107,5,0,3),(108,5,1,3),(109,5,2,3),(110,5,3,3),(111,5,4,3),(112,6,0,3),(113,6,1,3),(114,6,2,3),(115,6,3,3),(116,6,4,3),(117,0,0,4),(118,0,1,4),(119,0,2,4),(120,1,0,4),(121,1,1,4),(122,1,2,4),(123,2,0,4),(124,2,2,4),(125,3,0,4),(126,3,2,4),(127,4,0,4),(128,4,2,4),(129,5,0,4),(130,5,2,4),(131,6,0,4),(132,6,1,4),(133,6,2,4),(134,7,0,4),(135,7,1,4),(136,7,2,4),(137,0,0,5),(138,0,1,5),(139,0,2,5),(140,0,3,5),(141,0,4,5),(142,0,5,5),(143,0,6,5),(144,0,7,5),(145,1,0,5),(146,1,1,5),(147,1,2,5),(148,1,3,5),(149,1,4,5),(150,1,5,5),(151,1,6,5),(152,1,7,5),(153,2,0,5),(154,2,2,5),(155,2,3,5),(156,2,4,5),(157,2,5,5),(158,2,6,5),(159,2,7,5),(160,3,0,5),(161,3,2,5),(162,3,3,5),(163,3,4,5),(164,3,5,5),(165,3,6,5),(166,3,7,5),(167,4,0,5),(168,4,2,5),(169,4,3,5),(170,4,4,5),(171,4,5,5),(172,4,6,5),(173,4,7,5),(174,5,0,5),(175,5,2,5),(176,5,3,5),(177,5,4,5),(178,5,5,5),(179,5,6,5),(180,5,7,5),(181,6,0,5),(182,6,1,5),(183,6,2,5),(184,6,3,5),(185,6,4,5),(186,6,5,5),(187,6,6,5),(188,6,7,5),(189,0,0,6),(190,0,1,6),(191,0,2,6),(192,0,3,6),(193,0,4,6),(194,1,0,6),(195,1,1,6),(196,1,2,6),(197,1,3,6),(198,1,4,6),(199,2,0,6),(200,2,2,6),(201,2,3,6),(202,2,4,6),(203,3,0,6),(204,3,2,6),(205,3,3,6),(206,3,4,6),(207,4,0,6),(208,4,2,6),(209,4,3,6),(210,4,4,6),(211,0,0,7),(212,1,0,7),(213,2,0,7),(214,3,0,7),(215,4,0,7),(216,5,0,7),(217,6,0,7),(218,7,0,7),(219,8,0,7),(220,9,0,7);
/*!40000 ALTER TABLE `seats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `roles` varchar(255) DEFAULT NULL,
  KEY `FKj345gk1bovqvfame88rcx7yyx` (`user_id`),
  CONSTRAINT `FKj345gk1bovqvfame88rcx7yyx` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'ROLE_USER');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Rue de la mutualité','root@test.com','William','Pires','0477965461',_binary '','$2a$10$dkm5U5DPS2oOmqG2O66Cp.3N0DMo/kCBuF.cUd4H825HgfTbjBh4m','root');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-15  0:25:26
