CREATE DATABASE IF NOT EXISTS cms
  DEFAULT CHARSET utf8
  COLLATE utf8_general_ci;

USE cms;

CREATE TABLE admin (
  id         INT NOT NULL PRIMARY KEY,
  admin_user VARCHAR(20),
  admin_pwd  VARCHAR(50)
);

CREATE TABLE msg (
  id          INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  content     VARCHAR(300)                   NOT NULL,
  name        VARCHAR(50)                    NOT NULL,
  phone       VARCHAR(50),
  email       VARCHAR(50),
  qq          VARCHAR(16),
  ip          VARCHAR(20),
  status      TINYINT DEFAULT 0,
  create_time TIMESTAMP DEFAULT now()        NOT NULL
);
