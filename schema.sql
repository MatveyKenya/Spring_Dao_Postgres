/* создаем табл */

CREATE TABLE customers (
                           id serial primary key ,
                           name varchar(50) not null,
                           surname varchar(50) not null,
                           age integer not null check ( age > 0 ),
                           phone_number varchar(50) default 'empty'
);

CREATE TABLE orders (
                        id serial primary key ,
                        date date not null default now(),
                        customer_id serial,
                        amount integer not null check ( orders.amount >= 0 ),
                        product_name varchar(50) not null,
                        foreign key (customer_id) references customers (id)
);

/* заполняем */
INSERT INTO customers (name, surname, age, phone_number)
VALUES ('АЛЕКСЕЙ', 'Пупкин', 20, '5284'),
       ('Иван', 'Грозный', 34, '6699888'),
       ('Алексей', 'Непомнящий', 25, '54855'),
       ('Илья', 'Муромец', 44, '5844-5987'),
       ('алексей', 'Красавец', 21, '484444-5554'),
       ('Вера', 'Иванова', 28, '458-485-444'),
       ('Петя', 'Первый', 50, '558-785'),
       ('Вальдемар', 'Новый', 99, '555-555-555'),
       ('АлексеЙ', 'Распутин', 33, '584-554');

INSERT INTO orders (customer_id, product_name, amount)
VALUES (1, 'Яблоки', 20), (1, 'Груши', 7), (1, 'Тыквы', 5),
       (2, 'Хлеб', 5), (2, 'Кроссы', 33),
       (3, 'Вода', 20), (3, 'Вата', 44), (3, 'Яблоки', 8), (3, 'Тыквы', 77),
       (4, 'Яблоки', 2), (4, 'Гвозди', 100),
       (5, 'Яблоки', 18), (5, 'Помидоры', 10), (5, 'Яблоки', 14),
       (6, 'Яблоки', 3), (6, 'Огурцы', 56),
       (7, 'Яблоки', 5), (7, 'Редис', 4),
       (8, 'Яблоки', 1),
       (9, 'Огурцы', 45);