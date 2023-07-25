## Создаем БД
DROP DATABASE IF EXISTS human_friends;
CREATE DATABASE human_friends;
## Используем БД
USE human_friends;
## Создаем таблицы по диаграмме
DROP TABLE IF EXISTS humsters;
CREATE TABLE humsters (
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(40),
    Command VARCHAR(25),
    Birthday DATE);
SELECT * FROM humsters;
DROP TABLE IF EXISTS dogs;
CREATE TABLE dogs (
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(40),
    Command VARCHAR(25),
    Birthday DATE);
    SELECT * FROM dogs;
DROP TABLE IF EXISTS cats;
CREATE TABLE cats (
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(40),
    Command VARCHAR(25),
    Birthday DATE);
    SELECT * FROM cats;
DROP TABLE IF EXISTS camels;
CREATE TABLE camels (
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(40),
    Command VARCHAR(25),
    Birthday DATE);
    SELECT * FROM camels;
    DROP TABLE IF EXISTS horses;
CREATE TABLE horses (
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(40),
    Command VARCHAR(25),
    Birthday DATE);
    SELECT * FROM horses;
    DROP TABLE IF EXISTS donkeys;
CREATE TABLE donkeys (
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(40),
    Command VARCHAR(25),
    Birthday DATE);
    SELECT * FROM donkeys;
    DROP TABLE IF EXISTS pets;
CREATE TABLE pets (
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(40),
    Command VARCHAR(25),
    Birthday DATE);
    SELECT * FROM pets;
    DROP TABLE IF EXISTS pack_animals;
CREATE TABLE pack_animals (
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(40),
    Command VARCHAR(25),
    Birthday DATE);
    SELECT * FROM pack_animals;
DROP TABLE IF EXISTS animals;
CREATE TABLE animals (
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(40),
    Command VARCHAR(25),
    Birthday DATE);
    SELECT * FROM animals;
## Заполним низкоуровневые таблицы именами и тд.
INSERT INTO humsters (Name, Command, Birthday) VALUES
("Гоша","Бегает","2017-01-01"),
("Хомка","Бегает","2022-02-02"),
("Пушок","Бегает","2023-03-03");
    SELECT * FROM humsters;
INSERT INTO dogs (Name, Command, Birthday) VALUES
("Барон","Лает","2017-01-01"),
("Черныш","Лает","2022-02-02"),
("Тузик","Лает","2023-03-03");
    SELECT * FROM dogs;
INSERT INTO cats (Name, Command, Birthday) VALUES
("Чижик","Просит еду","2017-01-01"),
("Тимон","Просит еду","2022-02-02"),
("Ксю","Просит еду","2023-03-03");
    SELECT * FROM cats;
INSERT INTO camels (Name, Command, Birthday) VALUES
("Агата","Плюет","2017-01-01"),
("Ида","Плюет","2022-02-02"),
("Чайна","Плюет","2023-03-03");
    SELECT * FROM camels;
INSERT INTO horses (Name, Command, Birthday) VALUES
("Барс","Прыжок","2017-01-01"),
("Ярость","Прыжок","2022-02-02"),
("Коршун","Прыжок","2023-03-03");
    SELECT * FROM horses;
INSERT INTO donkeys (Name, Command, Birthday) VALUES
("Иа","Кричит","2017-01-01"),
("Тайсон","Кричит","2022-02-02"),
("Джек","Кричит","2023-03-03");
SELECT * FROM donkeys;

SELECT * FROM camels;

#Удаляем из таблицы верблюдов верблюдов

TRUNCATE camels;

SELECT * FROM camels;

#Объединяем таблицы лошадей и ослов в одну
DROP TABLE IF EXISTS horses_donkeys;
CREATE TABLE horses_donkeys (
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(40),
    Command VARCHAR(25),
    Birthday DATE);
INSERT INTO horses_donkeys (Name, Command, Birthday)
SELECT Name, Command, Birthday FROM
(
SELECT Name, Command, Birthday FROM horses
UNION
SELECT Name, Command, Birthday FROM donkeys
)horses_donkeys;

SELECT * FROM horses_donkeys;

#Создаем таблицу Молодые животные 
DROP TABLE IF EXISTS young_animals;
CREATE TABLE young_animals (
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(40),
    Command VARCHAR(25),
    Birthday DATE,
    Age VARCHAR(25));
    
#Создадим функцию, которая будет считать возраст

DELIMITER **
CREATE FUNCTION calc_age (birthdate DATE)
RETURNS VARCHAR(25)
DETERMINISTIC
BEGIN
	DECLARE age VARCHAR(25);
    SET age = CONCAT(
            TIMESTAMPDIFF(YEAR, birthdate, CURDATE()),
            ' years ',
            TIMESTAMPDIFF(MONTH, birthdate, CURDATE()) % 12,
            ' month'
        );
	RETURN age;
END **
DELIMITER ;


#Записываем в таблицу всех животных старше 1 года, но младше 3 лет

INSERT INTO young_animals (Name, Command, Birthday, Age)
SELECT Name, Command, Birthday, calc_age(Birthday) FROM humsters
WHERE TIMESTAMPDIFF(YEAR, Birthday, CURDATE()) BETWEEN 1 AND 3
UNION ALL
SELECT Name, Command, Birthday, calc_age(Birthday) FROM dogs
WHERE TIMESTAMPDIFF(YEAR, Birthday, CURDATE()) BETWEEN 1 AND 3
UNION ALL
SELECT Name, Command, Birthday, calc_age(Birthday) FROM cats
WHERE TIMESTAMPDIFF(YEAR, Birthday, CURDATE()) BETWEEN 1 AND 3
UNION ALL
SELECT Name, Command, Birthday, calc_age(Birthday) FROM horses_donkeys
WHERE TIMESTAMPDIFF(YEAR, Birthday, CURDATE()) BETWEEN 1 AND 3;

SELECT * FROM young_animals;

# Объединяем все таблицы в одну, сохраняя принадлежность

DROP TABLE IF EXISTS new_animals;
CREATE TABLE new_animals (ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
SELECT Name, Command, Birthday, "humster" AS Type_of_animal
FROM humsters
UNION 
SELECT Name, Command, Birthday, "dog" AS Type_of_animal
FROM dogs
UNION 
SELECT Name, Command, Birthday, "cat" AS Type_of_animal
FROM cats
UNION 
SELECT Name, Command, Birthday, "horse" AS Type_of_animal
FROM horses
UNION
SELECT Name, Command, Birthday, "donkey" AS Type_of_animal
FROM donkeys;

SELECT * FROM new_animals;
