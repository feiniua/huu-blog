# huu-blog

个人博客，采用vue + springboot前后端分离实现，springboot只提供数据接口。部署采用docker部署，打包成两个镜像，分别运行。

项目地址：<http://47.95.239.221/>
**点击页面下的邮箱进入后台登录界面。**
提供一个管理员账号admin 123456。
一个游客账号xian 123456。

PS：七牛云图床挂了，有时间的话再添加评论模块。

## 前端

### vue

**使用依赖**

* router

* axios

* element-ui

* mavon-editor

* marked

* js-md5

**项目结构**

* src
  * components/   // 自定义组件
  * config/       // 后端提供url信息
  * router/       // 路由信息
  * views/        // 页面
  * App.vue       
  * main.js
  
### Element-UI

使用相关组件

#### 首页

![image](http://feiniua.gitee.io/imagebed/img/home1.png)

![image](http://feiniua.gitee.io/imagebed/img/home2..png)

#### 文章页

![image](http://feiniua.gitee.io/imagebed/img/article.png)

#### 标签页

![image](http://feiniua.gitee.io/imagebed/img/tag.png)

![image](http://feiniua.gitee.io/imagebed/img/singletag.png)

#### 归档页
![image](http://feiniua.gitee.io/imagebed/img/time.png)

## 后端

采用Springboot。

* shiro:
	* 继承FormAuthenticationFilter拦截器，对不同请求方式进行拦截
* querydsl：
	* DAO层用来多表查询

### 建表

Article：用来记录文章信息

Tag：标签，用来对文章进行分类。

*认证*

User：用户，一个用户对应一个角色

Role：角色，一个角色对应多个权限

Permission：权限，add对应post，edit对应put，delete对应delete

## 日志

* 4.4
	* vue 整合axios后如何发送ajax请求
	* 每篇文章图片背景如何保存
* 4.5
	* 分页的处理
* 4.8
	* 后端权限shiro
* 4.11
	* vue 如何登陆后跳转并传参
	* vue使用sessionStorage保存登录后的返回信息，登录后即可跳过登录页
	* vue发送的请求不带cookie，对于后台来说就像是一个新客户端。无法获得权限。
		* 解决：main.js中添加axios.defaults.withCredentials=true;
	* 发送请求返回权限失败500使用catch
		* 解决：axios(...).then(...).catch(function(error) {...})
* 4.12
	* axios使用FormData()传送file文件
	* 新建文章时如何往内容中插入图片
	* 插入文章的图片显示出来过大未设置格式
* 4.13
	* 使用正则修改html里面的样式
	* 完成后台文章编辑页
* 4.14
	* 添加星空图
	* 后台数据发送时进行过滤
* 4.16
	* 完成后台tag页
	
## 部署

**分别在build下面的两个目录中构建镜像。**

### blogfrontend

进入目录build/blogfrontend后，执行
docker build -t blog .
构建前端镜像。

然后使用
docker run -d -p 80:80 blog
运行镜像

### blogbackend

**注意：后端连接的宿主机端口3306，mysql中需要执行相应数据库脚本后才能运行后端项目。**
**脚本文件在项目resources目录下。**

进入目录build/blogbackend后，执行
docker build -t blogend .
构建后端镜像。

然后使用
docker run -d --net host blogend
运行镜像。