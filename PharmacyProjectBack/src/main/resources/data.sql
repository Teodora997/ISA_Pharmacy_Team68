INSERT INTO `authority` (name) VALUES ('ROLE_PH_ADMIN');
INSERT INTO `authority` (name) VALUES ('ROLE_SYS_ADMIN');
INSERT INTO `authority` (name) VALUES ('ROLE_DERMATOLOGIST');
INSERT INTO `authority` (name) VALUES ('ROLE_PATIENT');
INSERT INTO `authority` (name) VALUES ('ROLE_PHARMACIST');
INSERT INTO `authority` (name) VALUES ('ROLE_SUPPLIER');


INSERT INTO `user` (id, address, city, email,first_time_login, is_activated, first_name,last_name, password, telephone, role) VALUES (100, 'Kralja Petra 42', 'Novi Sad', 'admin1@gmail.com',false, true, 'Jovan', 'Jovic','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06122251251', 'ROLE_PH_ADMIN');
INSERT INTO `user` (id, address, city, email,first_time_login, is_activated, first_name,last_name, password, telephone, role) VALUES (200, 'Nevesinjska 5', 'Beograd', 'pacijent1@gmail.com',false, true, 'Milos', 'Milovic','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06022251232', 'ROLE_PATIENT');
INSERT INTO `user` (id, address, city, email, first_time_login,is_activated, first_name, last_name,password, telephone, role) VALUES (300, 'Ive Andrica 11', 'Beograd', 'pacijent2@gmail.com',false, true, 'Ranka','Rakic', '$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06566551288', 'ROLE_PATIENT');
INSERT INTO `user` (id, address, city, email, first_time_login,is_activated, first_name, last_name,password, telephone, role) VALUES (400, 'Strazilovska 59', 'Novi Sad', 'dermatolog1@gmail.com',false, true, 'Marija','Maric', '$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06566000288', 'ROLE_DERMATOLOGIST');
INSERT INTO `user` (id, address, city,  email, first_time_login,is_activated, first_name,last_name, password, telephone, role) VALUES (500, 'Nevinih zrtava 13', 'Novi Sad',  'dermatolog2@gmail.com',false, true, 'Blagoje', 'Blazic','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06566000288', 'ROLE_DERMATOLOGIST');
INSERT INTO `user` (id, address, city, email,first_time_login, is_activated, first_name,last_name, password, telephone, role) VALUES (600, 'Strazilovska 10', 'Novi Sad', 'farmaceut1@gmail.com',false, true, 'Sandra', 'Saric','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06566000288', 'ROLE_PHARMACIST');
INSERT INTO `user` (id, address, city,  email, first_time_login,is_activated, first_name,last_name, password, telephone, role) VALUES (700, 'Brace Ribnikar 10', 'Nis',  'sadmin1@gmail.com', false,true, 'Aleksa', 'Aleksic','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06512000288', 'ROLE_SYS_ADMIN');
INSERT INTO `user` (id, address, city,  email, first_time_login,is_activated, first_name,last_name, password, telephone, role) VALUES (800, 'Brace Ribnikar 10', 'Nis',  'farmaceut2@gmail.com', false,true, 'Marko', 'Markovic','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06512000288', 'ROLE_PHARMACIST');
INSERT INTO `user` (id, address, city,  email, first_time_login,is_activated, first_name,last_name, password, telephone, role) VALUES (900, 'Tolstojeva 10', 'Novi Sad',  'farmaceut3@gmail.com', false,true, 'Dijana', 'Danic','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06512000288', 'ROLE_PHARMACIST');
INSERT INTO `user` (id, address, city, email,first_time_login, is_activated, first_name,last_name, password, telephone, role) VALUES (101, 'Kralja Petra 42', 'Novi Sad', 'admin2@gmail.com',false, true, 'Jovana', 'Jovanovic','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06122251251', 'ROLE_PH_ADMIN');
INSERT INTO `user` (id, address, city, email,first_time_login, is_activated, first_name,last_name, password, telephone, role) VALUES (102, 'Kralja Petra 42', 'Novi Sad', 'admin3@gmail.com',false, true, 'Zorana', 'Zoric','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06122251251', 'ROLE_PH_ADMIN');
INSERT INTO `user` (id, address, city, email,first_time_login, is_activated, first_name,last_name, password, telephone, role) VALUES (103, 'Kralja Petra 42', 'Novi Sad', 'dobavljac@gmail.com',false, true, 'Zorana', 'Zoric','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06122251251', 'ROLE_SUPPLIER');


INSERT INTO `user_authority` (user_id, authority_id) VALUES (100, 1);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (200, 4);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (300, 4);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (400, 3);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (500, 3);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (600, 5);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (700, 2);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (800, 5);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (900, 5);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (101, 1);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (102, 1);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (103, 6);

INSERT INTO `work_time` (id,from_date,shift,to_date) values (1,'',1,'');
INSERT INTO `work_time` (id,from_date,shift,to_date) values (2,'',2,'');

INSERT INTO `patients` (category,penals,points,id) values ('REGULAR',0,50,200);
INSERT INTO `patients` (category,penals,points,id) values ('REGULAR',4,10,300);

INSERT INTO `dermatologists` (mark,id,work_time_id) values (10,400,1);
INSERT INTO `dermatologists` (mark,id,work_time_id) values (5,500,2);

INSERT INTO `examination_price_list` (id,examinations,price) values (1,'',3000);


INSERT INTO `medicines` (id,additional,form,ingredients,name,producer,regime,type) values (1,'','SYRUP','','Ibuprofen','Galenika','NO_PRESCRIPTION','ANALGETIC');
INSERT INTO `medicines` (id,additional,form,ingredients,name,producer,regime,type) values (2,'','TABLET','','Rapten','Hemopharm','NO_PRESCRIPTION','ANALGETIC');
INSERT INTO `medicines` (id,additional,form,ingredients,name,producer,regime,type) values (3,'','CAPSULES','','Hemomicin','Galenika','PRESCRIPTION','ANTIBIOTIC');
INSERT INTO `medicines` (id,additional,form,ingredients,name,producer,regime,type) values (4,'','CAPSULES','','Amoksicilin','Galenika','PRESCRIPTION','ANTIBIOTIC');
INSERT INTO `medicines` (id,additional,form,ingredients,name,producer,regime,type) values (5,'','TABLET','','Hloropiramin','Galenika','PRESCRIPTION','ANTIHISTAMINE');
INSERT INTO `medicines` (id,additional,form,ingredients,name,producer,regime,type) values (6,'','DROPS','','Rezorcinol','Hemopharm','NO_PRESCRIPTION','ANTISEPTICS');
INSERT INTO `medicines` (id,additional,form,ingredients,name,producer,regime,type) values (7,'','SYRUP','','Ibuprofen','Hemopharm','NO_PRESCRIPTION','ANTISEPTICS');

INSERT INTO  `patients_allergies` (patient_id,allergies_id)values (200,1);
INSERT INTO  `patients_allergies` (patient_id,allergies_id)values (200,6);

INSERT INTO `medicine_price_list` (id,from_date,to_date) values (1,'','');

INSERT INTO `pharmacies` (id,address,mark,name,id_ex_price_list,id_med_price_list) values (1,'Bulevar Oslobodjenja 88',0,'Benu',1,1);
INSERT INTO `pharmacies` (id,address,mark,name,id_ex_price_list,id_med_price_list) values (2,'Kisacka 88',10,'Jankovic',1,1);
INSERT INTO `pharmacies` (id,address,mark,name,id_ex_price_list,id_med_price_list) values (3,'Tolstojeva 4',5,'Laurus',1,1);

INSERT INTO `pharmacists` (mark,id,pharmacy_id,work_time_id) values (10,600,1,1);
INSERT INTO `pharmacists` (mark,id,pharmacy_id,work_time_id) values (10,900,2,1);
INSERT INTO `pharmacists` (mark,id,pharmacy_id,work_time_id) values (5,800,3,1);

INSERT INTO `pharmacy_admins` (id,pharmacy_id) values (100,1);
INSERT INTO `pharmacy_admins` (id,pharmacy_id) values (101,2);
INSERT INTO `pharmacy_admins` (id,pharmacy_id) values (102,3);

INSERT INTO `system_admins` (id) values (700);

INSERT INTO `derm_pharmacy` (derm_id,pharmacy_id) values (400,1);
INSERT INTO `derm_pharmacy` (derm_id,pharmacy_id) values (500,2);

INSERT INTO `examinations` (id,date,duration,price,status,time,dermatologist_id,patient_id,pharmacy_id) values (1,'2021-09-30',0,500,3,'8:00',400,null,1);
INSERT INTO `examinations` (id,date,duration,price,status,time,dermatologist_id,patient_id,pharmacy_id) values (2,'2021-09-20',0,1500,3,'8:30',500,null,2);
INSERT INTO `examinations` (id,date,duration,price,status,time,dermatologist_id,patient_id,pharmacy_id) values (3,'2021-09-30',0,2000,3,'9:30',500,null,2);
INSERT INTO `examinations` (id,date,duration,price,status,time,dermatologist_id,patient_id,pharmacy_id) values (4,'2021-09-30',0,2000,3,'8:00',500,null,2);
INSERT INTO `examinations` (id,date,duration,price,status,time,dermatologist_id,patient_id,pharmacy_id) values (5,'2021-09-03',1,1500,1,'8:00',500,200,2);
INSERT INTO `examinations` (id,date,duration,price,status,time,dermatologist_id,patient_id,pharmacy_id) values (6,'2021-09-02',0,3500,4,'8:00',400,200,1);
INSERT INTO `examinations` (id,date,duration,price,status,time,dermatologist_id,patient_id,pharmacy_id) values (7,'2021-09-02',0,3500,0,'8:30',400,200,1);
INSERT INTO `examinations` (id,date,duration,price,status,time,dermatologist_id,patient_id,pharmacy_id) values (8,'2021-09-02',0,3500,2,'8:30',400,200,1);


INSERT INTO `consulting` (id,date,duration,price,status,time,patient_id,pharmacist_id) values (1,'2021-09-30',0,800,3,'8:00',null,600);
INSERT INTO `consulting` (id,date,duration,price,status,time,patient_id,pharmacist_id) values (2,'2021-08-31',0,800,4,'9:00',300,600);
INSERT INTO `consulting` (id,date,duration,price,status,time,patient_id,pharmacist_id) values (3,'2021-08-31',0,800,0,'9:30',300,600);
INSERT INTO `consulting` (id,date,duration,price,status,time,patient_id,pharmacist_id) values (4,'2021-09-10',0,800,3,'9:30',null,600);
INSERT INTO `consulting` (id,date,duration,price,status,time,patient_id,pharmacist_id) values (6,'2021-09-03',0,800,4,'10:30',200,600);
INSERT INTO `consulting` (id,date,duration,price,status,time,patient_id,pharmacist_id) values (7,'2021-09-10',0,800,3,'10:30',null,800);

INSERT INTO `consulting` (id,date,duration,price,status,time,patient_id,pharmacist_id) values (5,'2021-09-10',0,800,3,'9:00',null,800);

INSERT INTO `med_price_list_items` (id,name,price,medicine_id,medicine_price_list_id) values (1,'Ibuprofen',500,1,1);
INSERT INTO `med_price_list_items` (id,name,price,medicine_id,medicine_price_list_id) values (2,'Rapten',200,2,1);
INSERT INTO `med_price_list_items` (id,name,price,medicine_id,medicine_price_list_id) values (3,'Hemomicin',800,3,1);
INSERT INTO `med_price_list_items` (id,name,price,medicine_id,medicine_price_list_id) values (4,'Amoksicilin',600,4,1);
INSERT INTO `med_price_list_items` (id,name,price,medicine_id,medicine_price_list_id) values (5,'Hloropiramin',1000,5,1);
INSERT INTO `med_price_list_items` (id,name,price,medicine_id,medicine_price_list_id) values (6,'Rezorcinol',900,6,1);

INSERT INTO `pharmacy_storage`(id,in_stock,medicine_id,medicine_name,pharmacy_id,reserved) values(11,5,1,'Ibuprofen',1,1);
INSERT INTO `pharmacy_storage`(id,in_stock,medicine_id,medicine_name,pharmacy_id,reserved) values(22,0,2,'Rapten',1,1);
INSERT INTO `pharmacy_storage`(id,in_stock,medicine_id,medicine_name,pharmacy_id,reserved) values(33,6,3,'Hemomicin',1,1);
INSERT INTO `pharmacy_storage`(id,in_stock,medicine_id,medicine_name,pharmacy_id,reserved) values(44,4,4,'Amoksicilin',1,1);
INSERT INTO `pharmacy_storage`(id,in_stock,medicine_id,medicine_name,pharmacy_id,reserved) values(55,0,5,'Hloropiramin',1,1);
INSERT INTO `pharmacy_storage`(id,in_stock,medicine_id,medicine_name,pharmacy_id,reserved) values(57,9,6,'Rezorcinol',1,1);
INSERT INTO `pharmacy_storage`(id,in_stock,medicine_id,medicine_name,pharmacy_id,reserved) values(58,9,7,'Ibuprofen',1,1);

INSERT INTO `pharmacy_storage`(id,in_stock,medicine_id,medicine_name,pharmacy_id,reserved) values(66,0,1,'Ibuprofen',2,1);
INSERT INTO `pharmacy_storage`(id,in_stock,medicine_id,medicine_name,pharmacy_id,reserved) values(77,5,2,'Rapten',2,1);
INSERT INTO `pharmacy_storage`(id,in_stock,medicine_id,medicine_name,pharmacy_id,reserved) values(88,6,3,'Hemomicin',2,1);
INSERT INTO `pharmacy_storage`(id,in_stock,medicine_id,medicine_name,pharmacy_id,reserved) values(99,1,4,'Amoksicilin',2,1);
INSERT INTO `pharmacy_storage`(id,in_stock,medicine_id,medicine_name,pharmacy_id,reserved) values(100,0,5,'Hloropiramin',2,1);
INSERT INTO `pharmacy_storage`(id,in_stock,medicine_id,medicine_name,pharmacy_id,reserved) values(101,9,6,'Rezorcinol',2,1);

INSERT INTO `pharmacy_storage`(id,in_stock,medicine_id,medicine_name,pharmacy_id,reserved) values(111,5,1,'Ibuprofen',3,1);
INSERT INTO `pharmacy_storage`(id,in_stock,medicine_id,medicine_name,pharmacy_id,reserved) values(222,0,2,'Rapten',3,1);
INSERT INTO `pharmacy_storage`(id,in_stock,medicine_id,medicine_name,pharmacy_id,reserved) values(333,6,3,'Hemomicin',3,1);
INSERT INTO `pharmacy_storage`(id,in_stock,medicine_id,medicine_name,pharmacy_id,reserved) values(444,4,4,'Amoksicilin',3,1);
INSERT INTO `pharmacy_storage`(id,in_stock,medicine_id,medicine_name,pharmacy_id,reserved) values(555,0,5,'Hloropiramin',3,1);
INSERT INTO `pharmacy_storage`(id,in_stock,medicine_id,medicine_name,pharmacy_id,reserved) values(556,9,6,'Rezorcinol',3,1);

INSERT INTO `pharmacy_promotion`(id, med_name, pharmacy_id, price_before, price_after, start_date, end_date, description) values(1, 'Rapten', 1, 20, 15, '2021-08-20', '2021-08-25', 'sadad');
INSERT INTO `pharmacy_promotion`(id, med_name, pharmacy_id, price_before, price_after, start_date, end_date, description) values(2, 'Rapten', 1, 20, 15, '2021-08-20', '2021-08-25', 'sadad');
INSERT INTO `pharmacy_promotion`(id, med_name, pharmacy_id, price_before, price_after, start_date, end_date, description) values(3, 'Rapten', 1, 20, 15, '2021-08-20', '2021-08-25', 'sadad');
INSERT INTO `pharmacy_promotion`(id, med_name, pharmacy_id, price_before, price_after, start_date, end_date, description) values(4, 'Rapten', 1, 20, 15, '2021-08-20', '2021-08-25', 'sadad');

insert into `loyalty`(id,consulting_points,examination_points,gold_points,regular_points,silver_points) values(11,3,3,50,0,30);
insert into `medicine_reservation`(id,medicine_id,medicine_name,patient_email,patient_id,pharmacy_id,pharmacy_name,pick_up_date,reservation_code,status)values (100,1,'Ibuprofen','pacijent1@gmail.com',200,1,'Benu','2021-08-20','a1a1a1a1adf',0);
insert into `medicine_reservation`(id,medicine_id,medicine_name,patient_email,patient_id,pharmacy_id,pharmacy_name,pick_up_date,reservation_code,status)values (300,1,'Ibuprofen','pacijent1@gmail.com',200,1,'Benu','2021-08-21','a1a1a1jjjja1adf',1);
insert into `medicine_reservation`(id,medicine_id,medicine_name,patient_email,patient_id,pharmacy_id,pharmacy_name,pick_up_date,reservation_code,status)values (200,1,'Ibuprofen','pacijent1@gmail.com',200,1,'Benu','2021-07-21','a1a1a1jjjja1adf',0);
insert into `medicine_reservation`(id,medicine_id,medicine_name,patient_email,patient_id,pharmacy_id,pharmacy_name,pick_up_date,reservation_code,status)values (400,1,'Rapten','pacijent1@gmail.com',200,1,'Benu','2021-09-01','a1a1a1jjjja1adf',2);

INSERT INTO `order_item` (id,amount,medicine_id) values (1,3,1);
INSERT INTO `order_item` (id,amount,medicine_id) values (2,5,2);
INSERT INTO `order_item` (id,amount,medicine_id) values (3,8,2);
INSERT INTO `order_item` (id,amount,medicine_id) values (4,25,1);
INSERT INTO `order_item` (id,amount,medicine_id) values (5,25,3);
INSERT INTO `order_item` (id,amount,medicine_id) values (6,25,4);

INSERT INTO `order_medicines` (id,order_status,ph_admin,time_limit,pharmacy_id) values (70,2,"Jovan",'2021-09-28',1);
INSERT INTO `order_medicines` (id,order_status,ph_admin,time_limit,pharmacy_id) values (80,2,"Jovan",'2021-09-29',1);
INSERT INTO `order_medicines` (id,order_status,ph_admin,time_limit,pharmacy_id) values (92,2,"Jovana",'2021-09-23',2);

INSERT INTO `order_medicines_order_items`(order_medicines_id,order_items_id) values (70,1);
INSERT INTO `order_medicines_order_items` (order_medicines_id,order_items_id) values (70,2);
INSERT INTO `order_medicines_order_items` (order_medicines_id,order_items_id) values (80,3);
INSERT INTO `order_medicines_order_items` (order_medicines_id,order_items_id) values (92,4);
INSERT INTO `order_medicines_order_items`(order_medicines_id,order_items_id) values (92,5);
INSERT INTO `order_medicines_order_items` (order_medicines_id,order_items_id) values (92,6)

