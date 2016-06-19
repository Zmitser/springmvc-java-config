# USERS
INSERT INTO `user` (username, password, enabled) VALUES ('user', 'passsword', true);
INSERT INTO `user` (username, password, enabled) VALUES ('admin', 'passsword', true);
INSERT INTO `user` (username, password, enabled) VALUES ('test1@outlook.com', '12345', true);
INSERT INTO `user` (username, password, enabled) VALUES ('test1@outlook.com', '12345', true);


# AUTHORITIES
INSERT INTO `authorities` (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO `authorities` (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO `authorities` (username, authority) VALUES ('test1@outlook.com', 'ROLE_USER');
INSERT INTO `authorities` (username, authority) VALUES ('test1@outlook.com', 'ROLE_USER');

# BLOGPOST
INSERT INTO `blog_post` (content, draft, publish_date,title ,user_id) VALUES ('test content for Spring MVC',FALSE , now(), 'test', 1);
