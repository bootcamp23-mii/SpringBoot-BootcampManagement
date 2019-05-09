-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2019 at 04:41 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bootcampmanagement2`
--
DROP DATABASE IF EXISTS `bootcampmanagement2`;
CREATE DATABASE IF NOT EXISTS `bootcampmanagement2` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `bootcampmanagement2`;

DELIMITER $$
--
-- Functions
--
DROP FUNCTION IF EXISTS `nextIdAccessCard`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdAccessCard` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_ACCESSCARD;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_ACCESS_CARD_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdAchievement`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdAchievement` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_T_ACHIEVEMENT;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_T_ACHIEVEMENT_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdAspect`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdAspect` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_ASPECT;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_ASPECT_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdBatchClass`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdBatchClass` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_BATCHCLASS;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_BATCH_CLASS_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdCategory`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdCategory` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_CATEGORY;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_CATEGORY_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdCerificate`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdCerificate` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_CERTIFICATE;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_CERTIFICATE_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdCompany`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdCompany` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_COMPANY;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_COMPANY_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdDegree`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdDegree` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_DEGREE;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_DEGREE_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdDistrict`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdDistrict` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_DISTRICT;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_DISTRICT_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdEducation`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdEducation` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_EDUCATION;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_EDUCATION_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdEducationHistory`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdEducationHistory` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_T_EDUCATIONHISTORY;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_T_EDUCATION_HISTORY_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdEmployee`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdEmployee` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE nextId varchar(20);
SELECT max(id) INTO nextId FROM TB_M_EMPLOYEE;
SET nextId = nextId + 1;
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdEmployeeAccess`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdEmployeeAccess` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_T_EMPLOYEEACCESS;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_T_EMPLOYEE_ACCESS_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdEmployeeCertification`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdEmployeeCertification` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_T_EMPLOYEECERTIFICATION;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_T_EMPLOYEE_CERTIFICATION_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdEmployeeLanguage`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdEmployeeLanguage` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_T_EMPLOYEELANGUAGE;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_T_EMPLOYEE_LANGUAGE_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdEmployeeLocker`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdEmployeeLocker` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_T_EMPLOYEELOCKER;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_T_EMPLOYEE_LOCKER_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdEmployeeRole`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdEmployeeRole` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_T_EMPLOYEEROLE;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_T_EMPLOYEE_ROLE_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdEmployeeSkill`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdEmployeeSkill` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_T_EMPLOYEESKILL;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_T_EMPLOYEE_SKILL_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdErrorBank`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdErrorBank` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_T_ERRORBANK;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_T_ERROR_BANK_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdEvaluation`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdEvaluation` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_EVALUATION;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_EVALUATION_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdIdCard`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdIdCard` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_T_IDCARD;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_T_ID_CARD_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdLanguage`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdLanguage` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_LANGUAGE;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_LANGUAGE_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdLesson`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdLesson` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_LESSON;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_LESSON_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdLocker`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdLocker` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_LOCKER;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_LOCKER_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdMajor`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdMajor` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_MAJOR;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_MAJOR_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdOrganization`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdOrganization` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_T_ORGANIZATION;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_T_ORGANIZATION_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdParticipant`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdParticipant` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_T_PARTICIPANT;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_T_PARTICIPANT_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdPlacement`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdPlacement` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_T_PLACEMENT;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_T_PLACEMENT_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdProvince`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdProvince` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_PROVINCE;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_PROVINCE_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdReligion`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdReligion` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_RELIGION;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_RELIGION_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdRole`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdRole` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_ROLE;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_ROLE_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdRoom`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdRoom` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_ROOM;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_ROOM_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdScore`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdScore` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_T_SCORE;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_T_SCORE_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdSkill`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdSkill` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_SKILL;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_SKILL_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdSubdistrict`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdSubdistrict` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_SUBDISTRICT;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_SUBDISTRICT_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdTopic`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdTopic` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_TOPIC;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_TOPIC_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdUniversity`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdUniversity` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_UNIVERSITY;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_UNIVERSITY_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdVillage`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdVillage` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_M_VILLAGE;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_M_VILLAGE_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DROP FUNCTION IF EXISTS `nextIdWorkExperience`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `nextIdWorkExperience` () RETURNS VARCHAR(20) CHARSET utf8 COLLATE utf8_unicode_ci BEGIN
DECLARE idBegin varchar(20);
DECLARE nextId varchar(20);
DECLARE idCount INT;
SELECT count(id) INTO idCount FROM TB_T_WORKEXPERIENCE;
SET idCount = idCount + 1;
SELECT value INTO idBegin FROM TB_M_PARAMETER WHERE id = 'TB_T_WORK_EXPERIENCE_ID_BEGIN';
SET nextId = CONCAT(idBegin,idCount);
RETURN nextId;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_accesscard`
--

DROP TABLE IF EXISTS `tb_m_accesscard`;
CREATE TABLE IF NOT EXISTS `tb_m_accesscard` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `accessnumber` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_accesscard`
--

TRUNCATE TABLE `tb_m_accesscard`;
--
-- Dumping data for table `tb_m_accesscard`
--

INSERT INTO `tb_m_accesscard` (`id`, `accessnumber`) VALUES
('EAC1', '10001'),
('EAC2', '10002'),
('EAC3', '10003'),
('EAC4', '10004'),
('EAC5', '10005'),
('EAC6', '10006'),
('EAC7', '10007');

--
-- Triggers `tb_m_accesscard`
--
DROP TRIGGER IF EXISTS `setIdAccessCard`;
DELIMITER $$
CREATE TRIGGER `setIdAccessCard` BEFORE INSERT ON `tb_m_accesscard` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdAccessCard() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_aspect`
--

DROP TABLE IF EXISTS `tb_m_aspect`;
CREATE TABLE IF NOT EXISTS `tb_m_aspect` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_aspect`
--

TRUNCATE TABLE `tb_m_aspect`;
--
-- Dumping data for table `tb_m_aspect`
--

INSERT INTO `tb_m_aspect` (`id`, `name`) VALUES
('BA1', 'Discipline'),
('BA2', 'Teamwork'),
('BA3', 'Initiative'),
('BA4', 'Honesty'),
('BA5', 'Loyalty'),
('BA6', 'Coding');

--
-- Triggers `tb_m_aspect`
--
DROP TRIGGER IF EXISTS `setIdAspect`;
DELIMITER $$
CREATE TRIGGER `setIdAspect` BEFORE INSERT ON `tb_m_aspect` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdAspect() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_batch`
--

DROP TABLE IF EXISTS `tb_m_batch`;
CREATE TABLE IF NOT EXISTS `tb_m_batch` (
  `id` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `startdate` date NOT NULL,
  `enddate` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_batch`
--

TRUNCATE TABLE `tb_m_batch`;
--
-- Dumping data for table `tb_m_batch`
--

INSERT INTO `tb_m_batch` (`id`, `startdate`, `enddate`) VALUES
('22', '2019-01-01', '2019-02-28'),
('23', '2019-02-01', '2019-03-31'),
('24', '2019-03-01', '2019-04-30'),
('25', '2019-04-01', '2019-05-31'),
('26', '2019-05-01', '2019-06-30'),
('27', '2019-06-01', '2019-07-31');

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_batchclass`
--

DROP TABLE IF EXISTS `tb_m_batchclass`;
CREATE TABLE IF NOT EXISTS `tb_m_batchclass` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `isdeleted` tinyint(4) DEFAULT NULL,
  `trainer` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `batch` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `classes` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `room` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `trainer_fk` (`trainer`),
  KEY `TB_M_BATCH_fk` (`batch`),
  KEY `bc_TB_M_CLASSES_fk` (`classes`),
  KEY `TB_M_ROOM_fk` (`room`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_batchclass`
--

TRUNCATE TABLE `tb_m_batchclass`;
--
-- Dumping data for table `tb_m_batchclass`
--

INSERT INTO `tb_m_batchclass` (`id`, `isdeleted`, `trainer`, `batch`, `classes`, `room`) VALUES
('BBC1', 0, '14201', '22', 'dotNet', 'BR1'),
('BBC2', 0, '14202', '23', 'Java', 'BR2'),
('BBC3', 1, '14201', '22', 'Java', 'BR3'),
('BBC4', 1, '14201', '24', 'dotNet', 'BR2'),
('BBC5', 1, '14201', '27', 'Java', 'BR1'),
('BBC6', 0, '14202', '25', 'dotNet', 'BR4'),
('BBC7', 0, '14201', '25', 'Java', 'BR1');

--
-- Triggers `tb_m_batchclass`
--
DROP TRIGGER IF EXISTS `setIdBatchClass`;
DELIMITER $$
CREATE TRIGGER `setIdBatchClass` BEFORE INSERT ON `tb_m_batchclass` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdBatchClass() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_category`
--

DROP TABLE IF EXISTS `tb_m_category`;
CREATE TABLE IF NOT EXISTS `tb_m_category` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_category`
--

TRUNCATE TABLE `tb_m_category`;
--
-- Dumping data for table `tb_m_category`
--

INSERT INTO `tb_m_category` (`id`, `name`) VALUES
('CVCT1', 'Desktop'),
('CVCT2', 'Web'),
('CVCT3', 'Mobile'),
('CVCT4', 'Network');

--
-- Triggers `tb_m_category`
--
DROP TRIGGER IF EXISTS `setIdCategory`;
DELIMITER $$
CREATE TRIGGER `setIdCategory` BEFORE INSERT ON `tb_m_category` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdCategory() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_certificate`
--

DROP TABLE IF EXISTS `tb_m_certificate`;
CREATE TABLE IF NOT EXISTS `tb_m_certificate` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_certificate`
--

TRUNCATE TABLE `tb_m_certificate`;
--
-- Dumping data for table `tb_m_certificate`
--

INSERT INTO `tb_m_certificate` (`id`, `name`) VALUES
('CVCF1', 'Oracle'),
('CVCF2', 'Java'),
('CVCF3', 'Php'),
('CVCF4', 'HTML');

--
-- Triggers `tb_m_certificate`
--
DROP TRIGGER IF EXISTS `setIdCertificate`;
DELIMITER $$
CREATE TRIGGER `setIdCertificate` BEFORE INSERT ON `tb_m_certificate` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdCerificate() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_classes`
--

DROP TABLE IF EXISTS `tb_m_classes`;
CREATE TABLE IF NOT EXISTS `tb_m_classes` (
  `id` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_classes`
--

TRUNCATE TABLE `tb_m_classes`;
--
-- Dumping data for table `tb_m_classes`
--

INSERT INTO `tb_m_classes` (`id`) VALUES
('dotNet'),
('Java');

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_company`
--

DROP TABLE IF EXISTS `tb_m_company`;
CREATE TABLE IF NOT EXISTS `tb_m_company` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `village` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `TB_M_COMPANY_TB_M_VILLAGE_fk` (`village`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_company`
--

TRUNCATE TABLE `tb_m_company`;
--
-- Dumping data for table `tb_m_company`
--

INSERT INTO `tb_m_company` (`id`, `name`, `address`, `phone`, `village`) VALUES
('LC1', 'Bank Indonesia', 'Jalan M.H. Thamrin No.2 Tanah Abang, RT.2/RW.3, Gambir, Jakarta', '08321', 'LV1'),
('LC2', 'Pertamina', 'Tanjung Palas, Dumai Timur, Dumai, Riau', '08322', 'LV2'),
('LC3', 'BNI', 'Jl. Pejompongan Raya No.7, RT.1/RW.5, Bend. Hilir, Tanah Abang, Jakarta', '08323', 'LV3');

--
-- Triggers `tb_m_company`
--
DROP TRIGGER IF EXISTS `setIdCompany`;
DELIMITER $$
CREATE TRIGGER `setIdCompany` BEFORE INSERT ON `tb_m_company` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdCompany() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_degree`
--

DROP TABLE IF EXISTS `tb_m_degree`;
CREATE TABLE IF NOT EXISTS `tb_m_degree` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_degree`
--

TRUNCATE TABLE `tb_m_degree`;
--
-- Dumping data for table `tb_m_degree`
--

INSERT INTO `tb_m_degree` (`id`, `name`) VALUES
('CVD1', 'S1'),
('CVD2', 'S2'),
('CVD3', 'S3'),
('CVD4', 'D3');

--
-- Triggers `tb_m_degree`
--
DROP TRIGGER IF EXISTS `setIdDegree`;
DELIMITER $$
CREATE TRIGGER `setIdDegree` BEFORE INSERT ON `tb_m_degree` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdDegree() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_district`
--

DROP TABLE IF EXISTS `tb_m_district`;
CREATE TABLE IF NOT EXISTS `tb_m_district` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `province` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `TB_M_PROVINCE_fk` (`province`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_district`
--

TRUNCATE TABLE `tb_m_district`;
--
-- Dumping data for table `tb_m_district`
--

INSERT INTO `tb_m_district` (`id`, `name`, `province`) VALUES
('LD1', 'Jakarta Pusat', 'LP1'),
('LD2', 'Jakarta Utara', 'LP1'),
('LD3', 'Jakarta Barat', 'LP1'),
('LD4', 'Kota Yogyakarta', 'LP2'),
('LD5', 'Sleman', 'LP2'),
('LD6', 'Bantul', 'LP2'),
('LD7', 'Kota Pekanbaru', 'LP3'),
('LD8', 'Bengkalis', 'LP3');

--
-- Triggers `tb_m_district`
--
DROP TRIGGER IF EXISTS `setIdDistrict`;
DELIMITER $$
CREATE TRIGGER `setIdDistrict` BEFORE INSERT ON `tb_m_district` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdDistrict() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_education`
--

DROP TABLE IF EXISTS `tb_m_education`;
CREATE TABLE IF NOT EXISTS `tb_m_education` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `isdeleted` tinyint(4) DEFAULT NULL,
  `degree` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `major` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `university` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `TB_M_DEGREE_fk` (`degree`),
  KEY `TB_M_MAJOR_fk` (`major`),
  KEY `TB_M_UNIVERSITY_fk` (`university`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_education`
--

TRUNCATE TABLE `tb_m_education`;
--
-- Dumping data for table `tb_m_education`
--

INSERT INTO `tb_m_education` (`id`, `isdeleted`, `degree`, `major`, `university`) VALUES
('CVE1', 0, 'CVD1', 'CVM1', 'CVU1'),
('CVE10', 0, 'CVD1', 'CVM1', 'CVU4'),
('CVE11', 0, 'CVD1', 'CVM2', 'CVU4'),
('CVE12', 0, 'CVD1', 'CVM3', 'CVU4'),
('CVE13', 0, 'CVD1', 'CVM1', 'CVU5'),
('CVE14', 0, 'CVD1', 'CVM2', 'CVU5'),
('CVE15', 0, 'CVD1', 'CVM3', 'CVU5'),
('CVE2', 0, 'CVD1', 'CVM2', 'CVU1'),
('CVE3', 0, 'CVD1', 'CVM3', 'CVU1'),
('CVE4', 0, 'CVD1', 'CVM1', 'CVU2'),
('CVE5', 0, 'CVD1', 'CVM2', 'CVU2'),
('CVE6', 0, 'CVD1', 'CVM3', 'CVU2'),
('CVE7', 0, 'CVD1', 'CVM1', 'CVU3'),
('CVE8', 0, 'CVD1', 'CVM2', 'CVU3'),
('CVE9', 0, 'CVD1', 'CVM3', 'CVU3');

--
-- Triggers `tb_m_education`
--
DROP TRIGGER IF EXISTS `setIdEducation`;
DELIMITER $$
CREATE TRIGGER `setIdEducation` BEFORE INSERT ON `tb_m_education` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdEducation() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_employee`
--

DROP TABLE IF EXISTS `tb_m_employee`;
CREATE TABLE IF NOT EXISTS `tb_m_employee` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `birthdate` date NOT NULL,
  `gender` tinyint(4) NOT NULL,
  `marriedstatus` tinyint(4) NOT NULL,
  `address` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `onboarddate` date NOT NULL,
  `password` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `securityqestion` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `securityanswer` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `photo` longblob,
  `isdeleted` tinyint(4) DEFAULT NULL,
  `birthplace` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hiringlocation` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `religion` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `village` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_uk` (`email`),
  KEY `TB_M_RELIGION_fk` (`religion`),
  KEY `emp_TB_M_VILLAGE_fk` (`village`),
  KEY `birthPlace_fk` (`birthplace`),
  KEY `hiringLocation_fk` (`hiringlocation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_employee`
--

TRUNCATE TABLE `tb_m_employee`;
--
-- Dumping data for table `tb_m_employee`
--

INSERT INTO `tb_m_employee` (`id`, `name`, `birthdate`, `gender`, `marriedstatus`, `address`, `email`, `phone`, `onboarddate`, `password`, `securityqestion`, `securityanswer`, `photo`, `isdeleted`, `birthplace`, `hiringlocation`, `religion`, `village`) VALUES
('14201', 'Alpha', '1996-01-10', 1, 1, 'Mungkin di sini', 'alpha@mail.com', '08521', '2019-01-01', '$2a$10$nZpY3BG0INl5mkZO6vF95O8PS4p8YxsbAr9S0ChvsOfpHcTaxQlYC', 'admin', 'admin', 0xffd8ffe000104a46494600010101006000600000ffdb004300080606070605080707070909080a0c140d0c0b0b0c1912130f141d1a1f1e1d1a1c1c20242e2720222c231c1c2837292c30313434341f27393d38323c2e333432ffdb0043010909090c0b0c180d0d1832211c213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232ffc000110800d3009f03012200021101031101ffc4001f0000010501010101010100000000000000000102030405060708090a0bffc400b5100002010303020403050504040000017d01020300041105122131410613516107227114328191a1082342b1c11552d1f02433627282090a161718191a25262728292a3435363738393a434445464748494a535455565758595a636465666768696a737475767778797a838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae1e2e3e4e5e6e7e8e9eaf1f2f3f4f5f6f7f8f9faffc4001f0100030101010101010101010000000000000102030405060708090a0bffc400b51100020102040403040705040400010277000102031104052131061241510761711322328108144291a1b1c109233352f0156272d10a162434e125f11718191a262728292a35363738393a434445464748494a535455565758595a636465666768696a737475767778797a82838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae2e3e4e5e6e7e8e9eaf2f3f4f5f6f7f8f9faffda000c03010002110311003f00f7b20c672395ee29dc3afa834b51affac257eef7a0042ac1d4755cf5f4a924ff0056df4a5a493fd5b7d2801a41186c67d45299071b4649a72fdd1400076c500337b0e4a71ec734f0432fa834531387703a50000ec254f4ea295067e63d4fe951ce71b48a9a801a5f076819349bd872cbc7a839a22fb99ee69f400980cbec6a300ee03ba9cfd69d1f461d81a5e928f714006e7c7dd1ff007d52a1dc80fa8a53d0d247fead7e94009b98b1014607bd349218311cf4005397efb7e148bcc85bd3814006c2dcb9fc05380551c600a4762b800649e947979e5892680109321c0fbbdcd3b845f4029a2440300fe94005ce5871d850034925d18f033c0a7c9feadbe94927054fa1a477564600e490714006e240551ce3ad1f3a7fb429082bf32fe22b9bd5bc79a2e953b5b35c096ed4730a76fa9e949c92dca8c5cb63a5f309fbaac4fb8a722ed072464f5af34baf89170c49845b449d8b36e38fc315cd6a9f14b55542969708643fc410ed159bab146b1c34d9edae03b103a01d69e8db941efdebe748fe2578b233917f137b3447fc6b46cbe2e788a0981b84b4990fde01083f9e6a557896f07516a7bc60a138195fe54172c30aa73ea78af32b2f8ac6700b4101f55de54ff235d1e9df10747bc91629e516d231c00ec083f8d68aa45993a335d0eb1176ae290302c5bb0e2a3594ca80a1f95bf8bd69ef80a07419ab3214c8082006cf6e0d39061003d851bd71f78534be785e7de801539663ef48bc3b0f5e69eabb540a465dd820e08a00470782bc907a5279a3a6d6fca80f8e18629dbd7fbc2801460fa52d4280c631dcfad026e324823da8025c521007614c329ce381ec690cb9381807de803cf7e2878ce5d0ec934cd3e4d97f720e5c758d3b91ee78fd6bc379662ccccee796624e493d4e6baff16c4facf8b2fae1af61590b6c8e366e428e83d33f8d60db6913dccf243be38e68fac6c7935c555b948f5f0f18c21a99e79ebd7e9476ad41a2b3131adddb99ff00e7906e73e99aab6d6135c5cbc1c218c12e58e028acac6fcc8ab4569ae8b2bb6e8e785e11f7a50df2afb1ef41d15fc89275ba80c2a3ef863cfb74a2c1cc8cbfa5232823915bab3a7fc23e64f2222e1c47bb68ce306b2eced7ed738844a9193d0b9c03ed4ed604d3dcecfc31f13f50d03486b0b884df797c40cefca8f427a91534df187c4523831db594683f876139fccd72b69a4197585d3e59e23e61d9bb9c0278f4ab169a3fd9754bbb4b99606920465653ce091d7a76ab539183a549bd8f48f09fc588f54bf8ec358b58eda694ed8e54fb8c7d39e95ea0872338af992cf4e8cd9df117106e5002b8cfc98e735eebe05d624d5bc1f617329ccab1f94ec4e77153b777e38cfe35bd29b7a338f114947589d4d2640a607c8c1c73d0d336863d147b9adce426c8228dabfdd1f9543ca67a0c0cf1d08a919f6a83400d97d0f4c66a1fe107000073f8d5a650dd69a231d724fd4d00572339ca0e7b039cd0fc15381c0e6a731ae78c8fa1a49106cc0e31cd27b0d6e7cb93e9f7cdaac80a333b4a5b7f51d7ae6b620066f103b467212dfcb67edbaaacd796715d4cbf6aba55591b3003c673d33e9592f7922cd2b5bb3431b9fb8ac6b89bb33d88a728a27874dbd1a8221460c1c12e7a0e7ad69b037126a9242a4ab26d0c07539158b1dddfdc62d61967949e0469924d6ee9fe12f165c285b7b29a08cffcf56d82a39d21bf3650d3a398e95a86d46e40c0f7e73496b14ade1fbb011882ea578eb8c67f9575d61f0d35f65c5c6aa96ca792b1fcdfc8d6fd8fc34b1b78825cea37b3af745936a9fcb06a5d58a25cd1e682190786db287fd686fc3079acbb78ae26917ecf0c8ed9e36a935efb69e15d12c63091d96e5031891ddc63e849ad382d6d6d462ded61840ff9e7185fe42b39565d05ed5ad0f26b4f0cead772aead0583acaf18c6ff009487e99ab9e31d33ec9e2d3748802cd68c5caff780e735ea59ca90c1b39ce41e0570bf142c6693428f51b77657b67025da7831b71fcc8a6aadda338c9b96a79a58230d2f527c7ca500071d7935ebbf0aaeccfe1e68ca20589f682af9c703af031cd7890b898446212388d8f2a0f15eadf0532d16a8a49c7980f5f615d549fbc3c547dc6cf54e7cb18183bb3d69ec006c8dbb7e99a9422807be7d693ca5ed91f435d8796478cf63e82a603e500d0a814e47e669d400514514005358641a7534f5a4c0f97fc5967f61f16ea76f8c013311f435996d6f25ede436b0ae659982a8f735da7c59b2fb378d04eab84b98011f55ebfceb2bc05686ebc6962072202653f8579f5346cf6a12fdd5cf5ef0e786ecfc39611c16f1a19f6e269b6e19cf7e6b9ad5759f1cdcebb7369a3e9a23b680e03c814799f8b577c4e7f3a6bca9163cc9157770371c64fb572293b9cf7eace3fc31e2fbcbed4df45d72cdad35455debc7cae3d8d76551b5bc0f3aced121994615f1c81f5a92a66ee019c0eb58faf788ecbc3d6e8f722496694910c112ee790fb0ad8a8de08649525922469101dacc395a49ab86e7092fc47bcb09126d5bc39796964e702523903d48aeca78edb5bd1648d0892deee1c2b1e872383f9e29d776d65aadacf6572914f0b0c491ee048f63e952dadb43656915ac09b218902a2f60055c9f6137d8f9c6f2d1ec6fee2ca5056481ca907f4af5af82698b0d4df1d6603f415c87c4ed3c5a78b05c2fddbb843f1fde0707fa576ff05571a05fbfadcff415db41dd978877a27a78ef4b480e7a1a5aeeb9e58b45145300a28a2800aab7b318a2f97a9e956aa86a40ed43d81e6b1aeda8368a82bc8f25f8bb6a5edf4bbf209292344c7fde19ff00d96a97c24b2f3350d46f48e23458d4fb9c93fd2babf88f67f6bf055d1c7cd03aca3f3c7f5aa9f0aeccdb7845a765c1bab86901f51b557fa5799ccdc2e7a89da163b707a0af12f88fa8dd4fe2f9a1f3e58e2b551e5aab9014f3cf1f857b24f24fe62c7020c919676e82b91f157c3e1e22d522bf8aed609080b38c7de03d3dea20d264c2c9dd9bbe11be9751f0969d7770c5a478f0cc7be0919fd2b6aa8db456ba2e9705a23058a05d8a3b9a92d8cb3b79eea514fdc43d7f1a996e27dcb5dab33c45792587872feee1ff0059144597eb5a7515ddb477b692db4ab98e552ac0d11693126787f80f54bbb7f19d9e6e25905d39498339c3eeefef8ce735eedd38c5703a0fc3d5f0eeb31ea4b2fda8c418471ff77231debbb8a432a0628c84ff0009aaa924f62e76be8705f162c3ced0ad6f947cd6f36d240fe161ff00d6a9be13b32785661ce1ae18d749e25b01a9f86efad3192f11c67d6b9ff858857c18a5ba99a4fd188aa526a1a0b470b33beb3999670a58953ea6b54562db0dd7083df3fa56c8aeec24a4e3a9c35924c7514515d86214514500150dc44258997d454d486a6515256634ec729add91bbd16facd87cd240ea3eb8e3f5c541e1cb0fecdf0e58d99e1a28806faf535d5cb0472292ca2b20fde23df15e557a5ecd9d94e7ccac1fe78a3b8a2abc9790c7709033fef1ba2d731b58cfbb716dabacd72a5a12802b63214e6b5629639503238607b839a56459536ba8607b1aaf0e9f6f6d2992256427f8431c5036d3dcb54519cf5a28245a41c55596efcbbc8e065e24076b67bd5aa076b010186dc7078358de19d3bfb274d9ed48c0fb5ceea3fd969188fd08ad9eb57ed2de37855ca026b6a34dcf4339cf950961010c646fa0abfce45000030052d7ab4a9f246c714e5cceec5a28a2b52428a28a0028a28a0063fdd3588df78fd6b6dfee9ac46fbe47bd79f8de87461f712aa3d9137ad729332164da7038ab74579e7595765e2fdc96371e8c314d2da80e896e7e8c7fc2ae51405ca7ff001316e3fd1d7df24e281697127fadbb723d106d1573af5a2905cab1e9f6f1387589778fe22327f3ab428a2985c2b56c3fe3d96b2b35ab61ff001ecb5d982f8ce7aff096a8a28af50e40a28a2800a28a2800a28a4c50023722b1ee23f2e720f7e456ce2a0b9b713263b8e95cd88a5cf1d0d29cf95991453a485e36c329c7ad378af29c5adced524c28a2838f5a9185145191405c28a0d28058800127da9a4dec0da5b88012401d49ada813cb882fa0aab6b6851b7bfde3daaf018af4f0b45c7591c75a7ccec85a28a2bb0c428a28a0028a28a002929690d00145251cd0023283d40359da9a2c36524b1a8dc07f5ad139cd627886f8436df674c6f939fc05672a5ed13496a1ed55369b664aea5300372a9e3b1a7ff6a1c7faaffc7aabc76af2c225888718e47a534dbccbc796df85789384a127167af4dd39c79916ff00b50ffcf1fd69875290f48c0fa9aade4cc7fe59bffdf352ad94c54b3008a3a93daa527276453f6705766be8cff6cf34cbb72a7815b691a20f9540ae2ac6f4d9ea2922b663ce1fdc7ad7689323a821860fbd7bb4f0ae941732d4f1a5898d493b3241f4a5e94dc8ec452d682141a5a6d140ee3a8a4a3f1a005a2a19a65823692460a83a935953f892d23c88c3c87fd91c55461296c8ce75230dd9b59a6b301deb959bc497720fdcc2b1fb93bbfc2b3a6bfbbb83fbcb863ec3815bc70b27b9cf2c6c16c76336a5696ffeb2e2318ed9e6b36e3c4d6ebc408d21fa60572f81f53ef4b5bc70915b9cf3c6cdec6a4de21bd972136463db93fad66cb2c93c9be56676f534da41ff00ebae88538c36472ceaca5f132d58dcfd9e7c1c6c6e0d6f02368c11822bcf66d4993502e39897e523fad75da45f25d42a9b8138f90e7ad7919a612ebdac16a7a1966355fd9499a847eb595a9dd614408c3d58d5ebbb816f6e5bf8ba2e7bd711aa6a4cced1c47273b9d81efe95cf9660f9e5ed248df33c6aa50e44f735f1c631d28562872acca7d8d416b3adcdb4728f400d4d5f4364f73c68cbaa2d47a8dec78db73271ea7356535fbf43cbabfb15acda2a1d283e85aad35d4dd8fc4f303fbcb7523d8ff8d5b8fc4d6c71be2953d78cd72f4566f0d066ab17511d926bba7bf49c0ff78115692fed64fb97111fa38ae0a8c7a7159cb06ba3358e365d51d87881b1a44bef81fad71e00f4aeabc4adb74f54eecc2b96aac2fc04631dea09c52d145756a7205252d1400955afe668adcac6332c9c2a8ab549b46f0f81b8743e940a4aeac6759e931c6bbee3e676edd85729e2df16de780750b6fb25ac5716f3aef1e6e7839e9c115defe271deb80f8bd61f69f09c77b8e6d661cfb1e3fad635eee0cd70b08c6a2b95f46f8a5ab78cf5eb7d28d85a5bf9db81910312a029248c9f6aee86936c2168c862c7f8c9e735e4df062c44bae5f5f9e4416e517eac47f4cd7b29ff0022b3c2ab43435c6c62ea6a6658a49a7dd35bcbfeadfeeb76cd6a5232875dac0119cfd296ba8e48c79740a28a282828a28a0028a28a04749e286fdcc0beaf5cdd6f78a1ff007d027a02d5815cf865fbb3ab14ff0078c5a28a2ba0e612968a2800a28a2800ae37e2936df87f783fbd247ffa10aec6b8bf8ac7fe2839c7aca9fcc5675bf86cda87f111cdfc12386d5c76da87f5af58af23f828dfe93abafac4a7ff001e15eb9deb3c3fc08bc67f118b494b45741cc145252d00145145001494b45006d78a3fe3f61ff73fad62d1456187fe1a37c4ff00118514515b980514514005145140095c47c593ff001433ff00d765fe628a2b2aff00c366d87fe22398f827ff00210d53feb80ffd0857afd145461be045e33f88c28a28ae839828a28a0028a28a0028a28a00ffd9, 0, 'LD1', 'LD4', 'CVR1', 'LV1'),
('14202', 'Beta', '1996-02-15', 1, 0, 'Mungkin di situ', 'beta@mail.com', '08522', '2019-01-01', '$2a$10$UlqEcBaugz7NY6.0QSOOquaYv/wkvPd96iEuljwjTdO767Q3Bnv6i', 'admin', 'admin', 0xffd8ffe000104a46494600010101006000600000ffdb004300080606070605080707070909080a0c140d0c0b0b0c1912130f141d1a1f1e1d1a1c1c20242e2720222c231c1c2837292c30313434341f27393d38323c2e333432ffdb0043010909090c0b0c180d0d1832211c213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232ffc000110800d3009f03012200021101031101ffc4001f0000010501010101010100000000000000000102030405060708090a0bffc400b5100002010303020403050504040000017d01020300041105122131410613516107227114328191a1082342b1c11552d1f02433627282090a161718191a25262728292a3435363738393a434445464748494a535455565758595a636465666768696a737475767778797a838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae1e2e3e4e5e6e7e8e9eaf1f2f3f4f5f6f7f8f9faffc4001f0100030101010101010101010000000000000102030405060708090a0bffc400b51100020102040403040705040400010277000102031104052131061241510761711322328108144291a1b1c109233352f0156272d10a162434e125f11718191a262728292a35363738393a434445464748494a535455565758595a636465666768696a737475767778797a82838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae2e3e4e5e6e7e8e9eaf2f3f4f5f6f7f8f9faffda000c03010002110311003f00f7fa28a2800a4cf34b49de800cd14628a005a4cd14d247ad2ba01d9a334808f5a5a2e80334b4da5a602d1494b400514514005145140051452160a32680168a28a00293bd2d21ebd68010d52d4353b7d36032dc3e0761dcd3755d4a2d32c9ae256e83e51fde35e6b79793ea1746e2e0e58f45feed70e2f14a92b2dcde8d17336aff00c5f7b72c56d02c11faf526b1e4d42fa5397bcb8cfb4840aaf457873c4549bd59df1a518ad8b09a8dfc5f72f675ff0081923f5abf078a75787aceb281da451fd2b23bd1446bd48ecc6e9c5f43aeb3f1b64817b6db47778cf1f9574b63a95aea11efb7995fd47715e57d2a6b6b99acee52e207d8ea73d7afb57650cc269fbfb1854c326bdd3d6e8e2bcfa6f186a2ea02247091d4f2d4d83c5fa9c2ea6511cabdc631c5772cc6936737d5e67a25159ba5ead06ab6c2585b0dfc487aad688e95dd09a9aba3169a7662d14515420a89836fc952c3b54b4c32283826801f451450014d34ea69e94981c078c2f4cfaaada83f242a323fda3ffd6c573f57b5b62faede31ff009e9fd00aa35f2f89939546d9ead15cb0419a28a4ce2b035168a3a7278fad203b8e14127d853b0ae2d19c5588b4fbc987c96d263dc55d8fc3b7cf8de563fd6a9464c5cc648ff2297a74e2b7dbc33b21918dc1670320018ac0ee73c11c52945adc7cd7d8d6f0cddb5a6b90a0388e6ca30fc38af495e95e57a59c6b167ff5d56bd557a57b79649b8599c18a5698b451457a672854462f9b39a968a0028a28a0029a69d4d349ec07966afceb579ff5d4d53ab7aaf3ac5e7fd75356bc3f6a9737e5dc65625dc07bd7cb4d73556bccf5e2ed04169a0de5ca0924db129e81ab422f0cc2bc4b3bb7b0e0568deeada769dff1f77b0424f663cfe5599ff09af868becfed6809ce3186ebf957446811ccd97e2d0ec2120adba93fedf35763823886238d57e8288678ae2159a091648d864329c834fa7ca90ae1cd18ff00228ce2919d17ef3aafd4e2aac217a76ae375bb4fb2ea4c40f9241bc7d6bb059a163859a363e81c56478920f32c3cdef19fd0d65561ee8e2f539fd34e355b33ff004d97f9d7abaf4af27b13ff00133b3ffaee9ffa10af585e82bbf2bf859cf8bf890b451457aa72051451400514527bd0014c7200eb4e3595792969cae7e55ed58d7a8a9c6e5c21ccec79f6a79fed6bc3dfcd6addf0cc216da6988e1db0a4fa573d7ac3edb72dff004d1bf9d763a4c1e46990a1e0ecc9fc6be7a0f9a6e47a4f48d8e7351f86da26ab7f2de5d4b78d348727f7bd3e95963e197852eae64b6b7d4ae3cf8c7ef228e55665f72315db6ad33db68f793443e748988c7d2bc23c1d75341e2dd3268dc99669d4487fbc18f3fcebb60db411526b467bae91a4d9e83a647616819608fa076dc6affad23a8742add0f06a0b37262287ac6db6b264199e2ad2aff58d18dbe9b766dae438657071d2bceaefc13e2b113dc6a5ada4112fde792e4ed1fad7b076c57987c5eb9940d36cf2df6790b3b0fef11d2b483bb2a0ddec8a9a67c37d65e48aea3d715622430961959b70f6e6bd42e6d9a4d2a4b72c5dbcada1cf5271d6b87f84b7334ba25f5bbb131413831fb64723f41f9d7a175c8a555df409b77b3382b16ff4eb43ff004dd3ff004215eb01c051cd794106df51c7431cc31f83577a643205666c9c0a9c1d6f6574655e9f3346e0208cd2f5aa7612978ca9e48357057b74e6a71e6470c959d85a28a2ac41498a5a28010d62de8f2e690fb6eada22b1bc43fb9d3669c1c32a62b8f171bd36cd68bb4cf3bdbf6aba207fcb590fea6bd031818ae1f485dfaa5b0ff681aedcf5af168ecd9df3ec3644596368dc65581523dab92d1be1e699a2ebada9c734b2ed6dd142c384aebe8f6ed5ba6d6c4ea06a95abe6feed0762a7f9ff00855a96458a3691c80abc9359fa5132cb77738216461b73e83ffd748696869d62789fc3169e28d3c5bdc48d1488dba395064a9adbfc68a69d84bba327c3be1fb5f0de942c6d599f2dbda46eacd5ad4629686ee1beace1f574f2f55b91df76eaeb74f9c5c58c327aaf3f5ae675f5c6af2e3ba83fa56b7858b4d672c4a09d92715852bfb47145cdda373a8d3948566f535a02a2822f26255a96be868c7960933cc9caeee2d1476a2b52428a28a002b1fc476525fe8f2c50e4c83e60077ad8a61eb51521cf1711c5d9dcf34d06323595475dad183b81ea0d75f53dee9d6c9702f163c4dd091dea0f4af11d1f64ec77a9f3ab8514bdaa1fb4c21caef0187a8a9288b50b637766f0a9c31e41f7a834e9aeb7791716e50a0fbfd8d5f122374753ff0002a52c3fbc3f3a0a4da56145151bcf127de9107e355cea10e76c41e56f441fe340accb94b5142eef1ee78f637f773521a0473dab691797daa2b4083cb6014b96185fc2babd13495d26c4420ee7277337a9aaf17fad4ff787f3adc1d2bb305463772ea736224f61067bd2d14b5ea1cc14514500145145001494b494014eff00983f1acde335b3711f99115ef58d820907822bccc641f35cebc3b56b0535a357e1d437d453a8ae2372b9b1b76eb101f4c8a67f66dae7fd5b1ffb68dfe356e8a0776575b1b653910aff00c0b9fe753aa051855007b0a5a280d45a434514980e886654ff007856e0e9593671799303fc2b5ac3a57a9838b51bb38abbbc85a28a2bb4c428a28a0028a28a00293bd2d2500079aa57369bcef43f37a55da3159d4a6a6ac5464e2f4309e3743865229074adc28ac3900d73dae4af6b7118888552326bceaf86f66b9ae7552a9cef949696b1d7519c75087f0a7ff694dfdc4ae3ba3abd9b3528acb3a94dd910546f7d39538603e8280f652b1b1dea68ada495860617d4d5cb28d0db2395058af5c55bc01ed5e8d2c1ad24d9c53aef643218444b802a4140a0577a4a2ac8e66efab168a28a6014526696800a28a4cd00145579ef6dad8132ce89f8d655c78a6c623fba49263ec30293682c6ee690b05192703d6b8fb8f145e4bc43147103d0b1c9ac5bdd4ee65f2d65b9791e46c28ce3eb50e68a513bdb8d62c2d7892e63cfa29dc7f4ac79ef2db5a2de5875f2ff0088d72f8ebdfeb5ada1b626953d541ae7c43bc19b524e32b923e9f3af4c3d47f63b81ff002c8fe62b6a8af2ac77aaacc6165707fe59e3ea4558874d25d4cac0e3b5690fad1d29a44ba8da2ac5e278a0630bdbbed5e32a455d8bc51a6b90af3346c79c329ae3643995cffb554f502f15bfda635cb5bfcfb7fbc3a91f8d7b1193e5479f28ea7a745a959cdf72ea227d378ab21830c820fd2bcc519248d2489b746c372907b54a93cd19ca4d22fd0d5fb4ee4b89e95466b808f5ad4a33c5d337b3735723f14dfa637c70bfe6bfe355ce85cacece8c8ae5a3f178cfefac9c2fac4fbbf9e2ba482413c2922e40750c33ef549dc4d58c6d77599b4d9238add232cea492f5cddc6ada8dd7facbb60be91fca3fc6b43c52f9d4e31fdd8ffad625652932e3103973b98963eac7349452f5efcd41418c9acbd3a6fed1bfb8bf1cdbc4c60b7f7fef37e951f892fe6b3d392decdb17f7afe4dbe3ae7bb7e15a36767069d650d9db2e2185422fbe28193f7ab361796f6173e65cca238dbe4cb74aad593e26884de1dbb5233b5777e54a51525608bb33d114ee50c8db94f71c8a5c62be7cb1d6754d380fb16a373027f71256dbf956b2f8f3c4a830350cfd505734b072e8cdbda9eddb49accd575cd3749849bbba8d1dbe5540d9624f4af19b9f167882f01126af74a0f68e429fcab36d419b54b62e59dda741b9f927e61570c1b5ac98a552e8f5a2771ddfdee69783c37434a78a4adf6d118991a2ca6de5bbd2253f3dab663f788fddc7d06056b9ac0d7d8e97a8e9faeaf1144e20bac7fcf373b413f462b5be3054107208c8340c292968a0421aeff4693ccd22d9bfd8c7e4715c0576fe1b70da1c00755dc0ff00df46b4a7b93339ef11b6ed69ff00d9403f9d6555fd6db76b573ec71fa567d43dca8ec2d1d4d145219c65aeb36179e39bd9afee05b8b3020b48a61b771fe27cd764a77a06465753dc1c8fd2b3f57b0d16ead59f57b7b6312f59240148ff0081579d5f5e69ba44bbbc2de21bd69bb5b63ce8cfb7b531ee7aad56d4e2f3748bc4ebba161fa5733e1df117896f42aea5a09287fe5bafeef1f8735d814f3018cf4605692dc4d1e3ca72052d35015183c11c53ab7109c66ae694bbf5ab05ff00a7843f9366a9fbd6c785e1f3bc476a08e13731fc14d296c07a537de2690024e3049f6aa5aa5e5dd9db192cec1af653fc01f6d79cea9e27f124d77e4ea7e768d679c16820dc47e26b1292b9e81aedc69a9a4dddaea5790c49344c9cb64838e38fae2a9782f536d4bc3a824de5edd8c5b9971e628e8d593e1ed3bc1b713a3c578da9de9e737b26e6cfb2f4aed555635d888a8a3b2a80280614b45141215d77851c9d2dd7baca6b91ae9fc22ff25d27a306fd2ae1b8a5b183a93799aa5d3ffb67fa555a9676df732b7ab9a8ea5ee0b612968a291451d674b4d6747bad3db199908527b376accf03dd4573e17b67482386e221e54c1102b6e1d735d0838391d6b96d294691e38d474de96fa82fdaa0ff007bab0fd6803a92cc4f269578607f5a6d28eb408f26bf8fc9d46e62feecac3f5a82b4bc43188bc417a3b1933f99acdad900574be098b7eaf3cbd44717ea6b9935db781a1c5ade4dfde70a294b603abe474c8fa538331f97ae78c1e69b59fae6a6ba3685797f9f9e28c98c7f79b1c5643473da45adb6a9e3ebfd5618215b7d3d4c1132201ba4230c7dfbd763d6b1bc2ba5368fe1db6b793fe3e241e6ca7d5db9feb5b1d68062d148697bd020adef09be2f678c9c6e406b07bd6b7869f6eb03fda43fa5547714b6329bfd63ff00bc7fad368a293dc685a28a2900878048ed5cc78abf73e21f0d4d1fcb20bb31ee1fdd2ad9145140d1d4b7de3f5149de8a2811e73e2b18f11dc7b8158bda8a2b65b0076aeffc16a0680c71c998ff005a28a53d80e80f435cb78d3f793f87ed5f9827bd512a767191d68a2b203ab93a9a4a28a0188dc2834761451400bdeaf68e48d523c7f75a8a29c77096c7ffd9, 0, 'LD2', 'LD4', 'CVR2', 'LV2'),
('14303', 'Charlie', '1996-03-20', 0, 0, 'Di sini nggak ada', 'charlie@mail.com', '08133', '2019-02-01', '$2a$10$tbiny4jU78WHXSs2WBO8He4FdvBDaSf88g5yRlgzbTJAUN6Fyhk6u', 'admin', 'admin', 0xffd8ffe000104a46494600010101006000600000ffdb004300080606070605080707070909080a0c140d0c0b0b0c1912130f141d1a1f1e1d1a1c1c20242e2720222c231c1c2837292c30313434341f27393d38323c2e333432ffdb0043010909090c0b0c180d0d1832211c213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232ffc000110800d3009f03012200021101031101ffc4001f0000010501010101010100000000000000000102030405060708090a0bffc400b5100002010303020403050504040000017d01020300041105122131410613516107227114328191a1082342b1c11552d1f02433627282090a161718191a25262728292a3435363738393a434445464748494a535455565758595a636465666768696a737475767778797a838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae1e2e3e4e5e6e7e8e9eaf1f2f3f4f5f6f7f8f9faffc4001f0100030101010101010101010000000000000102030405060708090a0bffc400b51100020102040403040705040400010277000102031104052131061241510761711322328108144291a1b1c109233352f0156272d10a162434e125f11718191a262728292a35363738393a434445464748494a535455565758595a636465666768696a737475767778797a82838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae2e3e4e5e6e7e8e9eaf2f3f4f5f6f7f8f9faffda000c03010002110311003f00f7fa28a2800a28a2800a28a2800a28a2800a28a2800a28a2800a4621464d2d2300c3068018aa58ee6fc07a52b360e072c7a52792be87f3a72a05e9400ddbb51bb9239a58ff00d5ad3a99e529edfad0037692cf8ecd9c7e14f5707d8fa52850a30282aadd45003a8a28a0028a28a0028a28a002929aeea8a59880a3a93dab95d63e227877472c8d7a2e261c18edfe73f98e3f5a00eb33466bc86fbe324e6461a7e923676699f07f219ac893e2c788dce634b5887a05cff4a572b959eeb9a335e196ff0016fc430cbba682d665fee91b73f8815e81e14f885a7f8964fb2b2fd9af82eef29cf0febb4f73ed45c4e2d1d9e79c5364242f142f2734fa622ba33eee7a54be60f438f5c52b602926abf01f2492c38c0a009cb81ea4fa0a048bef9f4aae0e005c9cf7e3ad2f1b186738e831d28026320ce3073e98a5de3f1f4a8c0dc42b74c671eb4871d33900e01a00b145145001451450034e73593aff00886c3c3ba7bdddf4bb40e15072ce7d8559d6354b7d1b4bb8bfba60b142849e7a9ec07b938af9d3c43e20bcf12ea8f7b76c4272218bb46bed40d2b9a9e26f1eeade2395d039b3b1cfc90c67248ff68fad72c142ff009e4d2fe94549aa560eb451450014e8a596de78e781ca4d1b6e461d8d30d1d7ff00af4058f43b6f8bfaac1a7ac1269d04d72a31e7994853f55c75fc6974ff008bfac43721b50b2b69edcf510828cbf89273fa579e03c70693140b951f4b689e20d3bc47622e2c67ddc7cc8dc327d4569f94d9ce467d48af9a342d76f7c3ba9a5fd93907eecb1f675f422be89d0b58875cd22defeddc15954640fe16ee3f3a643562f793c6011f434a23c0e4fe5520a2992576ddc0e0e38c1a15198f2471d80e05582a0f5140181c5002d14514005373ed4b55afaee3b1b29eea5388e242ec7d001401e3df163c42d7dab2e890b1305b61e6c742fd40fc3fa579e77a92e6ee4d42f6e2fa624c9712b4a79e849ce2a3f4a46ab60a28a43c7bfd290c5a43c7278fad741a2f82f58d6f124712dbdb1e7ce987f215dee91f0d34ab12b2df4b25ecc3b11b507e158cebc225a836797e9ba46a5abcc23b0b3965cff1e30a3eac7815dde95f0b43445b56bc61211c470f201fad7a2c30456d108ade248900c00a314f393dc9fe95c53c5c9bd0d1533c1fc49e1eb9f0e6a66de625e27f9a197fbebfe358fdb35edfe34d1175bf0f4c8abfbf833244475e3a8af100770cf4cf2457650abcf1329ab011cfd6bd0be136bc6c759974795f105d8df1ae7a3f438faf15e7d52d9de49a7dfdbde4276bc320707e95b90f63ea81d296a0b4b84bbb386e623fbb9503afd08cd4f5464145145001451450025723f126f1ad3c117fb4e0cc3c9ffbeb8aebebcebe304c53c2f0c59c7993afe38a06b73c540c002968f6a43c8a9350fcfd78aef7c19e1ed26368b50d6aea0f3c9cc56cee001e848ac8f05787078835576b8dc2cedf976538cb63815e972f83b47788aac4e8d8e1c39ae2c4d6b7ba8d69c53dcde52a635f2f1e5e32bb7818a7554b0b18f4db18ed6366758c6327a9ab5b8124679af39b7736485f6a4240192401de8ce47b5646aba1ff006c5cc66e2ea5168aa7f7287193ef42b0cd7e31d88e847ad781f8974efecaf136a368176a09d9e3f656391fa1af59b5d02fb49d4a37d36ed8d99ff5914ad9ae2fe295a0875fb6b951813458247a8fff005576e1256958caa2387a43c8c11918e6968c735e8981f42fc3bbd37be07d319db2d1c4223ff01f97fa57535e7bf08252fe137427ee4ec07e64d7a08aa327b8bde8a28140828a28a002bccfe32ffc80ec3febb9fe95e986bcdbe31a67c3b68ffddb8ff0a4c6b73c6a909c0cf3c52d3e088cf750c2064c922afe669376d4d52d4f65f0169a34cf09db060a2e2e8b4cf93c9c9e3f402ae5c78b744b5d6174a9af956e9db68007009e809a7ea1e1db5d4f4db4b5925b9b7781156396da528cbc0e38e3f3af08d66d24b1f105eda2bcb24b1dcb223b9cb310df29faf4af25da726ceda714d1f47fde19f5c77eb5559b66a318ed2211f97ffae9f65bc585bf9872fe58ddf5c54531dda9daa8feeb9391f4ac048b9daa9eabaad9e8b646f2fe610c2081b8f73e83f5ab9f4af39f8bfe67f6569bd7c8fb410de9bb69c7f5a7149b1a57763b8d2b56b2d66c56f2c261342d919c60823b115c4fc578f16ba64bff004d19738f626b9bf02e9de23be86e3fb23543616624db292aac49c0e99070707b574ff12edcdbf85b4885a5694c3304f318f2e421049ae9a31b544456563cc7bd27ad2d27f8d7a6729ed1f077fe45bbaffaf835e8d5e77f07971e18b83eb70dfccd7a255193dc2968a2810514514005703f16e2dfe0d67c6764e9fcebbeae33e2847e6781af78fb855ff2a4c6b73c13357f42412f88b4e43d0ce2b3c722b47c3edb3c47a731e8261fd6a27f0b368ee7d00df788ac9b9f0ce8d79abc7aa5c58c6f7919056423a91d09f5ad66fbd45789768ebe855bf91e2b29248f861c038e9cd32cede3502612349232f2ec73569b6b7c87078e45471db41092d1a8527ae2a469e84d9c555d474db3d5acdecefa049a16eaac3bd23dfc497896c01691fd39c7d6ad8a69d82d62a69da5d9e91629676102c302e48503b9ea4d723f14c67c3d687bfda47f2aee8d70bf14cffc53d67ef723f956f41dea233a9b1e514b8a28ef5eb9cc7b67c211ff00148b9f59dff99af41ae13e12ae3c1919fef4ae7ff1e35ddd5193dc5a28a28105145140095cdf8f21f3bc11ab8c676db3b0fc05749595e2483ed3e1cd461fefc0e3f4a06b73e665fba3e9535a4a60beb6987fcb3915bf5155e2cf94b9f414e2091d71512574d1b2dcfa3a3713431c8bd1d437e6334eae7fc15aba6afe19b560f99e01e4cc9dd483c67f0c57415e2d48f2cda67545dd156f2d0ce44b0c8629d7a30e87d88aa0d26b2c0c623841e9bc56cd18a82d3b19da7e962d5ccf33992e1872c7b568d145026dbdc5ef5c0fc566c68ba6a0ef75fc94d77d5e6df1626ff9065b83c825f1f98ae8c32bcd19d4d8f38a4ec69690f4fad7ac731ef5f0b136f81ad081f79dcffe3c6bb4ae47e19aedf0169dee18fea6baecd5193dc5a28cd140828a28a004a86e62135bc91b746523f4a9a9ac3208f5a011f2a6cf299a33d518a9fc293fcfd2af6b507d9b5fd4a0c63cbba917ff001e354a91b234f41d7aefc3da80bab56dc8dc491767ff00035ecda1f88f4ef10db2c96726d971f340fc32ff008d78374c7f4a7413cf69389eda578655e4321c573d6c3aa9aa2e32b1f46f4ce4515cd787758bab8f0f584f74de74b2420b391824e7dab606a71e3946af264929347528c9aba2ed2e33fe1541b534fe18d9bdba579f78bfc6fabdb6a7369d652476d1aa8cbaae5b9fad55287b4764295e2b53b5f1078a34ef0edb96b87124e47c90272cdf5f4af18d6358bbd735192f2f1f2c4fca9da31e82a9cb2c9712b4b3caf2c8dd5a46c934caf5295054ce694ae2d21e99a5a6b7ddadd107d0ff000ed3678134a1eb083f98aea2b03c0e9e5f8234618c66ce23f9a8ae82a8c9ee18a28a281051451400534f4a7521a00f9bfc6b1f93e37d5d718ccecdf99cd617b5757f1323117c40bec0fbe919000e49da2b36c3c23afea8a1edb4e90467f8a42147f8fe948d56c6303c73c521e87dfa577767f0a35b9883737b656e0ff0ab339fe42b6ecfe14e96370bad526b82bc32c4813f0ce4d16760e645cf0cdac87c1fa54a8a4868067d4726afe187055ff235b167630699650d95b2958215d880f3c54c1413d33f8578738bf68cefa75b963a986904b2b0c21fa91d2bce3c67a1ea91f88aeae4585d35bb11b65442ca7f2af6954dbd71f853b713c1e47bd7a185c33a7ab39abe239dd91f33b300c437cade8dc1fd69def5f44de691a66a208bcd3e097dd979ae72f3e19f876eb2d0acd6ae7ba1dc07e15d9ca60a478cfe5f9d35bee9aeeb5af85faa58ab4fa6dcc77b0af543f2381f4e41fceb879e3921768a58d9255386461820d161dd1f4b7851767847465f4b287ff4015af59fa0a797e1fd393fbb6d18fc945681a666c296929681051451400521ef4b514cc561723ae280399bbf0e69973e267d6ae2113dc040b187e554818ce3bd69e70a00c003b0140e94530b915c4c2dada5948cec5247d6b06c61bdd3b66a13b978ee4e674fee6e3c1f6ae8880c304023d0d07e6054804118c1e847a55260308de415fbac33f8567ddeacb09682ca13737206481ca8ad231a18bcb23e4f434448902048915101e145631a308cb9994e6ed62b6997cb7f66b281b5c7caebfdd61c1ab758b342749d5c5ec43fd1276d932e38527f8ab6b0074e86b66880a28a290c071d09fceb98f16f832cfc4b6e6545583505e92a8c6ff661deba7a2863b9a1629e558c119c0291aa903a702ac551b3970de593c76abd5220a28a2800a28a2800a82e7fd43fd2a7a82ebfe3ddfe94019d451455005145140051451400d9116589e3906e8d861852aa8450a3f84600a5a4a005a62bee90af6a495f6ae075351464871401668a28a00546d8c1bd0e6b594e467d79ac73d0d6b47fead7e95203e8a28a0028a28a002a1b91fb87fa54d54ef64db185ee7b5080a63a514993fdc6fca97391c5500521651d48fce96341231058f1d854eb1a2f4514015c329e847e74b53b468dd5454324463f99492bdc5002526e5eb914a8a249003f771934f9911936600a00a4edb9b9a45e1b3483a73d47145005ca29074fc2968013d6b5a3ff0056bf4ac9ec6b5a3ff56bf4a4c07d1494b48028a28a002b32fc9170828a29a01cc7e53f4aa0aedb7ad1455002c8e275f98f348f348d2302e719a28a009a091c4aabb8e0d5d2063a51452029212aeb8ed9a7ccc4231cd14500525fba29d4514016bb7e14b4514009d8d6b47fead7e94514980ea51451480fffd9, 0, 'LD3', 'LD4', 'CVR3', 'LV3'),
('14304', 'Delta', '1997-04-25', 1, 0, 'Mana tau di sini', 'delta@mail.com', '08134', '2019-02-01', '$2a$10$1u0zBb6E1gvb82fRaSCdjOVd3C.FQsEyKUye1BrVf8wuS.SCfJ0G.', 'admin', 'admin', 0xffd8ffe000104a46494600010101006000600000ffdb004300080606070605080707070909080a0c140d0c0b0b0c1912130f141d1a1f1e1d1a1c1c20242e2720222c231c1c2837292c30313434341f27393d38323c2e333432ffdb0043010909090c0b0c180d0d1832211c213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232ffc000110800d3009f03012200021101031101ffc4001f0000010501010101010100000000000000000102030405060708090a0bffc400b5100002010303020403050504040000017d01020300041105122131410613516107227114328191a1082342b1c11552d1f02433627282090a161718191a25262728292a3435363738393a434445464748494a535455565758595a636465666768696a737475767778797a838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae1e2e3e4e5e6e7e8e9eaf1f2f3f4f5f6f7f8f9faffc4001f0100030101010101010101010000000000000102030405060708090a0bffc400b51100020102040403040705040400010277000102031104052131061241510761711322328108144291a1b1c109233352f0156272d10a162434e125f11718191a262728292a35363738393a434445464748494a535455565758595a636465666768696a737475767778797a82838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae2e3e4e5e6e7e8e9eaf2f3f4f5f6f7f8f9faffda000c03010002110311003f00f7fa28a2800a28a2800a2933cd2161eb400ea3359179e26d12c18add6ad671b8eaa665c8fc33598df117c2aa7075880fd39a02c753457309f10fc2d21c0d62dc7fbc715721f17f8767fb9add87e370a3f99a02c6dd1552df55d3ee982dbdf5b4cc7a08e5563fa1ab79a00334b4d04669680168a28a0028a28a0028a28a0028a28a004a2969a7ad0062789fc4b65e18d31eeee8967e91449f79dbb7e1ea6bc37c41e33d67c452389e7782d89e2de26381f5f5a97c77ae3ebfe28b860e4dbdbb18a25078e3a9ae6fb9f7a4cd121bb573923f5cd1b46300629d452284c0f4149b54f18a751400dda010433023be4d753e1cf1eeafe1f9635791eeec870d0bb7207b1e99ae628c668158fa5b48f11e9dabe9316a30dca242e39123052a7b83ee291bc51a12cbe51d56d37e718f301af9ac48eb198965956227714df819fa533cb5fee8c53b8b90faaa1b886e2312432a4887a323023f4a9857ce9e0df15ddf86b5688195e5b0908496166ce01e8cbe95f444522cb12488c191c06523b834c86ac3a968a2810514514005252d1400954b56bb363a4de5d0ff009630bbfe433576b1bc5a09f086b00673f6397ff413401f34a12c819b927934ea6a7dda5e7b549b0b451fad212072781ef400b45229de42a02e7d1464d685ae87abde902df4db97cf7d9b47eb8a4e515bb1d8a1476c575969f0e3c45738f323b7b653de49327f406b6ed7e1474379ab01ed1444fea48ac9d782ea351679b9200ea063de8c77e33d335ecb67f0ebc3f6db77c325c30ef23707f0af3ef1be8a9a2788585bc612d6e17cc8801803d47eb4a15e3376437068e69865187a8afa2bc017cda8f81f4b9dce5d63311e7fb8c53ff65af9dfb57b8fc2390b782d133c24f201ff007d13fd6ba1194cef45149da814ccc5a28a2800a28a4a005aa7aa5bfdaf4abbb7c7fad8993f318ab74879a00f9463042053d4714e3923001249e00eb57f5db23a6f88750b3c63ca99801ed9ad5f01e9f1ea3e2c804abb920532ed3d0918c7f3ace72e557364ae6ce83f0ce5beb68eeb55b992dd5f9586203763b649e9f956a2e8be00d1ae84173751bcd9c113cd9c1fc00aef9b9639ee6b8cb7f863e1d8bed0678a59de624e64620a67d315e63c44a5bb3a6308f53a4b1d3f498a157b2b4b5f2c8f959541fd6b4012060600f415c7f877c3f75e0fb9ba8c5e34da44a418e363968db9fd2bae046deb9f7aca726fa95ca90a4d0481cf4147e3cfad739e20d0b54d7af23b75d4dacb4a09fbc5b73b6476f73e98a9f503a112239215d18fa020d723f1234917fe1b3791ae66b271274e4a9383fcf3f8563df7802ff42922d43c2f7d72f3a38df049270e33cf27ad7a1c90addd9bc13a8db321471f515a424a9c934292ba3e75eab5edbf08508f07313d1ae1c8fcebc6f53b36d3b55bbb26c83048547f31fa57b5fc284dbe06b76fefcb29ff00c7d87f4af622f995ce391dcf6a0519e28154662d1451400521a5a28012a29a6585496a96b33516fdeaaf603358d79f241b2e11e6763c4be255b88bc6734c8084b88d5f91d4f7fe75a9f0a6d375e6a57a47dc54897f1c93fd2a4f8af69f369b7aa3a16898fea3f956b7c34b5fb37870bb0c35c4ad27e00003f91ae79d4e6a3766f156958ed0824103a9e99ae1b57f89369a57893fb2c5a34b046e126995b1b0fb0ef5dbb4ab160b305af00f13e97750f8bef2cfca76926b8dd1e0677063c1cfe35c34ecf73ae114dea7bccc23bbb03b48649132a7f5a669ae64d3e163d42ed3f51c7f4a2c216b6d2ada090fce9100c4fae2934aff009078ff00ae8fff00a19a896e4f42e66a96b1aac1a2e953ea1727f770ae703ab7b55de8335cf78db49b9d67c2f3dbdbf0c183e4f7c67fc6aa0b998b4ea53f08f8e61f145c4d6cf6c6d6e506e552dbb72e7ad75bd3d8d798fc3df0b5c59f887edc671b2288a15284672318eb5e9ec9220f9972077157529db541271bd91e3bf12ec3ec9e27172a30b77106ff00810241fd315e8df0de64b7f87fa6f52cc666c0ff00aeaf5ce7c53b3f3f47b5bd4196b772a7e8c3ff00b1ae83c070483c13a60185051db91eaec6bb2355aa49a399c5396a76b6f70b3af1c1f43538eb59367be3bb08c3a8eb5ac39ade84e528fbc6352293d05a28a2b72028a8f2ebd4647a8a78218641a005aced463242b819ec6b41880326a17532a15c00a7b9acab439e162a12e595cf3af893666ebc1d348832f04a8e31d7960bff00b35697876dc59e99656e0602c233f53cd6e6a3a2fdaec65b7924cc6d8278f420ff004aa30c12412c7900a28c71dabcf9424a1cacea524ddc98dac4d7066750efc6037217e9523c50bca92bc31b4abf75ca8257e869b34e91267a934efde7fb38ac234db347349922c6244724918cf4aa9671a456b1aa31c167c8cf3d49abb0b2aab073d4e6a85de8b1dc9474b868d41c9c77ad5d3d05192bee5b3cf4eb5389d0c596ea7823154e2b78ec2df68932a0f739341b98979049fc2b35cd01be564cde51e9095f75e2acc6ca63f94e71eb59cb771938c1c9e83157a042a198f1bbb55c6527b912b7439ef1869e2f347bb802fdf88903d18739ab9e0f70de11d2d718658002be87bd58d5086c21effcb1ff00d7a934ed29974f8238f688c2f19f4cd6caefdd899dd6ecd1b71bee015e42e79ad01505bc4205118c74ed538eb5dd4e3cb13093bb168a28ad091aac187bf714d3f23823a1fd286e265f71cd12ff00ab3400637b927a2ff3a5660a3dcf4a48bfd50a41ccadedc0a008ee1d96da4664e029cf3ed5916f2acbb1d4e456cddffc79cdfee37f2ae6b4f6db2903a601ae5aef5b1ad31f7b07fa6819c23e3f0a8d7503f6b996584a2c7c0c1ebef57351f95564f461fce97018e7d7bd714e4e1b1d30b3dc482682e1494703071d6a49a558a258d4a9cf72d8a6c4918472c81be6f4aaf78b685a3df6e8473d57355cd2e5b9368f3588ee26468cabbc683239dd9a6c56eb26096675feea2d4b6b059c930f2e08c6d193f20ad362a884f000f4a98b6f590df2ad8a696e228cb7961076e726ac09d51064e4f6c550b8964b99444ac428ea07f8d4e8a100551d28954b2b2050b946e99a4b8919ba8e00f4ae934e1fe810ff00bb5cccc732c87deba6d3bfe3c21ff76bab0aeed985544fff002d7f0a78a6ff00cb5fc29f5da621451450046a096dcc31e828939c2fa9a0c83a2f2695548393c9340089c657d2860436f519f514acb9391d4520900e1860d004370fe65bc91856dcc8474f6ac2b580c00eefbe7f4ae90b2e3391589a9136ec5e352c1bbf615cf5a37d4b8323bd95268845b86e1c9155adae30bb5d5bea0556639dcc4e49ef57e2645895770e063ad7172a9b374dc4b700fdd3670371c8159d7a7f7ca9dc54af75127f16e3e82a93b348e5dba9ede94e5651b20bb6ee68daf970ba0dc3e618cd58b871242d1a1e48e0d62e3f0f7f4ab50dd8c6d9783fde1d0d285ad660ddc9208cc0bfbc1f39ee2a7c3119fba3d4d344a8464383f8d46d730a756c9f4147b38ee3e7762bdc5b329dc9c86ea2ba4b152965129ea17158d64925f5c6e2bb204e7dd8d6ea32a0da4e3935d94636d4c26c77fcb5fc29f51a90d2641c8c5482ba4cc28a28a00318a4a6799c1c8e7d3d693cd39c601f6068024a438ee45304849c0c1f5e6a3620e588078c8a009f62f5dabf953648925428ea194f6c503e58c534c98e0807e949abee0655c687925addf6e7f85b9acdb8b196d537cb1a850719ae95dc91b72a0fd6a86a71f99014f9701b35cd568c6d746b4e6dcaccc10cb8f9714bf95551193232a95f97ab67814ac8c177065651d4a93c579dcf23bbd8aee59c8ee7f5a0b2e39602abac91a45cc6af202793d294324a423a2a93c2b2fad1cfa0bd8a45eb7b296ed43c31a91d326b46df4321834cf91fdd0314fd0a368b4f21d790c7f9d69f98463383f4af468d24e376714e569590b14490a044501476152607a54464c1008049e805233b152a36e7d335d2919130c76c52d451e3736001838e2a4a602d149cd14015b077c63d0f3f9d394e1531f78673f9524f3dadb01e74c9167a167c562dd78bb43b6257ed66461ff3c816fe5405cdb52084c0e79cd373b90633f72b8db9f1fc20916966ec7fbced8cd635cf8cf58998f95225bafa2283fce815cf510ebb016381ef5426bfb384b07b9886cfbc33dabca27d4f51bacf9f7d70e0f632103f214cb59e1b7f3a4b82e415c1e9cd0173d066f1ae94331c026b8918f1b178fceae5beaaba8c419222a3cc20e4e718af2c46f2f6b42cebc64127079aebbc2370d2dadcc6ced957dd9cf273438732b0b9ada9ba6de3923653082339386c1a6476108590846505719cf5ab238ef823be69d8cf2493f535e55787b2958eea7539d15974e8d608c850c71f366963b48849bfcb000ea6ac6de720907d41a6b73c33330f73450a5ed1ec152a38212e355934eb0b8b850a42a96018753dab234df1a3dd8649acd55d79f95fb77ed5178aee0c5a4088101a5719fa035c9594b1c136f90be369181df3c57abcaa2ac8e1e66ddcf41b6f1a6937371e5932c6c4100ba8c56bc5aad85c011c57085c638e98af1ddd1f9d22c45b6ab719ea335334f2b20532c98ff78d0173da629159980604e7b1a9abc496faf2360c97b708c3bacac3fad685bf8a75cb6184d41d97d2450d9fc48a0773d7681f4af37b7f1fea31a8fb45bc3363a90304d76fa36a7fdafa6457823f2c3ff0e738a07738cf88786d46cd4f4f289e7a7535c7e3a575ff00108ffc4dad07fd30fea6b91a0861f8d19a292800aaf78c488601d647e7e82acf5e2a9c47ed3aa4ac3ee42a147d4f5fe940170f19f6addf09ce21d59e3638492239fc39fe9585f5a96d6468eee364243938fcf8feb4e3b8a476d6dac2c97b2452f11b1f91ab641e6b020d099e12f2c9b256e540e71f5ae7f51f89da2f84f549f44d6d6f4dd5b6d0648620c1c328607923b11555e942a47958a9549459dfb1c563de6b0b0de47147f714fef08ef581a2fc44d2fc6776fa668115d8b809e63bcf185555ce0f73eb5b13680cb00314a5e5fe2dc383450a30a6ac82b4e52665f8bee44d7b6f02b02a9187fcf9ae77153de4af2ddbb487e6076e3e9c7f4a86a65b844ac1bcbd471da48f23ea0fff005eacf6aa77dfbb7b69c7f049b4fd0fff00aaae7d282829296929001e41af54f0573e18b6fa9af2c35ea3e0839f0c41eccdfce81a39bf885ff21ab51ff4efff00b31ae4abaaf88073ae5b8f483ff6635cad0261451450015425d38abb496b71242edc919e1aaf554d42ee5b4850c48ac5cedc93d2843440d777d6407dae05913fe7a26055bb4bf82eb1240fca907a5564d30cc44b7b31998f2173f2d5f54544d88a157d074a60cf4fb597cfb486407efa0af09f8f7a6795e22d3f5445c2dd5b8473eaca71fc80af64f0d4fe7e85164e4c4c50fe87fad79afed0240d33445ffa68e7f4ab7aa250bf00f4c31e9baaeacebfeb584087dba9fe55eb5752882d27949e110935e7df040e7e1e63d2e9f3f99aebbc4f7021d11d338695820a16884f738396e11374b34817712c727d79aa4dac5b6edb0869dba6101ab934115c47b2540ca7d6b3c4573a5e5a2067b51c94cfcc056762d04a6fefa2d82dc411960417ea315a49958d413920004d3609e3b985658892adea318a928130a28a28003d2bd3fc0c73e1a8bfde6fe75e615e9be0439f0da0f476fe740d1ccf8f4e7c4118f4807f3ae62ba5f1d9cf8907b44b5cd5026145145020a8e7885c5bbc2dd1875f4f7a9293f0a00a9a74acd034120fdec0769f71d8fe5573daa85d83697b1de27dd6c24bfe35787418e467834c6ceafc1b3e63bbb7ff00695c0fd0ff00215c07ed027fd17435f773fcebaef0b4fe56b6a99c0950ad71ff00b411f93445ef873fa9aabe825b9bdf035f7781675feedd1feb5bfe319f32dadb0fe105cfe3d3fad735f01db7783af57badd0feb5a3e20b8fb46b97041cac6422fe1cff005a4de80f7333d4552d46566db6717124dcb11fc2bdeae33ac48d239c2a8c93e954f4f8da467bd947ef25fba0ff000ad2b0f62dc512c302c483e55a7d14bb5bcb3263e50719a40251474a2800af4bf019ff008a7b1e9237f3af34af49f011ff008901ff00ae87f9d008e67c73ff00232b7fd725fe55ce514500c2928a2810b45145004570ab25a4c8c0152878351e9eccf61133124e3ad14503e869e944aeaf6641c1f3073f9d739fb41f13e883b6c6ff00d08d14535b096e6afc033ff14aea9ed3ae3fef96ab17249bb9589c92e79a28a3a0dee666adcdac29fc2ee370f5e6afe30001c0c0145140c2ae201fd8d31c72261fd28a2908a7dcd14514001af47f007fc80dff00eba1feb4514023ffd9, 0, 'LD4', 'LD4', 'CVR4', 'LV4'),
('14305', 'Echo', '1996-05-30', 1, 0, 'Mana tau di situ', 'echo@mail.com', '08525', '2019-02-01', '$2a$10$E0kEVjg0MOR5Mw5hX2GMXOD2O4Yq5hWahXI0G3NAryUEp0ODTUB/G', 'admin', 'admin', 0xffd8ffe000104a46494600010101006000600000ffdb004300080606070605080707070909080a0c140d0c0b0b0c1912130f141d1a1f1e1d1a1c1c20242e2720222c231c1c2837292c30313434341f27393d38323c2e333432ffdb0043010909090c0b0c180d0d1832211c213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232ffc000110800d3009f03012200021101031101ffc4001f0000010501010101010100000000000000000102030405060708090a0bffc400b5100002010303020403050504040000017d01020300041105122131410613516107227114328191a1082342b1c11552d1f02433627282090a161718191a25262728292a3435363738393a434445464748494a535455565758595a636465666768696a737475767778797a838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae1e2e3e4e5e6e7e8e9eaf1f2f3f4f5f6f7f8f9faffc4001f0100030101010101010101010000000000000102030405060708090a0bffc400b51100020102040403040705040400010277000102031104052131061241510761711322328108144291a1b1c109233352f0156272d10a162434e125f11718191a262728292a35363738393a434445464748494a535455565758595a636465666768696a737475767778797a82838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae2e3e4e5e6e7e8e9eaf2f3f4f5f6f7f8f9faffda000c03010002110311003f00f7fa28a2800a28a2800a28a4a005a2928a005a293346680168a4c8a5a0028a28a0028a28a0028a28a0028a28a0028a28a0028a29b93da8002706b96f1278f348f0e3186690cd758c8823ebf8fa567fc47f16b787b4e5b5b3602fee810a47f02f735e16c5a47692573248e7733b9c963f5a4ca4ae7a35f7c63d5a666163a75b409dbcd2cedfa1159127c4ff0015b9dc2eadd3d961ff00ebd72268a45f2a3ad5f89de2b4c1fb5dbb7b343fe06adc3f16bc4d191be2b0947bc6dfd1ab86c52d01ca8f4687e326ac8e3cfd32d245ee236653fa935d5e81f14f48d5e64b7bc8db4f9d8f0b23ee53ff0002c0fe55e1dfca90a86e0807ebd28138a3eab460ea19082a79041cd3b35e11e16f88d7be1fd35ecae6296f634ff51b9b2501ec7be2accff17b5e91f315ada44bfdd3934d13cacf6ecf1d69d9af31f0c7c558f50bc8ecf58b74b691ced49d4fc84fa73debd301cf4a62b0ea292814085a28a2800a28a2800a6d3a9a7ae2803e74f1d6a4754f195f4b925236f2501ec0573ddea7bd732ea375213f33cac4fe755fb5235485a28a3fad218514668a002838ef49b87ad2a8673844763e8aa4d26d0087be7f5eb4bd38e07a56b59f85f5dbe50f6fa6cdb4f219860543ac6897da15ca5bdf22a3baee1b4e734b9e2dd931d8cd238eb8eff8d7d0bf0f7586d63c1f652cac4cd0830b927aed3807f202be7ced5eb7f06ae49d3f51b52721260e07a640aa44491ea43a50281d296a8cc28a28a0028a28a0029a69d4d3401f2dea11f93ab5e467f86661fad57eb5bbe34b4fb178cf538b180642ebf43589144f3cd1c510cbc8c1540f5a96d2d59b21a88d2c8238d1e490f45452c4fe02b6ad3c1fe22bd6f934a9e353fc5226cfe75eb3e1af0cda78774f8e35457ba2019653d4b7703dab9ed6b5ef194dafdc69fa2e96ab043d25931871f53d2b89e29bba89ac695cc4b4f85dac4bcdcdd5bdbafa0393fa715b769f0af4e4da6eefae263dd57007f8d59f0cf8c6f6ef567d175fb1369a80198d87dd947b5769cf7ae7a95ea2dcd153473f69e07f0ed990574d8a461fc52e5ff435b76f6b6d66bb6dada1847fd338c2ff0021535656bbafd8f87ed16e2f19c96388e289773b9f402b2e79cba8f9574354b31e492715c57c4bd27ed9e1f4be8933259c809c0e4a9e0ff307f0aa527c4ab9b49165d43c37776b62dc09d8f2a3b6476fcebb6536bad693fbb6df6d771614fa822aa1cd0929314a3a1f3d6780474af4ff008324fdb7551db6a9af39d42ca4d3b53bab19061e172a3f9ff2af4af8329f3ea927a951fcabd78bd0e59687ad8e94b49da96acc828a28a0028a28cd0014868dca780467eb55af25314595e09e2a2a4b96371a57763c5fe2dd9f91e2b82ec0e2e60c7e2bc7f5ae7bc1d6a6efc5fa6a638493cc3f415db7c56b66974ab0bd249314db09f620ff00502b9af874b8f14a4a7a05dbf9ff00faab07579a9b91bc62d3b1ec6c7249f7cf14d690281bdc0e71c9c53fb1e31debc5fe27ea3733f8afec5e6b2436f12b4601c7cc7bfe95e6423cc75463cda1ebb75670dc62568d7cf407cb9001b97e868d3e769ed159fefa92af8f5071593e09bf9b53f08585c5cb169082acc7be0d6969e365c5e47d84b9c7d403fd6a65a32ba345ef6a8a5b5b69a48e49a08dde324a338cedcf523f2a94551d62edec746bcba8c7cf1c459685abb13e44d796d6ba95b4b677291cd1ba90e879ff00f55163656fa6d943656abe5c10a844507a015e1be0bd5af21f19d94fe7caed7b36c9817cefdc7049fa66bde8f5c7bd54d388e5171d19e49f13ac3ecfe2182ed570b751738fef29ff00022ba6f83483ec3a949eb3019ff808a8fe295b2cba05acf8f9e29f83ec473fc851f0a9dd7c3f7c14e035c1e47d057a34eaa8d2bb396706dd8f56073de94564daceeb3052c4827bd6a8ada8d55515d18ce0e0ec3a8a28ad882320c7c8e57d3d286f9980cf0467eb4fed5181c7071b4e066801c50118c7d2a95f65add49e70dcd5ade48c640f7cd12c41e164f6aceac79a0d1507692383f1d5a7db3c197ca065a20b2afe0c3fa135c2780d7cbbdb598f0649f1f863fc735eada8db19b4ebbb56ff009690bae3d7835e63a0c26c66b288f0639707f3af3a32b41c19df08a94ae7a74ef30748e08c316e4b31e05723e2cf009f125f437d1ddadbdc6d0937048651e9ef5db77c0a4dca0e372e7eb5ccae9dca4edb15348d362d1f49b7d3e124a42bb7247deee4d36c8ffa5de9ff00a6a3ff0041157b3c715822eae74fbdb80d6cd224926e04526f5bb1c56e6f5473c29716f241272922953f8d4367732dca92f6ed10ec58d5aa2e2b5b73cff46f872ba16b91ea4b3fda5212c638718c7a73ed5dec5219230c6368c9fe16a7ff004eb463f03da86dbdc252bee727e3e5136950c1fdf66fd00aabf0bd36f862624726e1bfc2acf8d1f0f64bdbe73fcaa6f025bfd9b41957a2b5c48e3e9b8d74737eeec2946c933aa806e9a3c7ad6d2d6758c3f3f9a4118e05690aecc241c61af538eb4af2d05a28a2bacc46b30514cdb85407a93cd3950039272686ea9f5a000aa80781d3d2910e557e94f6fba7e94c4fb8bf41403192408c092a09c578c4c426af211c6d9cff003af6b7fba7e95e257a48d46e08ff009eedfceb8f131495d1db836db675de2ad566b4862b681ca34a32597a815cd8d2b527119f9f7c9d0349f37d6b53c5aa4b69d758ca796013fad74c2d04972b771ca573185c01915c0dd91d29a48e24ff006fe9ad8c5e201df0597fc2ba1d1355beb9d36f2e2ed831841db9503a0cd6c95bc5fbb2c6e3fda5c531bed9b4a986dc86eb873cfe953ce84e5738f3e30d41871e4afd055793c49ab4e36fda8807fb8a01fd2baf362fd05a5927e24ff4a9574f931f3ccaa3d234c7eb4f99762938a38617fabc2566fb45d019ce5b76d3fd2bb7d0b533a9e9cb2b80251f2c807ad55d745be9fa2dcca066475daa49c939e29be12b492db49dee0af9adb80f6a6ecd0a4d357464f8d1b37f6abfdd8c9fccff00f5aba6f03c11c9e1d84b28cef7ff00d08d729e3070daca0feec23f99aec3c0bff22d45fefbff00e846bab0d14dea655db548e954003814e1494a2bd04ada1e70b4514530186400e0027143104a11d33fd2970a83b01518fbc319db9e280256fba7e94c5fb8bf414e6fba6913ee2fd05000dd0fd2bc4afbfe42173ff5d5bf9d7b6b77af24f1569ed61afce36e239c79887f43fcbf5ae6c4aba3b30924a4d1bb7d026ade114643b9a38430c7a81c8fd2a5f0b6a4b79a6a5bbb0f3a218c67a8f5ae5b4cd6eeb4b0c9190f037fcb36e9cd528ee25b7bafb45b131386caede83dab8396e75fb37a9ea7fe7ad1c57150f8c6f5102c90c7237f7b18fe5527fc26771ff3e91fe66b3f66c9e491d8f1f5a47912342ecc02819249e95c71f19dcf6b48f3f8d65ea3aedf6a2a6391f645ff003cd3806854da0f66cd7776f146b623507fb3e03c91fc5ffebaeb9515155554003a63d2b83d37c4274bb310416719eecc7ab1a9aebc5d7b3c2d1c3147096e0b0eb8aa7160e127a153c4b32cfaecdb390aa133efd7fad773e05ff91660f777ff00d08d79961e590004bcaed8f724d7b06816074ed0ed6dc8c32a02c3d18f27f535d9868bb99629da0a2698a514014b5dc79e1451450033cbc9cb1cff002a565c818e08e94b914640a0066d90ff0018c7d29c06001e8314d32609000e3de9e3919a004ac7f1068516b765e5361655e636f435b3486a64949598e327177478bea3a55f695314bb81940e920e55bf1aa4083d0e6bdc258229d4acb1aba9ea1866b0754f0b690f6b2cbf650ae01219490457254a1cb768eea78bbfbad1e5b9ff0039a5fc6ba16f0fdb30ca4b2afd706a2ff84754fddb93f8ad71fb58dec771874739e6b6ff00e11df5b9ff00c769ebe1e880f9ee1c8f40287562348c1e9d69638de790470c6d2c87a2a2e4d771a178634bb891fcf89a6dbd99b83f9575f6ba5d9592e2ded913dc0ae9a74b9d5d1c95715c8f94e4fc2be1292de55bfd417f7807eee2ebb7dcd772070314dda31d29e3a576c20a2ac79f3a8e6eec4a5a28ab2028a33450056071bb8048ed8ef9a1416007524679e71f852a91952463d4e3a9a56565e99e3a114009800e3001c8ce3d2a7a83048fbad9ce73c54573a95959a96baba862c0c9dce05016bec5ca2b92bef88de1eb30765cbdcbe7eec31b7f3381fad735a8fc5672a7ec3a715ecaf33007f219a9e64528499ea26aadf3c22ddd64915778c0c9c66bc5af3c6fe20bece6f8c0a7a8846daa3a5cb35c7886c649e67918ce325d89cf5a96d49729a2a6e3ef33d3e5d3a5424c6032feb5018261ff002cdbf2ad51315620f4a9c10c322bc9ad86953675d3c52968617932f41137e552259cee788f1ee6b64f4a85e624e13a54d1a0ea3b22aa627916a476fa9699a0155bebc8e1694f05c800d6cdbeb3a65de3ecf7f6d2e7b24a0ff5af2ff88232b619f7eb5c41453c74247635ea423ec9729c9cbed7de3e950c08c8c629735f3858ea97f6ebfe8f7d7113a128db2423df35b56be35f115a608d45a4f69be6ad14c97459eeb45790db7c4ed5e23fe916d0cc3d8edad7b6f8ad6e71f6ad3675ff00ae4437f3229f3a25d291e8f495c85b7c4af0ece3f7b3cb6e7d24889fe59ae834dd62c35789a5d3ee527453862b9e3f3aa4d321c5adccdf11789acbc331c4f751cced29211500e6b8bbdf8a97b2022c74e8a2ff006a672ffa0c53fe2acbfe9fa7c59ff9665f8fa915e7fcfd6b394fa1bc29a6ae6d5ef8bfc417f9f3751748dbf8210147e679ac79249666dd34af21f576269b466a6ecd945213a1e0557dde7df6c1cc708f9bddbd3f2c7e74ebbb816b6af29ea3851ea4f149630b4168a1bfd63fcee7dcff009148658fff005d5dd17fe43b61ff005d8551f7abba410bae5893d04c29adc997c2cf59ba984104b27f77a67b9a5d32f45d5b838f9fa32fa1aa5aa07b9963b58f927e66c76a12d24d3e6596162c9c0715d35a929d3b1e6539f2cee6bccdb233938cf19acbb4bf17571320e029cae3b8ef525f3497a44101da8402cdede9545ad4e9f771cf11cc44ed6f6a8c2d1f670d4ac455e796860f8ffeed8fa64d7175d778fa6dd7d6700390b1eefceb91ed59d4f899db417b88a92b8b6bf8e43feae71e5b7b30e47e793f955ac11c1a82f61fb459c918fbc06e5f623a1a2cae3ed56714bfc58dafecc383fa8a83627a5a28a004c03dabd17e14cc04fa8c03b857c7d38feb5e75dc576bf0ba5d9e25b9427efda9fcc32d547733a8bdd1df1464dde23b45feedb73ff7d1ae26babf88d26ff18489fdc8947e80ff005ae5294b71d3f8428ea714527f2a459952cd1df6b696e5d7cab61bc8271b9bb56b60f5f5ef54eeb4db3bbcb4b16d61fc68db4fe75957066d2b26df554913fe794a327f3a00e873525b37957b6d21e36ca87f5158161e20fb49092da48189c6e8c6456d671b5c71820e71cd09ea296c7b4281f7c01975049a70181815059bf99a7dbbff007a307f4a9ebb51e5496a26d1d80a0a86054f2a7839a5a0633cd0c56d4f33f18cbe6789a7407e589117ff001d1583c74abbadcfe76b9a84c738f3580c0ce4038fe95cb5f7888c19486d24c8e3749c0ae393bb3d4a6ad148dd00f1c74eb5956d2c76dae5c5a875293e2450a73b5b1cfeb54e059756506eb568d54f3e543c11f89ad7b5d3ad2cc830c4370ff968c7731a459679ef4b4628a004ae9bc013795e31b719c0923753ff007c93fd2b993d0d68e8173f63f105acdd369704ff00c00d35b933d8d0f1ccbe6f8cefcff74aafe4a2b9fad4f13c9e6f8b3556ce7170cbf91c7f4acba1ee10d828a28a45115cc3f68b5962fefa119f4acad0ececa4b225ed636b88dca3b30c9e2b6b383ed59508fb1f88248ba477681d7fde1c1fe9401a8b85e115547a28c5079073477cfbe28ea28067ace83279de1fb07cf263c7e44d68d61783a4f37c316e07f03b27eb9feb5bb5d91f84f2ea7c6c2993388ede590ff0a134faced7e7fb3e817b2e7044640a25b131d6491e50cfe648f2679762c7f134d650e36baab8ff00680348a30a05387615c6f73d55a2b185ae595a08a2486da35b89a4daa5060e3bd6d451886148864ec50b93df159b09fb66bf2dc6731da2f969e9b8f26b57f4a061451450021e8691a4688ac8bd54e7f3a75325198c8f7a109ec5fd6ce7c45aa13d4ddcbffa19aa67ad145011d83bd145140c0f4acad6be59f4e71c379e79a28a00d66eb49451401e89e0324f875f3dae5f1ff7cad7483b514575c3e13cbabf1b17bd60f8c091e1a9f07aba8fe745144fe10a7f123ccc76fa5231c239f44247d714515c87a86768007f6507fe2791cb1f5e6b4e8a2800a28a2800a43de8a28067ffd9, 0, 'LD5', 'LD4', 'CVR5', 'LV5');
INSERT INTO `tb_m_employee` (`id`, `name`, `birthdate`, `gender`, `marriedstatus`, `address`, `email`, `phone`, `onboarddate`, `password`, `securityqestion`, `securityanswer`, `photo`, `isdeleted`, `birthplace`, `hiringlocation`, `religion`, `village`) VALUES
('14306', 'Fox', '1996-05-30', 0, 0, 'Eh di sini rupanya', 'fox@mail.com', '08525', '2019-02-01', '$2a$10$rT0FmmjWF5rJaWSI2Ipmm.KNTvb22RspMGshYmy30IcleXGBXdMoW', 'admin', 'admin', 0xffd8ffe000104a46494600010101006000600000ffdb004300080606070605080707070909080a0c140d0c0b0b0c1912130f141d1a1f1e1d1a1c1c20242e2720222c231c1c2837292c30313434341f27393d38323c2e333432ffdb0043010909090c0b0c180d0d1832211c213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232ffc000110800d3009f03012200021101031101ffc4001f0000010501010101010100000000000000000102030405060708090a0bffc400b5100002010303020403050504040000017d01020300041105122131410613516107227114328191a1082342b1c11552d1f02433627282090a161718191a25262728292a3435363738393a434445464748494a535455565758595a636465666768696a737475767778797a838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae1e2e3e4e5e6e7e8e9eaf1f2f3f4f5f6f7f8f9faffc4001f0100030101010101010101010000000000000102030405060708090a0bffc400b51100020102040403040705040400010277000102031104052131061241510761711322328108144291a1b1c109233352f0156272d10a162434e125f11718191a262728292a35363738393a434445464748494a535455565758595a636465666768696a737475767778797a82838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae2e3e4e5e6e7e8e9eaf2f3f4f5f6f7f8f9faffda000c03010002110311003f00f7fa28a2800a28a2800a28a4a005a29bde8c8f5a007514de28cd003a8a4a43400ea29072296800a28a2800a28a2800a28a2800a28a2800a290d19a0033505c5dc56b0b4b3c8a91af5663c536fafa1d3ece4bab87091c63249af17f11f892ebc41764bb347668711c59e1bdc8ef58d5aaa08da8d27519d6eaff0012d51de2d2ed965c1c096563b4fe03fc6b989fc6fe229dc9fb6ac43d2388607e79ae7c0e3fa518ae09569c99e8468422b637e3f1b7886220fdbc38ff006e35c7e95ab6df13355888173696f328ea63dca4fea6b8cfc4d1f89fc4d255a6ba8dd083e87a9e9ff1274e9d825e4325ab1f53b87e7c575b67a85adfc225b5992543dd4e6be7ec7f93566c6feeb4bb813d84ed03e72421c07fa8ef5b4314d6e6153089abc4fa097a52e6b82b4f89360ba623de4720bb030d1aa9e4fd6a11f14adcc9ce99384cf62335d5ede1dce5f6153b1e874561e89e28d375d43f65997cd1f7a263861f856d06cd6919296a8c9c5c7463a8a4cd2d50828a28a0028a28a000d21341a86ea75b6b596773f2c6858fd00a4dd95c12b9e65f1135bfb55ea6950b66284ee9b07ab761f873fa570f8c0c0fcea6bab97bcbd9ae6439795d89350d793524e526cf628c146290bf8628a28accd428a28a041498cf5fca8a370f5a0007b71eb463f1353436b7172c161824727d16a37478a468e452aea70c0f634c134f61d04f2da5c2dc5bc8d1ca872ac0d7b378535f5d7b4a594e16e233b265cf46f6af16cf22ba3f03ea874df11c51b1c45747cb61db71e87f3c56f42a38cacce7c4d3528dd1ece2969a0d2d7a67962d14514005145140087918ac2f185c1b6f0aea0e0e098593f318ade35cbf8ff3ff00088de63fd9fe62a27a45974fe2478d8e07e1d697a520ab1636536a17915ac032f21e4fb7ad78e7b3b158b28ea707dcd5982c6f6e8ffa3d9cf2e7bac648fcebd3f4cf0fd868f6f958c492aae5e56192c7b9ae2dbe2a5d493c8d63e1b9e6b443832e486fc8291fad0b532751f421b6f086b570031b6110ff006d80fd2b56dfe1fccdf35cdf2afa88c1feb5d1f877c4963e25b237366cc190ed96271f321fceb67ad4c9d887391cc5b781b4984832f9b39ff6988fd056b5b685a5da81e5585b823b9404feb5a3595ad788b4ad02157d46e42171958d46e76fa01495d89b66a28d800501476c74af3af1be9df65d563bc44c25c8f988ecd5bba578ff0042d5af56d23926b79dce152e23299fa55ff15587f686833803f7917ef147b8ebfa669eab708b699e59d0faf34e8666b79e1b8438689c383ee0e6980e569aff00eacfd2ad3d51d0d5d1f4444c1e1460720806a515534e0469f6e1bef7963357057b11d8f15ad58514515420a28a28010f4ac0f1a41f68f09ea0a3f8622ff973fd2b78b0c751f9d50d4bcb92ddade450e92295653dc1eb59d59251772e9df98f9fe7996ded249d812b1aee2073507867e26689a56a4f75716b76ff00bbda360cedad9f115b46baa6a76d12058f2eaa8bc01c543f03ecb4cbbb1d72daeec6d6e2782e14e67855c852081d47a835e7d350706da3beb4e4ac975367fe179f86f39fb15ffe282a38be35f85618cc71e9778887aa888007eb5e823c3fa21eba269bc1ff009f54ff000af13bfd797fe12b7bb8ac2c56d229b60b716c9b4a67bf1cd11749ec8ce309cba9bd61f15bc13a5de5d5e59e937f0cb758f3768e38ce3f99ad05f8e9e1b6e4595f1ff808a7fc526d1f49f87fe6db6976115d5fed488a5b22b004649181ee3f3ad9f0178474bd3fc11a525d6976935ccb02cd23cd02b365fe6c1247bd5354b9399a325cf7b5cc2ff85e9e1a0769b3bf04f41b47359f2fc53f044faaff0069cfa3df4d73b02ab4ab90a07a0fc4d33e3268567a50d13c4165616f1476f72239a38a20a8dfc4370031fc247e35d378a6e348b4f03c3ab58e91a689af110238b543b4b0e71c76a76a518a925b8e2a6e56b9c86b9f10fc0dae3dbc92e9da8dbcd03aba4b046aadc1ce0f15b8ff001bfc352c2f1b596a05594a9ca0e73553e1a4f69a85d5c69ba869f6370427991b496a8587a8e95e94340d1370ff00892699d7afd923e9f9544a54d68d1a4a134ed73c161f18e9b7b7eb6d041701a490840c00e0d7456f6c6eaf60b4539334ab183f538ac0f12da5aafc63b886d208a28add549489428071e83eb5eabe0df0fc423835a95b7ca798d0f45a2aa845a68d6139723b9e9912ed8d47a0c54b54aca7690157ea3a7bd5cc815e8539a946e8f3a49a7a8b45377aff00787e74a083d0d6848b4c938434e0ca7a1a6c9feadbe940082342a0951597779f3bf135ac3ee0aa37316e8cb8fe1639fa66b9f111728686949da478aebaf9f115fb67fe5b91597f0c67ff00846fe236aba45f1f27fb4115e32fc06ea47fe847f2ab53b7daf5491faf9d375fa9ae9fc73f0f62f14dada5e69f39b4d62d23548e41c2c800e33dc63d6b8a8c92bc5f53b6bec8eddaec8b9f29217720fcc78007f8d797defc32d4a7f149684c5fd9d24be6162f82a33f771fe7a55383c51f15b45516771e1eb7bf11fcbe7b42c4c98ef90c33f953a6f137c56d7616b1b7f0fc1a72bf06e12260547d598e3f2a6a838b7ef2b19aad6d883e20c91f89fe20687e1bb572f67a72813488321589e47e4abf9d7b040cf313205f2e3fba89e8074ae37c13e1d87c31118351d8fa94dfbc9676e77b1ebcfe55dcef00f07af35956a9ccd456c8d147975303c71a30d7fc15aa586dcb98bcd8f1fdf5f9863f223f1af3ef041ff84cbe174de1e3205d4f4d9f0a8e7071d41fccb0fc2bd7c3aa9f518ee2bcafc4bf0ef57d2f5e6f127822e4c771212f3da93c13fecfa83e87f3e6b4a2d4a3c8cca578cb991abe08f0bdd785efae6eb53e66957cb8fca05801f9577cf3c505bbdccae1218d4bbb1e800af241e3cf8a31298a6f07db390319f21c67ff001faa9751fc4cf880069fa85ac3a369c4fef4c68c8187e2c49fa6451ec1b77931cab7374d4e7f4749fc43e33d735c8626781e4d88ff00a7f203f3af6cf08798be1d822914aba33020fd49ac7b7f0cd8f85346b4d36c32caa58bc8f8dced85c9e2b6342b80a5edc9efb87e54eb5a6ae8a83b46c74968489c91d979ad4080f24ee3ef54ec230a8589e5aae0460301be5fd6bb30d07186a72557790fda3d29a635ea38fa52794bea7f3a109cb2939c77ae83314a0238e0fa8a6337c8cadc363f3a70250e1b95ec7d29ce81d7068001f745676a72b43a45e3a9c3047c1f43835a40600155a5823b9b59a0946e8e40cac3d8f14a4ae869ea796e95a5dbc17500081dcb8cb3735e9380315c2cfa2eaba2ead6b1a2b4f64d3713af2c8307822badd833d3f1cd79751f268d1dafded516da30deaadea2aa19089bca7705fb0279352c2e776c639f4aad2db4b1f993288cbeeca93e950d292b8a2acc6cf6715efeee48d5fbe7fbb562cb4f8ac976a33b0f47627f9d36d5e6116e6832cc79da41a8ee6f655711a5acc78c9c6dff001a518f2c6eca6dbd0d1e3daa37815b91f2b7a8e2b27ceb86fb964e0fabb8fe84d5bb56bc954aca638c8ecbcf14e338cb4138b433ed24cb240c58489c907bfb8ad1daa57900fe15466b3449567cb17fba493eb4ed8b93f2ff00f5ea5cb91d86d296c66789c0096a40c7ccdd3f0a87c2d019b52772b9445c138ef5a72e9b0dfa05977008c48dbf856bda595bda471c5146157f9d76504a7a9954972ab169955546001cf6a7170bee7d0535805c6d0031e05395428e9cfad771ca27cedfec8a72a85181485c6700163ed49b5dbef1c7b0a0000f30e5beef614aee11726959828f7ec298ca76316ea4500480e40351c7d1bfde34f5fba3e950e3839276ee39c7d6900db86410b631d2b2876ada78d5e22981822b2cda2ee2373003b66b87154db774745195af723886e9c11fc3535c63c861ebc0a7222c6b85000a82593cc6c0fbabfad737c1135f89925bff00a851e9514cbb6624f46a227f2db07ee9fd2acb22c8b8619145b9e21f0b2a629f6e3748cc3a018a7fd9573f79b1e99a94058d70300528d3b3bb1ca775623b93fbb03d48a829647323eefe11d29c901740c5d867b54c939bd06b443ad8603ffbd5a8a398fe954628c2e11475eb579397c8e806057a1858d91cd59dd8eff96a3fdda5933e59c71ef48e0f0c3a834e521864722bacc41400bc74a0b05192714df2f1f758814a10039ea7de80054e72c7269cc3729146474cd1903a9a0066d93b38c7d29cab818eb9a5c8a370f5a00679647dd6c7b554b98a6c6e8c293deaf1229b91ea2a671e6438b69dcc366918e24381e94638e2b5deda293aa8fc2b2b53d96112c88376582e335e656c3ca3a9d70aaa4ec8691d475a159d3eeb71e86a88d523c72845491df472e76f18ebbab962df4377165df3e4ff00673eb9a631673f3b67dba5533a9423fbc71e8298daa478caa31fad3736c4a9b2f91918f6ed4e5965c850a18fa53ec152eed04eddf3c03ef5a11c51c63e541bb38aeaa3879bd4c27512d08edede43f34a719ec2ae0014600c0a4420a834e041ef9af4610e556395cb998948539c8383485cf38031eb9a4121ea4023d8d58870120eea68dae7ab71ed4e04119ec68041e86802bf39248503b7d690ee20646723249e714ed87713b58e7d71c527958fe1e7d450027cc1338dbce31da9fb7739da00fa8cd2797f21e303af3dea3926588ee24a823a8ef400e24f1e99e476a785dccdb40001ee2a8c9a840854127d401d6a07d5b24f971bae7bf07fad3e564f3234f7f45ecddbd39aa1a9c09750468c060b6401c1e013549ef6679433332a0e813fad40842ca1be738e9ebfcea674f9a3608d4b3b95562613ed96dd02e09185ff0039a8213932311b731938c63b1ad886505be60c40e94f4555cee56236e0600e95e3ce9b83b3d0f4e15f995d182bc81819c7b55868a59d6168e2504f5c2f7ad65450bc8181eb48b2e19a345dc71bbe86951a4e6ec875710a28bd662386d82068f2871803a9ab98f9f771f788e95cd800ed2e1bd4e0739a91267498b8670b9c803fad7b50838c523cb954bbb9be324138079fbb4a370c9c7419c8e2b0a3bd994fcedbc76e39153aea4e3fe59ee27824e055728b9d1ac5c1c36060f3c9a52c080400083dab357558f6aabc4e001d475a9e3d42de4206f3bbb6e18c52b31f322f20ca11db27151b1c01bb0003826a48990a7cac1bdc1a47037e08c86e08a450e9a410c6d23138039c566c9ac0c7eea2cfbb1ab5a9122ca423d315cf81c554519ca5665b9751b993fe5a05f65aabbe4c93e637345157633e66c4c739efeb4b4514082992482189e46e154734fed599a9b493bad9c3cb1396c7614d6a26c8ecb53669d96738573956f4f6ade49415c30c7a1f5ac68f4787c9db212653fc59e86bcf757f8b8de17d6af346bbd20cf25ac850387fbc3b1fcab2c451854dcd28ce70d8f579671b49ce235e49ac29755737a0a1610a9da707ef7b9ae7fc25e3393e209ba482c4d9db5a80647dd9c93d07f3ae9ae3478cc5fe8fc381cfbd5d1a50846c85565293bb35382320e41e41f6a2a8e992b34060978963e083e95785512145145200a4c0c52d06981a7a39c19476eb5ac54375ac7d20fefe41ea2b645652dcde1b14b5538b07fa8fe75855b5ab9ff4423d48fe758b571339ee252d028a6405145140053523542481c9eb4ea28001915f3ffc6fd385a78c61bd5181796eae7ea3e53fcabe80c66bc3fe3e36753d2149ff0097727ff1e34a454373abf82fa68b2f04c974c007bc9f767d97a7f3af44edefeb5c6fc297dff0e74fe7a3329aecbb534296e26c53279981bb18cfad2e314b45020a28a2800a28a2802f69471798f55adc1581a61c5f27d0d6f8a896e6d0d8cdd60fee107fb42b1fb56aeb3f7221fed1acaef551339ee14514532428a28a0028a28a6015e17f1e9b3e20d253fe9d0ffe846bdd3b1af07f8f473e28d307fd39ff00ecc6a645c373d03e11367e1d5a7b4ae3f9576fdab82f836dbbe1e443d2e1c7f2aef69a265b8b45145020a28a2800a28a28027b13b6fa2f738ae8c57356c71790ff00be2ba5151235a6646b3d62fc6b2fbd145544ce7b8b4514550828a28a40145145300af05f8ee4ff00c257a77fd79ffecc68a2a64690dcedfe0b127e1eaffd7d3d7a1f6a28a68996e1451453242928a2900b45145003e1ff008f88bfde1fceba71451512dcd699ffd9, 0, 'LD6', 'LD4', 'CVR1', 'LV6'),
('14307', 'Golf', '1996-05-30', 1, 0, 'Wah di situ ternyata', 'golf@mail.com', '08525', '2019-02-01', '$2a$10$7eWD2BPrhd7QJ8iztaGqs.9RIC4rUxbz7zGElcv0lxJy4zJCh4zuO', 'admin', 'admin', 0xffd8ffe000104a46494600010101006000600000ffdb004300080606070605080707070909080a0c140d0c0b0b0c1912130f141d1a1f1e1d1a1c1c20242e2720222c231c1c2837292c30313434341f27393d38323c2e333432ffdb0043010909090c0b0c180d0d1832211c213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232ffc000110800d3009f03012200021101031101ffc4001f0000010501010101010100000000000000000102030405060708090a0bffc400b5100002010303020403050504040000017d01020300041105122131410613516107227114328191a1082342b1c11552d1f02433627282090a161718191a25262728292a3435363738393a434445464748494a535455565758595a636465666768696a737475767778797a838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae1e2e3e4e5e6e7e8e9eaf1f2f3f4f5f6f7f8f9faffc4001f0100030101010101010101010000000000000102030405060708090a0bffc400b51100020102040403040705040400010277000102031104052131061241510761711322328108144291a1b1c109233352f0156272d10a162434e125f11718191a262728292a35363738393a434445464748494a535455565758595a636465666768696a737475767778797a82838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae2e3e4e5e6e7e8e9eaf2f3f4f5f6f7f8f9faffda000c03010002110311003f00f7fa28a2800a28a2800a28a4a005a29bde8c8f5a007514de28cd003a8a4a43400ea29072296800a28a2800a28a2800a28a2800a28a2800a290d19a0033505c5dc56b0b4b3c8a91af5663c536fafa1d3ece4bab87091c63249af17f11f892ebc41764bb347668711c59e1bdc8ef58d5aaa08da8d27519d6eaff0012d51de2d2ed965c1c096563b4fe03fc6b989fc6fe229dc9fb6ac43d2388607e79ae7c0e3fa518ae09569c99e8468422b637e3f1b7886220fdbc38ff006e35c7e95ab6df13355888173696f328ea63dca4fea6b8cfc4d1f89fc4d255a6ba8dd083e87a9e9ff1274e9d825e4325ab1f53b87e7c575b67a85adfc225b5992543dd4e6be7ec7f93566c6feeb4bb813d84ed03e72421c07fa8ef5b4314d6e6153089abc4fa097a52e6b82b4f89360ba623de4720bb030d1aa9e4fd6a11f14adcc9ce99384cf62335d5ede1dce5f6153b1e874561e89e28d375d43f65997cd1f7a263861f856d06cd6919296a8c9c5c7463a8a4cd2d50828a28a0028a28a000d21341a86ea75b6b596773f2c6858fd00a4dd95c12b9e65f1135bfb55ea6950b66284ee9b07ab761f873fa570f8c0c0fcea6bab97bcbd9ae6439795d89350d793524e526cf628c146290bf8628a28accd428a28a041498cf5fca8a370f5a0007b71eb463f1353436b7172c161824727d16a37478a468e452aea70c0f634c134f61d04f2da5c2dc5bc8d1ca872ac0d7b378535f5d7b4a594e16e233b265cf46f6af16cf22ba3f03ea874df11c51b1c45747cb61db71e87f3c56f42a38cacce7c4d3528dd1ece2969a0d2d7a67962d14514005145140087918ac2f185c1b6f0aea0e0e098593f318ade35cbf8ff3ff00088de63fd9fe62a27a45974fe2478d8e07e1d697a520ab1636536a17915ac032f21e4fb7ad78e7b3b158b28ea707dcd5982c6f6e8ffa3d9cf2e7bac648fcebd3f4cf0fd868f6f958c492aae5e56192c7b9ae2dbe2a5d493c8d63e1b9e6b443832e486fc8291fad0b532751f421b6f086b570031b6110ff006d80fd2b56dfe1fccdf35cdf2afa88c1feb5d1f877c4963e25b237366cc190ed96271f321fceb67ad4c9d887391cc5b781b4984832f9b39ff6988fd056b5b685a5da81e5585b823b9404feb5a3595ad788b4ad02157d46e42171958d46e76fa01495d89b66a28d800501476c74af3af1be9df65d563bc44c25c8f988ecd5bba578ff0042d5af56d23926b79dce152e23299fa55ff15587f686833803f7917ef147b8ebfa669eab708b699e59d0faf34e8666b79e1b8438689c383ee0e6980e569aff00eacfd2ad3d51d0d5d1f4444c1e1460720806a515534e0469f6e1bef7963357057b11d8f15ad58514515420a28a28010f4ac0f1a41f68f09ea0a3f8622ff973fd2b78b0c751f9d50d4bcb92ddade450e92295653dc1eb59d59251772e9df98f9fe7996ded249d812b1aee2073507867e26689a56a4f75716b76ff00bbda360cedad9f115b46baa6a76d12058f2eaa8bc01c543f03ecb4cbbb1d72daeec6d6e2782e14e67855c852081d47a835e7d350706da3beb4e4ac975367fe179f86f39fb15ffe282a38be35f85618cc71e9778887aa888007eb5e823c3fa21eba269bc1ff009f54ff000af13bfd797fe12b7bb8ac2c56d229b60b716c9b4a67bf1cd11749ec8ce309cba9bd61f15bc13a5de5d5e59e937f0cb758f3768e38ce3f99ad05f8e9e1b6e4595f1ff808a7fc526d1f49f87fe6db6976115d5fed488a5b22b004649181ee3f3ad9f0178474bd3fc11a525d6976935ccb02cd23cd02b365fe6c1247bd5354b9399a325cf7b5cc2ff85e9e1a0769b3bf04f41b47359f2fc53f044faaff0069cfa3df4d73b02ab4ab90a07a0fc4d33e3268567a50d13c4165616f1476f72239a38a20a8dfc4370031fc247e35d378a6e348b4f03c3ab58e91a689af110238b543b4b0e71c76a76a518a925b8e2a6e56b9c86b9f10fc0dae3dbc92e9da8dbcd03aba4b046aadc1ce0f15b8ff001bfc352c2f1b596a05594a9ca0e73553e1a4f69a85d5c69ba869f6370427991b496a8587a8e95e94340d1370ff00892699d7afd923e9f9544a54d68d1a4a134ed73c161f18e9b7b7eb6d041701a490840c00e0d7456f6c6eaf60b4539334ab183f538ac0f12da5aafc63b886d208a28add549489428071e83eb5eabe0df0fc423835a95b7ca798d0f45a2aa845a68d6139723b9e9912ed8d47a0c54b54aca7690157ea3a7bd5cc815e8539a946e8f3a49a7a8b45377aff00787e74a083d0d6848b4c938434e0ca7a1a6c9feadbe940082342a0951597779f3bf135ac3ee0aa37316e8cb8fe1639fa66b9f111728686949da478aebaf9f115fb67fe5b91597f0c67ff00846fe236aba45f1f27fb4115e32fc06ea47fe847f2ab53b7daf5491faf9d375fa9ae9fc73f0f62f14dada5e69f39b4d62d23548e41c2c800e33dc63d6b8a8c92bc5f53b6bec8eddaec8b9f29217720fcc78007f8d797defc32d4a7f149684c5fd9d24be6162f82a33f771fe7a55383c51f15b45516771e1eb7bf11fcbe7b42c4c98ef90c33f953a6f137c56d7616b1b7f0fc1a72bf06e12260547d598e3f2a6a838b7ef2b19aad6d883e20c91f89fe20687e1bb572f67a72813488321589e47e4abf9d7b040cf313205f2e3fba89e8074ae37c13e1d87c31118351d8fa94dfbc9676e77b1ebcfe55dcef00f07af35956a9ccd456c8d147975303c71a30d7fc15aa586dcb98bcd8f1fdf5f9863f223f1af3ef041ff84cbe174de1e3205d4f4d9f0a8e7071d41fccb0fc2bd7c3aa9f518ee2bcafc4bf0ef57d2f5e6f127822e4c771212f3da93c13fecfa83e87f3e6b4a2d4a3c8cca578cb991abe08f0bdd785efae6eb53e66957cb8fca05801f9577cf3c505bbdccae1218d4bbb1e800af241e3cf8a31298a6f07db390319f21c67ff001faa9751fc4cf880069fa85ac3a369c4fef4c68c8187e2c49fa6451ec1b77931cab7374d4e7f4749fc43e33d735c8626781e4d88ff00a7f203f3af6cf08798be1d822914aba33020fd49ac7b7f0cd8f85346b4d36c32caa58bc8f8dced85c9e2b6342b80a5edc9efb87e54eb5a6ae8a83b46c74968489c91d979ad4080f24ee3ef54ec230a8589e5aae0460301be5fd6bb30d07186a72557790fda3d29a635ea38fa52794bea7f3a109cb2939c77ae83314a0238e0fa8a6337c8cadc363f3a70250e1b95ec7d29ce81d7068001f745676a72b43a45e3a9c3047c1f43835a40600155a5823b9b59a0946e8e40cac3d8f14a4ae869ea796e95a5dbc17500081dcb8cb3735e9380315c2cfa2eaba2ead6b1a2b4f64d3713af2c8307822badd833d3f1cd79751f268d1dafded516da30deaadea2aa19089bca7705fb0279352c2e776c639f4aad2db4b1f993288cbeeca93e950d292b8a2acc6cf6715efeee48d5fbe7fbb562cb4f8ac976a33b0f47627f9d36d5e6116e6832cc79da41a8ee6f655711a5acc78c9c6dff001a518f2c6eca6dbd0d1e3daa37815b91f2b7a8e2b27ceb86fb964e0fabb8fe84d5bb56bc954aca638c8ecbcf14e338cb4138b433ed24cb240c58489c907bfb8ad1daa57900fe15466b3449567cb17fba493eb4ed8b93f2ff00f5ea5cb91d86d296c66789c0096a40c7ccdd3f0a87c2d019b52772b9445c138ef5a72e9b0dfa05977008c48dbf856bda595bda471c5146157f9d76504a7a9954972ab169955546001cf6a7170bee7d0535805c6d0031e05395428e9cfad771ca27cedfec8a72a85181485c6700163ed49b5dbef1c7b0a0000f30e5beef614aee11726959828f7ec298ca76316ea4500480e40351c7d1bfde34f5fba3e950e3839276ee39c7d6900db86410b631d2b2876ada78d5e22981822b2cda2ee2373003b66b87154db774745195af723886e9c11fc3535c63c861ebc0a7222c6b85000a82593cc6c0fbabfad737c1135f89925bff00a851e9514cbb6624f46a227f2db07ee9fd2acb22c8b8619145b9e21f0b2a629f6e3748cc3a018a7fd9573f79b1e99a94058d70300528d3b3bb1ca775623b93fbb03d48a829647323eefe11d29c901740c5d867b54c939bd06b443ad8603ffbd5a8a398fe954628c2e11475eb579397c8e806057a1858d91cd59dd8eff96a3fdda5933e59c71ef48e0f0c3a834e521864722bacc41400bc74a0b05192714df2f1f758814a10039ea7de80054e72c7269cc3729146474cd1903a9a0066d93b38c7d29cab818eb9a5c8a370f5a00679647dd6c7b554b98a6c6e8c293deaf1229b91ea2a671e6438b69dcc366918e24381e94638e2b5deda293aa8fc2b2b53d96112c88376582e335e656c3ca3a9d70aaa4ec8691d475a159d3eeb71e86a88d523c72845491df472e76f18ebbab962df4377165df3e4ff00673eb9a631673f3b67dba5533a9423fbc71e8298daa478caa31fad3736c4a9b2f91918f6ed4e5965c850a18fa53ec152eed04eddf3c03ef5a11c51c63e541bb38aeaa3879bd4c27512d08edede43f34a719ec2ae0014600c0a4420a834e041ef9af4610e556395cb998948539c8383485cf38031eb9a4121ea4023d8d58870120eea68dae7ab71ed4e04119ec68041e86802bf39248503b7d690ee20646723249e714ed87713b58e7d71c527958fe1e7d450027cc1338dbce31da9fb7739da00fa8cd2797f21e303af3dea3926588ee24a823a8ef400e24f1e99e476a785dccdb40001ee2a8c9a840854127d401d6a07d5b24f971bae7bf07fad3e564f3234f7f45ecddbd39aa1a9c09750468c060b6401c1e013549ef6679433332a0e813fad40842ca1be738e9ebfcea674f9a3608d4b3b95562613ed96dd02e09185ff0039a8213932311b731938c63b1ad886505be60c40e94f4555cee56236e0600e95e3ce9b83b3d0f4e15f995d182bc81819c7b55868a59d6168e2504f5c2f7ad65450bc8181eb48b2e19a345dc71bbe86951a4e6ec875710a28bd662386d82068f2871803a9ab98f9f771f788e95cd800ed2e1bd4e0739a91267498b8670b9c803fad7b50838c523cb954bbb9be324138079fbb4a370c9c7419c8e2b0a3bd994fcedbc76e39153aea4e3fe59ee27824e055728b9d1ac5c1c36060f3c9a52c080400083dab357558f6aabc4e001d475a9e3d42de4206f3bbb6e18c52b31f322f20ca11db27151b1c01bb0003826a48990a7cac1bdc1a47037e08c86e08a450e9a410c6d23138039c566c9ac0c7eea2cfbb1ab5a9122ca423d315cf81c554519ca5665b9751b993fe5a05f65aabbe4c93e637345157633e66c4c739efeb4b4514082992482189e46e154734fed599a9b493bad9c3cb1396c7614d6a26c8ecb53669d96738573956f4f6ade49415c30c7a1f5ac68f4787c9db212653fc59e86bcf757f8b8de17d6af346bbd20cf25ac850387fbc3b1fcab2c451854dcd28ce70d8f579671b49ce235e49ac29755737a0a1610a9da707ef7b9ae7fc25e3393e209ba482c4d9db5a80647dd9c93d07f3ae9ae3478cc5fe8fc381cfbd5d1a50846c85565293bb35382320e41e41f6a2a8e992b34060978963e083e95785512145145200a4c0c52d06981a7a39c19476eb5ac54375ac7d20fefe41ea2b645652dcde1b14b5538b07fa8fe75855b5ab9ff4423d48fe758b571339ee252d028a6405145140053523542481c9eb4ea28001915f3ffc6fd385a78c61bd5181796eae7ea3e53fcabe80c66bc3fe3e36753d2149ff0097727ff1e34a454373abf82fa68b2f04c974c007bc9f767d97a7f3af44edefeb5c6fc297dff0e74fe7a3329aecbb534296e26c53279981bb18cfad2e314b45020a28a2800a28a2802f69471798f55adc1581a61c5f27d0d6f8a896e6d0d8cdd60fee107fb42b1fb56aeb3f7221fed1acaef551339ee14514532428a28a0028a28a6015e17f1e9b3e20d253fe9d0ffe846bdd3b1af07f8f473e28d307fd39ff00ecc6a645c373d03e11367e1d5a7b4ae3f9576fdab82f836dbbe1e443d2e1c7f2aef69a265b8b45145020a28a2800a28a28027b13b6fa2f738ae8c57356c71790ff00be2ba5151235a6646b3d62fc6b2fbd145544ce7b8b4514550828a28a40145145300af05f8ee4ff00c257a77fd79ffecc68a2a64690dcedfe0b127e1eaffd7d3d7a1f6a28a68996e1451453242928a2900b45145003e1ff008f88bfde1fceba71451512dcd699ffd9, 0, 'LD7', 'LD4', 'CVR2', 'LV7'),
('14308', 'fes', '0009-09-09', 1, 0, 'ss', 'fes.game1@outlook.com', '08123456789', '0016-09-08', '$2a$10$0ZFCXcf2bsui9/.yFYfmY.bGPFQaBhTNlqCIcerL7573ATEsqBXVy', 'Phone Number', '08123456789', NULL, 0, 'LD2', 'LD1', 'CVR2', 'LV1'),
('14309', 'Tia', '0009-09-09', 0, 0, 'ww', 'restaaryaning@gmail.com', '08123456789', '0018-09-09', '$2a$10$2p/8aLr2kadJYcTys4yHJ.BzhogeDaYmKbguZkAnWvoPNG2N3JXJG', 'Phone Number', '08123456789', NULL, 1, 'LD1', 'LD1', 'CVR1', 'LV1'),
('14310', 'aa', '0010-09-09', 1, 0, 'ss', 'adhityawisnuprabowo@gmail.com', '08123456789', '0011-09-09', '$2a$10$cwnLfrHW/amaGNtDq4tmIueZQMX5EYLfEO8pGw6jkLLQA8TLWkeYy', 'Phone Number', '08123456789', NULL, 1, 'LD3', 'LD1', 'CVR1', 'LV1'),
('14312', 'gerybaru', '0033-11-14', 1, 0, 'Taman Delima', 'gerycahyandanu@gmail.com', '08133157', '2019-02-01', '$2a$10$CS1TKu9iIGQbHIbHbmWM1emUddHwUjOUVjJmST1Q9eWPKMED/F6JC', 'Phone Number', '08133157', NULL, 0, 'LD3', 'LD1', 'CVR1', 'LV3'),
('14313', 'Gery Cahyandanu', '0033-11-14', 1, 0, 'Delima 456', 'gerydanu@live.com', '00881133', '2019-02-01', '$2a$10$ZnaY9F.O/tNBVwb7wFsovOQyvjLTWq3Yol93/VYYngUwgO5BJdWBi', 'Phone Number', '00881133', 0xffd8ffe000104a46494600010101006000600000ffdb004300080606070605080707070909080a0c140d0c0b0b0c1912130f141d1a1f1e1d1a1c1c20242e2720222c231c1c2837292c30313434341f27393d38323c2e333432ffdb0043010909090c0b0c180d0d1832211c213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232ffc000110800d3009f03012200021101031101ffc4001f0000010501010101010100000000000000000102030405060708090a0bffc400b5100002010303020403050504040000017d01020300041105122131410613516107227114328191a1082342b1c11552d1f02433627282090a161718191a25262728292a3435363738393a434445464748494a535455565758595a636465666768696a737475767778797a838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae1e2e3e4e5e6e7e8e9eaf1f2f3f4f5f6f7f8f9faffc4001f0100030101010101010101010000000000000102030405060708090a0bffc400b51100020102040403040705040400010277000102031104052131061241510761711322328108144291a1b1c109233352f0156272d10a162434e125f11718191a262728292a35363738393a434445464748494a535455565758595a636465666768696a737475767778797a82838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae2e3e4e5e6e7e8e9eaf2f3f4f5f6f7f8f9faffda000c03010002110311003f00f7b20c672395ee29dc3afa834b51affac257eef7a0042ac1d4755cf5f4a924ff0056df4a5a493fd5b7d2801a41186c67d45299071b4649a72fdd1400076c500337b0e4a71ec734f0432fa834531387703a50000ec254f4ea295067e63d4fe951ce71b48a9a801a5f076819349bd872cbc7a839a22fb99ee69f400980cbec6a300ee03ba9cfd69d1f461d81a5e928f714006e7c7dd1ff007d52a1dc80fa8a53d0d247fead7e94009b98b1014607bd349218311cf4005397efb7e148bcc85bd3814006c2dcb9fc05380551c600a4762b800649e947979e5892680109321c0fbbdcd3b845f4029a2440300fe94005ce5871d850034925d18f033c0a7c9feadbe94927054fa1a477564600e490714006e240551ce3ad1f3a7fb429082bf32fe22b9bd5bc79a2e953b5b35c096ed4730a76fa9e949c92dca8c5cb63a5f309fbaac4fb8a722ed072464f5af34baf89170c49845b449d8b36e38fc315cd6a9f14b55542969708643fc410ed159bab146b1c34d9edae03b103a01d69e8db941efdebe748fe2578b233917f137b3447fc6b46cbe2e788a0981b84b4990fde01083f9e6a557896f07516a7bc60a138195fe54172c30aa73ea78af32b2f8ac6700b4101f55de54ff235d1e9df10747bc91629e516d231c00ec083f8d68aa45993a335d0eb1176ae290302c5bb0e2a3594ca80a1f95bf8bd69ef80a07419ab3214c8082006cf6e0d39061003d851bd71f78534be785e7de801539663ef48bc3b0f5e69eabb540a465dd820e08a00470782bc907a5279a3a6d6fca80f8e18629dbd7fbc2801460fa52d4280c631dcfad026e324823da8025c521007614c329ce381ec690cb9381807de803cf7e2878ce5d0ec934cd3e4d97f720e5c758d3b91ee78fd6bc379662ccccee796624e493d4e6baff16c4facf8b2fae1af61590b6c8e366e428e83d33f8d60db6913dccf243be38e68fac6c7935c555b948f5f0f18c21a99e79ebd7e9476ad41a2b3131adddb99ff00e7906e73e99aab6d6135c5cbc1c218c12e58e028acac6fcc8ab4569ae8b2bb6e8e785e11f7a50df2afb1ef41d15fc89275ba80c2a3ef863cfb74a2c1cc8cbfa5232823915bab3a7fc23e64f2222e1c47bb68ce306b2eced7ed738844a9193d0b9c03ed4ed604d3dcecfc31f13f50d03486b0b884df797c40cefca8f427a91534df187c4523831db594683f876139fccd72b69a4197585d3e59e23e61d9bb9c0278f4ab169a3fd9754bbb4b99606920465653ce091d7a76ab539183a549bd8f48f09fc588f54bf8ec358b58eda694ed8e54fb8c7d39e95ea0872338af992cf4e8cd9df117106e5002b8cfc98e735eebe05d624d5bc1f617329ccab1f94ec4e77153b777e38cfe35bd29b7a338f114947589d4d2640a607c8c1c73d0d336863d147b9adce426c8228dabfdd1f9543ca67a0c0cf1d08a919f6a83400d97d0f4c66a1fe107000073f8d5a650dd69a231d724fd4d00572339ca0e7b039cd0fc15381c0e6a731ae78c8fa1a49106cc0e31cd27b0d6e7cb93e9f7cdaac80a333b4a5b7f51d7ae6b620066f103b467212dfcb67edbaaacd796715d4cbf6aba55591b3003c673d33e9592f7922cd2b5bb3431b9fb8ac6b89bb33d88a728a27874dbd1a8221460c1c12e7a0e7ad69b037126a9242a4ab26d0c07539158b1dddfdc62d61967949e0469924d6ee9fe12f165c285b7b29a08cffcf56d82a39d21bf3650d3a398e95a86d46e40c0f7e73496b14ade1fbb011882ea578eb8c67f9575d61f0d35f65c5c6aa96ca792b1fcdfc8d6fd8fc34b1b78825cea37b3af745936a9fcb06a5d58a25cd1e682190786db287fd686fc3079acbb78ae26917ecf0c8ed9e36a935efb69e15d12c63091d96e5031891ddc63e849ad382d6d6d462ded61840ff9e7185fe42b39565d05ed5ad0f26b4f0cead772aead0583acaf18c6ff009487e99ab9e31d33ec9e2d3748802cd68c5caff780e735ea59ca90c1b39ce41e0570bf142c6693428f51b77657b67025da7831b71fcc8a6aadda338c9b96a79a58230d2f527c7ca500071d7935ebbf0aaeccfe1e68ca20589f682af9c703af031cd7890b898446212388d8f2a0f15eadf0532d16a8a49c7980f5f615d549fbc3c547dc6cf54e7cb18183bb3d69ec006c8dbb7e99a9422807be7d693ca5ed91f435d8796478cf63e82a603e500d0a814e47e669d400514514005358641a7534f5a4c0f97fc5967f61f16ea76f8c013311f435996d6f25ede436b0ae659982a8f735da7c59b2fb378d04eab84b98011f55ebfceb2bc05686ebc6962072202653f8579f5346cf6a12fdd5cf5ef0e786ecfc39611c16f1a19f6e269b6e19cf7e6b9ad5759f1cdcebb7369a3e9a23b680e03c814799f8b577c4e7f3a6bca9163cc9157770371c64fb572293b9cf7eace3fc31e2fbcbed4df45d72cdad35455debc7cae3d8d76551b5bc0f3aced121994615f1c81f5a92a66ee019c0eb58faf788ecbc3d6e8f722496694910c112ee790fb0ad8a8de08649525922469101dacc395a49ab86e7092fc47bcb09126d5bc39796964e702523903d48aeca78edb5bd1648d0892deee1c2b1e872383f9e29d776d65aadacf6572914f0b0c491ee048f63e952dadb43656915ac09b218902a2f60055c9f6137d8f9c6f2d1ec6fee2ca5056481ca907f4af5af82698b0d4df1d6603f415c87c4ed3c5a78b05c2fddbb843f1fde0707fa576ff05571a05fbfadcff415db41dd978877a27a78ef4b480e7a1a5aeeb9e58b45145300a28a2800aab7b318a2f97a9e956aa86a40ed43d81e6b1aeda8368a82bc8f25f8bb6a5edf4bbf209292344c7fde19ff00d96a97c24b2f3350d46f48e23458d4fb9c93fd2babf88f67f6bf055d1c7cd03aca3f3c7f5aa9f0aeccdb7845a765c1bab86901f51b557fa5799ccdc2e7a89da163b707a0af12f88fa8dd4fe2f9a1f3e58e2b551e5aab9014f3cf1f857b24f24fe62c7020c919676e82b91f157c3e1e22d522bf8aed609080b38c7de03d3dea20d264c2c9dd9bbe11be9751f0969d7770c5a478f0cc7be0919fd2b6aa8db456ba2e9705a23058a05d8a3b9a92d8cb3b79eea514fdc43d7f1a996e27dcb5dab33c45792587872feee1ff0059144597eb5a7515ddb477b692db4ab98e552ac0d11693126787f80f54bbb7f19d9e6e25905d39498339c3eeefef8ce735eedd38c5703a0fc3d5f0eeb31ea4b2fda8c418471ff77231debbb8a432a0628c84ff0009aaa924f62e76be8705f162c3ced0ad6f947cd6f36d240fe161ff00d6a9be13b32785661ce1ae18d749e25b01a9f86efad3192f11c67d6b9ff858857c18a5ba99a4fd188aa526a1a0b470b33beb3999670a58953ea6b54562db0dd7083df3fa56c8aeec24a4e3a9c35924c7514515d86214514500150dc44258997d454d486a6515256634ec729add91bbd16facd87cd240ea3eb8e3f5c541e1cb0fecdf0e58d99e1a28806faf535d5cb0472292ca2b20fde23df15e557a5ecd9d94e7ccac1fe78a3b8a2abc9790c7709033fef1ba2d731b58cfbb716dabacd72a5a12802b63214e6b5629639503238607b839a56459536ba8607b1aaf0e9f6f6d2992256427f8431c5036d3dcb54519cf5a28245a41c55596efcbbc8e065e24076b67bd5aa076b010186dc7078358de19d3bfb274d9ed48c0fb5ceea3fd969188fd08ad9eb57ed2de37855ca026b6a34dcf4339cf950961010c646fa0abfce45000030052d7ab4a9f246c714e5cceec5a28a2b52428a28a0028a28a0063fdd3588df78fd6b6dfee9ac46fbe47bd79f8de87461f712aa3d9137ad729332164da7038ab74579e7595765e2fdc96371e8c314d2da80e896e7e8c7fc2ae51405ca7ff001316e3fd1d7df24e281697127fadbb723d106d1573af5a2905cab1e9f6f1387589778fe22327f3ab428a2985c2b56c3fe3d96b2b35ab61ff001ecb5d982f8ce7aff096a8a28af50e40a28a2800a28a2800a28a4c50023722b1ee23f2e720f7e456ce2a0b9b713263b8e95cd88a5cf1d0d29cf95991453a485e36c329c7ad378af29c5adced524c28a2838f5a9185145191405c28a0d28058800127da9a4dec0da5b88012401d49ada813cb882fa0aab6b6851b7bfde3daaf018af4f0b45c7591c75a7ccec85a28a2bb0c428a28a0028a28a002929690d00145251cd0023283d40359da9a2c36524b1a8dc07f5ad139cd627886f8436df674c6f939fc05672a5ed13496a1ed55369b664aea5300372a9e3b1a7ff6a1c7faaffc7aabc76af2c225888718e47a534dbccbc796df85789384a127167af4dd39c79916ff00b50ffcf1fd69875290f48c0fa9aade4cc7fe59bffdf352ad94c54b3008a3a93daa527276453f6705766be8cff6cf34cbb72a7815b691a20f9540ae2ac6f4d9ea2922b663ce1fdc7ad7689323a821860fbd7bb4f0ae941732d4f1a5898d493b3241f4a5e94dc8ec452d682141a5a6d140ee3a8a4a3f1a005a2a19a65823692460a83a935953f892d23c88c3c87fd91c55461296c8ce75230dd9b59a6b301deb959bc497720fdcc2b1fb93bbfc2b3a6bfbbb83fbcb863ec3815bc70b27b9cf2c6c16c76336a5696ffeb2e2318ed9e6b36e3c4d6ebc408d21fa60572f81f53ef4b5bc70915b9cf3c6cdec6a4de21bd972136463db93fad66cb2c93c9be56676f534da41ff00ebae88538c36472ceaca5f132d58dcfd9e7c1c6c6e0d6f02368c11822bcf66d4993502e39897e523fad75da45f25d42a9b8138f90e7ad7919a612ebdac16a7a1966355fd9499a847eb595a9dd614408c3d58d5ebbb816f6e5bf8ba2e7bd711aa6a4cced1c47273b9d81efe95cf9660f9e5ed248df33c6aa50e44f735f1c631d28562872acca7d8d416b3adcdb4728f400d4d5f4364f73c68cbaa2d47a8dec78db73271ea7356535fbf43cbabfb15acda2a1d283e85aad35d4dd8fc4f303fbcb7523d8ff8d5b8fc4d6c71be2953d78cd72f4566f0d066ab17511d926bba7bf49c0ff78115692fed64fb97111fa38ae0a8c7a7159cb06ba3358e365d51d87881b1a44bef81fad71e00f4aeabc4adb74f54eecc2b96aac2fc04631dea09c52d145756a7205252d1400955afe668adcac6332c9c2a8ab549b46f0f81b8743e940a4aeac6759e931c6bbee3e676edd85729e2df16de780750b6fb25ac5716f3aef1e6e7839e9c115defe271deb80f8bd61f69f09c77b8e6d661cfb1e3fad635eee0cd70b08c6a2b95f46f8a5ab78cf5eb7d28d85a5bf9db81910312a029248c9f6aee86936c2168c862c7f8c9e735e4df062c44bae5f5f9e4416e517eac47f4cd7b29ff0022b3c2ab43435c6c62ea6a6658a49a7dd35bcbfeadfeeb76cd6a5232875dac0119cfd296ba8e48c79740a28a282828a28a0028a28a04749e286fdcc0beaf5cdd6f78a1ff007d027a02d5815cf865fbb3ab14ff0078c5a28a2ba0e612968a2800a28a2800ae37e2936df87f783fbd247ffa10aec6b8bf8ac7fe2839c7aca9fcc5675bf86cda87f111cdfc12386d5c76da87f5af58af23f828dfe93abafac4a7ff001e15eb9deb3c3fc08bc67f118b494b45741cc145252d00145145001494b45006d78a3fe3f61ff73fad62d1456187fe1a37c4ff00118514515b980514514005145140095c47c593ff001433ff00d765fe628a2b2aff00c366d87fe22398f827ff00210d53feb80ffd0857afd145461be045e33f88c28a28ae839828a28a0028a28a0028a28a00ffd9, 0, 'LD1', 'LD1', 'CVR1', 'LV1');

--
-- Triggers `tb_m_employee`
--
DROP TRIGGER IF EXISTS `setIdEmployee`;
DELIMITER $$
CREATE TRIGGER `setIdEmployee` BEFORE INSERT ON `tb_m_employee` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdEmployee() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_evaluation`
--

DROP TABLE IF EXISTS `tb_m_evaluation`;
CREATE TABLE IF NOT EXISTS `tb_m_evaluation` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `isdaily` tinyint(4) DEFAULT NULL,
  `evaluationdate` date NOT NULL,
  `note` longtext COLLATE utf8_unicode_ci,
  `isdeleted` tinyint(4) DEFAULT NULL,
  `lesson` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `topic` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `participant` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `TB_M_LESSON_fk` (`lesson`),
  KEY `TB_M_TOPIC_fk` (`topic`),
  KEY `ev_TB_T_PARTICIPANT_fk` (`participant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_evaluation`
--

TRUNCATE TABLE `tb_m_evaluation`;
--
-- Dumping data for table `tb_m_evaluation`
--

INSERT INTO `tb_m_evaluation` (`id`, `isdaily`, `evaluationdate`, `note`, `isdeleted`, `lesson`, `topic`, `participant`) VALUES
('BE1', 0, '0008-09-16', '', 1, 'BL12', 'BT3', '14305'),
('BE10', 1, '2019-04-04', 'Baru', 0, 'BL5', 'BT4', '14305'),
('BE2', 1, '0010-09-09', 'Fungsi', 0, 'BL12', 'BT2', '14306'),
('BE3', 0, '0010-09-09', '', 0, 'BL4', 'BT2', '14306'),
('BE4', 1, '0012-09-08', 'oke\r\n', 0, 'BL5', 'BT5', '14303'),
('BE5', 0, '0009-09-13', '', 0, 'BL5', 'BT4', '14303'),
('BE6', 1, '0009-09-19', '', 0, 'BL3', 'BT4', '14303'),
('BE7', 0, '0020-09-08', '', 0, 'BL3', 'BT5', '14303'),
('BE8', 1, '0026-09-09', '', 0, 'BL1', 'BT1', '14305'),
('BE9', 0, '0027-09-09', '', 0, 'BL1', 'BT1', '14305');

--
-- Triggers `tb_m_evaluation`
--
DROP TRIGGER IF EXISTS `setIdEvaluation`;
DELIMITER $$
CREATE TRIGGER `setIdEvaluation` BEFORE INSERT ON `tb_m_evaluation` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdEvaluation() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_language`
--

DROP TABLE IF EXISTS `tb_m_language`;
CREATE TABLE IF NOT EXISTS `tb_m_language` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_language`
--

TRUNCATE TABLE `tb_m_language`;
--
-- Dumping data for table `tb_m_language`
--

INSERT INTO `tb_m_language` (`id`, `name`) VALUES
('CH', 'CHINESE'),
('EN', 'ENGLISH'),
('IN', 'INDONESIA'),
('JP', 'JAPAN');

--
-- Triggers `tb_m_language`
--
DROP TRIGGER IF EXISTS `setIdLanguage`;
DELIMITER $$
CREATE TRIGGER `setIdLanguage` BEFORE INSERT ON `tb_m_language` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdLanguage() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_lesson`
--

DROP TABLE IF EXISTS `tb_m_lesson`;
CREATE TABLE IF NOT EXISTS `tb_m_lesson` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `classes` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ls_TB_M_CLASSES_fk` (`classes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_lesson`
--

TRUNCATE TABLE `tb_m_lesson`;
--
-- Dumping data for table `tb_m_lesson`
--

INSERT INTO `tb_m_lesson` (`id`, `name`, `classes`) VALUES
('BL1', 'SDLC', 'Java'),
('BL10', 'DML', 'dotNet'),
('BL11', 'OracleDB', 'dotNet'),
('BL12', 'PLSQL', 'dotNet'),
('BL2', 'ERD', 'Java'),
('BL3', 'UML', 'Java'),
('BL4', 'DML', 'Java'),
('BL5', 'OracleDB', 'Java'),
('BL6', 'PLSQL', 'Java'),
('BL7', 'SDLC', 'dotNet'),
('BL8', 'ERD', 'dotNet'),
('BL9', 'UML', 'dotNet');

--
-- Triggers `tb_m_lesson`
--
DROP TRIGGER IF EXISTS `setIdLesson`;
DELIMITER $$
CREATE TRIGGER `setIdLesson` BEFORE INSERT ON `tb_m_lesson` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdLesson() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_locker`
--

DROP TABLE IF EXISTS `tb_m_locker`;
CREATE TABLE IF NOT EXISTS `tb_m_locker` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `lockernumber` decimal(30,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_locker`
--

TRUNCATE TABLE `tb_m_locker`;
--
-- Dumping data for table `tb_m_locker`
--

INSERT INTO `tb_m_locker` (`id`, `lockernumber`) VALUES
('EL1', '1'),
('EL2', '2'),
('EL3', '3'),
('EL4', '4');

--
-- Triggers `tb_m_locker`
--
DROP TRIGGER IF EXISTS `setIdLocker`;
DELIMITER $$
CREATE TRIGGER `setIdLocker` BEFORE INSERT ON `tb_m_locker` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdLocker() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_major`
--

DROP TABLE IF EXISTS `tb_m_major`;
CREATE TABLE IF NOT EXISTS `tb_m_major` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_major`
--

TRUNCATE TABLE `tb_m_major`;
--
-- Dumping data for table `tb_m_major`
--

INSERT INTO `tb_m_major` (`id`, `name`) VALUES
('CVM1', 'Teknik Informatika'),
('CVM2', 'Sistem Informatika'),
('CVM3', 'Management Informatika');

--
-- Triggers `tb_m_major`
--
DROP TRIGGER IF EXISTS `setIdMajor`;
DELIMITER $$
CREATE TRIGGER `setIdMajor` BEFORE INSERT ON `tb_m_major` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdMajor() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_parameter`
--

DROP TABLE IF EXISTS `tb_m_parameter`;
CREATE TABLE IF NOT EXISTS `tb_m_parameter` (
  `id` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `value` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `note` longtext COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_parameter`
--

TRUNCATE TABLE `tb_m_parameter`;
--
-- Dumping data for table `tb_m_parameter`
--

INSERT INTO `tb_m_parameter` (`id`, `value`, `note`) VALUES
('TB_M_ACCESS_CARD_ID_BEGIN', 'EAC', 'KODE AWALAN DARI ID'),
('TB_M_ASPECT_ID_BEGIN', 'BA', 'KODE AWALAN DARI ID'),
('TB_M_BATCH_CLASS_ID_BEGIN', 'BBC', 'KODE AWALAN DARI ID'),
('TB_M_CATEGORY_ID_BEGIN', 'CVCT', 'KODE AWALAN DARI ID'),
('TB_M_CERTIFICATE_ID_BEGIN', 'CVCF', 'KODE AWALAN DARI ID'),
('TB_M_COMPANY_ID_BEGIN', 'LC', 'KODE AWALAN DARI ID'),
('TB_M_DEGREE_ID_BEGIN', 'CVD', 'KODE AWALAN DARI ID'),
('TB_M_DISTRICT_ID_BEGIN', 'LD', 'KODE AWALAN DARI ID'),
('TB_M_EDUCATION_ID_BEGIN', 'CVE', 'KODE AWALAN DARI ID'),
('TB_M_EMPLOYEE_ID_BEGIN', '', 'KODE AWALAN DARI ID'),
('TB_M_EVALUATION_ID_BEGIN', 'BE', 'KODE AWALAN DARI ID'),
('TB_M_LANGUAGE_ID_BEGIN', '', 'KODE AWALAN DARI ID'),
('TB_M_LESSON_ID_BEGIN', 'BL', 'KODE AWALAN DARI ID'),
('TB_M_LOCKER_ID_BEGIN', 'EL', 'KODE AWALAN DARI ID'),
('TB_M_MAJOR_ID_BEGIN', 'CVM', 'KODE AWALAN DARI ID'),
('TB_M_PROVINCE_ID_BEGIN', 'LP', 'KODE AWALAN DARI ID'),
('TB_M_RELIGION_ID_BEGIN', 'CVR', 'KODE AWALAN DARI ID'),
('TB_M_ROLE_ID_BEGIN', 'CVR', 'KODE AWALAN DARI ID'),
('TB_M_ROOM_ID_BEGIN', 'BR', 'KODE AWALAN DARI ID'),
('TB_M_SKILL_ID_BEGIN', 'CVS', 'KODE AWALAN DARI ID'),
('TB_M_SUBDISTRICT_ID_BEGIN', 'LSD', 'KODE AWALAN DARI ID'),
('TB_M_TOPIC_ID_BEGIN', 'BT', 'KODE AWALAN DARI ID'),
('TB_M_UNIVERSITY_ID_BEGIN', 'CVU', 'KODE AWALAN DARI ID'),
('TB_M_VILLAGE_ID_BEGIN', 'LV', 'KODE AWALAN DARI ID'),
('TB_T_ACHIEVEMENT_ID_BEGIN', 'CVA', 'KODE AWALAN DARI ID'),
('TB_T_EDUCATION_HISTORY_ID_BEGIN', 'CVEH', 'KODE AWALAN DARI ID'),
('TB_T_EMPLOYEE_ACCESS_ID_BEGIN', 'EEA', 'KODE AWALAN DARI ID'),
('TB_T_EMPLOYEE_CERTIFICATION_ID_BEGIN', 'CVEC', 'KODE AWALAN DARI ID'),
('TB_T_EMPLOYEE_LANGUAGE_ID_BEGIN', 'CVEL', 'KODE AWALAN DARI ID'),
('TB_T_EMPLOYEE_LOCKER_ID_BEGIN', 'EEL', 'KODE AWALAN DARI ID'),
('TB_T_EMPLOYEE_ROLE_ID_BEGIN', 'CVER', 'KODE AWALAN DARI ID'),
('TB_T_EMPLOYEE_SKILL_ID_BEGIN', 'CVES', 'KODE AWALAN DARI ID'),
('TB_T_ERROR_BANK_ID_BEGIN', 'BEB', 'KODE AWALAN DARI ID'),
('TB_T_ID_CARD_ID_BEGIN', 'EIC', 'KODE AWALAN DARI ID'),
('TB_T_ORGANIZATION_ID_BEGIN', 'CVO', 'KODE AWALAN DARI ID'),
('TB_T_PARTICIPANT_ID_BEGIN', '', 'KODE AWALAN DARI ID'),
('TB_T_PLACEMENT_ID_BEGIN', 'LEP', 'KODE AWALAN DARI ID'),
('TB_T_SCORE_ID_BEGIN', 'BS', 'KODE AWALAN DARI ID'),
('TB_T_WORK_EXPERIENCE_ID_BEGIN', 'CVWE', 'KODE AWALAN DARI ID');

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_province`
--

DROP TABLE IF EXISTS `tb_m_province`;
CREATE TABLE IF NOT EXISTS `tb_m_province` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_province`
--

TRUNCATE TABLE `tb_m_province`;
--
-- Dumping data for table `tb_m_province`
--

INSERT INTO `tb_m_province` (`id`, `name`) VALUES
('LP1', 'DKI Jakarta'),
('LP2', 'DI Yogyakarta'),
('LP3', 'Riau');

--
-- Triggers `tb_m_province`
--
DROP TRIGGER IF EXISTS `setIdProvince`;
DELIMITER $$
CREATE TRIGGER `setIdProvince` BEFORE INSERT ON `tb_m_province` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdProvince() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_religion`
--

DROP TABLE IF EXISTS `tb_m_religion`;
CREATE TABLE IF NOT EXISTS `tb_m_religion` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_religion`
--

TRUNCATE TABLE `tb_m_religion`;
--
-- Dumping data for table `tb_m_religion`
--

INSERT INTO `tb_m_religion` (`id`, `name`) VALUES
('CVR1', 'Islam'),
('CVR2', 'Christian'),
('CVR3', 'Catholic'),
('CVR4', 'Hindu'),
('CVR5', 'Buddha');

--
-- Triggers `tb_m_religion`
--
DROP TRIGGER IF EXISTS `setIdReligion`;
DELIMITER $$
CREATE TRIGGER `setIdReligion` BEFORE INSERT ON `tb_m_religion` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdReligion() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_role`
--

DROP TABLE IF EXISTS `tb_m_role`;
CREATE TABLE IF NOT EXISTS `tb_m_role` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_role`
--

TRUNCATE TABLE `tb_m_role`;
--
-- Dumping data for table `tb_m_role`
--

INSERT INTO `tb_m_role` (`id`, `name`) VALUES
('CVR0', 'Admin'),
('CVR1', 'Direktor'),
('CVR2', 'Human Resource'),
('CVR3', 'Health, Safety, Environment'),
('CVR4', 'Developer');

--
-- Triggers `tb_m_role`
--
DROP TRIGGER IF EXISTS `setIdRole`;
DELIMITER $$
CREATE TRIGGER `setIdRole` BEFORE INSERT ON `tb_m_role` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdRole() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_room`
--

DROP TABLE IF EXISTS `tb_m_room`;
CREATE TABLE IF NOT EXISTS `tb_m_room` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_room`
--

TRUNCATE TABLE `tb_m_room`;
--
-- Dumping data for table `tb_m_room`
--

INSERT INTO `tb_m_room` (`id`, `name`) VALUES
('BR1', 'Miami'),
('BR2', 'Amsterdam'),
('BR3', 'Osaka'),
('BR4', 'Johannesburg');

--
-- Triggers `tb_m_room`
--
DROP TRIGGER IF EXISTS `setIdRoom`;
DELIMITER $$
CREATE TRIGGER `setIdRoom` BEFORE INSERT ON `tb_m_room` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdRoom() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_skill`
--

DROP TABLE IF EXISTS `tb_m_skill`;
CREATE TABLE IF NOT EXISTS `tb_m_skill` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `category` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `TB_M_CATEGORY_fk` (`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_skill`
--

TRUNCATE TABLE `tb_m_skill`;
--
-- Dumping data for table `tb_m_skill`
--

INSERT INTO `tb_m_skill` (`id`, `name`, `category`) VALUES
('CVS1', 'Java', 'CVCT1'),
('CVS2', '.Net', 'CVCT1'),
('CVS3', 'Java', 'CVCT2'),
('CVS4', 'PHP', 'CVCT2'),
('CVS5', 'Java', 'CVCT3'),
('CVS6', 'Mikrotik', 'CVCT4'),
('CVS7', 'Cisco', 'CVCT4');

--
-- Triggers `tb_m_skill`
--
DROP TRIGGER IF EXISTS `setIdSkill`;
DELIMITER $$
CREATE TRIGGER `setIdSkill` BEFORE INSERT ON `tb_m_skill` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdSkill() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_subdistrict`
--

DROP TABLE IF EXISTS `tb_m_subdistrict`;
CREATE TABLE IF NOT EXISTS `tb_m_subdistrict` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `district` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `TB_M_DISTRICT_fk` (`district`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_subdistrict`
--

TRUNCATE TABLE `tb_m_subdistrict`;
--
-- Dumping data for table `tb_m_subdistrict`
--

INSERT INTO `tb_m_subdistrict` (`id`, `name`, `district`) VALUES
('LSD1', 'Gambir', 'LD1'),
('LSD2', 'Penjaringan', 'LD2'),
('LSD3', 'Grogol Pertamburan', 'LD3'),
('LSD4', 'Kotagede', 'LD4'),
('LSD5', 'Ngaglik', 'LD5'),
('LSD6', 'Imogiri', 'LD6'),
('LSD7', 'Pekanbaru Kota', 'LD7'),
('LSD8', 'Mandau', 'LD8');

--
-- Triggers `tb_m_subdistrict`
--
DROP TRIGGER IF EXISTS `setIdSubdistrict`;
DELIMITER $$
CREATE TRIGGER `setIdSubdistrict` BEFORE INSERT ON `tb_m_subdistrict` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdSubdistrict() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_topic`
--

DROP TABLE IF EXISTS `tb_m_topic`;
CREATE TABLE IF NOT EXISTS `tb_m_topic` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_topic`
--

TRUNCATE TABLE `tb_m_topic`;
--
-- Dumping data for table `tb_m_topic`
--

INSERT INTO `tb_m_topic` (`id`, `name`) VALUES
('BT0', ''),
('BT1', '1st Project'),
('BT2', '2nd Project'),
('BT3', '3rd Project'),
('BT4', '4th Project'),
('BT5', '5th Project');

--
-- Triggers `tb_m_topic`
--
DROP TRIGGER IF EXISTS `setIdTopic`;
DELIMITER $$
CREATE TRIGGER `setIdTopic` BEFORE INSERT ON `tb_m_topic` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdTopic() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_university`
--

DROP TABLE IF EXISTS `tb_m_university`;
CREATE TABLE IF NOT EXISTS `tb_m_university` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `village` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `TB_M_VILLAGE_fk` (`village`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_university`
--

TRUNCATE TABLE `tb_m_university`;
--
-- Dumping data for table `tb_m_university`
--

INSERT INTO `tb_m_university` (`id`, `name`, `address`, `village`) VALUES
('CVU1', 'Universitas Amikom Yogyakarta', 'Yogyakarta', 'LV1'),
('CVU2', 'Universitas Gajah Mada', 'Yogyakarta', 'LV2'),
('CVU3', 'STIKES', 'Bandung', 'LV3'),
('CVU4', 'Universitas Sanata Dharma', 'Semarang', 'LV4'),
('CVU5', 'Universitas Islam Indonesia', 'Bali', 'LV5');

--
-- Triggers `tb_m_university`
--
DROP TRIGGER IF EXISTS `setIdUniversity`;
DELIMITER $$
CREATE TRIGGER `setIdUniversity` BEFORE INSERT ON `tb_m_university` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdUniversity() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_m_village`
--

DROP TABLE IF EXISTS `tb_m_village`;
CREATE TABLE IF NOT EXISTS `tb_m_village` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `subdistrict` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `subTB_M_DISTRICT_fk` (`subdistrict`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_m_village`
--

TRUNCATE TABLE `tb_m_village`;
--
-- Dumping data for table `tb_m_village`
--

INSERT INTO `tb_m_village` (`id`, `name`, `subdistrict`) VALUES
('LV1', 'Duri Pulo', 'LSD1'),
('LV2', 'Pluit', 'LSD2'),
('LV3', 'Tanjung Duren Selatan', 'LSD3'),
('LV4', 'Rejowinangun', 'LSD4'),
('LV5', 'Minomartani', 'LSD5'),
('LV6', 'Girirejo', 'LSD6'),
('LV7', 'Sumahilang', 'LSD7'),
('LV8', 'Pematang Pudu', 'LSD8');

--
-- Triggers `tb_m_village`
--
DROP TRIGGER IF EXISTS `setIdVillage`;
DELIMITER $$
CREATE TRIGGER `setIdVillage` BEFORE INSERT ON `tb_m_village` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdVillage() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_t_achievement`
--

DROP TABLE IF EXISTS `tb_t_achievement`;
CREATE TABLE IF NOT EXISTS `tb_t_achievement` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `isdeleted` tinyint(4) DEFAULT NULL,
  `employee` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ac_employee_fk` (`employee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_t_achievement`
--

TRUNCATE TABLE `tb_t_achievement`;
--
-- Dumping data for table `tb_t_achievement`
--

INSERT INTO `tb_t_achievement` (`id`, `name`, `isdeleted`, `employee`) VALUES
('CVA1', '1st Place Hackathon 2017', NULL, '14201');

--
-- Triggers `tb_t_achievement`
--
DROP TRIGGER IF EXISTS `setIdAchievement`;
DELIMITER $$
CREATE TRIGGER `setIdAchievement` BEFORE INSERT ON `tb_t_achievement` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdAchievement() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_t_educationhistory`
--

DROP TABLE IF EXISTS `tb_t_educationhistory`;
CREATE TABLE IF NOT EXISTS `tb_t_educationhistory` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `gpa` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `isdeleted` tinyint(4) DEFAULT NULL,
  `education` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `employee` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `TB_M_EDUCATION_fk` (`education`),
  KEY `eh_employee_fk` (`employee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_t_educationhistory`
--

TRUNCATE TABLE `tb_t_educationhistory`;
--
-- Dumping data for table `tb_t_educationhistory`
--

INSERT INTO `tb_t_educationhistory` (`id`, `gpa`, `isdeleted`, `education`, `employee`) VALUES
('CVEH1', '3.25', NULL, 'CVE10', '14313'),
('CVEH2', '3.5', NULL, 'CVE4', '14201');

--
-- Triggers `tb_t_educationhistory`
--
DROP TRIGGER IF EXISTS `setIdEducationHistory`;
DELIMITER $$
CREATE TRIGGER `setIdEducationHistory` BEFORE INSERT ON `tb_t_educationhistory` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdEducationHistory() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_t_employeeaccess`
--

DROP TABLE IF EXISTS `tb_t_employeeaccess`;
CREATE TABLE IF NOT EXISTS `tb_t_employeeaccess` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `receivedate` date NOT NULL,
  `returndate` date DEFAULT NULL,
  `notes` longtext COLLATE utf8_unicode_ci,
  `accesscard` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `employee` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ea_employee_fk` (`employee`),
  KEY `TB_M_ACCESS_CARD_fk` (`accesscard`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_t_employeeaccess`
--

TRUNCATE TABLE `tb_t_employeeaccess`;
--
-- Dumping data for table `tb_t_employeeaccess`
--

INSERT INTO `tb_t_employeeaccess` (`id`, `receivedate`, `returndate`, `notes`, `accesscard`, `employee`) VALUES
('EEA1', '2019-03-01', '2019-03-31', 'itu', 'EAC3', '14304');

--
-- Triggers `tb_t_employeeaccess`
--
DROP TRIGGER IF EXISTS `setIdEmployeeAccess`;
DELIMITER $$
CREATE TRIGGER `setIdEmployeeAccess` BEFORE INSERT ON `tb_t_employeeaccess` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdEmployeeAccess() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_t_employeecertification`
--

DROP TABLE IF EXISTS `tb_t_employeecertification`;
CREATE TABLE IF NOT EXISTS `tb_t_employeecertification` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `certificatedate` date DEFAULT NULL,
  `certificatenumber` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `isdeleted` tinyint(4) DEFAULT NULL,
  `certificate` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `employee` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `TB_M_CERTIFICATE_fk` (`certificate`),
  KEY `ec_employee_fk` (`employee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_t_employeecertification`
--

TRUNCATE TABLE `tb_t_employeecertification`;
--
-- Dumping data for table `tb_t_employeecertification`
--

INSERT INTO `tb_t_employeecertification` (`id`, `certificatedate`, `certificatenumber`, `isdeleted`, `certificate`, `employee`) VALUES
('CVEC1', '2017-09-20', '20/ASD/Ora5/09/2017', NULL, 'CVCF1', '14201');

--
-- Triggers `tb_t_employeecertification`
--
DROP TRIGGER IF EXISTS `setIdEmployeeCertification`;
DELIMITER $$
CREATE TRIGGER `setIdEmployeeCertification` BEFORE INSERT ON `tb_t_employeecertification` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdEmployeeCertification() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_t_employeelanguage`
--

DROP TABLE IF EXISTS `tb_t_employeelanguage`;
CREATE TABLE IF NOT EXISTS `tb_t_employeelanguage` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `score` double DEFAULT NULL,
  `isactive` tinyint(4) DEFAULT NULL,
  `isdeleted` tinyint(4) DEFAULT NULL,
  `language` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `employee` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `TB_M_LANGUAGE_fk` (`language`),
  KEY `el_employee_fk` (`employee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_t_employeelanguage`
--

TRUNCATE TABLE `tb_t_employeelanguage`;
--
-- Dumping data for table `tb_t_employeelanguage`
--

INSERT INTO `tb_t_employeelanguage` (`id`, `score`, `isactive`, `isdeleted`, `language`, `employee`) VALUES
('CVEL1', 10, 1, 0, 'IN', '14201'),
('CVEL10', 6.5, 0, 0, 'EN', '14303'),
('CVEL11', 8, 1, 0, 'EN', '14304'),
('CVEL12', 7.5, 1, 0, 'EN', '14305'),
('CVEL13', 6, 0, 0, 'EN', '14306'),
('CVEL14', 7, 0, 0, 'EN', '14307'),
('CVEL15', 5.5, 0, 0, 'CH', '14201'),
('CVEL16', 5.5, 0, 0, 'JP', '14202'),
('CVEL17', 5, 0, 0, 'CH', '14303'),
('CVEL18', 5, 0, 0, 'JP', '14304'),
('CVEL19', 5, 0, 0, 'CH', '14305'),
('CVEL2', 10, 1, 0, 'IN', '14202'),
('CVEL20', 5, 0, 0, 'CH', '14306'),
('CVEL21', 5, 0, 0, 'JP', '14307'),
('CVEL3', 9.75, 1, 0, 'IN', '14303'),
('CVEL4', 10, 1, 0, 'IN', '14304'),
('CVEL5', 8.25, 1, 0, 'IN', '14305'),
('CVEL6', 9.5, 1, 0, 'IN', '14306'),
('CVEL7', 9, 1, 0, 'IN', '14307'),
('CVEL8', 8.5, 1, 0, 'EN', '14201'),
('CVEL9', 8, 1, 0, 'EN', '14202');

--
-- Triggers `tb_t_employeelanguage`
--
DROP TRIGGER IF EXISTS `setIdEmployeeLanguage`;
DELIMITER $$
CREATE TRIGGER `setIdEmployeeLanguage` BEFORE INSERT ON `tb_t_employeelanguage` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdEmployeeLanguage() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_t_employeelocker`
--

DROP TABLE IF EXISTS `tb_t_employeelocker`;
CREATE TABLE IF NOT EXISTS `tb_t_employeelocker` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `receivedate` date NOT NULL,
  `returndate` date DEFAULT NULL,
  `notes` longtext COLLATE utf8_unicode_ci,
  `locker` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `employee` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `TB_M_LOCKER_fk` (`locker`),
  KEY `elk_employee_fk` (`employee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_t_employeelocker`
--

TRUNCATE TABLE `tb_t_employeelocker`;
--
-- Dumping data for table `tb_t_employeelocker`
--

INSERT INTO `tb_t_employeelocker` (`id`, `receivedate`, `returndate`, `notes`, `locker`, `employee`) VALUES
('EEL1', '2019-03-01', '2019-03-31', 'ok', 'EL1', '14201');

--
-- Triggers `tb_t_employeelocker`
--
DROP TRIGGER IF EXISTS `setIdEmployeeLocker`;
DELIMITER $$
CREATE TRIGGER `setIdEmployeeLocker` BEFORE INSERT ON `tb_t_employeelocker` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdEmployeeLocker() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_t_employeerole`
--

DROP TABLE IF EXISTS `tb_t_employeerole`;
CREATE TABLE IF NOT EXISTS `tb_t_employeerole` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `isdeleted` tinyint(4) DEFAULT NULL,
  `role` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `employee` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `TB_M_ROLE_fk` (`role`),
  KEY `er_employee_fk` (`employee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_t_employeerole`
--

TRUNCATE TABLE `tb_t_employeerole`;
--
-- Dumping data for table `tb_t_employeerole`
--

INSERT INTO `tb_t_employeerole` (`id`, `startdate`, `enddate`, `isdeleted`, `role`, `employee`) VALUES
('CVER2', '2018-01-01', '2020-12-31', 0, 'CVR0', '14201'),
('CVER3', '2018-01-01', '2020-12-31', 0, 'CVR4', '14202'),
('CVER4', '2019-01-01', '2020-02-28', 0, 'CVR4', '14303'),
('CVER5', '2019-01-01', '2020-02-28', 0, 'CVR4', '14304'),
('CVER6', '2019-02-01', '2020-03-31', 0, 'CVR4', '14305'),
('CVER7', '2019-02-01', '2020-03-31', 0, 'CVR4', '14306'),
('CVER8', '2019-03-01', '2019-04-30', 0, 'CVR4', '14307');

--
-- Triggers `tb_t_employeerole`
--
DROP TRIGGER IF EXISTS `setIdEmployeeRole`;
DELIMITER $$
CREATE TRIGGER `setIdEmployeeRole` BEFORE INSERT ON `tb_t_employeerole` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdEmployeeRole() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_t_employeeskill`
--

DROP TABLE IF EXISTS `tb_t_employeeskill`;
CREATE TABLE IF NOT EXISTS `tb_t_employeeskill` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `score` double DEFAULT NULL,
  `isdeleted` tinyint(4) DEFAULT NULL,
  `skill` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `employee` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `TB_M_SKILL_fk` (`skill`),
  KEY `es_employee_fk` (`employee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_t_employeeskill`
--

TRUNCATE TABLE `tb_t_employeeskill`;
--
-- Dumping data for table `tb_t_employeeskill`
--

INSERT INTO `tb_t_employeeskill` (`id`, `score`, `isdeleted`, `skill`, `employee`) VALUES
('CVES1', 8, 0, 'CVS1', '14201'),
('CVES10', 7.5, 0, 'CVS2', '14307'),
('CVES11', 6.5, 0, 'CVS3', '14303'),
('CVES12', 6, 0, 'CVS3', '14304'),
('CVES13', 6, 0, 'CVS3', '14305'),
('CVES2', 7, 0, 'CVS3', '14201'),
('CVES3', 7.5, 0, 'CVS5', '14201'),
('CVES4', 8.5, 0, 'CVS2', '14202'),
('CVES5', 7.5, 0, 'CVS1', '14202'),
('CVES6', 7, 0, 'CVS1', '14303'),
('CVES7', 6, 0, 'CVS1', '14304'),
('CVES8', 6.5, 0, 'CVS1', '14305'),
('CVES9', 7, 0, 'CVS2', '14306');

--
-- Triggers `tb_t_employeeskill`
--
DROP TRIGGER IF EXISTS `setIdEmployeeSkill`;
DELIMITER $$
CREATE TRIGGER `setIdEmployeeSkill` BEFORE INSERT ON `tb_t_employeeskill` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdEmployeeSkill() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_t_errorbank`
--

DROP TABLE IF EXISTS `tb_t_errorbank`;
CREATE TABLE IF NOT EXISTS `tb_t_errorbank` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `submitdate` date NOT NULL,
  `description` longtext COLLATE utf8_unicode_ci,
  `solution` longtext COLLATE utf8_unicode_ci,
  `isdeleted` tinyint(4) DEFAULT NULL,
  `classes` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `employee` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `eb_TB_M_CLASSES_fk` (`classes`),
  KEY `eb_employee_fk` (`employee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_t_errorbank`
--

TRUNCATE TABLE `tb_t_errorbank`;
--
-- Dumping data for table `tb_t_errorbank`
--

INSERT INTO `tb_t_errorbank` (`id`, `submitdate`, `description`, `solution`, `isdeleted`, `classes`, `employee`) VALUES
('BEB1', '2019-02-26', 'sd', 's', 0, 'Java', '14202'),
('BEB2', '2019-02-26', 's', 's', 0, 'Java', '14202'),
('BEB3', '2019-03-06', 'sdw', 'qwqwqwwwwww', 1, 'Java', '14303'),
('BEB4', '2019-03-29', 'hmhmmm', 'okokok', 0, 'Java', '14202'),
('BEB5', '2019-04-01', 'Ada Error', 'Ada Solusinya', 0, 'dotNet', '14307');

--
-- Triggers `tb_t_errorbank`
--
DROP TRIGGER IF EXISTS `setIdErrorBank`;
DELIMITER $$
CREATE TRIGGER `setIdErrorBank` BEFORE INSERT ON `tb_t_errorbank` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdErrorBank() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_t_idcard`
--

DROP TABLE IF EXISTS `tb_t_idcard`;
CREATE TABLE IF NOT EXISTS `tb_t_idcard` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `receivedate` date NOT NULL,
  `returndate` date DEFAULT NULL,
  `note` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `employee` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ic_employee_fk` (`employee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_t_idcard`
--

TRUNCATE TABLE `tb_t_idcard`;
--
-- Dumping data for table `tb_t_idcard`
--

INSERT INTO `tb_t_idcard` (`id`, `receivedate`, `returndate`, `note`, `employee`) VALUES
('EIC1', '2019-03-01', '2019-03-31', 'ini', '14303');

--
-- Triggers `tb_t_idcard`
--
DROP TRIGGER IF EXISTS `setIdIdCard`;
DELIMITER $$
CREATE TRIGGER `setIdIdCard` BEFORE INSERT ON `tb_t_idcard` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdIdCard() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_t_organization`
--

DROP TABLE IF EXISTS `tb_t_organization`;
CREATE TABLE IF NOT EXISTS `tb_t_organization` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `position` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `period` date DEFAULT NULL,
  `isdeleted` tinyint(4) DEFAULT NULL,
  `employee` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `or_employee_fk` (`employee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_t_organization`
--

TRUNCATE TABLE `tb_t_organization`;
--
-- Dumping data for table `tb_t_organization`
--

INSERT INTO `tb_t_organization` (`id`, `name`, `position`, `period`, `isdeleted`, `employee`) VALUES
('CVO1', 'asdasd', 'Manager', '2018-03-03', NULL, '14313'),
('CVO2', 'Biznis', 'Coding Team Leader', '2017-08-30', NULL, '14201');

--
-- Triggers `tb_t_organization`
--
DROP TRIGGER IF EXISTS `setIdOrganization`;
DELIMITER $$
CREATE TRIGGER `setIdOrganization` BEFORE INSERT ON `tb_t_organization` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdOrganization() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_t_participant`
--

DROP TABLE IF EXISTS `tb_t_participant`;
CREATE TABLE IF NOT EXISTS `tb_t_participant` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `grade` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `isdeleted` tinyint(4) DEFAULT NULL,
  `batchclass` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `TB_M_BATCH_CLASS_fk` (`batchclass`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_t_participant`
--

TRUNCATE TABLE `tb_t_participant`;
--
-- Dumping data for table `tb_t_participant`
--

INSERT INTO `tb_t_participant` (`id`, `grade`, `isdeleted`, `batchclass`) VALUES
('14303', 'B', 0, 'BBC1'),
('14304', '', 0, 'BBC1'),
('14305', 'B', 0, 'BBC2'),
('14306', 'B', 0, 'BBC2'),
('14307', '', 0, 'BBC1'),
('14308', '', 1, 'BBC2'),
('14312', '', 1, 'BBC2'),
('14313', '', 1, 'BBC3');

-- --------------------------------------------------------

--
-- Table structure for table `tb_t_placement`
--

DROP TABLE IF EXISTS `tb_t_placement`;
CREATE TABLE IF NOT EXISTS `tb_t_placement` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `description` longtext COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `department` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `finishdate` date DEFAULT NULL,
  `isdeleted` tinyint(4) DEFAULT NULL,
  `company` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `employee` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `TB_M_COMPANY_fk` (`company`),
  KEY `p_employee_fk` (`employee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_t_placement`
--

TRUNCATE TABLE `tb_t_placement`;
--
-- Dumping data for table `tb_t_placement`
--

INSERT INTO `tb_t_placement` (`id`, `description`, `address`, `department`, `startdate`, `finishdate`, `isdeleted`, `company`, `employee`) VALUES
('LEP1', 'Semoga berkah', 'Taman Delima', 'ABCD', '2019-04-01', '2019-06-30', NULL, 'LC1', '14305');

--
-- Triggers `tb_t_placement`
--
DROP TRIGGER IF EXISTS `setIdPlacement`;
DELIMITER $$
CREATE TRIGGER `setIdPlacement` BEFORE INSERT ON `tb_t_placement` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdPlacement() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_t_score`
--

DROP TABLE IF EXISTS `tb_t_score`;
CREATE TABLE IF NOT EXISTS `tb_t_score` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `rating` double DEFAULT NULL,
  `isdeleted` tinyint(4) DEFAULT NULL,
  `evaluation` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `aspect` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `TB_M_EVALUATION_fk` (`evaluation`),
  KEY `TB_M_ASPECT_fk` (`aspect`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_t_score`
--

TRUNCATE TABLE `tb_t_score`;
--
-- Dumping data for table `tb_t_score`
--

INSERT INTO `tb_t_score` (`id`, `rating`, `isdeleted`, `evaluation`, `aspect`) VALUES
('BS1', 77, 0, 'BE2', 'BA3'),
('BS10', 67, 0, 'BE4', 'BA6'),
('BS11', 65, 0, 'BE5', 'BA1'),
('BS12', 85, 0, 'BE5', 'BA2'),
('BS13', 95, 0, 'BE5', 'BA3'),
('BS14', 69, 0, 'BE5', 'BA4'),
('BS15', 63, 0, 'BE5', 'BA5'),
('BS16', 78, 0, 'BE5', 'BA6'),
('BS17', 60, 0, 'BE6', 'BA1'),
('BS18', 80, 0, 'BE6', 'BA2'),
('BS19', 82, 0, 'BE6', 'BA3'),
('BS2', 93, 1, 'BE2', 'BA6'),
('BS20', 70, 0, 'BE6', 'BA4'),
('BS21', 85, 0, 'BE6', 'BA5'),
('BS22', 80, 0, 'BE6', 'BA6'),
('BS23', 66, 0, 'BE7', 'BA1'),
('BS24', 92, 0, 'BE7', 'BA2'),
('BS25', 60, 0, 'BE7', 'BA3'),
('BS26', 71, 0, 'BE7', 'BA4'),
('BS27', 68, 0, 'BE7', 'BA5'),
('BS28', 79, 0, 'BE7', 'BA6'),
('BS29', 73, 0, 'BE8', 'BA1'),
('BS3', 22, 0, 'BE2', 'BA4'),
('BS30', 50, 0, 'BE8', 'BA2'),
('BS31', 50, 0, 'BE8', 'BA3'),
('BS4', 50, 0, 'BE3', 'BA4'),
('BS5', 82, 0, 'BE4', 'BA2'),
('BS6', 76, 0, 'BE4', 'BA1'),
('BS7', 65, 0, 'BE4', 'BA3'),
('BS8', 64, 0, 'BE4', 'BA4'),
('BS9', 73, 0, 'BE4', 'BA5');

--
-- Triggers `tb_t_score`
--
DROP TRIGGER IF EXISTS `setIdScore`;
DELIMITER $$
CREATE TRIGGER `setIdScore` BEFORE INSERT ON `tb_t_score` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdScore() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_t_workexperience`
--

DROP TABLE IF EXISTS `tb_t_workexperience`;
CREATE TABLE IF NOT EXISTS `tb_t_workexperience` (
  `id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `description` longtext COLLATE utf8_unicode_ci NOT NULL,
  `position` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `startdate` date NOT NULL,
  `enddate` date NOT NULL,
  `isdeleted` tinyint(4) DEFAULT NULL,
  `employee` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `we_employee_fk` (`employee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Truncate table before insert `tb_t_workexperience`
--

TRUNCATE TABLE `tb_t_workexperience`;
--
-- Dumping data for table `tb_t_workexperience`
--

INSERT INTO `tb_t_workexperience` (`id`, `name`, `description`, `position`, `startdate`, `enddate`, `isdeleted`, `employee`) VALUES
('CVWE1', 'Sun Microsystems', 'Java Fullstack Developer', 'Developer', '2017-01-01', '2017-12-31', 0, '14201'),
('CVWE3', 'Usaha Kelompok', 'IT Support', 'IT Dept.', '2018-05-01', '2018-12-31', 0, '14303'),
('CVWE4', 'Motiontale Studio', '2D Animator', 'Animator', '2018-03-01', '2018-12-31', 0, '14304'),
('CVWE5', 'Bukalapas', 'IT support CS', 'Customer Service', '2018-02-01', '2018-10-31', 0, '14305'),
('CVWE6', 'PT. Maju Makmur', 'FrontEnd Developer', 'IT Developer', '2018-06-01', '2018-11-30', 0, '14306'),
('CVWE7', 'PT. Telekomunikasi Indo', 'BackEnd Developer', 'IT Dept.', '2018-09-01', '2018-12-31', 0, '14307');

--
-- Triggers `tb_t_workexperience`
--
DROP TRIGGER IF EXISTS `setIdWorkExperience`;
DELIMITER $$
CREATE TRIGGER `setIdWorkExperience` BEFORE INSERT ON `tb_t_workexperience` FOR EACH ROW BEGIN
DECLARE getId varchar(20);
SELECT nextIdWorkExperience() INTO getId;
SET NEW.id = getId;
END
$$
DELIMITER ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_m_batchclass`
--
ALTER TABLE `tb_m_batchclass`
  ADD CONSTRAINT `TB_M_BATCH_fk` FOREIGN KEY (`batch`) REFERENCES `tb_m_batch` (`id`),
  ADD CONSTRAINT `TB_M_ROOM_fk` FOREIGN KEY (`room`) REFERENCES `tb_m_room` (`id`),
  ADD CONSTRAINT `bc_TB_M_CLASSES_fk` FOREIGN KEY (`classes`) REFERENCES `tb_m_classes` (`id`),
  ADD CONSTRAINT `trainer_fk` FOREIGN KEY (`trainer`) REFERENCES `tb_m_employee` (`id`);

--
-- Constraints for table `tb_m_company`
--
ALTER TABLE `tb_m_company`
  ADD CONSTRAINT `TB_M_COMPANY_TB_M_VILLAGE_fk` FOREIGN KEY (`village`) REFERENCES `tb_m_village` (`id`);

--
-- Constraints for table `tb_m_district`
--
ALTER TABLE `tb_m_district`
  ADD CONSTRAINT `TB_M_PROVINCE_fk` FOREIGN KEY (`province`) REFERENCES `tb_m_province` (`id`);

--
-- Constraints for table `tb_m_education`
--
ALTER TABLE `tb_m_education`
  ADD CONSTRAINT `TB_M_DEGREE_fk` FOREIGN KEY (`degree`) REFERENCES `tb_m_degree` (`id`),
  ADD CONSTRAINT `TB_M_MAJOR_fk` FOREIGN KEY (`major`) REFERENCES `tb_m_major` (`id`),
  ADD CONSTRAINT `TB_M_UNIVERSITY_fk` FOREIGN KEY (`university`) REFERENCES `tb_m_university` (`id`);

--
-- Constraints for table `tb_m_employee`
--
ALTER TABLE `tb_m_employee`
  ADD CONSTRAINT `TB_M_RELIGION_fk` FOREIGN KEY (`religion`) REFERENCES `tb_m_religion` (`id`),
  ADD CONSTRAINT `birthPlace_fk` FOREIGN KEY (`birthplace`) REFERENCES `tb_m_district` (`id`),
  ADD CONSTRAINT `emp_TB_M_VILLAGE_fk` FOREIGN KEY (`village`) REFERENCES `tb_m_village` (`id`),
  ADD CONSTRAINT `hiringLocation_fk` FOREIGN KEY (`hiringlocation`) REFERENCES `tb_m_district` (`id`);

--
-- Constraints for table `tb_m_evaluation`
--
ALTER TABLE `tb_m_evaluation`
  ADD CONSTRAINT `TB_M_LESSON_fk` FOREIGN KEY (`lesson`) REFERENCES `tb_m_lesson` (`id`),
  ADD CONSTRAINT `TB_M_TOPIC_fk` FOREIGN KEY (`topic`) REFERENCES `tb_m_topic` (`id`),
  ADD CONSTRAINT `ev_TB_T_PARTICIPANT_fk` FOREIGN KEY (`participant`) REFERENCES `tb_m_employee` (`id`);

--
-- Constraints for table `tb_m_lesson`
--
ALTER TABLE `tb_m_lesson`
  ADD CONSTRAINT `ls_TB_M_CLASSES_fk` FOREIGN KEY (`classes`) REFERENCES `tb_m_classes` (`id`);

--
-- Constraints for table `tb_m_skill`
--
ALTER TABLE `tb_m_skill`
  ADD CONSTRAINT `TB_M_CATEGORY_fk` FOREIGN KEY (`category`) REFERENCES `tb_m_category` (`id`);

--
-- Constraints for table `tb_m_subdistrict`
--
ALTER TABLE `tb_m_subdistrict`
  ADD CONSTRAINT `TB_M_DISTRICT_fk` FOREIGN KEY (`district`) REFERENCES `tb_m_district` (`id`);

--
-- Constraints for table `tb_m_university`
--
ALTER TABLE `tb_m_university`
  ADD CONSTRAINT `TB_M_VILLAGE_fk` FOREIGN KEY (`village`) REFERENCES `tb_m_village` (`id`);

--
-- Constraints for table `tb_m_village`
--
ALTER TABLE `tb_m_village`
  ADD CONSTRAINT `subTB_M_DISTRICT_fk` FOREIGN KEY (`subdistrict`) REFERENCES `tb_m_subdistrict` (`id`);

--
-- Constraints for table `tb_t_achievement`
--
ALTER TABLE `tb_t_achievement`
  ADD CONSTRAINT `ac_employee_fk` FOREIGN KEY (`employee`) REFERENCES `tb_m_employee` (`id`);

--
-- Constraints for table `tb_t_educationhistory`
--
ALTER TABLE `tb_t_educationhistory`
  ADD CONSTRAINT `TB_M_EDUCATION_fk` FOREIGN KEY (`education`) REFERENCES `tb_m_education` (`id`),
  ADD CONSTRAINT `eh_employee_fk` FOREIGN KEY (`employee`) REFERENCES `tb_m_employee` (`id`);

--
-- Constraints for table `tb_t_employeeaccess`
--
ALTER TABLE `tb_t_employeeaccess`
  ADD CONSTRAINT `TB_M_ACCESS_CARD_fk` FOREIGN KEY (`accesscard`) REFERENCES `tb_m_accesscard` (`id`),
  ADD CONSTRAINT `ea_employee_fk` FOREIGN KEY (`employee`) REFERENCES `tb_m_employee` (`id`);

--
-- Constraints for table `tb_t_employeecertification`
--
ALTER TABLE `tb_t_employeecertification`
  ADD CONSTRAINT `TB_M_CERTIFICATE_fk` FOREIGN KEY (`certificate`) REFERENCES `tb_m_certificate` (`id`),
  ADD CONSTRAINT `ec_employee_fk` FOREIGN KEY (`employee`) REFERENCES `tb_m_employee` (`id`);

--
-- Constraints for table `tb_t_employeelanguage`
--
ALTER TABLE `tb_t_employeelanguage`
  ADD CONSTRAINT `TB_M_LANGUAGE_fk` FOREIGN KEY (`language`) REFERENCES `tb_m_language` (`id`),
  ADD CONSTRAINT `el_employee_fk` FOREIGN KEY (`employee`) REFERENCES `tb_m_employee` (`id`);

--
-- Constraints for table `tb_t_employeelocker`
--
ALTER TABLE `tb_t_employeelocker`
  ADD CONSTRAINT `TB_M_LOCKER_fk` FOREIGN KEY (`locker`) REFERENCES `tb_m_locker` (`id`),
  ADD CONSTRAINT `elk_employee_fk` FOREIGN KEY (`employee`) REFERENCES `tb_m_employee` (`id`);

--
-- Constraints for table `tb_t_employeerole`
--
ALTER TABLE `tb_t_employeerole`
  ADD CONSTRAINT `TB_M_ROLE_fk` FOREIGN KEY (`role`) REFERENCES `tb_m_role` (`id`),
  ADD CONSTRAINT `er_employee_fk` FOREIGN KEY (`employee`) REFERENCES `tb_m_employee` (`id`);

--
-- Constraints for table `tb_t_employeeskill`
--
ALTER TABLE `tb_t_employeeskill`
  ADD CONSTRAINT `TB_M_SKILL_fk` FOREIGN KEY (`skill`) REFERENCES `tb_m_skill` (`id`),
  ADD CONSTRAINT `es_employee_fk` FOREIGN KEY (`employee`) REFERENCES `tb_m_employee` (`id`);

--
-- Constraints for table `tb_t_errorbank`
--
ALTER TABLE `tb_t_errorbank`
  ADD CONSTRAINT `eb_TB_M_CLASSES_fk` FOREIGN KEY (`classes`) REFERENCES `tb_m_classes` (`id`),
  ADD CONSTRAINT `eb_employee_fk` FOREIGN KEY (`employee`) REFERENCES `tb_m_employee` (`id`);

--
-- Constraints for table `tb_t_idcard`
--
ALTER TABLE `tb_t_idcard`
  ADD CONSTRAINT `ic_employee_fk` FOREIGN KEY (`employee`) REFERENCES `tb_m_employee` (`id`);

--
-- Constraints for table `tb_t_organization`
--
ALTER TABLE `tb_t_organization`
  ADD CONSTRAINT `or_employee_fk` FOREIGN KEY (`employee`) REFERENCES `tb_m_employee` (`id`);

--
-- Constraints for table `tb_t_participant`
--
ALTER TABLE `tb_t_participant`
  ADD CONSTRAINT `TB_M_BATCH_CLASS_fk` FOREIGN KEY (`batchclass`) REFERENCES `tb_m_batchclass` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `TB_T_PARTICIPANT_fk` FOREIGN KEY (`id`) REFERENCES `tb_m_employee` (`id`);

--
-- Constraints for table `tb_t_placement`
--
ALTER TABLE `tb_t_placement`
  ADD CONSTRAINT `TB_M_COMPANY_fk` FOREIGN KEY (`company`) REFERENCES `tb_m_company` (`id`),
  ADD CONSTRAINT `p_employee_fk` FOREIGN KEY (`employee`) REFERENCES `tb_m_employee` (`id`);

--
-- Constraints for table `tb_t_score`
--
ALTER TABLE `tb_t_score`
  ADD CONSTRAINT `TB_M_ASPECT_fk` FOREIGN KEY (`aspect`) REFERENCES `tb_m_aspect` (`id`),
  ADD CONSTRAINT `TB_M_EVALUATION_fk` FOREIGN KEY (`evaluation`) REFERENCES `tb_m_evaluation` (`id`);

--
-- Constraints for table `tb_t_workexperience`
--
ALTER TABLE `tb_t_workexperience`
  ADD CONSTRAINT `we_employee_fk` FOREIGN KEY (`employee`) REFERENCES `tb_m_employee` (`id`);


--
-- Metadata
--
USE `phpmyadmin`;

--
-- Metadata for table tb_m_accesscard
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_aspect
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_batch
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_batchclass
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_category
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_certificate
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_classes
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_company
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_degree
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_district
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_education
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_employee
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_evaluation
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_language
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_lesson
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_locker
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_major
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_parameter
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_province
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_religion
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_role
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_room
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_skill
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_subdistrict
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_topic
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_university
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_m_village
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_t_achievement
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_t_educationhistory
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_t_employeeaccess
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_t_employeecertification
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_t_employeelanguage
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_t_employeelocker
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_t_employeerole
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_t_employeeskill
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_t_errorbank
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_t_idcard
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_t_organization
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_t_participant
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_t_placement
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_t_score
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for table tb_t_workexperience
--

--
-- Truncate table before insert `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Truncate table before insert `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Truncate table before insert `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata for database bootcampmanagement2
--

--
-- Truncate table before insert `pma__bookmark`
--

TRUNCATE TABLE `pma__bookmark`;
--
-- Truncate table before insert `pma__relation`
--

TRUNCATE TABLE `pma__relation`;
--
-- Truncate table before insert `pma__savedsearches`
--

TRUNCATE TABLE `pma__savedsearches`;
--
-- Truncate table before insert `pma__central_columns`
--

TRUNCATE TABLE `pma__central_columns`;SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
