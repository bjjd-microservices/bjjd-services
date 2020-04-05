CREATE TABLE `expense` (
  `id` int PRIMARY KEY,
  `expense_date` date,
  `description` longtext,
  `amount` decimal(10,2),
  `paid_to` varchar(255),
  `approved_by` int,
  `project_id` varchar(255),
  `remarks` varchar(255),
  `status` enum,
  `created_by` int,
  `created_on` datetime,
  `when_modified` datetime,
  `version` int,
  `group_id` int
);

CREATE TABLE `donation` (
  `id` int PRIMARY KEY,
  `donation_date` date,
  `project_id` varchar(255),
  `amount` int,
  `donor_type` enum,
  `donor_id` int,
  `received_by` int,
  `description` varchar(255),
  `remarks` varchar(255),
  `status` enum,
  `created_by` int,
  `created_on` datetime,
  `when_modified` datetime,
  `version` int,
  `group_id` int
);
