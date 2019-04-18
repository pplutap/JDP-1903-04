insert into 'group' (id, group_name) values (1,"Piwa");
insert into `group` (id, group_name) values (2, "Wódki");
insert into `group` (id, group_name) values (3, "Whisky");
insert into `group` (id, group_name) values (4, "Wina Biale");
insert into product (id, is_deleted,description,name,price,quantity,group_id)
 values (1, false, "Przeniczne i Orzezwiajace", "Zywiec Bialy", 3.5, 100, 1);
insert into product (id, is_deleted,description,name,price,quantity,group_id)
 values (2, false, "Piwo Ciemne Owsiane. 5 Ciemnych Slowdow", "Kormoran Ciemny", 8.0, 50, 1);
insert into product (id, is_deleted,description,name,price,quantity,group_id)
 values (3, false, "Nie ma po niej kaca", "Finlandia 0.5L", 50.0, 20, 2);
insert into product (id, is_deleted,description,name,price,quantity,group_id)
 values (4, false, "Polska Wódka", "Pan Tadeusz 0.5L", 25.0, 20, 2);
insert into product (id, is_deleted,description,name,price,quantity,group_id)
 values (5, false, "Jack Daniel's to legendarna amerykañska whiskey ", "Jack Daniel's Tennessee Whiskey 0,7l", 89.90, 20, 3);
insert into product (id, is_deleted,description,name,price,quantity,group_id)
 values (6, false, "wino bia³e wytrawnez z Chile", "Wino Yelcho Reserva Sauvignon Blanc 0,75 l", 42.50, 20, 4);
insert into cart(id) values(1);
insert into cart(id) values(2);
insert into cart(id) values(3);
insert into user(id, is_blocked, username, cart_id) values(1, false ,"Koneser Win", 1);
insert into user(id, is_blocked, username, cart_id) values(2, false ,"Alkoholik", 2);
insert into user(id, is_blocked, username, cart_id) values(3, false ,"Piwosz", 3);
insert into `order`(id, date, is_paid, user_id) values(1, current_time(), false, 1);
insert into `order`(id, date, is_paid, user_id) values(2, current_date(), false, 2);
insert into `order`(id, date, is_paid, user_id) values(3, current_date(), false, 2);
