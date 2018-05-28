CREATE DATABASE `ignite_spring`;

USE `ignite_spring`;

CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ss_number` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `update_ts` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);

CREATE TRIGGER `ignite_spring`.`person_BEFORE_UPDATE` BEFORE UPDATE ON `person` FOR EACH ROW
BEGIN
    SET NEW.update_ts = CURRENT_TIMESTAMP;
END
