insert into catalog(id,name,user_id) values(1,'first_catalog',null);
insert into catalog(id,name,user_id) values(2,'second_catalog',null);
insert into catalog(id,name,user_id) values(3,'third_catalog',null);

insert into document(id,name,description,priority,typeofview,catalog_id) values(1,'first_doc','some_description','letter','high',1);
insert into document(id,name,description,priority,typeofview,catalog_id) values(2,'second_doc','some_description2','letter', 'low',2);
insert into document(id,name,description,priority,typeofview,catalog_id) values(3,'third_doc','some_description3','fax','high',3);

insert into version(id,document_id) values(1,1);
insert into version(id,document_id) values(2,2);
insert into version(id,document_id) values(3,3);

insert into user(id,login,password,administrator_id) values(1,'ivan','joker1234',null);
insert into user(id,login,password,administrator_id) values(2,'andrey','joker5678',null);
insert into user(id,login,password,administrator_id) values(3,'ruslan','batman1234',null);

insert into administrator(id,user_id) values(1,1);
insert into administrator(id,user_id) values(2,3);