# stocker-manager
进销存系统


- 生产环境:Ubuntu 18.04 LTS

- 开发工具:eclipse+sublime text+vs code

- 项目构建工具:Maven

- 数据库:MySQL 8.0

- 项目运行服务器:Tomcat 9.0

- 客户端调试平台:火狐浏览器+谷歌浏览器

>>>

设计模式:MVC

项目整体框架:SSM,其中细分为:

+ IOC(Inversion of Control)容器:Spring

+ Web框架:SpringMVC

+ ORM(Object Relational Mapping)框架:Mybatis

前端css框架:Bootstrap

>>>

应用语言
- 后端:java+SQL
- 前端:HTML+css,JavaScript+jQuery,jstl+jsp EL

+ 2019-07-22,完成账管模块.

已实现功能如下:
* 登录,注册(只由管理员执行)
* 修改账户的名字/电话/地区部门/岗位(仅经管理员负责)
* 单个删除账户(仅经管理员负责)
* 查看所有账户的资料信息(ID/用户名/地区部门/岗位/电话/激活状态/注册日期/上次改动日期)
* 批量/单个地对账户们进行注销/激活/重置密码
* 搜索,按地区部门/职位/是否注销查看符合条件之账户,亦可按用户名模糊查询
* 查看系统日志,其包括了有关账户的注册/登录/改动/删除/注销/激活/密码复位此些活动的记录.

### 09-03之更新

* 优化整合了前台部分页面,修复了系统记录账号活动无法展示之故障

- 增加自行修改密码

- 增加自行修改基本资料