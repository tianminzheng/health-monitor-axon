DROP TABLE IF EXISTS `health_monitor`;

create table `health_monitor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `monitor_id` varchar(50) not null,
  `status` varchar(20) not null,
  `account` varchar(100) not null,
  `score` int not null,
  
  `order_number` varchar(100) not null,
  `allergy` varchar(200),
  `injection` varchar(200),
  `surgery` varchar(200),
  `symptom_description` varchar(200),
  `body_part` varchar(100),  
  `time_duration` varchar(100),
  `order_status` varchar(20) not null,
  
  `plan_id` varchar(100),   
  `doctor` varchar(100),  
  `tasks` varchar(100),    
  `description` varchar(100), 
	PRIMARY KEY (`id`)
);