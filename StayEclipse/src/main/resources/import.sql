---- You can use this file to load seed data into the database using SQL statements
--insert into Member (id, name, email, phone_number) values (1, 'John Smith', 'john.smith@mailinator.com', '2125551212')
--insert into role (id,role) values (1,'USER')
insert into suitetype values (1,'Single')
insert into suitetype values (2,'Single+Extra')
insert into suitetype values (3,'Double')
insert into suitetype values (4,'Double+Extra')
--
insert into facility values (1,'TV')
insert into facility values (2,'A/C')
insert into facility values (3,'FAN')
insert into facility values (4,'LOCKER')
insert into facility values (5,'FREE NEWS PAPER')
insert into facility values (6,'FRIDGE')
insert into facility values (7,'WASHING MACHINE')
insert into facility values (8,'WIFI')
insert into facility values (9,'MICROWAVE')
insert into facility values (10,'TRAVEL DESK')
insert into facility values (11,'PICK UP AND DROP')
insert into facility values (12,'CAR RENTAL DESK')


insert into stay (id, address, emailid, phoneno, profileImgPath, rating, stayname, websitelink) values (1000, 'banglore', 'vyman.hm@gmail.com', '7899653947', 'http://localhost:8080/nuxeo/nxbigfile/default/b59cb52a-3080-4a46-bb2e-75968249176e/file:content/ban1.jpg', 4, 'test', 'www.test.com');
insert into stay (id, address, emailid, phoneno, profileImgPath, rating, stayname, websitelink) values (1001, 'banglore', 'vyman.hm@gmail.com', '7899653947', 'http://localhost:8080/nuxeo/nxbigfile/default/7938ba29-2257-486b-bfa0-b1ce97ae1349/file:content/ban3.jpg', 5, 'test', 'www.test.com');
insert into stay (id, address, emailid, phoneno, profileImgPath, rating, stayname, websitelink) values (1002, 'banglore', 'vyman.hm@gmail.com', '7899653947', 'http://localhost:8080/nuxeo/nxbigfile/default/8e8d25c9-ee8a-4677-8ab8-b6b45e6828b0/file:content/ban2.jpg', 3, 'test', 'www.test.com');


insert into staynearbyplaces (id, discription, distance, photo, place_name, stay_id) values (1000, 'place1', '20', 'http://localhost:8080/nuxeo/nxbigfile/default/f7fbc39c-602e-48e6-8911-aa057699d565/file:content/s1.jpg', 'test1', 1000);
insert into staynearbyplaces (id, discription, distance, photo, place_name, stay_id) values (1001, 'place2', '30', 'http://localhost:8080/nuxeo/nxbigfile/default/6582f349-d976-4b72-b67d-6a54e887d76b/file:content/s2.jpg', 'test2', 1000);
insert into staynearbyplaces (id, discription, distance, photo, place_name, stay_id) values (1003, 'place2', '40', 'http://localhost:8080/nuxeo/nxbigfile/default/8b7a4d8b-18f1-438b-94b0-b4eb7bae444b/file:content/s3.jpg', 'test3', 1000);


insert into staymenu (id, menuphoto, stay_id) values (1000, 'http://localhost:8080/nuxeo/nxbigfile/default/d3651c14-2c80-44cc-85af-fb3075321d1c/file:content/pic2.jpg', 1000);

insert into staysuite (staysuite_id, discription, number_of_avilable_rooms, price, suite_code, stay_id, suite_type ,picpath) values (1000, 'single room', 2, 100, 'A01', 1000, 1,'http://localhost:8080/nuxeo/nxbigfile/default/8b7a4d8b-18f1-438b-94b0-b4eb7bae444b/file:content/s3.jpg');

insert into staysuitephotos (id, discription, imagepath, staysuite_id) values (1000, 'etroordinary room', 'http://localhost:8080/nuxeo/nxbigfile/default/8b7a4d8b-18f1-438b-94b0-b4eb7bae444b/file:content/s3.jpg', 1000);