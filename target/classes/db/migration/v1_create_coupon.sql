
CREATE TABLE `Coupon` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `coupon` varchar(100) NOT NULL,
                          `barcode` varchar(45) DEFAULT NULL,
                          `discount` decimal(5,2) NOT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
