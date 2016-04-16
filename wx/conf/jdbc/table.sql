-- 微信订单表 
-- DROP TABLE dbo.WX_ORDER
-- state0-未处理1-处理
CREATE TABLE dbo.WX_ORDER (
       id int primary key identity(1,1),
       name varchar(20) not null,
       tel varchar(20) not null,
       siteid varchar(1),
       addr varchar(200),
       note varchar(400),
       state int default 0,
       createdate DATETIME,
       modifydate DATETIME
)

-- 站点表
CREATE TABLE dbo.SYS_SITES (
       id int,
       name varchar(64)
)