-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2020 at 11:47 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pingpong`
--

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE `player` (
  `id_player` int(11) NOT NULL,
  `nama_player1` varchar(30) NOT NULL,
  `nama_player2` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`id_player`, `nama_player1`, `nama_player2`) VALUES
(1, 'agel', 'putra'),
(2, 'radin', 'banu'),
(3, 'Agil', 'Banu'),
(4, 'agel', 'putra'),
(5, 'ageeel', 'put'),
(6, 'a', 'b'),
(7, 'a', 'b'),
(8, 'age', 'ageeer'),
(9, 'A', 'A'),
(10, 'agelll', 'geil'),
(11, 'ae', 'ea'),
(12, 'are', 'aer'),
(13, 'agel', 'putra'),
(14, 'ageel', 'putput'),
(15, 'agee', 'putttt'),
(16, 'a', 'bb'),
(17, 'ae', 'ea'),
(18, 'putrer', 'juan'),
(19, 'putra', 'erere'),
(20, 'agee', 'trere'),
(21, 'a', 'b'),
(22, 'g', 'h'),
(23, 'juju', 'pupu'),
(24, 'h', 'ai'),
(25, 'h', 'k'),
(26, 'j', 'l'),
(27, 'age', 'tre'),
(28, 'q', 'qw'),
(29, 'agel', 'gela'),
(30, 'l', 'p'),
(31, 'agel', 'gila'),
(32, 'Agel', 'Juan'),
(33, 'juju', 'wawa'),
(34, 'qw', 'qw'),
(35, 'q', 'q'),
(36, 's', 'u'),
(37, 'p', 'o'),
(38, 'k', 'c'),
(39, 'l', 'k'),
(40, 'q', 'q'),
(41, 'po', 'op'),
(42, 'poo', 'oop'),
(43, 'p', 'o'),
(44, 'r', 'k'),
(45, 'ada', 'saya'),
(46, '12', '13'),
(47, 'agil', 'put'),
(48, 'pu', 'put'),
(49, 'w', 'w'),
(50, 'agil', 'didin'),
(51, 'radin', 'ande'),
(52, 'gil', 'put'),
(53, 'habib', 'riziq'),
(54, 'farid', 'godd'),
(55, 'agel', 'gela'),
(56, 'desi', 'desiii'),
(57, 'agell', 'gelaa'),
(58, 'p', 'ut'),
(59, 'PUT', 'PUT'),
(60, 'ande', 'radin'),
(61, 'ande', 'radin');

-- --------------------------------------------------------

--
-- Table structure for table `score`
--

CREATE TABLE `score` (
  `id_score` int(11) NOT NULL,
  `skor_1` int(11) NOT NULL,
  `skor_2` int(11) NOT NULL,
  `id_player` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `score`
--

INSERT INTO `score` (`id_score`, `skor_1`, `skor_2`, `id_player`) VALUES
(1, 0, 0, 16),
(2, 0, 0, 11),
(3, 1, 2, 1),
(4, 1, 2, 1),
(5, 1, 2, 1),
(6, 1, 2, 1),
(8, 0, 10, 18),
(9, 10, 0, 20),
(10, 0, 0, 6),
(11, 4, 10, 23),
(12, 2, 10, 24),
(13, 0, 10, 27),
(14, 0, 10, 28),
(15, 10, 1, 29),
(16, 0, 10, 30),
(17, 0, 10, 31),
(18, 3, 10, 32),
(19, 0, 10, 35),
(20, 0, 10, 36),
(21, 0, 10, 37),
(22, 0, 3, 39),
(23, 0, 3, 42),
(24, 0, 3, 37),
(25, 0, 3, 45),
(26, 0, 3, 46),
(27, 3, 0, 47),
(28, 0, 3, 48),
(29, 3, 0, 49),
(30, 3, 2, 50),
(31, 0, 10, 52),
(32, 2, 10, 53),
(33, 0, 10, 60);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`id_player`);

--
-- Indexes for table `score`
--
ALTER TABLE `score`
  ADD PRIMARY KEY (`id_score`),
  ADD KEY `player_score` (`id_player`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `player`
--
ALTER TABLE `player`
  MODIFY `id_player` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT for table `score`
--
ALTER TABLE `score`
  MODIFY `id_score` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `score`
--
ALTER TABLE `score`
  ADD CONSTRAINT `player_score` FOREIGN KEY (`id_player`) REFERENCES `player` (`id_player`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
