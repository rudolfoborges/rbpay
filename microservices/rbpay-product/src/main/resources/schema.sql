create table if not exists products (
  id varchar(50) primary key not null,
  name varchar(150) not null,
  price decimal(10,2) not null,
  about_it varchar(255) not null,
  image_url varchar(150) not null,
  active tinyint(1) not null,
  created_at datetime default current_timestamp not null
);