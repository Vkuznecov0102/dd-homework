drop table if exists administrator,catalog,document,moderator,user,version;

create table user(
id bigint auto_increment primary key,
login varchar(255),
password varchar(255),
catalog_id bigint
);

create table document(
id bigint auto_increment primary key,
name varchar(255),
priority varchar(255),
version_id bigint
);

create table catalog(
id bigint auto_increment primary key,
name varchar(255),
typeofview varchar(255),
document_id bigint
);

create table administrator(
id bigint auto_increment primary key,
user_id bigint
);

create table version(
id bigint auto_increment primary key,
document_id bigint
);

alter table user add foreign key(document_id) references document(id);

alter table document add foreign key(version_id) references version(id);

alter table document add foreign key(catalog_id) references catalog(id);

alter table administrator add foreign key(user_id) references user(id);

alter table administrator add foreign key(moderator_id) references moderator(id);

alter table moderator add foreign key(administrator_id) references administrator(id);

alter table version add foreign key(document_id) references document(id);