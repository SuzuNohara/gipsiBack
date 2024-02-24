-- -----------------------------------------------------
-- Schema twilight
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `twilight` DEFAULT CHARACTER SET utf8 ;

-- -----------------------------------------------------
-- Schema twilight
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `twilight` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `twilight` ;

-- -----------------------------------------------------
-- Table `twilight`.`workout`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `twilight`.`workout` (
  `id` INT NOT NULL,
  `date` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `twilight`.`excersice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `twilight`.`excersice` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `value` INT NOT NULL,
  `id_workout` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_workout_idx` (`id_workout` ASC) VISIBLE,
  CONSTRAINT `id_workout`
    FOREIGN KEY (`id_workout`)
    REFERENCES `twilight`.`workout` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `twilight`.`diary`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `twilight`.`diary` (
  `id` INT NOT NULL,
  `start` TIME NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `end` TIME NOT NULL,
  `color` VARCHAR(7) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `twilight`.`activity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `twilight`.`activity` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `content` VARCHAR(200) NULL,
  `done` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `twilight`.`diary_workout`
-- -----------------------------------------------------
 CREATE TABLE IF NOT EXISTS `twilight`.`diary_workout` (
    `id_workout` INT NOT NULL,
    `id_diary` INT NOT NULL,
    PRIMARY KEY (`id_workout`, `id_diary`),
    INDEX `id_diary_idx` (`id_diary` ASC) VISIBLE,
    CONSTRAINT `id_workoutc`
    FOREIGN KEY (`id_workout`)
    REFERENCES `twilight`.`workout` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `id_diaryc`
    FOREIGN KEY (`id_diary`)
    REFERENCES `twilight`.`diary` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB


-- -----------------------------------------------------
-- Table `twilight`.`diary_activity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `twilight`.`diary_activity` (
  `id_activity` INT NOT NULL,
  `id_diary` INT NOT NULL,
  PRIMARY KEY (`id_activity`, `id_diary`),
  INDEX `id_diary_idx` (`id_diary` ASC) VISIBLE,
  CONSTRAINT `id_activity`
    FOREIGN KEY (`id_activity`)
    REFERENCES `twilight`.` activity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_diary`
    FOREIGN KEY (`id_diary`)
    REFERENCES `twilight`.`diary` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `twilight` ;

-- -----------------------------------------------------
-- Table `twilight`.`note_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `twilight`.`note_type` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `color` VARCHAR(7) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `twilight`.`note`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `twilight`.`note` (
  `id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `content` VARCHAR(45) NOT NULL,
  `id_type` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_type_idx` (`id_type` ASC) VISIBLE,
  CONSTRAINT `id_type`
    FOREIGN KEY (`id_type`)
    REFERENCES `twilight`.`note_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `twilight`.`tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `twilight`.`tag` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `color` VARCHAR(7) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `twilight`.`note_tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `twilight`.`note_tag` (
  `id_note` INT NOT NULL,
  `id_tag` INT NOT NULL,
  PRIMARY KEY (`id_note`, `id_tag`),
  INDEX `id_tag_idx` (`id_tag` ASC) VISIBLE,
  CONSTRAINT `id_note`
    FOREIGN KEY (`id_note`)
    REFERENCES `twilight`.`note` (`id`),
  CONSTRAINT `id_tag`
    FOREIGN KEY (`id_tag`)
    REFERENCES `twilight`.`tag` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
