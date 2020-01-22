--DB Details
--User: users
--Password: users
--Database/Schema: users_schema


create user 'users'@'%' identified by 'users'; 

create database users_schema;

grant all on users_schema.* to users@'%';

CREATE TABLE `user`
(
  `id` integer PRIMARY KEY,
  `username` varchar(255),
  `display_name` varchar(255),
  `password` varchar(255),
  `security` varchar(255),
  `encryption` varchar(255),
  `login_attempt` integer,
  `fail_attempt` integer,
  `last_login` datetime,
  `mail_sent` enum('Y','N'),
  `sms_sent` enum('Y','N'),
  `status` enum('A','I'),
  `created_by` int,
  `created_on` datetime,
  `when_modified` datetime,
  `version` int,
  `group_id` int
);

CREATE TABLE `profile`
(
  `id` integer PRIMARY KEY,
  `user_id` integer,
  `first_name` varchar(255),
  `last_name` varchar(255),
  `date_of_birth` date,
  `user_type` varchar(255),
  `gender` enum('M','F'),
  `marital_status` enum('S','M'),
  `mobile_number` varchar(255),
  `alt_mobile_number` varchar(255),
  `email_id` varchar(255),
  `photo_id` varchar(255),
  `created_by` int,
  `created_on` datetime,
  `when_modified` datetime,
  `version` int,
  `group_id` int
);

CREATE TABLE `identity`
(
  `id` int PRIMARY KEY,
  `user_id` int,
  `pan_id` varchar(255),
  `aadhar_id` varchar(255),
  `voter_id` varchar(255),
  `passport_id` varchar(255),
  `driving_licence_id` varchar(255),
  `created_by` int,
  `created_on` datetime,
  `when_modified` datetime,
  `version` int,
  `group_id` int
);

CREATE TABLE `address`
(
  `id` int PRIMARY KEY,
  `user_id` int,
  `houseNo` varchar(255),
  `address_line1` varchar(255),
  `address_line2` varchar(255),
  `city` varchar(255),
  `state` varchar(255),
  `country` varchar(255),
  `pin_code` varchar(255),
  `type` varchar(255),
  `landmark` varchar(255),
  `created_by` int,
  `created_on` datetime,
  `when_modified` datetime,
  `version` int,
  `group_id` int
);

CREATE TABLE `role`
(
  `id` integer PRIMARY KEY,
  `rolename` varchar(255),
  `status` enum('Y','N'),
  `created_by` int,
  `created_on` datetime,
  `when_modified` datetime,
  `version` int,
  `group_id` int
);

CREATE TABLE `module`
(
  `id` integer PRIMARY KEY,
  `name` varchar(255),
  `description` varchar(255),
  `status` enum('Y','N'),
  `created_by` int,
  `created_on` datetime,
  `when_modified` datetime,
  `version` int,
  `group_id` int
);

CREATE TABLE `user_role`
(
  `id` integer PRIMARY KEY,
  `user_id` integer,
  `role_id` integer,
  `status` enum('A','I'),
  `created_by` int,
  `created_on` datetime,
  `when_modified` datetime,
  `version` int,
  `group_id` int
);

CREATE TABLE `role_module`
(
  `id` integer PRIMARY KEY,
  `role_id` integer,
  `module_id` integer,
  `status` enum('Y','N'),
  `created_by` int,
  `created_on` datetime,
  `when_modified` datetime,
  `version` int,
  `group_id` int
);

ALTER TABLE `profile` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `address` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `role_module` ADD FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

ALTER TABLE `role_module` ADD FOREIGN KEY (`module_id`) REFERENCES `module` (`id`);

ALTER TABLE `identity` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `user_role` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `user_role` ADD FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

