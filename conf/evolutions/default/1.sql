# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table "city" (
  id                            uuid not null,
  name                          varchar(255),
  country                       uuid,
  constraint pk_city primary key (id)
);

create table "country" (
  id                            uuid not null,
  name                          varchar(255),
  constraint pk_country primary key (id)
);

create table "cousine" (
  id                            uuid not null,
  name                          varchar(255),
  constraint pk_cousine primary key (id)
);

create table "menu" (
  id                            uuid not null,
  name                          varchar(255),
  type                          varchar(255),
  description                   varchar(255),
  price                         varchar(255),
  restaurant                    uuid,
  constraint pk_menu primary key (id)
);

create table "photo" (
  id                            uuid not null,
  photopath                     varchar(255),
  restaurant                    uuid,
  constraint pk_photo primary key (id)
);

create table reservations (
  id                            uuid not null,
  table_id                      uuid,
  userid                        uuid,
  reservationtime               timestamptz,
  starttime                     timestamptz,
  isconfirmed                   boolean,
  constraint pk_reservations primary key (id)
);

create table "restaurant_table" (
  id                            uuid not null,
  restaurantid                  uuid,
  chairs                        integer,
  constraint pk_restaurant_table primary key (id)
);

create table "restaurant" (
  id                            uuid not null,
  name                          varchar(255),
  address                       varchar(255),
  description                   varchar(255),
  pricerange                    float,
  rating                        float,
  profileimagefile              varchar(255),
  opentime                      varchar(255),
  closetime                     varchar(255),
  phone                         varchar(255),
  coverfile                     varchar(255),
  longitude                     float,
  latitude                      float,
  city                          uuid,
  constraint pk_restaurant primary key (id)
);

create table restaurant_cousine (
  restaurant                    uuid not null,
  cousine                       uuid not null,
  constraint pk_restaurant_cousine primary key (restaurant,cousine)
);

create table "review" (
  id                            uuid not null,
  name                          varchar(255),
  restaurant                    uuid,
  constraint pk_review primary key (id)
);

create table "users" (
  id                            uuid not null,
  firstname                     varchar(255),
  lastname                      varchar(255),
  city                          varchar(255),
  country                       varchar(255),
  phone                         varchar(255),
  email                         varchar(255),
  passwor                       varchar(255),
  is_admin                      boolean,
  constraint pk_users primary key (id)
);

alter table "city" add constraint fk_city_country foreign key (country) references "country" (id) on delete restrict on update restrict;
create index ix_city_country on "city" (country);

alter table "menu" add constraint fk_menu_restaurant foreign key (restaurant) references "restaurant" (id) on delete restrict on update restrict;
create index ix_menu_restaurant on "menu" (restaurant);

alter table "photo" add constraint fk_photo_restaurant foreign key (restaurant) references "restaurant" (id) on delete restrict on update restrict;
create index ix_photo_restaurant on "photo" (restaurant);

alter table reservations add constraint fk_reservations_table_id foreign key (table_id) references "restaurant_table" (id) on delete restrict on update restrict;
create index ix_reservations_table_id on reservations (table_id);

alter table reservations add constraint fk_reservations_userid foreign key (userid) references "users" (id) on delete restrict on update restrict;
create index ix_reservations_userid on reservations (userid);

alter table "restaurant_table" add constraint fk_restaurant_table_restaurantid foreign key (restaurantid) references "restaurant" (id) on delete restrict on update restrict;
create index ix_restaurant_table_restaurantid on "restaurant_table" (restaurantid);

alter table "restaurant" add constraint fk_restaurant_city foreign key (city) references "city" (id) on delete restrict on update restrict;
create index ix_restaurant_city on "restaurant" (city);

alter table restaurant_cousine add constraint fk_restaurant_cousine_restaurant foreign key (restaurant) references "restaurant" (id) on delete restrict on update restrict;
create index ix_restaurant_cousine_restaurant on restaurant_cousine (restaurant);

alter table restaurant_cousine add constraint fk_restaurant_cousine_cousine foreign key (cousine) references "cousine" (id) on delete restrict on update restrict;
create index ix_restaurant_cousine_cousine on restaurant_cousine (cousine);

alter table "review" add constraint fk_review_restaurant foreign key (restaurant) references "restaurant" (id) on delete restrict on update restrict;
create index ix_review_restaurant on "review" (restaurant);


# --- !Downs

alter table if exists "city" drop constraint if exists fk_city_country;
drop index if exists ix_city_country;

alter table if exists "menu" drop constraint if exists fk_menu_restaurant;
drop index if exists ix_menu_restaurant;

alter table if exists "photo" drop constraint if exists fk_photo_restaurant;
drop index if exists ix_photo_restaurant;

alter table if exists reservations drop constraint if exists fk_reservations_table_id;
drop index if exists ix_reservations_table_id;

alter table if exists reservations drop constraint if exists fk_reservations_userid;
drop index if exists ix_reservations_userid;

alter table if exists "restaurant_table" drop constraint if exists fk_restaurant_table_restaurantid;
drop index if exists ix_restaurant_table_restaurantid;

alter table if exists "restaurant" drop constraint if exists fk_restaurant_city;
drop index if exists ix_restaurant_city;

alter table if exists restaurant_cousine drop constraint if exists fk_restaurant_cousine_restaurant;
drop index if exists ix_restaurant_cousine_restaurant;

alter table if exists restaurant_cousine drop constraint if exists fk_restaurant_cousine_cousine;
drop index if exists ix_restaurant_cousine_cousine;

alter table if exists "review" drop constraint if exists fk_review_restaurant;
drop index if exists ix_review_restaurant;

drop table if exists "city" cascade;

drop table if exists "country" cascade;

drop table if exists "cousine" cascade;

drop table if exists "menu" cascade;

drop table if exists "photo" cascade;

drop table if exists reservations cascade;

drop table if exists "restaurant_table" cascade;

drop table if exists "restaurant" cascade;

drop table if exists restaurant_cousine cascade;

drop table if exists "review" cascade;

drop table if exists "users" cascade;

