-- MySQL dump 10.13  Distrib 8.0.27, for macos12.0 (x86_64)
--
-- Host: localhost    Database: CafeWhereIGo
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `article_id` int NOT NULL AUTO_INCREMENT,
  `cafe_name` varchar(50) DEFAULT NULL,
  `article_title` varchar(100) NOT NULL,
  `article_content` text,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `view_count` int NOT NULL DEFAULT '0',
  `user_user_id` varchar(50) NOT NULL,
  `article_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`article_id`),
  UNIQUE KEY `article_id_UNIQUE` (`article_id`),
  KEY `fk_TodaysCafeArticle_user1_idx` (`user_user_id`),
  CONSTRAINT `fk_TodaysCafeArticle_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (27,'카페 레드','거기 뷰 좋나요????','거기 뷰 좋나요????','2022-05-03 05:26:02',173,'sm4567','qna'),(28,'카페 레드','여기 음료 맛있나요?','음료 맛있나요?','2022-05-09 03:14:34',11,'sm4567','qna'),(29,'카페 레드','여기 음료 맛있나요???','여기 음료 맛있나요???','2022-05-09 03:17:14',11,'sm4567','qna'),(30,'카페 레드','여기 디저트 어떤가요?','여기 디저트 어떤가요?','2022-05-09 03:18:35',6,'sm4567','qna'),(31,'카페 레드','여기 음료 맛있나요? ㅎㅎ','여기 음료 맛있나요? ㅎㅎ','2022-05-10 06:14:11',6,'sm4567','qna'),(35,'카페 레드','오늘 여나요?','오늘 여나요?','2022-05-11 04:55:12',4,'sm1234','qna'),(36,'카페 레드','오늘 여나요?','오늘 여나요?\r\n오늘 여나요?','2022-05-11 05:09:36',14,'sm1234','qna'),(37,'카페 레드','오늘 여나요?','asdfds','2022-05-11 06:37:41',13,'sm1234','qna'),(38,'카페 레드','오늘 여나요?','asdfds','2022-05-12 01:00:52',0,'sm1234','qna'),(39,'카페 레드','거기 뷰 좋나요????','거기 뷰 좋나요????','2022-05-12 05:21:22',1,'sm1234','qna');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articlephoto`
--

DROP TABLE IF EXISTS `articlephoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articlephoto` (
  `article_photo_id` int NOT NULL AUTO_INCREMENT,
  `filename` varchar(100) NOT NULL,
  `Article_article_id` int NOT NULL,
  PRIMARY KEY (`article_photo_id`),
  KEY `fk_ArticlePhoto_Article1` (`Article_article_id`),
  CONSTRAINT `fk_ArticlePhoto_Article1` FOREIGN KEY (`Article_article_id`) REFERENCES `article` (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articlephoto`
--

LOCK TABLES `articlephoto` WRITE;
/*!40000 ALTER TABLE `articlephoto` DISABLE KEYS */;
INSERT INTO `articlephoto` VALUES (17,'dog-g0b2aeeec0_640.png',27),(20,'cafe1.jpg',35),(21,'americano.jpeg',37),(22,'cafe1.jpg',37);
/*!40000 ALTER TABLE `articlephoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articlereply`
--

DROP TABLE IF EXISTS `articlereply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articlereply` (
  `reply_id` int NOT NULL AUTO_INCREMENT,
  `reply_content` text,
  `Article_article_id` int NOT NULL,
  `user_user_id` varchar(50) NOT NULL,
  PRIMARY KEY (`reply_id`),
  UNIQUE KEY `reply_id_UNIQUE` (`reply_id`),
  KEY `fk_TodaysCafeArticleReply_TodaysCafeArticle1_idx` (`Article_article_id`),
  KEY `fk_TodaysCafeArticleReply_user1_idx` (`user_user_id`),
  CONSTRAINT `fk_TodaysCafeArticleReply_TodaysCafeArticle1` FOREIGN KEY (`Article_article_id`) REFERENCES `article` (`article_id`),
  CONSTRAINT `fk_TodaysCafeArticleReply_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articlereply`
--

LOCK TABLES `articlereply` WRITE;
/*!40000 ALTER TABLE `articlereply` DISABLE KEYS */;
/*!40000 ALTER TABLE `articlereply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cafe`
--

DROP TABLE IF EXISTS `cafe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cafe` (
  `cafe_id` int NOT NULL AUTO_INCREMENT,
  `cafe_name` varchar(50) NOT NULL,
  `cafe_location1` varchar(100) NOT NULL,
  `cafe_location2` varchar(100) NOT NULL,
  `number_of_seat` int NOT NULL,
  `user_user_id` varchar(50) NOT NULL,
  `phonenum1` varchar(5) DEFAULT NULL,
  `phonenum2` varchar(5) DEFAULT NULL,
  `phonenum3` varchar(5) DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `business_state` varchar(50) DEFAULT NULL,
  `shutdown_date` datetime DEFAULT NULL,
  `open_time` time DEFAULT NULL,
  `close_time` time DEFAULT NULL,
  PRIMARY KEY (`cafe_id`),
  UNIQUE KEY `cafe_id_UNIQUE` (`cafe_id`),
  KEY `fk_cafe_user1_idx` (`user_user_id`),
  CONSTRAINT `fk_cafe_user` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cafe`
--

LOCK TABLES `cafe` WRITE;
/*!40000 ALTER TABLE `cafe` DISABLE KEYS */;
/*!40000 ALTER TABLE `cafe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cafehomearticle`
--

DROP TABLE IF EXISTS `cafehomearticle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cafehomearticle` (
  `article_id` int NOT NULL AUTO_INCREMENT,
  `article_content` text,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `cafe_cafe_id` int NOT NULL,
  `user_user_id` varchar(50) NOT NULL,
  PRIMARY KEY (`article_id`),
  UNIQUE KEY `article_id_UNIQUE` (`article_id`),
  KEY `fk_CafeHomeArticle_cafe1_idx` (`cafe_cafe_id`),
  KEY `fk_CafeHomeArticle_user1_idx` (`user_user_id`),
  CONSTRAINT `fk_CafeHomeArticle_cafe1` FOREIGN KEY (`cafe_cafe_id`) REFERENCES `cafe` (`cafe_id`),
  CONSTRAINT `fk_CafeHomeArticle_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cafehomearticle`
--

LOCK TABLES `cafehomearticle` WRITE;
/*!40000 ALTER TABLE `cafehomearticle` DISABLE KEYS */;
/*!40000 ALTER TABLE `cafehomearticle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cafephoto`
--

DROP TABLE IF EXISTS `cafephoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cafephoto` (
  `cafe_cafe_id` int NOT NULL,
  `photo_location` varchar(100) NOT NULL,
  `photo_type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cafe_cafe_id`),
  UNIQUE KEY `cafe_cafe_id_UNIQUE` (`cafe_cafe_id`),
  KEY `fk_CafePhoto_cafe1_idx` (`cafe_cafe_id`),
  CONSTRAINT `fk_CafePhoto_cafe1` FOREIGN KEY (`cafe_cafe_id`) REFERENCES `cafe` (`cafe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cafephoto`
--

LOCK TABLES `cafephoto` WRITE;
/*!40000 ALTER TABLE `cafephoto` DISABLE KEYS */;
/*!40000 ALTER TABLE `cafephoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cafereview`
--

DROP TABLE IF EXISTS `cafereview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cafereview` (
  `review_id` int NOT NULL AUTO_INCREMENT,
  `review_content` text,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cafe_cafe_id` int NOT NULL,
  `user_user_id` varchar(50) NOT NULL,
  `OrderAndReservation_OrderAndReservation_id` int NOT NULL,
  PRIMARY KEY (`review_id`),
  UNIQUE KEY `review_id_UNIQUE` (`review_id`),
  KEY `fk_CafeReview_cafe1_idx` (`cafe_cafe_id`),
  KEY `fk_CafeReview_user1_idx` (`user_user_id`),
  KEY `fk_CafeReview_OrderAndReservation1_idx` (`OrderAndReservation_OrderAndReservation_id`),
  CONSTRAINT `fk_CafeReview_cafe1` FOREIGN KEY (`cafe_cafe_id`) REFERENCES `cafe` (`cafe_id`),
  CONSTRAINT `fk_CafeReview_OrderAndReservation1` FOREIGN KEY (`OrderAndReservation_OrderAndReservation_id`) REFERENCES `orderandreservation` (`OrderAndReservation_id`),
  CONSTRAINT `fk_CafeReview_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cafereview`
--

LOCK TABLES `cafereview` WRITE;
/*!40000 ALTER TABLE `cafereview` DISABLE KEYS */;
/*!40000 ALTER TABLE `cafereview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cafereviewphoto`
--

DROP TABLE IF EXISTS `cafereviewphoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cafereviewphoto` (
  `CafeReview_review_id` int NOT NULL,
  `photo_location` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CafeReview_review_id`),
  UNIQUE KEY `CafeReview_review_id_UNIQUE` (`CafeReview_review_id`),
  KEY `fk_CafeReviewPhoto_CafeReview1_idx` (`CafeReview_review_id`),
  CONSTRAINT `fk_CafeReviewPhoto_CafeReview1` FOREIGN KEY (`CafeReview_review_id`) REFERENCES `cafereview` (`review_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cafereviewphoto`
--

LOCK TABLES `cafereviewphoto` WRITE;
/*!40000 ALTER TABLE `cafereviewphoto` DISABLE KEYS */;
/*!40000 ALTER TABLE `cafereviewphoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cart_id` int NOT NULL,
  `user_user_id` varchar(50) NOT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `fk_cart_user1_idx` (`user_user_id`),
  CONSTRAINT `fk_cart_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_goods`
--

DROP TABLE IF EXISTS `cart_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_goods` (
  `cart_goods_id` int NOT NULL AUTO_INCREMENT,
  `order_quantity` int NOT NULL DEFAULT '0',
  `cart_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cart_state` varchar(50) DEFAULT NULL,
  `user_user_id` varchar(50) NOT NULL,
  `cafe_cafe_id` int NOT NULL,
  `cart_cart_id` int NOT NULL,
  PRIMARY KEY (`cart_goods_id`),
  UNIQUE KEY `cart_id_UNIQUE` (`cart_goods_id`),
  KEY `fk_cart_goods_user_idx` (`user_user_id`),
  KEY `fk_cart_goods_cafe_idx` (`cafe_cafe_id`),
  KEY `fk_cart_goods_cart1_idx` (`cart_cart_id`),
  CONSTRAINT `fk_cart_goods_cafe` FOREIGN KEY (`cafe_cafe_id`) REFERENCES `cafe` (`cafe_id`),
  CONSTRAINT `fk_cart_goods_cart1` FOREIGN KEY (`cart_cart_id`) REFERENCES `cart` (`cart_id`),
  CONSTRAINT `fk_cart_goods_user` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_goods`
--

LOCK TABLES `cart_goods` WRITE;
/*!40000 ALTER TABLE `cart_goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_group_seat`
--

DROP TABLE IF EXISTS `cart_group_seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_group_seat` (
  `cart_group_seat_id` int NOT NULL AUTO_INCREMENT,
  `reservation_date` date NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `cart_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cart_state` varchar(50) NOT NULL,
  `user_user_id` varchar(50) NOT NULL,
  `cafe_cafe_id` int NOT NULL,
  `cart_cart_id` int NOT NULL,
  PRIMARY KEY (`cart_group_seat_id`),
  UNIQUE KEY `cart_id_UNIQUE` (`cart_group_seat_id`),
  KEY `fk_cart_group_seat_user1_idx` (`user_user_id`),
  KEY `fk_cart_group_seat_cafe1_idx` (`cafe_cafe_id`),
  KEY `fk_cart_group_seat_cart1_idx` (`cart_cart_id`),
  CONSTRAINT `fk_cart_group_seat_cafe1` FOREIGN KEY (`cafe_cafe_id`) REFERENCES `cafe` (`cafe_id`),
  CONSTRAINT `fk_cart_group_seat_cart1` FOREIGN KEY (`cart_cart_id`) REFERENCES `cart` (`cart_id`),
  CONSTRAINT `fk_cart_group_seat_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_group_seat`
--

LOCK TABLES `cart_group_seat` WRITE;
/*!40000 ALTER TABLE `cart_group_seat` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_group_seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facilityinfo`
--

DROP TABLE IF EXISTS `facilityinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facilityinfo` (
  `cafe_cafe_id` int NOT NULL,
  `parking_lot` tinyint DEFAULT '0',
  `power_plug` tinyint DEFAULT '0',
  `wifi` tinyint DEFAULT '0',
  PRIMARY KEY (`cafe_cafe_id`),
  KEY `fk_FacilityInfo_cafe1_idx` (`cafe_cafe_id`),
  CONSTRAINT `fk_FacilityInfo_cafe1` FOREIGN KEY (`cafe_cafe_id`) REFERENCES `cafe` (`cafe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facilityinfo`
--

LOCK TABLES `facilityinfo` WRITE;
/*!40000 ALTER TABLE `facilityinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `facilityinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods` (
  `goods_id` int NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(50) DEFAULT NULL,
  `price` int NOT NULL DEFAULT '0',
  `cafe_cafe_id` int NOT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`goods_id`),
  UNIQUE KEY `goods_id_UNIQUE` (`goods_id`),
  KEY `fk_goods_cafe1_idx` (`cafe_cafe_id`),
  CONSTRAINT `fk_goods_cafe1` FOREIGN KEY (`cafe_cafe_id`) REFERENCES `cafe` (`cafe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goodsorder`
--

DROP TABLE IF EXISTS `goodsorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goodsorder` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_quantity` int NOT NULL DEFAULT '0',
  `order_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `order_state` varchar(50) DEFAULT NULL,
  `user_user_id` varchar(50) NOT NULL,
  `cafe_cafe_id` int NOT NULL,
  `goods_goods_id` int NOT NULL,
  `OrderAndReservation_OrderAndReservation_id` int NOT NULL,
  `is_takeout` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_id_UNIQUE` (`order_id`),
  KEY `fk_order_user1_idx` (`user_user_id`),
  KEY `fk_order_cafe1_idx` (`cafe_cafe_id`),
  KEY `fk_GoodsOrder_goods1_idx` (`goods_goods_id`),
  KEY `fk_GoodsOrder_OrderAndReservation1_idx` (`OrderAndReservation_OrderAndReservation_id`),
  CONSTRAINT `fk_GoodsOrder_goods1` FOREIGN KEY (`goods_goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `fk_GoodsOrder_OrderAndReservation1` FOREIGN KEY (`OrderAndReservation_OrderAndReservation_id`) REFERENCES `orderandreservation` (`OrderAndReservation_id`),
  CONSTRAINT `fk_order_cafe1` FOREIGN KEY (`cafe_cafe_id`) REFERENCES `cafe` (`cafe_id`),
  CONSTRAINT `fk_order_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goodsorder`
--

LOCK TABLES `goodsorder` WRITE;
/*!40000 ALTER TABLE `goodsorder` DISABLE KEYS */;
/*!40000 ALTER TABLE `goodsorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goodsphoto`
--

DROP TABLE IF EXISTS `goodsphoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goodsphoto` (
  `goods_goods_id` int NOT NULL,
  `photo_location` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`goods_goods_id`),
  UNIQUE KEY `goods_goods_id_UNIQUE` (`goods_goods_id`),
  KEY `fk_GoodsPhoto_goods1_idx` (`goods_goods_id`),
  CONSTRAINT `fk_GoodsPhoto_goods1` FOREIGN KEY (`goods_goods_id`) REFERENCES `goods` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goodsphoto`
--

LOCK TABLES `goodsphoto` WRITE;
/*!40000 ALTER TABLE `goodsphoto` DISABLE KEYS */;
/*!40000 ALTER TABLE `goodsphoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupseat`
--

DROP TABLE IF EXISTS `groupseat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `groupseat` (
  `groupseat_id` int NOT NULL AUTO_INCREMENT,
  `seat_name` varchar(50) DEFAULT NULL,
  `price` int NOT NULL DEFAULT '0',
  `cafe_cafe_id` int NOT NULL,
  `reservation_reservation_id` int NOT NULL,
  PRIMARY KEY (`groupseat_id`),
  UNIQUE KEY `groupseat_id_UNIQUE` (`groupseat_id`),
  KEY `fk_GroupSeat_cafe1_idx` (`cafe_cafe_id`),
  KEY `fk_GroupSeat_reservation1_idx` (`reservation_reservation_id`),
  CONSTRAINT `fk_GroupSeat_cafe1` FOREIGN KEY (`cafe_cafe_id`) REFERENCES `cafe` (`cafe_id`),
  CONSTRAINT `fk_GroupSeat_reservation1` FOREIGN KEY (`reservation_reservation_id`) REFERENCES `reservation` (`reservation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupseat`
--

LOCK TABLES `groupseat` WRITE;
/*!40000 ALTER TABLE `groupseat` DISABLE KEYS */;
/*!40000 ALTER TABLE `groupseat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupseatphoto`
--

DROP TABLE IF EXISTS `groupseatphoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `groupseatphoto` (
  `GroupSeat_groupseat_id` int NOT NULL,
  `photo_location` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`GroupSeat_groupseat_id`),
  UNIQUE KEY `GroupSeat_groupseat_id_UNIQUE` (`GroupSeat_groupseat_id`),
  KEY `fk_GroupSeatPhoto_GroupSeat1_idx` (`GroupSeat_groupseat_id`),
  CONSTRAINT `fk_GroupSeatPhoto_GroupSeat1` FOREIGN KEY (`GroupSeat_groupseat_id`) REFERENCES `groupseat` (`groupseat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupseatphoto`
--

LOCK TABLES `groupseatphoto` WRITE;
/*!40000 ALTER TABLE `groupseatphoto` DISABLE KEYS */;
/*!40000 ALTER TABLE `groupseatphoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likedarticle`
--

DROP TABLE IF EXISTS `likedarticle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likedarticle` (
  `liked_article_id` int NOT NULL AUTO_INCREMENT,
  `user_user_id` varchar(50) NOT NULL,
  `Article_article_id` int NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`liked_article_id`),
  UNIQUE KEY `liked_article_id_UNIQUE` (`liked_article_id`),
  KEY `fk_LikedArticle_user1_idx` (`user_user_id`),
  KEY `fk_LikedArticle_Article1_idx` (`Article_article_id`),
  CONSTRAINT `fk_LikedArticle_Article1` FOREIGN KEY (`Article_article_id`) REFERENCES `article` (`article_id`),
  CONSTRAINT `fk_LikedArticle_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likedarticle`
--

LOCK TABLES `likedarticle` WRITE;
/*!40000 ALTER TABLE `likedarticle` DISABLE KEYS */;
INSERT INTO `likedarticle` VALUES (8,'sm4567',27,'2022-05-10 15:09:24'),(19,'sm1234',27,'2022-05-12 14:45:37');
/*!40000 ALTER TABLE `likedarticle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likedcafe`
--

DROP TABLE IF EXISTS `likedcafe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likedcafe` (
  `liked_cafe_id` int NOT NULL AUTO_INCREMENT,
  `user_user_id` varchar(50) NOT NULL,
  `cafe_cafe_id` int NOT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`liked_cafe_id`),
  UNIQUE KEY `liked_cafe_id_UNIQUE` (`liked_cafe_id`),
  KEY `fk_LikedCafe_user1_idx` (`user_user_id`),
  KEY `fk_LikedCafe_cafe1_idx` (`cafe_cafe_id`),
  CONSTRAINT `fk_LikedCafe_cafe1` FOREIGN KEY (`cafe_cafe_id`) REFERENCES `cafe` (`cafe_id`),
  CONSTRAINT `fk_LikedCafe_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likedcafe`
--

LOCK TABLES `likedcafe` WRITE;
/*!40000 ALTER TABLE `likedcafe` DISABLE KEYS */;
/*!40000 ALTER TABLE `likedcafe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mileagehistory`
--

DROP TABLE IF EXISTS `mileagehistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mileagehistory` (
  `mileage_history_id` int NOT NULL AUTO_INCREMENT,
  `mileage_score` int NOT NULL DEFAULT '0',
  `accumalate_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `user_user_id` varchar(50) NOT NULL,
  `cafe_cafe_id` int NOT NULL,
  `OrderAndReservation_OrderAndReservation_id` int NOT NULL,
  PRIMARY KEY (`mileage_history_id`),
  UNIQUE KEY `mileage_history_id_UNIQUE` (`mileage_history_id`),
  KEY `fk_MileageHistory_user1_idx` (`user_user_id`),
  KEY `fk_MileageHistory_cafe1_idx` (`cafe_cafe_id`),
  KEY `fk_MileageHistory_OrderAndReservation1_idx` (`OrderAndReservation_OrderAndReservation_id`),
  CONSTRAINT `fk_MileageHistory_cafe1` FOREIGN KEY (`cafe_cafe_id`) REFERENCES `cafe` (`cafe_id`),
  CONSTRAINT `fk_MileageHistory_OrderAndReservation1` FOREIGN KEY (`OrderAndReservation_OrderAndReservation_id`) REFERENCES `orderandreservation` (`OrderAndReservation_id`),
  CONSTRAINT `fk_MileageHistory_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mileagehistory`
--

LOCK TABLES `mileagehistory` WRITE;
/*!40000 ALTER TABLE `mileagehistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `mileagehistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderandreservation`
--

DROP TABLE IF EXISTS `orderandreservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderandreservation` (
  `OrderAndReservation_id` int NOT NULL,
  `user_user_id` varchar(50) NOT NULL,
  PRIMARY KEY (`OrderAndReservation_id`),
  KEY `fk_OrderAndReservation_user1_idx` (`user_user_id`),
  CONSTRAINT `fk_OrderAndReservation_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderandreservation`
--

LOCK TABLES `orderandreservation` WRITE;
/*!40000 ALTER TABLE `orderandreservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderandreservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parkinglot`
--

DROP TABLE IF EXISTS `parkinglot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parkinglot` (
  `parking_lot_id` int NOT NULL AUTO_INCREMENT,
  `parking_lot_name` varchar(50) DEFAULT NULL,
  `parking_lot_location1` varchar(100) DEFAULT NULL,
  `parking_lot_location2` varchar(100) DEFAULT NULL,
  `cafe_cafe_id` int NOT NULL,
  `cordinate_x` float(8,5) DEFAULT NULL,
  `cordinate_y` float(8,5) DEFAULT NULL,
  PRIMARY KEY (`parking_lot_id`),
  UNIQUE KEY `parking_lot_id_UNIQUE` (`parking_lot_id`),
  KEY `fk_ParkingLot_cafe1_idx` (`cafe_cafe_id`),
  CONSTRAINT `fk_ParkingLot_cafe1` FOREIGN KEY (`cafe_cafe_id`) REFERENCES `cafe` (`cafe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parkinglot`
--

LOCK TABLES `parkinglot` WRITE;
/*!40000 ALTER TABLE `parkinglot` DISABLE KEYS */;
/*!40000 ALTER TABLE `parkinglot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommendedcafe`
--

DROP TABLE IF EXISTS `recommendedcafe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recommendedcafe` (
  `recommended_cafe_id` int NOT NULL AUTO_INCREMENT,
  `recommend_type` varchar(50) DEFAULT NULL,
  `user_user_id` varchar(50) NOT NULL,
  `cafe_cafe_id` int NOT NULL,
  PRIMARY KEY (`recommended_cafe_id`),
  UNIQUE KEY `recommended_cafe_id_UNIQUE` (`recommended_cafe_id`),
  KEY `fk_RecommendedCafe_user1_idx` (`user_user_id`),
  KEY `fk_RecommendedCafe_cafe1_idx` (`cafe_cafe_id`),
  CONSTRAINT `fk_RecommendedCafe_cafe1` FOREIGN KEY (`cafe_cafe_id`) REFERENCES `cafe` (`cafe_id`),
  CONSTRAINT `fk_RecommendedCafe_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommendedcafe`
--

LOCK TABLES `recommendedcafe` WRITE;
/*!40000 ALTER TABLE `recommendedcafe` DISABLE KEYS */;
/*!40000 ALTER TABLE `recommendedcafe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `reservation_id` int NOT NULL AUTO_INCREMENT,
  `reservation_date` date NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `reservation_add_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `reservation_state` varchar(50) NOT NULL,
  `user_user_id` varchar(50) NOT NULL,
  `cafe_cafe_id` int NOT NULL,
  `OrderAndReservation_OrderAndReservation_id` int NOT NULL,
  PRIMARY KEY (`reservation_id`),
  UNIQUE KEY `reservation_id_UNIQUE` (`reservation_id`),
  KEY `fk_reservation_user_idx` (`user_user_id`),
  KEY `fk_reservation_cafe1_idx` (`cafe_cafe_id`),
  KEY `fk_reservation_OrderAndReservation1_idx` (`OrderAndReservation_OrderAndReservation_id`),
  CONSTRAINT `fk_reservation_cafe1` FOREIGN KEY (`cafe_cafe_id`) REFERENCES `cafe` (`cafe_id`),
  CONSTRAINT `fk_reservation_OrderAndReservation1` FOREIGN KEY (`OrderAndReservation_OrderAndReservation_id`) REFERENCES `orderandreservation` (`OrderAndReservation_id`),
  CONSTRAINT `fk_reservation_user` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `themescore`
--

DROP TABLE IF EXISTS `themescore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `themescore` (
  `theme_score_id` int NOT NULL AUTO_INCREMENT,
  `mood_score` int DEFAULT '0',
  `coffee_score` int DEFAULT NULL,
  `drink_score` int DEFAULT NULL,
  `dessert_score` int DEFAULT NULL,
  `quiet_score` int DEFAULT NULL,
  `view_score` int DEFAULT NULL,
  `cafe_cafe_id` int NOT NULL,
  PRIMARY KEY (`theme_score_id`),
  UNIQUE KEY `theme_score_id_UNIQUE` (`theme_score_id`),
  KEY `fk_ThemeScore_cafe1_idx` (`cafe_cafe_id`),
  CONSTRAINT `fk_ThemeScore_cafe1` FOREIGN KEY (`cafe_cafe_id`) REFERENCES `cafe` (`cafe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `themescore`
--

LOCK TABLES `themescore` WRITE;
/*!40000 ALTER TABLE `themescore` DISABLE KEYS */;
/*!40000 ALTER TABLE `themescore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` varchar(50) NOT NULL,
  `user_pw` varchar(60) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `phonenum1` varchar(5) DEFAULT NULL,
  `phonenum2` varchar(5) DEFAULT NULL,
  `phonenum3` varchar(5) DEFAULT NULL,
  `user_email` varchar(50) DEFAULT NULL,
  `mileage` int DEFAULT '0',
  `user_role` varchar(20) DEFAULT NULL,
  `join_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `join_state` varchar(50) DEFAULT NULL,
  `quit_date` datetime DEFAULT NULL,
  `company_registration_number` varchar(20) DEFAULT NULL,
  `sns_account` varchar(20) NOT NULL DEFAULT 'no',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin1234','$2a$10$ae.XDar8o84nVEJ7AckVSO6zNA2Irf7dyIWcpTNNFjBdUWV1uhaYu','최사장','011','7331','8505','eofus1234@naver.com',0,'cafe_manager','2022-05-13 02:27:54','joined',NULL,'111-11-11111','0'),('sm1234','$2a$10$A2/5FmfL7jPmm8qFOzX0U.5dJGMNHOQaB/A9KAA12Z4wAqYSYu/ue','최대현','010','1234','1234','eofus1234@naver.com',0,'normal_user','2022-04-27 12:29:59','joined',NULL,NULL,'0'),('sm4428','$2a$10$A2/5FmfL7jPmm8qFOzX0U.5dJGMNHOQaB/A9KAA12Z4wAqYSYu/ue','최대련','010','7331','8505',NULL,0,'normal_user','2022-04-22 06:45:19','joined',NULL,NULL,'0'),('sm4567','$2a$10$A2/5FmfL7jPmm8qFOzX0U.5dJGMNHOQaB/A9KAA12Z4wAqYSYu/ue','최치원','010','1234','1234','eofus1234@naver.com',0,'normal_user','2022-05-02 12:28:47','joined',NULL,NULL,'0');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userprofilephoto`
--

DROP TABLE IF EXISTS `userprofilephoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userprofilephoto` (
  `user_user_id` varchar(50) NOT NULL,
  `filename` varchar(100) NOT NULL,
  PRIMARY KEY (`user_user_id`),
  UNIQUE KEY `user_user_id_UNIQUE` (`user_user_id`),
  KEY `fk_UserProfilePhoto_user1_idx` (`user_user_id`),
  CONSTRAINT `fk_UserProfilePhoto_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userprofilephoto`
--

LOCK TABLES `userprofilephoto` WRITE;
/*!40000 ALTER TABLE `userprofilephoto` DISABLE KEYS */;
INSERT INTO `userprofilephoto` VALUES ('admin1234','dog-g0b2aeeec0_640.png'),('sm1234','profile.jpg'),('sm4567','dog-g0b2aeeec0_640.png');
/*!40000 ALTER TABLE `userprofilephoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'CafeWhereIGo'
--
/*!50003 DROP FUNCTION IF EXISTS `getLikeCount` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`SiteAdmin`@`%` FUNCTION `getLikeCount`(article_id int) RETURNS int
    DETERMINISTIC
begin
    declare like_count int;

    select count(*) into like_count from likedarticle
    where Article_article_id = article_id;

    return like_count;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `getPreviousViewCount` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`SiteAdmin`@`%` FUNCTION `getPreviousViewCount`(article_no int) RETURNS int
    DETERMINISTIC
begin
    declare view_counts int;
    
    select view_count
    into view_counts
    from article
    where article_id=article_no;
    return view_counts;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-16 12:05:36
