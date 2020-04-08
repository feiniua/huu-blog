import Vue from 'vue'
import Router from 'vue-router'
import Index from "../views/Index";
import Time from "../views/Time";
import About from "../views/About";
import Tag from "../views/Tag";
import Article from "../views/Article";
import Login from "../views/Login";
import SingleTag from "../views/SingleTag";
import Backend from "../views/Backend";
import NotFound from "../views/NotFound";

Vue.use(Router)

export default new Router({
  mode: "history",
  routes: [
    {
      path: '/',
      name: 'index',
      component: Index
    }, {
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
      name: 'v-backend'
    }, {
      path: '/**',
      component: NotFound
    }
  ]
})
