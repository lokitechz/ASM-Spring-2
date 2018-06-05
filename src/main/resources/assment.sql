-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.21-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for spring_assignment_advanced
CREATE DATABASE IF NOT EXISTS `spring_assignment_advanced` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `spring_assignment_advanced`;

-- Dumping structure for table spring_assignment_advanced.attendance_details
CREATE TABLE IF NOT EXISTS `attendance_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_time_slot` int(11) DEFAULT NULL,
  `student_id` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_attendance_details_timeslots` (`id_time_slot`),
  KEY `FK_attendance_details_students` (`student_id`),
  CONSTRAINT `FK_attendance_details_students` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`),
  CONSTRAINT `FK_attendance_details_timeslots` FOREIGN KEY (`id_time_slot`) REFERENCES `attendance_slots` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table spring_assignment_advanced.attendance_details: ~5 rows (approximately)
/*!40000 ALTER TABLE `attendance_details` DISABLE KEYS */;
INSERT INTO `attendance_details` (`id`, `id_time_slot`, `student_id`, `create_date`, `status`) VALUES
	(1, 1, 'A00001', '2018-05-30 21:29:01', b'1'),
	(2, 2, 'A00002', '2018-05-30 21:29:01', b'0'),
	(3, 3, 'A00003', '2018-05-30 21:29:01', b'1'),
	(4, 4, 'A00004', '2018-05-30 21:29:01', b'0'),
	(5, 4, 'A00001', '2018-06-04 21:58:38', b'1');
/*!40000 ALTER TABLE `attendance_details` ENABLE KEYS */;

-- Dumping structure for table spring_assignment_advanced.attendance_slots
CREATE TABLE IF NOT EXISTS `attendance_slots` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` varchar(50) NOT NULL,
  `slot_id` int(11) NOT NULL,
  `subject_code` varchar(50) NOT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `status` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_attendance_slots_classes` (`class_id`),
  KEY `FK_attendance_slots_timeslots` (`slot_id`),
  CONSTRAINT `FK_attendance_slots_classes` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`),
  CONSTRAINT `FK_attendance_slots_timeslots` FOREIGN KEY (`slot_id`) REFERENCES `timeslots` (`slot_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table spring_assignment_advanced.attendance_slots: ~5 rows (approximately)
/*!40000 ALTER TABLE `attendance_slots` DISABLE KEYS */;
INSERT INTO `attendance_slots` (`id`, `class_id`, `slot_id`, `subject_code`, `create_date`, `status`) VALUES
	(1, 'T1707A', 1, 'JAVA', '2018-05-30 21:27:41', b'1'),
	(2, 'T1707B', 2, 'PHP', '2018-05-30 21:27:41', b'0'),
	(3, 'T1707C', 3, 'C#', '2018-05-30 21:27:41', b'1'),
	(4, 'T1707D', 3, 'C++', '2018-06-05 21:27:41', b'1'),
	(5, 'T1707A', 4, 'Spring', '2018-06-05 20:57:29', b'1');
/*!40000 ALTER TABLE `attendance_slots` ENABLE KEYS */;

-- Dumping structure for table spring_assignment_advanced.classes
CREATE TABLE IF NOT EXISTS `classes` (
  `class_id` varchar(50) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `class_status` bit(1) NOT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table spring_assignment_advanced.classes: ~4 rows (approximately)
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` (`class_id`, `create_date`, `class_status`) VALUES
	('T1707A', '2018-05-30 21:09:44', b'1'),
	('T1707B', '2018-05-30 21:09:44', b'0'),
	('T1707C', '2018-05-30 21:09:44', b'1'),
	('T1707D', '2018-05-30 21:09:44', b'1');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;

-- Dumping structure for table spring_assignment_advanced.students
CREATE TABLE IF NOT EXISTS `students` (
  `student_id` varchar(50) NOT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table spring_assignment_advanced.students: ~4 rows (approximately)
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` (`student_id`, `student_name`) VALUES
	('A00001', 'Hoàng Giang 1'),
	('A00002', 'Hoàng Giang 2'),
	('A00003', 'Hoàng Giang 3'),
	('A00004', 'Hoàng Giang 4');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;

-- Dumping structure for table spring_assignment_advanced.student_class
CREATE TABLE IF NOT EXISTS `student_class` (
  `student_id` varchar(50) NOT NULL,
  `class_id` varchar(50) NOT NULL,
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`student_id`,`class_id`),
  KEY `FK_student_class_students` (`student_id`),
  KEY `FK_student_class_classes` (`class_id`),
  CONSTRAINT `FK_student_class_classes` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`),
  CONSTRAINT `FK_student_class_students` FOREIGN KEY (`student_id`) REFERENCES `students` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table spring_assignment_advanced.student_class: ~6 rows (approximately)
/*!40000 ALTER TABLE `student_class` DISABLE KEYS */;
INSERT INTO `student_class` (`student_id`, `class_id`, `create_date`, `status`) VALUES
	('A00001', 'T1707A', '2018-05-30 21:21:17', b'1'),
	('A00001', 'T1707D', '2018-06-04 22:13:29', b'1'),
	('A00002', 'T1707A', '2018-06-04 22:54:31', b'1'),
	('A00002', 'T1707B', '2018-05-30 21:21:17', b'0'),
	('A00003', 'T1707C', '2018-05-30 21:21:17', b'1'),
	('A00004', 'T1707D', '2018-05-30 21:21:17', b'1');
/*!40000 ALTER TABLE `student_class` ENABLE KEYS */;

-- Dumping structure for table spring_assignment_advanced.timeslots
CREATE TABLE IF NOT EXISTS `timeslots` (
  `slot_id` int(11) NOT NULL AUTO_INCREMENT,
  `slot_time` varchar(50) NOT NULL,
  PRIMARY KEY (`slot_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table spring_assignment_advanced.timeslots: ~4 rows (approximately)
/*!40000 ALTER TABLE `timeslots` DISABLE KEYS */;
INSERT INTO `timeslots` (`slot_id`, `slot_time`) VALUES
	(1, '8h-11h'),
	(2, '9h-12h'),
	(3, '13h-15h'),
	(4, '15h-17h');
/*!40000 ALTER TABLE `timeslots` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
