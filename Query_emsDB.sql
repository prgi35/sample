create database ems_prod;
use ems_prod;
CREATE TABLE `resource_details` (
    `employee_id` INT not null auto_increment,
	`yash_emp_Id` LONG NOT NULL,
    `employee_name` VARCHAR(80) NOT NULL,
    `grade`  VARCHAR(3) NOT NULL,
    `designation` VARCHAR(60) NOT NULL,
	`email` VARCHAR(45) NOT NULL,
	`date_of_joining` date,
    `base_location` VARCHAR(45) NOT NULL,
	`current_location` VARCHAR(45) NOT NULL,
	`primary_skills` VARCHAR(45) NOT NULL,
	`secondary_skills` VARCHAR(45) NOT NULL,
	`exprience` VARCHAR(3) NOT NULL,
    `mobile_no` LONG NOT NULL,
    `irm` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`employee_id`)
);
CREATE TABLE `user` (
`user_id` INT NOT NULL auto_increment ,
`user_name`  VARCHAR(50) NOT NULL,
`email` VARCHAR(45) NOT NULL,
`password`  VARCHAR(80) NOT NULL,
PRIMARY KEY (`user_id`)

);
CREATE TABLE `skills` (
`skill_id` INT NOT NULL   auto_increment ,
`skill_name`  VARCHAR(50) NOT NULL,
`key_skill`  VARCHAR(80) NOT NULL,
PRIMARY KEY (`skill_id`)
);

CREATE TABLE `employee_evaluation` (
    `emp_evaluation_id` INT NOT NULL auto_increment,
	`evaluation_date` date,
	`evaluation_number` INT NOT NULL ,
	`evaluated_by` VARCHAR(45) NOT NULL,
	`overall_rating` double NOT NULL,
	`remarks` VARCHAR(45) NOT NULL,
    PRIMARY KEY (  `emp_evaluation_id`),
	`yash_emp_Id` INT,FOREIGN KEY(`yash_emp_Id`) REFERENCES  `resource_details` (`yash_emp_Id`)
);
CREATE TABLE `rating_master` (
    `rating_id` int not null auto_increment,
    PRIMARY KEY (`rating_id`),
    `rating_label` varchar(30)
);
CREATE TABLE `employee_skill_rating` (
    `id` int not null auto_increment,
    `emp_evaluation_id` INT,FOREIGN KEY(`emp_evaluation_id`) REFERENCES  `ems_prod`.`employee_evaluation`(`emp_evaluation_id`),
    `skill_id` INT,FOREIGN KEY(`skill_id`) REFERENCES  `ems_prod`.`skills`(`skill_id`) ,  
    `rating_id` int,FOREIGN KEY(`rating_id`) REFERENCES  `ems_prod`.`rating_master`(`rating_id`),
     PRIMARY KEY (`id`)
);

CREATE TABLE `feedback_details` (
`feedback_id` int not null auto_increment,
`project_name` varchar(55),
`client_name` varchar(55),
`project_manager` varchar(55),
`reason_for_release` varchar(55),
`technical_knowledge_rating` long not null,
`work_quality_rating` long not null,
`communication_rating` long  not null,
`team_playing_rating` long NOT NULL,
`overall_rating` long NOT NULL,
`remarks` VARCHAR(45) NOT NULL,
`yash_emp_Id` INT ,FOREIGN KEY(`yash_emp_Id`) REFERENCES  
`ems_prod`.`resource_details`(`yash_emp_Id`),
primary key (`feedback_id`)
);

use ems_prod;
 SELECT * FROM ems_prod.rating_master
LIMIT 0, 1000;

INSERT INTO `rating_master` (`rating_id`,`rating_label`) VALUES (1,'Basic');
INSERT INTO `rating_master` (`rating_id`,`rating_label`) VALUES (2,'Intermidiate');
INSERT INTO `rating_master` (`rating_id`,`rating_label`) VALUES (3,'Expert');
INSERT INTO `rating_master` (`rating_id`,`rating_label`) VALUES (4,'Specialist');

SELECT * FROM ems_prod.skills
LIMIT 0, 1000;
INSERT INTO skills (`skill_id`,`skill_name`,`key_skill`) VALUES (1,'Java','java');
INSERT INTO skills (`skill_id`,`skill_name`,`key_skill`) VALUES (2,'Angular','Angular');
INSERT INTO skills (`skill_id`,`skill_name`,`key_skill`) VALUES (3,'SpringBoot','boot');
INSERT INTO skills (`skill_id`,`skill_name`,`key_skill`) VALUES (4,'Hibernate','hibernat');