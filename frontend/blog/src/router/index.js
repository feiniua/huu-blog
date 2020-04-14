import Vue from 'vue'
import Router from 'vue-router'
import Index from "../views/Index";
import Time from "../views/Time";
import About from "../views/About";
import Tag from "../views/Tag";
import Article from "../views/Article";
import Login from "../views/Login";
import SingleTag from "../views/SingleTag";
import Backend from "../views/backend/Backend";
import NotFound from "../views/NotFound";
import EditArticle from "../views/backend/EditArticle";
import BackendArticle from "../views/backend/BackendArticle";
import BackendTag from "../views/backend/BackendTag";
import BackendUser from "../views/backend/BackendUser";
import CreateArticle from "../views/backend/CreateArticle";
import Star from "../components/Star";

Vue.use(Router)

export default new Router({
  mode: "history",
  routes: [
    {
      path: '/',
      name: 'index',
      component: Index
    },
    {
      path: '/time',
      component: Time,
      name: 'v-time'
    }, {
      path: '/about',
      component: About
    }, {
      path: '/tag',
      component: Tag,
      name: 'v-tag'
    }, {
      path: '/tag/:tagName',
      component: SingleTag,
      name: 'v-singleTag',
      props: true
    }, {
      // 需要传送信息时需要打开 props
      path: '/article/:id',
      props: true,
      component: Article,
      name: 'v-article'
    }, {
      path: '/login',
      component: Login
    }, {
      props: true,
      path: '/backend',
      component: Backend,
      meta: {
        requireAuth: true
      },
      name: 'v-backend',
      children: [
        {
          path: '/backend/article',
          component: BackendArticle,
          name: 'vb-article'
        },
        {
          path: '/backend/tag',
          component: BackendTag,
          name: 'vb-tag'
        },
        {
          path: '/backend/user',
          component: BackendUser,
          name: 'vb-user'
        },
        {
          path: '/backend/article/create',
          component: CreateArticle,
          name: 'vb-createArticle'
        },
        {
          path: '/backend/article/:id',
          component: EditArticle,
          name: 'vb-editArticle'
        }
      ]
    }, {
      path: '/**',
      component: NotFound
    }
  ],
  // beforeEach:
  //   //  判断是否需要登录权限 以及是否登录
  //   this.beforeEach((to, from, next) => {
  //     if (to.matched.some(res => res.meta.require)) {// 判断是否需要登录权限
  //       if (localStorage.getItem('username')) {// 判断是否登录
  //         next()  //有登录名称进行下一步路由
  //       } else {// 没登录则跳转到登录界面
  //         next({
  //           path: '/login',
  //         })
  //       }
  //     } else {
  //       next()
  //     }
  //   })

})
