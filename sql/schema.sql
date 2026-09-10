CREATE TABLE `pets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `species` varchar(20) NOT NULL,
  `breed` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `birth_date` date NOT NULL,
  `height` double DEFAULT NULL,
  `neck_size` double DEFAULT NULL,
  `chest_size` double DEFAULT NULL,
  `neutered` tinyint(1) NOT NULL,
  `activity_level` varchar(20) NOT NULL,
  `memo` varchar(200) DEFAULT NULL,
  `body_height` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `health_records` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pet_id` int NOT NULL,
  `record_date` date NOT NULL,
  `weight` double DEFAULT NULL,
  `poop_condition` varchar(20) DEFAULT NULL,
  `urination_count` int DEFAULT NULL,
  `vomiting` tinyint(1) NOT NULL DEFAULT '0',
  `morning_food_amount` int DEFAULT NULL,
  `morning_no_meal` tinyint(1) NOT NULL DEFAULT '0',
  `evening_food_amount` int DEFAULT NULL,
  `evening_no_meal` tinyint(1) NOT NULL DEFAULT '0',
  `memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pet_id` (`pet_id`),
  CONSTRAINT `health_records_ibfk_1`
    FOREIGN KEY (`pet_id`) REFERENCES `pets` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `foods` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pet_id` int NOT NULL,
  `food_name` varchar(100) NOT NULL,
  `calorie` int NOT NULL,
  `palatability` int DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pet_id` (`pet_id`),
  CONSTRAINT `foods_ibfk_1`
    FOREIGN KEY (`pet_id`) REFERENCES `pets` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
