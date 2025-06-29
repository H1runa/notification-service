-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: notif_db
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `customer_notif`
--

DROP TABLE IF EXISTS `customer_notif`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_notif` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `worker_id` int DEFAULT NULL,
  `customer_contract_id` int DEFAULT NULL,
  `worker_contract_id` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_notif`
--

LOCK TABLES `customer_notif` WRITE;
/*!40000 ALTER TABLE `customer_notif` DISABLE KEYS */;
INSERT INTO `customer_notif` VALUES (1,1,1,1,1,'Your contract was cancelled','Title: Cleaning needed\nDescription: Just some light cleaning for good pay\nStatus: Cancelled','2025-06-30','02:01:29','Read'),(2,5,3,3,3,'Your contract has been accepted','ID: 3\nTitle: Porfessional Wrestler needed\nDescription: For personal entertainment. Good pay guranteed\nStatus: Accepted','2025-06-30','02:07:02','Unread'),(3,1,1,1,1,'Your contract was cancelled','Your contract, \"Cleaning needed\" has been cancelled by the assigned worker. Contact the worker for furthur details.','2025-06-30','02:14:00','Unread'),(4,5,3,3,3,'Your contract was cancelled','Your contract, \"Porfessional Wrestler needed\" has been cancelled by the assigned worker. Contact the worker for furthur details.','2025-06-30','02:14:12','Unread'),(5,2,14,4,4,'Your contract has been accepted','Your contract, \"Lawn Mowing\" has been accepted by a worker','2025-06-30','02:18:24','Unread'),(6,2,2,4,5,'Your contract has been accepted','Your contract, \"Lawn Mowing\" has been accepted by a worker','2025-06-30','03:19:48','Unread'),(7,5,12,3,6,'Your contract has been accepted','Your contract, \"Porfessional Wrestler needed\" has been accepted by a worker','2025-06-30','03:36:55','Unread'),(8,5,12,3,7,'Your contract has been accepted','Your contract, \"Porfessional Wrestler needed\" has been accepted by a worker','2025-06-30','03:37:52','Unread');
/*!40000 ALTER TABLE `customer_notif` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker_notif`
--

DROP TABLE IF EXISTS `worker_notif`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worker_notif` (
  `id` int NOT NULL AUTO_INCREMENT,
  `worker_id` int NOT NULL,
  `customer_id` int DEFAULT NULL,
  `worker_contract_id` int DEFAULT NULL,
  `customer_contract_id` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker_notif`
--

LOCK TABLES `worker_notif` WRITE;
/*!40000 ALTER TABLE `worker_notif` DISABLE KEYS */;
INSERT INTO `worker_notif` VALUES (1,1,2,1,1,'Contract cancelled','\"Cleaning needed\" contract has been cancelled by the customer.','2025-06-30','01:46:20','Unread'),(2,14,2,4,4,'Contract cancelled','\"Lawn Mowing\" contract has been cancelled by the customer.','2025-06-30','02:19:34','Read'),(3,14,2,4,4,'Contract cancelled','\"Lawn Mowing\" contract has been cancelled by the customer.','2025-06-30','03:22:30','Unread'),(4,2,2,5,4,'Contract cancelled','\"Lawn Mowing\" contract has been cancelled by the customer.','2025-06-30','03:22:30','Unread'),(5,14,2,4,4,'Contract cancelled','\"Lawn Mowing\" contract has been cancelled by the customer.','2025-06-30','03:23:23','Unread'),(6,2,2,5,4,'Contract cancelled','\"Lawn Mowing\" contract has been cancelled by the customer.','2025-06-30','03:23:23','Unread'),(7,12,5,7,3,'Contract cancelled','\"Porfessional Wrestler needed\" contract has been cancelled by the customer.','2025-06-30','03:40:46','Unread');
/*!40000 ALTER TABLE `worker_notif` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-30  3:43:45
