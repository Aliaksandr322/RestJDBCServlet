CREATE DATABASE RestJDBCServlet_db; /*Create Db*/

CREATE TABLE `role` (
        `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
        `name` varchar(64) NOT NULL
);/*Create role table*/

CREATE TABLE `office` (
                        `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        `address` varchar(64) NOT NULL
);/*Create office table*/

CREATE TABLE `passport` (
                          `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          `first_name` varchar(64) NOT NULL,
                          `last_name` varchar(64) NOT NULL,
                          `init_id` int(11) NOT NULL,
                          `personal_id` varchar(64) NOT NULL
);/*Create passport table*/


CREATE TABLE `employee` (
                            `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            `name` varchar(64) DEFAULT NULL,
                            `address` varchar(64) DEFAULT NULL,
                            `passport_id` int(11) NOT NULL UNIQUE,
                            `office_id` int(11) NOT NULL,
                            FOREIGN KEY (`passport_id`) REFERENCES `passport` (`id`),
                            FOREIGN KEY (`office_id`) REFERENCES `office` (`id`)
);/*Create employee table*/



CREATE TABLE `empls_roles` (
                               `empl_id` int(11) NOT NULL,
                               `role_id` int(11) NOT NULL,
                               FOREIGN KEY (`empl_id`) REFERENCES `employee` (`id`),
                               FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
);
/*Insert role some roles*/
INSERT INTO `role` (`id`, `name`) VALUES (NULL, 'Admin'), (NULL, 'Manager');
/*Insert office some offices*/
INSERT INTO `office` (`id`, `address`) VALUES (NULL, 'Pushkina 85'), (NULL, 'KarlaMarksa 35');
/*Insert passport some passports*/
INSERT INTO `passport` (`id`, `first_name`, `last_name`, `init_id`, `personal_id`) VALUES (NULL, 'Bob', 'Bobov', '1234567', 'KB12354531'), (NULL, 'John', 'Johnov', '123321', 'KB123543');
/*Insert passport some employee*/
INSERT INTO `employee` (`id`, `name`, `address`, `passport_id`, `office_id`) VALUES (NULL, 'John', 'Nezavisimosti 32', '2', '1');
INSERT INTO `employee` (`id`, `name`, `address`, `passport_id`, `office_id`) VALUES (NULL, 'Bob', 'Lermontova 76', '1', '2');
/*Insert empls_roles some roles*/
INSERT INTO `empls_roles` (`empl_id`, `role_id`) VALUES ('1', '1'), ('1', '2');
INSERT INTO `empls_roles` (`empl_id`, `role_id`) VALUES ('2', '2')