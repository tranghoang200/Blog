import Vue from 'vue'
import App from './App'
import axios from 'axios'
import moment from 'moment'
import VueAxios from 'vue-axios'
import router from './router'
import Banner from './components/Banner'
import Home from './components/Home'
import About from './components/About'
import ListBlog from './components/ListBlog'
import Blog from './components/Blog'

Vue.use(VueAxios, axios)
Vue.use(moment)
Vue.use(require('vue-moment'));
Vue.component('component-banner', Banner)
Vue.component('component-home', Home)
Vue.component('component-about', About)
Vue.component('component-list-blog', ListBlog)
Vue.component('component-blog', Blog)
Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')