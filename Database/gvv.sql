SET NAMES utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand`
(
    `brand_id`   int(11) NOT NULL AUTO_INCREMENT,
    `brand_name` varchar(255) NOT NULL,
    PRIMARY KEY (`brand_id`) USING BTREE,
    UNIQUE INDEX (`brand_name`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`
(
    `type_id`   int(11) NOT NULL AUTO_INCREMENT,
    `type_name` varchar(255) NOT NULL,
    PRIMARY KEY (`type_id`) USING BTREE,
    UNIQUE INDEX (`type_name`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for vehicle
-- ----------------------------
DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle`
(
    `vehicle_id`           int(11) NOT NULL AUTO_INCREMENT,
    `vehicle_brand`        int(11) NOT NULL,
    `vehicle_type`         int(11) NOT NULL,
    `vehicle_cost`         decimal(10, 2) NOT NULL,
    `vehicle_storage_time` datetime(0) NOT NULL,
    `vehicle_sale_status`  boolean DEFAULT FALSE,
    PRIMARY KEY (`vehicle_id`) USING BTREE,
    FOREIGN KEY (`vehicle_brand`) REFERENCES brand (`brand_id`) ON UPDATE CASCADE,
    FOREIGN KEY (`vehicle_type`) REFERENCES type (`type_id`) ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`
(
    `customer_id`      int(11) NOT NULL AUTO_INCREMENT,
    `customer_name`    varchar(255) NOT NULL,
    `customer_email`   varchar(255) NOT NULL,
    `customer_address` varchar(255) NOT NULL,
    PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country`
(
    `country_id`   int(11) NOT NULL AUTO_INCREMENT,
    `country_name` varchar(255) NOT NULL,
    `tax_rate`     double       NOT NULL,
    PRIMARY KEY (`country_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`
(
    `order_id`           int(11) NOT NULL AUTO_INCREMENT,
    `customer_id`        int(11) NOT NULL,
    `vehicle_id`         int(11) NOT NULL,
    `country_id`         int(11) NOT NULL,
    `order_create_date`  datetime(0) NOT NULL,
    `order_status`       varchar(1)     NOT NULL COMMENT 'status of the order(0: in progress, 1: validated, 2: delivered)',
    `payment_type`       varchar(1)     NOT NULL COMMENT 'payment type of the order(0: cash, 1: credit)',
    `sale_price`         decimal(10, 2) NOT NULL,
    `tax_payment_amount` decimal(10, 2) NOT NULL,
    PRIMARY KEY (`order_id`) USING BTREE,
    FOREIGN KEY (`customer_id`) REFERENCES customer (`customer_id`) ON UPDATE CASCADE,
    FOREIGN KEY (`vehicle_id`) REFERENCES vehicle (`vehicle_id`) ON UPDATE CASCADE,
    FOREIGN KEY (`country_id`) REFERENCES country (`country_id`) ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;
