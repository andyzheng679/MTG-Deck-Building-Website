CREATE DATABASE  IF NOT EXISTS `login_info`;
USE `login_info`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `login`;

CREATE TABLE IF NOT EXISTS users (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name`varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
