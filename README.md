# Итоговая контрольная работа по блоку специализация
___
## **Pet-management-system**
___
*Информация о проекте*

### Необходимо организовать систему учета для питомника в котором живут домашние и вьючные животные.

*Как сдавать проект*

Для сдачи проекта необходимо создать отдельный общедоступный
репозиторий(Github, gitlub, или Bitbucket). Разработку вести в этом
репозитории, использовать пул реквесты на изменения. Программа должна
запускаться и работать, ошибок при выполнении программы быть не должно.
Программа, может использоваться в различных системах, поэтому необходимо
разработать класс в виде конструктора
### Задание
1. Используя команду cat в терминале операционной системы Linux, создать
   два файла Домашние животные (заполнив файл собаками, кошками,
   хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
   ослы), а затем объединить их. Просмотреть содержимое созданного файла.
   Переименовать файл, дав ему новое имя (Друзья человека).

   ![Task 1](https://github.com/pashtetrus33/pet-management-system/blob/main/Task%201.png)

2. Создать директорию, переместить файл туда.

![Task 2](https://github.com/pashtetrus33/pet-management-system/blob/main/Task%202.png)

3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.

![Task 3a](https://github.com/pashtetrus33/pet-management-system/blob/main/Task%203a.png)
![Task 3b](https://github.com/pashtetrus33/pet-management-system/blob/main/Task%203b.png)

4. Установить и удалить deb-пакет с помощью dpkg.
   
![Task 4](https://github.com/pashtetrus33/pet-management-system/blob/main/Task%204.png)

5. Выложить [историю команд](https://github.com/pashtetrus33/pet-management-system/blob/main/TerminalCommands.md) в терминале ubuntu


6. Нарисовать [диаграмму](https://github.com/pashtetrus33/pet-management-system/blob/main/diagram.drawio), в которой есть класс родительский класс, домашние
   животные и вьючные животные, в составы которых в случае домашних
   животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
   войдут: Лошади, верблюды и ослы).

![Task 6](https://github.com/pashtetrus33/pet-management-system/blob/main/Task%206.png)

7. В подключенном MySQL репозитории создать базу данных “Друзья человека”

``` mysql 
CREATE DATABASE mans_friends; 
```

8. Создать таблицы с иерархией из диаграммы в БД
```mysql
USE mans_friends;

CREATE TABLE animals
(
	Id INT AUTO_INCREMENT PRIMARY KEY,  
	Animal_class VARCHAR(50)
);

INSERT INTO animals (Animal_class)
VALUES ('pets'),
('pack animals');  

CREATE TABLE pets
(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    Pet_class VARCHAR (50),
    Animal_id INT,
    FOREIGN KEY (Animal_id) REFERENCES animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pets (Pet_class, Animal_id)
VALUES ('Dog', 1),
('Cat', 1),  
('Hamster', 1); 

CREATE TABLE pack_animals
(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    Pack_animal_class VARCHAR (50),
    Animal_id INT,
    FOREIGN KEY (Animal_id) REFERENCES animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pack_animals (Pack_animal_class, Animal_id)
VALUES ('Horse', 2),
('Camel', 2),  
('Donkey', 2); 
    

CREATE TABLE dogs
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(50), 
    Birthday DATE,
    Commands VARCHAR(50),
    Pet_id int,
    Foreign KEY (Pet_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE cats
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(50), 
    Birthday DATE,
    Commands VARCHAR(50),
    Pet_id int,
    Foreign KEY (Pet_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE hamsters
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(50), 
    Birthday DATE,
    Commands VARCHAR(50),
    Pet_id int,
    Foreign KEY (Pet_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE horses
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(50), 
    Birthday DATE,
    Commands VARCHAR(50),
    Pack_animal_id int,
    Foreign KEY (Pack_animal_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE camels
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(50), 
    Birthday DATE,
    Commands VARCHAR(50),
    Pack_animal_id int,
    Foreign KEY (Pack_animal_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE donkeys
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(50), 
    Birthday DATE,
    Commands VARCHAR(50),
    Pack_animal_id int,
    Foreign KEY (Pack_animal_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
```

9. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения

10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
    
11. Создать новую таблицу “молодые животные” в которую попадут все
    животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
    до месяца подсчитать возраст животных в новой таблице.

12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
    прошлую принадлежность к старым таблицам.

13. Создать класс с Инкапсуляцией методов и наследованием по диаграмме. 

14. Написать программу, имитирующую работу реестра домашних животных.
   В программе должен быть реализован следующий функционал:
   14.1 Завести новое животное
   14.2 определять животное в правильный класс
   14.3 увидеть список команд, которое выполняет животное
   14.4 обучить животное новым командам
   14.5 Реализовать навигацию по меню 

15. Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆ значение внутренней̆ int переменной̆на 1
при нажатие “Завести новое животное” Сделайте так, чтобы с объектом такого типа можно было работать в 
блоке try-with-resources. Нужно бросить исключение, если работа с объектом типа счетчик 
была не в ресурсном try и/или ресурс остался открыт. Значение считать в ресурсе try, если при заведения животного заполнены все поля.
