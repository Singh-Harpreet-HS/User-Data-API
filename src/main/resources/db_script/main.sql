--Database Name:
CREATE DATABASE user_manager_v1;

USE user_manager_v1;

--USER TABLE STRUCTURE:
CREATE TABLE newusers(
    user_id INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    createdAt TIMESTAMP,
    updatedAt TIMESTAMP,
    PRIMARY KEY(user_id)
);