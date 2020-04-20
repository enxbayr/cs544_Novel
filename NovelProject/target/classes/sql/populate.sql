
INSERT INTO credentials (username, enabled, password, user_role,verify_password) VALUES ('Admin',NULL,'$2a$10$80V1HDDrx2iuDcltnOpI9OpR1/lXvwbSJdh97fjcC/nfY6nLk7SAW','ADMIN',NULL);
INSERT INTO credentials (username,enabled,password,user_role,verify_password) VALUES ('Member',NULL,'$2a$10$nWXCIZZ5W/Z10tPdaRAvwOuKP2llgU4roTn8FE7iFjd.kRVYmabkW','STUDENT',NULL);


INSERT INTO  member (id,email,first_name,last_name,member_number,user_credentials_username) VALUES (3,'admin@miu.edu','AdminFirstname','AdminLastname',0,'Admin');
INSERT INTO  member (id,email,first_name,last_name,member_number,user_credentials_username) VALUES (4,'member@miu.edu','Membername','MemberLname',122,'Member');

INSERT INTO  authority (id,authority,username,credentials_id) VALUES (0,'Admin','Admin','Admin');
INSERT INTO  authority (id,authority,username,credentials_id) VALUES (1,'Member','Member','Member');

