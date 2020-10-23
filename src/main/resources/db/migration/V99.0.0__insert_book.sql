SET IDENTITY_INSERT books ON



INSERT INTO books (id, title, author, cost, created_at, updated_at)
VALUES (1, N'Spring 入門', N'著者1', 1000, '2016-01-10 12:10:12', '2016-01-10 12:10:12');

INSERT INTO books (id, title, author, cost, created_at, updated_at)
VALUES (2, N'Java', N'著者2', 700, '2016-01-11 13:10:12', '2016-01-11 13:10:12');







SET IDENTITY_INSERT books OFF