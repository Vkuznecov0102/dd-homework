insert into catalog(id,name,typeofview) values(1,'first_catalog','read-only');
insert into catalog(id,name,typeofview) values(2,'first_catalog','read-only');
insert into catalog(id,name,typeofview) values(3,'first_catalog','read-only');

insert into document(id,name,priority,version_id,catalog_id) values(1,'first_doc','high',null,1);
insert into document(id,name,priority,version_id,catalog_id) values(2,'second_doc','low',null,2);
insert into document(id,name,priority,version_id,catalog_id) values(3,'third_doc','high',null,3);

insert into version(id,document_id) values(1,1);
insert into version(id,document_id) values(2,2);
insert into version(id,document_id) values(3,3);

insert into user(id,login,password,document_id) values(1,'ivan','joker1234',1);
insert into user(id,login,password,document_id) values(2,'andrey','joker1234',3);
insert into user(id,login,password,document_id) values(3,'ruslan','joker1234',2);

insert into administrator(id,user_id,moderator_id) values(1,1,null);
insert into administrator(id,user_id,moderator_id) values(2,2,null);
insert into administrator(id,user_id,moderator_id) values(3,3,null);

insert into moderator(id,administrator_id) values(1,1);
insert into moderator(id,administrator_id) values(2,2);
insert into moderator(id,administrator_id) values(3,3);