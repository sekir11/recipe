SET IDENTITY_INSERT books ON
INSERT INTO books (id, title, making_time, serves, ingredients, cost, created_at, updated_at) VALUES (1, N'チキンカレー', N'45分', N'4人', N'玉ねぎ,肉,スパイス', 1000, '2016-01-10 12:10:12', '2016-01-10 12:10:12');
INSERT INTO books (id, title, making_time, serves, ingredients, cost, created_at, updated_at) VALUES (2, N'オムライス', N'30分', N'2人', N'玉ねぎ,卵,スパイス,醤油', 700, '2016-01-11 13:10:12', '2016-01-11 13:10:12');
SET IDENTITY_INSERT books OFF