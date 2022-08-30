DROP TABLE IF EXISTS `health_record`;

CREATE TABLE `health_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_id` varchar(100) DEFAULT NULL,
  `account` varchar(100) DEFAULT NULL,
  `record_type` varchar(20) DEFAULT NULL,
  `record_value` varchar(100) DEFAULT NULL,
  `health_score` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `health_record` VALUES ('1', 'record1', 'account1', 'MONITOR', 'monitor1', '0');
