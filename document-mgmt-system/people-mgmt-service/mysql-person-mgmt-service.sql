CREATE TABLE `person` (
  `id` int PRIMARY KEY,
  `first_name` varchar(255),
  `last_name` varchar(255),
  `father_name` varchar(255),
  `date_of_birth` date,
  `marital_status` enum,
  `gender` varchar(255),
  `mobile_number` varchar(255),
  `alt_mobile_number` varchar(255),
  `email_id` varchar(255),
  `photo_id` varchar(255),
  `status` enum,
  `created_by` int,
  `created_on` datetime,
  `when_modified` datetime,
  `version` int,
  `group_id` int
);

CREATE TABLE `member` (
  `id` int PRIMARY KEY,
  `joining_date` date,
  `member_type` varchar(255),
  `member_validity` date,
  `user_id` int
);

CREATE TABLE `devotee` (
  `id` int PRIMARY KEY,
  `devotee_type` enum
);

CREATE TABLE `sevadar` (
  `id` int PRIMARY KEY,
  `joining_date` date,
  `sevaday` varchar(255)
);

CREATE TABLE `identity` (
  `id` int PRIMARY KEY,
  `person_id` int,
  `document_type` enum,
  `document_number` varchar(255),
  `document_name` varchar(255),
  `document_path` varchar(255),
  `document_details` varchar(255),
  `status` enum,
  `created_by` int,
  `created_on` datetime,
  `when_modified` datetime,
  `version` int,
  `group_id` int
);

CREATE TABLE `address` (
  `id` int PRIMARY KEY,
  `person_id` int,
  `address_type` enum,
  `address_line` varchar(255),
  `city` varchar(255),
  `state` varchar(255),
  `country` varchar(255),
  `pin_zip_code` varchar(255),
  `type` varchar(255),
  `landmark` varchar(255),
  `status` enum,
  `created_by` int,
  `created_on` datetime,
  `when_modified` datetime,
  `version` int,
  `group_id` int
);

ALTER TABLE `member` ADD FOREIGN KEY (`id`) REFERENCES `person` (`id`);

ALTER TABLE `sevadar` ADD FOREIGN KEY (`id`) REFERENCES `person` (`id`);

ALTER TABLE `devotee` ADD FOREIGN KEY (`id`) REFERENCES `person` (`id`);

ALTER TABLE `address` ADD FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `identity` ADD FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);
