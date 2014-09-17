SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
-- -----------------------------------------------------
-- Schema tmdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tmdb` DEFAULT CHARACTER SET latin1 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`tier`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`tier` ;

CREATE TABLE IF NOT EXISTS `mydb`.`tier` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`widget`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`widget` ;

CREATE TABLE IF NOT EXISTS `mydb`.`widget` (
  `id` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `tier_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_widget_tier`
  FOREIGN KEY (`tier_id`)
  REFERENCES `mydb`.`tier` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

CREATE INDEX `fk_widget_tier_idx` ON `mydb`.`widget` (`tier_id` ASC);

USE `tmdb` ;

-- -----------------------------------------------------
-- Table `tmdb`.`company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tmdb`.`company` ;

CREATE TABLE IF NOT EXISTS `tmdb`.`company` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `users_count` INT(11) NULL DEFAULT '0',
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `mid` INT(11) NULL DEFAULT NULL,
  `active` TINYINT(1) NULL DEFAULT NULL,
  `search_feature_enabled` TINYINT(1) NULL DEFAULT NULL,
  `analytics_feature_enabled` TINYINT(1) NULL DEFAULT NULL,
  `currency` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `domain` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `token` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `source` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `source_domain` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL DEFAULT NULL,
  `tier_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_company_tier1`
  FOREIGN KEY (`tier_id`)
  REFERENCES `mydb`.`tier` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci;

CREATE INDEX `fk_company_tier1_idx` ON `tmdb`.`company` (`tier_id` ASC);


-- -----------------------------------------------------
-- Table `tmdb`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tmdb`.`user` ;

CREATE TABLE IF NOT EXISTS `tmdb`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NOT NULL DEFAULT '',
  `encrypted_password` VARCHAR(255) NOT NULL DEFAULT '',
  `reset_password_token` VARCHAR(255) NULL DEFAULT NULL,
  `reset_password_sent_at` DATETIME NULL DEFAULT NULL,
  `remember_created_at` DATETIME NULL DEFAULT NULL,
  `sign_in_count` INT(11) NULL DEFAULT '0',
  `current_sign_in_at` DATETIME NULL DEFAULT NULL,
  `last_sign_in_at` DATETIME NULL DEFAULT NULL,
  `current_sign_in_ip` VARCHAR(255) NULL DEFAULT NULL,
  `last_sign_in_ip` VARCHAR(255) NULL DEFAULT NULL,
  `confirmation_token` VARCHAR(255) NULL DEFAULT NULL,
  `confirmed_at` DATETIME NULL DEFAULT NULL,
  `confirmation_sent_at` DATETIME NULL DEFAULT NULL,
  `unconfirmed_email` VARCHAR(255) NULL DEFAULT NULL,
  `authentication_token` VARCHAR(255) NULL DEFAULT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `website` VARCHAR(255) NULL DEFAULT NULL,
  `phone_number` VARCHAR(255) NULL DEFAULT NULL,
  `company_name` VARCHAR(255) NULL DEFAULT NULL,
  `coupon` VARCHAR(255) NULL DEFAULT NULL,
  `approved` TINYINT(1) NULL DEFAULT '0',
  `superadmin` TINYINT(1) NULL DEFAULT '0',
  `terms_accept` TINYINT(1) NULL DEFAULT '0',
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;

CREATE UNIQUE INDEX `index_users_on_email` ON `tmdb`.`user` (`email` ASC);

CREATE UNIQUE INDEX `index_users_on_reset_password_token` ON `tmdb`.`user` (`reset_password_token` ASC);


-- -----------------------------------------------------
-- Table `tmdb`.`company_has_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tmdb`.`company_has_user` ;

CREATE TABLE IF NOT EXISTS `tmdb`.`company_has_user` (
  `company_id` INT(11) NOT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`company_id`, `user_id`),
  CONSTRAINT `company_has_user_ibfk_1`
  FOREIGN KEY (`company_id`)
  REFERENCES `tmdb`.`company` (`id`),
  CONSTRAINT `company_has_user_ibfk_2`
  FOREIGN KEY (`user_id`)
  REFERENCES `tmdb`.`user` (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;

CREATE INDEX `user_id` ON `tmdb`.`company_has_user` (`user_id` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
