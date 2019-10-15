-- drop database if exists purchase_sale_stock;

-- create database purchase_sale_stock;

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

-- ======================================================

-- 修改
 update purchase set is_agree=1,has_take_goods=1  where purchase_id<10;    

alter table accounts change reg_time reg_time date not null;

alter table accounts add password varchar(50) not null;

alter table accounts add salt varchar(20) not null;

alter table accounts ADD COLUMN modified_time date NOT NULL COMMENT '上次更新时间' AFTER reg_time;

alter table accounts modify COLUMN competence int(2) comment '权限,0系统后台管理,1主管,2采购经理,3销售经理';

show full COLUMNs FROM accounts;

alter table accounts change region_department region_department int(5) not null COMMENT '所属区域部门,如11为常川物流部';

-- 修改注释
ALTER TABLE accounts CHANGE region_department region_department int(3) NOT NULL
COMMENT '地区部门,0-滨河,1-上天院,2-鸣皋,3-焦王,4-申坡,5-遵王,6-常海山,7-老君堂,8-鸦岭,9-酒后,10-平等,11-夏堡,12-富留店';

-- 修改注释
ALTER TABLE purchase CHANGE is_enter_store is_enter_store int(1) NOT NULL DEFAULT '0'
COMMENT '是否已取货:0-未取货,1-已取货';

-- 修改注释
ALTER TABLE accounts CHANGE competence competence int(1) NOT NULL COMMENT '岗位类型,0:系统管理,1:总经理,2:采购经理,3:销售经理,4:仓库管理,5:普通雇员';

-- 修改字段名
ALTER TABLE purchase CHANGE is_enter_store has_take_goods int(1) NOT NULL DEFAULT '0'
COMMENT '是否已取货:0-未取货,1-已取货';

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

-- -- -- -- -- -- 
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

-- 
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

--  -----------------------------------------------
SELECT usrid,usrname FROM accounts;

SELECT usrid,usrname,competence,active_status FROM accounts;

UPDATE accounts SET active_status=0 WHERE usrid IN(17,18,19);

SELECT salt FROM accounts WHERE usrid IN(16,17,18);

SELECT usrid,usrname FROM accounts ORDER BY usrid ASC;

SELECT usrname,password FROM accounts WHERE usrid=7;


--  按地区部门搜索
SELECT usrid,usrname,region_department,phone,competence,active_status,reg_time,modified_time FROM accounts WHERE region_department='111';

SELECT region_department FROM accounts ORDER BY region_department ASC;

--  按职权搜索
SELECT usrid,usrname,region_department,phone,competence,active_status,reg_time,modified_time FROM accounts WHERE competence='1';

--  按已激活/已注销
SELECT usrid,usrname,region_department,phone,competence,active_status,reg_time,modified_time FROM accounts WHERE active_status='1';

--  按名模糊查询
SELECT usrid,usrname,region_department,phone,competence,active_status,reg_time,modified_time FROM accounts WHERE usrname LIKE '%r%';

SELECT usrid,usrname,region_department,phone,competence,active_status,DATE_FORMAT(reg_time,'%Y年%m月%d日'),modified_time FROM accounts WHERE usrname LIKE '%r%';

--  修改字段注释
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

ALTER TABLE accounts MODIFY COLUMN `phone` char(30) NOT NULL COMMENT 
'电话号码,1个电话号码至多准许绑定1个账号';

select * from purchase where operator ='user333';

-- update
update purchase set
commodity='铁马秋风',supplier='大山芽',quantity='60',amount_money='100.22',
payment_method='3',is_enter_store='1',purchase_time='2011-12-18 00:15:25' where purchase_id=3;

-- 新增1列
alter table purchase add classify int(2) not null comment 
'货品分类:0-电器,1-食品,2-服装,3-日用品,4-饮品,5-其它';

-- 创表
CREATE TABLE `t_stock`(
  id BIGINT(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  purchase_id INT(13) NOT NULL COMMENT '采购申请单ID',
  store_commodity varchar(45) NOT NULL COMMENT '存储货物之名',
  store_quantity MEDIUMINT NOT NULL comment '存储数量',
  unit_price DECIMAL NOT NULL comment '单价',
  stock_type_area TINYINT(2) NOT NULL comment '存储类型区域:0-电器区,1-食品区,2-服装区,3-日用品区,4-饮品区,5-混装区',
  stock_operator VARCHAR(30) NOT NULL comment '入库经办仓管',
  enter_stock_time TIMESTAMP NOT NULL comment '入库时间',
  remark CHAR(70) DEFAULT NULL comment '备注',
  agree_enter_stock TINYINT(1) comment '同意入库与否:0-否,1-可',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_pid` (`purchase_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '货仓存储表';

-- 已取已批
select purchase_id from purchase where has_take_goods=1 and is_agree=1;  
+-------------+
| purchase_id |
+-------------+
| 11          |
| 12          |
| 13          |
| 14          |
| 15          |
| 16          |
| 17          |
| 18          |
| 19          |
+-------------+

-- 从上面结果集合中获得
purchase_sale_stock> select purchase_id pid from t_stock;
+-----+
| pid |
+-----+
| 11  |
| 12  |
| 13  |
| 14  |
| 17  |
| 19  |
+-----+


--ts集合可以说属于全集p,查找ts集合的补集(属于p,且不属于ts)
--差集操作
select purchase_id from purchase where purchase.purchase_id not in(select purchase_id from t_stock);

--差集操作改进
select purchase_id purchaseId from purchase where purchase.purchase_id not in
(select purchase_id from t_stock) and purchase.has_take_goods=1 and purchase.is_agree=1;

select * from purchase where purchase.purchase_id not in(select purchase_id from t_stock) 
and purchase.has_take_goods=1 and purchase.is_agree=1;

-- 更新
update purchase set is_agree=1,has_take_goods=1 where purchase_id>20 && purchase_id<30;  

-- 修改采进表注释
ALTER TABLE purchase MODIFY `classify` int(2) NOT NULL COMMENT '货品分类:0-电器,1-食品,2-服装,3-日用品,4-饮品,5-其它,6-玩具,7-家具,8-药品';

-- 修改字段注释
ALTER TABLE t_stock MODIFY `stock_type_area` tinyint(2) NOT NULL COMMENT 
'存储类型区域:0-电器区,1-食品区,2-服装区,3-日用品区,4-饮品区,5-混装区,6-家具区,7-玩具区,8-药品区';

ALTER TABLE t_stock MODIFY `stock_type_area` tinyint(2) NOT NULL COMMENT 
'存储类型区域:0-电器区,1-食品区,2-服装区,3-日用品区,4-饮品区,5-混装区,6-家具区,7-玩具区,8-药品区,9-仓库外临时区';


