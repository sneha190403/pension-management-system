insert into userdao (id,email,password) values (1, 'sam@123','$2a$10$CYyFX/q2K7TAvsDzf8YYiOPyp6SL3lp3rxu0EqQ7GbQiByR6QRS12');

insert into process_pension_input (id,aadhaar_number) values (1, '987654321098');
insert into process_pension_input (id,aadhaar_number) values (2, '123456789077');
insert into process_pension_input (id,aadhaar_number) values (3, '876550982365');

INSERT INTO `pensioner_detail`(`id`,`allowances`,`dob`,`mode`,`name`,`pan_number`,`salary`,`pension_input`,`account_number`,`bank_name`,`bank_type`)
VALUES(1,20000,'1987-08-12 00:00:00','self','RAM KESHAV','PAN123',80000,1,'ACCOUNT123','ICICI Bank','Private');

INSERT INTO `pensioner_detail`(`id`,`allowances`,`dob`,`mode`,`name`,`pan_number`,`salary`,`pension_input`,`account_number`,`bank_name`,`bank_type`)
VALUES(2,15000,'1976-08-12 00:00:00','self','HARRY NOHARA','PAN456',45000,2,'ACCOUNT456','SBI Bank','Public');

INSERT INTO `pensioner_detail`(`id`,`allowances`,`dob`,`mode`,`name`,`pan_number`,`salary`,`pension_input`,`account_number`,`bank_name`,`bank_type`)
VALUES(3,10000,'1956-08-12 00:00:00','family','MISTY DEY','PAN789',67000,3,'ACCOUNT789','Union Bank','Private');
