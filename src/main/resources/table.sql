CREATE DATABASE  IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;
 SET NAMES utf8 ;


--
-- Table structure for table `user`
--
DROP TABLE IF EXISTS `user`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_of_birth` date DEFAULT NULL,
  `full_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--
LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'2018-09-19','D');
UNLOCK TABLES;


--
-- Table structure for table `article`
--
DROP TABLE IF EXISTS `article`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_text` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `article`
--
LOCK TABLES `article` WRITE;
INSERT INTO `article` VALUES (1,'This is my first article');
INSERT INTO `article` VALUES (2,'This is my second article');
UNLOCK TABLES;

--
-- Table structure for table `comment`
--
DROP TABLE IF EXISTS `comment`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_str` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `article_id_idx` (`article_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `article_id` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `comment`
--
LOCK TABLES `comment` WRITE;
INSERT INTO `comment` VALUES (1,'This is my first comment to article 1','2018-09-23 00:00:00',1,1);
INSERT INTO `comment` VALUES (2,'This is my second comment to article 1','2018-09-23 00:00:00',1,1);
UNLOCK TABLES;

CREATE TABLE `tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tag_id`),
  UNIQUE KEY `id_UNIQUE` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `article_tag` (
  `article_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  UNIQUE KEY `uq_article_tag` (`article_id`,`tag_id`),
  KEY `article_id_idx` (`article_id`),
  KEY `tag_id_idx` (`tag_id`),
  CONSTRAINT `` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`),
  CONSTRAINT `tag_id` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
