-- MySQL Script generated by MySQL Workbench
-- Sun Mar 24 14:43:07 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tickets
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tickets` ;

-- -----------------------------------------------------
-- Schema tickets
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tickets` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `tickets` ;

-- -----------------------------------------------------
-- Table `event_table`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event_table` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `event_table` (
  `event_id` INT NOT NULL AUTO_INCREMENT,
  `eventName` VARCHAR(45) NULL,
  `base_price` DOUBLE NULL,
  `eventRating` INT NULL)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `users` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` INT NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `email_UNIQUE` ON `users` (`email` ASC);

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;