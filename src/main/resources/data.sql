INSERT INTO
	author (name,description)
VALUES
  	('Frank Herbert','1920 Amerika'),
  	('Yuah Noah Hararit','1976 İsrail'),
  	('George Orwell','1903 Hindistan'),
  	('Emrah Safa GÜRKAN','1981 Türkiye');

INSERT INTO
     publisher (name,description)
VALUES
      ('İthaki Yayınları','Kadıköy-İstanbul'),
      ('Kolektif Kitap','Beyoğlu-İstanbul'),
      ('Can Sanat Yayınları','Galatasaray-İstanbul'),
      ('Kronik Kitap','Levent-İstanbul');

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

INSERT INTO
        book (name,sub_name,ser_name,isbn,description,author_id,publisher_id)
VALUES
        ('Dune','Dune Serisi','Dune Serisi','978-605-375-479-4','Dune serisi 1. kitaptır',1,1),
        ('Dune Mesihi','Dune Serisi','Dune Serisi','978-605-375-531-9','Dune serisi 2. kitaptır',1,1),
        ('Sapiens','İnsan Türünün Kısa Bir Tarihi','Sapiens','978-605-5029-35-7','İnsan Türünün Kısa Bir Tarihi',2,2),
        ('Hayvan Çiftliği','Bir Peri Masalı','Hayvan Çiftliği','978-975-07-1938-7','Bir Peri Masalı',3,3),
        ('Bunu Herkes Bilir','Tarihteki Yanlış Sorulara Doğru Cevaplar','Bunu Herkes Bilir','978-605-7635-40-2','Tarihteki Yanlış Sorulara Doğru Cevaplar',4,4);