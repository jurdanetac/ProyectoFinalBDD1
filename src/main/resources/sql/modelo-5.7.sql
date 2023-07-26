-- MySQL Script generated by MySQL Workbench
-- Mon Jul 24 12:14:03 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema proyecto_final
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema proyecto_final
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `proyecto_final` DEFAULT CHARACTER SET utf8 ;
USE `proyecto_final` ;

-- -----------------------------------------------------
-- Table `proyecto_final`.`territorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`territorio` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `ubicacion` VARCHAR(35) NOT NULL COMMENT 'https://stackoverflow.com/a/1196429\n\nThrooze comment.',
  `superficie` FLOAT NOT NULL,
  `nro_habitantes` INT(10) NOT NULL,
  `clima` VARCHAR(45) NOT NULL,
  `territorio_capital_id` INT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_territorio_UNIQUE` (`id` ASC),
  INDEX `fk_territorio_territorio1_idx` (`territorio_capital_id` ASC),
  UNIQUE INDEX `territorio_capital_id_UNIQUE` (`territorio_capital_id` ASC),
  CONSTRAINT `fk_territorio_territorio1`
    FOREIGN KEY (`territorio_capital_id`)
    REFERENCES `proyecto_final`.`territorio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto_final`.`actividad_economica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`actividad_economica` (
  `nombre` VARCHAR(45) NOT NULL,
  `tipo_recurso` VARCHAR(15) NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`nombre`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto_final`.`ser_vivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`ser_vivo` (
  `nombre_comun` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `estado_de_conservacion` VARCHAR(2) NOT NULL,
  `reino` VARCHAR(45) NOT NULL,
  `filo_o_division` VARCHAR(45) NOT NULL,
  `clase` VARCHAR(45) NOT NULL,
  `orden` VARCHAR(45) NOT NULL,
  `familia` VARCHAR(45) NOT NULL,
  `genero` VARCHAR(45) NOT NULL,
  `especie` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`genero`, `especie`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto_final`.`cuerpo_de_agua`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`cuerpo_de_agua` (
  `nombre` VARCHAR(45) NOT NULL,
  `ubicacion` VARCHAR(30) NOT NULL,
  `area` FLOAT NULL,
  `extension` FLOAT NULL,
  `profundidad` FLOAT NULL,
  PRIMARY KEY (`nombre`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto_final`.`territorio_tiene_ser_vivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`territorio_tiene_ser_vivo` (
  `territorio_id` INT UNSIGNED NOT NULL,
  `ser_vivo_genero` VARCHAR(45) NOT NULL,
  `ser_vivo_especie` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`territorio_id`, `ser_vivo_genero`, `ser_vivo_especie`),
  INDEX `fk_territorio_has_ser_vivo_ser_vivo1_idx` (`ser_vivo_genero` ASC, `ser_vivo_especie` ASC),
  INDEX `fk_territorio_has_ser_vivo_territorio1_idx` (`territorio_id` ASC),
  CONSTRAINT `fk_territorio_has_ser_vivo_territorio1`
    FOREIGN KEY (`territorio_id`)
    REFERENCES `proyecto_final`.`territorio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_territorio_has_ser_vivo_ser_vivo1`
    FOREIGN KEY (`ser_vivo_genero` , `ser_vivo_especie`)
    REFERENCES `proyecto_final`.`ser_vivo` (`genero` , `especie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto_final`.`simbolo_patrio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`simbolo_patrio` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NULL,
  `territorio_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_simbolo_patrio_territorio1_idx` (`territorio_id` ASC),
  CONSTRAINT `fk_simbolo_patrio_territorio1`
    FOREIGN KEY (`territorio_id`)
    REFERENCES `proyecto_final`.`territorio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto_final`.`territorio_linda_con_territorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`territorio_linda_con_territorio` (
  `territorio_id` INT UNSIGNED NOT NULL,
  `territorio_id1` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`territorio_id`, `territorio_id1`),
  INDEX `fk_territorio_has_territorio_territorio2_idx` (`territorio_id1` ASC),
  INDEX `fk_territorio_has_territorio_territorio1_idx` (`territorio_id` ASC),
  CONSTRAINT `fk_territorio_has_territorio_territorio1`
    FOREIGN KEY (`territorio_id`)
    REFERENCES `proyecto_final`.`territorio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_territorio_has_territorio_territorio2`
    FOREIGN KEY (`territorio_id1`)
    REFERENCES `proyecto_final`.`territorio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto_final`.`territorio_subdivide_en_territorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`territorio_subdivide_en_territorio` (
  `territorio_id` INT UNSIGNED NOT NULL,
  `territorio_id1` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`territorio_id`, `territorio_id1`),
  INDEX `fk_territorio_has_territorio_territorio4_idx` (`territorio_id1` ASC),
  INDEX `fk_territorio_has_territorio_territorio3_idx` (`territorio_id` ASC),
  CONSTRAINT `fk_territorio_has_territorio_territorio3`
    FOREIGN KEY (`territorio_id`)
    REFERENCES `proyecto_final`.`territorio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_territorio_has_territorio_territorio4`
    FOREIGN KEY (`territorio_id1`)
    REFERENCES `proyecto_final`.`territorio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto_final`.`relieve`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`relieve` (
  `tipo` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  UNIQUE INDEX `tipo_UNIQUE` (`tipo` ASC),
  PRIMARY KEY (`tipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto_final`.`idioma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`idioma` (
  `nombre` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`nombre`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto_final`.`gentilicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`gentilicio` (
  `nombre` VARCHAR(30) NOT NULL,
  `territorio_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`nombre`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC),
  INDEX `fk_gentilicio_territorio1_idx` (`territorio_id` ASC),
  CONSTRAINT `fk_gentilicio_territorio1`
    FOREIGN KEY (`territorio_id`)
    REFERENCES `proyecto_final`.`territorio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto_final`.`idioma_es_utilizado_en_territorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`idioma_es_utilizado_en_territorio` (
  `idioma_nombre` VARCHAR(30) NOT NULL,
  `territorio_id` INT UNSIGNED NOT NULL,
  `porcentaje` DECIMAL(5,2) NULL,
  `oficial` TINYINT(1) NULL,
  PRIMARY KEY (`idioma_nombre`, `territorio_id`),
  INDEX `fk_idioma_has_territorio_territorio1_idx` (`territorio_id` ASC),
  INDEX `fk_idioma_has_territorio_idioma1_idx` (`idioma_nombre` ASC),
  CONSTRAINT `fk_idioma_has_territorio_idioma1`
    FOREIGN KEY (`idioma_nombre`)
    REFERENCES `proyecto_final`.`idioma` (`nombre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idioma_has_territorio_territorio1`
    FOREIGN KEY (`territorio_id`)
    REFERENCES `proyecto_final`.`territorio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto_final`.`territorio_tiene_cuerpo_de_agua`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`territorio_tiene_cuerpo_de_agua` (
  `territorio_id` INT UNSIGNED NOT NULL,
  `cuerpo_de_agua_nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`territorio_id`, `cuerpo_de_agua_nombre`),
  INDEX `fk_territorio_has_cuerpo_de_agua_cuerpo_de_agua1_idx` (`cuerpo_de_agua_nombre` ASC),
  INDEX `fk_territorio_has_cuerpo_de_agua_territorio1_idx` (`territorio_id` ASC),
  CONSTRAINT `fk_territorio_has_cuerpo_de_agua_territorio1`
    FOREIGN KEY (`territorio_id`)
    REFERENCES `proyecto_final`.`territorio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_territorio_has_cuerpo_de_agua_cuerpo_de_agua1`
    FOREIGN KEY (`cuerpo_de_agua_nombre`)
    REFERENCES `proyecto_final`.`cuerpo_de_agua` (`nombre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto_final`.`territorio_tiene_relieve`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`territorio_tiene_relieve` (
  `territorio_id` INT UNSIGNED NOT NULL,
  `relieve_tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`territorio_id`, `relieve_tipo`),
  INDEX `fk_territorio_has_relieve_relieve1_idx` (`relieve_tipo` ASC),
  INDEX `fk_territorio_has_relieve_territorio1_idx` (`territorio_id` ASC),
  CONSTRAINT `fk_territorio_has_relieve_territorio1`
    FOREIGN KEY (`territorio_id`)
    REFERENCES `proyecto_final`.`territorio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_territorio_has_relieve_relieve1`
    FOREIGN KEY (`relieve_tipo`)
    REFERENCES `proyecto_final`.`relieve` (`tipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto_final`.`territorio_desarrolla_actividad_economica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyecto_final`.`territorio_desarrolla_actividad_economica` (
  `actividad_economica_nombre` VARCHAR(45) NOT NULL,
  `territorio_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`actividad_economica_nombre`, `territorio_id`),
  INDEX `fk_actividad_economica_has_territorio_territorio1_idx` (`territorio_id` ASC),
  INDEX `fk_actividad_economica_has_territorio_actividad_economica1_idx` (`actividad_economica_nombre` ASC),
  CONSTRAINT `fk_actividad_economica_has_territorio_actividad_economica1`
    FOREIGN KEY (`actividad_economica_nombre`)
    REFERENCES `proyecto_final`.`actividad_economica` (`nombre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actividad_economica_has_territorio_territorio1`
    FOREIGN KEY (`territorio_id`)
    REFERENCES `proyecto_final`.`territorio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;