
-- ################################################################################################################
-------------------------------------+
| accounts | CREATE TABLE `accounts` (                                                                                                                                       |
|          |   `usrid` int(22) NOT NULL AUTO_INCREMENT COMMENT '主键ID',                                                                                                     |
|          |   `usrname` varchar(30) NOT NULL COMMENT '账号用户名',                                                                                                          |
|          |   `region_department` int(3) NOT NULL COMMENT '部门所处地区,0-滨河,1-上天院,2-鸣皋,3-焦王,4-申坡,5-遵王,6-常海山,7-老君堂,8-鸦
岭,9-酒后,10-平等,11-夏堡,12-富留店', |
|          |   `competence` int(1) NOT NULL COMMENT '岗位类型,0:技术管理,1:审查员,2:采购经理,3:销售经理,4:仓库管理,5:普通雇员',                                              |
|          |   `active_status` int(1) DEFAULT '1' COMMENT '激活状态 0-已注销,1-已激活',                                                                                      |
|          |   `phone` char(30) NOT NULL COMMENT '电话号码,1个电话号码至多准许绑定1个账号',                                                                                  |
|          |   `reg_time` date NOT NULL COMMENT '帐号注册时间',                                                                                                              |
|          |   `modified_time` date NOT NULL COMMENT '上次更新时间',                                                                                                         |
|          |   `password` varchar(50) NOT NULL COMMENT '密码',                                                                                                               |
|          |   `salt` varchar(20) NOT NULL COMMENT '盐值',                                                                                                                   |
|          |   PRIMARY KEY (`usrid`),                                                                                                                                        |
|          |   UNIQUE KEY `usrname` (`usrname`)                                                                                                                              |
|          | ) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8                                                                                                          |
+----------+-----------------------------------------------------------------------------------------------------------------------------------------------------------------+


-- =======================================================================================================


+----------+-------------------------------------------------------------------------------------------------------------------+
| Table    | Create Table                                                                                                      |
+----------+-------------------------------------------------------------------------------------------------------------------+
| purchase | CREATE TABLE `purchase` (                                                                                         |
|          |   `purchase_id` int(13) NOT NULL AUTO_INCREMENT COMMENT '主键ID',                                                 |
|          |   `commodity` varchar(44) NOT NULL COMMENT '所购之货物',                                                          |
|          |   `is_agree` int(1) NOT NULL COMMENT '是否已获批:0-未获批,1-已获批,2-已阅被驳回',                                   |
|          |   `supplier` varchar(44) NOT NULL COMMENT '供货商',                                                               |
|          |   `quantity` int(11) NOT NULL COMMENT '所购货物之数量',                                                           |
|          |   `amount_money` float NOT NULL COMMENT '耗资金额',                                                               |
|          |   `payment_method` int(1) NOT NULL DEFAULT '0' COMMENT '支付方式:0-现金,1-网银,2-信用卡,3-其它',                  |
|          |   `is_pay` int(1) NOT NULL DEFAULT '0' COMMENT '是否已支付:0-未支付,1-已支付',                                    |
|          |   `has_take_goods` int(1) NOT NULL DEFAULT '0' COMMENT '是否已取货:0-未取货,1-已取货',                            |
|          |   `operator` varchar(44) NOT NULL COMMENT '本次采买活动之经办人',                                                 |
|          |   `purchase_time` datetime NOT NULL COMMENT '采买活动之时间',                                                     |
|          |   `classify` int(2) NOT NULL COMMENT '货品分类:0-电器,1-食品,2-服装,3-日用品,4-饮品,5-其它,6-玩具,7-家具,8-药品', |
|          |   PRIMARY KEY (`purchase_id`)                                                                                     |
|          | ) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8                                                            |
+----------+-------------------------------------------------------------------------------------------------------------------+


-- #########################################################################################################


+---------+-----------------------------------------------------------------------------------------------------------------------------
--------------------------------------+
| Table   | Create Table                                                                                                                
                                      |
+---------+-----------------------------------------------------------------------------------------------------------------------------
--------------------------------------+
| t_stock | CREATE TABLE `t_stock` (                                                                                                    
                                      |
|         |   `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',                                                          
                                      |
|         |   `purchase_id` int(13) NOT NULL COMMENT '采购申请单ID',                                                                                                          |
|         |   `store_commodity` varchar(45) NOT NULL COMMENT '存储货物之名',                                                                                                  |
|         |   `store_quantity` mediumint(9) NOT NULL COMMENT '存储数量',                                                                                                      |
|         |   `unit_price` decimal(13,2) NOT NULL COMMENT '单价',                                                                                                             |
|         |   `stock_type_area` tinyint(2) NOT NULL COMMENT '存储类型区域:0-电器区,1-食品区,2-服装区,3-日用品区,4-饮品区,5-混装区,6-家具区,7-玩具区,8-药品区,9-仓库外临时区', |
|         |   `stock_operator` varchar(30) NOT NULL COMMENT '入库经办仓管',                                                                                                   |
|         |   `enter_stock_time` timestamp NOT NULL COMMENT '入库时间',                                                                                                       |
|         |   `remark` char(70) DEFAULT NULL COMMENT '备注',                                                                                                                  |
|         |   `agree_enter_stock` tinyint(1) NOT NULL COMMENT '同意入库与否:0-否,1-可',                                                                                       |
|         |   `lastest_modified_time` timestamp NULL DEFAULT NULL COMMENT '上次修改时间',                                                                                     |
|         |   `lastest_modifier` varchar(30) DEFAULT NULL COMMENT '上次修改者',                                                                                               |                                                                  |
|         |   PRIMARY KEY (`id`),                                                                                                                                             |
|         |   UNIQUE KEY `uk_pid` (`purchase_id`)                                                                                                                             |
|         | ) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='货仓存储表'                                                         |
+---------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------+



-- iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii


+------------+--------------------------------------------------------------------------------------------------------------------+
| Table      | Create Table                                                                                                       |
+------------+--------------------------------------------------------------------------------------------------------------------+
| t_approval | CREATE TABLE `t_approval` (                                                                                        |
|            |   `id` int(25) NOT NULL AUTO_INCREMENT COMMENT '主键ID',                                                           |
|            |   `department_number` tinyint(4) NOT NULL COMMENT '来自哪个部门,0.信息技术部;1.审批部;2.采购部;3.销售部;4.仓储部', |
|            |   `approvals_time` timestamp NOT NULL COMMENT '审核处理时间',                                                      |
|            |   `reply_opinion` char(80) DEFAULT NULL COMMENT '批复意见',                                                        |
|            |   `original_order` int(22) NOT NULL COMMENT '申单原序号',                                                          |
|            |   `auditor` int(22) NOT NULL COMMENT '审核者,对应账号表usrid',                                                     |
|            |   `approve_operates` tinyint(1) NOT NULL COMMENT '审批操作:0.不同意;1.已同意',                                     |
|            |   PRIMARY KEY (`id`)                                                                                               |
|            | ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='申请单审核处理表'                      |
+------------+--------------------------------------------------------------------------------------------------------------------+



-- #####################################################################################33
+--------+------------------------------------------------------------------------------------------------------------------------------
---------------------------------------+
| Table  | Create Table                                                                                                                 
                                       |
+--------+------------------------------------------------------------------------------------------------------------------------------
---------------------------------------+
| t_sale | CREATE TABLE `t_sale` (                                                                                                      |                                     
|        |   `id` int(22) NOT NULL AUTO_INCREMENT COMMENT '主键',                                                                                                              |
|        |   `commodity` varchar(45) NOT NULL COMMENT '售出货物之名',                                                                                                          |
|        |   `customer` varchar(45) NOT NULL COMMENT '客户名',                                                                                                                 |
|        |   `amount_money` float NOT NULL COMMENT '耗资金额',                                                                                                                 |
|        |   `amount_paid` decimal(13,2) NOT NULL COMMENT '已付款金额',                                                                                                        |
|        |   `payment_method` int(1) NOT NULL COMMENT '支付方式:0-现金,1-网银,2-信用卡,3-其它',                                                                                |
|        |   `is_pay` int(1) NOT NULL COMMENT '客户是否已付款(0未,1已付定金,2多于定金少于全款,3已全款付完)',                                                                   |
|        |   `quantity` int(11) NOT NULL COMMENT '客户货物之数量',                                                                                                             |
|        |   `sale_operator` int(22) NOT NULL COMMENT '销售经办人(普通雇员或销售经理),对应账号表usrid' ,                                                                                         |
|        |   `region_department` int(3) NOT NULL COMMENT '部门所处地区:0-滨河,1-上天院,2-鸣皋,3-焦王,4-申坡,5-遵王,6-常海山,7-老君堂,8-
鸦岭,9-酒后,10-平等,11-夏堡,12-富留店', 																									|
|        |   `sale_time` timestamp NOT NULL COMMENT '销售时间',                                                                                                                |
|        |   `is_enough_stock` smallint(1) NOT NULL COMMENT '是否有足够存货(0-无,1-少量,2-半数左右,3-勉强供应,4-完全满足)',                                                    |
|        |   PRIMARY KEY (`id`)                                                                                                                                                |
|        | ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='销售记录表'                                                                             |
+--------+---------------------------------------------------------------------------------------------------------------------------------------------------------------------+




-- ---------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------------------------
---------------+
| Table            | Create Table                                                                         
+------------------+--------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------
---------------+
| t_stock_maintain | CREATE TABLE `t_stock_maintain` (                                                    |
|                  |   `id` int(22) NOT NULL AUTO_INCREMENT COMMENT '主键',            |
|                  |   `lastest_modified_time` timestamp NOT NULL COMMENT '上次修改时间',					|
|                  |   `lastest_modifier` int(22) NOT NULL COMMENT '上次修改者,对应账号表usrid',                                                                                                                                     |
|                  |   `modify_type` smallint(1) NOT NULL COMMENT '修改类型(0:修改单装区内某一批次货物的存储信息,1:货品之间数量抽调,2:组装混合种类货品单元)',      |                                                                                                                                                                |
|                  |   `modify_info` varchar(150) NOT NULL COMMENT '变动信息,例如:17s(17批次自行修改设定,s:self),22a36(第22批次添加到第36批次,a:add to),w15&17&51p10&43&45i3(抽调第15/17/51批次的全部货物,再抽调第10/43/45批次的部分货物,整合组建为新存储混装单元3;w:whole,p:partial,i:integrated)', |
|                  |   PRIMARY KEY (`id`)                                                                                                                                                                      |
|                  | ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='货仓维护记录表'                                                                                                                                                                                                                         |
+------------------+--------------------------------------------------------------------------------------------------------------------:





