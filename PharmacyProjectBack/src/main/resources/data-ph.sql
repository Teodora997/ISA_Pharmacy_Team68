insert into Patients (First_Name,Last_Name,Password,email) values('Pera','Peric','pera123','pera@');

insert into AUTHORITY (name) values ('ROLE_PATIENT');

INSERT INTO user_authority (user_id,authority_id) values(1,1);