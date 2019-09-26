
MD5摘要混合随机盐值密码加密算法

###### 1个简单的密码加密算法,以下为大体加密步骤:
0.编写extra(),该方法可生成返回一个随机盐值.
1.编写生成MD5摘要之方法:
aDigest(String str),参数为1个String,返回1个32位hex字符串.该方法需导入1个jar包:commons-codec-1.10.jar.
<br>
2.编写密码生成之方法generate(String pwd,String salt),在generate()方法中,获得aDigest(salt+pwd)返回之字符串hexs,新建一个48位char数组cs,通过for循环,分别截取hexs和salt自定义规律位置之单字符,然后纷纷赋予cs,将cs转为字符串os,os即为最终密码原文.
<br>

###### 解密
0.编写方法check(String pass,String origin)
<br>
1.check()内,分别新建digestChar字符数组[32]和saltChar字符数组[16]<br>
2.用for循环,按照之前自定义之位置规律,从origin逆向截取单个字符,赋予digestChar[]和saltChar[],
3.将saltChar[]转为字符串salt<br>
4.最后利用aDigest(salt+pass)返还的hexString,与new String(digestChar)相比较即可.
<br>
-----------------------------

http://localhost:8080/stocker-manager/  #项目起始
-----------------------------

web.xml中,<servlet>下<param-value>节点最好全部扫描全部spring配置xml文件(即classpath:spring*.xml),因若只扫描单个xml文件,该xml文件中必要配置之标签可能不完整,为解决配置元素标签分散未全之虞,故应全面一并扫描.
-----------------------------


数据表int类型字段对应之实体类成员,为了便利,当设为Integer,因为Integer类型setter和getter可代入null,而int类型不可以.
-----------------------------

报错405: Method Not Allowed之时,可检查spring-*.xml中的拦截器设置,或修改页面请求链接,或检查@RequestMapping(value = "yyy", method = {RequestMethod.????})
-----------------------------


for循环过多的JavaScript网页代码,极有可能会使浏览器卡住,无法F12,甚至系统卡机.
-----------------------------

点击事件函数不可写在外部JavaScript脚本内.
-----------------------------

项目pom.xml中原本为war强行修改为jar,之后再希图将项目打包为jar,极有可能会使项目可以正常启动,但访问前端页面报404.
-----------------------------

导入mybatis框架依赖时,mybatis和mybatis-spring二者是不同的依赖,缺少mybatis-spring可能会导致"未寻获类"异常.
-----------------------------

JSP内,${pageContext.request.contextPath}为当前页面环境下请求发出时的背景路径(不含http://localhost:8080/),考虑到链接跳转时前置路径的静止特性,有可能会报404,此时可于链接前缀加上${pageContext.request.contextPath}/控制器路径,即可找到指定目标控制器.
-----------------------------
intellij idea:maven项目创建后,SRC>main目录下无java与resources目录,
可如下循序:
file->project structure->modules->sources,<br>
在main目录右键new folder+,创建java目录,又在其右键选择目录属性'Sources';<br>
接着main目录下又创建resources,右键于其目录属性'Resources'.<br>

若src下无test目录,搬上即创,目录下建 java 和 resources 二目录,<br>
java目录右键属性'sources',而resources目录右键属性'test resources'.
----------------------------- 

springDAO.xml文件出现错误:

URI is not registered (settings | language & frameworks | schemas and DTDs)

resolve:
file-->settings...-->
languages & frameworks --> 
Schemas and DTDs --> 
Ignored Schemas and DTDs --> +

然后将报错的地址复制到 "URI:" 对话框中.
-----------------------------

Maven启动tomcat报错：
Error Running：..../home/gzh/.IntelliJIdea2019.1/system/tomcat/Tomcat_9_0_20_stock-manage/conf: Directory is invalid /opt/tomcat9/conf/Catalina
<br>
原因：Linux系统下，tomcat所处文件夹访问权限不足，无法复制文件到项目中。
<br>
解：赶往tomcat所在文件夹，对其文件夹授权：sudo chmod -R 777 tomcat9
-----------------------------

intellij idea启动tomcat成功，但浏览器进入 http://localhost:8080/ 报404
<br>
resolve：
选择菜单栏“Run-->Edit Configuration-->Tomcat Server-->tomcat9-->Deployment”,<br>选择右上角绿色“+”，选择“External Source...”，<br>将Apache-tomcat的webapps目录下的ROOT文件夹选中，点击OK，及完成Tomcat的首页的工程的部署。<br>选择ROOT文件后右侧 Application Context 可不填写，默认即可。
-----------------------------

上传工程至github:
<br>
git push -u origin master
<br>
报错:<br>
To git+ssh://github.com/AllStarGH/stock-manage.git<br>
! [rejected]        master -> master (non-fast-forward)<br>
error: 无法推送一些引用到 'git+ssh://git@github.com/AllStarGH/stock-manage.git'<br>
提示：更新被拒绝，因为您当前分支的最新提交落后于其对应的远程分支。<br>
提示：再次推送前，先与远程变更合并（如 'git pull ...'）。详见<br>
提示：'git push --help' 中的 'Note about fast-forwards' 小节。<br>

resolve:<br>
git push -u origin +master
-----------------------------

intelligentJava idea javaweb项目导入外部jar包报错:ClassNotFoundException<br>

0.打开Project Structure.<br>
1.左侧选中Modules，在Dependecies中，点击右侧“+”号，选择JARS or directories...<br>
2.选择WEB-INF\lib下的Jar包添加<br>
3.左侧选中Artifacts，然后点击-项目名:war exploded ，在Avaliable Elements中将刚刚添加的JAR包put into /WEB-LIF/lib<br>
-----------------------------

重定向至WEB-INF之下的文件报错404,<br>不可直接' retrun "redirect:xxx.jsp" ',<br>因WEB-INF之下的文件无法通过客户端之间互相访问(考虑到重定向的本质),只许转发,因此须' return "xxx.jsp" '.

今更正:WEN-INF下可以'return "redirect:xxx.jsp"',前提是于spring-server.xml中的白名单添加xxx
-----------------------------

-jsp引入外部脚本、样式文件报404，<br>原先是<script src="/jquery/jquery-3.2.1.min.js"></script>，<br>后来在jsp中的src路径前添加${pageContext.request.contextPath}，<br>变为
<script src="${pageContext.request.contextPath}/jquery/jquery-3.2.1.min.js"></script>，
方得解决。
```````
-----------------------------
+或者亦可如下:
先:<br>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
再:<br>
<script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>
-----------------------------
```````

每次发送请求,上一次请求的路径依旧残留在URL后尾,频报400;<br>
resolve:尽量使用JavaScript脚本负责前后数据往返,使前后端解耦相持.<br>
-----------------------------

-叙:明明前后两端均是确定POST请求方法,但于前端提交时却莫名变成GET方法,数据直接在地址栏中显现而出.<br>
-由:表单中"提交"之input标签中type属性仍旧为submit,致使其依旧执行机能,而表单默认请求方式为GET,使ajax中的type:'POST'无效.<br>
-举:将submit改为button.<br>
-----------------------------

-叙:服务层抛出之自定义异常无法通过json实体返回给前台页面,且触发后台异常时(throw e)前台报404.<br>

-由:没有把返回之自定义异常给写入到HTTP response body中,由于异常封装代码位于控制层工具集类(相当于控制层基类)中,仅仅是捕获全局异常(@ControllerAdvice),使返还结果为空,前台不知所措.<br>

-举:在控制层工具集类头上加@RestControllerAdvice代替@ControllerAdvice,或在异常统一处理方法前补加@ResponseBody.<br>
-----------------------------
-叙:eclipse导入maven依赖包过慢<br>
-由:因为maven依赖包仓库位于国外<br>
-举:<br>
在.m2目录下的settings.xml中的<mirrors>标签内加入如下内容,便可从阿里云私服下载依赖:

<mirror>
       <id>alimaven</id>
       <mirrorOf>central</mirrorOf>
       <name>aliyun maven</name>
       <url>http://maven.aliyun.com/nexus/content/repositories/central/</url>
</mirror>

-ps: 若.m2目录下无settings.xml,可从本地Apache Maven/conf目录复制一份到.m2
--------------------------

获取input文本框中所输入的文本,不可用text(),得用val()或value
--------------------------

后台时间类型参数返回前台视图,显示的却是13位数字,而非正常的时间格式.
<br>

解决:在BO实体类时间类型成员之getter方法上加上注解@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
----------------------------------------------------

click只能为页面现有的元素绑定点击事件,对于动态生成之元素,是不会起效的.



----------------------------------