/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Carlos
 * Created: 26/11/2016
 */
CREATE DATABASE GAME;

USE GAME;

CREATE TABLE IF NOT EXISTS TB_MATERIAL(
ID INT(255) UNSIGNED NOT NULL AUTO_INCREMENT,
IMAGEM VARCHAR(255) NOT NULL,
TIPO VARCHAR(255) NOT NULL,
PRIMARY KEY (ID)
) ENGINE=INNODB ;

