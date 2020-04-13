# huu-blog
个人博客，采用vue + springboot前后端分离实现，springboot只提供数据接口。

***[TOC]***
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

#### 首页
![image](https://github.com/feiniua/huu-blog/blob/master/md_image/home1.png)

![image](https://github.com/feiniua/huu-blog/blob/master/md_image/home2..png)

#### 文章页

![image](https://github.com/feiniua/huu-blog/blob/master/md_image/article.png)

#### 标签页
![image](https://github.com/feiniua/huu-blog/blob/master/md_image/tag.png)
![image](https://github.com/feiniua/huu-blog/blob/master/md_image/singletag.png)

#### 归档页
![image](https://github.com/feiniua/huu-blog/blob/master/md_image/time.png)

## 后端


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