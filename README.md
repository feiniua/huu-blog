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


## 遇到问题

* vue 整合axios后如何发送ajax请求
* 每篇文章图片背景如何保存
* 新建文章如何在内容中添加图片
* 分页的处理
* 后端权限shiro
* vue 如何登陆后跳转并传参