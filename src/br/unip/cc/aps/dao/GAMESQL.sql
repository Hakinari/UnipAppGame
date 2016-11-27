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

CREATE TABLE IF NOT EXISTS TB_RECORDE(
POSICAO INT(1) UNSIGNED NOT NULL,
NOME VARCHAR(255) NOT NULL,
PONTOS INT(3) NOT NULL,
PRIMARY KEY (POSICAO)
)ENGINE=INNODB;

SELECT * FROM TB_MATERIAL;
DROP TABLE TB_MATERIAL;
DROP TABLE TB_RECORDE;

INSERT INTO TB_MATERIAL(IMAGEM,TIPO) VALUES("/br/unip/cc/aps/images/balde_plastico.jpg","PLASTICO");
INSERT INTO TB_MATERIAL(IMAGEM,TIPO) VALUES("/br/unip/cc/aps/images/brinquedo_plastico.jpg","PLASTICO");
INSERT INTO TB_MATERIAL(IMAGEM,TIPO) VALUES("/br/unip/cc/aps/images/copo_plastico.jpg","PLASTICO");
INSERT INTO TB_MATERIAL(IMAGEM,TIPO) VALUES("/br/unip/cc/aps/images/garrafa_pet.jpg","PLASTICO");
INSERT INTO TB_MATERIAL(IMAGEM,TIPO) VALUES("/br/unip/cc/aps/images/faca.jpg","METAL");
INSERT INTO TB_MATERIAL(IMAGEM,TIPO) VALUES("/br/unip/cc/aps/images/garfo.jpg","METAL");
INSERT INTO TB_MATERIAL(IMAGEM,TIPO) VALUES("/br/unip/cc/aps/images/lata.jpg","METAL");
INSERT INTO TB_MATERIAL(IMAGEM,TIPO) VALUES("/br/unip/cc/aps/images/prego.jpg","METAL");
INSERT INTO TB_MATERIAL(IMAGEM,TIPO) VALUES("/br/unip/cc/aps/images/vaso_vidro.jpg","VIDRO");
INSERT INTO TB_MATERIAL(IMAGEM,TIPO) VALUES("/br/unip/cc/aps/images/prato_vidro.jpg","VIDRO");
INSERT INTO TB_MATERIAL(IMAGEM,TIPO) VALUES("/br/unip/cc/aps/images/garrafa_vidro.jpg","VIDRO");
INSERT INTO TB_MATERIAL(IMAGEM,TIPO) VALUES("/br/unip/cc/aps/images/garrafaCerveja_vidro.jpg","VIDRO");
INSERT INTO TB_MATERIAL(IMAGEM,TIPO) VALUES("/br/unip/cc/aps/images/papelao.jpg","PAPEL");
INSERT INTO TB_MATERIAL(IMAGEM,TIPO) VALUES("/br/unip/cc/aps/images/postit.jpg","PAPEL");
INSERT INTO TB_MATERIAL(IMAGEM,TIPO) VALUES("/br/unip/cc/aps/images/jornal.jpg","PAPEL");
INSERT INTO TB_MATERIAL(IMAGEM,TIPO) VALUES("/br/unip/cc/aps/images/folha_sulfite.jpg","PAPEL");

INSERT INTO TB_RECORDE(POSICAO,NOME,PONTOS) VALUES(1,"duduzinho tinhamo",10);
INSERT INTO TB_RECORDE(POSICAO,NOME,PONTOS) VALUES(2,"pulidao",100);
INSERT INTO TB_RECORDE(POSICAO,NOME,PONTOS) VALUES(3,"dennao tinhamo",0);
