INSERT INTO `authority` (name) VALUES ('ROLE_PH_ADMIN');
INSERT INTO `authority` (name) VALUES ('ROLE_SYS_ADMIN');
INSERT INTO `authority` (name) VALUES ('ROLE_DERMATOLOGIST');
INSERT INTO `authority` (name) VALUES ('ROLE_PATIENT');
INSERT INTO `authority` (name) VALUES ('ROLE_PHARMACIST');


INSERT INTO `user` (id, address, city, email, is_activated, first_name, password, telephone, role, last_name) VALUES (1, 'Kralja Petra 42', 'Novi Sad', 'pswtim2+1@gmail.com', true, 'John', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06122251251', 'ROLE_PH_ADMIN', 'Doe');
INSERT INTO `user` (id, address, city, email, is_activated, first_name, password, telephone, role, last_name) VALUES (2, 'Jovana Obrenovica 55', 'Foca', 'pswtim2+2@gmail.com', true, 'Mike', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06022251232', 'ROLE_PATIENT', 'Smith');
INSERT INTO `user` (id, address, city, email, is_activated, first_name, password, telephone, role, last_name) VALUES (3, 'Ive Andrica 11', 'Nevesinje', 'pacijent2@pacijent.com', true, 'Ron', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06566551288', 'ROLE_PATIENT', 'Lo');
INSERT INTO `user` (id, address, city, email, is_activated, first_name, password, telephone, role, last_name) VALUES (4, 'Doktora Doktorica 59', 'Novi Sad', 'pswtim2+3@gmail.com', true, 'Doktorko', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06566000288', 'ROLE_DERMATOLOGIST', 'Doktoric');
INSERT INTO `user` (id, address, city,  email, is_activated, first_name, password, telephone, role, last_name) VALUES (5, 'Nevinih zrtava 13', 'Novi Sad',  'doktor1@doktor.com', true, 'Blagoje', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06566000288', 'ROLE_DERMATOLOGIST', 'Pantic');
INSERT INTO `user` (id, address, city, email, is_activated, first_name, password, telephone, role, last_name) VALUES (6, 'Simke Simica 10', 'Novi Sad', 'doktor2@doktor.com', true, 'Simka', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06566000288', 'ROLE_PHARMACIST', 'Simic');
INSERT INTO `user` (id, address, city,  email, is_activated, first_name, password, telephone, role, last_name) VALUES (7, 'Skolska 10', 'Nis',  'pswtim2+4@gmail.com', true, 'Cadmin', '$2a$10$iGnVynNJEax7VXDAAnl7eOn02lNDjQ.VXn4S8rqKiVOLhFnld8K3q', '06512000288', 'ROLE_SYS_ADMIN', 'Cadminic');


INSERT INTO `user_authority` (user_id, authority_id) VALUES (1, 1);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (2, 4);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (3, 4);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (4, 3);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (5, 3);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (6, 5);
INSERT INTO `user_authority` (user_id, authority_id) VALUES (7, 2);