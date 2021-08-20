INSERT INTO `authority` (name) VALUES ('ROLE_PH_ADMIN');
INSERT INTO `authority` (name) VALUES ('ROLE_SYS_ADMIN');
INSERT INTO `authority` (name) VALUES ('ROLE_DERMATOLOGIST');
INSERT INTO `authority` (name) VALUES ('ROLE_PATIENT');
INSERT INTO `authority` (name) VALUES ('ROLE_PHARMACIST');


INSERT INTO `user` (id, address, city, email, is_activated, first_name,last_name, password, telephone, role) VALUES (100, 'Kralja Petra 42', 'Novi Sad', 'admin1@gmail.com', true, 'Jovan', 'Jovic','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06122251251', 'ROLE_PH_ADMIN');
INSERT INTO `user` (id, address, city, email, is_activated, first_name,last_name, password, telephone, role) VALUES (200, 'Nevesinjska 5', 'Beograd', 'pacijent1@gmail.com', true, 'Milos', 'Milovic','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06022251232', 'ROLE_PATIENT');
INSERT INTO `user` (id, address, city, email, is_activated, first_name, last_name,password, telephone, role) VALUES (300, 'Ive Andrica 11', 'Beograd', 'pacijent2@gmail.com', true, 'Ranka','Rakic', '$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06566551288', 'ROLE_PATIENT');
INSERT INTO `user` (id, address, city, email, is_activated, first_name, last_name,password, telephone, role) VALUES (400, 'Strazilovska 59', 'Novi Sad', 'dermatolog1@gmail.com', true, 'Marija','Maric', '$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06566000288', 'ROLE_DERMATOLOGIST');
INSERT INTO `user` (id, address, city,  email, is_activated, first_name,last_name, password, telephone, role) VALUES (500, 'Nevinih zrtava 13', 'Novi Sad',  'dermatolog2@gmail.com', true, 'Blagoje', 'Blazic','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06566000288', 'ROLE_DERMATOLOGIST');
INSERT INTO `user` (id, address, city, email, is_activated, first_name,last_name, password, telephone, role) VALUES (600, 'Strazilovska 10', 'Novi Sad', 'farmaceut1@gmail.com', true, 'Sandra', 'Saric','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06566000288', 'ROLE_PHARMACIST');
INSERT INTO `user` (id, address, city,  email, is_activated, first_name,last_name, password, telephone, role) VALUES (700, 'Brace Ribnikar 10', 'Nis',  'sadmin1@gmail.com', true, 'Aleksa', 'Aleksic','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06512000288', 'ROLE_SYS_ADMIN');


INSERT INTO `user_authority` (user_id, authority_id) VALUES (100, 1);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (200, 4);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (300, 4);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (400, 3);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (500, 3);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (600, 5);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (700, 2);

INSERT INTO `work_time` (id,from_date,shift,to_date) values (1,'',1,'');
INSERT INTO `work_time` (id,from_date,shift,to_date) values (2,'',2,'');

INSERT INTO `patients` (category,penals,points,id) values ('Kategorija',1,10,200);
INSERT INTO `patients` (category,penals,points,id) values ('Kategorija',1,10,300);

INSERT INTO `dermatologists` (mark,id,work_time_id) values (0,400,1);
INSERT INTO `dermatologists` (mark,id,work_time_id) values (0,500,2);

INSERT INTO `examination_price_list` (id,examinations,price) values (1,'',3000);


INSERT INTO `medicines` (id,additional,form,ingredients,name,producer,regime,type) values (1,'','','','Ibuprofen','','','');
INSERT INTO `medicines` (id,additional,form,ingredients,name,producer,regime,type) values (2,'','','','Rapten','','','');
INSERT INTO  `patients_allergies` (patient_id,allergies_id)values (200,1);
INSERT INTO `medicine_price_list` (id,from_date,to_date) values (1,'','');

INSERT INTO `pharmacies` (id,address,mark,name,id_ex_price_list,id_med_price_list) values (1,'Bulevar Oslobodjenja 88',0,'Benu',1,1);
INSERT INTO `pharmacies` (id,address,mark,name,id_ex_price_list,id_med_price_list) values (2,'Kisacka 88',0,'Jankovic',1,1);

INSERT INTO `pharmacists` (mark,id,pharmacy_id,work_time_id) values (0,600,1,1);

INSERT INTO `pharmacy_admins` (id,pharmacy_id) values (100,1);

INSERT INTO `system_admins` (id) values (700);

INSERT INTO `derm_pharmacy` (derm_id,pharmacy_id) values (400,1);
INSERT INTO `derm_pharmacy` (derm_id,pharmacy_id) values (500,1);

INSERT INTO `examinations` (id,date,duration,price,status,time,dermatologist_id,patient_id,pharmacy_id) values (1,'2021-08-22',0,0,3,'',400,null,1);
INSERT INTO `examinations` (id,date,duration,price,status,time,dermatologist_id,patient_id,pharmacy_id) values (2,'2021-08-20',0,0,3,'',500,null,1);
INSERT INTO `consulting` (id,date,duration,price,status,time,patient_id,pharmacist_id) values (1,'2021-08-22',0,800,3,'8:00',null,600);
INSERT INTO `consulting` (id,date,duration,price,status,time,patient_id,pharmacist_id) values (2,'2021-08-22',0,800,0,'9:00',null,600);

INSERT INTO `consulting` (id,date,duration,price,status,time,patient_id,pharmacist_id) values (3,'2021-08-20',0,800,3,'9:00',null,600);

INSERT INTO `med_price_list_items` (id,name,price,medicine_id,medicine_price_list_id) values (1,'Ibuprofen',0,1,1);

