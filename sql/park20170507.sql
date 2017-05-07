-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 07, 2017 at 02:18 PM
-- Server version: 5.7.14
-- PHP Version: 7.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `park`
--

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE `news` (
  `id` int(11) NOT NULL,
  `title` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `slug` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `content` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`id`, `title`, `slug`, `content`) VALUES
(1, 'title1', 'slug1', 'content1'),
(2, 'title2', 'title2', 'content2');

-- --------------------------------------------------------

--
-- Table structure for table `park_space`
--

CREATE TABLE `park_space` (
  `space_id` int(11) NOT NULL,
  `type` smallint(6) NOT NULL,
  `owner_id` int(11) NOT NULL,
  `space_no` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `valid_start_time` timestamp NOT NULL,
  `valid_end_time` timestamp NOT NULL,
  `status` smallint(6) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `park_space`
--

INSERT INTO `park_space` (`space_id`, `type`, `owner_id`, `space_no`, `valid_start_time`, `valid_end_time`, `status`) VALUES
(1, 2, 1, '十五号楼 202', '2017-05-07 12:26:30', '2017-09-27 12:26:30', 1),
(2, 2, 1, '十五号楼 203', '2017-05-07 12:29:30', '2019-09-27 12:26:30', 1),
(3, 2, 1, '十五号楼 204', '2017-05-07 12:29:42', '2019-09-27 12:26:30', 1),
(4, 2, 2, '12号楼 1204', '2017-05-07 12:30:13', '2019-09-27 12:26:30', 1),
(5, 2, 2, '12号楼 1205', '2017-05-07 12:30:25', '2019-09-27 12:26:30', 1),
(6, 2, 2, '12号楼 1206', '2017-05-07 12:30:33', '2019-09-27 12:26:30', 1),
(7, 2, 3, '13号楼 1301', '2017-05-07 12:30:44', '2019-09-27 12:26:30', 1),
(8, 2, 3, '13号楼 1302', '2017-05-07 12:30:51', '2019-09-27 12:26:30', 1),
(9, 2, 3, '13号楼 1303', '2017-05-07 12:30:56', '2019-09-27 12:26:30', 1);

-- --------------------------------------------------------

--
-- Table structure for table `rent`
--

CREATE TABLE `rent` (
  `rent_id` int(11) NOT NULL,
  `space_id` int(11) NOT NULL,
  `owner_id` int(11) NOT NULL,
  `price` decimal(16,0) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `delay_fee` decimal(16,0) NOT NULL,
  `bail` decimal(16,0) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `rent`
--

INSERT INTO `rent` (`rent_id`, `space_id`, `owner_id`, `price`, `start_time`, `end_time`, `delay_fee`, `bail`) VALUES
(1, 1, 1, '5', '2017-05-01 12:00:00', '2017-05-02 12:00:00', '4', '200'),
(2, 2, 1, '5', '2017-05-01 12:00:00', '2017-05-02 12:00:00', '5', '200'),
(3, 4, 2, '8', '2017-05-01 12:00:00', '2017-05-02 12:00:00', '6', '200');

-- --------------------------------------------------------

--
-- Table structure for table `reserve`
--

CREATE TABLE `reserve` (
  `reserve_id` bigint(20) NOT NULL,
  `rent_id` int(11) NOT NULL,
  `space_id` int(11) NOT NULL,
  `owner_id` int(11) NOT NULL,
  `request_user_id` int(11) NOT NULL,
  `warrantor_id` int(11) NOT NULL,
  `start_time` timestamp NOT NULL,
  `end_time` datetime NOT NULL,
  `status` smallint(6) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `reserve`
--

INSERT INTO `reserve` (`reserve_id`, `rent_id`, `space_id`, `owner_id`, `request_user_id`, `warrantor_id`, `start_time`, `end_time`, `status`) VALUES
(1, 0, 1, 1, 4, 9, '2017-04-30 16:00:00', '2017-05-03 12:00:00', 3),
(2, 0, 2, 1, 4, 10, '2017-04-30 16:00:00', '2017-05-02 12:00:00', 3),
(3, 0, 4, 2, 5, 12, '2017-04-30 16:00:00', '2017-05-02 12:15:00', 3);

-- --------------------------------------------------------

--
-- Table structure for table `tuser`
--

CREATE TABLE `tuser` (
  `user_id` int(11) NOT NULL,
  `owner_flg` tinyint(1) NOT NULL,
  `warrantor_flg` int(11) NOT NULL,
  `request_user_flg` int(11) NOT NULL,
  `guard_flg` int(11) NOT NULL,
  `community_manager_flg` int(11) NOT NULL,
  `phone` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `mail` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `password_hash` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `salt` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `nickname` varchar(24) COLLATE utf8_unicode_ci NOT NULL,
  `realname` varchar(24) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tuser`
--

INSERT INTO `tuser` (`user_id`, `owner_flg`, `warrantor_flg`, `request_user_flg`, `guard_flg`, `community_manager_flg`, `phone`, `mail`, `password_hash`, `salt`, `nickname`, `realname`) VALUES
(1, 1, 0, 0, 0, 0, '14433433456', '14433433456@qq.com', '', '', 'nickname14433433456', 'realname14433433456'),
(2, 1, 0, 0, 0, 0, '15843556789', '15843556789@qq.com', '', '', 'nickname14433433456', 'realname14433433456'),
(3, 1, 0, 0, 0, 0, '18640842899', '18640842899@qq.com', '', '', 'nick18640842899', 'real18640842899'),
(4, 0, 0, 0, 0, 0, '18000000001', '18000000001@qq.com', '', '', 'nick18000000001', 'real18000000001'),
(5, 0, 0, 0, 0, 0, '18000000002', '18000000002@qq.com', '', '', 'nick18000000002', 'real18000000002'),
(6, 0, 0, 0, 0, 0, '18000000003', '18000000003@qq.com', '', '', 'nick18000000003', 'real18000000003'),
(7, 0, 0, 0, 0, 0, '18000000004', '18000000004@qq.com', '', '', 'nick18000000004', 'real18000000004'),
(8, 0, 0, 0, 0, 0, '18000000005', '18000000005@qq.com', '', '', 'nick18000000005', 'real18000000005'),
(9, 0, 0, 0, 0, 0, '13800000001', '13800000001@qq.com', '', '', 'nick13800000001', 'real13800000001'),
(10, 0, 0, 0, 0, 0, '13800000002', '13800000002@qq.com', '', '', 'nick13800000002', 'real13800000002'),
(11, 0, 0, 0, 0, 0, '13800000003', '13800000003@qq.com', '', '', 'nick13800000003', 'real13800000003');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`),
  ADD KEY `slug` (`slug`);

--
-- Indexes for table `park_space`
--
ALTER TABLE `park_space`
  ADD PRIMARY KEY (`space_id`);

--
-- Indexes for table `rent`
--
ALTER TABLE `rent`
  ADD PRIMARY KEY (`rent_id`);

--
-- Indexes for table `reserve`
--
ALTER TABLE `reserve`
  ADD PRIMARY KEY (`reserve_id`);

--
-- Indexes for table `tuser`
--
ALTER TABLE `tuser`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `news`
--
ALTER TABLE `news`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `park_space`
--
ALTER TABLE `park_space`
  MODIFY `space_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `rent`
--
ALTER TABLE `rent`
  MODIFY `rent_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `reserve`
--
ALTER TABLE `reserve`
  MODIFY `reserve_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tuser`
--
ALTER TABLE `tuser`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
