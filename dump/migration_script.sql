-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: tickets
-- Source Schemata: tickets
-- Created: Sun Mar 24 15:56:28 2019
-- Workbench Version: 8.0.15
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema tickets
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `tickets` ;
CREATE SCHEMA IF NOT EXISTS `tickets` ;

-- ----------------------------------------------------------------------------
-- Table tickets.events
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `tickets`.`events` (
  `event_id` INT(11) NOT NULL AUTO_INCREMENT,
  `eventName` VARCHAR(45) NULL DEFAULT NULL,
  `base_price` DOUBLE NULL DEFAULT NULL,
  `eventRating` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`event_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table tickets.users
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `tickets`.`users` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
SET FOREIGN_KEY_CHECKS = 1;
