CREATE TABLE books (
  id                integer         IDENTITY(1,1)   PRIMARY KEY,
  title             nvarchar(100),
  author            nvarchar(100),
  cost              integer,
  created_at        datetime,
  updated_at        datetime
);




