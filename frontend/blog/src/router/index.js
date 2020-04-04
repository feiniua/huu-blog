import Vue from 'vue'
import Router from 'vue-router'
import Index from "../views/Index";
import Time from "../views/Time";
import About from "../views/About";
import Tag from "../views/Tag";
import Article from "../views/Article";

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
      component: Time
    }, {
      path: '/about',
      component: About
    }, {
      path: '/tag',
      props: true,
      component: Tag,
      name: 'v-tag'
    }, {
      path: '/article',
      props: true,
      component: Article,
      name: 'v-article'
    }
  ]
})
