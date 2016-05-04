-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 28, 2016 at 07:35 AM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 7.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eventit_app`
--

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `EventID` int(11) NOT NULL,
  `User` varchar(50) NOT NULL,
  `EventName` varchar(100) NOT NULL,
  `Descr` longtext NOT NULL,
  `Venue` varchar(50) NOT NULL,
  `Time` time NOT NULL,
  `Date` date NOT NULL,
  `TotalTicket` int(11) NOT NULL,
  `Status` char(5) NOT NULL,
  `Category` varchar(100) NOT NULL,
  `Rating` double DEFAULT '0',
  `total_rating` int(100) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`EventID`, `User`, `EventName`, `Descr`, `Venue`, `Time`, `Date`, `TotalTicket`, `Status`, `Category`, `Rating`, `total_rating`) VALUES
(1, '1', 'sample event', '', 'hi', '00:00:00', '2016-04-29', 2, 'A', '', 0, 0),
(2, '1', 'sd', 'das', 'asdas', '02:00:00', '2016-04-26', 12, 'A', 'category3', 0, 0),
(3, '1', 'asasd', 'asd', 'asd', '03:30:00', '2016-04-26', 123, 'A', 'Education', 0, 0),
(5, '1', 'testing event', 'testing eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting eventtesting event', 'India', '06:35:42', '2016-03-01', 123, 'A', 'Education', 3, 1),
(6, '1', 'asdasd', 'asdasd', 'asdasd', '02:00:00', '2016-04-30', 12, 'A', 'Financial', 0, 0),
(7, '1', 'asdasd', 'asdasd', 'asdasd', '02:00:00', '2016-04-30', 12, 'A', 'Financial', 0, 0),
(8, '1', 'asdasdsad', 'aasdasd', 'asdasd', '01:30:00', '2016-04-28', 12, 'A', 'Coporate', 0, 0),
(9, '2', 'adasd', 'asdasd', 'asdasd', '01:00:00', '2016-04-28', 12, 'A', 'Financial', 0, 0),
(10, '2', 'adsad', 'asdasd', 'sdasda', '00:30:00', '2016-04-28', 123213, 'A', 'Financial', 0, 0),
(11, 'naveenrajp.erode@gmail.com', 'Testing the event', 'Naveenraj creating this event to test it', 'dallas', '02:00:00', '2016-04-30', 1231, 'A', 'Coporate', 0, 0),
(12, 'naveenrajp.erode@gmail.com', 'naveenraj creating event', 'asdas asdasd adadads ', 'adas', '01:30:00', '2016-04-29', 12, 'P', 'others', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE `registration` (
  `ticketid` int(11) NOT NULL,
  `userid` varchar(50) NOT NULL,
  `eventid` int(11) NOT NULL,
  `rateing` int(100) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`ticketid`, `userid`, `eventid`, `rateing`) VALUES
(11, '1', 1, 0),
(13, '1', 5, 3),
(14, 'naveenrajp.erode@gmail.com', 6, 0);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `Email` varchar(50) NOT NULL,
  `Password` varchar(250) NOT NULL,
  `FirstName` varchar(25) NOT NULL,
  `LastName` varchar(25) NOT NULL,
  `Phone` varchar(10) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Rating` double NOT NULL DEFAULT '0',
  `total_rating` int(100) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Email`, `Password`, `FirstName`, `LastName`, `Phone`, `Address`, `Rating`, `total_rating`) VALUES
('3', '3', '3', '3', '3', '3adasda', 0, 0),
('4', '4', '4', '4', '4', '4', 0, 0),
('6', '6', '6', '6', '6', '6', 0, 0),
('7', '7', '7', '7', '7', '7', 0, 0),
('9', '9', '9', '9', '9', '9', 0, 0),
('a', 'a', 'a', 'a', 'a', 'a', 0, 0),
('addhivya@gmail.com', '12345678', 'Divya', 'Amaravathy', '8553449980', 'Number 10 viba, Muneerreddy layout.', 0, 0),
('admin', 'admin_naveenrajceg', 'admin', '', '', '', 0, 0),
('asdasd', 'asdasd', 'asd', 'asdasd', 'asd', 'asd', 0, 0),
('krushers@gmail.com', '12345678', 'A', 'D', '8553449980', 'oracle bangalore', 0, 0),
('naveenrajceg13@gmail.com', '123456789', 'naveen', 'raj', '9742048033', 'oracle bangalore', 0, 0),
('naveenrajp.erode@gmail.com', 'random12390812312randomcannotcreackthis', 'Naveenraj Palanisamy', '', '4699961744', '166, k.kulam,Sathymainroad', 0, 0),
('sample@saDmple.com', 'sample', 'sample', 'sample', '1323312', 'sdADASDS', 0, 0),
('tvvkadmits@gmail.com', 'asdf1234', 'sample', 'sample', '1323312', 'sdADASDS', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `worklist`
--

CREATE TABLE `worklist` (
  `EventID` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `worklist`
--

INSERT INTO `worklist` (`EventID`) VALUES
(12);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`EventID`);

--
-- Indexes for table `registration`
--
ALTER TABLE `registration`
  ADD PRIMARY KEY (`userid`,`eventid`),
  ADD UNIQUE KEY `ticketid` (`ticketid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Email`);

--
-- Indexes for table `worklist`
--
ALTER TABLE `worklist`
  ADD PRIMARY KEY (`EventID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `registration`
--
ALTER TABLE `registration`
  MODIFY `ticketid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
