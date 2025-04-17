-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 28, 2024 at 08:17 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `t2h`
--

-- --------------------------------------------------------

--
-- Table structure for table `corder`
--

CREATE TABLE `corder` (
  `oid` int(11) NOT NULL,
  `weight` varchar(20) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `ostatus` varchar(20) DEFAULT NULL,
  `reclat` varchar(20) DEFAULT NULL,
  `reclng` varchar(20) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `recname` varchar(50) DEFAULT NULL,
  `recmobile` varchar(10) DEFAULT NULL,
  `tostation` int(11) DEFAULT NULL,
  `fromstation` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `corder`
--

INSERT INTO `corder` (`oid`, `weight`, `date`, `time`, `amount`, `ostatus`, `reclat`, `reclng`, `cid`, `recname`, `recmobile`, `tostation`, `fromstation`) VALUES
(32, '450', '2024-02-27', '19:03:13', NULL, 'Placed', '6.726924711080657', '80.39740810785007', 1, 'tharuka pathiranage', '0712342313', 3, 2),
(33, '450', '2024-02-27', '19:06:13', NULL, 'Placed', '6.726924711080657', '80.39740810785007', 1, 'tharuka pathiranage', '0712342313', 3, 2),
(34, '450', '2024-02-27', '19:06:37', NULL, 'Placed', '6.726924711080657', '80.39740810785007', 1, 'tharuka pathiranage', '0712342313', 3, 2),
(35, '450', '2024-02-27', '19:06:58', NULL, 'Placed', '6.726924711080657', '80.39740810785007', 1, 'tharuka pathiranage', '0712342313', 3, 2),
(36, '450', '2024-02-27', '19:07:48', NULL, 'Placed', '6.726924711080657', '80.39740810785007', 1, 'tharuka pathiranage', '0712342313', 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `cus`
--

CREATE TABLE `cus` (
  `cid` int(11) NOT NULL,
  `fname` varchar(20) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `nic` varchar(20) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `lat` varchar(20) DEFAULT NULL,
  `lon` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cus`
--

INSERT INTO `cus` (`cid`, `fname`, `lname`, `nic`, `mobile`, `type`, `email`, `pwd`, `lat`, `lon`) VALUES
(1, 'gemba', 'nuge', '983171389v', '0710773633', 'user', 'gembanuge@gmail.com', '123', '6.833156128076833', '80.04177880287169'),
(3, 'lesmi', 'rale', '2332232323v', '0711231231', 'user', 'rale@gmail.com', 'rale123', '6.821464854841864', '80.04162311553955'),
(4, 'pulasthi', 'rajapaksha', '200179704268', '0766104767', 'user', 'pulasthi@gmail.com', 'pula2001', '7.021569086643644', '79.98040437698364');

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `did` int(11) NOT NULL,
  `fname` varchar(20) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `nic` varchar(20) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `v` int(11) DEFAULT NULL,
  `vid` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `cstatus` varchar(10) DEFAULT NULL,
  `lat` varchar(20) DEFAULT NULL,
  `lng` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `orderdriver`
--

CREATE TABLE `orderdriver` (
  `oid` int(11) NOT NULL,
  `did` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ordertstation`
--

CREATE TABLE `ordertstation` (
  `oid` int(11) NOT NULL,
  `tsid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tadmin`
--

CREATE TABLE `tadmin` (
  `tid` int(11) NOT NULL,
  `fname` varchar(20) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `nic` varchar(20) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tadminorder`
--

CREATE TABLE `tadminorder` (
  `oid` int(11) NOT NULL,
  `tid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tadmintstation`
--

CREATE TABLE `tadmintstation` (
  `tid` int(11) NOT NULL,
  `tsid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tstation`
--

CREATE TABLE `tstation` (
  `tsid` int(11) NOT NULL,
  `station` varchar(50) DEFAULT NULL,
  `lat` varchar(20) DEFAULT NULL,
  `lng` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tstation`
--

INSERT INTO `tstation` (`tsid`, `station`, `lat`, `lng`) VALUES
(1, 'Fort Railway station', '6.934073849763641', '79.84999801523931'),
(2, 'Matara Railway station', '5.95190716591961', '80.54363136863552'),
(3, 'Awissawella Railway station', '6.955093771099838', '80.2073890070397'),
(4, 'Polgahawela Railway station', '7.331211526466519', '80.30089416986107'),
(5, 'Ragama Railway station', '7.0300188141479545', '79.9215821591468'),
(6, 'Mahawa Railway station', '7.82288790860052', '80.27541515886763'),
(7, 'Peradeniya Railway station', '7.2571915138717875', '80.59008611742064'),
(8, 'Matale Railway station', '7.468007802219799', '80.6248163760032'),
(9, 'Badulla Railway station', '6.980278371211582', '81.05971228776583');

-- --------------------------------------------------------

--
-- Table structure for table `vtype`
--

CREATE TABLE `vtype` (
  `v` int(11) NOT NULL,
  `vname` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `corder`
--
ALTER TABLE `corder`
  ADD PRIMARY KEY (`oid`),
  ADD KEY `cid` (`cid`),
  ADD KEY `fk_tostation` (`tostation`),
  ADD KEY `fk_fromstation` (`fromstation`);

--
-- Indexes for table `cus`
--
ALTER TABLE `cus`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`did`),
  ADD KEY `v` (`v`);

--
-- Indexes for table `orderdriver`
--
ALTER TABLE `orderdriver`
  ADD PRIMARY KEY (`oid`,`did`),
  ADD KEY `did` (`did`);

--
-- Indexes for table `ordertstation`
--
ALTER TABLE `ordertstation`
  ADD PRIMARY KEY (`oid`,`tsid`),
  ADD KEY `tsid` (`tsid`);

--
-- Indexes for table `tadmin`
--
ALTER TABLE `tadmin`
  ADD PRIMARY KEY (`tid`);

--
-- Indexes for table `tadminorder`
--
ALTER TABLE `tadminorder`
  ADD PRIMARY KEY (`oid`,`tid`),
  ADD KEY `tid` (`tid`);

--
-- Indexes for table `tadmintstation`
--
ALTER TABLE `tadmintstation`
  ADD PRIMARY KEY (`tid`,`tsid`),
  ADD KEY `tsid` (`tsid`);

--
-- Indexes for table `tstation`
--
ALTER TABLE `tstation`
  ADD PRIMARY KEY (`tsid`);

--
-- Indexes for table `vtype`
--
ALTER TABLE `vtype`
  ADD PRIMARY KEY (`v`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `corder`
--
ALTER TABLE `corder`
  MODIFY `oid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `cus`
--
ALTER TABLE `cus`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `driver`
--
ALTER TABLE `driver`
  MODIFY `did` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tadmin`
--
ALTER TABLE `tadmin`
  MODIFY `tid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tstation`
--
ALTER TABLE `tstation`
  MODIFY `tsid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `vtype`
--
ALTER TABLE `vtype`
  MODIFY `v` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `corder`
--
ALTER TABLE `corder`
  ADD CONSTRAINT `corder_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `cus` (`cid`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_fromstation` FOREIGN KEY (`fromstation`) REFERENCES `tstation` (`tsid`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_tostation` FOREIGN KEY (`tostation`) REFERENCES `tstation` (`tsid`) ON DELETE CASCADE;

--
-- Constraints for table `driver`
--
ALTER TABLE `driver`
  ADD CONSTRAINT `driver_ibfk_1` FOREIGN KEY (`v`) REFERENCES `vtype` (`v`) ON DELETE CASCADE;

--
-- Constraints for table `orderdriver`
--
ALTER TABLE `orderdriver`
  ADD CONSTRAINT `orderdriver_ibfk_1` FOREIGN KEY (`oid`) REFERENCES `corder` (`oid`) ON DELETE CASCADE,
  ADD CONSTRAINT `orderdriver_ibfk_2` FOREIGN KEY (`did`) REFERENCES `driver` (`did`) ON DELETE CASCADE;

--
-- Constraints for table `ordertstation`
--
ALTER TABLE `ordertstation`
  ADD CONSTRAINT `ordertstation_ibfk_1` FOREIGN KEY (`oid`) REFERENCES `corder` (`oid`) ON DELETE CASCADE,
  ADD CONSTRAINT `ordertstation_ibfk_2` FOREIGN KEY (`tsid`) REFERENCES `tstation` (`tsid`) ON DELETE CASCADE;

--
-- Constraints for table `tadminorder`
--
ALTER TABLE `tadminorder`
  ADD CONSTRAINT `tadminorder_ibfk_1` FOREIGN KEY (`oid`) REFERENCES `corder` (`oid`) ON DELETE CASCADE,
  ADD CONSTRAINT `tadminorder_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `tadmin` (`tid`) ON DELETE CASCADE;

--
-- Constraints for table `tadmintstation`
--
ALTER TABLE `tadmintstation`
  ADD CONSTRAINT `tadmintstation_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `tadmin` (`tid`) ON DELETE CASCADE,
  ADD CONSTRAINT `tadmintstation_ibfk_2` FOREIGN KEY (`tsid`) REFERENCES `tstation` (`tsid`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
