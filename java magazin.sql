DROP DATABASE IF EXISTS warehouse;
CREATE DATABASE IF NOT EXISTS warehouse;
USE warehouse;
CREATE TABLE IF NOT EXISTS `warehouse`.`client` (
  `client_id` INT NOT NULL AUTO_INCREMENT,
  `nume` CHAR(10) NULL DEFAULT NULL,
  `email` CHAR(50) NULL DEFAULT NULL,
  `adresa` CHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`client_id`));

CREATE TABLE IF NOT EXISTS `warehouse`.`produs` (
  `produs_id` INT NOT NULL AUTO_INCREMENT,
  `nume` CHAR(10) NULL DEFAULT NULL,
  `cantitate` INT NOT NULL,
  PRIMARY KEY (`produs_id`));
  
  
 CREATE TABLE IF NOT EXISTS `warehouse`.`comanda` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `client_id` INT NOT NULL,
  `produs_id` INT NOT NULL,
    PRIMARY KEY (`order_id`),
  FOREIGN KEY (`client_id`)
    REFERENCES `warehouse`.`client` (`client_id`),
    FOREIGN KEY (`produs_id`)
    REFERENCES `warehouse`.`produs` (`produs_id`));
    
  INSERT INTO client(client_id, nume, email, adresa) VALUES
('1', 'Ionut', 'rusu.ionut@yahoo.com','Castanilor'),
('2', 'Cristina','zubascu.cristina@yahoo.com','Visinilor'),
('3', 'Maria','jijie.maria@yahoo.com','Teilor'),
('4', 'Ovidiu', 'pop.ovidiu@yahoo.com','Macilor'),
('5', 'Luminita', 'popa.luminita@yahoo.com','Romanul'),
('6', 'Marian', 'cristea.marian@yahoo.com','Fagului'),
('7', 'Iuliana', 'chihaia.iuliana@yahoo.com','Floriilor'),
('8', 'Vlad',  'faur.vlad@yahoo.com','Barbu'),
('9', 'Bogdan', 'giurgiu.vlad@yahoo.com','Cornesti'),
('10', 'Calin', 'george.calin@yahoo.com','Coltesti');

INSERT INTO produs(produs_id, nume, cantitate) VALUES
('1', 'cereale', '13'),
('2', 'paste','70'),
('3', 'bauturi','12'),
('4', 'covrigei', '78'),
('5', 'fructe', '100'),
('6', 'legume', '56'),
('7', 'faina', '87'),
('8', 'ulei',  '66'),
('9', 'apa', '109'),
('10', 'suc', '98');


INSERT INTO comanda(order_id, client_id, produs_id) VALUES
('1', '2', '6'),
('2', '4','6'),
('3', '2','8'),
('4', '4', '7'),
('5', '8', '3'),
('6', '2', '6'),
('7', '5', '9'),
('8', '10',  '10'),
('9', '5', '7'),
('10', '3', '1');


select * from client;
  
  