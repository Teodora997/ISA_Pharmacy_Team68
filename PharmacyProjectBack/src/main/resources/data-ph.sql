INSERT INTO `authority` (name) VALUES ('ROLE_PH_ADMIN');
INSERT INTO `authority` (name) VALUES ('ROLE_SYS_ADMIN');
INSERT INTO `authority` (name) VALUES ('ROLE_DERMATOLOGIST');
INSERT INTO `authority` (name) VALUES ('ROLE_PATIENT');
INSERT INTO `authority` (name) VALUES ('ROLE_PHARMACIST');


INSERT INTO `user` (id, address, city, email, is_activated, first_name,last_name, password, telephone, role) VALUES (1, 'Kralja Petra 42', 'Novi Sad', 'admin1@gmail.com', true, 'Jovan', 'Jovic','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06122251251', 'ROLE_PH_ADMIN');
INSERT INTO `user` (id, address, city, email, is_activated, first_name,last_name, password, telephone, role) VALUES (2, 'Nevesinjska 5', 'Beograd', 'pacijent1@gmail.com', true, 'Milos', 'Milovic','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06022251232', 'ROLE_PATIENT');
INSERT INTO `user` (id, address, city, email, is_activated, first_name, last_name,password, telephone, role) VALUES (3, 'Ive Andrica 11', 'Beograd', 'pacijent2@gmail.com', true, 'Ranka','Rakic', '$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06566551288', 'ROLE_PATIENT');
INSERT INTO `user` (id, address, city, email, is_activated, first_name, last_name,password, telephone, role) VALUES (4, 'Strazilovska 59', 'Novi Sad', 'dermatolog1@gmail.com', true, 'Marija','Maric', '$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06566000288', 'ROLE_DERMATOLOGIST');
INSERT INTO `user` (id, address, city,  email, is_activated, first_name,last_name, password, telephone, role) VALUES (5, 'Nevinih zrtava 13', 'Novi Sad',  'dermatolog2@gmail.com', true, 'Blagoje', 'Blazic','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06566000288', 'ROLE_DERMATOLOGIST');
INSERT INTO `user` (id, address, city, email, is_activated, first_name,last_name, password, telephone, role) VALUES (6, 'Strazilovska 10', 'Novi Sad', 'farmaceut1@gmail.com', true, 'Sandra', 'Saric','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06566000288', 'ROLE_PHARMACIST');
INSERT INTO `user` (id, address, city,  email, is_activated, first_name,last_name, password, telephone, role) VALUES (7, 'Brace Ribnikar 10', 'Nis',  'sadmin1@gmail.com', true, 'Aleksa', 'Aleksic','$2y$10$CzQgd1fUHL/tGHUsRUmTMuDCCLqbcUTwMlp6ebscwTmt04xVj8Zhu', '06512000288', 'ROLE_SYS_ADMIN');


INSERT INTO `user_authority` (user_id, authority_id) VALUES (1, 1);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (2, 4);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (3, 4);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (4, 3);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (5, 3);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (6, 5);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (7, 2);

INSERT INTO `work_time` (id,from_date,shift,to_date) values (1,'',1,'');
INSERT INTO `work_time` (id,from_date,shift,to_date) values (2,'',2,'');

INSERT INTO `patients` (allergy,category,penals,points,id) values ('Penicilin','Kategorija',1,10,2);
INSERT INTO `patients` (allergy,category,penals,points,id) values ('Penicilin','Kategorija',1,10,3);

INSERT INTO `dermatologists` (mark,id,work_time_id) values (0,4,1);
INSERT INTO `dermatologists` (mark,id,work_time_id) values (0,5,2);

INSERT INTO `examination_price_list` (id,examinations,price) values (1,'',3000);

INSERT INTO `medicines` (id,additional,alternative,form,ingredients,name,producer,regime,type) values (1,'',1,'','','','','','');

INSERT INTO `medicine_price_list` (id,from_date,to_date) values (1,'','');

INSERT INTO `pharmacies` (id,address,mark,name,id_ex_price_list,id_med_price_list) values (1,'Bulevar Oslobodjenja 88',0,'Benu',1,1);

INSERT INTO `pharmacists` (mark,id,pharmacy_id,work_time_id) values (0,6,1,1);

INSERT INTO `pharmacy_admins` (id,pharmacy_id) values (1,1);

INSERT INTO `system_admins` (id) values (1);

INSERT INTO `derm_pharmacy` (derm_id,pharmacy_id) values (4,1);
INSERT INTO `derm_pharmacy` (derm_id,pharmacy_id) values (5,1);

INSERT INTO `examinations` (id,date,duration,price,time,dermatologist_id,patient_id,pharmacy_id) values (1,'',0,0,'',4,2,1);

INSERT INTO `med_price_list_items` (id,name,price,medicine_id,medicine_price_list_id) values (1,'Ibuprofen',0,1,1);

