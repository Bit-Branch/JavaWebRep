INSERT INTO chumak_p_g.category (id, Name, ParentID) VALUES (1, 'Автомобили', null);
INSERT INTO chumak_p_g.category (id, Name, ParentID) VALUES (2, 'Спецтехника', null);
INSERT INTO chumak_p_g.category (id, Name, ParentID) VALUES (3, 'Недвижимость', null);
INSERT INTO chumak_p_g.category (id, Name, ParentID) VALUES (4, 'Мототехника', null);
INSERT INTO chumak_p_g.category (id, Name, ParentID) VALUES (5, 'Грузовая техника', null);
INSERT INTO chumak_p_g.category (id, Name, ParentID) VALUES (6, 'Грузовые авто', 5);
INSERT INTO chumak_p_g.category (id, Name, ParentID) VALUES (7, 'Фуры и тягачи', 5);
INSERT INTO chumak_p_g.category (id, Name, ParentID) VALUES (8, 'Прицепы', 5);
INSERT INTO chumak_p_g.category (id, Name, ParentID) VALUES (9, 'Бульдозеры', 2);
INSERT INTO chumak_p_g.category (id, Name, ParentID) VALUES (10, 'Мусоровозы', 2);
INSERT INTO chumak_p_g.category (id, Name, ParentID) VALUES (11, 'Погрузчики', 2);
INSERT INTO chumak_p_g.category (id, Name, ParentID) VALUES (12, 'Дома', 3);
INSERT INTO chumak_p_g.category (id, Name, ParentID) VALUES (13, 'Квартиры', 3);
INSERT INTO chumak_p_g.category (id, Name, ParentID) VALUES (14, 'Гаражи', 3);
INSERT INTO chumak_p_g.category (id, Name, ParentID) VALUES (15, 'Офисы', 3);
INSERT INTO chumak_p_g.category (id, Name, ParentID) VALUES (16, 'Земельные участки', 3);

INSERT INTO chumak_p_g.item (id, Name, initial_price, current_price, auction_start, auction_end, auction_ended, auction_in_progress, Description, SellerID, CategoryID) VALUES (1, 'Mercedes-benz', 4000, 4000, '2020-04-12 01:30:44', '2020-04-18 01:30:57', false, false, 'В отличном состоянии
Пробег 200000 км', 1, 1);
INSERT INTO chumak_p_g.item (id, Name, initial_price, current_price, auction_start, auction_end, auction_ended, auction_in_progress, Description, SellerID, CategoryID) VALUES (2, 'La villa', 50000, 50000, '2020-04-17 01:37:17', '2020-04-22 01:37:21', false, false, 'Вилла в Лос-Анджелесе', 1, 12);
INSERT INTO chumak_p_g.item (id, Name, initial_price, current_price, auction_start, auction_end, auction_ended, auction_in_progress, Description, SellerID, CategoryID) VALUES (3, 'Рэйлган', 2000, 2000, '2020-04-15 01:38:30', '2020-04-19 01:38:32', false, false, 'Увезет даже твои проблемы', 1, 11);

INSERT INTO chumak_p_g.image (id, Name, ImageURL, ItemID) VALUES (1, 'Mercedes-benz', '/static/resources/images/home/product1.jpg', 1);
INSERT INTO chumak_p_g.image (id, Name, ImageURL, ItemID) VALUES (2, 'La villa', '/static/resources/images/home/product2.jpg', 2);
INSERT INTO chumak_p_g.image (id, Name, ImageURL, ItemID) VALUES (3, 'Рэйлган', '/static/resources/images/home/product3.jpg', 3);