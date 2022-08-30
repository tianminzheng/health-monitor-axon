DROP TABLE IF EXISTS `health_task`;

create table `health_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_id` varchar(50) not null,
  `task_name` varchar(50) not null,
  `description` varchar(100) not null,  
  `task_score` int not null,
	PRIMARY KEY (`id`)
);

insert into `health_task` VALUES ('1', 'task1', 'task_name1','description1',100);
insert into `health_task` VALUES ('2', 'task2', 'task_name2','description2',50);
insert into `health_task` VALUES ('3', 'task3', 'task_name3','description3',70);
insert into `health_task` VALUES ('4', 'task4', 'task_name4','description4',80);