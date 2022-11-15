SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = FALSE;


DROP TABLE IF EXISTS `t_order`;
DROP TABLE IF EXISTS `t_customer`;
DROP TABLE IF EXISTS `t_customer_type`;
DROP TABLE IF EXISTS `t_country`;
DROP TABLE IF EXISTS `t_vehicle`;
DROP TABLE IF EXISTS `t_vehicle_type`;
DROP TABLE IF EXISTS `t_brand`;


-- ----------------------------
-- Table structure for brand
-- ----------------------------
CREATE TABLE `t_brand`
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
INSERT INTO `t_brand`
VALUES (1, 'BMW');
INSERT INTO `t_brand`
VALUES (2, 'Mercedes-Benz');
INSERT INTO `t_brand`
VALUES (3, 'Audi');
INSERT INTO `t_brand`
VALUES (4, 'Xiaomi');
INSERT INTO `t_brand`
VALUES (5, 'Huawei');


-- ----------------------------
-- Table structure for vehicle_type
-- ----------------------------
CREATE TABLE `t_vehicle_type`
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
INSERT INTO `t_vehicle_type`
VALUES (1, 'car');
INSERT INTO `t_vehicle_type`
VALUES (2, 'scooter');
INSERT INTO `t_vehicle_type`
VALUES (3, 'truck');


-- ----------------------------
-- Table structure for vehicle
-- ----------------------------
CREATE TABLE `t_vehicle`
(
    `vehicle_id`      int(11)        NOT NULL AUTO_INCREMENT,
    `brand_id`        int(11)        NOT NULL,
    `vehicle_type_id` int(11)        NOT NULL,
    `price`           decimal(15, 4) NOT NULL,
    `info`            varchar(255)   NOT NULL,
    `storage_time`    datetime(0)    NOT NULL,
    `sale_status`     boolean DEFAULT FALSE,
    PRIMARY KEY (`vehicle_id`) USING BTREE,
    FOREIGN KEY (`brand_id`) REFERENCES t_brand (`brand_id`) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (`vehicle_type_id`) REFERENCES t_vehicle_type (`vehicle_type_id`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vehicle
-- ----------------------------
INSERT INTO `t_vehicle`
VALUES (1, 1, 1, 79000, '2019 730Li M Sport Package', '2020-12-08', TRUE);
INSERT INTO `t_vehicle`
VALUES (2, 2, 1, 41000, '2019 E 320 L 4MATIC', '2020-12-09', TRUE);
INSERT INTO `t_vehicle`
VALUES (3, 3, 1, 60100, '2020 45 TFSI quattro', '2021-01-01', FALSE);
INSERT INTO `t_vehicle`
VALUES (4, 4, 2, 300, 'xiaomi scooter 3', '2022-01-01', FALSE);
INSERT INTO `t_vehicle`
VALUES (5, 5, 2, 33000, 'AITO M5 Electronic', '2022-07-01', FALSE);
INSERT INTO `t_vehicle`
VALUES (6, 1, 1, 40500 ,'2022 320i M Sport Package', '2022-07-02', FALSE);
INSERT INTO `t_vehicle`
VALUES (7, 1, 1, 42500 ,'2022 325i M Sport Package', '2022-07-02', FALSE);
INSERT INTO `t_vehicle`
VALUES (8, 2, 1, 300000, '2022 G 500', '2022-08-02', FALSE);


-- ----------------------------
-- Table structure for customer_type
-- ----------------------------
CREATE TABLE `t_customer_type`
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
INSERT INTO `t_customer_type`
VALUES (1, 'individual');
INSERT INTO `t_customer_type`
VALUES (2, 'small company');
INSERT INTO `t_customer_type`
VALUES (3, 'large company');


-- ----------------------------
-- Table structure for country
-- ----------------------------
CREATE TABLE `t_country`
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
INSERT INTO `t_country`
VALUES (1, 'United States', 0.15);
INSERT INTO `t_country`
VALUES (2, 'China', 0.13);
INSERT INTO `t_country`
VALUES (3, 'France', 0.20);
INSERT INTO `t_country`
VALUES (4, 'Germany', 0.20);


-- ----------------------------
-- Table structure for customer
-- ----------------------------
CREATE TABLE `t_customer`
(
    `customer_id`      int(11)      NOT NULL AUTO_INCREMENT,
    `customer_type_id` int(11)      NOT NULL,
    `country_id`       int(11)      NOT NULL,
    `user_name`        varchar(255) NOT NULL,
    `password`         varchar(255) NOT NULL,
    `first_name`       varchar(255) NOT NULL,
    `last_name`        varchar(255) NOT NULL,
    `email`            varchar(255) NOT NULL,
    `address`          varchar(255) NOT NULL,
    `phone_number`     varchar(255) ,
    PRIMARY KEY (`customer_id`) USING BTREE,
    UNIQUE INDEX (`user_name`) USING BTREE,
    FOREIGN KEY (`customer_type_id`) REFERENCES t_customer_type (`customer_type_id`) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (`country_id`) REFERENCES t_country (`country_id`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `t_customer`
VALUES (1, 1, 1, 'userA', '11111111', 'Naura', 'Mzurel', 'john@gmail.com', 'asd', '0754322200');
INSERT INTO `t_customer`
VALUES (2, 2, 3, 'userB', '11111111', 'Alpha', 'Teko', 'alpha@gamil.com', 'asd', '0754322201');
INSERT INTO `t_customer`
VALUES (3, 3, 4, 'userC', '11111111', 'Beita', 'Texcko', 'alqsda@gamil.com', 'asd', '0754322202');


-- ----------------------------
-- Table structure for order
-- ----------------------------
CREATE TABLE `t_order`
(
    `order_id`          int(11)     NOT NULL AUTO_INCREMENT,
    `customer_id`       int(11)     NOT NULL,
    `vehicle_id`        int(11)     NOT NULL,
    `order_create_date` datetime(0) NOT NULL,
    `order_status`      varchar(1)  NOT NULL COMMENT 'status of the order(0: in progress, 1: validated, 2: delivered)',
    `payment_type`      varchar(1)  NOT NULL COMMENT 'payment type of the order(0: cash, 1: credit)',
    PRIMARY KEY (`order_id`) USING BTREE,
    FOREIGN KEY (`customer_id`) REFERENCES t_customer (`customer_id`) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (`vehicle_id`) REFERENCES t_vehicle (`vehicle_id`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `t_order`
VALUES (1, 1, 1, '2021-01-08', '0', '0');
INSERT INTO `t_order`
VALUES (2, 2, 3, '2022-01-09', '1', '1');


-- ----------------------------
-- Views of vehicle
-- ----------------------------

CREATE OR REPLACE VIEW `v_vehicle` AS
SELECT vehicle_id, brand_name, vehicle_type_name, price, info, storage_time, sale_status
FROM `t_vehicle`
         NATURAL JOIN `t_vehicle_type`
         NATURAL JOIN `t_brand`;


-- ----------------------------
-- Views of customer
-- ----------------------------

CREATE OR REPLACE VIEW `v_customer` AS
SELECT customer_id,
       customer_type_name,
       country_name,
       tax_rate,
       user_name,
       password,
       first_name,
       last_name,
       email,
       address,
       phone_number
FROM `t_customer`
         NATURAL JOIN `t_customer_type`
         NATURAL JOIN `t_country`;

-- ----------------------------
-- Views of order
-- ----------------------------

CREATE OR REPLACE VIEW `v_order` AS
SELECT order_id,
       order_create_date,
       order_status,
       payment_type,
       brand_name,
       vehicle_type_name,
       price,
       info,
       storage_time,
       sale_status,
       customer_type_name,
       country_name,
       tax_rate,
       customer_id,
       user_name,
       email,
       address,
       phone_number
FROM `t_order`
         NATURAL JOIN `v_customer`
         NATURAL JOIN `v_vehicle`
