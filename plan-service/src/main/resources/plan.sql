DROP TABLE IF EXISTS `health_plan`;
DROP TABLE IF EXISTS `health_task`;

create table `health_plan` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`plan_id` varchar(100) not null,
	`account` varchar(50) not null,
	`doctor` varchar(50) not null,
	`description` varchar(100) not null,
	PRIMARY KEY (`id`)
);

create table `health_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `plan_id` bigint(20) NOT NULL,
  `task_id` varchar(50) not null,
  `task_name` varchar(50) not null,
  `description` varchar(100) not null,  
  `task_score` int not null,
	PRIMARY KEY (`id`)
);

insert into `health_plan` VALUES ('1', 'plan1', 'account1', 'doctor1', 'description1');
insert into `health_task` VALUES ('1', '1', 'task1', 'task_name1','description1',100);
insert into `health_task` VALUES ('2', '1', 'task2', 'task_name2','description2',50);

insert into `health_plan` VALUES ('2', 'plan2', 'account2', 'doctor2', 'description2');
insert into `health_task` VALUES ('3', '2', 'task3', 'task_name3','description3',70);
insert into `health_task` VALUES ('4', '2', 'task4', 'task_name4','description4',80);