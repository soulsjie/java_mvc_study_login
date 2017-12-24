# Host: localhost  (Version: 5.5.53)
# Date: 2017-12-24 13:31:10
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "login_info"
#

DROP TABLE IF EXISTS `login_info`;
CREATE TABLE `login_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "login_info"
#

/*!40000 ALTER TABLE `login_info` DISABLE KEYS */;
INSERT INTO `login_info` VALUES (1,'jie','jie'),(2,'test','test');
/*!40000 ALTER TABLE `login_info` ENABLE KEYS */;
