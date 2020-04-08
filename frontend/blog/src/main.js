// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'

// router
import router from './router'

// axios
import axios from 'axios'
import VueAxios from "vue-axios";

// element-ui
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

// mavon
import MavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'

// md5
import md5 from 'js-md5'

Vue.config.productionTip = false

Vue.prototype.md5 = md5

Vue.use(VueAxios, axios)
Vue.use(ElementUI)
Vue.use(MavonEditor)


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

// 页面跳转时自动到顶部
router.afterEach((to, from, next) => {
  window.scrollTo(0, 0)
});
