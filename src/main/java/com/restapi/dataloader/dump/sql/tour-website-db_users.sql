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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone_number` bigint DEFAULT NULL,
  `username` varchar(100) NOT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`),
  CONSTRAINT `FKp56c1712k691lhsyewcssf40f` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2023-12-07 14:48:16.546761','user','$2a$10$mxsr8OH6xqx.iAssHbnQquNjUBnbFJRKmPJL8JSQ.jICLlGBqfrSW',8585825658,'user@gmail.com',1),(2,'2023-12-07 14:48:16.693915','admin','$2a$10$5eHPXf.xNNP1IALmq.JKou0Ql5.rmxYxQEQx1QmTw6NBTpmONrN4a',NULL,'admin@gmail.com',2),(3,'2023-12-08 20:10:28.817369','Revathi','$2a$10$/UB0PShqoMS2pXgz7q5zZ.LsOSDDDVFIfMB4YxkYxJ3QLLaJbdnyO',8987898789,'revathi@gmail.com',1),(4,'2023-12-09 10:24:27.542459','Jhansi','$2a$10$VYkleHkUnkg9D.FU0r9Gde4uRAFhq87VEasUwgsnQr2mxb76NNCNG',8987898789,'jhansi@gmail.com',1),(5,'2023-12-15 16:26:57.729540','Sanjay','$2a$10$yZKPmWyr7W82Y.IWaC.ai.F57VHVIrS2p6.xMjAAh8W8rEn35bOau',9284204392,'sanjay@gmail.com',1),(16,'2023-12-21 22:51:37.561785','Ammu','$2a$10$yU0gSGots2zmbOyPpLLQVuGihjovY2FVwhyqiYqsswJ8z5nxVKRO.',7888789898,'revathis142@gmail.com',1),(19,'2023-12-27 14:46:08.638314','selvin','$2a$10$fq9/ky8ef25feNgtW3VEt.x5WHOhPgVv449.tsiIWzYsDj5/rEyqi',9600298600,'selvin2001@gmail.com',1),(20,'2025-04-24 11:13:06.584067','user','$2a$10$Fz8tJs/xNotUJ8MM.UHaUO6APuPWqG12kXwyT7uwCJ4UzwYmCLi/m',NULL,'user',1),(21,'2025-04-24 11:13:06.706280','admin','$2a$10$S6EPYip6sEhtWsJXJjJERu7Wq.olUO6HAXljzppsAg1JXISnMnV7C',NULL,'admin',2),(22,'2025-04-24 11:13:13.241961','Harry','$2a$10$e1ahKKrshjYaD1R7lRwe4OkBr6DBWFeCxtYt2SHjaCc3kzpJynGQm',8989767678,'hari@gmail.com',1);
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

-- Dump completed on 2025-04-24 11:19:49
