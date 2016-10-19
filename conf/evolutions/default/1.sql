# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table client (
  id                        bigint not null,
  name                      varchar(255),
  nif                       varchar(255),
  email                     varchar(255),
  address                   varchar(255),
  cep                       varchar(255),
  country                   varchar(255),
  constraint pk_client primary key (id))
;

create table invoice (
  id                        bigint not null,
  date                      timestamp,
  validate                  varchar(255),
  reference                 varchar(255),
  isencao_iva               varchar(255),
  description               varchar(255),
  retention                 double,
  currency                  varchar(255),
  client_id                 bigint,
  constraint pk_invoice primary key (id))
;

create table item (
  id                        bigint not null,
  reference                 varchar(255),
  description               varchar(255),
  price                     double,
  quantity                  integer,
  unit                      integer,
  iva                       float,
  descount                  float,
  invoice_id                bigint,
  constraint pk_item primary key (id))
;

create sequence client_seq;

create sequence invoice_seq;

create sequence item_seq;

alter table invoice add constraint fk_invoice_client_1 foreign key (client_id) references client (id) on delete restrict on update restrict;
create index ix_invoice_client_1 on invoice (client_id);
alter table item add constraint fk_item_invoice_2 foreign key (invoice_id) references invoice (id) on delete restrict on update restrict;
create index ix_item_invoice_2 on item (invoice_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists client;

drop table if exists invoice;

drop table if exists item;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists client_seq;

drop sequence if exists invoice_seq;

drop sequence if exists item_seq;

