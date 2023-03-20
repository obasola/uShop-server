CREATE TABLE `Item_List` (
                             `id` int NOT NULL AUTO_INCREMENT,
                             `item` varchar(45) NOT NULL,
                             `recurring` smallint DEFAULT NULL,
                             `date_recorded` date NOT NULL,
                             `price` decimal(5,2) NOT NULL,
                             `aisle` varchar(45) DEFAULT NULL,
                             `barcode` varchar(100) DEFAULT NULL,
                             `Store_id` int NOT NULL,
                             `Coupon_id` int NOT NULL,
                             `Person_id` int NOT NULL,
                             PRIMARY KEY (`id`,`Store_id`),
                             KEY `fk_Item_List_Store_idx` (`Store_id`),
                             KEY `fk_Item_List_Coupon1_idx` (`Coupon_id`),
                             KEY `fk_Item_List_Person1_idx` (`Person_id`),
                             CONSTRAINT `fk_Item_List_Coupon1` FOREIGN KEY (`Coupon_id`) REFERENCES `Coupon` (`id`),
                             CONSTRAINT `fk_Item_List_Person1` FOREIGN KEY (`Person_id`) REFERENCES `Person` (`id`),
                             CONSTRAINT `fk_Item_List_Store` FOREIGN KEY (`Store_id`) REFERENCES `Store` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
