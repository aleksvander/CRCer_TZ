-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Апр 14 2015 г., 12:22
-- Версия сервера: 5.6.20
-- Версия PHP: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `cafedb`
--

-- --------------------------------------------------------

--
-- Структура таблицы `cat`
--

CREATE TABLE IF NOT EXISTS `cat` (
`id` int(11) NOT NULL,
  `Name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Дамп данных таблицы `cat`
--

INSERT INTO `cat` (`id`, `Name`) VALUES
(1, 'Горячие'),
(2, 'Салаты'),
(3, 'Японская');

-- --------------------------------------------------------

--
-- Структура таблицы `menu`
--

CREATE TABLE IF NOT EXISTS `menu` (
`Id` int(11) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Catid` int(11) DEFAULT NULL,
  `Price` float DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=26 ;

--
-- Дамп данных таблицы `menu`
--

INSERT INTO `menu` (`Id`, `Name`, `Catid`, `Price`) VALUES
(1, 'Dragon', 3, -1),
(2, 'Soup Harcho', 3, 50),
(3, '???????? ????? 3', NULL, -1),
(4, 'Тест4', NULL, NULL),
(5, 'Тест5', NULL, NULL),
(6, '1', 2, 1),
(13, '123', 1, 123),
(17, '!21', 3, 12),
(18, '23', 2, 42),
(19, 'salat', 1, 12222),
(21, 'trytrh', 2, 123),
(24, '2', NULL, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cat`
--
ALTER TABLE `cat`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
 ADD PRIMARY KEY (`Id`), ADD KEY `catNameFK_idx` (`Catid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cat`
--
ALTER TABLE `cat`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=26;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `menu`
--
ALTER TABLE `menu`
ADD CONSTRAINT `catNameFK` FOREIGN KEY (`Catid`) REFERENCES `cat` (`id`) ON DELETE SET NULL ON UPDATE SET NULL;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
