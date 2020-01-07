-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 07, 2020 at 08:30 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tic_tac_toe`
--

-- --------------------------------------------------------

--
-- Table structure for table `Game`
--

CREATE TABLE `Game` (
  `GID` int(11) NOT NULL,
  `PXID` int(11) NOT NULL,
  `POID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Game`
--

INSERT INTO `Game` (`GID`, `PXID`, `POID`) VALUES
(1, 4, 9);

-- --------------------------------------------------------

--
-- Table structure for table `P_Positions`
--

CREATE TABLE `P_Positions` (
  `GID` int(11) NOT NULL,
  `PID` int(11) NOT NULL,
  `POS1` int(11) DEFAULT NULL,
  `POS2` int(11) DEFAULT NULL,
  `POS3` int(11) DEFAULT NULL,
  `POS4` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `P_Positions`
--
;

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE `User` (
  `UID` int(11) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Fullname` varchar(255) NOT NULL,
  `Gender` varchar(1) NOT NULL,
  `Score` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `User`
--


--
-- Indexes for dumped tables
--

--
-- Indexes for table `Game`
--
ALTER TABLE `Game`
  ADD PRIMARY KEY (`GID`),
  ADD KEY `POID` (`POID`),
  ADD KEY `PXID` (`PXID`);

--
-- Indexes for table `P_Positions`
--
ALTER TABLE `P_Positions`
  ADD PRIMARY KEY (`GID`,`PID`),
  ADD KEY `PID` (`PID`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`UID`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Game`
--
ALTER TABLE `Game`
  MODIFY `GID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `User`
--
ALTER TABLE `User`
  MODIFY `UID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Game`
--
ALTER TABLE `Game`
  ADD CONSTRAINT `Game_ibfk_1` FOREIGN KEY (`POID`) REFERENCES `User` (`UID`),
  ADD CONSTRAINT `Game_ibfk_2` FOREIGN KEY (`POID`) REFERENCES `User` (`UID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Game_ibfk_3` FOREIGN KEY (`PXID`) REFERENCES `User` (`UID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `P_Positions`
--
ALTER TABLE `P_Positions`
  ADD CONSTRAINT `P_Positions_ibfk_1` FOREIGN KEY (`GID`) REFERENCES `Game` (`GID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `P_Positions_ibfk_2` FOREIGN KEY (`PID`) REFERENCES `User` (`UID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
