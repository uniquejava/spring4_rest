CREATE DATABASE IF NOT EXISTS cms
  DEFAULT CHARSET utf8
  COLLATE utf8_general_ci;

CREATE TABLE admin (
  id         INT NOT NULL PRIMARY KEY,
  admin_user VARCHAR(20),
  admin_pwd  VARCHAR(50)
);
INSERT INTO admin (id, admin_user, admin_pwd) VALUES
  (1, 'admin', '21232f297a57a5a743894a0e4a801fc3');
  
CREATE TABLE msg (
  id          INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
  content     VARCHAR(300) NOT NULL,
  name        VARCHAR(50)  NOT NULL,
  phone       VARCHAR(50),
  email       VARCHAR(50),
  qq          VARCHAR(16),
  ip          VARCHAR(20),
  status      TINYINT                           DEFAULT 0,
  create_time TIMESTAMP    NOT NULL             DEFAULT now()
);
INSERT INTO msg (content, name, phone, email, qq, ip) VALUES
  ('test1', 'cyper', '12345', 'test@test.com', '12234234', '1.2.3.4'),
  ('test2', 'cyper2', '12345', 'test@test.com', '12234234', '1.2.3.4'),
  ('test3', 'cyper3', '12345', 'test@test.com', '12234234', '1.2.3.4'),
  ('test4', 'cyper4', '12345', 'test@test.com', '12234234', '1.2.3.4'),
  ('test5', 'cyper5', '12345', 'test@test.com', '12234234', '1.2.3.4'),
  ('test6', 'cyper6', '12345', 'test@test.com', '12234234', '1.2.3.4'),
  ('test7', 'cyper7', '12345', 'test@test.com', '12234234', '1.2.3.4'),
  ('test8', 'cyper8', '12345', 'test@test.com', '12234234', '1.2.3.4'),
  ('test9', 'cyper9', '12345', 'test@test.com', '12234234', '1.2.3.4'),
  ('test10', 'cyper10', '12345', 'test@test.com', '12234234', '1.2.3.4'),
  ('test11', 'cyper11', '12345', 'test@test.com', '12234234', '1.2.3.4'),
  ('test12', 'cyper12', '12345', 'test@test.com', '12234234', '1.2.3.4'),
  ('test13', 'cyper13', '12345', 'test@test.com', '12234234', '1.2.3.4'),
  ('test14', 'cyper14', '12345', 'test@test.com', '12234234', '1.2.3.4'),
  ('test15', 'cyper15', '12345', 'test@test.com', '12234234', '1.2.3.4');