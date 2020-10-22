CREATE TABLE books (
  id                integer         IDENTITY(1,1)   PRIMARY KEY,
  title             nvarchar(100),
  making_time       nvarchar(100),
  serves            nvarchar(100),
  ingredients       nvarchar(300),
  cost              integer,
  created_at        datetime,
  updated_at        datetime
);

