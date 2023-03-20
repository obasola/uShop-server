CREATE TABLE `Store` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `name` varchar(45) NOT NULL,
                         `website` varchar(75) DEFAULT NULL,
                         `address` varchar(45) DEFAULT NULL,
                         `city` varchar(45) DEFAULT NULL,
                         `state` varchar(2) DEFAULT NULL,
                         `zipcode` varchar(5) DEFAULT NULL,
                         `phone` varchar(11) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
