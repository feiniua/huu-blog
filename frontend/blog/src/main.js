// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
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


Vue.config.productionTip = false

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
