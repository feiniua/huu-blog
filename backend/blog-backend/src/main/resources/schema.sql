use myblog;
CREATE TABLE article (
                         id VARCHAR(36) NOT NULL,
                         content TEXT,
                         create_at DATETIME(6),
                         image_address VARCHAR(255),
                         title VARCHAR(255) NOT NULL,
                         PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE article_tags (
                              article_id VARCHAR(36) NOT NULL,
                              tags_id VARCHAR(36) NOT NULL,
                              PRIMARY KEY (article_id , tags_id)
)  ENGINE=INNODB;
CREATE TABLE permission (
                            id VARCHAR(255) NOT NULL,
                            name VARCHAR(255),
                            PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE role (
                      id VARCHAR(255) NOT NULL,
                      name VARCHAR(255),
                      PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE role_permissions (
                                  role_id VARCHAR(255) NOT NULL,
                                  permissions_id VARCHAR(255) NOT NULL,
                                  PRIMARY KEY (role_id , permissions_id)
)  ENGINE=INNODB;
CREATE TABLE tag (
                     id VARCHAR(36) NOT NULL,
                     name VARCHAR(255),
                     PRIMARY KEY (id)
)  ENGINE=INNODB;
CREATE TABLE user (
                      id VARCHAR(36) NOT NULL,
                      password VARCHAR(255),
                      username VARCHAR(255),
                      role VARCHAR(255),
                      PRIMARY KEY (id)
)  ENGINE=INNODB;
alter table article_tags
    add constraint FKp6owh2p5p9yllwwrc2hn7bnxr
        foreign key (tags_id)
            references tag (id);
alter table article_tags
    add constraint FK85ph188kqbfc5u1gq0tme7flk
        foreign key (article_id)
            references article (id);
alter table role_permissions
    add constraint FKclluu29apreb6osx6ogt4qe16
        foreign key (permissions_id)
            references permission (id);
alter table role_permissions
    add constraint FKlodb7xh4a2xjv39gc3lsop95n
        foreign key (role_id)
            references role (id);
alter table user
    add constraint FKl5alypubd40lwejc45vl35wjb
        foreign key (role)
            references role (id);
INSERT INTO permission(id,name) VALUES (UUID(),"add");
INSERT INTO permission(id,name) VALUES (UUID(),"edit");
INSERT INTO permission(id,name) VALUES (UUID(),"delete");
INSERT INTO permission(id,name) VALUES (UUID(),"find");
INSERT INTO role(id,name) VALUES (UUID(),"admin");
INSERT INTO role(id,name) VALUES (UUID(),"guest");
INSERT INTO role_permissions(role_id,permissions_id) SELECT role.id,permission.id FROM role,permission WHERE role.name="admin";
INSERT INTO role_permissions(role_id,permissions_id) SELECT role.id,permission.id FROM role,permission WHERE role.name="guest" AND permission.name="find";
INSERT INTO user(id,username,password,role) SELECT UUID(),"admin","e10adc3949ba59abbe56e057f20f883e",role.id FROM role WHERE role.name="admin";
INSERT INTO user(id,username,password,role) SELECT UUID(),"xian","e10adc3949ba59abbe56e057f20f883e",role.id FROM role WHERE role.name="guest";