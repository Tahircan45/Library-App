INSERT INTO
	role (name)
VALUES
  	('USER'),
  	('ADMIN'),
  	('MANAGER');

INSERT INTO
	user (username,password,enabled)
VALUES
  	('user1','$2a$10$LyOyaDDauPzXKT9U.y0HGOPirxb4DVhkYpjUY4xwS/Ol.6TuZ0KBi',1),
  	('admin','$2a$10$rPDlaEsVQENIiikJSxQnTubkxA088Uws1Xef475Uncm4Eeft3BXsG',1),
  	('manager','$2a$10$nO0boRydqepHMlk55xjF6uLu8R4KGcUYQgVAOOvDixM90hJZg5TAi',1);

INSERT INTO
    	user_role (user_id,role_id)
VALUES
      	(1,1),
      	(2,2),
      	(3,3);