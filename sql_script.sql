create database if not exists api_database;
use api_database;
CREATE TABLE `record_entity` (
  `PrimaryKey` varchar(255) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Description` varchar(10000) DEFAULT NULL,
  `UpdatedTimestamp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PrimaryKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
