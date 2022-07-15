-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 12, 2022 at 11:16 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bakery_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `bread_table`
--

CREATE TABLE `bread_table` (
  `bread_customer_id` int(250) NOT NULL,
  `bread_type` varchar(100) NOT NULL,
  `price` double(10, 2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bread_table`
--

INSERT INTO `bread_table` (`bread_customer_id`, `bread_type`, `price`) VALUES
(2, 'Breadsticks', 35.00),
(3, 'Donut', 80.00),
(4, 'Brown', 30.00),
(8, 'White ', 30.00),
(9, 'Wheat', 35.00),
(10, 'Rye ', 200.00),
(16, 'Hot dog bun', 35.00);

-- --------------------------------------------------------

--
-- Table structure for table `cake_table`
--

CREATE TABLE `cake_table` (
  `cake_customer_id` int(10) NOT NULL,
  `flavour` varchar(1000) NOT NULL,
  `weight` float NOT NULL,
  `price` double(10, 2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cake_table`
--

INSERT INTO `cake_table` (`cake_customer_id`, `flavour`, `weight`, `price`) VALUES
(1, 'Pinnata Cake', 0.5, 600.00),
(2, 'Blueberry Cake     ', 0.5, 400.00),
(2, 'Blueberry Cake     ', 0.5, 400.00),
(3, 'Caramel Cake', 1, 850.00),
(4, 'Whiteforest Cake  ', 0.5, 350.00),
(5, 'Pinnata Cake', 0.5, 600.00),
(6, 'Funfetti Cake', 1.5, 1350.00),
(8, 'Funfetti Cake', 1.5, 1350.00),
(9, 'Bomb Cake', 0.5, 850.00),
(10, 'Truffle Cake ', 0.5, 300.00),
(11, 'Funfetti Cake', 0.5, 450.00),
(12, 'Pinnata Cake', 1, 1200.00),
(13, 'Pinnata Cake', 0.5, 600.00),
(14, 'Truffle Cake ', 0.5, 300.00),
(15, 'Whiteforest Cake  ', 0.5, 350.00),
(15, 'Whiteforest Cake  ', 0.5, 350.00),
(16, 'Fruit Cake', 0.5, 375.00),
(16, 'Fruit Cake', 0.5, 375.00);

-- --------------------------------------------------------

--
-- Table structure for table `choco_table`
--

CREATE TABLE `choco_table` (
  `choco_customer_id` int(250) NOT NULL,
  `choco_type` varchar(100) NOT NULL,
  `price` double(10, 2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `choco_table`
--

INSERT INTO `choco_table` (`choco_customer_id`, `choco_type`, `price`) VALUES
(2, 'Dairy milk.', 20.00),
(5, 'Dairy milk.', 20.00),
(6, 'Five Star. ', 10.00),
(9, 'Dairy milk.', 20.00),
(14, 'Dairy milk.', 20.00),
(15, 'Five Star. ', 10.00);

-- --------------------------------------------------------

--
-- Table structure for table `decorative_table`
--

CREATE TABLE `decorative_table` (
  `deco_customer_id` int(255) NOT NULL,
  `deco_item` varchar(100) NOT NULL,
  `price` double(10, 2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `decorative_table`
--

INSERT INTO `decorative_table` (`deco_customer_id`, `deco_item`, `price`) VALUES
(2, 'Birthday Cap', 20.00),
(3, 'Lotus Lamp', 110.00),
(3, 'Candles', 10.00),
(6, 'Party Bomb', 170.00),
(9, 'HBD Balloons', 200.00),
(10, 'Lotus Lamp', 110.00),
(11, 'Lotus Lamp', 110.00),
(13, 'Snow Spary', 30.00),
(14, 'Candles', 10.00),
(15, 'Lotus Lamp', 110.00),
(16, 'Birthday Cap', 20.00);

-- --------------------------------------------------------

--
-- Table structure for table `feedback_table`
--

CREATE TABLE `feedback_table` (
  `feedback_customer_id` int(250) NOT NULL,
  `cust_name` varchar(100) NOT NULL,
  `customer_feedback` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedback_table`
--

INSERT INTO `feedback_table` (`feedback_customer_id`, `cust_name`, `customer_feedback`) VALUES
(1, 'Shrutika Mahajan', 'The products are excellent, especially like the Red Velvet Cake. \nWe also purchased a Pianata Cake a couple weeks ago for a birthday that was excellent.\nGive it a try you won’t be disappointed'),
(2, 'Rakshanda Giri', 'Wow! Super cute place with amazing pastries.\nThe staff was also super nice and welcoming.\nDefinitely recommend a trip!'),
(3, 'Jack Doe', 'Great place!\nThe staff is friendly and helpful. Lots of coffees and baked goods.\nClean with good atmosphere.\nThey have started providing a few lunch items.\nWell worth stopping in.'),
(4, 'Smith Johnson', 'Go get these donuts and various pastries.\nYou will not be disappointed as they are the best. Local owned and operated.\nStaff is very friendly and helpful.'),
(5, 'Jockey James', 'Lots of great pastries. Nice people.\nGood coffee Bread and a squeaky clean restroom \nA place with self respect! I like it.'),
(6, 'Anne Marie', 'So glad that this place is open!\nNew hours are definitely going to bring more customers.\nI can now stop in and get some delicious pastries.\nI live for their decorated pastries and caramel cake. \nFamily operated and friendly as can be. A must try for sure!'),
(8, 'Joe Biden', '.Great bakery. \nExcellent selection of Cakes, pastries and breads.\nIf you love sweet treats, you need to visit.'),
(10, 'Helly Shah', ' Such a gem! Not only are the staff and pastries / donuts incredible, you can’t beat the prices and supporting local! Get here ASAP!'),
(9, 'Shreya Agrawal', 'This bakery is a slice of heaven. All the pastries are beautiful and delicious, and the menu is fantastic, too.'),
(11, 'Mahek Agrawal', 'Nice to be here the last cake was amazing'),
(12, 'Adi bhaiya', 'Nice to b here'),
(13, 'Atul kabra', 'abcd egerh'),
(14, 'Kunal sonawne', 'The cake was amazing..!!'),
(15, 'Amol Chaudhari', 'This is awesom ebakery enjoyed all products!'),
(16, 'Arti Sarode', 'This bakery product are awesome');

-- --------------------------------------------------------

--
-- Table structure for table `ice_table`
--

CREATE TABLE `ice_table` (
  `ice_customer_id` int(250) NOT NULL,
  `ice_type` varchar(100) NOT NULL,
  `price` double(10, 2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ice_table`
--

INSERT INTO `ice_table` (`ice_customer_id`, `ice_type`, `price`) VALUES
(1, 'Buttered Pecan.  ', 50.00),
(2, 'Neapolitan.', 50.00),
(4, 'Moose tracks.', 45.00),
(4, 'Macadamia', 55.00),
(5, 'Hazelnut', 55.00),
(6, 'Moose tracks.', 45.00),
(8, 'Durian.', 45.00),
(9, 'Buttered Pecan.  ', 50.00),
(10, 'Neapolitan.', 50.00),
(13, 'Cookies & Cream  ', 45.00),
(15, 'Neapolitan.', 50.00);

-- --------------------------------------------------------

--
-- Table structure for table `main_table`
--

CREATE TABLE `main_table` (
  `customer_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone_no` varchar(100) DEFAULT NULL,
  `total_amount` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `main_table`
--

INSERT INTO `main_table` (`customer_id`, `name`, `phone_no`, `total_amount`) VALUES
(1, 'Shrutika Mahajan', '1234567899', 650),
(2, 'Rakshanda Giri', '9876543210', 970),
(3, 'Jack Doe', '9638527410', 1130),
(4, 'Smith Johnson', '9856741230', 480),
(5, 'Jockey James', '8974563210', 720),
(6, 'Anne Marie', '8596321480', 1675),
(8, 'Joe Biden', '8965741230', 1485),
(9, 'Shreya Agrawal', '9856741232', 1155),
(10, 'Helly Shah', '9685741230', 660),
(11, 'Mahek Agrawal', '8888692898', 610),
(12, 'Adi bhaiya', '9638527410', 1200),
(13, 'Atul kabra', '7894561230', 675),
(14, 'Kunal sonawne', '9665553249', 390),
(15, 'Amol Chaudhari', '7588192858', 930),
(16, 'Arti Sarode', '7709319506', 805);

-- --------------------------------------------------------

--
-- Table structure for table `pastry_table`
--

CREATE TABLE `pastry_table` (
  `pastry_customer_id` int(250) NOT NULL,
  `flavour` varchar(100) NOT NULL,
  `price` double(10, 2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pastry_table`
--

INSERT INTO `pastry_table` (`pastry_customer_id`, `flavour`, `price`) VALUES
(2, 'Coffee', 45.00),
(3, 'Mango', 35.00),
(3, 'Coffee', 45.00),
(5, 'Coffee', 45.00),
(6, 'Ice Candy', 100.00),
(8, 'Choco Walnut', 60.00),
(11, 'Chocolate Mud', 50.00),
(14, 'Choco Walnut', 60.00),
(15, 'Choco Walnut', 60.00);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bread_table`
--
ALTER TABLE `bread_table`
  ADD KEY `bread_cust_fk` (`bread_customer_id`);

--
-- Indexes for table `cake_table`
--
ALTER TABLE `cake_table`
  ADD KEY `cake_customer_id` (`cake_customer_id`),
  ADD KEY `cake_cust_fk` (`cake_customer_id`);

--
-- Indexes for table `choco_table`
--
ALTER TABLE `choco_table`
  ADD KEY `chcho_cust_fk` (`choco_customer_id`);

--
-- Indexes for table `decorative_table`
--
ALTER TABLE `decorative_table`
  ADD KEY `deco_cust_fk` (`deco_customer_id`);

--
-- Indexes for table `feedback_table`
--
ALTER TABLE `feedback_table`
  ADD KEY `feedback_cust_fk` (`feedback_customer_id`);

--
-- Indexes for table `ice_table`
--
ALTER TABLE `ice_table`
  ADD KEY `ice_cust_fk` (`ice_customer_id`);

--
-- Indexes for table `main_table`
--
ALTER TABLE `main_table`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `pastry_table`
--
ALTER TABLE `pastry_table`
  ADD KEY `pastry_cust_fk` (`pastry_customer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `main_table`
--
ALTER TABLE `main_table`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bread_table`
--
ALTER TABLE `bread_table`
  ADD CONSTRAINT `bread_cust` FOREIGN KEY (`bread_customer_id`) REFERENCES `main_table` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `cake_table`
--
ALTER TABLE `cake_table`
  ADD CONSTRAINT `customer_cake` FOREIGN KEY (`cake_customer_id`) REFERENCES `main_table` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `choco_table`
--
ALTER TABLE `choco_table`
  ADD CONSTRAINT `choco_cust` FOREIGN KEY (`choco_customer_id`) REFERENCES `main_table` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `decorative_table`
--
ALTER TABLE `decorative_table`
  ADD CONSTRAINT `deco_cust` FOREIGN KEY (`deco_customer_id`) REFERENCES `main_table` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `feedback_table`
--
ALTER TABLE `feedback_table`
  ADD CONSTRAINT `cust_feedback` FOREIGN KEY (`feedback_customer_id`) REFERENCES `main_table` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ice_table`
--
ALTER TABLE `ice_table`
  ADD CONSTRAINT `ice_cust` FOREIGN KEY (`ice_customer_id`) REFERENCES `main_table` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pastry_table`
--
ALTER TABLE `pastry_table`
  ADD CONSTRAINT `pastry_cust` FOREIGN KEY (`pastry_customer_id`) REFERENCES `main_table` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
