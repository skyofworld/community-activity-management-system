DROP DATABASE IF EXISTS `cams`;

CREATE DATABASE `cams`;

USE `cams`;

CREATE TABLE IF NOT EXISTS `admin`(
	`id` INT UNSIGNED AUTO_INCREMENT,
	`name` VARCHAR(32) NOT NULL,
	`status` INT DEFAULT 0
		COMMENT '-1：禁用账号
				 0：普通权限',
	`role` INT UNSIGNED NOT NULL
		COMMENT '1：管理员
				 2：发起方
				 3：导师
				 4：居民',
	`gender` TINYINT DEFAULT 0
		COMMENT '0：未知
				 1：男
				 2：女',
	`openid` VARCHAR(32) UNIQUE,
    `identity_card` CHAR(18) UNIQUE,
	`phone` VARCHAR(16) UNIQUE,
	`email` VARCHAR(32) UNIQUE,
	`img_path` VARCHAR(128),
	`salt` VARCHAR(64),
    `password` VARCHAR(64),
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `sponsor`(
	`id` INT UNSIGNED AUTO_INCREMENT,
    `name` VARCHAR(32) NOT NULL,
    `status` INT DEFAULT 0
		COMMENT '-1：禁用账号
				 0：普通权限',
	`role` INT UNSIGNED NOT NULL
		COMMENT '1：管理员
				 2：发起方
				 3：导师
				 4：居民',
	`gender` TINYINT DEFAULT 0
		COMMENT '0：未知
				 1：男
				 2：女',
	`openid` VARCHAR(32) UNIQUE,
    `identity_card` CHAR(18) UNIQUE,
	`phone` VARCHAR(16) UNIQUE,
	`email` VARCHAR(32) UNIQUE,
    `intro` VARCHAR(128),
	`img_path` VARCHAR(128),
	`salt` VARCHAR(64),
    `password` VARCHAR(64),
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `activity_type`(
	`id` INT UNSIGNED AUTO_INCREMENT,
    `name` VARCHAR(32) NOT NULL UNIQUE,
    `credit` INT UNSIGNED NOT NULL,
    `intro` VARCHAR(128),
	`img_path` VARCHAR(128),
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `resident`(
	`id` INT UNSIGNED AUTO_INCREMENT,
    `name` VARCHAR(32) NOT NULL,
    `status` INT DEFAULT 0
		COMMENT '-1：禁用账号
				 0：普通权限',
    `credit` INT UNSIGNED DEFAULT 0,
    `role` INT UNSIGNED NOT NULL
		COMMENT '1：管理员
				 2：发起方
				 3：导师
				 4：居民',
    `gender` TINYINT DEFAULT 0
		COMMENT '0：未知
				 1：男
                 2：女',
	`openid` VARCHAR(32) UNIQUE,
    `identity_card` CHAR(18) UNIQUE,
	`phone` VARCHAR(16) UNIQUE,
	`email` VARCHAR(32) UNIQUE,
    `intro` VARCHAR(128),
	`img_path` VARCHAR(128),
	`salt` VARCHAR(64),
    `password` VARCHAR(64),
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `coach`(
	`id` INT UNSIGNED AUTO_INCREMENT,
    `name` VARCHAR(32) NOT NULL,
    `status` INT DEFAULT 0
		COMMENT '-1：禁用账号
				 0：普通权限',
	`role` INT UNSIGNED NOT NULL
		COMMENT '1：管理员
				 2：发起方
				 3：导师
				 4：居民',
    `type` INT UNSIGNED,
    `credit` INT UNSIGNED DEFAULT 0,
    `gender` TINYINT DEFAULT 0
		COMMENT '0：未知
				 1：男
                 2：女',
	`openid` VARCHAR(32) UNIQUE,
    `identity_card` CHAR(18) UNIQUE,
	`phone` VARCHAR(16) UNIQUE,
	`email` VARCHAR(32) UNIQUE,
    `intro` VARCHAR(128),
	`img_path` VARCHAR(128),
	`salt` VARCHAR(64),
    `password` VARCHAR(64),
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`),
    FOREIGN KEY (`type`) references `activity_type`(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `place`(
	`id` INT UNSIGNED AUTO_INCREMENT,
    `address` VARCHAR(64) NOT NULL UNIQUE,
    `intro` VARCHAR(128),
	`img_path` VARCHAR(128),
	`number` INT UNSIGNED DEFAULT 0,
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `activity`(
	`id` INT UNSIGNED AUTO_INCREMENT,
    `name` VARCHAR(32) NOT NULL,
    `status` INT DEFAULT 0
		COMMENT '0：待审核
				 1：审核未通过
                 2：审核通过
                 20：审核通过，未开始，
                 21：审核通过，进行中，
                 22：审核通过，已结束',
    `number` INT UNSIGNED DEFAULT 0
		COMMENT '0: 表示无人数要求',
    `start_time` DATETIME NOT NULL,
    `end_time` DATETIME NOT NULL,
    `intro` VARCHAR(128),
    `type` INT UNSIGNED,
    `sponsor` INT UNSIGNED NOT NULL,
    `coach` INT UNSIGNED,
    `place` INT UNSIGNED NOT NULL,
	`img_path` VARCHAR(128),
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`),
    FOREIGN KEY (`type`) references `activity_type`(`id`),
    FOREIGN KEY (`sponsor`) references `sponsor`(`id`),
    FOREIGN KEY (`coach`) references `coach`(`id`),
    FOREIGN KEY (`place`) references `place`(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `activity_resident`(
	`id` INT UNSIGNED AUTO_INCREMENT,
    `activity` INT UNSIGNED NOT NULL,
    `resident` INT UNSIGNED NOT NULL,
    `status` INT DEFAULT 1
		COMMENT '0：取消报名
				 1：已报名
				 11：已报名，已签到
                 10：已报名，未签到',
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`activity`) references `activity`(`id`),
    FOREIGN KEY (`resident`) references `resident`(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `message`(
	`id` INT UNSIGNED AUTO_INCREMENT,
    `author` INT UNSIGNED NOT NULL,
    `content` LONGTEXT NOT NULL,
	`update_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;