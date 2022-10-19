SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = FALSE;


DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS `customer`;
DROP TABLE IF EXISTS `customer_type`;
DROP TABLE IF EXISTS `country`;
DROP TABLE IF EXISTS `vehicle`;
DROP TABLE IF EXISTS `vehicle_type`;
DROP TABLE IF EXISTS `brand`;


-- ----------------------------
-- Table structure for brand
-- ----------------------------
CREATE TABLE `brand`
(
    `brand_id`   int(11)      NOT NULL AUTO_INCREMENT,
    `brand_name` varchar(255) NOT NULL,
    PRIMARY KEY (`brand_id`) USING BTREE,
    UNIQUE INDEX (`brand_name`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of brand
-- ----------------------------
INSERT INTO `brand`
VALUES (1, 'BMW');
INSERT INTO `brand`
VALUES (2, 'Mercedes-Benz');
INSERT INTO `brand`
VALUES (3, 'Audi');
INSERT INTO `brand`
VALUES (4, 'Xiaomi');


-- ----------------------------
-- Table structure for vehicle_type
-- ----------------------------
CREATE TABLE `vehicle_type`
(
    `vehicle_type_id`   int(11)      NOT NULL AUTO_INCREMENT,
    `vehicle_type_name` varchar(255) NOT NULL,
    PRIMARY KEY (`vehicle_type_id`) USING BTREE,
    UNIQUE INDEX (`vehicle_type_name`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vehicle_type
-- ----------------------------
INSERT INTO vehicle_type
VALUES (1, 'car');
INSERT INTO vehicle_type
VALUES (2, 'scooter');


-- ----------------------------
-- Table structure for vehicle
-- ----------------------------
CREATE TABLE `vehicle`
(
    `vehicle_id`     int(11)        NOT NULL AUTO_INCREMENT,
    `brand_id`       int(11)        NOT NULL,
    `vehicle_type_id` int(11)        NOT NULL,
    `prise`         decimal(15, 4) NOT NULL,
    `storage_time`   datetime(0)    NOT NULL,
    `sale_status`    boolean DEFAULT FALSE,
    PRIMARY KEY (`vehicle_id`) USING BTREE,
    FOREIGN KEY (`brand_id`) REFERENCES brand (`brand_id`) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (`vehicle_type_id`) REFERENCES vehicle_type (`vehicle_type_id`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vehicle
-- ----------------------------
INSERT INTO `vehicle`
VALUES (1, 1, 1, 88888.8, '2020-12-08', TRUE);
INSERT INTO `vehicle`
VALUES (2, 2, 1, 88889.9, '2020-12-09', TRUE);
INSERT INTO `vehicle`
VALUES (3, 3, 1, 99999.9, '2021-01-01', FALSE);
INSERT INTO `vehicle`
VALUES (4, 4, 2, 300, '2022-01-01', FALSE);


-- ----------------------------
-- Table structure for customer_type
-- ----------------------------
CREATE TABLE `customer_type`
(
    `customer_type_id`   int(11)      NOT NULL AUTO_INCREMENT,
    `customer_type_name` varchar(255) NOT NULL,
    PRIMARY KEY (`customer_type_id`) USING BTREE,
    UNIQUE INDEX (`customer_type_name`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_type
-- ----------------------------
INSERT INTO `customer_type`
VALUES (1, 'individual');
INSERT INTO `customer_type`
VALUES (2, 'small company');
INSERT INTO `customer_type`
VALUES (3, 'large company');


-- ----------------------------
-- Table structure for country
-- ----------------------------
CREATE TABLE `country`
(
    `country_id`   int(11)        NOT NULL AUTO_INCREMENT,
    `country_name` varchar(255)   NOT NULL,
    `tax_rate`     decimal(15, 4) NOT NULL,
    PRIMARY KEY (`country_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country`
VALUES (1, 'United States', 0.15);
INSERT INTO `country`
VALUES (2, 'China', 0.13);
INSERT INTO `country`
VALUES (3, 'France', 0.20);


-- ----------------------------
-- Table structure for customer
-- ----------------------------
CREATE TABLE `customer`
(
    `customer_id` int(11)      NOT NULL AUTO_INCREMENT,
    `country_id`  int(11)      NOT NULL,
    `user_name`   varchar(255) NOT NULL,
    `password`   varchar(255) NOT NULL,
    `first_name`  varchar(255) NOT NULL,
    `last_name`   varchar(255) NOT NULL,
    `email`      varchar(255) NOT NULL,
    `address`    varchar(255) NOT NULL,
    PRIMARY KEY (`customer_id`) USING BTREE,
    UNIQUE INDEX (`user_name`) USING BTREE,
    FOREIGN KEY (`country_id`) REFERENCES country (`country_id`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer`
VALUES (1, 1, 'userA', '11111111', 'Naura', 'Mzurel', 'john@gmail.com', 'asd');
INSERT INTO `customer`
VALUES (2, 3, 'userB', '11111111', 'Alpha', 'Teko', 'alpha@gamil.com', 'asd');


-- ----------------------------
-- Table structure for order
-- ----------------------------
CREATE TABLE `order`
(
    `order_id`            int(11)        NOT NULL AUTO_INCREMENT,
    `customer_id`         int(11)        NOT NULL,
    `vehicle_id`          int(11)        NOT NULL,
    `order_create_date`  datetime(0)    NOT NULL,
    `order_status`       varchar(1)     NOT NULL COMMENT 'status of the order(0: in progress, 1: validated, 2: delivered)',
    `payment-type`       varchar(1)     NOT NULL COMMENT 'payment type of the order(0: cash, 1: credit)',
    PRIMARY KEY (`order_id`) USING BTREE,
    FOREIGN KEY (`customer_id`) REFERENCES customer (`customer_id`) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (`vehicle_id`) REFERENCES vehicle (`vehicle_id`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order`
VALUES (1, 1, 1, '2021-01-08', '0', '0');
INSERT INTO `order`
VALUES (2, 2, 3, '2022-01-09', '1', '1');
