SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_account` int NOT NULL COMMENT 'Administrator account',
  `admin_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Administrator password',
  PRIMARY KEY (`admin_account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1001', '123456');
INSERT INTO `admin` VALUES ('1002', '123456');
INSERT INTO `admin` VALUES ('1003', '123456');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `room_id` int NOT NULL AUTO_INCREMENT COMMENT 'Room id',
  `room_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Room Name',
  PRIMARY KEY (`room_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` (`room_name`) VALUES ("gym");
INSERT INTO `room` (`room_name`) VALUES ("yoga");

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `member_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL UNIQUE COMMENT 'Member Account',
  `member_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '123456' COMMENT 'Member Password',
  `member_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Member Name',
  `member_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'Member Gender',
  `member_age` int NULL DEFAULT NULL COMMENT 'Age',
  `member_height` int NULL DEFAULT NULL COMMENT 'Height',
  `member_weight` int NULL DEFAULT NULL COMMENT 'weight',
  `member_phone` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'phone',
  PRIMARY KEY (`member_account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('202009867', '123456', 'Nguyễn', 'female', 24, 182, 60, '0515548482');
INSERT INTO `member` VALUES ('202100788', '123456', 'Thái', 'male', 31, 178, 60, '0131554873');
INSERT INTO `member` VALUES ('202132539', '123456', 'Bình', 'male', 31, 178, 60, '0154875489');
INSERT INTO `member` VALUES ('202186416', '123456', 'Hoàng', 'female', 23, 160, 45, '0124576857');
INSERT INTO `member` VALUES ('202106725', '123456', 'Huy', 'male', 24, 178, 88, '0758784959');
INSERT INTO `member` VALUES ('202183406', '123456', 'Hiếu', 'female', 19, 170, 60, '0786457488');
INSERT INTO `member` VALUES ('202176587', '123456', 'Dương', 'male', 33, 177, 90, '0767546666');
INSERT INTO `member` VALUES ('202156754', '123456', 'Ronaldo', 'male', 36, 166, 67, '0786532448');
INSERT INTO `member` VALUES ('202153468', '123456', 'Messi', 'female', 25, 173, 44, '0786457124');
INSERT INTO `member` VALUES ('202121345', '123456', 'Mbappe', 'male', 28, 160, 40, '0754457488');
INSERT INTO `member` VALUES ('202189776', '123456', 'Haland', 'female', 27, 170, 50, '0986337489');
INSERT INTO `member` VALUES ('202123664', '123456', 'Alice', 'female', 25, 165, 51, '0986457423');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `employee_id` int NOT NULL AUTO_INCREMENT COMMENT 'Employee ID',
  `employee_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'employee name',
  `employee_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'employee gender',
  `employee_age` int NULL DEFAULT NULL COMMENT 'Age',
  `entry_time` date NULL DEFAULT NULL COMMENT 'entry time`',
  `staff` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'staff',
  `employee_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'employee message',
  PRIMARY KEY (`employee_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO employee (`employee_name`, `employee_gender`, `employee_age`, `entry_time`, `staff`, `employee_message`) VALUES ('Coach 1', 'Female', 26, '2016-06-29', 'Fitness coach', 'Bodybuilding champion');
INSERT INTO employee (`employee_name`, `employee_gender`, `employee_age`, `entry_time`, `staff`, `employee_message`) VALUES ('Coach 2', 'Male', 34, '2020-01-06', 'Fitness coach', 'Career coach');
INSERT INTO employee (`employee_name`, `employee_gender`, `employee_age`, `entry_time`, `staff`, `employee_message`) VALUES ('Coach 3', 'Male', 30, '2020-06-06', 'Fitness coach', 'Career coach');
INSERT INTO employee (`employee_name`, `employee_gender`, `employee_age`, `entry_time`, `staff`, `employee_message`) VALUES ('Coach 4', 'Male', 24, '2021-01-07', 'Fitness coach', 'Career coach');
INSERT INTO employee (`employee_name`, `employee_gender`, `employee_age`, `entry_time`, `staff`, `employee_message`) VALUES ('Cleaning 1', 'Female', 48, '2019-08-24', 'Cleaners', 'Model employee');
INSERT INTO employee (`employee_name`, `employee_gender`, `employee_age`, `entry_time`, `staff`, `employee_message`) VALUES ('Cleaning 2', 'Female', 48, '2010-08-01', 'Cleaners', '');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_id` int NOT NULL AUTO_INCREMENT COMMENT 'Course id',
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Course Name',
  `course_begin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Course start time',
  `course_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Course Duration',
  `coach_id` int NULL DEFAULT NULL COMMENT 'Coach ID',
  `price` int NULL DEFAULT NULL COMMENT 'vnd',
  `course_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'based on time/sport',
  PRIMARY KEY (`course_id`) USING BTREE,
  FOREIGN KEY (`coach_id`) REFERENCES `employee`(`employee_id`) ON DELETE SET NULL ON UPDATE CASCADE

) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` (`course_name`, `course_begin`, `course_time`, `coach_id`, `price`, `course_type`) VALUES ('yoga_3m', '2021-01-01 15:00', '60m', 1, 600000, "yoga 3 months");
INSERT INTO `course` (`course_name`, `course_begin`, `course_time`, `coach_id`, `price`, `course_type`) VALUES ('gym_1m', '2021-01-02 10:20', '90m', 1, 200000, "gym 1 month");
INSERT INTO `course` (`course_name`, `course_begin`, `course_time`, `coach_id`, `price`, `course_type`) VALUES ('gym_3m', '2021-03-06 18:00', '90m', 2, 550000, "gym 3 months");
INSERT INTO `course` (`course_name`, `course_begin`, `course_time`, `coach_id`, `price`, `course_type`) VALUES ('gym_1m_PT', '2021-02-02 10:00', '45m', 4, 3000000, "gym 1 month with PT");
INSERT INTO `course` (`course_name`, `course_begin`, `course_time`, `coach_id`, `price`, `course_type`) VALUES ('yoga_1m', '2021-02-03 15:00', '60m', 3, 200000, "yoga 1 month");
INSERT INTO `course` (`course_name`, `course_begin`, `course_time`, `coach_id`, `price`, `course_type`) VALUES ('cardio_1m', '2021-02-03 15:00', '60m', 3, 150000, "cardio 1 month");
INSERT INTO `course` (`course_name`, `course_begin`, `course_time`, `coach_id`, `price`, `course_type`) VALUES ('gym_1d', '2021-03-01 17:30', '60m', 4, 10000, "gym 1 day");
INSERT INTO `course` (`course_name`, `course_begin`, `course_time`, `coach_id`, `price`, `course_type`) VALUES ('yoga_1d', '2021-02-22 09:00', '90m', 4, 12000,"yoga 1 day");
INSERT INTO `course` (`course_name`, `course_begin`, `course_time`, `coach_id`, `price`, `course_type`) VALUES ('cardio_1d', '2021-02-04 15:00', '60m', 2, 8000, "cardio 1 day");
INSERT INTO `course` (`course_name`, `course_begin`, `course_time`, `coach_id`, `price`, `course_type`) VALUES ('gym_1y_PT', '2021-03-08 15:00', '45m', 1, 20000000, "gym 1 year with PT");
INSERT INTO `course` (`course_name`, `course_begin`, `course_time`, `coach_id`, `price`, `course_type`) VALUES ('gym_1y', '2021-02-22 18:00', '60m', 2, 1500000, "gym 1 year");


-- ----------------------------
-- Table structure for course order
-- ----------------------------
DROP TABLE IF EXISTS `course_order`;
CREATE TABLE `course_order`  (
  `course_order_id` int NOT NULL AUTO_INCREMENT COMMENT 'Registration Form id',
  `course_id` int NULL DEFAULT NULL COMMENT 'Course id',
  `member_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Member Account',
  `status` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'accepted/waiting',
  PRIMARY KEY (`course_order_id`) USING BTREE,
  FOREIGN KEY (`course_id`) REFERENCES `course`(`course_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  FOREIGN KEY (`member_account`) REFERENCES `member`(`member_account`) ON DELETE SET NULL ON UPDATE CASCADE

) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course order
-- ----------------------------
INSERT INTO `course_order` (`course_id`, `member_account`, `status`) VALUES (1, '202100788', "accepted");
INSERT INTO `course_order` (`course_id`, `member_account`, `status`) VALUES (2, '202132539', "accepted");
INSERT INTO `course_order` (`course_id`, `member_account`, `status`) VALUES (3, '202156754', "accepted");
INSERT INTO `course_order` (`course_id`, `member_account`, `status`) VALUES (4, '202156754', "accepted");
INSERT INTO `course_order` (`course_id`, `member_account`, `status`) VALUES (5, '202183406', "accepted");
INSERT INTO `course_order` (`course_id`, `member_account`, `status`) VALUES (6, '202183406', "accepted");
INSERT INTO `course_order` (`course_id`, `member_account`, `status`) VALUES (7, '202100788', "accepted");
INSERT INTO `course_order` (`course_id`, `member_account`, `status`) VALUES (8, '202186416', "accepted");
INSERT INTO `course_order` (`course_id`, `member_account`, `status`) VALUES (9, '202186416', "accepted");
INSERT INTO `course_order` (`course_id`, `member_account`, `status`) VALUES (10, '202123664', "accepted");
INSERT INTO `course_order` (`course_id`, `member_account`, `status`) VALUES (11, '202153468', "waiting");

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment`  (
  `equipment_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `equipment_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'equipment name',
  `equipment_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'equipment status',
  `equipment_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'equipment message',
  `room_id` int NULL DEFAULT NULL COMMENT 'room id',
  PRIMARY KEY (`equipment_id`) USING BTREE,
  FOREIGN KEY (`room_id`) REFERENCES `room`(`room_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO equipment (`equipment_name`, `equipment_status`, `equipment_message`, `room_id`) VALUES ('Dumbbell 1', 'Normal', '', 1);
INSERT INTO equipment (`equipment_name`, `equipment_status`, `equipment_message`, `room_id`) VALUES ('Barbell 1', 'Damage', 'To be repaired', 1);
INSERT INTO equipment (`equipment_name`, `equipment_status`, `equipment_message`, `room_id`) VALUES ('Treadmill 1', 'In maintenance', 'Contact the manufacturer for maintenance', 2);
INSERT INTO equipment (`equipment_name`, `equipment_status`, `equipment_message`, `room_id`) VALUES ('Treadmill 2',  'Normal', '', 1);
INSERT INTO equipment (`equipment_name`, `equipment_status`, `equipment_message`, `room_id`) VALUES ('Treadmill 3', 'Normal', '', 1);
INSERT INTO equipment (`equipment_name`, `equipment_status`, `equipment_message`, `room_id`) VALUES ('Barbell 1', 'Normal', '', 2);
INSERT INTO equipment (`equipment_name`, `equipment_status`, `equipment_message`, `room_id`) VALUES ('Barbell 2', 'Normal', '', 2);

-- ----------------------------
-- Table structure for feedback_employee
-- ----------------------------
DROP TABLE IF EXISTS `feedback_employee`;
CREATE TABLE `feedback_employee`  (
  `feedback_id` int NOT NULL AUTO_INCREMENT COMMENT 'feedback id',
  `member_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'account of member',
  `employee_id` int NULL DEFAULT NULL COMMENT 'account of employee got feedback',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'content of feedback',
  `time_created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`feedback_id`) USING BTREE,
  FOREIGN KEY (`member_account`) REFERENCES `member`(`member_account`) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`employee_id`) REFERENCES `employee`(`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of feedback_employee
-- ----------------------------
INSERT INTO `feedback_employee` (`member_account`, `employee_id`, `content`) VALUES ('202100788', 1, 'Good');
INSERT INTO `feedback_employee` (`member_account`, `employee_id`, `content`) VALUES ('202183406', 1, 'Awesome');
INSERT INTO `feedback_employee` (`member_account`, `employee_id`, `content`) VALUES ('202183406', 2, 'Usually late');

-- ----------------------------
-- Table structure for feedback_equipment
-- ----------------------------
DROP TABLE IF EXISTS `feedback_equipment`;
CREATE TABLE `feedback_equipment`  (
  `feedback_id` int NOT NULL AUTO_INCREMENT COMMENT 'feedback id',
  `member_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'account of member with feedback',
  `equipment_id` int NULL DEFAULT NULL COMMENT 'id of equipment got feedback',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'content of feedback',
  `time_created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`feedback_id`) USING BTREE,
  FOREIGN KEY (`member_account`) REFERENCES `member`(`member_account`) ON DELETE SET NULL ON UPDATE CASCADE,
  FOREIGN KEY (`equipment_id`) REFERENCES `equipment`(`equipment_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of feedback_equipment
-- ----------------------------
INSERT INTO `feedback_equipment` (`member_account`, `equipment_id`, `content`) VALUES ('202100788', 1, 'Good');
INSERT INTO `feedback_equipment` (`member_account`, `equipment_id`, `content`) VALUES ('202183406', 1, 'Awesome');
INSERT INTO `feedback_equipment` (`member_account`, `equipment_id`, `content`) VALUES ('202183406', 2, 'Dirty');

-- ----------------------------
-- Table structure for feedback_course
-- ----------------------------
DROP TABLE IF EXISTS `feedback_course`;
CREATE TABLE `feedback_course`  (
  `feedback_id` int NOT NULL AUTO_INCREMENT COMMENT 'feedback id',
  `member_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'account of member with feedback',
  `course_id` int NULL DEFAULT NULL COMMENT 'id of equipment got feedback',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'content of feedback',
  `time_created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`feedback_id`) USING BTREE,
  FOREIGN KEY (`member_account`) REFERENCES `member`(`member_account`) ON DELETE SET NULL ON UPDATE CASCADE,
  FOREIGN KEY (`course_id`) REFERENCES `course`(`course_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of feedback_course
-- ----------------------------
INSERT INTO `feedback_course` (`member_account`, `course_id`, `content`) VALUES ('202100788', 1, 'Good');
INSERT INTO `feedback_course` (`member_account`, `course_id`, `content`) VALUES ('202183406', 1, 'Okay');
INSERT INTO `feedback_course` (`member_account`, `course_id`, `content`) VALUES ('202183406', 2, 'Hate that');

DROP TABLE IF EXISTS `feedback_room`;
CREATE TABLE `feedback_room`  (
  `feedback_id` int NOT NULL AUTO_INCREMENT COMMENT 'feedback id',
  `member_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'account of member with feedback',
  `room_id` int NULL DEFAULT NULL COMMENT 'id of equipment got feedback',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'content of feedback',
  `time_created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`feedback_id`) USING BTREE,
  FOREIGN KEY (`member_account`) REFERENCES `member`(`member_account`) ON DELETE SET NULL ON UPDATE CASCADE,
  FOREIGN KEY (`room_id`) REFERENCES `room`(`room_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of feedback_room
-- ----------------------------
INSERT INTO `feedback_room` (`member_account`, `room_id`, `content`) VALUES ('202100788', 1, 'Clean');
INSERT INTO `feedback_room` (`member_account`, `room_id`, `content`) VALUES ('202183406', 1, 'Okay');
INSERT INTO `feedback_room` (`member_account`, `room_id`, `content`) VALUES ('202183406', 2, 'A lot of equipment');

SET FOREIGN_KEY_CHECKS = 1;