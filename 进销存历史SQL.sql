mysql -uroot -proot

USE purchase_sale_stock;

CREATE TABLE `accounts` (
  `usrid` int(22) NOT NULL AUTO_INCREMENT,
  `usrname` varchar(30) NOT NULL,
  `region_department` int(4) NOT NULL COMMENT '地方区域部门,如0-15为常川分部,16-21为滨河分部',
  `competence` int(1) DEFAULT NULL COMMENT '岗位对应之权限,0:管理员,1:总经理,2:采购经理,3:销售经理,4:仓库主管,5普通雇员',
  `active_status` int(1) DEFAULT '1' COMMENT '激活状态 0-Sleep,1-Awake',
  `phone` char(30) NOT NULL COMMENT '1个号码至多只准关联3个账号',
  `reg_time` date NOT NULL,
  `modified_time` date NOT NULL COMMENT '上次更新时间',
  `password` varchar(50) NOT NULL,
  `salt` varchar(20) NOT NULL,
  PRIMARY KEY (`usrid`),
  UNIQUE KEY `usrname` (`usrname`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;  

SELECT * FROM accounts;

DESC accounts;

drop database if exists purchase_sale_stock;

create database purchase_sale_stock;

####
alter table accounts change reg_time reg_time date not null;

alter table accounts add password varchar(50) not null;

alter table accounts add salt varchar(20) not null;

alter table accounts ADD COLUMN modified_time date NOT NULL COMMENT '上次更新时间' AFTER reg_time;

alter table accounts modify COLUMN competence int(2) comment '权限,0系统后台管理,1主管,2采购经理,3销售经理';

show full COLUMNs FROM accounts;

alter table accounts change region_department region_department int(5) not null COMMENT '所属区域部门,如11为常川物流部';

select count(usrid) from accounts where phone='181524007';

alter table accounts modify COLUMN competence int(1) comment '权限,0技术运维,1总经理,2采购经理,3销售经理,4仓库主管,5普通雇员';

update accounts set competence=1 where usrid in (4,9);
 
alter table accounts change competence competence int(2) not null;

SELECT usrname,competence FROM accounts;

SHOW CREATE TABLE accounts;
 
CREATE TABLE `accounts` (
  `usrid` int(22) NOT NULL AUTO_INCREMENT,
  `usrname` varchar(30) NOT NULL,
  `region_department` int(5) NOT NULL COMMENT '所属区域部门,如11为常川物流部',
  `competence` int(2) NOT NULL,
  `active_status` int(2) NOT NULL DEFAULT '1' COMMENT '激活状态 0:sleep,1:awake',
  `phone` char(30) NOT NULL COMMENT '1个号码至多只准关联3个账号',
  `reg_time` date NOT NULL,
  `modified_time` date NOT NULL COMMENT '上次更新时间',
  `password` varchar(50) NOT NULL,
  `salt` varchar(20) NOT NULL,
  PRIMARY KEY (`usrid`),
  UNIQUE KEY `usrname` (`usrname`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8  

ALTER TABLE accounts MODIFY COLUMN competence int(1) COMMENT '权限,0技术运维,1总经理,2采购经理,3销售经理,4仓库主管,5普通雇员';

######
CREATE TABLE `accounts` (
  `usrid` int(22) NOT NULL AUTO_INCREMENT,
  `usrname` varchar(30) NOT NULL,
  `region_department` int(5) NOT NULL COMMENT '所属区域部门,如11为常川物流部',
  `competence` int(1) DEFAULT NULL COMMENT '权限,0技术运维,1总经理,2采购经理,3销售经理,4仓库主管,5普通雇员',
  `active_status` int(2) NOT NULL DEFAULT '1' COMMENT '激活状态 0:sleep,1:awake',
  `phone` char(30) NOT NULL COMMENT '1个号码至多只准关联3个账号',
  `reg_time` date NOT NULL,
  `modified_time` date NOT NULL COMMENT '上次更新时间',
  `password` varchar(50) NOT NULL,
  `salt` varchar(20) NOT NULL,
  PRIMARY KEY (`usrid`),
  UNIQUE KEY `usrname` (`usrname`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8

ALTER TABLE accounts MODIFY COLUMN active_status int(1) DEFAULT '1' COMMENT '激活状态 0-Sleep,1-Awake';

#
CREATE TABLE `accounts` (
  `usrid` int(22) NOT NULL AUTO_INCREMENT,
  `usrname` varchar(30) NOT NULL,
  `region_department` int(5) NOT NULL COMMENT '所属区域部门,如11为常川物流部',
  `competence` int(1) DEFAULT NULL COMMENT '权限,0技术运维,1总经理,2采购经理,3销售经理,4仓库主管,5普通雇员',
  `active_status` int(1) DEFAULT '1' COMMENT '激活状态 0-Sleep,1-Awake',
  `phone` char(30) NOT NULL COMMENT '1个号码至多只准关联3个账号',
  `reg_time` date NOT NULL,
  `modified_time` date NOT NULL COMMENT '上次更新时间',
  `password` varchar(50) NOT NULL,
  `salt` varchar(20) NOT NULL,
  PRIMARY KEY (`usrid`),
  UNIQUE KEY `usrname` (`usrname`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

# -----------------------------------------------
SELECT usrid,usrname FROM accounts;

SELECT usrid,usrname,competence,active_status FROM accounts;

UPDATE accounts SET active_status=0 WHERE usrid IN(17,18,19);

SELECT salt FROM accounts WHERE usrid IN(16,17,18);

SELECT usrid,usrname FROM accounts ORDER BY usrid ASC;

SELECT usrname,password FROM accounts WHERE usrid=7;


# 按地区部门搜索
SELECT usrid,usrname,region_department,phone,competence,active_status,reg_time,modified_time FROM accounts WHERE region_department='111';

SELECT region_department FROM accounts ORDER BY region_department ASC;

# 按职权搜索
SELECT usrid,usrname,region_department,phone,competence,active_status,reg_time,modified_time FROM accounts WHERE competence='1';

# 按已激活/已注销
SELECT usrid,usrname,region_department,phone,competence,active_status,reg_time,modified_time FROM accounts WHERE active_status='1';

# 按名模糊查询
SELECT usrid,usrname,region_department,phone,competence,active_status,reg_time,modified_time FROM accounts WHERE usrname LIKE '%r%';

SELECT usrid,usrname,region_department,phone,competence,active_status,DATE_FORMAT(reg_time,'%Y年%m月%d日'),modified_time FROM accounts WHERE usrname LIKE '%r%';

# 修改字段注释
ALTER TABLE accounts MODIFY COLUMN `region_department` int(4) NOT NULL COMMENT '地方区域部门,如0-15为常川分部,16-21为滨河分部';

ALTER TABLE accounts MODIFY COLUMN `competence` int(1) DEFAULT NULL COMMENT '岗位对应之权限,0:管理员,1:总经理,2:采购经理,3:销售经理,4:仓库主管,5普通雇员';

SHOW CREATE TABLE accounts;

-- -------------------------------------------------------------------------------------

insert into purchase (commodity, is_agree, 
      supplier, quantity, amount_money, 
      payment_method, is_pay, is_enter_store, 
      operator, purchase_time)
values ('单例设计模式',
    	1,
    	'java',
    	'120',
    	'100',
    	0,
    	1,
    	1,
    	'admin',
    	'2011-11-11 11:50:02');
    	
-- 修改列注释
ALTER TABLE accounts MODIFY COLUMN `active_status` int(1) DEFAULT '1' COMMENT '激活状态 0-已注销,1-已激活';

ALTER TABLE accounts MODIFY COLUMN `reg_time` date NOT NULL COMMENT '帐号注册时间';

ALTER TABLE accounts MODIFY COLUMN `password` varchar(50) NOT NULL COMMENT '密码';                                                                                        
ALTER TABLE accounts MODIFY COLUMN `salt` varchar(20) NOT NULL COMMENT '盐值';

ALTER TABLE accounts MODIFY COLUMN `phone` char(30) NOT NULL COMMENT '电话号码,1个电话号码至多准许绑定1个账号';

select * from purchase where operator ='user333';