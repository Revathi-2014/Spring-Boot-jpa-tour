-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: tour-website-db
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `count` int DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` bigint DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `status_id` bigint DEFAULT NULL,
  `tour_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7udbel7q86k041591kj6lfmvw` (`user_id`),
  KEY `FKj71yfwtvpb8cim66giop5l1cu` (`status_id`),
  KEY `FKlc7bhi14w8e558dt15eofelm4` (`tour_id`),
  CONSTRAINT `FK7udbel7q86k041591kj6lfmvw` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKj71yfwtvpb8cim66giop5l1cu` FOREIGN KEY (`status_id`) REFERENCES `booking_status` (`id`),
  CONSTRAINT `FKlc7bhi14w8e558dt15eofelm4` FOREIGN KEY (`tour_id`) REFERENCES `tour` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (24,1,'2023-12-25 14:35:26.040082','Ammu',8989898999,'revathi@gmail.com',3,2,12),(25,1,'2023-12-25 14:43:25.533157','Revathi',8989898989,'revathis142@gmail.com',3,1,10),(26,1,'2023-12-26 15:23:19.731118','Mithra',7898789889,'mithra@gmail.com',3,2,6),(27,1,'2023-12-26 15:26:26.984736','Jhansi',7887878987,'jhansi@gmail.com',3,1,3),(28,1,'2023-12-26 16:44:12.199402','Revathi',7878787878,'revathi@gmail.com',3,2,3),(29,13,'2023-12-27 14:50:16.933000','Ammu',9600268600,'revathi@gmail.com',19,1,2);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-24 11:19:48
