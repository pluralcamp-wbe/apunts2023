CREATE DATABASE spring_data1;
use spring_data1;

CREATE TABLE `spring_data1`.`student` (
  `idstudent` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(100) NULL,
  `age` INT NULL,
  PRIMARY KEY (`idstudent`));
  
INSERT INTO `spring_data1`.`student`(name,surname,age)
VALUES ("Laura","Cases",24),
("Josep","Querol",31), 
("Anna","Puig",29);

