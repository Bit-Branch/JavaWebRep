create schema if not exists chumak_p_g default character set utf8;

drop table if exists chumak_p_g.category;
drop table if exists chumak_p_g.user;
drop table if exists chumak_p_g.account;
drop table if exists chumak_p_g.item;
drop table if exists chumak_p_g.image;
drop table if exists chumak_p_g.address;
drop table if exists chumak_p_g.bid;
drop table if exists chumak_p_g.bankAccount;
drop table if exists chumak_p_g.creditCard;

create table if not exists chumak_p_g.category
(
    id int unsigned primary key auto_increment,
    Name varchar(50),
    ParentID int unsigned default null,
    constraint fk_parentid foreign key(ParentID)
        references category(id)
        on delete set null
);

create table if not exists chumak_p_g.user
(
    id int unsigned primary key auto_increment,
    Surname  varchar(45) null,
    Name      varchar(45) null,
    Patronymic varchar(45) null,
    passport_number  varchar(45) null,
    Email    varchar(45) null
);

create table if not exists chumak_p_g.account
(
    id              int         not null primary key auto_increment,
    Login           varchar(45) null,
    Password          varchar(45) null,
    Role            varchar(45) null,
    UserID int  unsigned   null,
    constraint account_id_uindex
        unique (id),
    constraint account_user_id_fk
        foreign key (UserID) references user (id)
            on update cascade on delete cascade
);

create table if not exists chumak_p_g.item
(
    id int unsigned primary key auto_increment,
    Name varchar(100) not null,
    initial_price decimal not null,
    current_price decimal not null,
    auction_start timestamp default CURRENT_TIMESTAMP,
    auction_end timestamp default CURRENT_TIMESTAMP,
    auction_ended bit(1) default 0,
    auction_in_progress bit(1) default 0,
    Description text,
    SellerID int unsigned null,
    CategoryID int unsigned default null,
                  constraint fk_sellerid_item foreign key(SellerID) references user(id) on delete cascade,
                  constraint fk_categoryid_item foreign key(CategoryID) references category(id) on delete set null
);


create table if not exists chumak_p_g.image
(
    id int unsigned primary key auto_increment,
    Name varchar(50),
    ImageURL varchar(255) not null,
    ItemID int unsigned not null,
    constraint fk_itemid_image foreign key(ItemID) references item(id) on delete cascade
);


create table if not exists chumak_p_g.address
(
    id int unsigned primary key auto_increment,
    Locality varchar(50) not null,
    Street varchar(50) not null,
    Building varchar(50) not null,
    Flat varchar(50) not null,
    zip_code varchar(20) not null,
    UserID int unsigned not null,
    constraint fk_userid_address foreign key(UserID) references user(id) on delete cascade
);


create table if not exists chumak_p_g.bid
(
    id int unsigned primary key auto_increment,
    Amount decimal not null,
    bid_time timestamp not null,
    is_success bit(1) default 0,
    ItemID int unsigned not null,
    UserID int unsigned not null,
                 constraint fk_itemid_bidding foreign key(ItemID) references item(id) on delete cascade,
                 constraint fk_userid_bidding foreign key(UserID) references user(id) on delete cascade
);

create table if not exists chumak_p_g.bookmark
(
    id int unsigned primary key auto_increment,
    ItemID int unsigned not null,
    UserID int unsigned not null,
    constraint fk_itemid_bookmark foreign key(ItemID) references item(id) on delete cascade,
    constraint fk_userid_bookmark foreign key(UserID) references user(id) on delete cascade
);

create table if not exists chumak_p_g.credit_card
(
    id int unsigned primary key auto_increment,
    card_number varchar(30) not null,
    expiry_month int not null,
    expiry_year int not null,
    Balance decimal not null,
    UserID int unsigned not null,
    constraint fk_userid_cc foreign key(UserID) references user(id) on delete cascade
);


INSERT INTO chumak_p_g.user(id , Surname, Name, Patronymic, passport_number, Email)
select * from(select 0,'Фамилия', 'Имя','Отчество', 'MC793405497', 'email@email.com') as tmp
where not exists(
        select Surname from chumak_p_g.user where Surname = 'Фамилия'
    ) limit 1;

INSERT INTO chumak_p_g.account(id , Login, Password, Role, UserID)
select * from(select 0,'Admin', 'Passw','Администратор', 1) as tmp
where not exists(
        select Login from chumak_p_g.account where Login = 'Admin'
    ) limit 1;

