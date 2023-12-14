DROP DATABASE IF EXISTS baibai_petspa;

CREATE DATABASE baibai_petspa;

USE baibai_petspa;

CREATE TABLE owner (
   owner_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   first_name VARCHAR(25) NOT NULL,
   last_name VARCHAR(25) NOT NULL,
   address VARCHAR(50),
   phone VARCHAR(15)
);

CREATE TABLE pet (
   pet_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `name` VARCHAR(50) NOT NULL,
   species VARCHAR(50) NOT NULL,
   birthday DATE,
   owner_id INT NOT NULL,
   FOREIGN KEY (owner_id) REFERENCES owner(owner_id)
);

INSERT INTO owner(first_name, last_name, address, phone)
VALUES ("Paul", "Kimball", "123 Cherry Lane", "1-800-555-1212");

INSERT INTO pet(`name`, species, owner_id)
VALUES ("Bai-Bai", "Cat", 1);
