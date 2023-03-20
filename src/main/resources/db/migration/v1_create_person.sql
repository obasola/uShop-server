CREATE TABLE `Person` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `email` varchar(45) DEFAULT NULL,
                          `password` varchar(45) NOT NULL,
                          `first_name` varchar(45) DEFAULT NULL,
                          `last_name` varchar(45) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
