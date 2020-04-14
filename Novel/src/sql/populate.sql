 
INSERT INTO Credentials(username,password,enabled) VALUES ('guest','guest', TRUE);
INSERT INTO Credentials(username,password,enabled) VALUES ('admin','admin', TRUE);
 
INSERT INTO Authority (id,username, authority,credentials_id) VALUES (1,'guest', 'ROLE_USER','guest');
INSERT INTO Authority (id,username, authority,credentials_id) VALUES (2,'admin', 'ROLE_ADMIN','admin');
INSERT INTO Authority (id,username, authority,credentials_id) VALUES (3,'admin', 'ROLE_USER','admin');

INSERT INTO  `USER` (id,firstname, lastname,age,title,membernumber, member_id) VALUES (1,'Curious','George',12,'Boy Monkey', 8754,'admin');
INSERT INTO `USER` (id,firstname, lastname,age,title,membernumber,member_id) VALUES (2,'Allen','Rench',123,'Torque Master', 8733,'guest');

INSERT INTO `ADDRESS` (id,city,state,street,member_id) VALUES (1,'Fairfield','Iowa','Main','1');
INSERT INTO `ADDRESS` (id,city,state,street,member_id) VALUES (2,'Batavia','Iowa','Maple','2');
INSERT INTO `ADDRESS` (id,city,state,street,member_id) VALUES (3,'Eldon','Iowa','Gothic','1');
