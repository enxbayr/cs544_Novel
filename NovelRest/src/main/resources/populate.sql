 
INSERT INTO CREDENTIALS(username,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO CREDENTIALS(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);
                                                                     
INSERT INTO Authority (id,username, authority) VALUES (1,'guest', 'ROLE_USER');
INSERT INTO Authority (id,username, authority) VALUES (2,'admin', 'ROLE_ADMIN');

INSERT INTO  `User` (id,first_name, last_name,age,title,member_number, member_id) VALUES (1,'Curious','George',12,'Boy Monkey', 8754,'admin');
INSERT INTO `User` (id,first_name, last_name,age,title,member_number,member_id) VALUES (2,'Allen','Rench',123,'Torque Master', 8733,'guest');

INSERT INTO `Address` (id,city,state,street,member_id) VALUES (1,'Fairfield','Iowa','Main','1');
INSERT INTO `Address` (id,city,state,street,member_id) VALUES (2,'Batavia','Iowa','Maple','2');
INSERT INTO `Address` (id,city,state,street,member_id) VALUES (3,'Ottumwa','Iowa','Maple','2');
					