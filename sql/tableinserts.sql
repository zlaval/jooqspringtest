create table if not exists orders
(
    id       int primary key,
    batch_id int,
    created  timestamp not null,
    username varchar(50) unique
);

create table if not exists order_item
(
    id       int primary key,
    order_id int,
    created  timestamp not null,
    name varchar(50),
    foreign key (order_id) references orders (id)
);


insert into orders values (1,1,now(),'person1');
insert into orders values (2,1,now(),'person2');
insert into orders values (3,2,now(),'person3');

insert into order_item values (1,1,now(),'product1');
insert into order_item values (2,1,now(),'product2');
insert into order_item values (3,1,now(),'product3');
insert into order_item values (4,2,now(),'product1');
insert into order_item values (5,2,now(),'product6');
insert into order_item values (6,3,now(),'product2');
insert into order_item values (7,3,now(),'product7');
insert into order_item values (8,3,now(),'product8');

