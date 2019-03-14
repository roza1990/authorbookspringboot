/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.25-0ubuntu0.16.04.2 : Database - author_book
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`author_book` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `author_book`;

/*Table structure for table `author` */

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `author` */

insert  into `author`(`id`,`age`,`email`,`name`,`surname`) values (1,70,'roza.tahmazyan@mail.ru','Paolo','Kuelo'),(2,70,'roza.tahmazyan@mail.ru','Erix','Ramark'),(3,22,'roza.tahmazyan@mail.ru','test','Khachatryan');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `description` text,
  `pic_url` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `author_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKklnrv3weler2ftkweewlky958` (`author_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `book` */

insert  into `book`(`id`,`count`,`description`,`pic_url`,`price`,`title`,`author_id`) values (1,10,'description','1551891058544_51221341_1012222692321439_8264313351555776512_o.jpg',50,'Haxtakan Kamar,',2),(2,5,'test','1552298587061_51221341_1012222692321439_8264313351555776512_o.jpg',555,'test,',2),(3,3,'description','1552298688544_51221341_1012222692321439_8264313351555776512_o.jpg',777,'Blog title,',1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`email`,`name`,`surname`) values (1,'roza','roza','roza'),(2,'test','test','test');

/*Table structure for table `user_book` */

DROP TABLE IF EXISTS `user_book`;

CREATE TABLE `user_book` (
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  KEY `FK85pwltn867pjxog1gk5smtqcw` (`book_id`),
  KEY `FKbc0bwdnndnxhct38sinbem0n0` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `user_book` */

insert  into `user_book`(`user_id`,`book_id`) values (1,1),(2,1),(1,2),(1,3),(2,3),(2,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
