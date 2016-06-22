DELETE FROM `user`;
DELETE FROM `authorities`;
DELETE FROM `blog_post`;

# USERS
INSERT INTO `user` (id, username, password, enabled) VALUES (1, 'user', 'passsword', true);
INSERT INTO `user` (id,username, password, enabled) VALUES (2, 'admin', 'passsword', true);
INSERT INTO `user` (id,username, password, enabled) VALUES (3, 'test1@outlook.com', '12345', true);
INSERT INTO `user` (id,username, password, enabled) VALUES (4, 'test1@outlook.com', '12345', true);


# AUTHORITIES
INSERT INTO `authorities` (id,username, authority) VALUES (1, 'user', 'ROLE_USER');
INSERT INTO `authorities` (id,username, authority) VALUES (2, 'admin', 'ROLE_ADMIN');
INSERT INTO `authorities` (id,username, authority) VALUES (3, 'test1@outlook.com', 'ROLE_USER');
INSERT INTO `authorities` (id,username, authority) VALUES (4, 'test1@outlook.com', 'ROLE_USER');

# BLOGPOST
INSERT INTO `blog_post` (id,content, draft, publish_date, title ,user_id) VALUES (1, 'test content for Spring MVC', false , now(), 'test', 1);
